package com.jcode.prfuncional.chapter7;

import java.util.function.BiPredicate;

public final class MainPredicate
{

      public static void main(String[] args)
      {
            BiPredicate<Integer,Integer> isGreater = MainPredicate::isGreater;
            System.out.println("Es menor el primer número? : " + isGreater.negate()
                                                                          .test(12314,43));
      }

      public static boolean isGreater(Integer greater,Integer less)
      {
            return greater > less;
      }

}
