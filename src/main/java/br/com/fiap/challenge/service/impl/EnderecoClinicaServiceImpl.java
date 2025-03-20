package br.com.fiap.challenge.service.impl;

import br.com.fiap.challenge.model.EnderecoClinicaOdontoprev;
import br.com.fiap.challenge.repository.EnderecoClinicaRepository;
import br.com.fiap.challenge.service.EnderecoClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EnderecoClinicaServiceImpl implements EnderecoClinicaService {

    @Autowired
    private EnderecoClinicaRepository enderecoClinicaRepository;

    // Valida o formato do CEP
    private boolean validarCep(String cep) {
        String regex = "^[0-9]{5}-[0-9]{3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cep);
        return matcher.matches();
    }

    @Override
    public EnderecoClinicaOdontoprev criar(EnderecoClinicaOdontoprev endereco) {
        // Validações
        if (!validarCep(endereco.getCepClinica())) {
            throw new IllegalArgumentException("CEP inválido. O formato correto é 12345-678.");
        }
        return enderecoClinicaRepository.save(endereco);
    }

    @Override
    public List<EnderecoClinicaOdontoprev> listarTodos() {
        return enderecoClinicaRepository.findAll();
    }

    @Override
    public EnderecoClinicaOdontoprev buscarPorId(Long id) {
        return enderecoClinicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço de clínica não encontrado"));
    }

    @Override
    public EnderecoClinicaOdontoprev atualizar(Long id, EnderecoClinicaOdontoprev enderecoAtualizado) {
        // Validações
        if (!validarCep(enderecoAtualizado.getCepClinica())) {
            throw new IllegalArgumentException("CEP inválido. O formato correto é 12345-678.");
        }

        EnderecoClinicaOdontoprev enderecoExistente = buscarPorId(id);
        enderecoExistente.setCepClinica(enderecoAtualizado.getCepClinica());
        enderecoExistente.setCidadeClinica(enderecoAtualizado.getCidadeClinica());
        enderecoExistente.setEstadoClinica(enderecoAtualizado.getEstadoClinica());
        enderecoExistente.setLogradouroClinica(enderecoAtualizado.getLogradouroClinica());
        enderecoExistente.setBairroClinica(enderecoAtualizado.getBairroClinica());
        enderecoExistente.setClinica(enderecoAtualizado.getClinica());

        return enderecoClinicaRepository.save(enderecoExistente);
    }

    @Override
    public void deletar(Long id) {
        enderecoClinicaRepository.deleteById(id);
    }

    @Override
    public EnderecoClinicaOdontoprev salvar(EnderecoClinicaOdontoprev endereco) {
        return criar(endereco);
    }
}
