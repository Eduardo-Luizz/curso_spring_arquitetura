package github.curso.spring.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private TodoRepository repository;

    public TodoValidator(TodoRepository repository) {
        this.repository = repository;
    }

    public void validarDescricao(TodoEntity todo) {
        if (existeTodoComDescricao(todo.getDescription())){
            throw new IllegalArgumentException("Já existe um TODO com está descrição");
        }
    }

    private boolean existeTodoComDescricao(String descricao) {
        return repository.existsByDescription(descricao);
    }
}
