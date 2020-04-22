package com.devignites.lendenbankapi.repository;

import com.devignites.lendenbankapi.entity.bank_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface bank_info_Repository extends JpaRepository<bank_info, Integer> {

    // custom jpa query select * from table where bankno=...
    //findBy--- will match table column
    bank_info findBybankno(String name);

  // bank_info findBybankpinAndbankno(String pass, String no);

    @Query("SELECT t FROM bank_info t WHERE t.bankpin = ?1 AND t.bankno = ?2")
    bank_info findBybankpinAndbankno(String pass, String no);

}
