package com.youssef.smarthome.service;

import com.youssef.smarthome.entity.SmartDevice;
import com.youssef.smarthome.entity.DeviceCategory;
import com.youssef.smarthome.repository.SmartDeviceRepository;
import com.youssef.smarthome.repository.DeviceCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SmartDeviceService {


    @Autowired
    private SmartDeviceRepository SmartDeviceRepository;
    @Autowired
    private DeviceCategoryRepository DeviceCategoryRepository;

    public SmartDevice save(SmartDevice SmartDevice) {
        Optional<DeviceCategory> DeviceCategory = DeviceCategoryRepository.findById(SmartDevice.getDeviceCategory().getId());
        if (DeviceCategory.isEmpty()) {
            throw new RuntimeException("Category not found.");
        }
        SmartDevice.setDeviceCategory(DeviceCategory.get());
        return SmartDeviceRepository.save(SmartDevice);
    }

    public Optional<SmartDevice> findById(Long id) {
        return SmartDeviceRepository.findById(id);
    }

    public void deleteById(Long id) {
        SmartDeviceRepository.deleteById(id);
    }

    public List<SmartDevice> findAll() {
        return SmartDeviceRepository.findAll();
    }

    public void update(Long id, SmartDevice appInfo) {
        SmartDevice SmartDevice = SmartDeviceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("app not found with id " + id));
        SmartDevice.setState(appInfo.isState());
        SmartDeviceRepository.save(SmartDevice);
    }

    public void updateAll(boolean state) {
        List<SmartDevice> SmartDeviceList = SmartDeviceRepository.findAll();
        SmartDeviceList.forEach(s -> s.setState(state));
        SmartDeviceRepository.saveAll(SmartDeviceList);
    }
}

