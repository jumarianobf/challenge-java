package br.com.fiap.challenge.repository;

import br.com.fiap.challenge.model.DentistaOdontoprev;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistaRepository extends JpaRepository<DentistaOdontoprev, Long> {
}
