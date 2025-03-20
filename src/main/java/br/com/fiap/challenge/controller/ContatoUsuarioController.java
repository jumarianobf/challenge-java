package br.com.fiap.challenge.controller;

import br.com.fiap.challenge.model.ContatoUsuarioOdontoprev;
import br.com.fiap.challenge.service.impl.ClinicaServiceImpl;
import br.com.fiap.challenge.service.impl.ContatoUsuarioServiceImpl;
import br.com.fiap.challenge.service.EnderecoClinicaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contatos-usuarios")
public class ContatoUsuarioController {

    private final ClinicaServiceImpl clinicaService;
    private final EnderecoClinicaService enderecoClinicaService;
    private ContatoUsuarioServiceImpl contatoUsuarioServiceImpl;

    public ContatoUsuarioController(ClinicaServiceImpl clinicaService, EnderecoClinicaService enderecoClinicaService) {
        this.clinicaService = clinicaService;
        this.enderecoClinicaService = enderecoClinicaService;
    }

    // Método para listar todos os contatos de usuários
    @GetMapping
    public String listarContatosUsuarios(Model model) {
        List<ContatoUsuarioOdontoprev> contatos = contatoUsuarioServiceImpl.listarTodos();
        model.addAttribute("contatos", contatos);
        return "contato/lista";  // Nome do template Thymeleaf
    }

    // Método para exibir o formulário de novo contato de usuário
    @GetMapping("/novo")
    public String novoContatoUsuario(Model model) {
        model.addAttribute("contato", new ContatoUsuarioOdontoprev());  // Garantindo que o objeto seja inicializado
        return "contato/form";  // Nome do template para o formulário
    }

    // Método para salvar um novo contato de usuário
    @PostMapping("/salvar")
    public String salvarContatoUsuario(@ModelAttribute ContatoUsuarioOdontoprev contato) {
        contatoUsuarioServiceImpl.salvar(contato);
        return "redirect:/contatos-usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editarContatoUsuario(@PathVariable Long id, Model model) {
        ContatoUsuarioOdontoprev contato = contatoUsuarioServiceImpl.buscarPorId(id);
        model.addAttribute("contato", contato);
        return "contato/form";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarContatoUsuario(@PathVariable Long id, @ModelAttribute ContatoUsuarioOdontoprev contato) {
        contatoUsuarioServiceImpl.atualizar(id, contato);  // Passando Long como parâmetro
        return "redirect:/contatos-usuarios";
    }

    @GetMapping("/deletar/{id}")
    public String deletarContatoUsuario(@PathVariable Long id) {
        contatoUsuarioServiceImpl.deletar(id);  // Passando Long como parâmetro
        return "redirect:/contatos-usuarios";
    }
}
