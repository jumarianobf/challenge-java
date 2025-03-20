package br.com.fiap.challenge.service;

import br.com.fiap.challenge.model.EnderecoClinicaOdontoprev;

import java.util.List;

public interface EnderecoClinicaService {
    EnderecoClinicaOdontoprev criar(EnderecoClinicaOdontoprev endereco);
    List<EnderecoClinicaOdontoprev> listarTodos();
    EnderecoClinicaOdontoprev buscarPorId(Long id);
    EnderecoClinicaOdontoprev atualizar(Long id, EnderecoClinicaOdontoprev enderecoAtualizado);
    void deletar(Long id);
    EnderecoClinicaOdontoprev salvar(EnderecoClinicaOdontoprev endereco);
}
