package com.youkeda.wacai.web.service.impl;

import com.youkeda.wacai.web.model.FinanceInfo;
import com.youkeda.wacai.web.service.FinanceService;

import java.util.Date;

public class JdFinanceServiceImpl implements FinanceService {

    @Override
    public FinanceInfo invest(double amount, int days) {
        FinanceInfo financeInfo = new FinanceInfo();

        double income = amount*0.0295/365*days;

        financeInfo.setIncome(income);
        financeInfo.setStartTime(new Date());
        financeInfo.setAmount(amount);
        financeInfo.setDays(days);

        return financeInfo;
    }
}
