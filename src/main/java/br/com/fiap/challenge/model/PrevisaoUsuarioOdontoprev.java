package br.com.fiap.challenge.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "T_PREVISAO_USUARIO_ODONTOPREV")
public class PrevisaoUsuarioOdontoprev {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "previsao_usuario_seq")
    @SequenceGenerator(name = "previsao_usuario_seq", sequenceName = "previsao_usuario_seq", allocationSize = 1)
    @Column(name = "previsao_usuario_id")
    private Long previsaoUsuarioId;

    @ManyToOne
    @JoinColumn(name = "imagem_usuario_id", nullable = false)
    private ImagemUsuarioOdontoprev imagemUsuario;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioOdontoprev usuario;

    @Column(name = "previsao_texto", length = 255, nullable = false)
    private String previsaoTexto;

    @Column(name = "probabilidade", nullable = false)
    private Float probabilidade;

    @Column(name = "recomendacao", length = 255, nullable = false)
    private String recomendacao;

    @Column(name = "data_previsao", nullable = false)
    private LocalDate dataPrevisao;
}