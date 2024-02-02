package com.myJournalApp.services.user;

import com.myJournalApp.dtos.AuthenticationRequest;
import com.myJournalApp.dtos.GeneralResponse;
import com.myJournalApp.dtos.SignupRequest;
import com.myJournalApp.dtos.UserDto;
import com.myJournalApp.entity.User;
import com.myJournalApp.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Transactional
    public UserDto createUser(SignupRequest signupRequest) throws Exception {
        User user = new User(signupRequest.getEmail(), new BCryptPasswordEncoder().encode(signupRequest.getPassword()), signupRequest.getName());
        user = userRepo.save(user);
        if (user == null)
            return  null;

        return user.mapUsertoUserDto();
    }


    public Boolean hasUserWithEmail(String email) {
        return userRepo.findFirstByEmail(email) != null;
    }

    @Override
    public UserDto getUser(Long userId) {
        UserDto userDto = null;
        Optional<User> optionalUser = userRepo.findById(userId);
        if(optionalUser.isPresent()){
            userDto = optionalUser.get().mapUsertoUserDto();
        }
        return userDto;
    }

    @Override
    public GeneralResponse login(AuthenticationRequest authenticationRequest) {
        GeneralResponse generalResponse = new GeneralResponse();
        Optional<User> optionalUser = userRepo.findByEmail(authenticationRequest.getUsername());
        if(optionalUser.isPresent()){
            if(new BCryptPasswordEncoder().matches(authenticationRequest.getPassword(),optionalUser.get().getPassword())){
                UserDto userDto = new UserDto();
                userDto.setId(optionalUser.get().getId());

                generalResponse.setStatus(HttpStatus.OK);
                generalResponse.setData(userDto);
            }
            else{
                generalResponse.setStatus(HttpStatus.NOT_ACCEPTABLE);
                generalResponse.setMessage("Password is not correct");
            }
        }
        else{
            generalResponse.setStatus(HttpStatus.NOT_ACCEPTABLE);
            generalResponse.setMessage("User Not Found");
        }
        return generalResponse;
    }

}
