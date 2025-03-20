package br.com.fiap.challenge.service;

import br.com.fiap.challenge.model.EnderecoUsuarioOdontoprev;

import java.util.List;

public interface EnderecoUsuarioService {
    EnderecoUsuarioOdontoprev criar(EnderecoUsuarioOdontoprev endereco);
    List<EnderecoUsuarioOdontoprev> listarTodos();
    EnderecoUsuarioOdontoprev buscarPorId(Long id);
    EnderecoUsuarioOdontoprev atualizar(Long id, EnderecoUsuarioOdontoprev enderecoAtualizado);
    void deletar(Long id);
    EnderecoUsuarioOdontoprev salvar(EnderecoUsuarioOdontoprev endereco);
    List<EnderecoUsuarioOdontoprev> listarTodosComUsuarios();
}
