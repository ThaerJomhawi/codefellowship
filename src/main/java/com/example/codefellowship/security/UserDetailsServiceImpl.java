package com.example.codefellowship.Security;


import com.example.codefellowship.model.ApplicationUserModel;
import com.example.codefellowship.model.UserDataModel;
import com.example.codefellowship.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    // Dependency Injection & IoC
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    // Polymorphism
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDataModel applicationUser1 = applicationUserRepository.findByUsername(username);
        ApplicationUserModel applicationUserModel = new ApplicationUserModel(applicationUser1);
        // Error handling ... the user is equal to null (doesn't exist in the database)
        if(applicationUser1 == null){
            throw  new UsernameNotFoundException("The user "+ username + " does not exist");
        }
        return applicationUserModel;
    }
}