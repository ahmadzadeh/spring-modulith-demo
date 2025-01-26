package com.example.hex_modulith.orders.adapter.in.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @PostMapping("/order/modal")
    public String handleCheckout(@RequestParam("product") String productSku,
                                 @RequestParam String productName,
                                 @RequestParam int quantity, Model model) {
        model.addAttribute("productSku", productSku);
        model.addAttribute("productName", productName);
        model.addAttribute("quantity", quantity);
        return "order :: modalContent";
    }
}
