package daw.t2.pregunta2.sanca.t2_pregunta2_sanca.repository;

import daw.t2.pregunta2.sanca.t2_pregunta2_sanca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCodigo(String codigo);
}