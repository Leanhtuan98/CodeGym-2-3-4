package com.example.demospringmvcandcrud.controller;

import com.example.demospringmvcandcrud.model.Product;
import com.example.demospringmvcandcrud.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Home {
    @GetMapping("/home")
    public String toan(Model model) {
        model.addAttribute("products", ProductService.products);
        return "home";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        ProductService.delete(id);
        return "redirect:/home";
    }

    @GetMapping("/create")
    public String showCreate() {
        return "create";
    }

    @PostMapping("/create")
    public String create(Product product) {
        ProductService.products.add(product);
        return "redirect:/home";
    }

    @GetMapping("/edit")
    public String showFormEdit(Model model, @RequestParam int id) {
        model.addAttribute("edit", ProductService.findIndexById(id));
        ProductService.findIndexById(id);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Product product) {
        ProductService.delete(product.getId());
        ProductService.products.add(product);
        return "redirect:/home";
    }

    @GetMapping("/search")
    public String search(Model model,@RequestParam String search) {
        List<Product> list=ProductService.search(search);
        model.addAttribute("product",list);
        return "home";
    }

}
