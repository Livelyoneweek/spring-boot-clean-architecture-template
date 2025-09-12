package template.choi.java_spring_clean_arci.application.member.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
public record LoginCommand (@Getter String userName, @Getter String password){
}
