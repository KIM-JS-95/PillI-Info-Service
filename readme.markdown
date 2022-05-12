
![BE](https://user-images.githubusercontent.com/65659478/167803880-ca17061c-7949-4d4c-b3ca-81d38b3a0dbc.png)

# 알파 테스트
알파 테스트를 목적으로 Jenkins - Docker  -Github 으로 구성하여 로컬에서 운영할 계획이다.

1. GitHub push
2. Detecting from Jenkins and Building a file
3. Docker build to image and run Container


# jenkins run

jenkins 의 기본 포트는 `8080` 이지만 임의로 변경해 줍시다

```bash
docker run -p -d 9090:8080 -p 50000:50000 jenkins/jenkins
```


# Docker 업로드 방법

```
docker tag ebkm baugh248730/ebkm:latest
docker push baugh248730/ebkm:latest
```
## 베타 테스트

AWS EC2 로 전환하여 배포