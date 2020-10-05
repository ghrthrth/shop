package com.shop.shop.dao;

import com.shop.shop.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ProductsDaoImp implements ProductsDAO{

    @Override
    @Transactional
    public void addProducts(Products products) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.save(products);
        session.close();
    }

    @Override
    public List<Products> listProducts() {
        List<Products> products = (List<Products>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createSQLQuery("from Products").list();
        return products;
    }
}
