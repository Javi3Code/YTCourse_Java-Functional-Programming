package com.jcode.prfuncional.chapter13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class MapSample
{

      private static final String TXT = ".txt";
      private static final String CLASS = ".class";
      private static final String SRC_PATH = "src";
      private static final String PROYECT_PATH = ".";
      private static final String fPath = "C:\\Users\\JAVIER\\Desktop\\ObjectContainer\\Pet.data";
      private static final String fPathM = "C:\\Users\\JAVIER\\Desktop\\ObjectContainer\\Michis.data";
      private static final String fPathF = "C:\\Users\\JAVIER\\Desktop\\ObjectContainer\\Firulais.data";
      private static final String pathTxtFile = "sampleTxtFile.txt";

      public static void main(String[] args) throws IOException
      {

            var pathR = Paths.get(pathTxtFile);
            var w = "fichero";
            try (var lines = Files.lines(pathR))
            {

                  var count = lines.flatMap(line-> Stream.of(line.split("[\\s,.]+")))
                                   .peek(System.out::println)
                                   .filter(word-> word.toLowerCase()
                                                      .contains(w))
                                   .count();

                  System.out.println(count);

            }

      }

}
