//Textfil.java

// TEXTFIL:

// Metoder för att skriva och läsa textfiler bekvämt
// och med rätt tecken (å, ä, ö).
// ====================================== 

// Version: 0.98

//      Copyright (c) 2012-2013 Per Tunedal, Stockholm, Sweden
//       Author: Per Tunedal <info@tunedal.nu>

	// Optimized code for line counting heavily inspired by:
	// http://stackoverflow.com/questions/453018/number-of-lines-in-a-file-in-java
	// with the kind consent of Martin Ankerl martin.ankerl@gmail.com
	// "It's not completely my code, it has been modified by one or more of 
	// the stackoverflow community. But you are of course free to use it anywhere, 
	// as far as I can say. Just don't sue me or anyone because of it ;)"
	// Martin

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

// v. 0.1 Comments etc mainly in Swedish.
// v. 0.98 Added line counting
// --------------------------------------

package per.edu;

import java.io.*; // för att skapa/öppna en fil (File)
import java.util.*; // för att skriva/läsa en fil (PrintWriter resp. Scanner)

public class Textfil

// Öppna och skriv till en textfil
// Skriver över om filen finns

{

	public static void skrivText (String filnamn, String text) throws Exception
	{
	// Binder en textfil till en variabel
	// Filen skapas om den inte finns.
	// Använder paketet java.io
	
	File   fil = new File (filnamn); // skapas i aktuell katalog
	
	// Skapar ett FileWriter-objekt för skrivning till filen
	// och binder objektet till filen
	// Filen öppnas samtidigt för skrivning.
	// Använder paketet java.io
	
	// Skriver över filen om den finns
	// (fil, true) lägger till på slutet
	
	FileWriter fw = new FileWriter (fil); // Java 1.4?
	
	// Skapar ett PrintWriter-objekt för 
	// bekväm skrivning till filen.
	// (Automatisk omvandling till tkn-sträng.)
	// och binder objektet till filen
	// Använder paketet java.util	
	
	PrintWriter fout = new PrintWriter (fw); // Java 1.4?
		
	// Skriver till filen
	
	fout.print (text);
	
	// Stänger filen
	// framtvingar skrivning av de sista buffrade tecken,
	// görs annars med flush().
	
	fout.close();  // Stänger även fw!

	}

	// Öppna och skriv till en textfil
	// Lägger till om filen finns

	public static void addText (String filnamn, String text) throws Exception
	{

	// Binder en textfil till en variabel
	// Filen skapas om den inte finns.
	// Använder paketet java.io
	
	File   fil = new File (filnamn); // skapas i aktuell katalog
	
	// Skapar ett FileWriter-objekt för skrivning till filen
	// och binder objektet till filen
	// Filen öppnas samtidigt för skrivning.
	// Använder paketet java.io
	
	// Lägger till i slutet på filen
	// om den finns
	// (argumentet "true")
	
	FileWriter fw = new FileWriter (fil, true);
		
	// Buffrad utskrift
	// skapar ett BufferedWriter-objekt för skrivning
	// och binder det till FileWriter-objektet.
	
	BufferedWriter fout = new BufferedWriter (fw);
		
	// Lägger till radbrytning.
	fout.write (text + "\n"); // BufferedWriter
	
	// Stänger filen
	// framtvingar skrivning av de sista buffrade tecken,
	// görs annars med flush().
	
	fout.close();  // Stänger även fw!
	
	}
	
	
// Öppna och skriv till en textfil med angiven kodning
// Skriver över om filen finns

	public static void skrivText (String filnamn, String text, String encoding) throws Exception
	{
	// Binder en textfil till en variabel
	// Filen skapas om den inte finns.
	// Använder paketet java.io
	
	File   fil = new File (filnamn); // skapas i aktuell katalog
	
	// Skapar ett FileWriter-objekt för skrivning till filen
	// och binder objektet till filen
	// Filen öppnas samtidigt för skrivning.
	// Använder paketet java.io
	
	// Skriver över filen om den finns
	// (fil, true) lägger till på slutet
	
	 // Skriver byte-ström till fil
	FileOutputStream fos = new FileOutputStream (fil);
		
	// Character till byte
	OutputStreamWriter fout = new OutputStreamWriter (fos, encoding); // Java 1.6
	
	// Skriver till filen
	
	//Obs! Lägger till!
	fout.append (text); // Java 1.6
	
	// Stänger filen
	// framtvingar skrivning av de sista buffrade tecken,
	// görs annars med flush().
	
	fout.close(); // Stänger även fw!

	}
	
// Öppna och skriv till en textfil med angiven kodning
// Lägger till om filen finns och append = true
public static void addText (String filnamn, String text, String encoding) throws Exception
	{
	// Binder en textfil till en variabel
	// Filen skapas om den inte finns.
	// Använder paketet java.io
	
	File   fil = new File (filnamn); // skapas i aktuell katalog
	
	// Skapar ett FileWriter-objekt för skrivning till filen
	// och binder objektet till filen
	// Filen öppnas samtidigt för skrivning.
	// Använder paketet java.io
	
	// Skriver över filen om den finns
	// (fil, true) lägger till på slutet
	
	 // Skriver byte-ström till fil
	 // boolean true anger append! Annars: skriv över.
	 // --------------------------
	FileOutputStream fos = new FileOutputStream (fil, true); // true ger append
		
	// Character till byte
	OutputStreamWriter fout = new OutputStreamWriter (fos, encoding); // Java 1.6
	
	// Skriver till filen
	
	//Obs! Lägger till!
	fout.append (text); // Java 1.6
	
	// Stänger filen
	// framtvingar skrivning av de sista buffrade tecken,
	// görs annars med flush().
	
	fout.close(); // Stänger även fw!

	}
	
	// Läs från en textfil
	
	public static String laesText (String filnamn) throws Exception
	
	{
	
	File fil = new File (filnamn); // Öppnar en fil
	
	Scanner fin = new Scanner (fil); // Binder till läsare
	
	String text = "";
	
	String rad = "";
	
	while (fin.hasNextLine())
		{
		rad = fin.nextLine() + "\n";
		text = text + rad;		
		}
	
	fin.close(); // Stänger filen
		
	return text;
	}
	
	// Läs från en texfil med angiven kodning
	public static String laesText (String filnamn, String encoding) throws Exception
	
	{
	
	File fil = new File (filnamn); // Öppnar en fil
	
	// läser byte från fil
	FileInputStream fis = new FileInputStream (fil);
	
	// Läsare för rader etc
	// avkodar från angiven kodning
	
	Scanner fin = new Scanner (fis, encoding);
	
	String text = "";
	
	String rad = "";
	
	while (fin.hasNextLine())
		{
		rad = fin.nextLine() + "\n";
		text = text + rad;
		}
	
	fin.close(); // Stänger filen
	
	return text;	
	}
	
	// Läs från ett filobjekt (textfil) med angiven kodning
	public static String laesText (File fil, String encoding) throws Exception
	
	{
	// Läsare för rader etc
	// avkodar från angiven kodning
	// Läser från ett filobject. Binder till en läsare.
	Scanner fin = new Scanner (fil, encoding);
	
	String text = "";
	
	String rad = "";
	
	while (fin.hasNextLine())
		{
		rad = fin.nextLine() + "\n";
		text = text + rad;
		}
	
	fin.close(); // Stänger filen
	
	return text;	
	}
	
	// Läs ett visst antal rader från en texfil med angiven kodning
	public static String laesText (String filnamn, String encoding, int lines) throws Exception
	
	{
	
	File fil = new File (filnamn); // Öppnar en fil
	
	// läser byte från fil
	FileInputStream fis = new FileInputStream (fil);
	
	// Läsare för rader etc
	// avkodar från angiven kodning
	
	Scanner fin = new Scanner (fis, encoding);
	
	String text = "";
	
	String rad = "";
	
	int antal = 0;
	
	while (fin.hasNextLine())
		{
		rad = fin.nextLine() + "\n";
		text = text + rad;
		antal++;
		if (antal == lines) break;
		}
	
	fin.close(); // Stänger filen
	
	return text;
	}
	
	// Läs angivna rader från en texfil med angiven kodning
	public static String laesText (String filnamn, String encoding, int[] lines) throws Exception
	
	{
	// Kräver att vektorn med radnummer är sorterad.
	// BufferedReader är c:a 25 % snabbare.
	BufferedReader br = new BufferedReader(new InputStreamReader(new
	FileInputStream(filnamn), encoding));

	String text = "";
	String rad = "";
	int antal = 0;
	int hittade = 0;

	while ((hittade < lines.length) && ((rad = br.readLine()) != null))
	{
		//System.out.println(rad);
		antal++;
		if (0 == Math.round(antal%100000)) System.out.println ("Tusental rader hittills: "+ antal/1000);
		if (Arrays.binarySearch(lines, antal) >= 0)
		{
			text = text + rad + "\n";
			hittade++;
		}
	}
	
	br.close();
	return text;
	}
	
	// Läs rader från en texfil, sätt angiven avgränsare
	public static String laesText (String filnamn, String encoding, String delimiter) throws Exception
	
	{
	// BufferedReader lär vara snabbare. Ja, c:a 25 %!
	BufferedReader br = new BufferedReader(new InputStreamReader(new
	FileInputStream(filnamn), encoding));

	String text = "";
	String rad = "";
	int antal = 0;

	while ((rad = br.readLine()) != null)
	{
		//System.out.println(rad);
		antal++;
		if (0 == Math.round(antal%100000)) System.out.println ("Tusental rader hittills: "+ antal/1000);
		//if (0 == Math.round(antal%1000)) System.out.println ("Tusental rader hittills: "+ antal/1000);
		{
			text = text + rad + delimiter;
		}
	}
	
	br.close();
	return text;
	}
	
	// Läs visst antal rader från en textfil till en strängvektor
	public static String[] laesText (int lines, String filnamn, String encoding) throws Exception
	
	{
	// BufferedReader lär vara snabbare. Ja, c:a 25 %!
	BufferedReader br = new BufferedReader(new InputStreamReader(new
	FileInputStream(filnamn), encoding));

	String[] text = new String[lines];
	String rad = "";
	//int antal = 0;

	//while ((rad = br.readLine()) != null)
	for (int i = 0;i < lines; i++)
	{
		rad = br.readLine();

		if (0 == Math.round(i%100000)) System.out.println ("Tusental rader hittills: "+ i/1000);
		{
			text[i] = rad;
		}
	}
	
	br.close();
	return text;
	}

	// Läs visst antal rader från en textfil till en strängvektor	
	// Lägg till ett ord först på varje rad
	public static String[] laesText (int lines, String filnamn, String encoding, String add) throws Exception
	
	{
	// BufferedReader lär vara snabbare. Ja, c:a 25 %!
	BufferedReader br = new BufferedReader(new InputStreamReader(new
	FileInputStream(filnamn), encoding));

	String[] text = new String[lines];
	String rad = "";
	//int antal = 0;

	//while ((rad = br.readLine()) != null)
	for (int i = 0;i < lines; i++)
	{
		rad = add + " " + br.readLine();

		if (0 == Math.round(i%100000)) System.out.println ("Tusental rader hittills: "+ i/1000);
		{
			text[i] = rad;
		}
	}
	
	br.close();
	return text;
	}

	
	// Läs en textfil till en 2-dim strängvektor med varje ord i en cell
	public static String[][] laesText (int lines, int words, String filnamn, String encoding) throws Exception
	
	{
	// BufferedReader lär vara snabbare. Ja, c:a 25 %!
	BufferedReader br = new BufferedReader(new InputStreamReader(new
	FileInputStream(filnamn), encoding));

	String[][] text = new String[lines][words];
	String rad = "";
	//int antal = 0;

	//while ((rad = br.readLine()) != null)
	for (int i = 0;i < lines; i++)
	{
		rad = br.readLine();

		if (0 == Math.round(i%100000)) System.out.println ("Tusental rader hittills: "+ i/1000);
		{
			StringTokenizer st = new StringTokenizer(rad);
			
			int j = 0;
			
			while (st.hasMoreTokens())
				{
					text[i][j++] = st.nextToken();
				}
		}
	}
	
	br.close();
	return text;
	}
	
	// Läs en textfil till en 2-dim strängvektor med varje ord i en cell
	// med särskild separator: medger "flerordsuttryck", multiwords
	public static String[][] laesText (int lines, int words, String filnamn, String encoding, String delimiter) throws Exception
	
	{
	// BufferedReader lär vara snabbare. Ja, c:a 25 %!
	BufferedReader br = new BufferedReader(new InputStreamReader(new
	FileInputStream(filnamn), encoding));

	String[][] text = new String[lines][words];
	String rad = "";
	//int antal = 0;

	//while ((rad = br.readLine()) != null)
	for (int i = 0;i < lines; i++)
	{
		rad = br.readLine();

		if (0 == Math.round(i%100000)) System.out.println ("Tusental rader hittills: "+ i/1000);
		{
			StringTokenizer st = new StringTokenizer(rad, delimiter);
			
			int j = 0;
			
			while (st.hasMoreTokens())
				{
					text[i][j++] = st.nextToken();
				}
		}
	}
	
	br.close();
	return text;
	}
	
	// Läser från en textfil och visar att något händer
	public static String laesText (String filnamn, String encoding, boolean showActivity) throws Exception
	
	{
	
	File fil = new File (filnamn); // Öppnar en fil
	
	// läser byte från fil
	FileInputStream fis = new FileInputStream (fil);
	
	// Läsare för rader etc
	// avkodar från angiven kodning
	
	Scanner fin = new Scanner (fis, encoding);
	
	String text = "";	
	String rad = "";
	
	if (showActivity)
	{
		int antal = 0;
		
		while (fin.hasNextLine())
			{
			antal++;
			rad = fin.nextLine() + "\n";
			text = text + rad;
			if (0 == Math.round(antal%1000)) System.out.println ("Rader hittills: "+ antal);
			}
	}
	else
	{
		while (fin.hasNextLine())
			{
			rad = fin.nextLine() + "\n";
			text = text + rad;
			}
	}
	
	fin.close(); // Stänger filen
	
	return text;	
	}
	
	// Räknar rader i en textfil
	public static int rader (String filnamn) throws Exception
	{
	
	/**********************************************
	
	// Denna algoritm ger en på tok för låg siffra!!
	// =============================================
	File fil = new File (filnamn); // Öppnar en fil
	
	Scanner fin = new Scanner (fil); // Binder till läsare
	
	int antal = 0;
	
	while (fin.hasNextLine())
		{
		antal++;
		fin.nextLine();
		}
	
	fin.close(); // Stänger filen
	
	*************************************************/
	
	/************************************************************
	// Nedanstående kod är långsam, men ger korrekt resultat
	// =====================================================
	BufferedReader reader = new BufferedReader(new FileReader(filnamn));
	int antal = 0;
	while (reader.readLine() != null) antal++;
	reader.close();
	*********************************************************/
	
	/*******************************************
	// Denna kod är lite snabbare
	FileReader fr = new FileReader(filnamn);
	LineNumberReader lnr = new LineNumberReader(fr);
 
	int antal = 0;
 
	while (lnr.readLine() != null)
	{
		antal++;
	}
  
	lnr.close();
	
	return antal;
	**********************************************/
	
	// Nedanstående kod är blixtsnabb!!
	// Heavily inspired by:
	// http://stackoverflow.com/questions/453018/number-of-lines-in-a-file-in-java
	// with the kind consent of Martin Ankerl martin.ankerl@gmail.com
	// "It's not completely my code, it has been modified by one or more of 
	// the stackoverflow community. But you are of course free to use it anywhere, 
	// as far as I can say. Just don't sue me or anyone because of it ;)"
	// Martin
	InputStream is = new BufferedInputStream(new FileInputStream(filnamn));
	
	//int antal = 0;
    try {
        byte[] c = new byte[1024];
        int antal = 0;
        int readChars = 0;
        boolean empty = true;
        while ((readChars = is.read(c)) != -1) {
            empty = false;
            for (int i = 0; i < readChars; ++i) {
                if (c[i] == '\n')
                    ++antal;
            }
        }
        return (antal == 0 && !empty) ? 1 : antal;
    } finally {
        is.close();
    }
	//return antal;
	}

	// Beräknar maximala radlängden för en textfil
	public static int maxLength (String filnamn, String encoding) throws Exception
	{
	
	File fil = new File (filnamn); // Öppnar en fil
	
	// läser byte från fil
	FileInputStream fis = new FileInputStream (fil);
	
	// Läsare för rader etc
	// avkodar från angiven kodning
	
	Scanner fin = new Scanner (fis, encoding);
	
	String text = "";
	
	String rad = "";
	int len = 0;
	int max = 0;
	
	while (fin.hasNextLine())
		{
		rad = fin.nextLine();
		len = rad.length();
		
		if (max < len) max = len;
		}
	
	fin.close(); // Stänger filen

	return max;
	}	
		
	// Beräknar medelvärdet av radlängden för en textfil
	public static double averageLength (String filnamn, String encoding) throws Exception
	{
	
	File fil = new File (filnamn); // Öppnar en fil
	
	// läser byte från fil
	FileInputStream fis = new FileInputStream (fil);
	
	// Läsare för rader etc
	// avkodar från angiven kodning
	
	Scanner fin = new Scanner (fis, encoding);
	
	String text = "";
	
	String rad = "";
	int length = 0;
	int antal = 0;
	
	while (fin.hasNextLine())
		{
		rad = fin.nextLine();
		length = length + rad.length(); // The total
		antal++;
		}
	
	fin.close(); // Stänger filen
	
	double medel = length/antal;
	
	return medel;
	}
	
	// Beräknar medianen av radlängden för en textfil
	public static double medianLength (String filnamn, String encoding) throws Exception
	{	
		File fil = new File (filnamn); // Öppnar en fil
		
		// läser byte från fil
		FileInputStream fis = new FileInputStream (fil);
		
		// Läsare för rader etc
		// avkodar från angiven kodning
		
		Scanner fin = new Scanner (fis, encoding);
		
		String text = "";
		
		String rad = "";
		//int length = 0;
		//int antal = 0;
		// ArrayList<String> stringList = new ArrayList<String>();
		ArrayList<Integer> lengths = new ArrayList<Integer>();
		
		while (fin.hasNextLine())
			{
			rad = fin.nextLine();
			lengths.add(rad.length()); // The total
			}
		
		fin.close(); // Stänger filen
		
		//define Array to hold Strings
		//String[] v = new String[lista.size()];
		int[] len = new int[lengths.size()];;

		for (int i=0; i<lengths.size(); i++)
			{
				// Första raden har nr 1, men index 0!
				// ===================================
				len[i] = lengths.get(i);
			}
			
		// Sortera på plats
		Arrays.sort(len);
		
		int mitt = len.length/2;
	
		if (len.length%2 == 1)
		{
			return len[mitt];
		}	
		else
		{
			return (len[mitt-1] + len[mitt]) / 2.0;
		}
	}

	// Beräknar maximala skillnaden i radlängden för två textfiler
	public static int maxLengthDiff (String filnamn1, String filnamn2, String encoding) throws Exception
	{	
		File fil1 = new File (filnamn1); // Öppnar en fil
		File fil2 = new File (filnamn2); // Öppnar en fil
		
		// läser byte från fil
		FileInputStream fis1 = new FileInputStream (fil1);
		FileInputStream fis2 = new FileInputStream (fil2);
		
		// Läsare för rader etc
		// avkodar från angiven kodning		
		Scanner fin1 = new Scanner (fis1, encoding);
		Scanner fin2 = new Scanner (fis2, encoding);
			
		String rad1 = "";
		String rad2 = "";

		//ArrayList<Integer> lengths = new ArrayList<Integer>();
		int max = 0;
		int ls = 0;
		
		while (fin1.hasNextLine())
		{
			rad1 = fin1.nextLine();
			rad2 = fin2.nextLine();

			ls = Math.abs(rad1.length()-rad2.length()); // längdskillnad
			
			if (max < ls) max = ls;
			
		}
		
		fin1.close(); // Stänger filen
		fin2.close(); // Stänger filen
		
		return max;
	}

	// Beräknar medianen av skillnaden i radlängden för två textfiler
	public static int medianLengthDiff (String filnamn1, String filnamn2, String encoding) throws Exception
	{	
		File fil1 = new File (filnamn1); // Öppnar en fil
		File fil2 = new File (filnamn2); // Öppnar en fil
		
		// läser byte från fil
		FileInputStream fis1 = new FileInputStream (fil1);
		FileInputStream fis2 = new FileInputStream (fil2);
		
		// Läsare för rader etc
		// avkodar från angiven kodning		
		Scanner fin1 = new Scanner (fis1, encoding);
		Scanner fin2 = new Scanner (fis2, encoding);
			
		String rad1 = "";
		String rad2 = "";

		ArrayList<Integer> lengths = new ArrayList<Integer>();
		
		while (fin1.hasNextLine())
		{
			rad1 = fin1.nextLine();
			rad2 = fin2.nextLine();

			lengths.add(Math.abs(rad1.length()-rad2.length())); // längdskillnad
		}
		
		fin1.close(); // Stänger filen
		fin2.close(); // Stänger filen
		
		//define Array to hold length differences
		//String[] v = new String[lista.size()];
		int[] len = new int[lengths.size()];;

		for (int i=0; i<lengths.size(); i++)
			{
				// Första raden har nr 1, men index 0!
				// ===================================
				len[i] = lengths.get(i);
			}
			
		// Sortera på plats
		Arrays.sort(len);
		
		int mitt = len.length/2;
	
		return len[mitt];
	}
	
	// Beräknar 95-percentilen av skillnaden i radlängden för två textfiler
	public static int percent95LengthDiff (String filnamn1, String filnamn2, String encoding) throws Exception
	{	
		File fil1 = new File (filnamn1); // Öppnar en fil
		File fil2 = new File (filnamn2); // Öppnar en fil
		
		// läser byte från fil
		FileInputStream fis1 = new FileInputStream (fil1);
		FileInputStream fis2 = new FileInputStream (fil2);
		
		// Läsare för rader etc
		// avkodar från angiven kodning		
		Scanner fin1 = new Scanner (fis1, encoding);
		Scanner fin2 = new Scanner (fis2, encoding);
			
		String rad1 = "";
		String rad2 = "";

		ArrayList<Integer> lengths = new ArrayList<Integer>();
		
		while (fin1.hasNextLine())
		{
			rad1 = fin1.nextLine();
			rad2 = fin2.nextLine();

			lengths.add(Math.abs(rad1.length()-rad2.length())); // längdskillnad
		}
		
		fin1.close(); // Stänger filen
		fin2.close(); // Stänger filen
		
		//define Array to hold length differences
		//String[] v = new String[lista.size()];
		int[] len = new int[lengths.size()];;

		for (int i=0; i<lengths.size(); i++)
			{
				// Första raden har nr 1, men index 0!
				// ===================================
				len[i] = lengths.get(i);
			}
			
		// Sortera på plats
		Arrays.sort(len);
		
		double tot = 0;
		double sum = 0;
		int percentil = 0;
		
		// Calculate total
		for (int i=0; i<len.length; i++)
		{
			tot = tot + len[i];
		}
		
		// Calculate 95th percentile
		for (int i=0; i<len.length; i++)
		{
			sum = sum + len[i];
			if (sum >= 0.95 * tot)
			{
				percentil = len[i];
				break;
			}
		}
		
		return percentil;
	}

	// Beräknar n-percentilen av skillnaden i radlängden för två textfiler
	public static int percentLengthDiff (String filnamn1, String filnamn2, int n, String encoding) throws Exception
	{	
	
		/**********************************
		// räkna raderna
		int lines1 = rader(filnamn1);
		int lines2 = rader(filnamn2);

		if (!(lines1 == lines2)) System.exit(1);
		****************************************/
		File fil1 = new File (filnamn1); // Öppnar en fil
		File fil2 = new File (filnamn2); // Öppnar en fil
		
		// läser byte från fil
		FileInputStream fis1 = new FileInputStream (fil1);
		FileInputStream fis2 = new FileInputStream (fil2);
		
		// Läsare för rader etc
		// avkodar från angiven kodning		
		Scanner fin1 = new Scanner (fis1, encoding);
		Scanner fin2 = new Scanner (fis2, encoding);
			
		String rad1 = "";
		String rad2 = "";

		ArrayList<Integer> lengths = new ArrayList<Integer>();
				
		while (fin1.hasNextLine())
		{
			rad1 = fin1.nextLine();
			rad2 = fin2.nextLine();

			lengths.add(Math.abs(rad1.length()-rad2.length())); // längdskillnad
		}
		
		//System.out.println();
		
		fin1.close(); // Stänger filen
		fin2.close(); // Stänger filen
		
		//define Array to hold length differences
		//String[] v = new String[lista.size()];
		int[] len = new int[lengths.size()];;

		for (int i=0; i<lengths.size(); i++)
			{
				// Första raden har nr 1, men index 0!
				// ===================================
				len[i] = lengths.get(i);
			}
			
		// Sortera på plats
		Arrays.sort(len);
		
		double tot = 0;
		
		// Calculate total
		for (int i=0; i<len.length; i++)
		{
			tot = tot + len[i];
		}
		
		//System.out.println("Tot: " + tot);
		
		double sum = 0;
		int percentil = 0;
		double p = (double)n/100;
		
		//System.out.println("p*tot: " + p*tot);
		
		// Calculate n-th percentile
		for (int i=0; i<len.length; i++)
		{
			sum = sum + len[i];
			
			//System.out.println("Summa: " + sum);
			//System.out.println("Längdskillnad: " + len[i]);
			
			if (sum >= p * tot)
			{
				percentil = len[i];
				//System.out.println("i: " + i);
				break;
			}
		}
		
		/**********************************
		// Skriver ut vektorns längd
		System.out.println ("Antal rader: " + len.length);
		
		//Skriver ut vektorn
		for (int i=0; i<len.length; i++)
		{
		System.out.print (len[i] + " ");		
		}
		
		System.out.println ();
		*******************************************/
		
		return percentil;
	}
	
	// Längdskillnad mätt som antal ord
	// Beräknar n-percentilen av skillnaden i radlängden för två textfiler
	public static int percentWordLengthDiff (String filnamn1, String filnamn2, int n, String encoding) throws Exception
	{	
	
		/**********************************
		// räkna raderna
		int lines1 = rader(filnamn1);
		int lines2 = rader(filnamn2);

		if (!(lines1 == lines2)) System.exit(1);
		****************************************/
		File fil1 = new File (filnamn1); // Öppnar en fil
		File fil2 = new File (filnamn2); // Öppnar en fil
		
		// läser byte från fil
		FileInputStream fis1 = new FileInputStream (fil1);
		FileInputStream fis2 = new FileInputStream (fil2);
		
		// Läsare för rader etc
		// avkodar från angiven kodning		
		Scanner fin1 = new Scanner (fis1, encoding);
		Scanner fin2 = new Scanner (fis2, encoding);
			
		String rad1 = "";
		String rad2 = "";
		
		int wlen1 = 0;
		int wlen2 = 0;

		ArrayList<Integer> lengths = new ArrayList<Integer>();
				
		while (fin1.hasNextLine())
		{
			rad1 = fin1.nextLine();
			rad2 = fin2.nextLine();
			
			wlen1 = Text.countWords(rad1);
			wlen2 = Text.countWords(rad2);

			lengths.add(Math.abs(wlen1-wlen2)); // längdskillnad
		}
		
		//System.out.println();
		
		fin1.close(); // Stänger filen
		fin2.close(); // Stänger filen
		
		//define Array to hold length differences
		//String[] v = new String[lista.size()];
		int[] len = new int[lengths.size()];;

		for (int i=0; i<lengths.size(); i++)
			{
				// Första raden har nr 1, men index 0!
				// ===================================
				len[i] = lengths.get(i);
			}
			
		// Sortera på plats
		Arrays.sort(len);
		
		double tot = 0;
		
		// Calculate total
		for (int i=0; i<len.length; i++)
		{
			tot = tot + len[i];
		}
		
		//System.out.println("Tot: " + tot);
		
		double sum = 0;
		int percentil = 0;
		double p = (double)n/100;
		
		//System.out.println("p*tot: " + p*tot);
		
		// Calculate n-th percentile
		for (int i=0; i<len.length; i++)
		{
			sum = sum + len[i];
			
			//System.out.println("Summa: " + sum);
			//System.out.println("Längdskillnad: " + len[i]);
			
			if (sum >= p * tot)
			{
				percentil = len[i];
				//System.out.println("i: " + i);
				break;
			}
		}
		
		/**********************************
		// Skriver ut vektorns längd
		System.out.println ("Antal rader: " + len.length);
		
		//Skriver ut vektorn
		for (int i=0; i<len.length; i++)
		{
		System.out.print (len[i] + " ");		
		}
		
		System.out.println ();
		*******************************************/
		
		return percentil;
	}
	
	// Läser sökvägen från ett filnamn med fullständig sökväg
	public static String readPath (String filnamn)	
	{
		String path = "";
		int i = filnamn.lastIndexOf("\\");
		if (i>=0) path = filnamn.substring(0, i+1);
		return path;
	}
	
	// Läser enbart filnamnet från ett filnamn med fullständig sökväg
	public static String readFileName (String filnamn)	
	{
		String name = filnamn;
		int i = filnamn.lastIndexOf("\\");
		if (i>=0) name = filnamn.substring(i+1, filnamn.length());
		return name;
	}
	
	// Kollar om en fil finns
	public static boolean exists (String filnamn)	
	{
	  File f = new File(filnamn);
	// f.exists() ger true även för kataloger
	  if(f.isFile()) return true;
	  
	  else return false;
	}
	
	// Kollar om en katalog finns
	public static boolean directoryExists (String directory)	
	{
	  File f = new File(directory);
	// f.exists() ger true även för kataloger
	  if(f.isDirectory()) return true;
	  
	  else return false;
	}
}