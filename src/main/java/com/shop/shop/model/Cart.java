package com.shop.shop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cart")
@Getter @Setter
public class Cart {
    @Column(name = "general_price")
    private int general_price;

    @Column(name = "names")
    private String names;

    @Column(name="quantity_products")
    private int quantity_products;

    @Id
    @Column(name= "id_products")
    private int id;

}
