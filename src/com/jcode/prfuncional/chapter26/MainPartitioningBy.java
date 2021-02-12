package com.jcode.prfuncional.chapter26;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jcode.prfuncional.pojos.Character;
import com.jcode.prfuncional.pojos.Gender;
import com.jcode.prfuncional.pojos.Pet;

import jeycodeutils.persistence.file.PersistenceFileManager;

public final class MainPartitioningBy
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

            var isMale = true;

            Predicate<Pet> partition = pet-> pet.getGender() == Gender.MALE;

//            var newMap = lst.stream()
//                            .collect(Collectors.partitioningBy(partition));

            Function<Pet,PetDto> mapper = PetDto::new;

            Predicate<PetDto> filter = pet-> pet.character == Character.GOOD;

            Collector<PetDto,?,List<PetDto>> filtering = 
                                                       Collectors.filtering(filter,Collectors.toUnmodifiableList());

            Collector<Pet,?,List<PetDto>> mapping = Collectors.mapping(mapper,filtering);

            Collector<Pet,?,Map<Boolean,List<PetDto>>> partitioningBy =
                                    
                                    Collectors.partitioningBy(partition,mapping);

            var newMap = lst.stream()
                            .collect(partitioningBy);

            newMap.get(isMale)
                  .stream()
                  .map(gsonConverter::toJson)
                  .forEach(System.out::println);
            
            System.out.println("********************************");
            
            newMap.get(!isMale)
                  .stream()
                  .map(gsonConverter::toJson)
                  .forEach(System.out::println);

      }

}
