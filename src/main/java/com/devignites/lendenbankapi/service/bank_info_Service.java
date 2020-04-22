package com.devignites.lendenbankapi.service;

import com.devignites.lendenbankapi.entity.bank_info;
import com.devignites.lendenbankapi.errorhandle.error;
import com.devignites.lendenbankapi.repository.bank_info_Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bank_info_Service {

    private Logger logger = LoggerFactory.getLogger((this.getClass()));
    private error errorobj;

    private String x;

    @Autowired
    private bank_info_Repository repository;

    //get all data
    public List<bank_info> getInfo() {
        return repository.findAll();
    }

    //get data by id
    public bank_info getInfoById(int id) {
        // this will return optional. if id found return result else null.
        //or use the optional return type.
        return repository.findById(id).orElse(null);
    }

    //get data by bankname
    public bank_info getInfoByName(String name) {
        // this will return optional. if id found return result else null.
        //or use the optional return type.

        //custom query. The prefix should "findBy" postfix should "col nam"e from table.
        // But for custom query we need add method to repository.
        return repository.findBybankno(name);
    }

    public bank_info getInfoByNameAndPass(String pass, String no) {
        // this will return optional. if id found return result else null.
        //or use the optional return type.

        //custom query. The prefix should "findBy" postfix should "col nam"e from table.
        // But for custom query we need add method to repository.
        return repository.findBybankpinAndbankno(pass, no);
    }

    //save
    public bank_info saveInfo(bank_info bankInfoObj) {
        return repository.save(bankInfoObj);
    }

    //save all
    public List<bank_info> saveAll(List<bank_info> bankInfoObjs) {
        return repository.saveAll(bankInfoObjs);
    }

    //update
    public String updateInfo(bank_info bankInfoObj) {

//        bank_info existingInfo = repository.findById(bankInfoObj.getId()).orElse(null); //check is there anything or not.

        bank_info existingInfo = repository.findBybankpinAndbankno(bankInfoObj.getBankpin(), bankInfoObj.getBankno());

       Double currentBalance = Double.valueOf(existingInfo.getBankmoney().toString());
       Double withdraBalance = Double.valueOf(bankInfoObj.getBankmoney().toString());

        System.out.println("currentBalance " + currentBalance);
        System.out.println("withdraBalance " + withdraBalance);

        //System.out.println("exits account 2>> " + existingInfo1);

//        System.out.println("Orginal account>> " + existingInfo.getBankmoney().toString());
//        //Orginal account bank_info(id=1, bankmoney=900.99, bankno=b1111, bankpin=1234, transactionaccount=gsd94d83b1c1cc8248994d83b1)
//        // String xx = bankInfoObj.getBankmoney().toString();
//        System.out.println("abal deposit : " + bankInfoObj.getBankmoney().toString());
//        System.out.println("abal transiction : " + transiction);
        calculate();
//        //fill as your need
//        existingInfo.setBankmoney(bankInfoObj.getBankmoney());
        //return repository.save(existingInfo);
        System.out.println(errorobj.getError_massage());
        return errorobj.getError_massage();
    }

    void calculate() {
        x = "DSadadsa";
//        System.out.println("hello lenden "+x);
//        x="dasda";
//        System.out.println("hello lenden "+x);

        x = "DSadadsa";
        System.out.println("hello lenden " + x);
        x = "dasda";
        System.out.println("hello lenden " + x);
    }

}

