package com.youkeda.wacai.web.control;

import com.youkeda.wacai.web.model.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AccountingController {

    private static List<AccountingRecord> records = new ArrayList<>();
    private static List<Payinfo> payinfos = new ArrayList<>();

    @PostConstruct
    public void init(){
        //初始化白条数据
        Payinfo baitiao = new Payinfo();
        baitiao.setPayType(PayType.baitiao);
        baitiao.setBillingDate(10);
        baitiao.setDueDate(20);
        payinfos.add(baitiao);

        //初始化花呗数据
        Payinfo huabei = new Payinfo();
        huabei.setPayType(PayType.huabei);
        huabei.setBillingDate(20);
        huabei.setDueDate(10);
        payinfos.add(huabei);

        //初始化信用卡数据
        CreditCard creditCard = new CreditCard();
        creditCard.setPayType(PayType.creditCard);
        creditCard.setBillingDate(5);
        creditCard.setDueDate(25);
        creditCard.setName("招商银行");
        creditCard.setCardNumber("11111111111");
        payinfos.add(creditCard);
    }

    @RequestMapping(path = "/pay")
    public Payinfo pay(@RequestParam("amount") double amount, @RequestParam("payType")PayType payType, @RequestParam("stagesCount")int stagesCount){

        List<Payinfo> payinfoList = payinfos.stream()
                .filter(payinfo1 -> payinfo1.getPayType().equals(payType)).collect(Collectors.toList());

        if(payType.equals(PayType.creditCard)){
            CreditCard creditCard = (CreditCard) payinfoList.get(0);
            CreditCard result = new CreditCard();
            result.setBillingDate(creditCard.getBillingDate());
            result.setDueDate(creditCard.getDueDate());
            result.setPayType(creditCard.getPayType());
            result.setAmount(amount);
            result.setStagesCount(stagesCount);
            result.setName(creditCard.getName());
            result.setCardNumber(creditCard.getCardNumber());
            return result;
        }else {
            Payinfo payinfo = payinfoList.get(0);
            Payinfo result = new  Payinfo();
            result.setBillingDate(payinfo.getBillingDate());
            result.setDueDate(payinfo.getDueDate());
            result.setPayType(payinfo.getPayType());
            result.setAmount(amount);
            result.setStagesCount(stagesCount);
            return result;
        }
    }

    @RequestMapping(path = "/record")
    public String record(AccountingRecord record){

        Date time = new Date();
        record.setTime(time);

        records.add(record);
        String temp = "";
        for (AccountingRecord index:records) {
            temp =temp+"记录："+
                       "发生日期："+index.getCreateTime()+
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

        List<AccountingRecord> filterd = records.stream().
                filter(record->record.getAmount()>amount).collect(Collectors.toList());

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
