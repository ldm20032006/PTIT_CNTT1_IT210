package org.example.session01.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SystemConfig {
    @Value("Cyber Center Hà Nội")
    private String branchName;

    @Value("08:00 - 20:00")
    private String openingHour;

    public void display() {
        System.out.printf("Tên chi nhánh: %s\n", branchName);
        System.out.printf("Giờ mở cửa: %s\n", openingHour);
    }
}
