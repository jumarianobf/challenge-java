package br.com.fiap.challenge.service.impl;

import br.com.fiap.challenge.model.UsuarioOdontoprev;
import br.com.fiap.challenge.repository.UsuarioRepository;
import br.com.fiap.challenge.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioOdontoprev criar(UsuarioOdontoprev usuario) {
        if (usuarioRepository.existsByCpf(usuario.getCpf())) {
            throw new RuntimeException("CPF já cadastrado");
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<UsuarioOdontoprev> listarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioOdontoprev buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    @Override
    public UsuarioOdontoprev atualizar(Long id, UsuarioOdontoprev usuarioAtualizado) {
        UsuarioOdontoprev usuarioExistente = buscarPorId(id);
        usuarioExistente.setNome(usuarioAtualizado.getNome());
        usuarioExistente.setCpf(usuarioAtualizado.getCpf());
        usuarioExistente.setGenero(usuarioAtualizado.getGenero());
        usuarioExistente.setSobrenome(usuarioAtualizado.getSobrenome());
        usuarioExistente.setDataCadastro(usuarioAtualizado.getDataCadastro());
        usuarioExistente.setDataNascimento(usuarioAtualizado.getDataNascimento());

        return usuarioRepository.save(usuarioExistente);
    }

    @Override
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioOdontoprev salvar(UsuarioOdontoprev usuario) {
        return criar(usuario);
    }
}
