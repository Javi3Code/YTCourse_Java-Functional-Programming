package com.jcode.prfuncional.pojos;

import java.util.List;

public class Firulais extends Pet
{

      private static final long serialVersionUID = 1L;
      private static String[] skillSet = {"Olfatear","Empatía","Proteger","Jugar","Correr"};
      private static List<String> lstOfSkills = List.of(skillSet);

      public Firulais(float weight,float length,int age,String petName,String owner,Character character,String specialSkill,Gender gender)
      {
            super(weight,length,age,petName,owner,character,specialSkill,gender);
      }

      @Override
      public List<String> getSkills()
      {
            return lstOfSkills;
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

}
