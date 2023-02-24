package com.example.module_3_final_exam.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ICoreCRUDService<E,K> {
    List<E> findAll(HttpServletRequest request);

    E findById(HttpServletRequest request);

    boolean save(HttpServletRequest request);

    boolean deleteById(HttpServletRequest request);
}
