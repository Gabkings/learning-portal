package com.gabkings.learning_portal.controller;

import com.gabkings.learning_portal.dto.LoginDTO;
import com.gabkings.learning_portal.dto.ResponseDTO;
import com.gabkings.learning_portal.dto.SignupDTO;
import com.gabkings.learning_portal.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;



    @PostMapping("/login")
    public ResponseEntity<ResponseDTO<String>> login(@RequestBody @Valid LoginDTO loginDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.login(loginDTO));
    }

    @PostMapping("/register/student")
    public ResponseEntity<ResponseDTO<String>> signupStudent(@RequestBody @Valid SignupDTO signupDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.createStudentProfile(signupDTO));
    }

    @PostMapping("/register/instructor")
    public ResponseEntity<ResponseDTO<String>> signupInstructor(@RequestBody @Valid SignupDTO signupDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.createInstructorProfile(signupDTO));
    }

}
