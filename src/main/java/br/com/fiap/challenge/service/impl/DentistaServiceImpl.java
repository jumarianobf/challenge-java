package br.com.fiap.challenge.service.impl;

import br.com.fiap.challenge.model.DentistaOdontoprev;
import br.com.fiap.challenge.repository.DentistaRepository;
import br.com.fiap.challenge.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistaServiceImpl implements DentistaService {

    private final DentistaRepository dentistaRepository;

    @Autowired
    public DentistaServiceImpl(DentistaRepository dentistaRepository) {
        this.dentistaRepository = dentistaRepository;
    }

    @Override
    public DentistaOdontoprev criar(DentistaOdontoprev dentista) {
        return dentistaRepository.save(dentista);
    }

    @Override
    public List<DentistaOdontoprev> listarTodos() {
        return dentistaRepository.findAll();
    }

    @Override
    public DentistaOdontoprev buscarPorId(Long id) {
        return dentistaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dentista não encontrado"));
    }

    @Override
    public DentistaOdontoprev atualizar(Long id, DentistaOdontoprev dentistaAtualizado) {
        DentistaOdontoprev dentistaExistente = buscarPorId(id);
        dentistaExistente.setNomeDentista(dentistaAtualizado.getNomeDentista());
        dentistaExistente.setEspecialidade(dentistaAtualizado.getEspecialidade());
        dentistaExistente.setTelefoneDentista(dentistaAtualizado.getTelefoneDentista());
        dentistaExistente.setEmailDentista(dentistaAtualizado.getEmailDentista());
        dentistaExistente.setClinica(dentistaAtualizado.getClinica());
        dentistaExistente.setUsuario(dentistaAtualizado.getUsuario());

        return dentistaRepository.save(dentistaExistente);
    }

    @Override
    public void deletar(Long id) {
        dentistaRepository.deleteById(id);
    }

    @Override
    public DentistaOdontoprev salvar(DentistaOdontoprev dentista) {
        return criar(dentista);
    }
}
