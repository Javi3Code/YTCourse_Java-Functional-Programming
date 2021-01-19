package com.jcode.prfuncional.chapter16;

import java.util.Comparator;
import java.util.List;

import com.jcode.prfuncional.pojos.ProductX;

import jeycodeutils.persistence.file.PersistenceFileManager;

public final class MainSorted
{

      private static final String fPathPX = "C:\\Users\\JAVIER\\Desktop\\ObjectContainer\\ProductX.data";
      private static List<ProductX> lst;

      public static void main(String[] args)
      {

            // Limitar tamaño de un stream con Limit(n) y skip(n)

            var manager = PersistenceFileManager.getInstance()
                                                .file(fPathPX);
            lst = manager.loadData();

            Comparator<? super ProductX> comparator = (p0,p1)-> p0.getExpirationDate()
                                                                  .compareTo(p1.getExpirationDate());
            lst.stream()
               .sorted(Comparator.comparing(ProductX::getName))
               .skip(lst.size() - 10)
               .forEach(System.out::println);

      }

}
