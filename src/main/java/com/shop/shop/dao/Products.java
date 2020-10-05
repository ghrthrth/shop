package com.shop.shop.dao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
@Getter
@Setter
public class Products {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "names")
    private String names;
    @Column(name = "price")
    private int price;
}
