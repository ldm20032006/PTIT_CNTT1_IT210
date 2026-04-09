package com.restaurant.bai3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class Bai3Controller {
    // Cách A: số 5 nằm trong URI Path (đường dẫn), là một phần của tài nguyên.
    // Cách B: số 5 nằm trong Query String (chuỗi truy vấn).
    // Em chọn cách A vì ID là định danh duy nhất của tài nguyên,
    // nên việc đặt nó trong URL path giúp API rõ ràng và chuẩn hơn.
    @GetMapping("/bai3/orders/{id}")
    public String orders(@PathVariable("id") long id) {
        return "Chi tiet don hang so " + id;
    }
}
