//TMX2Moses.java

// TMX2MOSES

// Reads a TMX-file and outputs two aligned files,
// one sentence a line.

// Machinetranslation with Moses
// http://www.statmt.org/moses/
// ====================================== 

// Version: 0.5

//      Copyright (c) 2013-2015 Per Tunedal, Stockholm, Sweden
//       Author: Per Tunedal <info@tunedal.nu>

//       This program is free software: you can redistribute it and/or modify
//       it under the terms of the GNU General Public License as published by
//       the Free Software Foundation, either version 3 of the License, or
//       (at your option) any later version.

//       This program is distributed in the hope that it will be useful,
//       but WITHOUT ANY WARRANTY; without even the implied warranty of
//       MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//       GNU General Public License for more details.

//       You should have received a copy of the GNU General Public License
//       along with this program.  If not, see <http://www.gnu.org/licenses/>.


// Notes
// =====

// v. 0.1 First version.

// v. 0.2 Internationalization

// v. 0.3 Now handles the case that some information preceds the translation 
//        at the line.

// v. 0.4 Check of input improved.

// v. 0.5 Option: process all tmx-files in a folder.

// -----------------------------------------------------------------------

// TODO:
// - log-file
// 

import java.util.*; // ArrayList, Scanner, Comparator, Random
import java.io.*; // för att skapa/öppna en fil (File)
import per.edu.*;

   
class TMX2Moses

{	
	public static void main (String[] args) throws Exception
	{
	// Internationalization
	// add language code and country code when running the program
	// -----------------------------------------------------------
	
	String language;
	String country;

	if (args.length != 2)
		{
			language = new String("en");
			country = new String("GB");
		}
		
		else
		{
			language = new String(args[0]);
			country = new String(args[1]);
		}

		Locale currentLocale;
		ResourceBundle messages;

		currentLocale = new Locale(language, country);

		messages = ResourceBundle.getBundle("MessagesBundleTMX2Moses", currentLocale);
	
	String tmxfil = "";
	boolean file=false;
	boolean directory=false;
	String allowed = "";
	String answer = "";
	
	// Kolla att filen finns.
	while (tmxfil.length()==0 || (file==false && directory==false))
		{
		Utskrift.rubrik(messages.getString("writepath"));
		Utskrift.skrivText(messages.getString("processpath"));
		System.out.println();
		tmxfil = Inmatning.rad(messages.getString("tmx"));
		file=Textfil.exists(tmxfil);
		if(file==false)
			{
				Utskrift.skrivText(messages.getString("doesntexist"));
				if(Textfil.directoryExists(tmxfil)) directory=true;
			}
			
		if (directory==true)
			{
				Utskrift.skrivText(messages.getString("directory"));
				// regex ^$ betyder tom sträng
				allowed = messages.getString("yesno"); // Tillåtna svar
				answer = Inmatning.rad(messages.getString("usedir"), allowed);	
				if (!answer.matches(messages.getString("yes"))) directory = false;
			}
		}
		
	if (directory == true)
	{
		String cat = tmxfil;
		tmxfil = ""; // counter for tmx-files
		
		// Filerna i katalogen listas
		// ==========================
		ArrayList<String> files = new ArrayList<String>();
		files = listFiles(cat);
		
		// Antal filer i katalogen
		//------------------------
		int max = files.size();
		System.out.println();
		Utskrift.skrivText(messages.getString("fileno") + " " + cat + " : " + max);
		
		//System.exit(1);
		
		String filnamn = "";
		int tmx = 0;
		String lang1 = "";
		String lang2 = "";
		//String katalog = tmxfil;
		
		String path = cat;
		
		//Utskrift.skrivText("Path: " + path);
		
		// Loop för att beta av alla filer i katalogen
		// -------------------------------------------
		for (int i=0; i < files.size(); i++)
			{
				filnamn = files.get(i);
				System.out.println();
				Utskrift.skrivText(i + ": " + filnamn);
				// Kolla att det är en TMX-fil
				//boolean checkTMX(String tmxfil)
				if (!checkTMX(filnamn))
				{
				
					Utskrift.skrivText(messages.getString("notmx"));
					continue;
				}
				
				// Writes to bitext files
				// ======================
				tmx++; // Counts tmx-files
				// Läs språkparet ur TMX-filen
				// ===========================
				String[] v = new String [2];
				String lang3 = "";
				String lang4 = "";
				
				TMXlanguages(filnamn, v);
				
				if (tmx>1)
				{
					lang3 = v[0];
					lang4 = v[1];

					if(!((lang1.equals(lang3) || lang1.equals(lang4)) && 
								(lang2.equals(lang3) || lang2.equals(lang4))))
					{
						Utskrift.rubrik (messages.getString("langpair") + lang1 + "-" + lang2, '=');
						Utskrift.skrivText(messages.getString("onemorelang"));
						Utskrift.skrivText(messages.getString("thislangpair") + " " +
							lang3 + "-" + lang4);
						Utskrift.skrivText(messages.getString("skips"));
						continue;
					}
				}
				else
				{
					lang1 = v[0];
					lang2 = v[1];
					Utskrift.skrivText(messages.getString("langpair") + " " +
							lang1 + "-" + lang2);
				}
				
				//TMX2bitext(String tmxfil, String[] v, String language, String country)
				TMX2bitext(filnamn, path, v, directory, language, country);
			}
	}
	
	else
	{
		// Kolla att det är en TMX-fil
		//boolean checkTMX(String tmxfil)
		if (!checkTMX(tmxfil))
		{
			Utskrift.skrivText(messages.getString("notmx"));
			System.exit(1);
		}
		// Writes to bitext files
		// ======================
		else
		{
			// Läs språkparet ur TMX-filen
			// ===========================
			String[] v = new String [2];
			TMXlanguages(tmxfil, v);
			
			// Läs sökvägen ur TMX-filnamn m sökväg.
			String path = Textfil.readPath(tmxfil);
			
			//Utskrift.skrivText("TMX: " + tmxfil);
			//Utskrift.skrivText("Path: " + path);
			//Utskrift.skrivText(messages.getString("langpair") + " " + v[0] + "-" + v[1]);
			//TMX2bitext(String tmxfil, String[] v, String language, String country) 
			TMX2bitext(tmxfil, path, v, directory, language, country);
		}
	}
	
	// KLART
	Utskrift.rubrik(messages.getString("finished"));
	
	}
	
