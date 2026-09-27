package com.ga.items.service;

import com.ga.items.acception.InformationNotFoundException;
import com.ga.items.model.Category;
import com.ga.items.model.Item;
import com.ga.items.model.User;
import com.ga.items.model.UserProfile;
import com.ga.items.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

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
}
