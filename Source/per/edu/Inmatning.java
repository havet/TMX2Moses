// Inmatning.java

// INMATNING: 

// Matar in med riktiga å,ä,ö.
// Ledtexter och inmatningskontroll.

// Version: 0.97

//      Copyright (c) 2012 Per Tunedal, Stockholm, Sweden
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
// v. 0.2 Minor improvements
// v. 0.97
// --------------------------------------

// Demonstrerar:
// Klass med flera metoder med samma namn
// som skiljer sig åt genom olika antal parametrar

package per.edu;

import java.io.*;
import java.util.*;
import java.awt.*; // Beep

public class Inmatning

{

	// Inmatning av en rad (sträng)
	
	public static String rad () throws Exception
	// lägg till hantering av undantagen:
	// kasta med egna felmeddelanden!
	
	{

		// Förbereder inmatning med rätt tecken.
		// =====================================
		// Klassen InputStreamReader från paketet java.util
		// ------------------------------------------------
		//Förutsätter: import java.util.*;
		
		InputStreamReader isr = new InputStreamReader (System.in, "Cp850");
		Scanner sin = new Scanner (isr);
		
		// Matar in en sträng
		// ==================

		// Inmatningen ger korrekta å,ä,ö:
		String text = sin.nextLine ();
		return text;
	}
	
	// Inmatning av en rad (sträng) med fråga
	
		public static String rad (String ask) throws Exception
	// lägg till hantering av undantagen:
	// kasta med egna felmeddelanden!
	
	{

		// Förbereder inmatning med rätt tecken.
		// =====================================
		// Klassen InputStreamReader från paketet java.util
		// ------------------------------------------------
		//Förutsätter: import java.util.*;
		
		InputStreamReader isr = new InputStreamReader (System.in, "Cp850");
		Scanner sin = new Scanner (isr);
		
		// Skriver ut en fråga
		// ===================

		//Utskrift.skrivText (ask); // Hittar inte klassen! Trots samma katalog.
		// Hur gör man?? Borde kunna använda metoder från egna klasser
		// från andra egna klasser i samma egna paket!
		
		OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
		PrintWriter out = new PrintWriter (osw, true);
		
		out.println (ask);
		
		// Matar in en sträng
		// ==================
	
		// Inmatningen ger korrekta å,ä,ö:
		String text = sin.nextLine ();
		return text;
	}
	
		// Inmatning av en rad (sträng) med fråga
		// samt inmatningskontroll
	
		public static String rad (String ask, String allowed) throws Exception
		// Obs! allowed = regex!
		
		// lägg till hantering av undantagen:
		// kasta med egna felmeddelanden!
	
	{

		// Förbereder inmatning med rätt tecken.
		// =====================================
		// Klassen InputStreamReader från paketet java.util
		// ------------------------------------------------
		//Förutsätter: import java.util.*;
		
		InputStreamReader isr = new InputStreamReader (System.in, "Cp850");
		Scanner sin = new Scanner (isr);
		
		// Skriver ut en fråga
		// ===================

		//Utskrift.skrivText (ask); // Hittar inte klassen! Trots samma katalog.
		// Hur gör man?? Borde kunna använda metoder från egna klasser
		// från andra egna klasser i samma egna paket!
		
		OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
		PrintWriter out = new PrintWriter (osw, true);
		
		out.println (ask); // Skriver ut frågan
		
		// Matar in en sträng
		// ==================
		// Inmatningen ger korrekta å,ä,ö:
		
		// Kontrollera att inmatningen är tillåten
		String text = "";
		while (true)
			{
				text = sin.nextLine ();

				if (text.matches(allowed)) break;
				Toolkit.getDefaultToolkit().beep(); // Kräver import java.awt.*;				
				out.println ("*** FEL ***");
				out.println ("tillåtet: " + allowed  + "\n" + ask);

			}
		
		return text;
	}
	
		// Inmatning av en rad (sträng) med fråga
		// samt inmatningskontroll: stopp-ord
		// och felmeddelande
	
		public static String rad (String ask, String[] stop, String meddelande) throws Exception
		
		// lägg till hantering av undantagen:
		// kasta med egna felmeddelanden!
	
	{

		// Förbereder inmatning med rätt tecken.
		// =====================================
		// Klassen InputStreamReader från paketet java.util
		// ------------------------------------------------
		//Förutsätter: import java.util.*;
		
		InputStreamReader isr = new InputStreamReader (System.in, "Cp850");
		Scanner sin = new Scanner (isr);
		
		// Skriver ut en fråga
		// ===================

		//Utskrift.skrivText (ask); // Hittar inte klassen! Trots samma katalog.
		// Hur gör man?? Borde kunna använda metoder från egna klasser
		// från andra egna klasser i samma egna paket!
		
		OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
		PrintWriter out = new PrintWriter (osw, true);
		
		out.println (ask); // Skriver ut frågan
		
		// Matar in en sträng
		// ==================
		// Inmatningen ger korrekta å,ä,ö:
		
		// Kontrollera att inmatningen är tillåten
		String text = "";
		while (true)
			{
				text = sin.nextLine ();

				// Jämför med uteslutningsordlista
				// bryter vid <0 dvs. ingen träff
				if (Arrays.binarySearch (stop, text) < 0) break;	
				//if (text.matches(allowed)) break;
				Toolkit.getDefaultToolkit().beep(); // Kräver import java.awt.*;				
				out.println ("***" + meddelande + "***" + "\n" + ask);
			}
		
		return text;
	}
	
