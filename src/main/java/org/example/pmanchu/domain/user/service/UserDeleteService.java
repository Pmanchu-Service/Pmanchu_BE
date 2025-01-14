package org.example.pmanchu.domain.user.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.pmanchu.domain.user.domain.User;
import org.example.pmanchu.domain.user.facade.UserFacade;
import org.example.pmanchu.domain.user.repository.UserRepository;
import org.example.pmanchu.domain.userLink.repository.UserLinkRepository;
import org.example.pmanchu.domain.userMajor.repository.UserMajorRepository;
import org.example.pmanchu.domain.userstack.repository.UserStackRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDeleteService {
    private final UserFacade userFacade;
    private final UserRepository userRepository;
    private final UserLinkRepository userLinkRepository;
    private final UserStackRepository userStackRepository;
    private final UserMajorRepository userMajorRepository;

    @Transactional
    public void delete(){
        User user = userFacade.getCurrentUser();
        userLinkRepository.deleteByUserId(user);
        userStackRepository.deleteByUserId(user);
        userMajorRepository.deleteByUserId(user);
        userRepository.deleteById(user.getUserId());
    }
}
