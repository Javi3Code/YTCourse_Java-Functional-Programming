package com.jcode.prfuncional.pojos;

import java.util.Set;

public class Michi extends Pet
{

      private static final long serialVersionUID = 1L;
      private static Set<String> setOfSkills = Set.of("Arañar","Moverse silenciosamente","Dormir","Saltar","Trepar",
                                                      "Perseguir cualquier cosa inanimada");

      public Michi(float weight,float length,int age,String petName,String owner,Character character,String specialSkill,Gender gender)
      {
            super(weight,length,age,petName,owner,character,specialSkill,gender);
      }

      @Override
      public Set<String> getSkills()
      {

            return setOfSkills;
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
            if (!(obj instanceof Michi))
            {
                  return false;
            }
            return true;
      }
}
