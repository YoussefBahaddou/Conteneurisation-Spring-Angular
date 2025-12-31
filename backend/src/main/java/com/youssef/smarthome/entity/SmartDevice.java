package com.youssef.smarthome.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SmartDevice {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String label;
    private String description;
    private boolean state;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String photo;

    @ManyToOne
    private DeviceCategory DeviceCategory;


}

