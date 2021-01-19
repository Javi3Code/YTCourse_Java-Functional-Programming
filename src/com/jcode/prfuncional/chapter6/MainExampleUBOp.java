package com.jcode.prfuncional.chapter6;

import java.util.List;
import java.util.function.BinaryOperator;

public final class MainExampleUBOp
{

      public static void main(String[] args)
      {
            //@formatter:off
												List<String> inmLst = List.of(" -juan- "," -Laura- "," -Rosa- "
												                              ," -Pedro- "," -Eloy- ");//@formatter:on

            BinaryOperator<String> biOp = (text,word)-> text.replace(word,"");
            var text = "tres tristes tigres comían trigo en un trigal";
            var word = "tr";
            System.out.println(biOp.apply(text,word));

            BinaryOperator<Integer> biOp2 = BinaryOperator.maxBy(Integer::compareTo);
            BinaryOperator<Integer> biOp3 = BinaryOperator.minBy(Integer::compareTo);

            System.out.println(biOp2.apply(1000,300));
            System.out.println(biOp3.apply(1000,300));

      }

}
