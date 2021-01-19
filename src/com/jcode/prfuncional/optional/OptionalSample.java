package com.jcode.prfuncional.optional;

import java.util.Optional;

public final class OptionalSample
{

      public static void main(String[] args)
      {
            Integer result2 = result2(5,2);
            System.out.println(result2 == -1 ? "No se hace la operación" : "Se realiza la operación->" + result2);
      }

      public static String result(String value,String otherValue)
      {
            return Optional.ofNullable(value)
                           .filter(String::isBlank)
                           .orElse(otherValue);
      }

      public static Integer result2(Integer value,Integer otherValue)
      {
            return Optional.of(Integer.sum(value,otherValue))
                           .filter(sum-> sum > 0)
                           .orElse(-1);

      }

}
