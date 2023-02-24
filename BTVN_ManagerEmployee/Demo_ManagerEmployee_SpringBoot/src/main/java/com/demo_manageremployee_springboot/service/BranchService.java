package com.demo_manageremployee_springboot.service;

import com.demo_manageremployee_springboot.model.Branch;
import com.demo_manageremployee_springboot.repository.IBranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BranchService {
    @Autowired
    IBranchRepo iBranchRepo;

    public List<Branch> getAll(){
        return (List<Branch>) iBranchRepo.findAll();
    }
}
