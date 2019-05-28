package com.example.thymeleaf.controller;

import com.example.thymeleaf.model.Product;
import com.example.thymeleaf.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(path ="/")
    public String index(){
        return "index";
    }

    @RequestMapping(path="/products/add", method = RequestMethod.GET)
    public String createProduct(Model model){
        model.addAttribute("product", new Product());
        return "edit";
    }

    @RequestMapping(path ="/products", method=RequestMethod.POST)
    public String saveProduct(Product product){
        productRepository.save(product);
        return "redirect:/";
    }

    @RequestMapping(path ="/products", method=RequestMethod.GET)
    public String getAllProducts(Model model){
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    @RequestMapping(path ="/products/edit/{id}", method=RequestMethod.GET)
    public String editProduct(@PathVariable(value="id") String id, Model model){
        model.addAttribute("product", productRepository.getOne(id));
        return "edit";
    }

    @RequestMapping(path ="/products/delete/{id}", method=RequestMethod.GET)
    public String deleteProduct(@PathVariable(value="id") String id){
        productRepository.deleteById(id);
        return "redirect:/products";
    }
}
