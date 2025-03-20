package br.com.fiap.challenge.repository;

import br.com.fiap.challenge.model.PrevisaoUsuarioOdontoprev;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrevisaoUsuarioRepository extends JpaRepository<PrevisaoUsuarioOdontoprev, Long> {
}
