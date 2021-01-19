package com.jcode.prfuncional.chapter0;

public class MainExample
{

      public MainExample()
      {

            printResultOfThis(this::anyMethod);
      }

      private float anyMethod()
      {
            return 2 / 5;
      }

      private void printResultOfThis(Operation operation)
      {
            System.out.println(operation.operation());
      }

      public static void main(String[] args)
      {
            new MainExample();
      }

}
