package br.com.fiap.challenge.service;

import br.com.fiap.challenge.model.ContatoUsuarioOdontoprev;

import java.util.List;

public interface ContatoUsuarioService {
    ContatoUsuarioOdontoprev criar(ContatoUsuarioOdontoprev contato);
    List<ContatoUsuarioOdontoprev> listarTodos();
    ContatoUsuarioOdontoprev buscarPorId(Long id);
    ContatoUsuarioOdontoprev atualizar(Long id, ContatoUsuarioOdontoprev contatoAtualizado);
    void deletar(Long id);
    ContatoUsuarioOdontoprev salvar(ContatoUsuarioOdontoprev contato);
}
