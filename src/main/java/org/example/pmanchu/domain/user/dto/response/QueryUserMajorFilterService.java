package org.example.pmanchu.domain.user.dto.response;

import lombok.RequiredArgsConstructor;
import org.example.pmanchu.domain.user.repository.UserRepository;
import org.example.pmanchu.domain.userMajor.domain.Specialization;
import org.example.pmanchu.domain.userMajor.domain.UserMajor;
import org.example.pmanchu.domain.userMajor.repository.UserMajorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryUserMajorFilterService {
    private final UserMajorRepository userMajorRepository;

    public List<QueryUserResponse> queryUserMajorFilter(List<Specialization> specializations) {
        return userMajorRepository.findAllUserBySpecializationIn(specializations).stream().map(UserMajor::getUserId).distinct().map(QueryUserResponse::new).toList();
    }
}
