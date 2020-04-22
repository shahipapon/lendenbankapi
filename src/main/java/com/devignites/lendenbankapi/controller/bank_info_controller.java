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


//    public bank_info addpro(bank_info bank_info_obj){
//        return service.saveInfo(bank_info_obj);
//    }

    @GetMapping("/")
    public List<bank_info> getAll(){
        return service.getInfo();
    }

    @GetMapping("/info/{id}")
    public bank_info getInfoById(@PathVariable int id){
        return service.getInfoById(id);
    }

    @GetMapping("/bank/{name}")
    public bank_info getInfoByName(@PathVariable String name){
        return service.getInfoByName(name);
    }



    @PutMapping("/update")
    public String update(@RequestBody bank_info bank_info_obj){
        return service.updateInfo(bank_info_obj);
    }


}
