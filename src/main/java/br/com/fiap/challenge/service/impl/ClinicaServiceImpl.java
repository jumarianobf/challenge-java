package br.com.fiap.challenge.service.impl;

import br.com.fiap.challenge.model.ClinicaOdontoprev;
import br.com.fiap.challenge.repository.ClinicaRepository;
import br.com.fiap.challenge.service.ClinicaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicaServiceImpl implements ClinicaService {

    @Autowired
    private ClinicaRepository clinicaRepository;

    @Override
    public ClinicaOdontoprev criar(ClinicaOdontoprev clinica) {
        return clinicaRepository.save(clinica);
    }

    @Transactional
    @Override
    public List<ClinicaOdontoprev> listarTodas() {
        List<ClinicaOdontoprev> clinicas = clinicaRepository.findAll();

        for (ClinicaOdontoprev clinica : clinicas) {
            if (clinica.getEnderecos() != null) {
                clinica.getEnderecos().size();
            }
        }
        return clinicas;
    }

    @Override
    public ClinicaOdontoprev buscarPorId(Long id) {
        return clinicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clínica não encontrada"));
    }

    @Override
    public ClinicaOdontoprev atualizar(Long id, ClinicaOdontoprev clinicaAtualizada) {
        ClinicaOdontoprev clinicaExistente = buscarPorId(id);
        clinicaExistente.setNomeClinica(clinicaAtualizada.getNomeClinica());
        clinicaExistente.setTelefoneClinica(clinicaAtualizada.getTelefoneClinica());

        return clinicaRepository.save(clinicaExistente);
    }

    @Override
    public void deletar(Long id) {
        clinicaRepository.deleteById(id);
    }

    @Override
    public ClinicaOdontoprev salvar(ClinicaOdontoprev clinica) {
        return criar(clinica);
    }
}
