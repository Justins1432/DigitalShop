package com.example.digitalshop.products;

public class SocialNetwork {
    public String idSocNet, nameSocNet, costSocNet, quantitySocNet, descriptionSocNet;

    public SocialNetwork(){}

    public SocialNetwork(String idSocNet, String nameSocNet, String costSocNet,
                         String quantitySocNet, String descriptionSocNet){
        this.idSocNet = idSocNet;
        this.nameSocNet = nameSocNet;
        this.costSocNet = costSocNet;
        this.quantitySocNet = quantitySocNet;
        this.descriptionSocNet = descriptionSocNet;
    }
}
