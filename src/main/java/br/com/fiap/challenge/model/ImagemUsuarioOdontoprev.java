package br.com.fiap.challenge.model;

import br.com.fiap.challenge.model.UsuarioOdontoprev;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_IMAGEM_USUARIO_ODONTOPREV")
public class ImagemUsuarioOdontoprev {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "imagem_usuario_seq")
    @SequenceGenerator(name = "imagem_usuario_seq", sequenceName = "imagem_usuario_seq", allocationSize = 1)
    @Column(name = "imagem_usuario_id", length = 10)
    private Long imagemUsuarioId;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioOdontoprev usuario;

    @Column(name = "imagem_url", length = 255)
    private String imagemUrl;

    @Column(name = "data_envio")
    private LocalDate dataEnvio;
}
