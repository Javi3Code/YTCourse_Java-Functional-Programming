package com.jcode.prfuncional.pojos;

import java.io.Serializable;
import java.util.Objects;

public abstract class Animal implements Serializable 
{

						private static final long serialVersionUID = 1L;

						protected String habitat;
						protected float weight,length;
						protected int age;
						public final String typeOfAnimal;
						public boolean endangered;
						protected Gender gender;

						public Animal(String habitat,float weight,float length,int age,boolean endangered,Gender gender)
						{
												super();
												this.habitat = habitat;
												this.weight = weight;
												this.length = length;
												this.age = age;
												this.endangered = endangered;
												typeOfAnimal = this.getClass()
																															.getSimpleName();
												this.gender = gender;
						}

						@Override
						public int hashCode()
						{
												return Objects.hash(age,endangered,habitat,length,weight,gender);
						}

						@Override
						public boolean equals(Object obj)
						{
												if (this == obj)
												{
																		return true;
												}
												if (!(obj instanceof Animal))
												{
																		return false;
												}
												Animal other = (Animal)obj;
												return age == other.age && endangered == other.endangered && Objects.equals(habitat,other.habitat)
																																				&& Float.floatToIntBits(length) == Float.floatToIntBits(other.length)
																																				&& Float.floatToIntBits(weight) == Float.floatToIntBits(other.weight) && Objects.equals(gender,other.gender);
						}

						@Override
						public abstract String toString();

						public Gender getGender()
						{
												return gender;
						}

						public void setGender(Gender gender)
						{
												this.gender = gender;
						}

						public boolean isEndangered()
						{
												return endangered;
						}

						public String getHabitat()
						{
												return habitat;
						}

						public void setHabitat(String habitat)
						{
												this.habitat = habitat;
						}

						public float getWeight()
						{
												return weight;
						}

						public void setWeight(float weight)
						{
												this.weight = weight;
						}

						public float getLength()
						{
												return length;
						}

						public void setLength(float length)
						{
												this.length = length;
						}

						public int getAge()
						{
												return age;
						}

						public void setAge(int age)
						{
												this.age = age;
						}

}
