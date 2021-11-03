package com.kove.pcstore.data;

import com.kove.pcstore.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {
    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public void saveUserWithAuthorities(User user) {
        em.persist(user);
        em.createNativeQuery("INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES ( ?1 , 'ROLE_USER')")
                .setParameter(1, user.getUsername())
                .executeUpdate();
    }
}