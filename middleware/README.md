## Trabalho

Uma aplicação que guarde dados de filmes provenientes de canais de TV, incluindo  o gênero cinematográfico (drama, romance, policial, suspense, faroeste), notifique clientes no dia/hora previso para exibição de um filme do gênero de seu interesse e represente os dados dos diferentes filmes e o canal de sua exibição em uma interface gráfica.

### Midleware

Aplicação utilizando FIWARE e WireCloud.


### Instalando FIWARE

Pode-se ver a [documentação do FIWARE aqui](https://fiware-tutorials.readthedocs.io/en/latest/getting-started.html#option-2-using-docker-compose). Utiliza a instalação docker.

```
docker pull mongo:4.2
docker pull fiware/orion
docker network create fiware_default
docker run -d --name=mongo-db --network=fiware_default \
  --expose=27017 mongo:4.2 --bind_ip_all
docker run -d --name fiware-orion -h orion --network=fiware_default \
  -p 1026:1026  fiware/orion -dbhost mongo-db
```

### Instalando WireCloud

A documentação do WireCloud pode ser [vista aqui](https://wirecloud.readthedocs.io/en/stable/installation_guide/).

Criou-se uma env para gerir o wirecloud. O arquivo de requirements necessário para instalação pode ser visto abaixo. (essa instalação não utilizou o docker). Ele deve ser criado após criar o projeto no ` /opt ` utilizando o seguinte comando: ` wirecloud-admin startproject wirecloud_instance --quick-start `.

PS: Precisou utilizar o  python 3.6

```
wirecloud
Django==1.10
lxml
django-appconf==1.0.1
django_compressor==2.0
rdflib==3.2.0
requests==2.1.0
selenium==3.4
pytz
django_relatives==0.3.1
user-agents
regex
markdown
django-haystack==2.4.1
whoosh==2.7.2
pycrypto
pyScss
Pygments
pillow
jsonpatch
pyOpenSSL
ndg-httpsclient 
pyasn1
```
