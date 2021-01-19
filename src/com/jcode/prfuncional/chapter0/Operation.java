package com.jcode.prfuncional.chapter0;

@FunctionalInterface
public interface Operation
{

      float operation();

      private void interfacePrivateMethod()
      {
            System.out.println("Llamando al método privado de una interfaz");
            interfaceStaticMethod();
      }

      static void interfaceStaticMethod()
      {
            System.out.println("Llamando al método estático de una interfaz");
      }

      default void interfaceDefaultMethod()
      {
            interfacePrivateMethod();
            interfaceStaticMethod();
            System.out.println("Llamando al método default de una interfaz");
      }

}
