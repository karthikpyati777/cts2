package com.myJournalApp.services.user;


import com.myJournalApp.dtos.AuthenticationRequest;
import com.myJournalApp.dtos.GeneralResponse;
import com.myJournalApp.dtos.SignupRequest;
import com.myJournalApp.dtos.UserDto;

public interface UserService {

     UserDto createUser(SignupRequest signupRequest) throws Exception;

     Boolean hasUserWithEmail(String email);

     UserDto getUser(Long userId);

     GeneralResponse login(AuthenticationRequest authenticationRequest);

}
