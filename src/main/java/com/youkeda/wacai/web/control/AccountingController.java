package com.youkeda.wacai.web.control;

import com.youkeda.wacai.web.model.Accounting;
import com.youkeda.wacai.web.model.AccountingRecord;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class AccountingController {

    List<AccountingRecord> records = new ArrayList<>();

    @RequestMapping(path = "/record")
    public String record(AccountingRecord record){

        Date time = new Date();
        record.setTime(time);

        records.add(record);
        String temp = "";
        for (int index=0;index<records.size();index++) {
             temp +="发生日期："+record.getCreateTime()+"<br>"+" 金额："+record.getAmount()+"<br>"+" 记账类型："+record.getType()+"<br>"+" 记账科目："+record.getCategory()+"<br>"+" 记账时间："+record.getTime()+"<br>";
        }
        return temp;
    }

    @RequestMapping(path = "/accounting" )
    public Accounting accounting(Accounting accounting){

        int result = (accounting.getCash()+accounting.getIncome())-(accounting.getRent()+accounting.getCharges()+accounting.getEat()+accounting.getTreat()+accounting.getKtv());
        accounting.setBalance(result);
        return accounting;
    }
}
