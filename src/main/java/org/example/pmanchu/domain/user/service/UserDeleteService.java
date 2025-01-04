package org.example.pmanchu.domain.user.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.pmanchu.domain.user.domain.User;
import org.example.pmanchu.domain.user.exception.UserNotFoundException;
import org.example.pmanchu.domain.user.facade.UserFacade;
import org.example.pmanchu.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDeleteService {
    private final UserFacade userFacade;
    private final UserRepository userRepository;

    @Transactional
    public void delete(){
        userRepository.delete(userFacade.getCurrentUser());
    }
}
