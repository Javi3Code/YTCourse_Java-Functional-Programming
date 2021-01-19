package com.jcode.prfuncional.chapter18;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import com.jcode.prfuncional.pojos.ProductX;

import jeycodeutils.persistence.file.PersistenceFileManager;

public final class MainReduce
{

      private static final String SEPARATOR = " // ";
      private static final String TIPOS_DE_MATERIALES = "Tipos de Materiales: ";
      private static final String fPathPX = "C:\\Users\\JAVIER\\Desktop\\ObjectContainer\\ProductX.data";
      private static List<ProductX> lst;
      private static Set<String> setOfThread = new HashSet<>();

      public static void main(String[] args)
      {

            var manager = PersistenceFileManager.getInstance()
                                                .file(fPathPX);
            lst = manager.loadData();

            BiFunction<Integer,Integer,Integer> acumulator = (sum,num)->
                  {
                        var location = "acumulator";
                        var threadName = Thread.currentThread()
                                               .getName();
                        setOfThread.add(threadName);
                        System.out.println(location + ": " + threadName + "//sum-> " + sum);
                        System.out.println(location + ": " + threadName + "//num-> " + num);
                        return sum + num * 2;
                  };
            BinaryOperator<Integer> combiner = (sum,sum1)->
                  {

                        var location = "combiner";
                        var threadName = Thread.currentThread()
                                               .getName();
                        setOfThread.add(threadName);
                        var sumTotal = sum + sum1;
                        System.out.println(location + ": " + threadName + "//sum-> " + sum);
                        System.out.println(location + ": " + threadName + "//sum1-> " + sum1);
                        System.out.println("Suma total actual " + sumTotal);
                        return sumTotal;
                  };

            var result = Stream.of(1,2,3,432,543,654,765,343,23,456,567,8,87,568)
                               .reduce(0,acumulator,combiner);

            System.out.println("[" + result + "]");
            resultSeq();
            System.out.println("NºHilos utilizados: " + setOfThread.size());
      }

      private static void resultSeq()
      {
            System.out.println(Stream.of(1,2,3,432,543,654,765,343,23,456,567,8,87,568)
                                     .map(number-> number * 2)
                                     .reduce(Integer::sum)
                                     .get());
      }

}
