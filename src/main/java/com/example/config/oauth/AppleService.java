package com.example.config.oauth;

import com.example.config.oauth.dto.AppleAccessTokenRes;
import com.example.config.oauth.dto.AppleClient;
import com.example.config.oauth.dto.ApplePublicKeyRes;
import com.example.config.oauth.dto.AppleUserInfoRes;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class AppleService {

    private final AppleClient appleClient;

    public String getRedirectUri() {

        String loginUrl = "https://appleid.apple.com/auth/authorize";

        StringBuilder redirectUri = new StringBuilder()
                .append(loginUrl)
                .append("?client_id=").append("org.example.apple")
                .append("&redirect_uri=").append("https://apple.example.org/oauth/apple/callback")
                .append("&response_type=").append("code%20id_token")
                .append("&response_mode=").append("fragment")
                .append("&state=").append("test")
                .append("&nonce=").append("20B20D-0S8-1K8");

        return redirectUri.toString();
    }

    public AppleUserInfoRes getUserId(String idToken) {

        try {
            ApplePublicKeyRes response = appleClient.getAppleAuthPublicKey();

            String headerOfIdentityToken = idToken.substring(0, idToken.indexOf("."));
            Map<String, String> header = new ObjectMapper().readValue(new String(Base64.getDecoder().decode(headerOfIdentityToken), "UTF-8"), Map.class);
            ApplePublicKeyRes.Key key = response.getMatchedKeyBy(header.get("kid"), header.get("alg"))
                    .orElseThrow(() -> new NullPointerException("Failed get public key from apple's id server."));

            byte[] nBytes = Base64.getUrlDecoder().decode(key.getN());
            byte[] eBytes = Base64.getUrlDecoder().decode(key.getE());

            BigInteger n = new BigInteger(1, nBytes);
            BigInteger e = new BigInteger(1, eBytes);

            RSAPublicKeySpec publicKeySpec = new RSAPublicKeySpec(n, e);
            KeyFactory keyFactory = KeyFactory.getInstance(key.getKty());
            PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

            Claims claims = Jwts.parser().setSigningKey(publicKey).parseClaimsJws(idToken).getBody();

            return AppleUserInfoRes.builder()
                    .id(claims.getId())
                    .sub(claims.getSubject())
                    .iss(claims.getIssuer())
                    .aud(claims.getAudience())
                    .exp(claims.getExpiration().toString())
                    .iat(claims.getIssuedAt().toString())
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public AppleAccessTokenRes.Response getAccessToken(String authorizationCode) {

        String clientSecret = "";
        try {
            clientSecret = createClientSecret();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return appleClient.getAccessToken(AppleAccessTokenRes.Request.of(
                authorizationCode,
                "org.example.apple",
                clientSecret,
                "https://apple.example.org/oauth/apple/callback",
                "authorization_code"
        ));
    }

    public String createClientSecret() throws IOException {
        Date expirationDate = Date.from(LocalDateTime.now().plusDays(30).atZone(ZoneId.systemDefault()).toInstant());

        String clientSecret = Jwts.builder()
                .setHeaderParam("kid", "12345678")
                .setHeaderParam("alg", "ES256")
                .setIssuer("TEAM_ID")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expirationDate)
                .setAudience("https://appleid.apple.com")
                .setSubject("org.example.oauth")
                .signWith(SignatureAlgorithm.ES256, getPrivateKey())
                .compact();

        return clientSecret;
    }

    private PrivateKey getPrivateKey() throws IOException {
        ClassPathResource resource = new ClassPathResource("key/AuthKey_12345678.p8");
        String privateKey = new String(Files.readAllBytes(Paths.get(resource.getURI())));
        Reader pemReader = new StringReader(privateKey);
        PEMParser pemParser = new PEMParser(pemReader);
        JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
        PrivateKeyInfo object = (PrivateKeyInfo) pemParser.readObject();
        return converter.getPrivateKey(object);
    }
}
