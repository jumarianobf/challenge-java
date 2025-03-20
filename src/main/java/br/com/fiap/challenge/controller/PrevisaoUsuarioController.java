package br.com.fiap.challenge.controller;

import br.com.fiap.challenge.model.ImagemUsuarioOdontoprev;
import br.com.fiap.challenge.model.PrevisaoUsuarioOdontoprev;
import br.com.fiap.challenge.model.UsuarioOdontoprev;
import br.com.fiap.challenge.service.ImagemUsuarioService;
import br.com.fiap.challenge.service.impl.PrevisaoUsuarioServiceImpl;
import br.com.fiap.challenge.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/previsao-usuarios")
public class PrevisaoUsuarioController {

    @Autowired
    private PrevisaoUsuarioServiceImpl previsaoUsuarioService;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private ImagemUsuarioService imagemUsuarioService;

    // Método para listar todas as previsões de usuários
    @GetMapping
    public String listarPrevisoesUsuarios(Model model) {
        List<PrevisaoUsuarioOdontoprev> previsoes = previsaoUsuarioService.listarTodos();
        model.addAttribute("previsoes", previsoes);
        return "previsaoUsuario/lista";
    }

    @GetMapping("/novo")
    public String novaPrevisaoUsuario(Model model) {
        List<UsuarioOdontoprev> usuarios = usuarioService.listarTodos();
        List<ImagemUsuarioOdontoprev> imagens = imagemUsuarioService.listarTodos();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("imagens", imagens);  // Passa as imagens para o template
        model.addAttribute("previsao", new PrevisaoUsuarioOdontoprev());
        return "previsaoUsuario/form";
    }

    @PostMapping("/salvar")
    public String salvarPrevisaoUsuario(@ModelAttribute PrevisaoUsuarioOdontoprev previsao) {
        previsaoUsuarioService.salvar(previsao);
        return "redirect:/previsao-usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editarPrevisaoUsuario(@PathVariable Long id, Model model) {
        PrevisaoUsuarioOdontoprev previsao = previsaoUsuarioService.buscarPorId(id);
        List<UsuarioOdontoprev> usuarios = usuarioService.listarTodos();
        List<ImagemUsuarioOdontoprev> imagens = imagemUsuarioService.listarTodos();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("imagens", imagens);
        model.addAttribute("previsao", previsao);
        return "previsaoUsuario/form";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarPrevisaoUsuario(@PathVariable Long id, @ModelAttribute PrevisaoUsuarioOdontoprev previsao) {
        previsaoUsuarioService.atualizar(id, previsao);
        return "redirect:/previsao-usuarios";
    }

    @GetMapping("/deletar/{id}")
    public String deletarPrevisaoUsuario(@PathVariable Long id) {
        previsaoUsuarioService.deletar(id);
        return "redirect:/previsao-usuarios";
    }
}
