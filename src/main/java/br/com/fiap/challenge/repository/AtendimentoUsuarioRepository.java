package br.com.fiap.challenge.repository;

import br.com.fiap.challenge.model.AtendimentoUsuarioOdontoprev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendimentoUsuarioRepository extends JpaRepository<AtendimentoUsuarioOdontoprev, Long> {
}
