package com.jcode.prfuncional.pojos;

import java.util.List;
import java.util.Objects;

public abstract class Pet extends Animal
{

      private static final long serialVersionUID = 1L;
      protected String petName,owner,specialSkill;
      protected Character character;

      protected Pet(float weight,float length,int age,String petName,String owner,Character character,String specialSkill,Gender gender)
      {
            super("Ciudad",weight,length,age,false,gender);
            this.petName = petName;
            this.owner = owner;
            this.character = character;
            this.specialSkill = specialSkill;
      }

      @Override
      public String toString()
      {
            StringBuilder builder = new StringBuilder();
            builder.append("Pet [");
            if (petName != null)
            {
                  builder.append("petName=")
                         .append(petName)
                         .append(", ");
            }
            if (owner != null)
            {
                  builder.append("owner=")
                         .append(owner)
                         .append(", ");
            }
            if (character != null)
            {
                  builder.append("character=")
                         .append(character)
                         .append(", ");
            }
            if (habitat != null)
            {
                  builder.append("habitat=")
                         .append(habitat)
                         .append(", ");
            }
            builder.append("weight=")
                   .append(weight)
                   .append(", length=")
                   .append(length)
                   .append(", age=")
                   .append(age)
                   .append(", ");
            if (typeOfAnimal != null)
            {
                  builder.append("typeOfAnimal=")
                         .append(typeOfAnimal)
                         .append(", ");
            }

            builder.append("endangered=")
                   .append(endangered)
                   .append(", ");
            if (gender != null)
            {
                  builder.append("gender=")
                         .append(gender)
                         .append(", ");
            }
            if (this.getSkills() != null)
            {
                  builder.append("skills=")
                         .append(this.getSkills())
                         .append(", ");
            }
            if (this.specialSkill() != null)
            {
                  builder.append("specialSkill=")
                         .append(specialSkill);
            }
            builder.append("]");
            return builder.toString();
      }

      @Override
      public int hashCode()
      {
            final int prime = 31;
            int result = super.hashCode();
            result = prime * result + Objects.hash(character,owner,petName,getSkills(),specialSkill());
            return result;
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
            if (!(obj instanceof Pet))
            {
                  return false;
            }
            Pet other = (Pet)obj;
            return character == other.character && Objects.equals(owner,other.owner) && Objects.equals(petName,other.petName)
                                    && Objects.equals(getSkills(),other.getSkills()) && Objects.equals(specialSkill(),other.specialSkill());
      }

      public String getPetName()
      {
            return petName;
      }

      public void setPetName(String petName)
      {
            this.petName = petName;
      }

      public String getOwner()
      {
            return owner;
      }

      public void setOwner(String owner)
      {
            this.owner = owner;
      }

      public Character getCharacter()
      {
            return character;
      }

      public void setCharacter(Character character)
      {
            this.character = character;
      }

      public abstract List<String> getSkills();

      public String specialSkill()
      {
            return specialSkill;
      }

}
