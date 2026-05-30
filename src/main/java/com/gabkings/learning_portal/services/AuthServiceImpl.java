package com.gabkings.learning_portal.services;

import com.gabkings.learning_portal.dto.LoginDTO;
import com.gabkings.learning_portal.dto.ResponseDTO;
import com.gabkings.learning_portal.dto.SignupDTO;
import com.gabkings.learning_portal.entity.User;
import com.gabkings.learning_portal.enums.Role;
import com.gabkings.learning_portal.exceptions.AuthenticationFailedException;
import com.gabkings.learning_portal.exceptions.ResourceAlreadyExistsException;
import com.gabkings.learning_portal.jwtUtils.JwtUtils;
import com.gabkings.learning_portal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final  JwtUtils jwtUtils;


    @Override
    public ResponseDTO<String> createStudentProfile(SignupDTO signupDTO) {

        checkIfUserExists(signupDTO);

        User newUser = createNewUser(signupDTO);
        newUser.setRole(Role.STUDENT);
        userRepository.save(newUser);

        String jwt = jwtUtils.generateToken(newUser);
        ResponseDTO<String> responseDTO = new ResponseDTO<>();
        responseDTO.setData(jwt);
        responseDTO.setMessage("New Student Profile is created successfully!");

        return responseDTO;
    }

    @Override
    public ResponseDTO<String> createInstructorProfile(SignupDTO signupDTO) {

        checkIfUserExists(signupDTO);

        User newUser = createNewUser(signupDTO);
        newUser.setRole(Role.INSTRUCTOR);
        userRepository.save(newUser);

        String jwt = jwtUtils.generateToken(newUser);
        ResponseDTO<String> responseDTO = new ResponseDTO<>();
        responseDTO.setData(jwt);
        responseDTO.setMessage("New Instructor Profile is created successfully!");
        return responseDTO;
    }

    @Override
    public ResponseDTO<String> login(LoginDTO loginDTO) {
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        if (authentication.isAuthenticated()) {
            String jwt = jwtUtils.generateToken(userDetails);
            updateLastLogin(username);

            ResponseDTO<String> responseDTO = new ResponseDTO<>();
            responseDTO.setData(jwt);
            responseDTO.setMessage("Login successfully!");
            return responseDTO;
        }

        throw new AuthenticationFailedException("User credentials are not valid. Please try again.");
    }

    private void checkIfUserExists(SignupDTO signupDTO) {
        String username = signupDTO.getUsername();
        String email = signupDTO.getEmail();

        boolean existsByUsername = userRepository.existsByUsernameIgnoreCase(username);
        if (existsByUsername) {
            throw new ResourceAlreadyExistsException("User", "username");
        }
        boolean existsByEmail = userRepository.existsByEmailIgnoreCase(email);

        if (existsByEmail) {
            throw new ResourceAlreadyExistsException("User", "email");
        }
    }

    private User createNewUser(SignupDTO signupDTO) {
        User newUser = new User();
        newUser.setFirstName(signupDTO.getFirstName());
        newUser.setLastName(signupDTO.getLastName());
        newUser.setUsername(signupDTO.getUsername());
        newUser.setEmail(signupDTO.getEmail());

        String encodedPassword = passwordEncoder.encode(signupDTO.getPassword());
        newUser.setPassword(encodedPassword);
        return newUser;
    }

    private void updateLastLogin(String username) {

        userRepository.updateLastLoginDate(username, LocalDateTime.now());
    }
}
