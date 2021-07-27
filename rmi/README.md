Compile todas as classes de usando ` javac com/client/*.java com/objects/*.java com/server/*.java `

Na pasta src rode:
`rmic com.server.GroupServer`

Em seguida execute o servidor (ainda na pasta src):
`java com.server.Main`

Resumindo: 

```shell
javac com/client/*.java com/objects/*.java com/server/*.java
&&
rmic com.server.GroupServer
&&
java com.server.Main
```

Lembrando que quando rodar o resumo você estará rodando somente o servidor, 
para rodar o cliente: `java com.client.Main`