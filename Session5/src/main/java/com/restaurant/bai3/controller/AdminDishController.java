package com.restaurant.bai3.controller;

import com.restaurant.bai3.model.Dish;
import com.restaurant.bai3.service.AdminDishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/bai3")
public class AdminDishController {
    private final AdminDishService adminDishService;

    public AdminDishController(AdminDishService adminDishService) {
        this.adminDishService = adminDishService;
    }

    @GetMapping
    public String showDishList(Model model) {
        model.addAttribute("dishes", adminDishService.getAllDishes());
        return "dish-list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Dish> dishOptional = adminDishService.findById(id);
        if (dishOptional.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Không tìm thấy món ăn yêu cầu!");
            return "redirect:/bai3";
        }
        model.addAttribute("dish", dishOptional.get());
        return "edit-dish";
    }

    @PostMapping("/edit/{id}")
    public String updateDish(@PathVariable Integer id,
                             @ModelAttribute("dish") Dish dish,
                             RedirectAttributes redirectAttributes) {
        if (adminDishService.findById(id).isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Không tìm thấy món ăn yêu cầu!");
            return "redirect:/bai3";
        }

        adminDishService.updateDish(id, dish);
        redirectAttributes.addFlashAttribute("successMessage", "Cập nhật món ăn thành công!");
        return "redirect:/bai3";
    }
}
