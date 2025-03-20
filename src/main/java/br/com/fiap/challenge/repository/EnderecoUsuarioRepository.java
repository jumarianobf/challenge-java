package br.com.fiap.challenge.repository;

import br.com.fiap.challenge.model.EnderecoUsuarioOdontoprev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnderecoUsuarioRepository extends JpaRepository<EnderecoUsuarioOdontoprev, Long> {
    // Supondo que você esteja usando Spring Data JPA
    @Query("SELECT e FROM EnderecoUsuarioOdontoprev e JOIN FETCH e.usuario")
    List<EnderecoUsuarioOdontoprev> findAllWithUsuarios();
}

