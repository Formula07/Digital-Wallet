package org.kk.TransactionService.consumer;

import org.json.JSONObject;
import org.kk.TransactionService.repository.TransactionRepository;
import org.mavenLearn.enums.TxnStatus;
import org.mavenLearn.util.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UpdatedTransactionConsumer     {

    @Autowired
    TransactionRepository transactionRepository;

    @KafkaListener(topics = "TXN_UPDATE_QUEUE", groupId = "txn-update-group")
    public void listenUpdatedTransaction(String data) {
        System.out.println(data);

        JSONObject jsonObject = new JSONObject(data);

        String txnId = jsonObject.getString(CommonConstants.TXN_ID);
        String txnMessage = jsonObject.getString(CommonConstants.TXN_MESSAGE);
        //TxnStatus txnStatus = jsonObject.getEnum(TxnStatus.class, CommonConstants.TXN_STATUS);
        TxnStatus txnStatus = TxnStatus.valueOf(jsonObject.getString(CommonConstants.TXN_STATUS));

        System.out.printf("Updating txnId: %s, status: %s, message: %s%n", txnId, txnStatus, txnMessage);

        transactionRepository.updateTransactionDetails(txnId, txnStatus, txnMessage);
        System.out.println("final transaction updated");
    }
}
