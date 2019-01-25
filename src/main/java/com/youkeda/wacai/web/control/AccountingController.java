package com.youkeda.wacai.web.control;

import com.youkeda.wacai.web.model.Accounting;
import com.youkeda.wacai.web.model.AccountingRecord;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AccountingController {

    private static List<AccountingRecord> records = new ArrayList<>();

    @RequestMapping(path = "/record")
    public String record(AccountingRecord record){

        Date time = new Date();
        record.setTime(time);

        records.add(record);
        String temp = "";
        for (AccountingRecord index:records) {
            temp =temp+"记录："+"发生日期："+index.getCreateTime()+
                       " 金额："+index.getAmount()+
                       " 记账类型："+index.getType()+
                       " 记账科目："+index.getCategory()+
                       " 记账时间："+index.getTime()+"<br>";
        }
        return temp;
    }

    @RequestMapping(path = "/search")
    public String search(@RequestParam("amount") int amount){

        StringBuilder sb = new StringBuilder();

        List<AccountingRecord> filterd = records.stream().filter(record->record.getAmount()>amount).collect(Collectors.toList());

        for (AccountingRecord index : filterd) {
            sb.append("发生时间:"+index.getCreateTime());
            sb.append(" 金额:"+index.getAmount());
            sb.append(" 类别:"+index.getType());
            sb.append(" 科目:"+index.getCategory());
            sb.append(" 创建时间:"+index.getTime());
            sb.append("<br>");

        }
        return sb.toString();
    }

    @RequestMapping(path = "/accounting" )
    public Accounting accounting(Accounting accounting){

        int result = (accounting.getCash()+accounting.getIncome())-
                (accounting.getRent()+accounting.getCharges()+accounting.getEat()+accounting.getTreat()+accounting.getKtv());
        accounting.setBalance(result);
        return accounting;
    }
}
