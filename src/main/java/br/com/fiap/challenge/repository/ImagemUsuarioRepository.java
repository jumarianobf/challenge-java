package br.com.fiap.challenge.repository;

import br.com.fiap.challenge.model.ImagemUsuarioOdontoprev;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagemUsuarioRepository extends JpaRepository<ImagemUsuarioOdontoprev, Long> {
}
