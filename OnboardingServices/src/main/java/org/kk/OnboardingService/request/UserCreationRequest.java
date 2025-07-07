package org.kk.OnboardingService.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mavenLearn.enums.UserIdentifier;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreationRequest {

    private String name;
    private String email;
    private String mobileNo;
    private String password;
    private String dob;
    private UserIdentifier userIdentifier;
    private String userIdentifierValue;


}
