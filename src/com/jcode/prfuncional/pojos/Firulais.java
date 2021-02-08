package com.jcode.prfuncional.pojos;

import java.util.Set;

public class Firulais extends Pet
{

      private static final long serialVersionUID = 1L;

      private final static Set<String> setOfSkills = Set.of("Olfatear","Empatía","Proteger","Jugar","Correr");

      public Firulais(float weight,float length,int age,String petName,String owner,Character character,String specialSkill,Gender gender)
      {
            super(weight,length,age,petName,owner,character,specialSkill,gender);
      }


      @Override
      public int hashCode()
      {
            return super.hashCode();
      }

      @Override
      public boolean equals(Object obj)
      {
            if (this == obj)
            {
                  return true;
            }
            if (!super.equals(obj))
            {
                  return false;
            }
            if (!(obj instanceof Firulais))
            {
                  return false;
            }
            return true;
      }

      @Override
      public Set<String> getSkills()
      {
            return setOfSkills;
      }

}
