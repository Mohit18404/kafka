package com.example.kafka.jpa;

import com.example.kafka.dao.UserRegistration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/*
 * @author: mohit5.kumar
 * @created: 09/05/19
 */
@Repository
@Transactional
public class UserRegistrationJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    public UserRegistration findById(int id) {
        return entityManager.find(UserRegistration.class,id);
    }

    public UserRegistration update(UserRegistration userRegistration){
        return entityManager.merge(userRegistration);
    }

    public void insert(UserRegistration userRegistration){
        entityManager.persist(userRegistration);
    }
}
