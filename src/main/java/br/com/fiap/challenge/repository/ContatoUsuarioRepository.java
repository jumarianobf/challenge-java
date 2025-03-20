package br.com.fiap.challenge.repository;

import br.com.fiap.challenge.model.ContatoUsuarioOdontoprev;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoUsuarioRepository extends JpaRepository<ContatoUsuarioOdontoprev, Long> {
}
