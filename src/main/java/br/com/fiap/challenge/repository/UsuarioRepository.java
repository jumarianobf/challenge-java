package br.com.fiap.challenge.repository;

import br.com.fiap.challenge.model.UsuarioOdontoprev;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioOdontoprev, Long>  {
    boolean existsByCpf(String cpf);
}
