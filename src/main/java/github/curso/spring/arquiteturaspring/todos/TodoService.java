package github.curso.spring.arquiteturaspring.todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository repository;
    private TodoValidator validator;
    private MailSender mailSender;

    public TodoService(TodoRepository repository, TodoValidator validator, MailSender mailSender) {
        this.repository = repository;
        this.validator = validator;
        this.mailSender = mailSender;
    }

    public TodoEntity salvar (TodoEntity novoTodo) {
        validator.validarDescricao(novoTodo);
        return repository.save(novoTodo);
    }

    public void atualizarStatus(TodoEntity todo) {
        repository.save(todo);
        String status = todo.getCompleted() == Boolean.TRUE ? "Concluído" : "Não concluído";
        mailSender.sendMail("TODO: " + todo.getDescription() + " foi atualizado para " + status);
    }

    public TodoEntity buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
