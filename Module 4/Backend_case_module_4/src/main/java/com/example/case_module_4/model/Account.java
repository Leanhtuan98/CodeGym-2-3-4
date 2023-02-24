package com.example.case_module_4.model;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAccount;
    private String username;
    private String password;
    private String fullName;
    private String address;
    private String phone;
    private String img;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

}
