package com.jcode.prfuncional.chapter28;

import java.util.HashSet;
import java.util.List;

import com.jcode.prfuncional.pojos.Pet;

import jeycodeutils.persistence.file.PersistenceFileManager;

public final class MainPersonalCollector
{

      private static final String fPathPet = "res\\Pet.data";

      private static List<Pet> lst;

      public static void main(String[] args)
      {

            var manager = PersistenceFileManager.getInstance()
                                                .file(fPathPet);
            lst = manager.loadData();

            lst.parallelStream()
               .collect(new JsonPetDtoCollector(HashSet::new))
               .forEach(System.out::println);
      }

}
