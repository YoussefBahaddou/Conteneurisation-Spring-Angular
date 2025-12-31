package com.youssef.smarthome.service;

import com.youssef.smarthome.entity.SmartDevice;
import com.youssef.smarthome.entity.DeviceCategory;
import com.youssef.smarthome.repository.DeviceCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceCategoryService {

    @Autowired
    private DeviceCategoryRepository DeviceCategoryRepository;

    public List<DeviceCategory> findAll() {
        return DeviceCategoryRepository.findAll();
    }

    public DeviceCategory  save (DeviceCategory DeviceCategory) {
        return DeviceCategoryRepository.save(DeviceCategory);
    }

    public Optional<DeviceCategory> findById(Long id) {
        return DeviceCategoryRepository.findById(id);
    }

    public void deleteById(Long id) {
        DeviceCategoryRepository.deleteById(id);
    }

    public void update(Long id, DeviceCategory catInfo) {
        DeviceCategory DeviceCategory=DeviceCategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("cat not found with id " + id));
        DeviceCategory.setLabel(catInfo.getLabel());
        DeviceCategoryRepository.save(DeviceCategory);
    }

}

