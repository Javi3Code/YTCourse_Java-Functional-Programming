package com.jcode.prfuncional.chapter1;

import java.awt.Toolkit;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainIFExamples
{

      public static void main(String[] args)
      {
//												comparatorExample();
//												runnableExample();
            callableExample();
//												actionListenerExample();
      }

      private static void comparatorExample()
      {
            var tree = new TreeSet<>(MainIFExamples::compare);
            tree.add(4);
            tree.add(8);
            tree.add(1);
            tree.add(4);
            tree.add(8);
            tree.add(1);
            tree.forEach(System.out::println);
      }

      private static int compare(Integer a,Integer b)
      {
            if (a < b)
            {
                  return 1;
            }
            if (a == b)
            {
                  return 0;
            }
            return -1;
      }

      private static void runnableExample()
      {
            var thread = new Thread(MainIFExamples::runBehavior);
            thread.start();
      }

      private static void runBehavior()
      {
            var i = 0;
            while (i++ != 100)
            {
                  System.out.println("llamada a run() Nº: " + i);
            }
      }

      private static void callableExample()
      {
            try
            {
                  ExecutorService executor = Executors.newFixedThreadPool(1);
                  Future<String> future = executor.submit(MainIFExamples::operation);
                  System.out.println("Resultado: " + future.get());
                  executor.shutdown();
            }
            catch (InterruptedException | ExecutionException e)
            {
                  e.printStackTrace();
            }
      }

      private static String operation()
      {
            Character[] charArray = new Character[]{'S','o','y',' ','u','n','a',' ','c','a','d','e','n','a'};
            var bfferr = new StringBuffer("Recomponiendo cadena -> ");

            Arrays.stream(charArray)
                  .forEach(character->
                        {
                              System.out.println(character);
                              bfferr.append(character);
                              sleep();
                        });
            System.out.println(Thread.currentThread()
                                     .getName());
            return bfferr.toString();
      }

      private static void sleep()
      {
            try
            {
                  Thread.sleep(1000);
                  System.out.println("Un segundo después...");
            }
            catch (InterruptedException ex)
            {
                  ex.printStackTrace();
            }
      }

      private static void actionListenerExample()
      {
            var frame = new JFrame();
            frame.setSize(Toolkit.getDefaultToolkit()
                                 .getScreenSize());
            var btn = new JButton("EXIT");
            btn.setSize(frame.getSize());

            btn.addActionListener(event-> out());

            frame.getContentPane()
                 .add(btn);
            frame.setVisible(true);
      }

      private static void out()
      {
            System.out.println("Saliendo...");
            System.exit(0);
      }

}
