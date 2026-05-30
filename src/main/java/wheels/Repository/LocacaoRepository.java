package wheels.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wheels.Classes.Locacao;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Integer> {
}
