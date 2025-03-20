package br.com.fiap.challenge.service;

import br.com.fiap.challenge.model.PrevisaoUsuarioOdontoprev;

import java.util.List;

public interface PrevisaoUsuarioService {
    PrevisaoUsuarioOdontoprev criar(PrevisaoUsuarioOdontoprev previsao);
    List<PrevisaoUsuarioOdontoprev> listarTodos();
    PrevisaoUsuarioOdontoprev buscarPorId(Long id);
    PrevisaoUsuarioOdontoprev atualizar(Long id, PrevisaoUsuarioOdontoprev previsaoAtualizada);
    void deletar(Long id);
    PrevisaoUsuarioOdontoprev salvar(PrevisaoUsuarioOdontoprev previsao);
}
