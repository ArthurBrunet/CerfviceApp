package com.onlinebank.Utils;

import com.onlinebank.Servlet.ServletProposition;

import java.time.LocalDate;
import java.time.Period;

public class Utils extends ServletProposition {

    public Integer findAge (String birthday) {
        String[] values = birthday.split("-", 0);
        LocalDate birthdate = LocalDate.of(Integer.parseInt(values[0]), Integer.parseInt(values[1]), Integer.parseInt(values[2]));
        LocalDate actualDate = LocalDate.now();
        Period difference = Period.between(birthdate, actualDate);
        return difference.getYears();
    }

}