package org.example.pmanchu.domain.user.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.pmanchu.domain.user.domain.User;
import org.example.pmanchu.domain.user.dto.request.UserAddInfoRequest;
import org.example.pmanchu.domain.user.facade.UserFacade;
import org.example.pmanchu.domain.user.repository.UserRepository;
import org.example.pmanchu.domain.userLink.domain.UserLink;
import org.example.pmanchu.domain.userLink.repository.UserLinkRepository;
import org.example.pmanchu.domain.userMajor.domain.UserMajor;
import org.example.pmanchu.domain.userMajor.repository.UserMajorRepository;
import org.example.pmanchu.domain.userstack.domain.UserStack;
import org.example.pmanchu.domain.userstack.repository.UserStackRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAddInfoService {
    private final UserFacade userFacade;
    private final UserMajorRepository userMajorRepository;
    private final UserStackRepository userStackRepository;
    private final UserLinkRepository userLinkRepository;

    @Transactional
    public void addUserInfo(UserAddInfoRequest request) {
        User user = userFacade.getCurrentUser();
        user.addInfo(request.getIntroduction(), request.getShortIntroduction(), request.getName(),request.getYears());

        userLinkRepository.deleteByUserId(user);
        userStackRepository.deleteByUserId(user);
        userMajorRepository.deleteByUserId(user);
        request.getMajors()
                .forEach(s->userMajorRepository.save(new UserMajor(user,s)));
        request.getStacks()
                .forEach(s->userStackRepository.save(new UserStack(user,s)));
        request.getLinks()
                .forEach(s->userLinkRepository.save(new UserLink(user,s)));
    }
}
