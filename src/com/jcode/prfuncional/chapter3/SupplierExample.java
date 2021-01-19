package com.jcode.prfuncional.chapter3;

import java.time.LocalDate;
import java.util.Random;
import java.util.function.Supplier;

public final class SupplierExample
{

      public static void main(String[] args)
      {
            Supplier<LocalDate> date = LocalDate::now;
            var random = new Random();
            Supplier<Integer> randomInt = random::nextInt;
            Supplier<HotDog> hotdog = HotDog::new;
            usingSupplier(date);
            usingSupplier(randomInt);
            usingSupplier(randomInt);
            usingSupplier(randomInt);
            usingSupplier(randomInt);
            usingSupplier(hotdog);
      }

      static <T> void usingSupplier(Supplier<T> supplier)
      {
            System.out.println("Hacemos cierto código");
            System.out.println("Se obtiene: " + supplier.get());
      }

}
