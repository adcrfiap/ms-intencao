package br.com.fiap.arremate.msintensao.repositories;

import br.com.fiap.arremate.msintensao.entities.Intensao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntensaoRepository extends JpaRepository<Intensao, Long> {

    Intensao findByIdIntensao(Long id);
}
