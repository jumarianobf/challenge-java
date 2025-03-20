package br.com.fiap.challenge.repository;

import br.com.fiap.challenge.model.ClinicaOdontoprev;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicaRepository extends JpaRepository<ClinicaOdontoprev, Long> {
}
