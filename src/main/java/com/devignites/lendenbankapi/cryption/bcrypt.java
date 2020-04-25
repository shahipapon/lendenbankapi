package com.devignites.lendenbankapi.cryption;


import org.mindrot.jbcrypt.BCrypt;



public class bcrypt {

    //encryption
    public String hashPassword(String plainTextPassword) {
        String c= BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
        //System.out.println("hash is: "+c);
        return c ;
    }

    //Matching Encrypted and Plain Text Password in Bcrypt


    public boolean checkPass(String plainPassword, String hashedPassword) {
        if (BCrypt.checkpw(plainPassword, hashedPassword)){
             //System.out.println("The password matches.");
        return true;
        }

        else{
           // System.out.println("The password does not match.");
           return false;
        }

    }

}