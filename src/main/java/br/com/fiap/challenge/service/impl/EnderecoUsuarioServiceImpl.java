package br.com.fiap.challenge.service.impl;

import br.com.fiap.challenge.model.EnderecoUsuarioOdontoprev;
import br.com.fiap.challenge.repository.EnderecoUsuarioRepository;
import br.com.fiap.challenge.service.EnderecoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoUsuarioServiceImpl implements EnderecoUsuarioService {

    @Autowired
    private EnderecoUsuarioRepository enderecoUsuarioRepository;

    @Override
    public EnderecoUsuarioOdontoprev criar(EnderecoUsuarioOdontoprev endereco) {
        return enderecoUsuarioRepository.save(endereco);
    }

    @Override
    public List<EnderecoUsuarioOdontoprev> listarTodos() {
        return enderecoUsuarioRepository.findAll();
    }

    @Override
    public EnderecoUsuarioOdontoprev buscarPorId(Long id) {
        return enderecoUsuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço de usuário não encontrado"));
    }

    @Override
    public EnderecoUsuarioOdontoprev atualizar(Long id, EnderecoUsuarioOdontoprev enderecoAtualizado) {
        EnderecoUsuarioOdontoprev enderecoExistente = buscarPorId(id);
        enderecoExistente.setCepUsuario(enderecoAtualizado.getCepUsuario());
        enderecoExistente.setCidadeUsuario(enderecoAtualizado.getCidadeUsuario());
        enderecoExistente.setEstadoUsuario(enderecoAtualizado.getEstadoUsuario());
        enderecoExistente.setLogradouroUsuario(enderecoAtualizado.getLogradouroUsuario());
        enderecoExistente.setBairroUsuario(enderecoAtualizado.getBairroUsuario());
        enderecoExistente.setUsuario(enderecoAtualizado.getUsuario());

        return enderecoUsuarioRepository.save(enderecoExistente);
    }

    @Override
    public void deletar(Long id) {
        enderecoUsuarioRepository.deleteById(id);
    }

    @Override
    public EnderecoUsuarioOdontoprev salvar(EnderecoUsuarioOdontoprev endereco) {
        return criar(endereco);
    }

    @Override
    public List<EnderecoUsuarioOdontoprev> listarTodosComUsuarios() {
        // Supondo que você esteja usando Spring Data JPA
        return enderecoUsuarioRepository.findAllWithUsuarios();
    }
}
