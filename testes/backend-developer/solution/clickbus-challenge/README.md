```                                                                                          
,------.                         ,-----. ,--.               ,--. ,--.                                  
|  .-.  \   ,---.  ,--.  ,--.   '  .--./ |  ,---.   ,--,--. |  | |  |  ,---.  ,--,--,   ,---.   ,---.  
|  |  \  : | .-. :  \  `'  /    |  |     |  .-.  | ' ,-.  | |  | |  | | .-. : |      \ | .-. | | .-. : 
|  '--'  / \   --.   \    /     '  '--'\ |  | |  | \ '-'  | |  | |  | \   --. |  ||  | ' '-' ' \   --. 
`-------'   `----'    `--'       `-----' `--' `--'  `--`--' `--' `--'  `----' `--''--' .`-  /   `----' 
                                                                                       `---'           
```

Backend Developer Challenge for clickbus selective process

## Requirements

For building and running the application you need:

- [Maven](http://maven.apache.org/download.cgi)
- [Lombok](https://projectlombok.org/) - Download the Lombok plugin for your IDE. This is required to add Lombok dependency support.


## Running

First, clone the project:

```shell
git clone https://github.com/vezixtor/quero-ser-clickbus.git
```

Go to the folder:

```shell
/testes/backend-developer/solution/clickbus-challenge/
```

From project root directory run:

```shell
mvn spring-boot:run
```


## Executing requests

[swagger](https://clickbus-challenge.herokuapp.com/swagger-ui.html) - Api Documentation


Or


[![Run in Postman](https://run.pstmn.io/button.svg)](https://www.getpostman.com/collections/f7a9aab8c91811bfb276)

##  Testing

Unit test
```shell
mvn test
```

Integration test
```shell
mvn test-compile failsafe:integration-test
```

## Built With

- [Java](https://www.java.com/) - Programming language
- [Spring](https://spring.io/) - Web Framework
- [IntelliJ](https://www.jetbrains.com/idea/) - IDE
- [Maven](https://maven.apache.org/) - Dependency Management