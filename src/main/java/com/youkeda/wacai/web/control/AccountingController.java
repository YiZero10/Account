package com.youkeda.wacai.web.control;

import com.youkeda.wacai.web.model.Accounting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountingController {

    @RequestMapping(path = "/accounting" )
    public Accounting accounting(Accounting accounting){

        int result = (accounting.getCash()+accounting.getIncome())-(accounting.getRent()+accounting.getCharges()+accounting.getEat()+accounting.getTreat()+accounting.getKtv());
        accounting.setBalance(result);
        return accounting;
    }
}
