//Textfil.java

// TEXTFIL:

// Metoder f�r att skriva och l�sa textfiler bekv�mt
// och med r�tt tecken (�, �, �).
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

import java.io.*; // f�r att skapa/�ppna en fil (File)
import java.util.*; // f�r att skriva/l�sa en fil (PrintWriter resp. Scanner)

public class Textfil

// �ppna och skriv till en textfil
// Skriver �ver om filen finns

{

	public static void skrivText (String filnamn, String text) throws Exception
	{
	// Binder en textfil till en variabel
	// Filen skapas om den inte finns.
	// Anv�nder paketet java.io
	
	File   fil = new File (filnamn); // skapas i aktuell katalog
	
	// Skapar ett FileWriter-objekt f�r skrivning till filen
	// och binder objektet till filen
	// Filen �ppnas samtidigt f�r skrivning.
	// Anv�nder paketet java.io
	
	// Skriver �ver filen om den finns
	// (fil, true) l�gger till p� slutet
	
	FileWriter fw = new FileWriter (fil); // Java 1.4?
	
	// Skapar ett PrintWriter-objekt f�r 
	// bekv�m skrivning till filen.
	// (Automatisk omvandling till tkn-str�ng.)
	// och binder objektet till filen
	// Anv�nder paketet java.util	
	
	PrintWriter fout = new PrintWriter (fw); // Java 1.4?
		
	// Skriver till filen
	
	fout.print (text);
	
	// St�nger filen
	// framtvingar skrivning av de sista buffrade tecken,
	// g�rs annars med flush().
	
	fout.close();  // St�nger �ven fw!

	}

	// �ppna och skriv till en textfil
	// L�gger till om filen finns

	public static void addText (String filnamn, String text) throws Exception
	{

	// Binder en textfil till en variabel
	// Filen skapas om den inte finns.
	// Anv�nder paketet java.io
	
	File   fil = new File (filnamn); // skapas i aktuell katalog
	
	// Skapar ett FileWriter-objekt f�r skrivning till filen
	// och binder objektet till filen
	// Filen �ppnas samtidigt f�r skrivning.
	// Anv�nder paketet java.io
	
	// L�gger till i slutet p� filen
	// om den finns
	// (argumentet "true")
	
	FileWriter fw = new FileWriter (fil, true);
		
	// Buffrad utskrift
	// skapar ett BufferedWriter-objekt f�r skrivning
	// och binder det till FileWriter-objektet.
	
	BufferedWriter fout = new BufferedWriter (fw);
		
	// L�gger till radbrytning.
	fout.write (text + "\n"); // BufferedWriter
	
	// St�nger filen
	// framtvingar skrivning av de sista buffrade tecken,
	// g�rs annars med flush().
	
	fout.close();  // St�nger �ven fw!
	
	}
	
	
// �ppna och skriv till en textfil med angiven kodning
// Skriver �ver om filen finns

	public static void skrivText (String filnamn, String text, String encoding) throws Exception
	{
	// Binder en textfil till en variabel
	// Filen skapas om den inte finns.
	// Anv�nder paketet java.io
	
	File   fil = new File (filnamn); // skapas i aktuell katalog
	
	// Skapar ett FileWriter-objekt f�r skrivning till filen
	// och binder objektet till filen
	// Filen �ppnas samtidigt f�r skrivning.
	// Anv�nder paketet java.io
	
	// Skriver �ver filen om den finns
	// (fil, true) l�gger till p� slutet
	
	 // Skriver byte-str�m till fil
	FileOutputStream fos = new FileOutputStream (fil);
		
	// Character till byte
	OutputStreamWriter fout = new OutputStreamWriter (fos, encoding); // Java 1.6
	
	// Skriver till filen
	
	//Obs! L�gger till!
	fout.append (text); // Java 1.6
	
	// St�nger filen
	// framtvingar skrivning av de sista buffrade tecken,
	// g�rs annars med flush().
	
	fout.close(); // St�nger �ven fw!

	}
	
// �ppna och skriv till en textfil med angiven kodning
// L�gger till om filen finns och append = true
public static void addText (String filnamn, String text, String encoding) throws Exception
	{
	// Binder en textfil till en variabel
	// Filen skapas om den inte finns.
	// Anv�nder paketet java.io
	
	File   fil = new File (filnamn); // skapas i aktuell katalog
	
	// Skapar ett FileWriter-objekt f�r skrivning till filen
	// och binder objektet till filen
	// Filen �ppnas samtidigt f�r skrivning.
	// Anv�nder paketet java.io
	
	// Skriver �ver filen om den finns
	// (fil, true) l�gger till p� slutet
	
	 // Skriver byte-str�m till fil
	 // boolean true anger append! Annars: skriv �ver.
	 // --------------------------
	FileOutputStream fos = new FileOutputStream (fil, true); // true ger append
		
	// Character till byte
	OutputStreamWriter fout = new OutputStreamWriter (fos, encoding); // Java 1.6
	
	// Skriver till filen
	
	//Obs! L�gger till!
	fout.append (text); // Java 1.6
	
	// St�nger filen
	// framtvingar skrivning av de sista buffrade tecken,
	// g�rs annars med flush().
	
	fout.close(); // St�nger �ven fw!

	}
	
	// L�s fr�n en textfil
	
	public static String laesText (String filnamn) throws Exception
	
	{
	
	File fil = new File (filnamn); // �ppnar en fil
	
	Scanner fin = new Scanner (fil); // Binder till l�sare
	
	String text = "";
	
	String rad = "";
	
	while (fin.hasNextLine())
		{
		rad = fin.nextLine() + "\n";
		text = text + rad;		
		}
	
	fin.close(); // St�nger filen
		
	return text;
	}
	
	// L�s fr�n en texfil med angiven kodning
	public static String laesText (String filnamn, String encoding) throws Exception
	
	{
	
	File fil = new File (filnamn); // �ppnar en fil
	
	// l�ser byte fr�n fil
	FileInputStream fis = new FileInputStream (fil);
	
	// L�sare f�r rader etc
	// avkodar fr�n angiven kodning
	
	Scanner fin = new Scanner (fis, encoding);
	
	String text = "";
	
	String rad = "";
	
	while (fin.hasNextLine())
		{
		rad = fin.nextLine() + "\n";
		text = text + rad;
		}
	
	fin.close(); // St�nger filen
	
	return text;	
	}
	
	// L�s fr�n ett filobjekt (textfil) med angiven kodning
	public static String laesText (File fil, String encoding) throws Exception
	
	{
	// L�sare f�r rader etc
	// avkodar fr�n angiven kodning
	// L�ser fr�n ett filobject. Binder till en l�sare.
	Scanner fin = new Scanner (fil, encoding);
	
	String text = "";
	
	String rad = "";
	
	while (fin.hasNextLine())
		{
		rad = fin.nextLine() + "\n";
		text = text + rad;
		}
	
	fin.close(); // St�nger filen
	
	return text;	
	}
	
	// L�s ett visst antal rader fr�n en texfil med angiven kodning
	public static String laesText (String filnamn, String encoding, int lines) throws Exception
	
	{
	
	File fil = new File (filnamn); // �ppnar en fil
	
	// l�ser byte fr�n fil
	FileInputStream fis = new FileInputStream (fil);
	
	// L�sare f�r rader etc
	// avkodar fr�n angiven kodning
	
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
	
	fin.close(); // St�nger filen
	
	return text;
	}
	
	// L�s angivna rader fr�n en texfil med angiven kodning
	public static String laesText (String filnamn, String encoding, int[] lines) throws Exception
	
	{
	// Kr�ver att vektorn med radnummer �r sorterad.
	// BufferedReader �r c:a 25 % snabbare.
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
	
	// L�s rader fr�n en texfil, s�tt angiven avgr�nsare
	public static String laesText (String filnamn, String encoding, String delimiter) throws Exception
	
	{
	// BufferedReader l�r vara snabbare. Ja, c:a 25 %!
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
	
	// L�s visst antal rader fr�n en textfil till en str�ngvektor
	public static String[] laesText (int lines, String filnamn, String encoding) throws Exception
	
	{
	// BufferedReader l�r vara snabbare. Ja, c:a 25 %!
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

	// L�s visst antal rader fr�n en textfil till en str�ngvektor	
	// L�gg till ett ord f�rst p� varje rad
	public static String[] laesText (int lines, String filnamn, String encoding, String add) throws Exception
	
	{
	// BufferedReader l�r vara snabbare. Ja, c:a 25 %!
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

	
	// L�s en textfil till en 2-dim str�ngvektor med varje ord i en cell
	public static String[][] laesText (int lines, int words, String filnamn, String encoding) throws Exception
	
	{
	// BufferedReader l�r vara snabbare. Ja, c:a 25 %!
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
	
	// L�s en textfil till en 2-dim str�ngvektor med varje ord i en cell
	// med s�rskild separator: medger "flerordsuttryck", multiwords
	public static String[][] laesText (int lines, int words, String filnamn, String encoding, String delimiter) throws Exception
	
	{
	// BufferedReader l�r vara snabbare. Ja, c:a 25 %!
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
	
	// L�ser fr�n en textfil och visar att n�got h�nder
	public static String laesText (String filnamn, String encoding, boolean showActivity) throws Exception
	
	{
	
	File fil = new File (filnamn); // �ppnar en fil
	
	// l�ser byte fr�n fil
	FileInputStream fis = new FileInputStream (fil);
	
	// L�sare f�r rader etc
	// avkodar fr�n angiven kodning
	
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
	
	fin.close(); // St�nger filen
	
	return text;	
	}
	
	// R�knar rader i en textfil
	public static int rader (String filnamn) throws Exception
	{
	
	/**********************************************
	
	// Denna algoritm ger en p� tok f�r l�g siffra!!
	// =============================================
	File fil = new File (filnamn); // �ppnar en fil
	
	Scanner fin = new Scanner (fil); // Binder till l�sare
	
	int antal = 0;
	
	while (fin.hasNextLine())
		{
		antal++;
		fin.nextLine();
		}
	
	fin.close(); // St�nger filen
	
	*************************************************/
	
	/************************************************************
	// Nedanst�ende kod �r l�ngsam, men ger korrekt resultat
	// =====================================================
	BufferedReader reader = new BufferedReader(new FileReader(filnamn));
	int antal = 0;
	while (reader.readLine() != null) antal++;
	reader.close();
	*********************************************************/
	
	/*******************************************
	// Denna kod �r lite snabbare
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
	
	// Nedanst�ende kod �r blixtsnabb!!
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

	// Ber�knar maximala radl�ngden f�r en textfil
	public static int maxLength (String filnamn, String encoding) throws Exception
	{
	
	File fil = new File (filnamn); // �ppnar en fil
	
	// l�ser byte fr�n fil
	FileInputStream fis = new FileInputStream (fil);
	
	// L�sare f�r rader etc
	// avkodar fr�n angiven kodning
	
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
	
	fin.close(); // St�nger filen

	return max;
	}	
		
	// Ber�knar medelv�rdet av radl�ngden f�r en textfil
	public static double averageLength (String filnamn, String encoding) throws Exception
	{
	
	File fil = new File (filnamn); // �ppnar en fil
	
	// l�ser byte fr�n fil
	FileInputStream fis = new FileInputStream (fil);
	
	// L�sare f�r rader etc
	// avkodar fr�n angiven kodning
	
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
	
	fin.close(); // St�nger filen
	
	double medel = length/antal;
	
	return medel;
	}
	
	// Ber�knar medianen av radl�ngden f�r en textfil
	public static double medianLength (String filnamn, String encoding) throws Exception
	{	
		File fil = new File (filnamn); // �ppnar en fil
		
		// l�ser byte fr�n fil
		FileInputStream fis = new FileInputStream (fil);
		
		// L�sare f�r rader etc
		// avkodar fr�n angiven kodning
		
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
		
		fin.close(); // St�nger filen
		
		//define Array to hold Strings
		//String[] v = new String[lista.size()];
		int[] len = new int[lengths.size()];;

		for (int i=0; i<lengths.size(); i++)
			{
				// F�rsta raden har nr 1, men index 0!
				// ===================================
				len[i] = lengths.get(i);
			}
			
		// Sortera p� plats
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

	// Ber�knar maximala skillnaden i radl�ngden f�r tv� textfiler
	public static int maxLengthDiff (String filnamn1, String filnamn2, String encoding) throws Exception
	{	
		File fil1 = new File (filnamn1); // �ppnar en fil
		File fil2 = new File (filnamn2); // �ppnar en fil
		
		// l�ser byte fr�n fil
		FileInputStream fis1 = new FileInputStream (fil1);
		FileInputStream fis2 = new FileInputStream (fil2);
		
		// L�sare f�r rader etc
		// avkodar fr�n angiven kodning		
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

			ls = Math.abs(rad1.length()-rad2.length()); // l�ngdskillnad
			
			if (max < ls) max = ls;
			
		}
		
		fin1.close(); // St�nger filen
		fin2.close(); // St�nger filen
		
		return max;
	}

	// Ber�knar medianen av skillnaden i radl�ngden f�r tv� textfiler
	public static int medianLengthDiff (String filnamn1, String filnamn2, String encoding) throws Exception
	{	
		File fil1 = new File (filnamn1); // �ppnar en fil
		File fil2 = new File (filnamn2); // �ppnar en fil
		
		// l�ser byte fr�n fil
		FileInputStream fis1 = new FileInputStream (fil1);
		FileInputStream fis2 = new FileInputStream (fil2);
		
		// L�sare f�r rader etc
		// avkodar fr�n angiven kodning		
		Scanner fin1 = new Scanner (fis1, encoding);
		Scanner fin2 = new Scanner (fis2, encoding);
			
		String rad1 = "";
		String rad2 = "";

		ArrayList<Integer> lengths = new ArrayList<Integer>();
		
		while (fin1.hasNextLine())
		{
			rad1 = fin1.nextLine();
			rad2 = fin2.nextLine();

			lengths.add(Math.abs(rad1.length()-rad2.length())); // l�ngdskillnad
		}
		
		fin1.close(); // St�nger filen
		fin2.close(); // St�nger filen
		
		//define Array to hold length differences
		//String[] v = new String[lista.size()];
		int[] len = new int[lengths.size()];;

		for (int i=0; i<lengths.size(); i++)
			{
				// F�rsta raden har nr 1, men index 0!
				// ===================================
				len[i] = lengths.get(i);
			}
			
		// Sortera p� plats
		Arrays.sort(len);
		
		int mitt = len.length/2;
	
		return len[mitt];
	}
	
	// Ber�knar 95-percentilen av skillnaden i radl�ngden f�r tv� textfiler
	public static int percent95LengthDiff (String filnamn1, String filnamn2, String encoding) throws Exception
	{	
		File fil1 = new File (filnamn1); // �ppnar en fil
		File fil2 = new File (filnamn2); // �ppnar en fil
		
		// l�ser byte fr�n fil
		FileInputStream fis1 = new FileInputStream (fil1);
		FileInputStream fis2 = new FileInputStream (fil2);
		
		// L�sare f�r rader etc
		// avkodar fr�n angiven kodning		
		Scanner fin1 = new Scanner (fis1, encoding);
		Scanner fin2 = new Scanner (fis2, encoding);
			
		String rad1 = "";
		String rad2 = "";

		ArrayList<Integer> lengths = new ArrayList<Integer>();
		
		while (fin1.hasNextLine())
		{
			rad1 = fin1.nextLine();
			rad2 = fin2.nextLine();

			lengths.add(Math.abs(rad1.length()-rad2.length())); // l�ngdskillnad
		}
		
		fin1.close(); // St�nger filen
		fin2.close(); // St�nger filen
		
		//define Array to hold length differences
		//String[] v = new String[lista.size()];
		int[] len = new int[lengths.size()];;

		for (int i=0; i<lengths.size(); i++)
			{
				// F�rsta raden har nr 1, men index 0!
				// ===================================
				len[i] = lengths.get(i);
			}
			
		// Sortera p� plats
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

	// Ber�knar n-percentilen av skillnaden i radl�ngden f�r tv� textfiler
	public static int percentLengthDiff (String filnamn1, String filnamn2, int n, String encoding) throws Exception
	{	
	
		/**********************************
		// r�kna raderna
		int lines1 = rader(filnamn1);
		int lines2 = rader(filnamn2);

		if (!(lines1 == lines2)) System.exit(1);
		****************************************/
		File fil1 = new File (filnamn1); // �ppnar en fil
		File fil2 = new File (filnamn2); // �ppnar en fil
		
		// l�ser byte fr�n fil
		FileInputStream fis1 = new FileInputStream (fil1);
		FileInputStream fis2 = new FileInputStream (fil2);
		
		// L�sare f�r rader etc
		// avkodar fr�n angiven kodning		
		Scanner fin1 = new Scanner (fis1, encoding);
		Scanner fin2 = new Scanner (fis2, encoding);
			
		String rad1 = "";
		String rad2 = "";

		ArrayList<Integer> lengths = new ArrayList<Integer>();
				
		while (fin1.hasNextLine())
		{
			rad1 = fin1.nextLine();
			rad2 = fin2.nextLine();

			lengths.add(Math.abs(rad1.length()-rad2.length())); // l�ngdskillnad
		}
		
		//System.out.println();
		
		fin1.close(); // St�nger filen
		fin2.close(); // St�nger filen
		
		//define Array to hold length differences
		//String[] v = new String[lista.size()];
		int[] len = new int[lengths.size()];;

		for (int i=0; i<lengths.size(); i++)
			{
				// F�rsta raden har nr 1, men index 0!
				// ===================================
				len[i] = lengths.get(i);
			}
			
		// Sortera p� plats
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
			//System.out.println("L�ngdskillnad: " + len[i]);
			
			if (sum >= p * tot)
			{
				percentil = len[i];
				//System.out.println("i: " + i);
				break;
			}
		}
		
		/**********************************
		// Skriver ut vektorns l�ngd
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
	
	// L�ngdskillnad m�tt som antal ord
	// Ber�knar n-percentilen av skillnaden i radl�ngden f�r tv� textfiler
	public static int percentWordLengthDiff (String filnamn1, String filnamn2, int n, String encoding) throws Exception
	{	
	
		/**********************************
		// r�kna raderna
		int lines1 = rader(filnamn1);
		int lines2 = rader(filnamn2);

		if (!(lines1 == lines2)) System.exit(1);
		****************************************/
		File fil1 = new File (filnamn1); // �ppnar en fil
		File fil2 = new File (filnamn2); // �ppnar en fil
		
		// l�ser byte fr�n fil
		FileInputStream fis1 = new FileInputStream (fil1);
		FileInputStream fis2 = new FileInputStream (fil2);
		
		// L�sare f�r rader etc
		// avkodar fr�n angiven kodning		
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

			lengths.add(Math.abs(wlen1-wlen2)); // l�ngdskillnad
		}
		
		//System.out.println();
		
		fin1.close(); // St�nger filen
		fin2.close(); // St�nger filen
		
		//define Array to hold length differences
		//String[] v = new String[lista.size()];
		int[] len = new int[lengths.size()];;

		for (int i=0; i<lengths.size(); i++)
			{
				// F�rsta raden har nr 1, men index 0!
				// ===================================
				len[i] = lengths.get(i);
			}
			
		// Sortera p� plats
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
			//System.out.println("L�ngdskillnad: " + len[i]);
			
			if (sum >= p * tot)
			{
				percentil = len[i];
				//System.out.println("i: " + i);
				break;
			}
		}
		
		/**********************************
		// Skriver ut vektorns l�ngd
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
	
	// L�ser s�kv�gen fr�n ett filnamn med fullst�ndig s�kv�g
	public static String readPath (String filnamn)	
	{
		String path = "";
		int i = filnamn.lastIndexOf("\\");
		if (i>=0) path = filnamn.substring(0, i+1);
		return path;
	}
	
	// L�ser enbart filnamnet fr�n ett filnamn med fullst�ndig s�kv�g
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
	// f.exists() ger true �ven f�r kataloger
	  if(f.isFile()) return true;
	  
	  else return false;
	}
	
	// Kollar om en katalog finns
	public static boolean directoryExists (String directory)	
	{
	  File f = new File(directory);
	// f.exists() ger true �ven f�r kataloger
	  if(f.isDirectory()) return true;
	  
	  else return false;
	}
}