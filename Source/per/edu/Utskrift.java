// Utskrift.java

// UTSKRIFT:

// Skriver ut med riktiga å,ä,ö
// Skriver objekt, strängar och vektorer,
// samt rubriker med understrykning
// ====================================== 

// Version: 0.98

//      Copyright (c) 2012-2015 Per Tunedal, Stockholm, Sweden
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

// v. 0.1 Comments etc mainly in Swedish.
// v. 0.97
// v. 0.98 Adjusts printout according to OS.
// ----------------------------------------------------

// Demonstrerar:
// Klass med två metoder med samma namn
// som skiljer sig åt genom olika antal parametrar

// även överlagring:
// metoder som endast skiljer sig åt
// genom typen av parametrar

package per.edu;

import java.io.*;
import java.util.*; // ArrayList

public class Utskrift

{
 
// Utskrift av angiven rubrik (sträng)
// understruken med tecknet "´"
	
	public static void rubrik (String s) throws Exception
	
	{
		//Förbereder utskrift med rätt tecken (å,ä,ö).
		//Fungerar bara om man kodar i ANSI, inte med UTF-8!
		// Klassen OutputStreamWriter från paketet java.io
		// ------------------------------------------------		
		//Förutsätter: import java.io.*;
		String osName = System.getProperty("os.name");
		if(osName.contains("nux"))
		{
			System.out.println();
			System.out.println(s);
			int l = s.length();
			for (int i = 0; i<l; i++)
				System.out.print ("´");			
			System.out.println ();
		}
		
		else
		{
			OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
			PrintWriter out = new PrintWriter (osw, true);
			
			out.println ();
			out.println (s);
			int l = s.length();
			for (int i = 0; i<l; i++)
				out.print ("´");			
			out.println ();
		}
	}

 
// Utskrift av angiven rubrik (parameter 1)
// understruken med angivet tecken (parameter 2)
	
	public static void rubrik (String s, char c) throws Exception
	
	{
		//Förbereder utskrift med rätt tecken (å,ä,ö).
		//Fungerar bara om man kodar i ANSI, inte med UTF-8!
		// Klassen OutputStreamWriter från paketet java.io
		// ------------------------------------------------		
		//Förutsätter: import java.io.*;
		String osName = System.getProperty("os.name");
		if(osName.contains("nux"))
		{
			System.out.println ();
			System.out.println (s);
			int l = s.length();
			for (int i = 0; i<l; i++)
				System.out.print (c);			
			System.out.println ();		
		}
		
		else
		{
			OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
			PrintWriter out = new PrintWriter (osw, true);
			
			out.println ();
			out.println (s);
			int l = s.length();
			for (int i = 0; i<l; i++)
				out.print (c);			
			out.println ();
		}
	}
	
// Utskrift av angiven rubrik (sträng)
// omgjord till versaler och
// understruken med tecknet "*"
	
	public static void rubrikVersal (String s) throws Exception
	
	{
		//Förbereder utskrift med rätt tecken (å,ä,ö).
		//Fungerar bara om man kodar i ANSI, inte med UTF-8!
		// Klassen OutputStreamWriter från paketet java.io
		// ------------------------------------------------		
		//Förutsätter: import java.io.*;

		String osName = System.getProperty("os.name");
		if(osName.contains("nux"))
		{
			System.out.println ();
			System.out.println (s.toUpperCase());
			int l = s.length();
			for (int i = 0; i<l; i++)
				System.out.print ("*");			
			System.out.println ();		
		}
		
		else
		{		
			OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
			PrintWriter out = new PrintWriter (osw, true);
			
			out.println ();
			out.println (s.toUpperCase());
			int l = s.length();
			for (int i = 0; i<l; i++)
				out.print ("*");			
			out.println ();
		}
	}
	
	// Utskrift av angiven text (sträng)
	// med riktiga å,ä,ö
	
	public static void skrivText (String s) throws Exception
	
	{
		//Förbereder utskrift med rätt tecken (å,ä,ö).
		//Fungerar bara om man kodar i ANSI, inte med UTF-8!
		// Klassen OutputStreamWriter från paketet java.io
		// ------------------------------------------------		
		//Förutsätter: import java.io.*;

		String osName = System.getProperty("os.name");
		if(osName.contains("nux"))
		{
			System.out.println (s);		
		}
		
		else
		{		
			OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
			PrintWriter out = new PrintWriter (osw, true);
			
			out.println (s);
		}

	}
	
	
	// Utskrift av objekt
	
		public static void skrivText (Object o) throws Exception
	
