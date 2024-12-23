package github.curso.spring.arquiteturaspring;

import github.curso.spring.arquiteturaspring.todos.TodoEntity;
import github.curso.spring.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Lazy(false) // Por padrão é true e significa que só é instaciado quando é chamado, só faz sentido quando por padrão são todos true
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
//@Scope(WebApplicationContext.SCOPE_APPLICATION) para scopos que são da web
//@Scope("singleton")
//@Scope("request")
//@Scope("session")
//@Scope("application")
public class BeanGerenciado {

    @Autowired // Injeção pela propriedade sem precisar de um construtor
    private TodoValidator validator;

    public void utilizar() {
        var todo = new TodoEntity();
        validator.validarDescricao(todo);
    }

    // Via setter cria um setter e atribuir ao parâmetro
    @Autowired
    public void setValidator(TodoValidator validator) {
        this.validator = validator;
    }

    @Autowired // Não é obrigatório usar o Autowired
    // Via construtor é o recomendado pelo spring
    public BeanGerenciado(TodoValidator validator) {
        this.validator = validator;
    }
}
