package daw.t2.pregunta2.sanca.t2_pregunta2_sanca.service.interfaces;

import daw.t2.pregunta2.sanca.t2_pregunta2_sanca.dto.DTOLogin;
import daw.t2.pregunta2.sanca.t2_pregunta2_sanca.dto.DTOUsuarioResponse;
import daw.t2.pregunta2.sanca.t2_pregunta2_sanca.model.Usuario;

public interface IUsuarioService {

    DTOUsuarioResponse registrarUsuario(Usuario usuario);
    DTOUsuarioResponse loginUsuario(DTOLogin login);

}