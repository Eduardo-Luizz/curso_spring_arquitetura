package github.curso.spring.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class MailSender {
    public void sendMail(String message) {
        System.out.println("Enviando email: " + message);
    }
}
