package br.com.fiap.challenge.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "T_DENTISTA_ODONTOPREV")
public class DentistaOdontoprev {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dentista_id_seq")
    @SequenceGenerator(name = "dentista_id_seq", sequenceName = "dentista_id_seq", allocationSize = 1)
    @Column(name = "dentista_id", nullable = false)
    private Long dentistaId;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private UsuarioOdontoprev usuario;

    @ManyToOne
    @JoinColumn(name = "clinica_id", referencedColumnName = "clinica_id")
    private ClinicaOdontoprev clinica;

    @Column(name = "nome_dentista", length = 100, nullable = false)
    private String nomeDentista;

    @Column(name = "especialidade", length = 100)
    private String especialidade;

    @Column(name = "telefone_dentista", length = 15)
    private String telefoneDentista;

    @Column(name = "email_dentista", length = 100)
    private String emailDentista;
}
