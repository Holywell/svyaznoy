package com.getjavajob.phonebook.dao;

import com.getjavajob.phonebook.domain.Phone;

import java.util.List;


public interface PhoneDao {
    void save(List<Phone> numbers);

    Page<Phone> getPage(int currPage, int size);
}
