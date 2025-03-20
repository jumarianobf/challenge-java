package br.com.fiap.challenge.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_endereco_usuario_odontoprev")
public class EnderecoUsuarioOdontoprev {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_usuario_seq")
    @SequenceGenerator(name = "endereco_usuario_seq", sequenceName = "endereco_usuario_seq", allocationSize = 1)
    @Column(name = "endereco_usuario_id", length = 10, nullable = false)
    private Long enderecoUsuarioId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioOdontoprev usuario;

    @Column(name = "cep_usuario", length = 9)
    private String cepUsuario;

    @Column(name = "cidade_usuario", length = 255)
    private String cidadeUsuario;

    @Column(name = "estado_usuario", length = 2)
    private String estadoUsuario;

    @Column(name = "logradouro_usuario", length = 255)
    private String logradouroUsuario;

    @Column(name = "bairro_usuario", length = 255)
    private String bairroUsuario;
}
