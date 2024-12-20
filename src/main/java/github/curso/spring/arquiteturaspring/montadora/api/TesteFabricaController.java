package github.curso.spring.arquiteturaspring.montadora.api;

import github.curso.spring.arquiteturaspring.montadora.CarroStatus;
import github.curso.spring.arquiteturaspring.montadora.Chave;
import github.curso.spring.arquiteturaspring.montadora.ChevroletOnix;
import github.curso.spring.arquiteturaspring.montadora.Motor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carros")
public class TesteFabricaController {

    @Qualifier("motorEletrico")
    @Autowired
    private Motor motor;

    @PostMapping
    public CarroStatus ligarCarro(@RequestBody Chave chave){
        var carro = new ChevroletOnix(motor);
        return carro.darIgnicao(chave);
    }
}
