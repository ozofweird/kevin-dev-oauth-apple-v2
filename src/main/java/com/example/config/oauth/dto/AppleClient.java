package com.example.config.oauth.dto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "appleClient", url = "https://appleid.apple.com/auth")
public interface AppleClient {

    // Public key를 조회할 client 설정
    @GetMapping(value = "/keys")
    ApplePublicKeyRes getAppleAuthPublicKey();

    // 'access_token, expires_in, id_token, refresh_token, token_type'을 받아오기 위한 client 설정
    @PostMapping(value = "/token", consumes = "application/x-www-form-urlencoded")
    AppleAccessTokenRes.Response getAccessToken(AppleAccessTokenRes.Request request);
}
