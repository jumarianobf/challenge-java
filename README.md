# 🦷 Parrot Tech

## Integrantes do Grupo

- **Julia Mariano Barsotti Ferreira - RM552713**
- **Leonardo Gaspar Saheb - RM553383**
- **Caio Eduardo Nascimento Martins - RM554025**

## Descrição e Proposta de solução

O objetivo deste projeto é aplicar técnicas de análise preditiva para a redução de sinistros, utilizando processamento de imagens, reutilização de dados e modularidade.

A solução foi projetada para otimizar o atendimento ao cliente e prever incidentes antes que ocorram, melhorando a eficiência e a precisão no gerenciamento de sinistros. A análise preditiva é realizada utilizando dados históricos de atendimentos e outros parâmetros de risco.

## Estrutura do Sistema

A aplicação segue o padrão MVC (Model-View-Controller):

- Model: Representa as entidades do sistema, como usuários, dentistas e clínicas.
- View: Utiliza Thymeleaf para renderizar as páginas HTML, permitindo uma interação dinâmica e responsiva.
- Controller: Controla a lógica da aplicação, gerencia o fluxo de dados e interage com a camada de visualização.

## Características
- CRUD completo para usuários, dentistas, clínicas e endereços, atendimentos, previsões, imagens e contatos.
- Integração com Oracle Database para armazenamento de dados.
- Interface web dinâmica utilizando Thymeleaf para renderização de templates.
- Spring MVC para controle e gerenciamento da lógica da aplicação.
- Processamento de imagens odontológicas para análise visual.
- Modularidade e flexibilidade para fácil escalabilidade e manutenção.

## Tecnologia

- 🚀 Java 21
- 🧰 Spring MVC
- 💾 Thymeleaf
- 💻 Oracle Database (SID: ORCL)
- 💻 Spring Boot

## 📈 Diagramas
![Odontoprev drawio (sprint_3)](https://github.com/user-attachments/assets/0cc6e5ae-e087-496a-b873-5f29ebf3d6e9)

![Odontoprev drawio (sprint_3 1)](https://github.com/user-attachments/assets/999ff54c-fbe9-4ffa-a667-3e099af1ee42)




## Pré-requisitos
- JDK 17 ou superior
- Maven ou Gradle
- IDE (como IntelliJ IDEA, Eclipse, ou VS Code)
- Banco de dados Oracle configurado localmente ou remotamente

## Instruções para Rodar a Aplicação

**1️⃣ Clone o repositório:**
```
git clone https://github.com/challenge-java-url.git
cd challenge-java
```

**2️⃣ Configure o banco de dados no arquivo application.properties:**

Adicione as configurações do banco Oracle:
```
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:ORCL
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha
```

**3️⃣ Compile e execute o projeto:**
```
mvn spring-boot:run
```
Ou, caso esteja utilizando Gradle:
```
./gradlew bootRun
```

**4️⃣ Acesse a aplicação no navegador:**
```
http://localhost:8080
```

## Exemplos de Teste
- View
- ![image](https://github.com/user-attachments/assets/a355dea3-bf9e-4c13-8a14-1cd5c9618ab3)

- Oracle SQL
- ![image](https://github.com/user-attachments/assets/860c28b0-2a76-4ab7-b8b0-ec877de8678f)


## 📜 Licença

- 📝 Este projeto é de uso acadêmico - FIAP.


