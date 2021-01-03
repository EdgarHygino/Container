package com.port.container.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String client;
    private String numberCntr;
    private String type;
    private String status;
    private String category;

    @ManyToOne
    private Move move;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getNumberCntr() {
        return numberCntr;
    }

    public void setNumberCntr(String numberCntr) {
        this.numberCntr = numberCntr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
