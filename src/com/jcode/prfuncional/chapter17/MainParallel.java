package com.jcode.prfuncional.chapter17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jcode.prfuncional.pojos.ProductX;

import jeycodeutils.persistence.file.PersistenceFileManager;

public final class MainParallel
{

      private static final String fPathPX = "C:\\Users\\JAVIER\\Desktop\\ObjectContainer\\ProductX.data";
      private static final int ROUNDS = 30;
      private static final String YES = "Y";
      private final static Scanner scanner = new Scanner(System.in);
      private static List<ProductX> lst;
      private static long diffPar;
      private static long diffSeq;

      // N*Q
      public static void main(String[] args)
      {
            var manager = PersistenceFileManager.getInstance()
                                                .file(fPathPX);

            System.out.println("cargar los datos [Y/?]");

            lst = new ArrayList<>();

            if (scanner.nextLine()
                       .equalsIgnoreCase(YES))
            {
                  List<ProductX> data = manager.loadData();
                  System.out.println("Cargados los datos");

                  for (var i = 0; i < 130; i++)
                  {
                        lst.addAll(data);
                        System.out.println("Tamaño actual de la lista: " + lst.size());
                  }

                  System.out.println("Mostrar lo que se tarda en realizar estas operaciones [Y/?]");
                  while (scanner.nextLine()
                                .equalsIgnoreCase(YES))
                  {
                        runParallel();
                        runSeq();
                        System.out.println("Diferencia entre Seq-Par-> " + (diffSeq - diffPar));
                        System.out.println("Mostrar lo que se tarda en realizar estas operaciones [Y/?]");
                  }

            }
            else
            {
                  System.out.println("Cerrando");
            }
            scanner.close();
            System.out.println("Se acabó la pary");

      }

      private static void runParallel()
      {
            diffPar = 0;
            for (var i = 0; i < ROUNDS; i++)
            {
                  var on = System.nanoTime();

                  lst.parallelStream()
                     .filter(prod-> prod.getPrice() > 0.5)
                     .map(prod-> prod.getPrice() * 0.21 + prod.getPrice())
                     .count();

                  var diff = System.nanoTime() - on;
                  diffPar += diff;
            }
      }

      private static void runSeq()
      {

            diffSeq = 0;
            for (var i = 0; i < ROUNDS; i++)
            {
                  var on = System.nanoTime();

                  lst.stream()
                     .filter(prod-> prod.getPrice() > 0.5)
                     .map(prod-> prod.getPrice() * 0.21 + prod.getPrice())
                     .count();

                  var diff = System.nanoTime() - on;
                  diffSeq += diff;
            }

      }

}
