package com.demo_manageremployee_springboot.repository;

import com.demo_manageremployee_springboot.model.Branch;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBranchRepo extends PagingAndSortingRepository<Branch,Long> {
}
