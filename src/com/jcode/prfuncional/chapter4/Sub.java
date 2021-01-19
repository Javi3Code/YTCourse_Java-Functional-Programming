package com.jcode.prfuncional.chapter4;

public class Sub
{

      private final String name = "Suscriptor";
      private final Integer age;

      public Sub(Integer age)
      {
            this.age = age;
      }

      public Integer getAge()
      {
            return age;
      }

      @Override
      public String toString()
      {
            return "Sub [name=" + name + ", age=" + age + "]";
      }

}
