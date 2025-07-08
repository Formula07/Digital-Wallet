package org.kk.WalletService.service;

import org.kk.WalletService.model.Wallet;
import org.kk.WalletService.repository.WalletRepository;
import org.mavenLearn.enums.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Value("${wallet.initial.amount}")
    private String walletAmount;

    @Autowired
    WalletRepository walletRepository;

    public void createWalletAccount(Wallet wallet){
        wallet.setUserStatus(UserStatus.ACTIVE);
        wallet.setBalance(Double.parseDouble(walletAmount));

        walletRepository.save(wallet);
        System.out.println("wallet account created");
    }
}
