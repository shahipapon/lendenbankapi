package com.devignites.lendenbankapi;

import com.devignites.lendenbankapi.cryption.bcrypt;
import com.devignites.lendenbankapi.entity.bank_info;
import com.devignites.lendenbankapi.repository.bank_info_Repository;
import com.devignites.lendenbankapi.service.bank_info_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LendenbankapiApplication implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger((this.getClass()));

    @Autowired
    private bank_info_Repository repository;

    public static void main(String[] args) {
		bcrypt bbb = new bcrypt();

		SpringApplication.run(LendenbankapiApplication.class, args);
//		System.out.println("main... testing");
////		for  (int i =0;i<10;i++){
////			bbb.hashPassword("1234");
////		}
//
//
//		bbb.checkPass("$2a$10$qWLsk76RkyH3AX7RQ/M70.SIWVd0Dm8lbay1ykhIxweJxG6HxGSP","$2a$10$jsgoVvmo6PJbjRvfqGtBzO6HGCvv4VnbtMCmm/XaVbbut9omUR29O");
   }

    @Override
    public void run(String... args) throws Exception {


        //logger.info("find By bankno =>> {}", bankinfo);
        //logger.info("bankno pin =>> {} {}", repository.findBybankpinAndbankno("1234","b111k1"));
        //logger.info("the update info {}", service.getInfo());

        //update
        //logger.info("update 2 {}", repository.update(new bankInfo(2, "b2222", "1234", (double) 2000.98)));

        //String password = BCrypt.hashpw("password", BCrypt.gensalt(12));

       // logger.info("Your hash pass is: " + bcrypt.hashPassword("papon"));
       // String hash = "$2a$10$/Pq73lQ5qN6ugwdSQB4l7";

        //logger.info("check resullt >> {}",bcrypt.checkPass("papon",hash));
        // $2a$10$/Pq73lQ5qN6ugwdSQB4l7
        //$2a$10$FN0.XpkiytKNsItV3mNqJ.RQXHT8mHmEaLFAzsoGKU.Yyv8.9VZa6
		//logger.info(bank_info_Service.);
    }

}
