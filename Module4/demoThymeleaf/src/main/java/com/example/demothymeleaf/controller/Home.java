package com.example.demothymeleaf.controller;

import com.example.demothymeleaf.model.Product;
import com.example.demothymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Home {
    @GetMapping("/home")
    public String toan(Model model) {
        model.addAttribute("sanPhams", ProductService.products);
        return "home";
    }

//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable int id) {
//        ProductService.delete(id);
//        return "redirect:/home";
//    }

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
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("sanPhams", ProductService.findById(id));
        return "/edit";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("sanPhams", ProductService.findById(id));
        return "/home";
    }
    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        ProductService.delete(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/home";
    }
}
