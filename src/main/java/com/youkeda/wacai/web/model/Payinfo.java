package com.youkeda.wacai.web.model;

public class Payinfo {
    /**
     * 支付类型
     */
    private PayType PayType;

    /**
     * 账单日
     */
    private int billingDate;

    /**
     * 还款日
     */
    private int dueDate;

    /**
     * 金额
     */
    private double amount;

    /**
     * 分期数
     */
    private int stagesCount;

    public com.youkeda.wacai.web.model.PayType getPayType() {
        return PayType;
    }

    public void setPayType(com.youkeda.wacai.web.model.PayType payType) {
        PayType = payType;
    }

    public int getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(int billingDate) {
        this.billingDate = billingDate;
    }

    public int getDueDate() {
        return dueDate;
    }

    public void setDueDate(int dueDate) {
        this.dueDate = dueDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getStagesCount() {
        return stagesCount;
    }

    public void setStagesCount(int stagesCount) {
        this.stagesCount = stagesCount;
    }
}
