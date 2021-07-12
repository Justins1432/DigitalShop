package com.example.digitalshop.users;

import java.util.stream.Stream;

public class Seller {
    private String sellerEmail, sellerPass, sellerSurname, sellerName, sellerPatron, sellerNumberPhone,
        sellerPayPal;

    public Seller(){}

    public Seller(String sellerEmail, String sellerPass, String sellerSurname, String sellerName,
                  String sellerPatron, String sellerNumberPhone, String sellerPayPal){
        this.sellerEmail = sellerEmail;
        this.sellerPass = sellerPass;
        this.sellerSurname = sellerSurname;
        this.sellerName = sellerName;
        this.sellerPatron = sellerPatron;
        this.sellerNumberPhone = sellerNumberPhone;
        this.sellerPayPal = sellerPayPal;
    }

    public String getSellerEmail(){return sellerEmail;}
    public void setSellerEmail(String sellerEmail){this.sellerEmail = sellerEmail;}

    public String getSellerPass(){return sellerPass;}
    public void setSellerPass(String sellerPass){this.sellerPass = sellerPass;}

    public String getSellerSurname(){return sellerSurname;}
    public void setSellerSurname(String sellerSurname){this.sellerSurname = sellerSurname;}

    public String getSellerName(){return sellerName;}
    public void setSellerName(String sellerName){this.sellerName = sellerName;}

    public String getSellerPatron(){return sellerPatron;}
    public void setSellerPatron(String sellerPatron){this.sellerPatron = sellerPatron;}

    public String getSellerNumberPhone(){return sellerNumberPhone;}
    public void setSellerNumberPhone(String sellerNumberPhone){this.sellerNumberPhone = sellerNumberPhone;}

    public String getSellerPayPal(){return sellerPayPal;}
    public void setSellerPayPal(String sellerPayPal){this.sellerPayPal = sellerPayPal;}

}
