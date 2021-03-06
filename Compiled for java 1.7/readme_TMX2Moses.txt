TMX2Moses
=========

Description
-----------

The program takes a TMX-file created with OmegaT and makes two bi-text files, suitable for Moses training. Just enter the name of your TMX-file (with full path) when the program waits for input. Hit <ENTER> and wait for the bi-text files to be created.

Notes
-----
1. The program hasn't got any GUI - you have to run it from the command line i.e. in the Command interpreter.

2. It speaks English by default. If you prefere Swedish type the language code (sv) and the country code (SE) after the name of the program. Like this: java -jar TMX2Moses.jar sv SE 

Translation
-----------
Would you like to translate the program to your language? Translate the file MessagesBundleTMX2Moses.properties. You should save it with the appropriate language and country codes, like "_fr_FR" for french, France (if you translate into French from France). Like this: MessagesBundleTMX2Moses_fr_FR.properties
Add the language code and country code as parameters when you run the program:
java -jar TMX2Moses.jar fr FR

(Language code according to ISO 639-1 and country code according to ISO 3166-1 alpha-2:
https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes
https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2)

Usage
-----

If you'r not a programmer or a computer freak do like this:

0. Download and install Java from Oracle, if you don't have it installed. You only need the common version (Java SE Runtime Environment), not the full kit for developers (Java JDK).You MUST install the 32-bit version if you have a 32-bit browser (even if you run 64-bit Windows). In doubt: choose 32-bit Java and avoid severe trouble.

1. Download the file TMX2Moses.jar . 
(If your are using an old version of Java: try the version compiled for Java v. 1.7.)

2. Make a new folder called TMX2Moses in your user folder. In Windows 7: Click on START and then on your username (up to the far right). Now you are in your user folder. Create a new folder named TMX2Moses.

3. Copy the file TMX2Moses.jar to your new folder TMX2Moses.

4. Copy your TMX-file to your new folder TMX2Moses.

5. Open  the Command interpreter (Start � Programs � Utilities � Command Interpreter).

6. Type cd TMX2Moses and hit <ENTER> to get to the new folder with the program.

7. Type:

java -jar TMX2Moses.jar

and the program starts.

(If the program doesn't start, you might have to either enter the path to java.exe in the path-varible for your system or write the full path before "java", like this:
C:\Program Files (x86)\Java\jre1.8.0_25\bin\java -jar TMX2Moses.jar)

8. You get this notice:
"You must write the full path before the filename"

and the prompt:
"Please enter the name of the TMX-file"

9. Type the name of your TMX-file, e.g. My_own.tmx. Don't forget the file extension :".tmx" at the end.

(You don't have to type the path before the filename, because you have copied your TMX-file to the same folder as the program TMX2Moses.)

10. Hit <ENTER> and wait for the result.

11. You'll get an error message if the TMX-file doesn't exist (that is: if you have made a typo).

12. The languages are detected and presented.

13. When "Finished" is displayed the work is done.

14. Enjoy your new bi-text files!
"The result has been written to the files:"
The filenames are displayed. You'll find the files in the same folder as your TMX-file. In this case in your new folder TMX2Moses.
