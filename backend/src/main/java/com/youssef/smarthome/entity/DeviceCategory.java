package com.youssef.smarthome.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeviceCategory {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;

    @OneToMany(targetEntity = SmartDevice.class , mappedBy = "DeviceCategory", fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"DeviceCategory"})
    List<SmartDevice> SmartDeviceList;
}

