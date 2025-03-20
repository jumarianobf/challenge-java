package br.com.fiap.challenge.controller;

import br.com.fiap.challenge.model.*;
import br.com.fiap.challenge.service.impl.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final ClinicaServiceImpl clinicaService;
    private final UsuarioServiceImpl usuarioService;
    private final DentistaServiceImpl dentistaService;
    private final AtendimentoUsuarioServiceImpl atendimentoUsuarioService;
    private final EnderecoClinicaServiceImpl enderecoClinicaService;
    private final EnderecoUsuarioServiceImpl enderecoUsuarioService;
    private final ImagemUsuarioServiceImpl imagemUsuarioService;
    private final PrevisaoUsuarioServiceImpl previsaoService;

    public HomeController(ClinicaServiceImpl clinicaService, UsuarioServiceImpl usuarioService,
                          DentistaServiceImpl dentistaService, AtendimentoUsuarioServiceImpl atendimentoUsuarioService,
                          EnderecoClinicaServiceImpl enderecoClinicaService, EnderecoUsuarioServiceImpl enderecoUsuarioService,
                          ImagemUsuarioServiceImpl imagemUsuarioService, PrevisaoUsuarioServiceImpl previsaoService) {
        this.clinicaService = clinicaService;
        this.usuarioService = usuarioService;
        this.dentistaService = dentistaService;
        this.atendimentoUsuarioService = atendimentoUsuarioService;
        this.enderecoClinicaService = enderecoClinicaService;
        this.enderecoUsuarioService = enderecoUsuarioService;
        this.imagemUsuarioService = imagemUsuarioService;
        this.previsaoService = previsaoService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<ClinicaOdontoprev> clinicas = clinicaService.listarTodas();
        List<UsuarioOdontoprev> pacientes = usuarioService.listarTodos();
        List<DentistaOdontoprev> dentistas = dentistaService.listarTodos();
        List<AtendimentoUsuarioOdontoprev> atendimentos = atendimentoUsuarioService.listarTodos();
        List<EnderecoClinicaOdontoprev> enderecosClinica = enderecoClinicaService.listarTodos();
        List<EnderecoUsuarioOdontoprev> enderecosUsuario = enderecoUsuarioService.listarTodos();
        List<ImagemUsuarioOdontoprev> imagensUsuarios = imagemUsuarioService.listarTodos();
        List<PrevisaoUsuarioOdontoprev> previsoes = previsaoService.listarTodos();

        model.addAttribute("clinicas", clinicas);
        model.addAttribute("pacientes", pacientes);
        model.addAttribute("dentistas", dentistas);
        model.addAttribute("atendimentos", atendimentos);
        model.addAttribute("enderecosClinica", enderecosClinica);
        model.addAttribute("enderecosUsuario", enderecosUsuario);
        model.addAttribute("imagensUsuarios", imagensUsuarios);
        model.addAttribute("previsoes", previsoes);

        return "home/home";
    }
}
