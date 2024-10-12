package daw.t2.pregunta2.sanca.t2_pregunta2_sanca.controller;

import daw.t2.pregunta2.sanca.t2_pregunta2_sanca.model.Producto;
import daw.t2.pregunta2.sanca.t2_pregunta2_sanca.service.impl.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoService productoService;


    @PreAuthorize("hasRole('COORDINADOR')")
    @GetMapping("/findAll")
    public ResponseEntity<List<Producto>> findAll() {
        return ResponseEntity.ok(productoService.listarProductos());
    }


    @PreAuthorize("hasAuthority('GESTOR')")
    @PostMapping("/crear")
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.crearProducto(producto));
    }


    @PreAuthorize("hasRole('GESTOR') or hasRole('COORDINADOR')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> actualizar(@RequestBody Producto producto, @PathVariable Long id) {
        return ResponseEntity.ok(productoService.actualizarProducto(id, producto));
    }

}