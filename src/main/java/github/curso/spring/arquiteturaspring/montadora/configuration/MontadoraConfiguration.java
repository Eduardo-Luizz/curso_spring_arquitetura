package github.curso.spring.arquiteturaspring.montadora.configuration;

import github.curso.spring.arquiteturaspring.montadora.Motor;
import github.curso.spring.arquiteturaspring.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MontadoraConfiguration {

    @Bean
    public Motor motor() {
        var motor = new Motor();
        motor.setCavalos(120);
        motor.setCilindros(4);
        motor.setModelo("Onix-Turbo");
        motor.setLitragem(1.0);
        motor.setTipo(TipoMotor.TURBO);
        return motor;
    }
}
