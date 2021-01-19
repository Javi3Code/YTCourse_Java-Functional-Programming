package com.jcode.prfuncional.pojos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class ProductX implements Serializable,Comparable<ProductX>
{

      private static final long serialVersionUID = 1L;
      private String name,promotionCode,material;
      private LocalDate expirationDate;
      private float price;

      public ProductX()
      {}

      public ProductX(String name,String promotionCode,String material,LocalDate expirationDate,float price)
      {
            super();
            this.name = name;
            this.promotionCode = promotionCode;
            this.material = material;
            this.expirationDate = expirationDate;
            this.price = price;
      }

      @Override
      public int hashCode()
      {
            return Objects.hash(promotionCode,expirationDate,name,price,material);
      }

      @Override
      public boolean equals(Object obj)
      {
            if (this == obj)
            {
                  return true;
            }
            if (!(obj instanceof ProductX))
            {
                  return false;
            }
            ProductX other = (ProductX)obj;
            return Objects.equals(promotionCode,other.promotionCode) && Objects.equals(expirationDate,other.expirationDate)
                                    && Objects.equals(name,other.name) && Float.floatToIntBits(price) == Float.floatToIntBits(other.price)
                                    && Objects.equals(material,other.material);
      }

      public String getName()
      {
            return name;
      }

      public void setName(String name)
      {
            this.name = name;
      }

      public String getCode()
      {
            return promotionCode;
      }

      public void setCode(String code)
      {
            promotionCode = code;
      }

      public String getType()
      {
            return material;
      }

      public void setType(String type)
      {
            material = type;
      }

      public LocalDate getExpirationDate()
      {
            return expirationDate;
      }

      public void setExpirationDate(LocalDate dateOfExpiry)
      {
            expirationDate = dateOfExpiry;
      }

      public float getPrice()
      {
            return price;
      }

      public void setPrice(float price)
      {
            this.price = price;
      }

      @Override
      public String toString()
      {
            StringBuilder builder = new StringBuilder();
            builder.append("ProductX [");
            if (name != null)
            {
                  builder.append("name=")
                         .append(name)
                         .append(", ");
            }
            if (promotionCode != null)
            {
                  builder.append("code=")
                         .append(promotionCode)
                         .append(", ");
            }
            if (material != null)
            {
                  builder.append("type=")
                         .append(material)
                         .append(", ");
            }
            if (expirationDate != null)
            {
                  builder.append("expirationDate=")
                         .append(expirationDate)
                         .append(", ");
            }
            builder.append("price=")
                   .append(price)
                   .append("]");
            return builder.toString();
      }

      @Override
      public int compareTo(ProductX o)
      {
//												return price > o.getPrice() ? -1 : 1;// Descendente Mayor a menor
//												return price > o.getPrice() ? 1 : -1; // Ascendente menor a mayor
            return price > o.getPrice() ? 1 : price == o.getPrice() ? name.compareToIgnoreCase(o.getName()) : -1;
      }

}
