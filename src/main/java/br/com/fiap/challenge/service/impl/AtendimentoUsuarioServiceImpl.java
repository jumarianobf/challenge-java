package br.com.fiap.challenge.service.impl;

import br.com.fiap.challenge.model.AtendimentoUsuarioOdontoprev;
import br.com.fiap.challenge.repository.AtendimentoUsuarioRepository;
import br.com.fiap.challenge.repository.UsuarioRepository;
import br.com.fiap.challenge.service.AtendimentoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendimentoUsuarioServiceImpl implements AtendimentoUsuarioService {

    @Autowired
    private AtendimentoUsuarioRepository atendimentoUsuarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<AtendimentoUsuarioOdontoprev> listarTodos() {
        return atendimentoUsuarioRepository.findAll();
    }

    @Override
    public AtendimentoUsuarioOdontoprev buscarPorId(Long id) {
        return atendimentoUsuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atendimento não encontrado"));
    }

    @Override
    public AtendimentoUsuarioOdontoprev criar(AtendimentoUsuarioOdontoprev atendimento) {
        return atendimentoUsuarioRepository.save(atendimento);
    }

    @Override
    public AtendimentoUsuarioOdontoprev atualizar(Long id, AtendimentoUsuarioOdontoprev atendimentoAtualizado) {
        AtendimentoUsuarioOdontoprev atendimentoExistente = buscarPorId(id);
        atendimentoExistente.setUsuario(atendimentoAtualizado.getUsuario());
        atendimentoExistente.setDentista(atendimentoAtualizado.getDentista());
        atendimentoExistente.setClinica(atendimentoAtualizado.getClinica());
        atendimentoExistente.setDataAtendimento(atendimentoAtualizado.getDataAtendimento());
        atendimentoExistente.setDescricaoProcedimento(atendimentoAtualizado.getDescricaoProcedimento());
        atendimentoExistente.setCusto(atendimentoAtualizado.getCusto());

        return atendimentoUsuarioRepository.save(atendimentoExistente);
    }

    @Override
    public void deletar(Long id) {
        atendimentoUsuarioRepository.deleteById(id);
    }
}
