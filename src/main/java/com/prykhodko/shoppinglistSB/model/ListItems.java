//////////////////////////////////////////////////////////////////////////
// ListItems model class has following fields:                          //
// id: Primary Key with Auto Increment                                  //
// item: The title of the item (NOT NULL field)                         //
// details: The details of the item(product) (NOT NULL field)           //
// amount: The amount of items that should be bought (NOT NULL field)   //
// price: The price of the item (NOT NULL field)                        //
//                                                                      //
//////////////////////////////////////////////////////////////////////////

package com.prykhodko.shoppinglistSB.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity //used to mark the class as a persistent Java class
@Table(name = "list") //used to provide the details of the table that this entity will be mapped to
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true) //is a Jackson annotation.
// Spring Boot uses Jackson for Serializing and Deserializing Java objects to and from JSON

public class ListItems implements Serializable {

    @Id //annotation is used to define the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //used to define the primary key generation strategy
    private Long id;

    @NotBlank //used to validate that the annotated field is not null or empty
    private String item;

    @NotBlank
    private String details;

    @NotNull
    private int amount;

    @NotNull
    private double price;

    @Column(nullable = false, updatable = false) //used to define the properties of the column that will be mapped to the annotated field
    @Temporal(TemporalType.TIMESTAMP) //used with java.util.Date and java.util.Calendar classes.
    // It converts the date and time values from Java Object to compatible database type and vice versa

    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
