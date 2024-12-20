package github.curso.spring.arquiteturaspring.montadora;

import java.awt.*;

public class ChevroletOnix extends Carro {

    public ChevroletOnix(Motor motor) {
        super(motor);
        setModelo("Onix");
        setCor(Color.BLACK);
        setMontadora(Montadora.CHEVROLET);
    }
}
