package github.curso.spring.arquiteturaspring.montadora.configuration;

import github.curso.spring.arquiteturaspring.montadora.Motor;
import github.curso.spring.arquiteturaspring.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MontadoraConfiguration {

    @Bean(name = "motorTurbo")
    public Motor motorTurbo() {
        var motor = new Motor();
        motor.setCavalos(120);
        motor.setCilindros(4);
        motor.setModelo("Onix-Turbo");
        motor.setLitragem(1.0);
        motor.setTipo(TipoMotor.TURBO);
        return motor;
    }

    @Bean(name = "motorEletrico")
    @Primary //Informa que este é o bean primário evitando o erro múltiplos de beans
    public Motor motorEletrico() {
        var motor = new Motor();
        motor.setCavalos(500);
        motor.setCilindros(6);
        motor.setModelo("TE-40");
        motor.setLitragem(1.4);
        motor.setTipo(TipoMotor.ELETRICO);
        return motor;
    }

    @Bean(name = "motorAspirado")
    public Motor motorAspirado() {
        var motor = new Motor();
        motor.setCavalos(250);
        motor.setCilindros(6);
        motor.setModelo("Cruze");
        motor.setLitragem(2.5);
        motor.setTipo(TipoMotor.ASPIRADO);
        return motor;
    }
}
