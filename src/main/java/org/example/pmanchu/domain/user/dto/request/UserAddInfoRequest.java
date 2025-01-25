package org.example.pmanchu.domain.user.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.example.pmanchu.domain.userMajor.domain.Specialization;

import java.util.List;

@Getter
@Setter
public class UserAddInfoRequest {
    private String name;
    private List<String> Stacks;
    private List<Specialization> majors;
    private Long years;
    private String introduction;
    private String shortIntroduction;
    private String contact;
    private List<String> links;
}
