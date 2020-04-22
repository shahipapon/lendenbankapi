package com.devignites.lendenbankapi;

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
		SpringApplication.run(LendenbankapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		bank_info bankinfo = repository.findBybankno("b111p1");

		//logger.info("find By bankno =>> {}", bankinfo);
		//logger.info("bankno pin =>> {} {}", repository.findBybankpinAndbankno("1234","b111k1"));
		//logger.info("the update info {}", service.getInfo());



		//update
		//logger.info("update 2 {}", repository.update(new bankInfo(2, "b2222", "1234", (double) 2000.98)));



	}

}
