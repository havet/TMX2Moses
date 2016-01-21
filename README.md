# TMX2Moses
TMX2Moses transforms translation memory files into a parallell corpus of two aligned bitext files suitable for training a statistical machine translation system like Moses.
Thus TMX2Moses makes it possible to train your machine translation system on a corpus consisting of the documents you (or some one else) have translated. This is a great advantage as the vocabulary and style is adapted to the domain you are working on.

The software has been tested mainly on TMX-files created with OmegaT, but it works with TMX-files created with other CAT-tools (Computer Aided Translation) as well.

Please read the QuickStart if you would like to test the program. You can test on the TMX-file example_en-sv-omegat.tmx (a translation to Swedish of a Wikipedia article on translation) or your own TMX-file. If you enter the name of a folder all TMX-files in the folder will be processed.