	{
		//Förbereder utskrift med rätt tecken (å,ä,ö).
		//Fungerar bara om man kodar i ANSI, inte med UTF-8!
		// Klassen OutputStreamWriter från paketet java.io
		// ------------------------------------------------		
		//Förutsätter: import java.io.*;

		String osName = System.getProperty("os.name");
		if(osName.contains("nux"))
		{
			System.out.println (o.toString());		
		}
		
		else
		{		
			OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
			PrintWriter out = new PrintWriter (osw, true);
			
			out.println (o.toString());
		}
	}
	
	// Utskrift av angiven textvektor
	// (strängvektor)
	// med riktiga å,ä,ö
	
	public static void skrivVektor (String[] s) throws Exception
	
	{
		//Förbereder utskrift med rätt tecken (å,ä,ö).
		//Fungerar bara om man kodar i ANSI, inte med UTF-8!
		// Klassen OutputStreamWriter från paketet java.io
		// ------------------------------------------------		
		//Förutsätter: import java.io.*;

		String osName = System.getProperty("os.name");
		if(osName.contains("nux"))
		{
			String ord = "";
			for (String o : s)
				ord = ord + o + " ";		
			System.out.print (ord);
			System.out.println ();		
		}
		
		else
		{		
			OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
			PrintWriter out = new PrintWriter (osw, true);
					
			String ord = "";
			for (String o : s)
				ord = ord + o + " ";		
			out.print (ord);
			out.println ();
		}
	}
	
	// Utskrift av objekt
	// (strängvektor)
	// med riktiga å,ä,ö
	
	public static void skrivVektor (Object[] obj) throws Exception
	
	{
		//Förbereder utskrift med rätt tecken (å,ä,ö).
		//Fungerar bara om man kodar i ANSI, inte med UTF-8!
		// Klassen OutputStreamWriter från paketet java.io
		// ------------------------------------------------		
		//Förutsätter: import java.io.*;

		String osName = System.getProperty("os.name");
		if(osName.contains("nux"))
		{
			for (Object o : obj)
				skrivText(o);		
			System.out.println ();		
		}
		
		else
		{		
			OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
			PrintWriter out = new PrintWriter (osw, true);
					
			for (Object o : obj)
				skrivText(o);		
			out.println ();
		}
	}
	
	// Utskrift av objekt - visst antal rader (från början)
	// (strängvektor)
	// med riktiga å,ä,ö
	
	public static void skrivVektor (Object[] obj, int lines) throws Exception
	
	{
		//Förbereder utskrift med rätt tecken (å,ä,ö).
		//Fungerar bara om man kodar i ANSI, inte med UTF-8!
		// Klassen OutputStreamWriter från paketet java.io
		// ------------------------------------------------		
		//Förutsätter: import java.io.*;

		String osName = System.getProperty("os.name");
		if(osName.contains("nux"))
		{
			if (lines >= 0) // top n, ascending order
				{
					for (int i=0; i<lines; i++)
						skrivText(obj[i]);
					System.out.println ();
				}
			else // bottom n, decending order
				{
					// nb lines < 0!
					for (int i=obj.length-1; i>=obj.length+lines; i--)
						skrivText(obj[i]);
					System.out.println ();
				}				
		}
		
		else
		{		
			OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
			PrintWriter out = new PrintWriter (osw, true);
			
			if (lines >= 0) // top n, ascending order
				{
					for (int i=0; i<lines; i++)
						skrivText(obj[i]);
					out.println ();
				}
			else // bottom n, decending order
				{
					// nb lines < 0!
					for (int i=obj.length-1; i>=obj.length+lines; i--)
						skrivText(obj[i]);
					out.println ();
				}		
		}
		/*******************************************************
			{
				for (int i=obj.length+lines; i<obj.length; i++)
					skrivText(obj[i]);
				out.println ();
			}	
		********************************************************/
	}
	
		public static void skrivVektor (int[] v) throws Exception
	
	{
		//Förbereder utskrift med rätt tecken (å,ä,ö).
		//Fungerar bara om man kodar i ANSI, inte med UTF-8!
		// Klassen OutputStreamWriter från paketet java.io
		// ------------------------------------------------		
		//Förutsätter: import java.io.*;

		String osName = System.getProperty("os.name");
		if(osName.contains("nux"))
		{
			for (int i : v)
				System.out.print (i + " ");		
			System.out.println ();		
		}
		
		else
		{		
			OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
			PrintWriter out = new PrintWriter (osw, true);
					
			for (int i : v)
				out.print (i + " ");		
			out.println ();
		}
	}
	
			public static void skrivVektor (double[] v) throws Exception
	
	{
		//Förbereder utskrift med rätt tecken (å,ä,ö).
		//Fungerar bara om man kodar i ANSI, inte med UTF-8!
		// Klassen OutputStreamWriter från paketet java.io
		// ------------------------------------------------		
		//Förutsätter: import java.io.*;

		String osName = System.getProperty("os.name");
		if(osName.contains("nux"))
		{
			for (double i : v)
				System.out.print (i + " ");		
			System.out.println ();		
		}
		
		else
		{		
			OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
			PrintWriter out = new PrintWriter (osw, true);
					
			for (double i : v)
				out.print (i + " ");		
			out.println ();
		}
	}
	
