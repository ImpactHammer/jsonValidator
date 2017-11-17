# jsonValidator
Run container:
```bash
sudo docker run --rm -d -p 80:80 impacthammer/jsonvalidator
```
Send file for validation:
```bash
curl --data-binary @filename.json http://localhost
```
