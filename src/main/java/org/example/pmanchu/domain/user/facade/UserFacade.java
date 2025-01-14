package org.example.pmanchu.domain.user.facade;

import lombok.RequiredArgsConstructor;
import org.example.pmanchu.domain.user.domain.User;
import org.example.pmanchu.domain.user.exception.UserNotFoundException;
import org.example.pmanchu.domain.user.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        String id =
                SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserById(id);
    }

    public User getUserById(String id) {
        return userRepository.findById((long) Integer.parseInt(id)).orElseThrow(()-> UserNotFoundException.EXCEPTION);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> UserNotFoundException.EXCEPTION);
    }
}
