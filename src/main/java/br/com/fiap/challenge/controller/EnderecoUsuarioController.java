package br.com.fiap.challenge.controller;

import br.com.fiap.challenge.model.EnderecoUsuarioOdontoprev;
import br.com.fiap.challenge.model.UsuarioOdontoprev;
import br.com.fiap.challenge.service.UsuarioService;
import br.com.fiap.challenge.service.impl.EnderecoUsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/enderecos-usuario")
public class EnderecoUsuarioController {

    @Autowired
    private EnderecoUsuarioServiceImpl enderecoUsuarioService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String getAllEnderecosUsuario(Model model) {
        List<EnderecoUsuarioOdontoprev> enderecosUsuario = enderecoUsuarioService.listarTodos();
        enderecosUsuario.forEach(endereco -> {
            if (endereco.getUsuario() != null) {
                endereco.getUsuario().getNome();
            }
        });
        model.addAttribute("endereco", enderecosUsuario);
        return "enderecoUsuario/lista";
    }
    @GetMapping("/novo")
    public String showNovoEnderecoUsuarioForm(Model model) {
        List<UsuarioOdontoprev> usuarios = usuarioService.listarTodos(); // Aqui você deve buscar a lista de usuários
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("endereco", new EnderecoUsuarioOdontoprev());
        return "enderecoUsuario/form"; // Nome da sua página HTML para criar um novo endereço
    }

    @PostMapping("/salvar")
    public String salvarEnderecoUsuario(@ModelAttribute("enderecos") EnderecoUsuarioOdontoprev enderecoUsuario, Model model) {
        enderecoUsuarioService.salvar(enderecoUsuario);
        model.addAttribute("mensagem", "Endereço cadastrado com sucesso!");
        return "redirect:/enderecos-usuario";
    }


    @GetMapping("/editar/{id}")
    public String showEditarEnderecoUsuarioForm(@PathVariable Long id, Model model) {
        EnderecoUsuarioOdontoprev enderecoUsuario = enderecoUsuarioService.buscarPorId(id);
        model.addAttribute("endereco", enderecoUsuario);
        List<UsuarioOdontoprev> usuarios = usuarioService.listarTodos();
        model.addAttribute("usuarios", usuarios);
        return "enderecoUsuario/form";
    }


    @PostMapping("/atualizar/{id}")
    public String atualizarEnderecoUsuario(@PathVariable Long id, @ModelAttribute("enderecos") EnderecoUsuarioOdontoprev enderecoUsuario) {
        // Buscar o endereço existente pelo ID
        EnderecoUsuarioOdontoprev existingEnderecoUsuario = enderecoUsuarioService.buscarPorId(id);

        if (existingEnderecoUsuario == null) {
            // Se não encontrar o endereço, redireciona ou exibe erro
            return "redirect:/enderecos-usuario";
        }

        // Atualizar os campos do endereço existente com os dados fornecidos no formulário
        existingEnderecoUsuario.setLogradouroUsuario(enderecoUsuario.getLogradouroUsuario());
        existingEnderecoUsuario.setCepUsuario(enderecoUsuario.getCepUsuario());
        existingEnderecoUsuario.setCidadeUsuario(enderecoUsuario.getCidadeUsuario());
        existingEnderecoUsuario.setEstadoUsuario(enderecoUsuario.getEstadoUsuario());
        existingEnderecoUsuario.setBairroUsuario(enderecoUsuario.getBairroUsuario());
        existingEnderecoUsuario.setUsuario(enderecoUsuario.getUsuario());  // Atualiza o usuário relacionado

        // Chama o método de serviço para salvar as atualizações
        enderecoUsuarioService.atualizar(id, existingEnderecoUsuario);

        // Redireciona para a lista de endereços após a atualização
        return "redirect:/enderecos-usuario";
    }


    @GetMapping("/deletar/{id}")
    public String deletarEnderecoUsuario(@PathVariable Long id) {
        EnderecoUsuarioOdontoprev endereco = enderecoUsuarioService.buscarPorId(id);

        if (endereco != null) {
            enderecoUsuarioService.deletar(id);
        }

        return "redirect:/enderecos-usuario";
    }

}

