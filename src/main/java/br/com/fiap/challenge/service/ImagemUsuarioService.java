package br.com.fiap.challenge.service;

import br.com.fiap.challenge.model.ImagemUsuarioOdontoprev;

import java.util.List;

public interface ImagemUsuarioService {
    ImagemUsuarioOdontoprev criar(ImagemUsuarioOdontoprev imagem);
    List<ImagemUsuarioOdontoprev> listarTodos();
    ImagemUsuarioOdontoprev buscarPorId(Long id);
    ImagemUsuarioOdontoprev atualizar(Long id, ImagemUsuarioOdontoprev imagemAtualizada);
    void deletar(Long id);
    ImagemUsuarioOdontoprev salvar(ImagemUsuarioOdontoprev imagem);
}
