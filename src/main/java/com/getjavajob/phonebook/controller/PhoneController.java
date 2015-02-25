package com.getjavajob.phonebook.controller;

import com.getjavajob.phonebook.dao.Page;
import com.getjavajob.phonebook.domain.Phone;
import com.getjavajob.phonebook.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        Page page = phoneService.getPage(1, 10);
        model.addAttribute("page", page);
        return "index";
    }

    @RequestMapping(value = "/getPage", method = RequestMethod.POST)
    public String getPage(@RequestParam(defaultValue = "1", value = "id", required = false) int page,
                          @RequestParam(defaultValue = "10", value = "size", required = false) int size, Model model) {
        Page phonePage = phoneService.getPage(page, size);
        model.addAttribute("page", phonePage);
        return "page";
    }


    @RequestMapping(value = "/savePhone", method = RequestMethod.POST)
    public String save(@RequestBody List<Phone> phones) {

        phoneService.save(phones);

        return "page";
    }
}