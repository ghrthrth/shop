package com.shop.shop.dao;


import com.shop.shop.model.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDaoImpl implements CartDao{
    private static final Logger logger = LoggerFactory.getLogger(CartDaoImpl.class);
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Cart> listCart() {
        return null;
    }

    @Override
    public void addCart(Cart cart) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(cart);
        logger.info("add is ok");
    }

    @Override
    public void updateCart(Cart cart) {
    Session session = this.sessionFactory.getCurrentSession();
    session.update(cart);
    logger.info("update ok");

    }

    @Override
    public void removeCart(Cart cart) {
        Session session= this.sessionFactory.getCurrentSession();
        session.remove(cart);
        logger.info("remove is ok");
    }

    @Override
    public void getCartById(int id) {
    Session session = this.sessionFactory.getCurrentSession();
    Cart cart = (Cart) session.load(Cart.class, new Integer(id));
    if (cart!=null){
        session.delete(cart);
    }logger.info("it ok");
    }
}
