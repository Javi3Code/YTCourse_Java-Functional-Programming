package com.jcode.prfuncional.chapter27;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jcode.prfuncional.chapter26.PetDto;
import com.jcode.prfuncional.pojos.Character;
import com.jcode.prfuncional.pojos.Gender;
import com.jcode.prfuncional.pojos.Pet;

import jeycodeutils.persistence.file.PersistenceFileManager;

public final class MainFlatMapping
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

            Predicate<Pet> partition = pet-> pet.getGender() == Gender.MALE;
            Function<Pet,PetDto> mapper = PetDto::new;
            Predicate<PetDto> filter = pet-> pet.character == Character.GOOD;
            Collector<PetDto,?,List<PetDto>> filtering = Collectors.filtering(filter,Collectors.toUnmodifiableList());
            Collector<Pet,?,List<PetDto>> mapping = Collectors.mapping(mapper,filtering);
            Collector<Pet,?,Map<Boolean,List<PetDto>>> partitioningBy = Collectors.partitioningBy(partition,mapping);

            var newMap = lst.stream()
                            .collect(partitioningBy);

            Function<List<PetDto>,Stream<String>> flatMapper = l-> l.stream()
                                                                    .map(gsonConverter::toJson);

            var result = Stream.of(newMap.get(true),newMap.get(false))
                               .peek(System.out::println)
                               .collect(Collectors.flatMapping(flatMapper,Collectors.toList()));

            System.out.println();

            result.forEach(System.out::println);

      }

}
