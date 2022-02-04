package com.ensemble.pj.security;

import lombok.Getter;
import lombok.Setter;

public class JwtAuthenticationResponse {

    @Getter @Setter
    private String userId;

    @Getter @Setter
    private String accessToken;

    @Getter @Setter
    private String tokenType = "Bearer";

    public JwtAuthenticationResponse(String userId, String accessToken) {
        this.userId = userId;
        this.accessToken = accessToken;
    }

}
