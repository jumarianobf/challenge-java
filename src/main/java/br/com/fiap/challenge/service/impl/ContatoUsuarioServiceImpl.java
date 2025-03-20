package br.com.fiap.challenge.service.impl;

import br.com.fiap.challenge.model.ContatoUsuarioOdontoprev;
import br.com.fiap.challenge.repository.ContatoUsuarioRepository;
import br.com.fiap.challenge.service.ContatoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoUsuarioServiceImpl implements ContatoUsuarioService {

    @Autowired
    private ContatoUsuarioRepository contatoUsuarioRepository;

    @Override
    public ContatoUsuarioOdontoprev criar(ContatoUsuarioOdontoprev contato) {
        return contatoUsuarioRepository.save(contato);
    }

    @Override
    public List<ContatoUsuarioOdontoprev> listarTodos() {
        return contatoUsuarioRepository.findAll();
    }

    @Override
    public ContatoUsuarioOdontoprev buscarPorId(Long id) {
        return contatoUsuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato de usuário não encontrado"));
    }

    @Override
    public ContatoUsuarioOdontoprev atualizar(Long id, ContatoUsuarioOdontoprev contatoAtualizado) {
        ContatoUsuarioOdontoprev contatoExistente = buscarPorId(id);
        contatoExistente.setEmailUsuario(contatoAtualizado.getEmailUsuario());
        contatoExistente.setTelefoneUsuario(contatoAtualizado.getTelefoneUsuario());
        contatoExistente.setUsuario(contatoAtualizado.getUsuario());

        return contatoUsuarioRepository.save(contatoExistente);
    }

    @Override
    public void deletar(Long id) {
        contatoUsuarioRepository.deleteById(id);
    }

    @Override
    public ContatoUsuarioOdontoprev salvar(ContatoUsuarioOdontoprev contato) {
        return criar(contato);
    }
}
