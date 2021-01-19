package com.jcode.prfuncional.chapter8;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class MainReference
{

      public static void main(String[] args)
      {
            /**
												 * Formato--> referencia :: nombre del método
												 * @formatter:off
												 * Tipos-->{ 
												 *										 nombre de la clase :: método static 
												 *											nombre de la clase :: método
												 * 										nombre de la clase :: new 
												 * 										objeto existente :: método 
												 * 								}
												 * @formatter:on
												 */
            var string = "Esternocleidomastoideo";
            var instance = new MainReference();
            Supplier<String> instanceMethod = string::toUpperCase;
            Supplier<String> instanceMethod2 = instance::get;
            Supplier<String> instanceMethod3 = instance::getReferencedMethod;
            Supplier<MainReference> constructorReference = MainReference::new;
            Predicate<String> staticMethod = Objects::isNull;

            System.out.println(instanceMethod.get());
            System.out.println(instanceMethod2.get());
            System.out.println(instanceMethod3.get());
            System.out.println(constructorReference.get()
                                                   .toString());
            System.out.println(staticMethod.test(null));
      }

      public String getReferencedMethod()
      {

            Supplier<String> supplier = this::get;
            return supplier.get()
                           .concat("-->llamado con this");
      }

      public String get()
      {
            return "Cualquier cosa";
      }

      @Override
      public String toString()
      {
            return "Soy una instancia de la clase MainReference";
      }

}
