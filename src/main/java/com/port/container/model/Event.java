package com.port.container.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Cliente é Obrigatório")
    @Size(max = 30, message = "Maximo 30 caracteres")
    private String client;

    @NotBlank(message = "Obrigatório informar o número do container")
    private String numberCntr;

    @NotBlank(message = "Obrigatório informar o tipo")
    private String type;

    @NotBlank(message = "Obrigatório informar o status")
    private String status;

    @NotNull(message = "Obrigatório selecionar a categoria")
    private Category category;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
