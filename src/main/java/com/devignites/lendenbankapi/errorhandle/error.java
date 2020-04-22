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

    public String myerror() {
        return "ErrorLog{" +
                "error_massage='" + "Not Enough Balance" + '\'' +

                '}';
    }

}
