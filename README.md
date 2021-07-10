# kevin-dev-oauth-apple-v2

![](https://img.shields.io/badge/version-0.0.1-brightgreen)

## 📋 Index
- [About](#🎉-about)
- [Overview](#👀-overview)
- [Getting Started](#🚀-getting-started)
- [Release Notes](#✅-release-notes)
- [Issues](#🔥-issues)
- [Contributing](#👥-contributing)
- [Authors](#👤-authors)
- [License](#🏷-license)
- [References](#📚-references)
- [Commit Message (Gitmoji)](#✉️-commit-messages-gitmoji)

## 🎉 About
Feign Client를 이용한 Apple 소셜 로그인을 구현한 프로젝트입니다. 실제로 구동 테스트를 해보지 않은 프로젝트이므로 참고만 해주시길 바랍니다.

## 👀 Overview
- Apple Login

## 🚀 Getting Started
```
implementation group: 'io.jsonwebtoken', name: 'jjwt', version: '0.9.1'
implementation group: 'org.bouncycastle', name: 'bcpkix-jdk15on', version: '1.69'
implementation group: 'org.springframework.cloud', name: 'spring-cloud-openfeign-core', version: '3.0.3'
```

### 🔹 AWS
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

### 🔹 Project Structures
```
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── example
    │   │           ├── api
    │   │           │   └── AppleController.java
    │   │           ├── config.oauth
    │   │               ├── dto
    │   │               │   ├── AppleAccessTokenRes.java
    │   │               │   ├── ApplePublicKeyRes.java
    │   │               │   ├── AppleUserInfoRes.java
    │   │               │   ├── AppleClient.java
    │   │               └── AppleService.java
```

## ✅ Release Notes
* 0.0.1
    * 테스트

## 🔥 Issues

## 👥 Contributing
ozofweird

## 👤 Authors
- [ozofweird](https://github.com/ozofweird) - **Kevin Ahn**

## 🏷 License
ozofweird

## 📚 References
- [kevin-dev-oauth-apple-v1](https://github.com/ozofweird/kevin-dev-oauth-apple-v1.git)
- [Spring API서버에서 Apple 인증(로그인, 회원가입) 처리하기](https://hwannny.tistory.com/71)
- [openfeign maven repository](https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-openfeign-core)
- [우아한 feign 적용기](https://techblog.woowahan.com/2630/)
- [(Spring Cloud) Feign](https://supawer0728.github.io/2018/03/11/Spring-Cloud-Feign/)

---

## ✉️ Commit messages (Gitmoji)

|Gitmoji|Code|Description|
|:-----:|:---:|:--------:|
|🎨|art|파일/코드 구조 개선|
|🩹|adhesive_bandage|간단한 수정|
|⚡️|zap|성능 향상|
|🔥️|fire|코드나 파일 삭제|
|🐛️|bug|버그 해결|
|🚑️|ambulance|긴급 수정|
|✨️|sparkles|새로운 기능|
|📝️|memo|문서 추가/수정|
|💄️|lipstick|화면 UI 추가/수정|
|🎉️|tada|프로젝트 시작|
|✅️|white_check_mark|테스트 추가/수정|
|🔒️|lock|보안 이슈 수정|
|🔖️|bookmark|릴리즈/버전 태그|
|🚧|construction|작업 진행 중|
|💚|green_heart|CI 빌드 수정|
|⬇️|arrow_down|의존성 버전 다운|
|⬆️|arrow_up|의존성 버전 업|
|📌|pushpin|특정 버전 의존성 고정|
|👷|construction_worker|CI 빌드 시스템 추가/수정|
|📈|chart_with_upwards_trend|분석, 추적 코드 추가/수정|
|♻️|recycle|코드 리팩토링|
|➕|heavy_plus_sign|의존성 추가|
|➖|heavy_minus_sign|의존성 제거|
|🔧|wrench|설정 파일 추가/수정|
|🔨|hammer|개발 스크립트 추가/수정|
|🌐|globe_with_meridians|다국어 지원|
|💩|poop|안좋은 코드 추가|
|⏪|rewind|변경 내용 되돌리기|
|🔀|twisted_rightwards_arrows|브랜치 합병|
|👽|alien|외부 API 변화로 인한 수정|
|🚚|truck|리소스 이동/이름 변경|
|💥|boom|놀라운 기능 소개|
|🍱|bento|에셋 추가/수정|
|💡|bulb|주석 추가/수정|
|💬|speech_balloon|스트링 파일 추가/수정|
|🗃|card_file_box|데이버베이스 관련 수정|
|🔊|loud_sound|로그 추가/수정|
|🔇|mute|로그 삭제|
|📱|iphone|반응형 디자인|
|🙈|see_no_evil|gitignore 추가|
