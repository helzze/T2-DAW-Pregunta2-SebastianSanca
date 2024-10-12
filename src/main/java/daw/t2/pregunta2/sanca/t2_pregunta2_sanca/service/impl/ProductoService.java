package daw.t2.pregunta2.sanca.t2_pregunta2_sanca.service.impl;

import daw.t2.pregunta2.sanca.t2_pregunta2_sanca.model.Producto;
import daw.t2.pregunta2.sanca.t2_pregunta2_sanca.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    public Producto crearProducto(Producto producto) {
        producto.setNombre(producto.getNombre());
        return productoRepository.save(producto);
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Producto actualizarProducto(Long id, Producto producto) {
        Producto productoActual = productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        productoActual.setNombre(producto.getNombre());

        return productoRepository.save(productoActual);
    }

}
