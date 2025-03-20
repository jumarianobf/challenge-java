package br.com.fiap.challenge.controller;

import br.com.fiap.challenge.model.ImagemUsuarioOdontoprev;
import br.com.fiap.challenge.model.UsuarioOdontoprev;
import br.com.fiap.challenge.service.impl.ImagemUsuarioServiceImpl;
import br.com.fiap.challenge.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/imagens-usuarios")
public class ImagemUsuarioController {

    @Autowired
    private ImagemUsuarioServiceImpl imagemUsuarioService;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @GetMapping
    public String listarImagensUsuarios(Model model) {
        List<ImagemUsuarioOdontoprev> imagens = imagemUsuarioService.listarTodos();
        model.addAttribute("imagens", imagens);
        return "imagemUsuario/lista";
    }

    @GetMapping("/novo")
    public String novaImagemUsuario(Model model) {
        List<UsuarioOdontoprev> usuarios = usuarioService.listarTodos();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("imagem", new ImagemUsuarioOdontoprev());
        return "imagemUsuario/form";
    }


    @PostMapping("/salvar")
    public String salvarImagemUsuario(@ModelAttribute ImagemUsuarioOdontoprev imagem) {
        imagemUsuarioService.salvar(imagem);
        return "redirect:/imagens-usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editarImagemUsuario(@PathVariable Long id, Model model) {
        ImagemUsuarioOdontoprev imagem = imagemUsuarioService.buscarPorId(id);
        model.addAttribute("imagem", imagem);
        return "imagemUsuario/form";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarImagemUsuario(@PathVariable Long id, @ModelAttribute ImagemUsuarioOdontoprev imagem) {
        imagemUsuarioService.atualizar(id, imagem);
        return "redirect:/imagens-usuarios";
    }

    @GetMapping("/deletar/{id}")
    public String deletarImagemUsuario(@PathVariable Long id) {
        imagemUsuarioService.deletar(id);
        return "redirect:/imagens-usuarios";
    }
}
