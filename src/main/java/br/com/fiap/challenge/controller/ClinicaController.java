package br.com.fiap.challenge.controller;

import br.com.fiap.challenge.model.ClinicaOdontoprev;
import br.com.fiap.challenge.service.EnderecoClinicaService;
import br.com.fiap.challenge.service.impl.ClinicaServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/clinicas")
public class ClinicaController {

    private final ClinicaServiceImpl clinicaService;
    private final EnderecoClinicaService enderecoClinicaService;

    public ClinicaController(ClinicaServiceImpl clinicaService, EnderecoClinicaService enderecoClinicaService) {
        this.clinicaService = clinicaService;
        this.enderecoClinicaService = enderecoClinicaService;
    }

    @Transactional
    @GetMapping
    public String listarClinicas(Model model) {
        try {
            List<ClinicaOdontoprev> clinicas = clinicaService.listarTodas();
            model.addAttribute("clinicas", clinicas);
            model.addAttribute("activeMenu", "clinicas");
        } catch (DataAccessException e) {
            model.addAttribute("error", "Erro ao listar as clínicas: " + e.getMessage());
        }
        return "clinica/lista";
    }

    @GetMapping("/nova")
    public String novoCadastroClinica(Model model) {
        model.addAttribute("activeMenu", "clinicas");
        model.addAttribute("clinica", new ClinicaOdontoprev());  // Adiciona um novo objeto Clinica ao modelo
        return "clinica/form";  // Template para cadastrar clínica
    }


    @PostMapping("/salvar")
    public String salvarClinica(@ModelAttribute ClinicaOdontoprev clinica, RedirectAttributes redirectAttributes) {
        try {
            clinicaService.salvar(clinica);  // Salva a clínica
            redirectAttributes.addFlashAttribute("mensagem", "Clínica cadastrada com sucesso!");
            return "redirect:/enderecos-clinicas/novo?clinicaId=" + clinica.getClinicaId();  // Redireciona para o cadastro do endereço
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao salvar a clínica: " + e.getMessage());
            return "redirect:/clinicas/novo";  // Se falhar, redireciona para o formulário de criação da clínica novamente
        }
    }


    @GetMapping("/editar/{id}")
    public String editarClinica(@PathVariable Long id, Model model) {
        try {
            ClinicaOdontoprev clinica = clinicaService.buscarPorId(id);
            model.addAttribute("clinica", clinica);
            model.addAttribute("enderecosDisponiveis", enderecoClinicaService.listarTodos());
            model.addAttribute("activeMenu", "clinicas");
        } catch (Exception e) {
            model.addAttribute("error", "Erro ao buscar a clínica para edição: " + e.getMessage());
        }
        return "clinica/form";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarClinica(@PathVariable Long id, @ModelAttribute ClinicaOdontoprev clinica, RedirectAttributes redirectAttributes) {
        try {
            clinicaService.atualizar(id, clinica);
            redirectAttributes.addFlashAttribute("mensagem", "Clínica atualizada com sucesso!");
            return "redirect:/clinicas";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao atualizar a clínica: " + e.getMessage());
            return "redirect:/clinicas/editar/" + id;
        }
    }

    @GetMapping("/deletar/{id}")
    public String deletarClinica(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            clinicaService.deletar(id);
            redirectAttributes.addFlashAttribute("mensagem", "Clínica excluída com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao excluir a clínica: " + e.getMessage());
        }
        return "redirect:/clinicas";
    }
}

