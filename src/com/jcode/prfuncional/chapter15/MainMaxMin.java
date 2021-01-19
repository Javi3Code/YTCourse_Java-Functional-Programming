package com.jcode.prfuncional.chapter15;

import java.text.DecimalFormat;
import java.util.List;
import java.util.function.Predicate;

import com.jcode.prfuncional.pojos.ProductX;

import jeycodeutils.persistence.file.PersistenceFileManager;

public class MainMaxMin
{

      private static DecimalFormat resFormat = new DecimalFormat("#.##");

      private static final String fPathPX = "C:\\Users\\JAVIER\\Desktop\\ObjectContainer\\ProductX.data";

      public static void main(String[] args) throws Exception
      {
            var manager = PersistenceFileManager.getInstance()
                                                .file(fPathPX);
            List<ProductX> lst = manager.loadData();

            Predicate<? super ProductX> isPlastic = p-> p.getType()
                                                         .equals("Adamantium");

            var max = lst.stream()
                         .filter(isPlastic)
                         .mapToDouble(ProductX::getPrice)
                         .max()
                         .orElseGet(()-> Double.MIN_VALUE);

            System.out.println("Máximo: " + resFormat.format(max));
            System.out.println();

      }

}
