package com.restaurant.bai4.controller;

import com.restaurant.bai4.model.DishB4;
import com.restaurant.bai4.service.AdminDishLayoutService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/bai4")
public class AdminDishLayoutController {
    private final AdminDishLayoutService adminDishLayoutService;

    public AdminDishLayoutController(AdminDishLayoutService adminDishLayoutService) {
        this.adminDishLayoutService = adminDishLayoutService;
    }

    @GetMapping
    public String dishList(Model model) {
        model.addAttribute("dishes", adminDishLayoutService.findAll());
        return "templates/bai4/dish-list";
    }

    @GetMapping("/detail/{id}")
    public String dishDetail(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        Optional<DishB4> dish = adminDishLayoutService.findById(id);
        if (dish.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Khong tim thay mon an yeu cau!");
            return "redirect:/bai4";
        }
        model.addAttribute("dish", dish.get());
        return "templates/bai4/dish-detail";
    }
}
