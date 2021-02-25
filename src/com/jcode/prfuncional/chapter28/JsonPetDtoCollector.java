package com.jcode.prfuncional.chapter28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jcode.prfuncional.chapter26.PetDto;
import com.jcode.prfuncional.pojos.Pet;

public class JsonPetDtoCollector implements Collector<Pet,List<PetDto>,Collection<String>>
{

      private final Gson gsonCoverter;
      private final Collector<String,?,Collection<String>> collector;

      public JsonPetDtoCollector(Supplier<Collection<String>> collectionSupplier)
      {
            collector = Objects.requireNonNull(Collectors.toCollection(collectionSupplier),"Debes pasar un supplier válido");
            gsonCoverter = new GsonBuilder().setPrettyPrinting()
                                            .create();
      }

      @Override
      public Supplier<List<PetDto>> supplier()
      {
            return ArrayList::new;
      }

      @Override
      public BiConsumer<List<PetDto>,Pet> accumulator()
      {
            return (accumulator,pet)-> accumulator.add(new PetDto(pet));
      }

      @Override
      public BinaryOperator<List<PetDto>> combiner()
      {
            return (accumulator,accumulator2)->
                  {
                        System.out.println("Entra en el combiner el hilo " + Thread.currentThread()
                                                                                   .getName());
                        accumulator.addAll(accumulator2);
                        return accumulator;
                  };
      }

      @Override
      public Function<List<PetDto>,Collection<String>> finisher()
      {
            return accumulator-> accumulator.stream()
                                            .map(gsonCoverter::toJson)
                                            .collect(collector);
      }

      @Override
      public Set<Characteristics> characteristics()
      {
            return Set.of(Characteristics.CONCURRENT);
      }

}
