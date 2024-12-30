package com.heima.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.heima.result.Result;
import com.heima.model.YourData;

@RestController
public class YourController {
    
    @GetMapping("/your-endpoint")
    public Result<YourData> yourMethod() {
        YourData data = new YourData();
        data.setName("Test Name");
        data.setDescription("Test Description");
        return Result.success(data);
    }
} 