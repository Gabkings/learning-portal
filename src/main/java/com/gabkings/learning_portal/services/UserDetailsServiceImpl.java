package com.gabkings.learning_portal.services;

import com.gabkings.learning_portal.entity.User;
import com.gabkings.learning_portal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent()){
            return user.get();
        }else {
            throw new UsernameNotFoundException("Username not found");
        }
    }
}
