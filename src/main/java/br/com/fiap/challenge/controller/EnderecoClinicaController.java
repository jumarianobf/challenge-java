package br.com.fiap.challenge.controller;

import br.com.fiap.challenge.model.ClinicaOdontoprev;
import br.com.fiap.challenge.model.EnderecoClinicaOdontoprev;
import br.com.fiap.challenge.service.EnderecoClinicaService;
import br.com.fiap.challenge.service.impl.ClinicaServiceImpl;
import br.com.fiap.challenge.service.impl.EnderecoClinicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/enderecos-clinicas")
public class EnderecoClinicaController {

    @Autowired
    private EnderecoClinicaServiceImpl enderecoClinicaService;

    @Autowired
    private ClinicaServiceImpl clinicaService;

    // Método para listar todos os endereços de clínicas
    @GetMapping
    public String listarEnderecos(Model model) {
        List<EnderecoClinicaOdontoprev> enderecos = enderecoClinicaService.listarTodos();
        model.addAttribute("enderecos", enderecos);
        return "enderecoClinica/lista";
    }

    @GetMapping("/novo")
    public String novoEnderecoClinica(Model model) {
        List<ClinicaOdontoprev> clinicas = clinicaService.listarTodas();
        model.addAttribute("clinicas", clinicas);
        model.addAttribute("endereco", new EnderecoClinicaOdontoprev());
        return "enderecoClinica/form";
    }

    @PostMapping("/salvar")
    public String salvarEndereco(@ModelAttribute EnderecoClinicaOdontoprev endereco, RedirectAttributes redirectAttributes) {
        try {
            enderecoClinicaService.salvar(endereco);
            redirectAttributes.addFlashAttribute("mensagem", "Endereço salvo com sucesso!");
            return "redirect:/enderecos-clinicas";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao salvar o endereço: " + e.getMessage());
            return "redirect:/enderecos-clinicas/novo?clinicaId=" + endereco.getClinica().getClinicaId();  // Corrigido para enviar o clinicaId
        }
    }

    @GetMapping("/editar/{id}")
    public String editarEnderecoClinica(@PathVariable Long id, Model model) {
        EnderecoClinicaOdontoprev endereco = enderecoClinicaService.buscarPorId(id);
        model.addAttribute("endereco", endereco);
        List<ClinicaOdontoprev> clinicas = clinicaService.listarTodas();
        model.addAttribute("clinicas", clinicas);
        return "enderecoClinica/form";  // Nome do template Thymeleaf
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarEnderecoClinica(@PathVariable Long id, @ModelAttribute EnderecoClinicaOdontoprev endereco, RedirectAttributes redirectAttributes) {
        try {
            enderecoClinicaService.atualizar(id, endereco);
            redirectAttributes.addFlashAttribute("mensagem", "Endereço atualizado com sucesso!");
            return "redirect:/enderecos-clinicas";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao atualizar o endereço: " + e.getMessage());
            return "redirect:/enderecos-clinicas/editar/" + id;
        }
    }

    @GetMapping("/deletar/{id}")
    public String deletarEnderecoClinica(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            enderecoClinicaService.deletar(id);
            redirectAttributes.addFlashAttribute("mensagem", "Endereço excluído com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao excluir o endereço: " + e.getMessage());
        }
        return "redirect:/enderecos-clinicas";
    }

    @GetMapping("/detalhes/{id}")
    @ResponseBody
    public ResponseEntity<EnderecoClinicaOdontoprev> getEnderecoDetalhes(@PathVariable Long id) {
        try {
            EnderecoClinicaOdontoprev endereco = enderecoClinicaService.buscarPorId(id);
            return ResponseEntity.ok(endereco);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
