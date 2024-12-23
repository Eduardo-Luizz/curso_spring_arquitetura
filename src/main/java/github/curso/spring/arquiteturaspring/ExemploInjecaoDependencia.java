package github.curso.spring.arquiteturaspring;

import github.curso.spring.arquiteturaspring.todos.*;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;

public class ExemploInjecaoDependencia {

    public static void main(String[] args) throws Exception {

        // Exemplo se fosse criar uma aplicação sem injeção de dependência

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("url");
        dataSource.setUsername("username");
        dataSource.setPassword("password");

        Connection connection = dataSource.getConnection();

        EntityManager entityManager = null;

        TodoRepository repository = null; // new SimpleJpaRepository<TodoEntity, Integer>();
        TodoValidator todoValidator = new TodoValidator(repository);
        MailSender mailSender = new MailSender();

        TodoService todoService = new TodoService(repository, todoValidator, mailSender);

        // Repare na quantidade de código que é necessária sem a injeção de dependencia e inversão de dependencia
    }

}
