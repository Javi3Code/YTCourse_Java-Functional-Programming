package com.jcode.prfuncional.chapter4;

import java.time.LocalDate;
import java.util.function.Function;

public final class MainFunction
{

      public static void main(String[] args)
      {
            var chain = new StringBuilder("Usando la interface ");
            Function<StringBuilder,String> toString = in-> in.append(" Function")
                                                             .toString();
            System.out.println(usingFunction(toString,chain));

            var birth = LocalDate.of(1998,3,23);
            Function<LocalDate,Integer> returnAge = date-> date.until(LocalDate.now())
                                                               .getYears();
            Function<Integer,Sub> returnSub = Sub::new;
            Function<Sub,String> returnToString = Sub::toString;
            System.out.println(usingFunWithCompose(returnToString,returnSub,returnAge,birth));

            var sub = new Sub(19);
            Function<Sub,Integer> returnAge1 = Sub::getAge;
            Function<Integer,LocalDate> returnBirth = age->
                  {
                        var now = LocalDate.now();
                        return LocalDate.of(now.getYear() - age,now.getMonth(),now.getDayOfMonth());
                  };
            Function<LocalDate,String> returnString = LocalDate::toString;

            System.out.println(usingFunWithAndThen(returnAge1,returnBirth,returnString,sub));

      }

      private static <T,R,V,O> O usingFunWithAndThen(Function<T,R> fun,Function<R,V> fun1,Function<V,O> fun2,T value)
      {
            return fun.andThen(fun1)
                      .andThen(fun2)
                      .apply(value);
      }

      private static <T,R,V,O> R usingFunWithCompose(Function<T,R> fun,Function<V,T> fun1,Function<O,V> fun2,O value)
      {
            return fun.compose(fun1)
                      .compose(fun2)
                      .apply(value);
      }

      private static <T,R> R usingFunction(Function<T,R> fun,T value)
      {
            return fun.apply(value);
      }

}
