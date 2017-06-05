# webframeworks

Projeto para a Pós Graduação Desenvolvimento de Aplicações para WEB Webframeworks

### Autores

-Vinícius Enéas Bezerra

-Jafet Gomes

-Nélio Frazão

### Tecnologias
| Back-End | Front-End |
| ------ | ------ |
| Spring Boot | Thymeleaf |
| Spring MVC | Bootstrap |
| Spring Security| HTML5 |
| Spring Core | CSS3 |
| Spring ORM | JQuery |
| Hibernate |
| JSP |
| JPA |

### Tecnologias Controle de Dependências

Maven

### Tecnologias Banco de Dados

MySQL

Executar as querys abaixo.

Usuário.: admin Senha.: abc125

- User

INSERT INTO app_user(nome, email, password, ativo )
VALUES ('Vinícius','vinicius.eneas@gmail.com','$2a$10$4eqIF5s/ewJwHK1p8lqlFOEm2QIA0S8g6./Lok.pQxqcxaBZYChRm', true);

- Roles

INSERT INTO `roles`(`role_id`, `type`) VALUES (1, "ADMIN");
INSERT INTO `roles`(`role_id`, `type`) VALUES (2, "USER");

License

- GPL
