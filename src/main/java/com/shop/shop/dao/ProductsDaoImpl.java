package com.shop.shop.dao;

import com.shop.shop.model.Products;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProductsDaoImpl implements ProductsDao{
    private static final Logger logger = LoggerFactory.getLogger(CartDaoImpl.class);
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addProducts(Products products) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(products);
        logger.info("add is ok");
    }

    @Override
    public void removeProducts(Products products) {
        Session session= this.sessionFactory.getCurrentSession();
        session.remove(products);
        logger.info("remove is ok");
    }

    @Override
    public void updateProducts(Products products) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(products);
        logger.info("update ok");
    }

    @Override
    public List<Products> listProducts() {
        return null;
    }

    @Override
    public void getProductsById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Products products = (Products) session.load(Products.class, new Integer(id));
        if (products!=null){
            session.delete(products);
        }logger.info("it ok");
    }
}
