package com.jcode.prfuncional.chapter25;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jcode.prfuncional.pojos.Pet;

import jeycodeutils.persistence.file.PersistenceFileManager;

public final class MainGroupingBy
{

      private static final String fPathPet = "res\\Pet.data";

      private static List<Pet> lst;

      private static Gson gsonConverter;

      public static void main(String[] args)
      {

            var manager = PersistenceFileManager.getInstance()
                                                .file(fPathPet);

            gsonConverter = new GsonBuilder().setPrettyPrinting()
                                             .create();
            lst = manager.loadData();

//            lst.stream()
//               .map(gsonConverter::toJson)
//               .forEach(System.out::println);

//            groupingBySimple().entrySet()
//                              .forEach(System.out::println);

//            System.out.println(lst.size());

//            groupingByMedium().entrySet()
//                              .forEach(System.out::println);

//            groupingByComplete().entrySet()
//                                .forEach(System.out::println);

            groupingByComplex().entrySet()
                               .forEach(System.out::println);

      }

      private static Map<Integer,String> groupingByComplex()
      {
            Function<Pet,Integer> classifier = pet-> pet.getAge() > 5 ? 1 : 0;
            Collector<Pet,?,String> downstream = Collectors.mapping(Pet::getPetName,Collectors.joining(", "));

            return lst.stream()
                      .collect(Collectors.groupingBy(classifier,downstream));

      }

      private static LinkedHashMap<String,Set<Pet>> groupingByComplete()
      {
            return lst.stream()
                      .collect(Collectors.groupingBy(Pet::getOwner,LinkedHashMap::new,Collectors.toSet()));

      }

      private static Map<? super Pet,Long> groupingByMedium()
      {
            return lst.stream()
                      .collect(Collectors.groupingBy(Pet::getClass,Collectors.counting()));
      }

      private static Map<com.jcode.prfuncional.pojos.Character,List<Pet>> groupingBySimple()
      {
            return lst.stream()
                      .collect(Collectors.groupingBy(Pet::getCharacter));
      }

}
