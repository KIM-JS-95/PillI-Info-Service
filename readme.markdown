<br>
<br>
<br>

<div align="center">

# 💊 Project. EBKM 💊

## Eat Before Knowing The Medicine

<br>
<br>
<br>


![](presentation/pngegg.ico)

</div>
<br>
<br>
<br>

# 💊 INTRO
### 「 아들! ‘프로프라놀롤’ 효능이 뭐니? 」

    프로젝트는 엄마의 한마디에서 시작되었습니다.
    대한민국의 부모님께 안전하게 약을 복용해 드리고 싶은 마음에서 개발했습니다.
    이제는 인터넷으로 찾지 말고 검색 한 번으로 정보를 찾으세요!

### 「 Son! What's the effect of propranolol? 」

    The project started with my mother's words.
    I developed it with the desire to take medicine safely to my parents in Korea.
    Don't look it up on the Internet anymore, just search for information!

<br>
<br>
<br>

# 💊 Tools

<div align="center">

## 🍃 Language & FrameWork

![s](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![s](https://img.shields.io/badge/SPRINGBOOT-6DB33F?style=for-the-badge&logo=SPRINGBOOT&logoColor=white)
## 🍃 Infra

![Docker](https://img.shields.io/badge/docker-2496ED.svg?style=for-the-badge&logo=docker&logoColor=white)
![Jenkins](https://img.shields.io/badge/jenkins-D24939.svg?style=for-the-badge&logo=jenkins&logoColor=white)
![AWS](https://img.shields.io/badge/AWS-232F3E.svg?style=for-the-badge&logo=amazon-aws&logoColor=white)

</div>
<br>
<br>
<br>

# 💊 구성도

![BE](./presentation/BE.png)


# 💊 Do you want to clone this Repo?

## 🍃 Step 1
- Add application.properties
  - [공공데이터포털](https://www.data.go.kr/) 에서 `Open_API`를 적용해 주세요. 

```properties
server.port=8080

pillUrl ="End Point"

medic.client.Encoding="Your Encoding Key"
medic.client.Decoding="Your Decoding Key"
```


## 🍃 Step 2

<div align="center">

### ❗❗ 주의사항 ❗❗

#### 다음 `shell`파일은 최종 배포 과정을 자동화하는 자동스크립트 파일 입니다.
#### 🙅‍♂️ 개인 설정에 맞추어 사용해 주세요. 🙅‍♂️

### ❗❗ NOTICE ❗❗


#### The following 'shell' file is an automated script file that automates the final deployment process.

#### 🙅‍♂️  Please use it according to your personal settings. 🙅‍♂️
</div>

### deploy.sh

```shell
container_name="Container_name";
repository="Your Docker Repository name";

# 기존 컨테이너 정지 후 이미지 제거
echo "Container stop and remove";

# shellcheck disable=SC1007
container_id=$(docker ps -aqf "name= ${container}");

echo "Docker : container_id = ${container_id}";

echo "Container stop"
docker stop ${container_id}
docker rm ${container_id}

echo "Docker image remove"
docker rmi ${repository}

# jar 파일을 만들고 이미지로 만들기

echo "DockerFile start. . ."
 docker build -t ebkm:latest .
 docker run -d --name ${container_name} -p 8080:8080 ebkm:latest


echo "image push to docker hub"
docker tag ebkm ${repository}:latest
docker push ${repository}:latest

```

## 🍃 Using
### Don't use `deploy.sh`
### you should this comment

```
docker-compose up -d
```

# 💊 Reference
<div align="center">

<img width="200" height="100" src="https://openmate-on.com/data-on/upload/origin-site-logo/%EA%B3%B5%EA%B3%B5%EB%8D%B0%EC%9D%B4%ED%84%B0%ED%8F%AC%ED%84%B8.png">


</div>

<br>

# 💊 더 자세한 정보는 노션에서 확인해 주세요!

<div align="center">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="https://json0506.notion.site/EBKM-c2fde8692fec4cafb1ac7c647adb7598">
<img width="100" height="100" src="https://www.inthenews.co.kr/data/photos/uploads/2020/08/%EC%9D%B4%EB%AF%B8%EC%A7%80-%EB%85%B8%EC%85%98-%EB%A1%9C%EA%B3%A0.jpg">
</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="https://github.com/KIM-JS-95/PillInfoservice_FE">
<img width="200" height="100" src="https://velog.velcdn.com/images/gil0127/post/857b454c-74a1-4fbc-b00f-3d0aff6f1a55/111111111.png">
</a>

🔺 Jason's Notion 으로 이동! &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 🔺 Front_End Part 로 이동!

</div>