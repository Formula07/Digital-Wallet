package org.kk.WalletService.consumer;

import org.json.JSONObject;
import org.kk.WalletService.model.Wallet;
import org.kk.WalletService.service.WalletService;
import org.mavenLearn.enums.UserIdentifier;
import org.mavenLearn.util.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumer {

    @Autowired
    WalletService walletService;

    @KafkaListener(topics = "USER_DETAILS_QUEUE", groupId = "wallet_account")
    public void listenNewlyCreatedUser(String data) {
        System.out.println(data);

        JSONObject jsonObject = new JSONObject(data);

        int userId = jsonObject.getInt(CommonConstants.USER_ID);
        String name = jsonObject.getString(CommonConstants.USER_NAME);
        String email = jsonObject.getString(CommonConstants.USER_EMAIL);
        String mobile = jsonObject.getString(CommonConstants.USER_MOBILE);
        String userIdentifierValue = jsonObject.getString(CommonConstants.USER_IDENTIFIER_VALUE);
        UserIdentifier userIdentifier = jsonObject.getEnum(UserIdentifier.class, CommonConstants.USER_IDENTIFIER);


        Wallet wallet = new Wallet();
        wallet.setUserId(userId);
        wallet.setName(name);
        wallet.setEmail(email);
        wallet.setMobileNo(mobile);
        wallet.setUserIdentificationNumber(userIdentifierValue);
        wallet.setUserIdentifier(userIdentifier);

        walletService.createWalletAccount(wallet);
    }
}
