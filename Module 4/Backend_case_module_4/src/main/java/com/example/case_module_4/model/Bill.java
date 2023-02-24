package com.example.case_module_4.model;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBill;
    private Date date;
    @ManyToOne
    private Account account;

}
