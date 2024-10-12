package daw.t2.pregunta2.sanca.t2_pregunta2_sanca.repository;

import daw.t2.pregunta2.sanca.t2_pregunta2_sanca.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}