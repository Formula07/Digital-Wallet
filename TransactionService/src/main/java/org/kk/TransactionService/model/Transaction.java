package org.kk.TransactionService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.mavenLearn.enums.TxnStatus;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity//(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String txnId;
    private String senderId;
    private String receiverId;
    private double txnAmount;
    private String txnPurpose;

    @Enumerated(EnumType.STRING)
    private TxnStatus txnStatus;
    private String txnMessage;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

}
