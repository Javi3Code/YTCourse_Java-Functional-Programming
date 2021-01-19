package com.jcode.prfuncional.chapter11;

import java.util.List;

import com.jcode.prfuncional.pojos.Firulais;
import com.jcode.prfuncional.pojos.Pet;

import jeycodeutils.persistence.file.PersistenceFileManager;

public class FilterStreamMain
{

      private static final String fPath = "C:\\Users\\JAVIER\\Desktop\\ObjectContainer\\Pet.data";
      private static final String fPathM = "C:\\Users\\JAVIER\\Desktop\\ObjectContainer\\Michis.data";
      private static final String fPathF = "C:\\Users\\JAVIER\\Desktop\\ObjectContainer\\Firulais.data";

      public static void main(String[] args)
      {
            var manager = PersistenceFileManager.getInstance()
                                                .file(fPath);
            List<Pet> lst = manager.loadData();

            manager.file(fPathF);

            var count = lst.stream()
                           .filter(pet-> pet instanceof Firulais)
                           .peek(manager::save)
                           .count();

            System.out.println(count + " filas afectadas");

      }

}
