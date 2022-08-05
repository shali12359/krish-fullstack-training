package com.fuelapp.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "allocation")
public class Allocation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int allocateId;
    int orderId;

    public int getAllocateId() {
        return allocateId;
    }

    public void setAllocateId(int allocateId) {
        this.allocateId = allocateId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
