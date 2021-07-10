package com.example.api;

import com.example.config.oauth.AppleService;
import com.example.config.oauth.dto.AppleAccessTokenRes;
import com.example.config.oauth.dto.AppleUserInfoRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AppleController {

    private final AppleService appleService;

    @GetMapping("/")
    public String test() {
        return "test";
    }

    @GetMapping("/oauth/apple")
    public String getRedirectUri() {
        return appleService.getRedirectUri();
    }

    @GetMapping("/oauth/apple/callback")
    public String getCallback() {
        return "callback";
    }

    @GetMapping("/oauth/apple/accessToken")
    public AppleAccessTokenRes.Response getAccessToken(@RequestParam(name = "code") String authorizationCode) {
        return appleService.getAccessToken(authorizationCode);
    }

    @GetMapping("/oauth/apple/userInfo")
    public AppleUserInfoRes getUserInfo(@RequestParam(name = "id_token") String idToken) {
        return appleService.getUserId(idToken);
    }
}