			public static void skrivVektor (char[] c) throws Exception
	
	{
		//Förbereder utskrift med rätt tecken (å,ä,ö).
		//Fungerar bara om man kodar i ANSI, inte med UTF-8!
		// Klassen OutputStreamWriter från paketet java.io
		// ------------------------------------------------		
		//Förutsätter: import java.io.*;

		String osName = System.getProperty("os.name");
		if(osName.contains("nux"))
		{
			for (char b : c)
				System.out.print (b + " ");		
			System.out.println ();		
		}
		
		else
		{		
			OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
			PrintWriter out = new PrintWriter (osw, true);
					
			for (char b : c)
				out.print (b + " ");		
			out.println ();
		}
	}
	
				public static void skrivVektor (byte[] v) throws Exception
	
	{
		//Förbereder utskrift med rätt tecken (å,ä,ö).
		//Fungerar bara om man kodar i ANSI, inte med UTF-8!
		// Klassen OutputStreamWriter från paketet java.io
		// ------------------------------------------------		
		//Förutsätter: import java.io.*;
		String osName = System.getProperty("os.name");
		if(osName.contains("nux"))
		{
			for (byte b : v)
				System.out.print (b + " ");		
			System.out.println ();		
		}
		
		else
		{		
			OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
			PrintWriter out = new PrintWriter (osw, true);
					
			for (byte b : v)
				out.print (b + " ");		
			out.println ();
		}
	}
	
			public static void skrivVektor (int[][] v) throws Exception
	
	{
		//Förbereder utskrift med rätt tecken (å,ä,ö).
		//Fungerar bara om man kodar i ANSI, inte med UTF-8!
		// Klassen OutputStreamWriter från paketet java.io
		// ------------------------------------------------		
		//Förutsätter: import java.io.*;

		String osName = System.getProperty("os.name");
		if(osName.contains("nux"))
		{
			for (int[] w : v)
			{
				for (int i : w)
					System.out.print (i + " ");		
				System.out.println ();
			}		
		}
		
		else
		{		
			OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
			PrintWriter out = new PrintWriter (osw, true);
			for (int[] w : v)
			{
				for (int i : w)
					out.print (i + " ");		
				out.println ();
			}
		}
	}
	
	public static void skrivVektor (double[][] v) throws Exception
	
	{
		//Förbereder utskrift med rätt tecken (å,ä,ö).
		//Fungerar bara om man kodar i ANSI, inte med UTF-8!
		// Klassen OutputStreamWriter från paketet java.io
		// ------------------------------------------------		
		//Förutsätter: import java.io.*;

		String osName = System.getProperty("os.name");
		if(osName.contains("nux"))
		{
			for (double[] w : v)
			{
				for (double i : w)
					System.out.print (i + " ");		
				System.out.println ();
			}		
		}
		
		else
		{		
			OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
			PrintWriter out = new PrintWriter (osw, true);
			for (double[] w : v)
			{
				for (double i : w)
					out.print (i + " ");		
				out.println ();
			}
		}
	}
	
	public static void skrivVektor (char[][] c) throws Exception
	
	{
		//Förbereder utskrift med rätt tecken (å,ä,ö).
		//Fungerar bara om man kodar i ANSI, inte med UTF-8!
		// Klassen OutputStreamWriter från paketet java.io
		// ------------------------------------------------		
		//Förutsätter: import java.io.*;

		String osName = System.getProperty("os.name");
		if(osName.contains("nux"))
		{
			for (char[] b : c)
			{
				for (char t : b)
					System.out.print (t + " ");		
				System.out.println ();
			}		
		}
		
		else
		{		
			OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
			PrintWriter out = new PrintWriter (osw, true);
			for (char[] b : c)
			{
				for (char t : b)
					out.print (t + " ");		
				out.println ();
			}
		}
	}
	
			public static void skrivVektor (byte[][] v) throws Exception
	
	{
		//Förbereder utskrift med rätt tecken (å,ä,ö).
		//Fungerar bara om man kodar i ANSI, inte med UTF-8!
		// Klassen OutputStreamWriter från paketet java.io
		// ------------------------------------------------		
		//Förutsätter: import java.io.*;

		String osName = System.getProperty("os.name");
		if(osName.contains("nux"))
		{
			for (byte[] b : v)
			{
				for (byte bt : b)
					System.out.print (bt + " ");		
				System.out.println ();
			}		
		}
		
		else
		{		
			OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
			PrintWriter out = new PrintWriter (osw, true);
			for (byte[] b : v)
			{
				for (byte bt : b)
					out.print (bt + " ");		
				out.println ();
			}
		}
	}	
		
