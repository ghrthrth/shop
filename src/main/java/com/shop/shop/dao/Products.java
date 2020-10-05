package com.shop.shop.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Products")
@Getter
@Setter
@NoArgsConstructor
public class Products {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "names")
    private String names;
    @Column(name = "price")
    private int price;

    public Products(int id, String names, int price) {
        this.id = id;
        this.names = names;
        this.price = price;
    }
}
