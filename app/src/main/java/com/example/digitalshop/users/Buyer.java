package com.example.digitalshop.users;

public class Buyer {
    private String emailBuyer, passwordBuyer, surnameBuyer, nameBuyer, patronBuyer, numberPhoneBuyer,
        debCardBuyer;

    public Buyer(){}

    public Buyer(String emailBuyer, String passwordBuyer, String surnameBuyer, String nameBuyer,
                 String patronBuyer, String numberPhoneBuyer, String debCardBuyer){
        this.emailBuyer = emailBuyer;
        this.passwordBuyer = passwordBuyer;
        this.surnameBuyer = surnameBuyer;
        this.nameBuyer = nameBuyer;
        this.patronBuyer = patronBuyer;
        this.numberPhoneBuyer = numberPhoneBuyer;
        this.debCardBuyer = debCardBuyer;
    }

    public String getEmailBuyer(){ return emailBuyer; }
    public void setEmailBuyer(String emailBuyer){ this.emailBuyer = emailBuyer; }

    public String getPasswordBuyer(){return passwordBuyer;}
    public void setPasswordBuyer(String passwordBuyer){this.passwordBuyer = passwordBuyer;}

    public String getSurnameBuyer(){return surnameBuyer;}
    public void setSurnameBuyer(String surnameBuyer){this.surnameBuyer = surnameBuyer;}

    public String getNameBuyer(){return nameBuyer;}
    public void setNameBuyer(String nameBuyer){this.nameBuyer = nameBuyer;}

    public String getPatronBuyer(){return patronBuyer;}
    public void setPatronBuyer(String patronBuyer){this.patronBuyer = patronBuyer;}

    public String getNumberPhoneBuyer(){return numberPhoneBuyer;}
    public void setNumberPhoneBuyer(String numberPhoneBuyer){this.numberPhoneBuyer = numberPhoneBuyer;}

    public String getDebCardBuyer(){return debCardBuyer;}
    public void setDebCardBuyer(String debCardBuyer){this.debCardBuyer = debCardBuyer;}
}
