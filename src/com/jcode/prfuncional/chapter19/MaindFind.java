package com.jcode.prfuncional.chapter19;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.jcode.prfuncional.pojos.ProductX;

import jeycodeutils.persistence.file.PersistenceFileManager;

public final class MaindFind
{

      private static final String IRON = "Iron";
      private static final String PLASTIC = "Plastic";
      private static final String fPathPX = "C:\\Users\\JAVIER\\Desktop\\ObjectContainer\\ProductX.data";
      private static final float MIN_PRICE_LIMIT = 10;
      private static final float MAX_PRICE_LIMIT = 70;
      private static List<ProductX> lst;

      public static void main(String[] args)
      {
            var manager = PersistenceFileManager.getInstance()
                                                .file(fPathPX);
            lst = manager.loadData();

            // Producto válido-->
            // si el precio está entre X e Y, y si el material es de hierro o plástico

            Predicate<ProductX> priceOverX = prod-> prod.getPrice() > MIN_PRICE_LIMIT;
            Predicate<ProductX> priceLessThanY = prod-> prod.getPrice() < MAX_PRICE_LIMIT;
            Predicate<ProductX> isPlastic = prod-> prod.getType()
                                                       .equals(PLASTIC);
            Predicate<ProductX> isIron = prod-> prod.getType()
                                                    .equals(IRON);

            Predicate<ProductX> isValid = priceOverX.and(isIron.or(isPlastic))
                                                    .and(priceLessThanY);

            System.out.println("Tenemos " + lst.stream()
                                               .filter(isValid)
                                               .count()
                                    + " productos válidos para estos parámetros");

            Supplier<ProductX> productS = ()-> lst.stream()
                                                  .filter(isValid)
                                                  .findFirst()
                                                  .get();

            Supplier<ProductX> productP = ()-> lst.parallelStream()
                                                  .filter(isValid)
                                                  .findAny()
                                                  .get();

            getSet(productS).forEach(System.out::println);
            System.out.println("=========================");
            getSet(productP).forEach(System.out::println);
      }

      private static Set<ProductX> getSet(Supplier<ProductX> product)
      {
            var setOfProd = new HashSet<ProductX>();
            for (var i = 0; i < 10000; i++)
            {
                  setOfProd.add(product.get());
            }
            return setOfProd;
      }

}
