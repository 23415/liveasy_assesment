package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Load {

    @Id
    private long id;
    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private String truckType;
    private long noOfTrucks;
    private long weight;
    private String comment;
    private Date date;
}


