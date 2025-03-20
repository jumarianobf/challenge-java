package br.com.fiap.challenge.service.impl;

import br.com.fiap.challenge.model.ImagemUsuarioOdontoprev;
import br.com.fiap.challenge.repository.ImagemUsuarioRepository;
import br.com.fiap.challenge.service.ImagemUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagemUsuarioServiceImpl implements ImagemUsuarioService {

    @Autowired
    private ImagemUsuarioRepository imagemUsuarioRepository;

    @Override
    public ImagemUsuarioOdontoprev criar(ImagemUsuarioOdontoprev imagem) {
        return imagemUsuarioRepository.save(imagem);
    }

    @Override
    public List<ImagemUsuarioOdontoprev> listarTodos() {
        return imagemUsuarioRepository.findAll();
    }

    @Override
    public ImagemUsuarioOdontoprev buscarPorId(Long id) {
        return imagemUsuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Imagem de usuário não encontrada"));
    }

    @Override
    public ImagemUsuarioOdontoprev atualizar(Long id, ImagemUsuarioOdontoprev imagemAtualizada) {
        ImagemUsuarioOdontoprev imagemExistente = buscarPorId(id);
        imagemExistente.setImagemUrl(imagemAtualizada.getImagemUrl());
        imagemExistente.setDataEnvio(imagemAtualizada.getDataEnvio());
        imagemExistente.setUsuario(imagemAtualizada.getUsuario());

        return imagemUsuarioRepository.save(imagemExistente);
    }

    @Override
    public void deletar(Long id) {
        imagemUsuarioRepository.deleteById(id);
    }

    @Override
    public ImagemUsuarioOdontoprev salvar(ImagemUsuarioOdontoprev imagem) {
        return criar(imagem);
    }
}
