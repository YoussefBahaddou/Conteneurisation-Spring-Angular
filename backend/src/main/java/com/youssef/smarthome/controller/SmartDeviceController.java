package com.youssef.smarthome.controller;

import com.youssef.smarthome.entity.SmartDevice;
import com.youssef.smarthome.service.SmartDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/controller/SmartDevice")
@CrossOrigin
public class SmartDeviceController {


    @Autowired
    private SmartDeviceService SmartDeviceService;

    @PostMapping("/")
    public SmartDevice save(@RequestBody SmartDevice SmartDevice) {
        return SmartDeviceService.save(SmartDevice);
    }

    @GetMapping("/id/{id}")
    public Optional<SmartDevice> findById(@PathVariable Long id) {
        return SmartDeviceService.findById(id);
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        SmartDeviceService.deleteById(id);
    }

    @GetMapping("/")
    public List<SmartDevice> findAll() {
        return SmartDeviceService.findAll();
    }


    @PutMapping("/id/{id}")
    public void update(@PathVariable Long id, @RequestBody SmartDevice appInfo) {
        SmartDeviceService.update(id, appInfo);
    }


    @GetMapping("/update/state/{state}")
    public void updateAll(@PathVariable boolean state) {
        SmartDeviceService.updateAll(state);
    }

}

