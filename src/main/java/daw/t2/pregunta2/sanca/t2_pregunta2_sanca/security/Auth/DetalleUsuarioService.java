package daw.t2.pregunta2.sanca.t2_pregunta2_sanca.security.Auth;

import daw.t2.pregunta2.sanca.t2_pregunta2_sanca.model.Usuario;
import daw.t2.pregunta2.sanca.t2_pregunta2_sanca.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetalleUsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioRepository.findByCodigo(username).orElseThrow(
                () -> new RuntimeException("Usuario no encontrado")
        );

        return AuthUsuario.builder()
                .usuario(usuario)
                .build();
    }

}