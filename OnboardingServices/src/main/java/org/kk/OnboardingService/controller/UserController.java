package org.kk.OnboardingService.controller;

import org.kk.OnboardingService.model.User;
import org.kk.OnboardingService.request.UserCreationRequest;
import org.kk.OnboardingService.response.UserCreationResponse;
import org.kk.OnboardingService.service.UserService;
import org.mavenLearn.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/onboarding-service")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create/user")
    public ResponseEntity<UserCreationResponse> onBoardUser(@RequestBody UserCreationRequest userCreationRequest){
        System.out.println(userCreationRequest);
        UserCreationResponse userCreationResponse = new UserCreationResponse();
        userCreationResponse.setCode("02");
        if(StringUtil.isBlank(userCreationRequest.getEmail())){
            userCreationResponse.setMessage("email cannot be empty");
            return new ResponseEntity<>(userCreationResponse, HttpStatus.OK);
        }
        else if(StringUtil.isBlank(userCreationRequest.getMobileNo())){
            userCreationResponse.setMessage("phone number cannot be empty");
            return new ResponseEntity<>(userCreationResponse, HttpStatus.OK);
        }
        else if(StringUtil.isBlank(userCreationRequest.getUserIdentifierValue()) || StringUtil.isBlank(userCreationRequest.getPassword())){
            userCreationResponse.setMessage("invalid request");
            return new ResponseEntity<>(userCreationResponse, HttpStatus.BAD_REQUEST);
        }
        else{
            User user = userService.createNewUser(userCreationRequest);
            if(user==null){
                userCreationResponse.setMessage("user not found");
                userCreationResponse.setCode("02");
                return new ResponseEntity<>(userCreationResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            userCreationResponse.setEmail(user.getEmail());
            userCreationResponse.setName(user.getName());
            userCreationResponse.setCode("00");
            userCreationResponse.setMessage("User created successfully");
            //return new ResponseEntity<>(userCreationResponse, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(userCreationResponse, HttpStatus.CREATED);
    }
}
