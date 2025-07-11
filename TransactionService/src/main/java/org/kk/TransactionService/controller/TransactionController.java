package org.kk.TransactionService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @GetMapping("/initiate/transaction")
    public String initiateTransaction(@RequestParam("receiver") String receiver,
                                      @RequestParam("amount") String amount,
                                      @RequestParam("purpose") String purpose){

        return "ok";

    }
}
