## springbootrest
Поднятие Кластера в AWS Elastic Kubernetes Service - EKS:<br>
<code>
- sudo su<br>
- apt install python3-pip<br>
- pip3 install awscli --upgrade<br>
- mkdir /kubernetes/ - создаем директорию для хранения файлов eksctl<br>
- curl --silent --location "https://github.com/weaveworks/eksctl/releases/download/v0.88.0/eksctl_Linux_amd64.tar.gz" | tar xz -C /kubernetes <br>
- curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl" <br>
- chmod +x kubectl - даем права <br>
- echo *export PATH=$PATH:/kubernetes/* >> /etc/bash.bashrc - добавляем пути <br>
- создаем в aws пользователя и проводим аутентификацию
- ВАЖНО: это платно, можно использовать бесплатный ресурс https://labs.play-with-k8s.com

</code>

### Контакты для связи<br>
<img src="https://img.icons8.com/clouds/100/000000/gmail-new.png" width="10"/> arvikvan@gmail.com<br>
<img src="https://img.icons8.com/color/100/000000/telegram-app--v2.png" width="10"/> @ArvikV

###Используемые технологии:
- Maven
- Hibernate/JPA
- PostgreSQL
- Spring boot, REST
