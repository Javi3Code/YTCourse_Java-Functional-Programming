package com.jcode.prfuncional.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public final class ConsumerExamples
{

      static List<Object> lst = new ArrayList<>();

      public static void main(String[] args)
      {
            lst.add("Hellooo bros");
            lst.add(2020);
            lst.add(true);
            lst.add(48.88f);
//												usingConsumer("Hola soy un valor de tipo T",System.out::println,lst::add,ConsumerExamples::printLst);
            usingBiConsumer(4,1000,ConsumerExamples::printBefore,lst::add,ConsumerExamples::printAfter);

      }

      private static void printAfter(Integer e,Integer v)
      {
            System.out.println("En el index: " + e + ", se añadió el elemento: " + v);
            lst.forEach(System.out::println);
      }

      private static void printBefore(Integer e,Integer v)
      {
            System.out.println("En el index: " + e + ", se intenta añadir el elemento: " + v);
      }

      private static <T,U> void usingBiConsumer(T oneValue,U otherValue,BiConsumer<T,U> biconsume,BiConsumer<T,U> biconsume2,
                                                BiConsumer<T,U> biconsume3)
      {
            biconsume.andThen(biconsume2)
                     .andThen(biconsume3)
                     .accept(oneValue,otherValue);
      }

      private static <T> void printLst(T value)
      {
            System.out.println("Se añadió a la lista el valor: " + value + " -- Total de valores en la lista:");
            lst.forEach(System.out::println);
      }

      private static <T> void usingConsumer(T value,Consumer<T> consume,Consumer<T> consumer2,Consumer<T> consumer3)
      {
//												consume.accept(value);
//												consumer2.accept(value);
//												consumer3.accept(value);
            var consumerCompleted = consume.andThen(consumer2)
                                           .andThen(consumer3);
            consumerCompleted.accept(value);
      }

}
