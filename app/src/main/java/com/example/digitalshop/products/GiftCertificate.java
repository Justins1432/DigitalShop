package com.example.digitalshop.products;

public class GiftCertificate {
    public String idGifSertif, nameGiftSertif, costGiftSertif, quantityGiftSertif, descriptionGiftSertif;

    public GiftCertificate(){}

    public GiftCertificate(String idGifSertif, String nameGiftSertif, String costGiftSertif,
                           String quantityGiftSertif, String descriptionGiftSertif){
        this.idGifSertif = idGifSertif;
        this.nameGiftSertif = nameGiftSertif;
        this.costGiftSertif = costGiftSertif;
        this.quantityGiftSertif = quantityGiftSertif;
        this.descriptionGiftSertif = descriptionGiftSertif;
    }
}
