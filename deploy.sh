#!/bin/bash

# Jenkins 에서 체크가 끝나면 해당 파일을 실행

container_name="ebkm";
repository="baugh248730/ebkm";

# 기존 컨테이너 정지 후 이미지 제거
echo "Container stop and remove";

# shellcheck disable=SC1007
container_id=$(docker ps -aqf "name= ${container_name}");

echo "Docker : container_id = ${container_id}";

echo "Container stop"
docker stop ${container_id}
docker rm ${container_id}

echo "Docker image remove"
docker rmi ${container_name}

cd proxy

echo "Run Nginx ..."
docker build -t nginx:test .

echo "Change dir ... "
cd ..

# gradle build
echo "DockerFile start... and"
docker build -t ebkm:latest .


sudo chmod 666 /var/run/docker.sock

echo "Docker compose up start ... "
sudo service jenkins restart && docker-compose up -d



#echo "image push to docker hub"
#docker tag ebkm baugh248730/ebkm:latest
#docker push ${repository}
