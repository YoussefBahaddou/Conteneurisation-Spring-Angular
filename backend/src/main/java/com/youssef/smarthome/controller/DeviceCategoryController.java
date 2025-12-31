package com.youssef.smarthome.controller;

import com.youssef.smarthome.entity.DeviceCategory;
import com.youssef.smarthome.service.DeviceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/controller/DeviceCategory")
@CrossOrigin
public class DeviceCategoryController {


    @Autowired
    private DeviceCategoryService DeviceCategoryService;

    @GetMapping("/")
    public List<DeviceCategory> findAll() {
        return DeviceCategoryService.findAll();
    }

    @PostMapping("/")
    public DeviceCategory save(@RequestBody DeviceCategory DeviceCategory) {
        return DeviceCategoryService.save(DeviceCategory);
    }


    @GetMapping("/id/{id}")
    public Optional<DeviceCategory> findById(@PathVariable Long id) {
        return DeviceCategoryService.findById(id);
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        DeviceCategoryService.deleteById(id);
    }


    @PutMapping("/id/{id}")
    public void update(@PathVariable Long id,@RequestBody DeviceCategory catInfo) {
        DeviceCategoryService.update(id, catInfo);
    }


}

