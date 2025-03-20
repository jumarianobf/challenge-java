package br.com.fiap.challenge.service;

import br.com.fiap.challenge.model.UsuarioOdontoprev;

import java.util.List;

public interface UsuarioService {
    UsuarioOdontoprev criar(UsuarioOdontoprev usuario);
    List<UsuarioOdontoprev> listarTodos();
    UsuarioOdontoprev buscarPorId(Long id);
    UsuarioOdontoprev atualizar(Long id, UsuarioOdontoprev usuarioAtualizado);
    void deletar(Long id);
    UsuarioOdontoprev salvar(UsuarioOdontoprev usuario);
}
