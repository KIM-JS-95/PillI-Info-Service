#!/bin/bash

# Jenkins 에서 체크가 끝나면 해당 파일을 실행

container_name="ebkm";
repository="baugh248730/ebkm";

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
echo "bootJar. . ."
 ./gtadlew bootJar

echo "DockerFile start... and"
 docker build -t ebkm:latest .
 docker run -itd --name ${container_name} -p 8080:9090 ebkm:latest


echo "image push to docker hub"
docker tag ebkm baugh248730/ebkm:latest
docker push baugh248730/ebkm:latest
