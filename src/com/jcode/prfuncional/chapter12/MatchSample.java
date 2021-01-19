package com.jcode.prfuncional.chapter12;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.jcode.prfuncional.pojos.Firulais;
import com.jcode.prfuncional.pojos.Pet;

import jeycodeutils.persistence.file.PersistenceFileManager;

public class MatchSample
{

      private static final String fPath = "C:\\Users\\JAVIER\\Desktop\\ObjectContainer\\Pet.data";
      private static final String fPathM = "C:\\Users\\JAVIER\\Desktop\\ObjectContainer\\Michis.data";
      private static final String fPathF = "C:\\Users\\JAVIER\\Desktop\\ObjectContainer\\Firulais.data";
      private static final String regexLetter = "[a-zA-Z]{1,}";

      public static void main(String[] args)
      {
            var manager = PersistenceFileManager.getInstance()
                                                .file(fPath);
            List<Pet> lst = manager.loadData();

            var complexLst = new ArrayList<List<Pet>>();
            complexLst.add(lst);

            manager.file(fPathF);
            lst = manager.loadData();
            complexLst.add(lst);

            manager.file(fPathM);
            lst = manager.loadData();
            complexLst.add(lst);

            complexLst.stream()
                      .filter(list-> list.stream()
                                         .anyMatch(MatchSample::isFirulaisAndOwnerJeyCode))
                      .forEach(list->
                            {
                                  System.out.println("__________________________");
                                  list.stream()
                                      .filter(pet-> pet.getOwner()
                                                       .equals("Jey Code"))
                                      .forEach(System.out::println);
                            });

      }

      private static boolean isFirulaisAndOwnerJeyCode(Pet pet)
      {
            Predicate<Pet> isOwnerIsJCode = e-> e.getOwner()
                                                 .equals("Jey Code");
            Predicate<Pet> isFirulais = e-> e instanceof Firulais;
            return isFirulais.and(isOwnerIsJCode)
                             .test(pet);
      }

}
