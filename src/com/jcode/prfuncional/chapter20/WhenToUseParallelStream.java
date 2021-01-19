package com.jcode.prfuncional.chapter20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.LongStream;

import com.jcode.prfuncional.pojos.ProductX;

import jeycodeutils.persistence.file.PersistenceFileManager;

public final class WhenToUseParallelStream
{

      private static final String RANGE = "range";
      private static final String ITERATE = "iterate";
      private static final String YES = "Y";
      private static final String fPathPX = "C:\\Users\\JAVIER\\Desktop\\ObjectContainer\\ProductX.data";
      private final static Scanner scanner = new Scanner(System.in);
      private static List<ProductX> arrayLst = new ArrayList<>();
      private static List<ProductX> linkedLst = new LinkedList<>();

      public static void main(String[] args)
      {

            var manager = PersistenceFileManager.getInstance()
                                                .file(fPathPX);

            System.out.println("cargar los datos [Y/?]");

            if (ifUWant())
            {
                  loadAll(manager);

                  question();
                  while (ifUWant())
                  {

                        System.out.println(diffOperation(arrayLst));
                        System.out.println(diffOperation(linkedLst));

                        LongStream iterate = LongStream.iterate(0,i-> i <= 100000000,i-> i + 1);
                        LongStream range = LongStream.rangeClosed(0,100000000);

                        System.out.println(numberOperation(iterate,ITERATE));
                        System.out.println(numberOperation(range,RANGE));

                        question();
                  }
                  scanner.close();
                  System.out.println("Se acabó la fiesta");
            }
            else
            {
                  System.out.println("Cerrando");
            }
      }

      private static String numberOperation(LongStream stream,String name)
      {
            var diff = 0L;
            var on = System.nanoTime();

            var sum = stream.parallel()
                            .reduce(0,Long::sum);

            diff = System.nanoTime() - on;

            return name + " ha tardado: " + (double)diff / 1000000 + " ms :: Suma-> " + sum;

      }

      private static String diffOperation(List<ProductX> lst)
      {
            var diff = 0L;
            var on = System.nanoTime();

            var sumPrice = lst.parallelStream()
                              .map(ProductX::getPrice)
                              .reduce(0f,Float::sum);

            diff = System.nanoTime() - on;

            return lst.getClass()
                      .getSimpleName() + " ha tardado: " + (double)diff / 1000000 + " ms :: Suma de precios-> " + sumPrice;
      }

      private static boolean ifUWant()
      {
            return scanner.nextLine()
                          .equalsIgnoreCase(YES);
      }

      private static void loadAll(PersistenceFileManager manager)
      {
            List<ProductX> data = manager.loadData();
            System.out.println("Cargados los datos");
            for (var i = 0; i < 1250; i++)
            {
                  arrayLst.addAll(data);
            }
            linkedLst.addAll(arrayLst);
            System.out.println("Tamaño actual de arraylist->" + arrayLst.size() + "\nTamaño actual de linkedlist->" + linkedLst.size());
      }

      private static void question()
      {
            System.out.println("Mostrar lo que tarda en hacerse las operaciones  [Y/?]");
      }

}
