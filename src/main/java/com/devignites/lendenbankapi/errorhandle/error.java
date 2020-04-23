package com.devignites.lendenbankapi.errorhandle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class error {
    private String error_massage = "{" +
            "error_massage='" + "Not Enough Balance" + '\'' +

            '}';

    private String bal = "{" + "error" + ": "+ "Not Enough Balance } " ;


    public String toString() {
        return "bankInfo{" +
                "bankNo='" + "bankNo" + '\'' +
                ", bankPin='" + "bankPin" + '\'' +
                ", bankMoney='" + "bankMoney" + '\'' +
                '}';
    }

}
