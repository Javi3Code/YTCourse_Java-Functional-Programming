package com.jcode.prfuncional.chapter23;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.jcode.prfuncional.pojos.ProductX;

import jeycodeutils.persistence.file.PersistenceFileManager;

public final class MainCollectToListOrSet
{

      private static final String fPathPX = "C:\\Users\\JAVIER\\Desktop\\ObjectContainer\\ProductX.data";
      private static List<ProductX> lst;

      public static void main(String[] args)
      {

            var manager = PersistenceFileManager.getInstance()
                                                .file(fPathPX);
            lst = manager.loadData();

            Collector<String,?,List<String>> collector = Collectors.toList();
            Collector<String,?,List<String>> collector2 = Collectors.toCollection(LinkedList::new);
            Collector<String,?,List<String>> collector3 = Collectors.toUnmodifiableList();

            Collector<String,?,Set<String>> collector4 = Collectors.toSet();
            Collector<String,?,Set<String>> collector5 = Collectors.toCollection(TreeSet::new);
            Collector<String,?,Set<String>> collector6 = Collectors.toUnmodifiableSet();

            printTypeOfCollection(collector);
            printTypeOfCollection(collector2);
            printTypeOfCollection(collector3);
            printTypeOfCollection(collector4).forEach(System.out::println);
            printTypeOfCollection(collector5).forEach(System.out::println);
            printTypeOfCollection(collector6).forEach(System.out::println);

      }

      private static <T> T printTypeOfCollection(Collector<String,?,T> collector)
      {
            var collection = lst.stream()
                                .filter(prod-> prod.getPrice() < 2)
                                .map(ProductX::getType)
                                .collect(collector);

            System.out.println("TypeResult :: <<" + collection.getClass()
                                                              .getSimpleName()
                                    + ">>");
            return collection;
      }

}
