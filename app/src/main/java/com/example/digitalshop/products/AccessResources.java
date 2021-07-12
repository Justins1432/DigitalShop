package com.example.digitalshop.products;

public class AccessResources {
    public String idAccessRes, nameAccessRes, costAccessRes, quantityAccessRes, descriptionAccessRes;

    public AccessResources(){}

    public AccessResources(String idAccessRes, String nameAccessRes, String costAccessRes,
                           String quantityAccessRes, String descriptionAccessRes){
        this.idAccessRes = idAccessRes;
        this.nameAccessRes = nameAccessRes;
        this.costAccessRes = costAccessRes;
        this.quantityAccessRes = quantityAccessRes;
        this.descriptionAccessRes = descriptionAccessRes;
    }
}
