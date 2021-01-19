package com.jcode.prfuncional.chapter14;

import java.text.DecimalFormat;
import java.util.List;

import com.jcode.prfuncional.pojos.Firulais;

import jeycodeutils.persistence.file.PersistenceFileManager;

public class MainNumberReslut
{

      private static final String fPathPX = "C:\\Users\\JAVIER\\Desktop\\ObjectContainer\\Firulais.data";

      public static void main(String[] args)
      {
            var manager = PersistenceFileManager.getInstance()
                                                .file(fPathPX);
            List<Firulais> lst = manager.loadData();

            lst.forEach(System.out::println);

            var format = new DecimalFormat("#.##");

            var average = lst.stream()
                             .mapToDouble(Firulais::getWeight)
                             .average()
                             .getAsDouble();

            System.out.println("Media de edad de los perros que tenemos " + format.format(average));

      }

}
