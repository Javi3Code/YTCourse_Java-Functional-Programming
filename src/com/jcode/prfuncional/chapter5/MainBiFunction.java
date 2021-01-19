package com.jcode.prfuncional.chapter5;

import java.util.function.BiFunction;
import java.util.function.Function;

public final class MainBiFunction
{

      public static void main(String[] args)
      {

            System.out.println(usingBiFunctionAndThen(

                                                      "Arriba","Arriba",String::equals,MainBiFunction::sendResponse));

      }

      private static String sendResponse(boolean e)
      {
            return e ? "Son iguales" : "Son diferentes";
      }

      private static <T,U,R> R usingBiFunction(T value,U value2,BiFunction<T,U,R> bifun)
      {
            return bifun.apply(value,value2);
      }

      private static <T,U,R,O> O usingBiFunctionAndThen(T value,U value2,BiFunction<T,U,R> bifun,Function<R,O> fun)
      {
            return bifun.andThen(fun)
                        .apply(value,value2);
      }

}
