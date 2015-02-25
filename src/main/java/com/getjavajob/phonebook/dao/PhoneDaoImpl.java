package com.getjavajob.phonebook.dao;

import com.getjavajob.phonebook.domain.Phone;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PhoneDaoImpl implements PhoneDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(List<Phone> numbers) {
        em.persist(numbers);
    }

    @Override
    public Page<Phone> getPage(int currPage, int size) {
        TypedQuery<Long> countQuery = em.createQuery("select count(p) from Phone p", Long.class);
        long count = countQuery.getSingleResult();
        TypedQuery<Phone> phoneQuery = em.createQuery("from Phone p", Phone.class);
        List<Phone> phones = phoneQuery.setFirstResult(currPage).setMaxResults(size).getResultList();

        return new Page<>(count, phones, 10);
    }

}