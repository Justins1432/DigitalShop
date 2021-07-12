package com.example.digitalshop.products;

public class CreditCard {
    public String idCreditCard, nameCreditCard, costCreditCard, quantityCreditCard, descriptionCreditCard;

    public CreditCard(){}

    public CreditCard(String idCreditCard, String nameCreditCard, String costCreditCard,
                      String quantityCreditCard, String descriptionCreditCard){
        this.idCreditCard = idCreditCard;
        this.nameCreditCard = nameCreditCard;
        this.costCreditCard = costCreditCard;
        this.quantityCreditCard = quantityCreditCard;
        this.descriptionCreditCard = descriptionCreditCard;
    }
}
