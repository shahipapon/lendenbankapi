package com.devignites.lendenbankapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class bank_info {

    @Id
    @GeneratedValue
    private int id;

    private Double bankmoney;
    private String bankno;
    private String bankpin;
    private String transaction;
    private String receiveraccount;


}
