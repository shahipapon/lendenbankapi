package com.devignites.lendenbankapi.service;

import com.devignites.lendenbankapi.cryption.bcrypt;
import com.devignites.lendenbankapi.entity.bank_info;
import com.devignites.lendenbankapi.errorhandle.error;
import com.devignites.lendenbankapi.repository.bank_info_Repository;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bank_info_Service {

    private Logger logger = LoggerFactory.getLogger((this.getClass()));
    private bcrypt bbb = new bcrypt();

    @Autowired
    private bank_info_Repository repository;

    //Matching Encrypted and Plain Text Password in Bcrypt

    ///bcrpyt

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
        //custom query. The prefix should "findBy" postfix should "col nam"e from table.
        // But for custom query we need add method to repository.
        return repository.findBybankno(name);
    }

    //validate bank user
    public bank_info getInfoByNameAndPass(String pass, String no) {
        //custom query. The prefix should "findBy" postfix should "col nam"e from table.
        // But for custom query we need add method to repository.
        return repository.findBybankpinAndbankno(pass, no);
    }

    //save
    public bank_info saveInfo(bank_info bankInfoObj) {
        bankInfoObj.setBankpin(bbb.hashPassword(bankInfoObj.getBankpin()));
        return repository.save(bankInfoObj);
    }

    //update bank info //need id
    public bank_info update(bank_info bankInfoObj) {

        bank_info existaccount = repository.findById(bankInfoObj.getId()).orElse(null); //check is there anything or not.
        existaccount.setBankmoney(bankInfoObj.getBankmoney());
        return repository.save(existaccount);
    }

    //save list
    public List<bank_info> saveAll(List<bank_info> bankInfoObjs) {
        return repository.saveAll(bankInfoObjs);
    }

    //update
    public String payment(bank_info bankInfoObj) {
        bank_info validate = new bank_info();

        String result = "";
//        bank_info senderInfo = repository.findById(bankInfoObj.getId()).orElse(null); //check is there anything or not.

        ///validate encrytion
      try {
           validate = repository.findBybankno(bankInfoObj.getBankno());
      } catch (Exception e) {
        //  e.printStackTrace();
          result = "No Bank found";
      }
      String hashedPass = validate.getBankpin();
        String checkuser = validate.getBankno();
        boolean match = bbb.checkPass(bankInfoObj.getBankpin(), hashedPass);
        //System.out.println("cccccccccccccc"+match);
        if (match) {
            //  bank_info senderInfo = repository.findBybankpinAndbankno(bankInfoObj.getBankpin(), bankInfoObj.getBankno());
            bank_info senderInfo = validate;

            // getreceiver info from request (bankno only)
            //get receiver data from database by name
            bank_info receiverInfo = repository.findBybankno(bankInfoObj.getReceiveraccount());

//        logger.info("Sender's Info >>  {}",senderInfo);
//        logger.info("Receiver's Info >>  {}",receiverInfo);

            Double senderCurrentBalance = Double.valueOf(senderInfo.getBankmoney().toString());
            Double receiverCurrentBalance = Double.valueOf(receiverInfo.getBankmoney().toString());
            Double withdraBalance = Double.valueOf(bankInfoObj.getTransaction().toString());

            if ((senderCurrentBalance - withdraBalance) < 0) {
                result = "Not Enough Balance. \nCurrent balance is: " + receiverCurrentBalance.toString();
            } else {
                //sender bank update
                //senderInfo //contain  sender data
                //set information for update ..need id
                senderInfo.setId(senderInfo.getId());
                senderInfo.setBankmoney(senderCurrentBalance - withdraBalance);
                repository.save(senderInfo);

                //receiver bank update
                // bankInfoObj //contain receiver data
                //set information ..need id
                receiverInfo.setId(receiverInfo.getId());
                receiverInfo.setBankmoney(receiverCurrentBalance + withdraBalance);
                repository.save(receiverInfo);

                result = "Success";
            }

        } else {
            result = "Password Not Match.";
        }

        //confirm user
        //Get sender data from request

        // calculate();
//        //fill as your need
//        senderInfo.setBankmoney(bankInfoObj.getBankmoney());
        //return repository.save(senderInfo);
        return result;
    }


    void calculate() {
    }

}

