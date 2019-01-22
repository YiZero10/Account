package com.youkeda.wacai.web.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountingController {

    @RequestMapping(path = "/accounting" )
    public String accounting(@RequestParam("cash") int cash,@RequestParam("income") int income,@RequestParam("rent") int rent,@RequestParam("charges") int charges,@RequestParam("eat") int eat){

        int result = (cash+income)-(charges+rent+eat);
        return "本月余额为："+result;
    }
}
