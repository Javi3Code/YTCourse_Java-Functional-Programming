package com.jcode.prfuncional.chapter22;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

import com.jcode.prfuncional.pojos.Pet;

import jeycodeutils.persistence.file.PersistenceFileManager;

public final class InitRecollect
{

      private static final String fPathPX = "C:\\Users\\JAVIER\\Desktop\\ObjectContainer\\ProductX.data";
      private static final String fPathAll = "C:\\Users\\JAVIER\\Desktop\\ObjectContainer\\Pet.data";
      private static final String fPathMichis = "C:\\Users\\JAVIER\\Desktop\\ObjectContainer\\Michis.data";
      private static final String fPathFirus = "C:\\Users\\JAVIER\\Desktop\\ObjectContainer\\Firulais.data";

      public static void main(String[] args)
      {

//          Collectors
//          Collector
            
            var manager = PersistenceFileManager.getInstance()
                                                .file(fPathAll);
            List<Pet> lst = manager.loadData();

            IntFunction<String[]> generator = size-> new String[size + size];
//            IntFunction<String[]> generator = String[]::new;

            String[] arr = lst.stream()
                              .map(Pet::getOwner)
                              .distinct()
                              .toArray(generator);

            System.out.println(Arrays.toString(arr));

      }

}
