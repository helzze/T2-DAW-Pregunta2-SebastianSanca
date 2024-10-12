package daw.t2.pregunta2.sanca.t2_pregunta2_sanca.controller;

import daw.t2.pregunta2.sanca.t2_pregunta2_sanca.dto.DTOLogin;
import daw.t2.pregunta2.sanca.t2_pregunta2_sanca.dto.DTOUsuarioResponse;
import daw.t2.pregunta2.sanca.t2_pregunta2_sanca.model.Usuario;
import daw.t2.pregunta2.sanca.t2_pregunta2_sanca.service.impl.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UsuarioService usuarioService;
    @PostMapping("/login")
    public ResponseEntity<DTOUsuarioResponse> login(@RequestBody DTOLogin DTOLogin) {
        return ResponseEntity.ok(usuarioService.loginUsuario(DTOLogin));
    }
    @PostMapping("/registrar")
    public ResponseEntity<DTOUsuarioResponse> registrarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.registrarUsuario(usuario));
    }
}