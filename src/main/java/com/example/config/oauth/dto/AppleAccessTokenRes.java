package com.example.config.oauth.dto;

import lombok.Setter;

public class AppleAccessTokenRes {

    @Setter
    public static class Request {
        private String code;
        private String client_id;
        private String client_secret;
        private String redirect_uri;
        private String grant_type;

        public static Request of(String code, String clientId, String clientSecret, String redirect_uri, String grantType) {
            Request request = new Request();
            request.code = code;
            request.client_id = clientId;
            request.client_secret = clientSecret;
            request.redirect_uri = redirect_uri;
            request.grant_type = grantType;
            return request;
        }
    }

    @Setter
    public static class Response {
        private String access_token;
        private String expires_in;
        private String id_token;
        private String refresh_token;
        private String token_type;
        private String error;

        public String getAccessToken() {
            return access_token;
        }

        public String getExpiresIn() {
            return expires_in;
        }

        public String getIdToken() {
            return id_token;
        }

        public String getRefreshToken() {
            return refresh_token;
        }

        public String getTokenType() {
            return token_type;
        }
    }
}