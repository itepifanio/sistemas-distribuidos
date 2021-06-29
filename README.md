Compile todas as classes de `src/com/concord/` usando ` javac *.java `

Na pasta src rode:
`rmic com.concord.GroupMain`

Em seguida execute o servidor (ainda na pasta src):
`java com.concord.GroupServer`

Resumindo: 

```shell
javac com/concord/*.java && rmic com.concord.GroupMain && java com.concord.GroupServer
```

Lembrando que quando rodar o resumo você estará rodando somente o servidor, 
para rodar o cliente: `java com.concord.GroupClient`