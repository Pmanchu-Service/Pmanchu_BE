package org.example.pmanchu.global.security.auth;

import lombok.RequiredArgsConstructor;
import org.example.pmanchu.domain.user.domain.User;
import org.example.pmanchu.domain.user.facade.UserFacade;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {

    private final UserFacade userFacade;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        User user = userFacade.getUserById((long) Integer.parseInt(id));//코드가 좀 머저리같은데;;ㅋㅋ
        return new AuthDetails(user);
    }
}