	 // List all the files in a directory
	public static ArrayList<String> listFiles(String directoryName)
	{
		ArrayList<String> files = new ArrayList<String>();
		File directory = new File(directoryName);
 
		//get all the filenames from a directory
		File[] fList = directory.listFiles();
 
		for (File file : fList)
		{
			if (file.isFile())
			{
				files.add(file.getName());
			}
		}
		return files;
	}
	
	 // Check if it's a TMX-file or not
	public static boolean checkTMX(String tmxfil) throws Exception
	{
		int i=0;
		String rad = "";
		// Opens TMX-file for reading
		BufferedReader br = new BufferedReader(new InputStreamReader(new
		FileInputStream(tmxfil), "UTF-8"));

		// Reads a few lines to check the file type
		while ((rad = br.readLine()) != null && i<5)
		{
			if (rad.contains("<!DOCTYPE tmx"))
			{
				br.close(); // stänger filen
				return true;
			}
			
			i++;
		}
		
		br.close(); // stänger filen
		return false;
	}
	
	// Read a TMX-file and write to bitext files.
	public static void TMX2bitext(String tmxfil, String path, String[] v, boolean directory, String language, String country) throws Exception
	{
	
		Locale currentLocale;
		ResourceBundle messages;

		currentLocale = new Locale(language, country);

		messages = ResourceBundle.getBundle("MessagesBundleTMX2Moses", currentLocale);
		
		// Läs språkparet ur TMX-filen
		// ===========================
		//String[] v = new String [2];
		//TMXlanguages(tmxfil, v);
		
		String lang1 = v[0];
		String lang2 = v[1];
		
		// Opens TMX-file for reading
		BufferedReader br0 = new BufferedReader(new InputStreamReader(new
		FileInputStream(tmxfil), "UTF-8"));
		
		String rad = "";
		boolean segStart = true; // Raden börjar med meningen.
		
		// Läser några rader för att bestämma hur raderna med meningarna ser ut.
		// =====================================================================
		while ((rad = br0.readLine()) != null)
		{
			rad = rad.trim();
			
			//Utskrift.skrivText("Index för text på raden: " + rad.indexOf("<seg>"));
			
			// söker början på textraden
			if (rad.indexOf("<seg>") == 0)
			{
				segStart = true;
				break;
			}
			
			else if (rad.indexOf("<seg>") > 0)
			{
				segStart = false;
				break;
			}
		}
		
		br0.close(); // stänger filen
		
		//Utskrift.skrivText("Raden börjar med texten: " + segStart);
		
		Utskrift.skrivText(messages.getString("languages") + " " + lang1 + " " + messages.getString("and") + " " + lang2);
		
		// Läs sökvägen ur TMX-filnamn m sökväg.
		//String path = Textfil.readPath(tmxfil);
		
		//Utskrift.skrivText("TMX: " + tmxfil);
		//Utskrift.skrivText("Path: " + path);
		
		String filnamnet = "";
		String filstam = "";
		
		if (directory)
		{
		// The new files gets the same name as the folder
		filstam = Textfil.readFolderName(path);
		path = Textfil.readPath(path); // ..
		//Utskrift.skrivText ("path: " + path);
		//Utskrift.skrivText ("filstam: " + filstam);
		}
		
		else
		{	
		// Läs själva filnamnet på TMX-filen.
		filnamnet = Textfil.readFileName(tmxfil);
		
		// Ta bort ändelsen .tmx
		filstam = filnamnet.substring(0, filnamnet.length() - 4);
		//Utskrift.skrivText(filstam);
		}
		
		// Konstruera utfilerna.
		
		String utfil1 = path + filstam + "." + lang1;
		String utfil2 = path + filstam + "." + lang2;
		
		//Utskrift.rubrik("Resultatfiler");
		//Utskrift.skrivText(utfil1);
		//Utskrift.skrivText(utfil2);
		
		// N.B. If directory mode and output file exists, it will be appended.
		// -------------------------------------------------------------------
		if(!directory)
		{
			Textfil.skrivText(utfil1, "", "UTF-8"); // rensning
			Textfil.skrivText(utfil2, "", "UTF-8"); // rensning
		}

		
		// Opens TMX-file for reading
		BufferedReader br1 = new BufferedReader(new InputStreamReader(new
		FileInputStream(tmxfil), "UTF-8"));
		
		int chunkSize = 500; // Adds a number of lines at a time
		
		rad = "";
		String text1 = "";
		String text2 = "";
		int i = 0; // radräknare
		int j = 0; // indexering
		int u = 1; //udda
		
		// A. Översättningen på egen rad
		// =============================
		if (segStart)
		{
			// Läser in meningarna på resp. språk
			while ((rad = br1.readLine()) != null)
			{	
				rad = rad.trim();
				
				//Utskrift.skrivText("Rad " + i + ": " + rad);
				
				if (rad.startsWith("<seg>") && u == 1) // udda
				{
					j = rad.indexOf("</seg>");
					
					if(j > 0)
					{
						text1 = text1 + rad.substring(5, j) + "\n";
					
						u = 0; // jämn
						
						//Utskrift.skrivText(rad);
						//Utskrift.skrivText(text1);
					}
					
					else
					{
						text1 = text1 + rad.substring(5) + " ";

						//Utskrift.skrivText(rad);
						//Utskrift.skrivText(text1);				
					}

				}
				
				else if (rad.startsWith("<seg>") && u == 0) // jämn
				{
					j = rad.indexOf("</seg>");

					if(j > 0)
					{			
						text2 = text2 + rad.substring(5, j) + "\n";
								
						u = 1; // udda
						
						//Utskrift.skrivText(rad);
						//Utskrift.skrivText(text2);
					}
					
					else
					{
						text2 = text2 + rad.substring(5) + " ";
												
						//Utskrift.skrivText(rad);
						//Utskrift.skrivText(text2);
					}
				}
			
				if ((i%chunkSize) == 0)
				{
					Utskrift.rubrik(messages.getString("chunk"));
					Textfil.addText(utfil1, text1, "UTF-8"); // skriver urvalet
					text1 = ""; // nollställ
					Textfil.addText(utfil2, text2, "UTF-8"); // skriver urvalet
					text2 = ""; // nollställ
				}
				
				i++;
			}

			br1.close(); // stänger filen
			
			// skriv ev. resterande rader till filerna.
						Textfil.addText(utfil1, text1, "UTF-8"); // skriver urvalet
						text1 = ""; // nollställ
						Textfil.addText(utfil2, text2, "UTF-8"); // skriver urvalet
						text2 = ""; // nollställ
		}
		// B. Översättningen efter språk-koden eller något annat.
		// ======================================================
		else if (!segStart)
		{
			int k = 0; // index för <seg> dvs. början på textraden
			
			// Läser in meningarna på resp. språk
			while ((rad = br1.readLine()) != null)
			{	
				rad = rad.trim();
				
				k = rad.indexOf("<seg>"); // början på textraden
				
				//Utskrift.skrivText("Rad " + i + ": " + rad);
				
				if (k>0 && u == 1) // udda
				{
					j = rad.indexOf("</seg>");
					
					if(j > 0)
					{
						text1 = text1 + rad.substring(k+5, j) + "\n";
					
						u = 0; // jämn
						
						//Utskrift.skrivText(rad);
						//Utskrift.skrivText(text1);
					}
					
					else
					{
						text1 = text1 + rad.substring(5) + " ";

						//Utskrift.skrivText(rad);
						//Utskrift.skrivText(text1);				
					}

				}
				
				else if (k>0 && u == 0) // jämn
				{
					j = rad.indexOf("</seg>");

					if(j > 0)
					{			
						text2 = text2 + rad.substring(k+5, j) + "\n";
								
						u = 1; // udda
						
						//Utskrift.skrivText(rad);
						//Utskrift.skrivText(text2);
					}
					
					else
					{
						text2 = text2 + rad.substring(5) + " ";
												
						//Utskrift.skrivText(rad);
						//Utskrift.skrivText(text2);
					}
				}
			
				if ((i%chunkSize) == 0)
				{
					Utskrift.rubrik(messages.getString("chunk"));
					Textfil.addText(utfil1, text1, "UTF-8"); // skriver urvalet
					text1 = ""; // nollställ
					Textfil.addText(utfil2, text2, "UTF-8"); // skriver urvalet
					text2 = ""; // nollställ
				}
				
				
				i++;
			}

			br1.close(); // stänger filen
			
			// skriv ev. resterande rader till filerna.
						Textfil.addText(utfil1, text1, "UTF-8"); // skriver urvalet
						text1 = ""; // nollställ
						Textfil.addText(utfil2, text2, "UTF-8"); // skriver urvalet
						text2 = ""; // nollställ
		}
		
		if (path.length()>0)
			{}
		else
			Utskrift.skrivText(messages.getString("currentcat"));
		
		Utskrift.skrivText(messages.getString("writtento"));
		Utskrift.skrivText(utfil1);
		Utskrift.skrivText(utfil2);
	}
	
