package com.example.case_module_4.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class BillDetails {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBillDetails;

 @ManyToOne
    private Bill bill;
 @ManyToOne
    private Product product;
 private String comment;
 private int amount;
}
