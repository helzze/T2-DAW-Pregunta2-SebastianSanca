package daw.t2.pregunta2.sanca.t2_pregunta2_sanca.model;

import daw.t2.pregunta2.sanca.t2_pregunta2_sanca.Enums.Rol;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String password;
    private String email;

    @Enumerated(EnumType.STRING)
    private Rol rol;
    private Boolean activo;

}