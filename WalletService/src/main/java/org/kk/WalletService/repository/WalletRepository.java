package org.kk.WalletService.repository;

import jakarta.transaction.Transactional;
import org.kk.WalletService.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet  , Integer> {

    Wallet findByMobileNo(String mobile);

    @Modifying
    @Transactional
    @Query("update wallet w set w.balance=w.balance+:amount where w.mobileNo=:sender")
    void updateWallet(String sender, double amount);
}
