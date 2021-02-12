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

}
