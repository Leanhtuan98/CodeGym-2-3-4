package com.example.online_electronics_store.model;

public class Product {
   private Long id;
   private String name;
   private Double price;
   private String description;
   private String image;
   private Boolean stockStatus;
   private Category category;

   public Product(String name, Double price, String description, String image, Boolean stockStatus, Category category) {
      this.name = name;
      this.price = price;
      this.description = description;
      this.image = image;
      this.stockStatus = stockStatus;
      this.category = category;
   }

   public Product(){}

   public Product(Long id, String name, Double price, String description, String image, Boolean stockStatus, Category category) {
      this.id = id;
      this.name = name;
      this.price = price;
      this.description = description;
      this.image = image;
      this.stockStatus = stockStatus;
      this.category = category;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Double getPrice() {
      return price;
   }

   public void setPrice(Double price) {
      this.price = price;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getImage() {
      return image;
   }

   public void setImage(String image) {
      this.image = image;
   }

   public Boolean isStockStatus() {
      return stockStatus;
   }

   public void setStockStatus(Boolean stock_status) {
      this.stockStatus = stock_status;
   }


   public Category getCategory() {
      return category;
   }

   public void setCategory(Category category) {
      this.category = category;
   }
}
