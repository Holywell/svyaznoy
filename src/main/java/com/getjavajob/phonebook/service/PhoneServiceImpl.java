package com.getjavajob.phonebook.service;

import com.getjavajob.phonebook.dao.Page;
import com.getjavajob.phonebook.dao.PhoneDao;
import com.getjavajob.phonebook.domain.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Iterator;
import java.util.List;


@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneDao phoneDao;

    @Override
    @Transactional
    public Page<Phone> save(List<Phone> numbers) {

        Iterator<Phone> iter = numbers.iterator();

        while (iter.hasNext()) {
            Phone elem = iter.next();
            if (!elem.getNumber().matches("7\\d{10}")) {
                iter.remove();
            }
        }

        phoneDao.save(numbers);

        return phoneDao.getPage(1, 10);
    }

    @Override
    @Transactional
    public Page<Phone> getPage(int page, int size) {
        return phoneDao.getPage(page, size);
    }

}
