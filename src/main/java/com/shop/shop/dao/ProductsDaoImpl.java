package com.shop.shop.dao;

import com.shop.shop.HibernateSessionFactoryUtil;
import org.hibernate.Session;

import java.util.List;

public class ProductsDaoImpl {


    public static void addProducts(Products products) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.save(products);
        session.close();
    }
    public List<Products> listProducts() {
        List<Products> products = (List<Products>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createSQLQuery("from Products").list();
        return products;
    }
}
