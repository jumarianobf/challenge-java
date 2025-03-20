package br.com.fiap.challenge.controller;

import br.com.fiap.challenge.model.DentistaOdontoprev;
import br.com.fiap.challenge.service.DentistaService;
import br.com.fiap.challenge.service.impl.ClinicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dentistas")
public class DentistaController {

    private final DentistaService dentistaService;
    private final ClinicaServiceImpl clinicaService;


    @Autowired
    public DentistaController(DentistaService dentistaService, ClinicaServiceImpl clinicaService) {
        this.dentistaService = dentistaService;
        this.clinicaService = clinicaService;
    }

    // Método para listar todos os dentistas
    @GetMapping
    public String listarDentistas(Model model) {
        List<DentistaOdontoprev> dentistas = dentistaService.listarTodos();
        model.addAttribute("dentistas", dentistas);
        return "dentista/lista";
    }

    // Método para exibir o formulário de novo dentista
    @GetMapping("/novo")
    public String novoDentista(Model model) {
        model.addAttribute("dentista", new DentistaOdontoprev());
        model.addAttribute("clinicas", clinicaService.listarTodas());
        return "dentista/form";
    }

    // Método para salvar um novo dentista
    @PostMapping("/salvar")
    public String salvarDentista(@ModelAttribute DentistaOdontoprev dentista) {
        dentistaService.salvar(dentista);
        return "redirect:/dentistas";
    }

    @GetMapping("/editar/{id}")
    public String editarDentista(@PathVariable Long id, Model model) {
        DentistaOdontoprev dentista = dentistaService.buscarPorId(id);
        model.addAttribute("dentista", dentista);
        model.addAttribute("clinicas", clinicaService.listarTodas());
        return "dentista/form";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarDentista(@PathVariable Long id, @ModelAttribute DentistaOdontoprev dentista) {
        dentistaService.atualizar(id, dentista);
        return "redirect:/dentistas";
    }

    @GetMapping("/deletar/{id}")
    public String deletarDentista(@PathVariable Long id) {
        dentistaService.deletar(id);
        return "redirect:/dentistas";
    }
}
