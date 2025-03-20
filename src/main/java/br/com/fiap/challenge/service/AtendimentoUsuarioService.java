package br.com.fiap.challenge.service;

import br.com.fiap.challenge.model.AtendimentoUsuarioOdontoprev;

import java.util.List;

public interface AtendimentoUsuarioService {
    List<AtendimentoUsuarioOdontoprev> listarTodos();
    AtendimentoUsuarioOdontoprev buscarPorId(Long id);
    AtendimentoUsuarioOdontoprev criar(AtendimentoUsuarioOdontoprev atendimento);
    AtendimentoUsuarioOdontoprev atualizar(Long id, AtendimentoUsuarioOdontoprev atendimentoAtualizado);
    void deletar(Long id);
}
