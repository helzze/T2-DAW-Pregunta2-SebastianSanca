package daw.t2.pregunta2.sanca.t2_pregunta2_sanca.dto;

import daw.t2.pregunta2.sanca.t2_pregunta2_sanca.model.Usuario;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DTOUsuarioResponse {

    private Long id;
    private String codigo;
    private String rol;
    private String mensaje;
    private String tiempoExpiracion;
    private String token;
    private Usuario usuario;

}
