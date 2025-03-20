package br.com.fiap.challenge.service;

import br.com.fiap.challenge.model.DentistaOdontoprev;

import java.util.List;

public interface DentistaService {
    DentistaOdontoprev criar(DentistaOdontoprev dentista);
    List<DentistaOdontoprev> listarTodos();
    DentistaOdontoprev buscarPorId(Long id);
    DentistaOdontoprev atualizar(Long id, DentistaOdontoprev dentistaAtualizado);
    void deletar(Long id);
    DentistaOdontoprev salvar(DentistaOdontoprev dentista);
}
