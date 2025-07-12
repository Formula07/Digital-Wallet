package org.kk.WalletService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.mavenLearn.enums.UserIdentifier;
import org.mavenLearn.enums.UserStatus;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "wallet")
@Builder
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private int userId;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String mobileNo;

    private double balance;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    private String userIdentificationNumber;

    @Enumerated(EnumType.STRING)
    private UserIdentifier userIdentifier;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;


}
