package com.jcode.prfuncional.chapter21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
public class UnordererSample
{

      // Extraer el package a un proyecto independiente para ejecutar **AÑADIR al POM
      // las Dependencias

//    En los casos en los que la secuencia tiene un orden de encuentro, pero al
//    usuario no le importa particularmente ese orden de encuentro, desordenar
//    explícitamente la secuencia con unordered () puede mejorar el rendimiento en
//    paralelo para algunas operaciones con estado o de terminal. Por ejemplo
//    cuando filtramos con distinct() o en reducciones de agrupación como
//    GroupingBy

      @Param("5000000")
      private long NUMBER;
      private List<Long> lst;

      public static void main(String[] args) throws RunnerException
      {

            var opt = new OptionsBuilder().include(UnordererSample.class.getSimpleName())
                                          .forks(1)
                                          .warmupIterations(3)
                                          .timeUnit(TimeUnit.MILLISECONDS)
                                          .measurementIterations(4)
                                          .build();
            new Runner(opt).run();
      }

      @Setup
      public void loadData()
      {
            lst = new ArrayList<>();
            for (long i = 0; i < NUMBER; i++)
            {
                  lst.add(i);
            }
            for (long i = 0; i < NUMBER; i++)
            {
                  lst.add(i);
            }
      }

      @Benchmark
      public Long ordered()
      {
            return lst.parallelStream()
                      .distinct()
                      .reduce(0L,Long::sum);
      }

      @Benchmark
      public Long unordered()
      {
            return lst.stream()
                      .unordered()
                      .parallel()
                      .distinct()
                      .reduce(0L,Long::sum);

      }

}
