package br.com.fiap.challenge.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "T_ENDERECO_CLINICA_ODONTOPREV")
public class EnderecoClinicaOdontoprev {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_clinica_id_seq")
    @SequenceGenerator(name = "endereco_clinica_id_seq", sequenceName = "endereco_clinica_id_seq", allocationSize = 1)
    @Column(name = "endereco_clinica_id", nullable = false)
    private Long enderecoClinicaId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clinica_id", nullable = false)
    private ClinicaOdontoprev clinica;

    @Column(name = "cep_clinica", length = 9)
    private String cepClinica;

    @Column(name = "cidade_clinica", length = 255)
    private String cidadeClinica;

    @Column(name = "estado_clinica", length = 2)
    private String estadoClinica;

    @Column(name = "logradouro_clinica", length = 255)
    private String logradouroClinica;

    @Column(name = "bairro_clinica", length = 255)
    private String bairroClinica;
}

