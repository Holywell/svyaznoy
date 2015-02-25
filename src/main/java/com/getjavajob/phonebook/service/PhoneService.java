package com.getjavajob.phonebook.service;

import com.getjavajob.phonebook.dao.Page;
import com.getjavajob.phonebook.domain.Phone;

import java.util.List;


public interface PhoneService {

    Page<Phone> save(List<Phone> numbers);

    Page<Phone> getPage(int page, int size);

}
