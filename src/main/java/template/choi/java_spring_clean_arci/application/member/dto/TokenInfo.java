package template.choi.java_spring_clean_arci.application.member.dto;

import lombok.Builder;

@Builder
public record TokenInfo (String grantType, String accessToken){

}
