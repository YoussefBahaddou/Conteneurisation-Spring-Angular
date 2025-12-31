package com.youssef.smarthome.repository;

import com.youssef.smarthome.entity.SmartDevice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartDeviceRepository extends JpaRepository<SmartDevice,Long> {
}

