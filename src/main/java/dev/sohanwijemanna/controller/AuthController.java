package dev.sohanwijemanna.controller;

import dev.sohanwijemanna.model.Cart;
import dev.sohanwijemanna.model.USER_ROLE;
import dev.sohanwijemanna.model.User;
import dev.sohanwijemanna.repository.CartRepository;
import dev.sohanwijemanna.repository.UserRepository;
import dev.sohanwijemanna.request.LoginRequest;
import dev.sohanwijemanna.response.AuthResponse;
import dev.sohanwijemanna.service.CustomerUserDetailsService;
import dev.sohanwijemanna.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private CustomerUserDetailsService customerUserDetailsService;

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws Exception {

        User isEmailExists = userRepository.findByEmail(user.getEmail());
        if(isEmailExists != null){
            throw new Exception("Email has being already used");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User createdUser = userRepository.save(user);

        Cart cart = new Cart();
        cart.setCustomer(createdUser);
        cartRepository.save(cart);

        Authentication authentication = new UsernamePasswordAuthenticationToken(createdUser.getEmail(), createdUser.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateToken(authentication);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwtToken(jwt);
        authResponse.setMessage("User Created Successfully");
        authResponse.setRole(createdUser.getRole());

        return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> loginHandler(@RequestBody LoginRequest request) throws Exception {

        String email = request.getEmail();
        String password = request.getPassword();

        Authentication authentication = authenticate(email, password);

        String jwt = jwtService.generateToken(authentication);

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String role = authorities.isEmpty() ? null : authorities.iterator().next().getAuthority();

        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwtToken(jwt);
        authResponse.setMessage("User Login Successfully");
        authResponse.setRole(USER_ROLE.valueOf(role));

        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

    private Authentication authenticate(String email, String password) {
        UserDetails userDetails = customerUserDetailsService.loadUserByUsername(email);

        if(userDetails == null){
            throw new BadCredentialsException("No User Found");
        }

        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            throw new BadCredentialsException("Invalid password");
        }

        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }
}
