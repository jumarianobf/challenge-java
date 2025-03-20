package br.com.fiap.challenge.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_CONTATO_USUARIO_ODONTOPREV")
public class ContatoUsuarioOdontoprev {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contato_usuario_seq")
    @SequenceGenerator(name = "contato_usuario_seq", sequenceName = "contato_usuario_seq", allocationSize = 1)
    @Column(name = "contato_usuario_id")
    private Long contatoUsuarioId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioOdontoprev usuario;

    @Column(name = "email_usuario", length = 100)
    private String emailUsuario;

    @Column(name = "telefone_usuario", length = 15)
    private String telefoneUsuario;
}
