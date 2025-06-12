package dev.sohanwijemanna.service.impl;

import dev.sohanwijemanna.model.User;
import dev.sohanwijemanna.repository.UserRepository;
import dev.sohanwijemanna.service.JwtService;
import dev.sohanwijemanna.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Override
    public User findUserByJwtToken(String jwtToken) throws Exception {
        String email = jwtService.getEmailFromJwtToken(jwtToken);
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new Exception("User not found");
        }
        return user;
    }

    @Override
    public User findUserByEmail(String email) throws Exception {
        User user = userRepository.findByEmail(email);
        if(user == null) {
            throw new Exception("User not found");
        }
        return user;
    }
}
