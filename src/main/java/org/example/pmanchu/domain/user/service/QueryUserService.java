package org.example.pmanchu.domain.user.service;

import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.example.pmanchu.domain.user.dto.response.QueryMyPageResponse;
import org.example.pmanchu.domain.user.dto.response.QueryUserResponse;
import org.example.pmanchu.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryUserService {
    private final UserRepository userRepository;

    public List<QueryUserResponse> queryUsers(){
        return userRepository.findAll().stream().map(QueryUserResponse::new).toList();
    }
}
