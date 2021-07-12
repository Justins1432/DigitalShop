package com.example.digitalshop.products;

public class MobileConnection {
    public String idMobConnect, nameMobConnect, costMobConnect, quantityMobConnect, descriptionMobConnect;

    public MobileConnection(){}

    public MobileConnection(String idMobConnect, String nameMobConnect, String costMobConnect,
                            String quantityMobConnect, String descriptionMobConnect){
        this.idMobConnect = idMobConnect;
        this.nameMobConnect = nameMobConnect;
        this.costMobConnect = costMobConnect;
        this.quantityMobConnect = quantityMobConnect;
        this.descriptionMobConnect = descriptionMobConnect;
    }
}
