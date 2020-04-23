package com.devignites.lendenbankapi.controller;

import com.devignites.lendenbankapi.entity.bank_info;
import com.devignites.lendenbankapi.service.bank_info_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class bank_info_controller {
    @Autowired
    private bank_info_Service service;

    private Logger logger = LoggerFactory.getLogger((this.getClass()));

    @GetMapping("/")
    public String dummy() {
        return "Oops! Missing Something...";
    }

    @GetMapping("/giveall")
    public List<bank_info> getAll() {
        return service.getInfo();
    }

    @GetMapping("/info/{id}")
    public bank_info getInfoById(@PathVariable int id) {
        return service.getInfoById(id);
    }

    @GetMapping("/bank/{name}")
    public bank_info getInfoByName(@PathVariable String name) {
        return service.getInfoByName(name);
    }

    @PostMapping("/addbank")
    public bank_info addnewbank(@RequestBody bank_info bank_info_obj) {
        return service.saveInfo(bank_info_obj);

    }


    @PutMapping("/update")
    public bank_info update(@RequestBody bank_info bank_info_obj) {
        return service.update(bank_info_obj);
    }

    @PutMapping("/payment")
    public String payment(@RequestBody bank_info bank_info_obj) {
        return service.payment(bank_info_obj);
    }

}
