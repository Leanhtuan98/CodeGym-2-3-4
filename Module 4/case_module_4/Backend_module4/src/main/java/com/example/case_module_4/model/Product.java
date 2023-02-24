package com.example.case_module_4.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idProduct;
private String nameProduct;
private double price;
private int quantity;
private  String img;
@ManyToOne
    private Category category;
}
