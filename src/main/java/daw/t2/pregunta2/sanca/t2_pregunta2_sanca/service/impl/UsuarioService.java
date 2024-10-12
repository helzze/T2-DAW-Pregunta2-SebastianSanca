package daw.t2.pregunta2.sanca.t2_pregunta2_sanca.service.impl;

import daw.t2.pregunta2.sanca.t2_pregunta2_sanca.dto.DTOLogin;
import daw.t2.pregunta2.sanca.t2_pregunta2_sanca.dto.DTOUsuarioResponse;
import daw.t2.pregunta2.sanca.t2_pregunta2_sanca.model.Usuario;
import daw.t2.pregunta2.sanca.t2_pregunta2_sanca.repository.UsuarioRepository;
import daw.t2.pregunta2.sanca.t2_pregunta2_sanca.security.JWT.JwtUtil;
import daw.t2.pregunta2.sanca.t2_pregunta2_sanca.service.interfaces.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;


    @Override
    public DTOUsuarioResponse registrarUsuario(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        Usuario usuarioSaved = this.usuarioRepository.save(usuario);

        return DTOUsuarioResponse.builder()
                .mensaje("Usuario registrado")
                .codigo(usuarioSaved.getCodigo())
                .build();
    }


    @Override
    public DTOUsuarioResponse loginUsuario(DTOLogin login) {
        Usuario usuario = this.usuarioRepository.findByCodigo(login.getCodigo()).orElseThrow(
                () -> new RuntimeException("Usuario no encontrado")
        );

        if (!passwordEncoder.matches(login.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        String token = this.jwtUtil.generarToken(usuario);

        return DTOUsuarioResponse.builder()
                .mensaje("Usuario logeado correctamente")
                .codigo(usuario.getCodigo())
                .rol(usuario.getRol().name())
                .tiempoExpiracion("3 minutos")
                .token(token)
                .build();
    }
}