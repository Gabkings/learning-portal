package com.gabkings.learning_portal.services;

import com.gabkings.learning_portal.dto.LoginDTO;
import com.gabkings.learning_portal.dto.ResponseDTO;
import com.gabkings.learning_portal.dto.SignupDTO;

public interface AuthService {
    ResponseDTO<String> createStudentProfile(SignupDTO signupDTO);

    ResponseDTO<String> createInstructorProfile(SignupDTO signupDTO);

    ResponseDTO<String> login(LoginDTO loginDTO);
}
