# jsonValidator
Run container:
  with maven:
```bash
sudo docker build -t validation-service github.com/impacthammer/jsonvalidator && sudo docker run --rm -p 80:80 validation-service
```
  with gradle:
  ```bash
sudo docker build -t validation-service github.com/ImpactHammer/jsonValidator/tree/gradle && sudo docker run --rm -p 80:80 validation-service
```

Send file for validation:
```bash
curl --data-binary @filename.json http://localhost
```
