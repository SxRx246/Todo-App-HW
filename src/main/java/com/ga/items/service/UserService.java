package com.ga.items.service;

import com.ga.items.acception.InformationNotFoundException;
import com.ga.items.model.Category;
import com.ga.items.model.Item;
import com.ga.items.model.User;
import com.ga.items.model.UserProfile;
import com.ga.items.model.request.LoginRequest;
import com.ga.items.model.response.LoginResponse;
import com.ga.items.repository.UserRepository;
import com.ga.items.security.JWTUtils;
import com.ga.items.security.MyUserDetails;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private MyUserDetails myUserDetails;

    @Autowired
    public UserService(UserRepository userRepository,
                       @Lazy PasswordEncoder passwordEncoder,
                       JWTUtils jwtUtil,
                       @Lazy AuthenticationManager authenticationManager,
                       @Lazy MyUserDetails myUserDetails
    ){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.myUserDetails = myUserDetails;
    }

    public User createUser(User userObject) {
        System.out.println("Calling createUser() ==>");
        if (!userRepository.existsByEmail(userObject.getEmail())) {
            userObject.setPassword(passwordEncoder.encode(userObject.getPassword()));
            if (userObject.getCategories() != null) {
                for (Category category : userObject.getCategories()) {

                    category.setUser(userObject);

                    if (category.getItemList() != null) {
                        for (Item item : category.getItemList()) {

                            item.setCategory(category);
                            item.setUser(userObject);
                            if (userObject.getItems() == null) {
                                userObject.setItems(new ArrayList<>());
                            }
                            userObject.getItems().add(item);
                        }
                    }
                }
            }
            return userRepository.save(userObject);
        } else {
            throw new InformationNotFoundException("User with email "
                    + userObject.getEmail()
                    + " not exists");
        }
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public ResponseEntity<?> loginUser(LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            MyUserDetails myUserDetails =
                    (MyUserDetails) authentication.getPrincipal();
            System.out.println("myUserDetails: "+ myUserDetails);
            final String JWT = jwtUtils.generateJwtToken(myUserDetails);
            System.out.println("JWT: "+JWT);
            return ResponseEntity.ok(new LoginResponse(JWT));

        } catch (Exception e) {
            return ResponseEntity.ok(
                    new LoginResponse("Error: user name or email is incorrect, " + e)

            );
        }
    }

}
