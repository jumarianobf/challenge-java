package br.com.fiap.challenge.service.impl;

import br.com.fiap.challenge.model.PrevisaoUsuarioOdontoprev;
import br.com.fiap.challenge.repository.PrevisaoUsuarioRepository;
import br.com.fiap.challenge.service.PrevisaoUsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrevisaoUsuarioServiceImpl implements PrevisaoUsuarioService {

    private final PrevisaoUsuarioRepository previsaoUsuarioRepository;

    public PrevisaoUsuarioServiceImpl(PrevisaoUsuarioRepository previsaoUsuarioRepository) {
        this.previsaoUsuarioRepository = previsaoUsuarioRepository;
    }

    @Override
    public PrevisaoUsuarioOdontoprev criar(PrevisaoUsuarioOdontoprev previsao) {
        return previsaoUsuarioRepository.save(previsao);
    }

    @Override
    public List<PrevisaoUsuarioOdontoprev> listarTodos() {
        return previsaoUsuarioRepository.findAll();
    }

    @Override
    public PrevisaoUsuarioOdontoprev buscarPorId(Long id) {
        return previsaoUsuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Previsão de usuário não encontrada"));
    }

    @Override
    public PrevisaoUsuarioOdontoprev atualizar(Long id, PrevisaoUsuarioOdontoprev previsaoAtualizada) {
        PrevisaoUsuarioOdontoprev previsaoExistente = buscarPorId(id);
        previsaoExistente.setImagemUsuario(previsaoAtualizada.getImagemUsuario());
        previsaoExistente.setUsuario(previsaoAtualizada.getUsuario());
        previsaoExistente.setPrevisaoTexto(previsaoAtualizada.getPrevisaoTexto());
        previsaoExistente.setProbabilidade(previsaoAtualizada.getProbabilidade());
        previsaoExistente.setRecomendacao(previsaoAtualizada.getRecomendacao());
        previsaoExistente.setDataPrevisao(previsaoAtualizada.getDataPrevisao());

        return previsaoUsuarioRepository.save(previsaoExistente);
    }

    @Override
    public void deletar(Long id) {
        previsaoUsuarioRepository.deleteById(id);
    }

    @Override
    public PrevisaoUsuarioOdontoprev salvar(PrevisaoUsuarioOdontoprev previsao) {
        return criar(previsao);
    }
}