	public static void skrivVektor (String[][] c) throws Exception
	
	{
		//Förbereder utskrift med rätt tecken (å,ä,ö).
		//Fungerar bara om man kodar i ANSI, inte med UTF-8!
		// Klassen OutputStreamWriter från paketet java.io
		// ------------------------------------------------		
		//Förutsätter: import java.io.*;

		String osName = System.getProperty("os.name");
		if(osName.contains("nux"))
		{
			for (String[] b : c)
			{
				for (String t : b)
					System.out.print (t + " ");		
				System.out.println ();
			}		
		}
		
		else
		{		
			OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
			PrintWriter out = new PrintWriter (osw, true);
			for (String[] b : c)
			{
				for (String t : b)
					out.print (t + " ");		
				out.println ();
			}
		}
	}
	
	public static void skrivArrayList (ArrayList<String> list) throws Exception
	
	{
		//Förbereder utskrift med rätt tecken (å,ä,ö).
		//Fungerar bara om man kodar i ANSI, inte med UTF-8!
		// Klassen OutputStreamWriter från paketet java.io
		// ------------------------------------------------		
		//Förutsätter: import java.io.*;

		String osName = System.getProperty("os.name");
		if(osName.contains("nux"))
		{
			for (int i=0;i<list.size();i++)
			{
				System.out.println (list.get(i));
			}		
		}
		
		else
		{		
			OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
			PrintWriter out = new PrintWriter (osw, true);
			for (int i=0;i<list.size();i++)
			{
				out.println (list.get(i));
			}
		}
	}

	public static void skrivArrayListDouble (ArrayList<Double> list) throws Exception
	
	{
		//Förbereder utskrift med rätt tecken (å,ä,ö).
		//Fungerar bara om man kodar i ANSI, inte med UTF-8!
		// Klassen OutputStreamWriter från paketet java.io
		// ------------------------------------------------		
		//Förutsätter: import java.io.*;
		
		{		
			for (int i=0;i<list.size();i++)
			{
				//out.println (list.get(i));
				Utskrift.skrivText(list.get(i));
			}
		}
	}
	
	public static void skrivArrayListIntVektor (ArrayList<int[]> list) throws Exception
	
	{
		//Förbereder utskrift med rätt tecken (å,ä,ö).
		//Fungerar bara om man kodar i ANSI, inte med UTF-8!
		// Klassen OutputStreamWriter från paketet java.io
		// ------------------------------------------------		
		//Förutsätter: import java.io.*;
		
		{		
			for (int i=0;i<list.size();i++)
			{
				//out.println (list.get(i));
				Utskrift.skrivVektor(list.get(i));
			}
		}
	}

/****************************************************************************
// funkar ej heller.	
	public static void skrivArrayList (ArrayList<Object> obj) throws Exception
	
	{
		//Förbereder utskrift med rätt tecken (å,ä,ö).
		//Fungerar bara om man kodar i ANSI, inte med UTF-8!
		// Klassen OutputStreamWriter från paketet java.io
		// ------------------------------------------------		
		//Förutsätter: import java.io.*;

		String osName = System.getProperty("os.name");
		if(osName.contains("nux"))
		{
			for (int i=0; i<obj.size(); i++)
				skrivText(obj.get(i));
			System.out.println ();		
		}
		
		else
		{		
			OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
			PrintWriter out = new PrintWriter (osw, true);
			
			for (int i=0;i<obj.size();i++)
				skrivText(obj.get(i));
			out.println ();	
		}
	}
	
*******************************************************************************/

		/******************************************************************
		public static void skrivArrayListObjects (ArrayList<Object> list) throws Exception
	
	{
		//Förbereder utskrift med rätt tecken (å,ä,ö).
		//Fungerar bara om man kodar i ANSI, inte med UTF-8!
		// Klassen OutputStreamWriter från paketet java.io
		// ------------------------------------------------		
		//Förutsätter: import java.io.*;
		
		OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
		PrintWriter out = new PrintWriter (osw, true);
		for (int i=0;i<list.size();i++)
		{
			//out.println (list.get(i).toString());
			//out.println (list.get(i));
			skrivText (list.get(i));
		}
	}
	

		public static void skrivVektor (Object[] obj) throws Exception
	
	{
		//Förbereder utskrift med rätt tecken (å,ä,ö).
		//Fungerar bara om man kodar i ANSI, inte med UTF-8!
		// Klassen OutputStreamWriter från paketet java.io
		// ------------------------------------------------		
		//Förutsätter: import java.io.*;
		
		OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
		PrintWriter out = new PrintWriter (osw, true);
				
		for (Object o : obj)
			skrivText(o);		
		out.println ();
	}
	*****************************************************************/
}