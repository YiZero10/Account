package com.youkeda.wacai.web.control;

import com.youkeda.wacai.web.model.*;
import com.youkeda.wacai.web.service.FinanceService;
import com.youkeda.wacai.web.service.RecordService;
import com.youkeda.wacai.web.service.impl.JdFinanceServiceImpl;
import com.youkeda.wacai.web.service.impl.RecordServiceImpl;
import com.youkeda.wacai.web.service.impl.YuebaoFinanceServiceImpl;
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
    private static RecordService recordService = new RecordServiceImpl();

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

    @RequestMapping(path = "/finance")
    public FinanceInfo finance(@RequestParam("type") FinanceType type, @RequestParam("amount") double amount, @RequestParam("days") int days){

        FinanceService financeService = null;

        if(FinanceType.yuebao.equals(type)){
            financeService = new YuebaoFinanceServiceImpl();
        }else if(FinanceType.jd.equals(type)){
            financeService = new JdFinanceServiceImpl();
        }else{
            return null;
        }
        return financeService.invest(amount,days);
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
    public String record(AccountingRecord accountingRecordrecord){

        if(accountingRecordrecord.getAmount()==0){
            return "";
        }

        Date time = new Date();
        accountingRecordrecord.setTime(time);

        //调用方法
        recordService.record(accountingRecordrecord);
        return "记录成功！";
    }

    @RequestMapping(path = "/query")
    public List<AccountingRecord> query(){
        return recordService.query();
    }

    @RequestMapping(path = "/search")
    public String search(@RequestParam("amount") int amount){

        StringBuilder sb = new StringBuilder();

        List<AccountingRecord> filterd = records.stream().
                filter(record->record.getAmount()>amount).collect(Collectors.toList());

        for (AccountingRecord index : filterd) {
            Date date = index.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//HH表示为24小时制

            sb.append("发生时间:"+index.getCreateTime());
            sb.append(" 金额:"+index.getAmount());
            sb.append(" 类别:"+index.getType());
            sb.append(" 科目:"+index.getCategory());
            sb.append(" 创建时间:"+sdf.format(date));
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
