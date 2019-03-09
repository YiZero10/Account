package com.youkeda.wacai.web.model;

public class CreditCard extends Payinfo{
    /**
     * 信用卡名称
     */
    private String name;

    /**
     * 信用卡卡号
     */
    private String cardNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