	// Inmatning av ett decimaltal(double)
	
	public static double decimaltal () throws Exception
	// lägg till hantering av undantagen:
	// kasta med egna felmeddelanden!
	
	{
		// Förbereder inmatning
		// ====================
		
		//Förutsätter: import java.util.*;

		Scanner  in = new Scanner (System.in);
		
		// Förbereder utmatning
		// ====================
		
		OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
		PrintWriter out = new PrintWriter (osw, true);

		// Inmatning
		// =========

		// Heltalsinmatining med metoden nextDouble
		
				while (!in.hasNextDouble())
		{
			out.println ("Detta är inte ett decimaltal!");
			in.nextLine (); // rensar bufferten
		}

		double n = (double) in.nextDouble ();

		// rensning av bufferten
		in.nextLine ();
		return n;
	}
	
	// Inmatning av ett heltal(int)
	
	public static int heltal () throws Exception
	// lägg till hantering av undantagen:
	// kasta med egna felmeddelanden!
	
	{
		// Förbereder inmatning
		// ====================
		
		//Förutsätter: import java.util.*;

		Scanner  in = new Scanner (System.in);
		
		// Förbereder utskrift
		// ===================
		
		OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
		PrintWriter out = new PrintWriter (osw, true);

		// Inmatning
		// =========

		// Heltalsinmatining med metoden nextInt
		
		while (!in.hasNextInt())
		{
			out.println ("Detta är inte ett heltal!");
			in.nextLine (); // rensar bufferten
		}

		int n = (int) in.nextInt ();

		// rensning av bufferten
		in.nextLine ();
		return n;
	}

	// Inmatning av ett decimaltal(double) med fråga
	
	public static double decimaltal (String ask) throws Exception
	// lägg till hantering av undantagen:
	// kasta med egna felmeddelanden!
	
	{
		// Förbereder inmatning
		// ====================
		
		//Förutsätter: import java.util.*;

		Scanner  in = new Scanner (System.in);
		
		// Skriver ut en fråga
		// ===================
		
		OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
		PrintWriter out = new PrintWriter (osw, true);
		
		out.println (ask); // Skriver ut frågan		

		// Inmatning
		// =========

		// Decimaltalsinmatning med metoden nextDouble
		
				while (!in.hasNextDouble())
		{
			out.println ("Detta är inte ett decimaltal!");
			in.nextLine (); // rensar bufferten
		}

		double n = (double) in.nextDouble ();

		// rensning av bufferten
		in.nextLine ();
		return n;
	}
	

	// Inmatning av ett heltal(int) med fråga
	
	public static int heltal (String ask) throws Exception
	// lägg till hantering av undantagen:
	// kasta med egna felmeddelanden!
	
	{
		// Förbereder inmatning
		// ====================
		
		//Förutsätter: import java.util.*;

		Scanner  in = new Scanner (System.in);
		
		// Skriver ut en fråga
		// ===================
		
		OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
		PrintWriter out = new PrintWriter (osw, true);

		out.println (ask); // Skriver ut frågan			

		// Inmatning
		// =========

		// Heltalsinmatining med metoden nextInt
		
		
		while (!in.hasNextInt())
		{
			out.println ("Detta är inte ett heltal!");
			in.nextLine (); // rensar bufferten
		}

		int n = (int) in.nextInt ();

		// rensning av bufferten
		in.nextLine ();
		return n;
	}
	
	// Inmatning av ett heltal(int) med fråga och kontroll
	
	public static int heltal (String ask, int max) throws Exception
	// lägg till hantering av undantagen:
	// kasta med egna felmeddelanden!
	
	{
		// Förbereder inmatning
		// ====================
		
		//Förutsätter: import java.util.*;

		Scanner  in = new Scanner (System.in);
		
		// Skriver ut en fråga
		// ===================
		
		OutputStreamWriter  osw = new OutputStreamWriter (System.out, "Cp850");
		PrintWriter out = new PrintWriter (osw, true);

		out.println (ask); // Skriver ut frågan			

		// Inmatning
		// =========

		// Heltalsinmatining med metoden nextInt
		
		// 			if (text.matches(allowed)) break;
		int n = 0;
		while (!in.hasNextInt() || max < (n = (int) in.nextInt ()))
		{
			out.println ("Fel. Försök igen!");
			in.nextLine (); // rensar bufferten
		}

		//int n = (int) in.nextInt ();

		// rensning av bufferten
		in.nextLine ();
		return n;
	}
}