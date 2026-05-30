package wheels.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wheels.Classes.Bicicleta;

@Repository // <-- Avisa ao Spring que este componente cuidará do acesso aos dados da Bicicleta
public interface BicicletaRepository extends JpaRepository<Bicicleta, Integer> {
    // A mágica está aqui! Ao estender JpaRepository, o Spring nos dá de graça métodos como:
    // .save(), .findAll(), .findById(), .deleteById(), etc.
    // Passamos <Bicicleta, Integer> porque a entidade é Bicicleta e o tipo da Chave Primária (ID) é int/Integer.
}