	// Read a TMX-file to get the languages
	public static void TMXlanguages(String tmxfil, String[] v) throws Exception
	{
		// Läs språkparet ur TMX-filen
		// ===========================
		String rad = "";
		String lang1 = "";
		String lang2 = "";
		
		int u = 1; //udda
		
		// Opens TMX-file for reading
		BufferedReader br = new BufferedReader(new InputStreamReader(new
		FileInputStream(tmxfil), "UTF-8"));
		
		// Läser några meningar på resp. språk för att bestämma språkpar.
		// --------------------------------------------------------------
		while ((rad = br.readLine()) != null)
		{
			rad = rad.trim();
			//Utskrift.rubrik("Språk-läsning: " + u + " " + rad);
			//Utskrift.skrivText("Börjar med <tuv lang= " + rad.startsWith("<tuv lang="));
			//Utskrift.skrivText("Börjar med <tuv xml:lang= " + rad.startsWith("<tuv xml:lang="));
			
			if (rad.startsWith("<tuv lang=") && u == 1) // udda
			{
				//i = rad.indexOf("<tuv lang=");
				lang1 = rad.substring(11, 13);
				v[0] = lang1;
				u = 0; // jämn
				//Utskrift.skrivText("Udda rad: " + rad);
				//Utskrift.skrivText(lang1);
			}
			
			else if (rad.startsWith("<tuv lang=") && u == 0) // jämn
			{
				//i = rad.indexOf("<tuv lang=");
				lang2 = rad.substring(11, 13);
				v[1] = lang2;
				u = 1; // udda
				//Utskrift.skrivText("Jämn rad: " + rad);
				//Utskrift.skrivText(lang2);
			}
			
			else if (rad.startsWith("<tuv xml:lang=") && u == 1) // udda
			{
				//i = rad.indexOf("<tuv lang=");
				lang1 = rad.substring(15, 17);
				v[0] = lang1;
				u = 0; // jämn
				//Utskrift.skrivText("Udda rad: " + rad);
				//Utskrift.skrivText(lang1);
			}
			
			else if (rad.startsWith("<tuv xml:lang=") && u == 0) // jämn
			{
				//i = rad.indexOf("<tuv lang=");
				lang2 = rad.substring(15, 17);
				v[1] = lang2;
				u = 1; // udda
				//Utskrift.skrivText("Jämn rad: " + rad);
				//Utskrift.skrivText(lang2);
			}
			
			if (lang1.length() > 0 && lang2.length() > 0) break;
		}
		
		br.close(); // stänger filen
	}
}