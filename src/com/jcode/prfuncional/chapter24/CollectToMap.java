package com.jcode.prfuncional.chapter24;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.google.gson.GsonBuilder;
import com.jcode.prfuncional.pojos.Gender;
import com.jcode.prfuncional.pojos.Pet;

import jeycodeutils.persistence.file.PersistenceFileManager;

public final class CollectToMap
{

      private static final String fPathPet = "C:\\Users\\JAVIER\\Desktop\\ObjectContainer\\Pet.data";
      private static List<Pet> lst;

      public static void main(String[] args)
      {

            var manager = PersistenceFileManager.getInstance()
                                                .file(fPathPet);
            lst = manager.loadData();

            simple();
//            merge();
//            mergeSupp();
//            grouping();

      }

      private static void grouping()
      {
            Map<Gender,List<Pet>> map = lst.stream()
                                           .collect(Collectors.groupingBy(Pet::getGender));
            map.entrySet()
               .forEach(System.out::println);
      }

      private static void mergeSupp()
      {

            Function<Pet,List<Pet>> valueMap = pet->
                  {
                        var lst = new ArrayList<Pet>();
                        lst.add(pet);
                        return lst;
                  };

            BinaryOperator<List<Pet>> merge = (lst,lst2)->
                  {
                        lst2.addAll(lst);
                        return lst2;
                  };

            Supplier<Map<Gender,List<Pet>>> supplier = ()-> new EnumMap<>(Gender.class);

            Map<Gender,List<Pet>> map = lst.stream()
                                           .collect(Collectors.toMap(Pet::getGender,valueMap,merge,supplier));

            map.get(Gender.FEMALE)
               .forEach(System.out::println);

      }

      private static void merge()
      {

            // Clave->Gender Valor->List<Pet>

            Function<Pet,List<Pet>> valueMap = pet->
                  {
                        var lst = new ArrayList<Pet>();
                        lst.add(pet);
//                        System.out.println("lstSize: " + lst.size());
                        return lst;
                  };

            BinaryOperator<List<Pet>> merge = (lst,lst2)->
                  {
//                        System.out.println("lstSize1Bf: " + lst.size());
//                        System.out.println("lstSize2Bf: " + lst2.size());
                        lst2.addAll(lst);
//                        System.out.println("lstSizeAft: " + lst.size());
                        return lst2;
                  };

            Map<Gender,List<Pet>> map = lst.stream()
                                           .collect(Collectors.toMap(Pet::getGender,valueMap,merge));

//            map.get(Gender.FEMALE)
//               .forEach(System.out::println);

      }

      private static void simple()
      {
            // Clave->Pet Valor-> Su Json
            var gsonObj = new GsonBuilder().setPrettyPrinting()
                                           .create();

            Map<Pet,String> map = lst.stream()
                                     .limit(5)
                                     .collect(Collectors.toMap(Function.identity(),pet-> gsonObj.toJson(pet)));

            System.out.println(map.get(lst.get(0)));

      }

}
