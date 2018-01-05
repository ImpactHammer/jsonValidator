# jsonValidator


Build docker image from Gradle:



```bash

[sudo] ./gradlew createDockerImage

```



Run container built with Gradle:



```bash

sudo docker run --rm -p 80:80 validation-service

```



Send file for validation:


```bash

curl --upload-file filename.json http://localhost

```
