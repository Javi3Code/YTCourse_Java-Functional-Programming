package com.jcode.prfuncional.chapter26;

import com.jcode.prfuncional.pojos.Character;
import com.jcode.prfuncional.pojos.Pet;

public final class PetDto
{

      public String name,owner;
      public int age;
      public Character character;

      public PetDto(Pet pet)
      {
            name = pet.getPetName();
            owner = pet.getOwner();
            age = pet.getAge();
            character = pet.getCharacter();
      }

      @Override
      public String toString()
      {
            StringBuilder builder = new StringBuilder();
            builder.append("PetDto [");
            if (name != null)
            {
                  builder.append("name=")
                         .append(name)
                         .append(", ");
            }
            if (owner != null)
            {
                  builder.append("owner=")
                         .append(owner)
                         .append(", ");
            }
            builder.append("age=")
                   .append(age)
                   .append(", ");
            if (character != null)
            {
                  builder.append("character=")
                         .append(character);
            }
            builder.append("]");
            return builder.toString();
      }

}
