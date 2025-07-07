package org.kk.OnboardingService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true, length = 13)
    private String mobileNo;

    private String password;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private UserStatus userStatus;

    private String dob;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private UserIdentifier userIdentifier;

    @Column(unique = true)
    private String userIdentifierValue;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

}
