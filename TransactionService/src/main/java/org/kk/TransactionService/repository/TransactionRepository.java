package org.kk.TransactionService.repository;

import jakarta.transaction.Transactional;
import org.kk.TransactionService.model.Transaction;
import org.mavenLearn.enums.TxnStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Transaction t SET t.txnStatus = :status, t.txnMessage = :message WHERE t.txnId = :txnId")
    void updateTransactionDetails(
            @Param("txnId") String txnId,
            @Param("status") TxnStatus status,
            @Param("message") String message
    );

    List<Transaction> findBySenderIdOrReceiverId(String sender, String receiver);
}
