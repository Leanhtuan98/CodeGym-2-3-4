package com.example.case_module_4.dto;

import com.example.case_module_4.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AccountToken {
    private String username;
    private String img;
    private String token;
    private String fullname;

    private List<Role> roles;
}
