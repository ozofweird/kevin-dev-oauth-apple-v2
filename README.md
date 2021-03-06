# kevin-dev-oauth-apple-v2

![](https://img.shields.io/badge/version-0.0.1-brightgreen)

## ๐ Index
- [About](#๐-about)
- [Overview](#๐-overview)
- [Getting Started](#๐-getting-started)
- [Release Notes](#โ-release-notes)
- [Issues](#๐ฅ-issues)
- [Contributing](#๐ฅ-contributing)
- [Authors](#๐ค-authors)
- [License](#๐ท-license)
- [References](#๐-references)
- [Commit Message (Gitmoji)](#โ๏ธ-commit-messages-gitmoji)

## ๐ About
Apple ์์ ๋ก๊ทธ์ธ์ ๊ตฌํํ ํ๋ก์ ํธ์๋๋ค. ์ค์ ๋ก ๊ตฌ๋ ํ์คํธ๋ฅผ ํด๋ณด์ง ์์ ํ๋ก์ ํธ์ด๋ฏ๋ก ์ฐธ๊ณ ๋ง ํด์ฃผ์๊ธธ ๋ฐ๋๋๋ค.

์ด ํ๋ก์ ํธ๋ kevin-dev-oauth-apple-v1๊ณผ๋ ๋ค๋ฅด๊ฒ RestTemplate๊ฐ ์๋ Feign Client๋ก ์งํํ์ต๋๋ค.
๊ทธ๋ ๊ธฐ ๋๋ฌธ์ v1๊ณผ๋ ๋ค๋ฅด๊ฒ RestTemplate๋ณด๋ค ๋ ๋ง์ ์ฝ๋์ ์ถ์๋ฅผ ํ์ธํ  ์ ์์ต๋๋ค.

๊ธฐ๋ณธ์ ์ธ ํ์ v1๊ณผ ๋์ผํ๊ธฐ์ ๋ถํ์ํ ๋ด์ฉ์ ์๋ตํ์์ต๋๋ค.

## ๐ Overview
- Apple Login
  * ๋ก๊ทธ์ธ ํ๋ฉด ๋ฆฌ๋ค์ด๋ ํธ (getRedirectUri)
  * 'id_token'์ public key๋ก ์ฌ์ฉ์ ์ ๋ณด ๊ฐ์ ธ์ค๊ธฐ (getUserId)
  * Private key๋ฅผ ์ด์ฉํ์ฌ client_secret์ ๋ง๋ค๊ณ  ๋ค๋ฅธ ์ ๋ณด๋ค๊ณผ ์ทจํฉํ์ฌ Apple๋ก ๋ถํฐ 'refresh_token' ๋ฐ๊ธ (getAccessToken)
  
## ๐ Getting Started
**dependencies**
```
implementation group: 'io.jsonwebtoken', name: 'jjwt', version: '0.9.1'
implementation group: 'org.bouncycastle', name: 'bcpkix-jdk15on', version: '1.69'
implementation group: 'org.springframework.cloud', name: 'spring-cloud-openfeign-core', version: '3.0.3'
```

### ๐น AWS
- EC2
- Route53 (+SSL)
- ALB

```
sudo yum install -y git 
sudo yum install -y java-1.8.0-openjdk-devel.x86_64 
git clone https://github.com/ozofweird/kevin-dev-oauth-apple-v2.git 
cd kevin-dev-oauth-apple 
sudo chmod +x gradlew 
sudo ./gradlew clean build 
cd build/libs 
sudo nohup java -jar kevin-dev-oauth-apple-0.0.1-SNAPSHOT.jar &
```

### ๐น Project Structures
```
โโโ src
    โโโ main
    โ   โโโ java
    โ   โ   โโโ com
    โ   โ       โโโ example
    โ   โ           โโโ api
    โ   โ           โ   โโโ AppleController.java
    โ   โ           โโโ config.oauth
    โ   โ               โโโ dto
    โ   โ               โ   โโโ AppleAccessTokenRes.java
    โ   โ               โ   โโโ ApplePublicKeyRes.java
    โ   โ               โ   โโโ AppleUserInfoRes.java
    โ   โ               โ   โโโ AppleClient.java
    โ   โ               โโโ AppleService.java
```

## โ Release Notes
* 0.0.1
    * ํ์คํธ

## ๐ฅ Issues

## ๐ฅ Contributing
ozofweird

## ๐ค Authors
- [ozofweird](https://github.com/ozofweird) - **Kevin Ahn**

## ๐ท License
ozofweird

## ๐ References
- [kevin-dev-oauth-apple-v1](https://github.com/ozofweird/kevin-dev-oauth-apple-v1.git)
- [Spring API์๋ฒ์์ Apple ์ธ์ฆ(๋ก๊ทธ์ธ, ํ์๊ฐ์) ์ฒ๋ฆฌํ๊ธฐ](https://hwannny.tistory.com/71)
- [openfeign maven repository](https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-openfeign-core)
- [์ฐ์ํ feign ์ ์ฉ๊ธฐ](https://techblog.woowahan.com/2630/)
- [(Spring Cloud) Feign](https://supawer0728.github.io/2018/03/11/Spring-Cloud-Feign/)

---

## โ๏ธ Commit messages (Gitmoji)

|Gitmoji|Code|Description|
|:-----:|:---:|:--------:|
|๐จ|art|ํ์ผ/์ฝ๋ ๊ตฌ์กฐ ๊ฐ์ |
|๐ฉน|adhesive_bandage|๊ฐ๋จํ ์์ |
|โก๏ธ|zap|์ฑ๋ฅ ํฅ์|
|๐ฅ๏ธ|fire|์ฝ๋๋ ํ์ผ ์ญ์ |
|๐๏ธ|bug|๋ฒ๊ทธ ํด๊ฒฐ|
|๐๏ธ|ambulance|๊ธด๊ธ ์์ |
|โจ๏ธ|sparkles|์๋ก์ด ๊ธฐ๋ฅ|
|๐๏ธ|memo|๋ฌธ์ ์ถ๊ฐ/์์ |
|๐๏ธ|lipstick|ํ๋ฉด UI ์ถ๊ฐ/์์ |
|๐๏ธ|tada|ํ๋ก์ ํธ ์์|
|โ๏ธ|white_check_mark|ํ์คํธ ์ถ๊ฐ/์์ |
|๐๏ธ|lock|๋ณด์ ์ด์ ์์ |
|๐๏ธ|bookmark|๋ฆด๋ฆฌ์ฆ/๋ฒ์  ํ๊ทธ|
|๐ง|construction|์์ ์งํ ์ค|
|๐|green_heart|CI ๋น๋ ์์ |
|โฌ๏ธ|arrow_down|์์กด์ฑ ๋ฒ์  ๋ค์ด|
|โฌ๏ธ|arrow_up|์์กด์ฑ ๋ฒ์  ์|
|๐|pushpin|ํน์  ๋ฒ์  ์์กด์ฑ ๊ณ ์ |
|๐ท|construction_worker|CI ๋น๋ ์์คํ ์ถ๊ฐ/์์ |
|๐|chart_with_upwards_trend|๋ถ์, ์ถ์  ์ฝ๋ ์ถ๊ฐ/์์ |
|โป๏ธ|recycle|์ฝ๋ ๋ฆฌํฉํ ๋ง|
|โ|heavy_plus_sign|์์กด์ฑ ์ถ๊ฐ|
|โ|heavy_minus_sign|์์กด์ฑ ์ ๊ฑฐ|
|๐ง|wrench|์ค์  ํ์ผ ์ถ๊ฐ/์์ |
|๐จ|hammer|๊ฐ๋ฐ ์คํฌ๋ฆฝํธ ์ถ๊ฐ/์์ |
|๐|globe_with_meridians|๋ค๊ตญ์ด ์ง์|
|๐ฉ|poop|์์ข์ ์ฝ๋ ์ถ๊ฐ|
|โช|rewind|๋ณ๊ฒฝ ๋ด์ฉ ๋๋๋ฆฌ๊ธฐ|
|๐|twisted_rightwards_arrows|๋ธ๋์น ํฉ๋ณ|
|๐ฝ|alien|์ธ๋ถ API ๋ณํ๋ก ์ธํ ์์ |
|๐|truck|๋ฆฌ์์ค ์ด๋/์ด๋ฆ ๋ณ๊ฒฝ|
|๐ฅ|boom|๋๋ผ์ด ๊ธฐ๋ฅ ์๊ฐ|
|๐ฑ|bento|์์ ์ถ๊ฐ/์์ |
|๐ก|bulb|์ฃผ์ ์ถ๊ฐ/์์ |
|๐ฌ|speech_balloon|์คํธ๋ง ํ์ผ ์ถ๊ฐ/์์ |
|๐|card_file_box|๋ฐ์ด๋ฒ๋ฒ ์ด์ค ๊ด๋ จ ์์ |
|๐|loud_sound|๋ก๊ทธ ์ถ๊ฐ/์์ |
|๐|mute|๋ก๊ทธ ์ญ์ |
|๐ฑ|iphone|๋ฐ์ํ ๋์์ธ|
|๐|see_no_evil|gitignore ์ถ๊ฐ|
