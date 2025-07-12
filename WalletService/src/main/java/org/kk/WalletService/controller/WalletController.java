package org.kk.WalletService.controller;

import org.kk.WalletService.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet-service")
public class WalletController {

    @Autowired
    WalletService walletService;

    @GetMapping("/get/balance")
    public Double WalletBalance(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return walletService.getWalletBalance(userDetails.getUsername());
    }
}
