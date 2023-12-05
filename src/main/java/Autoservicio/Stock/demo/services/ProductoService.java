package Autoservicio.Stock.demo.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Autoservicio.Stock.demo.models.Dtos.ProductoDto;
import Autoservicio.Stock.demo.models.Dtos.ProductoRequest;
import Autoservicio.Stock.demo.models.entity.Producto;
import Autoservicio.Stock.demo.repositories.ProductoRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductoService {
    private final ProductoRepo productoRepo;

    public void addProducto(ProductoRequest productoRequest){
        Producto producto = Producto.builder()
        .nombre(productoRequest.getNombre())
        .stock(productoRequest.getStock())
        .precio(productoRequest.getPrecio())
        .precio_unitario(productoRequest.getPrecio_unitario())
        .categoria(productoRequest.getCategoria_id())
        .build();
    productoRepo.save(producto);
    log.info("producto agregado", producto);
    }

    public List<ProductoDto> getAllProductos(){
        List<Producto> producto = productoRepo.findAll();
        return producto.stream().map(this::mapToProductoDto).toList();
    } 
    
    public ResponseEntity <Producto> findProductoById(Long id){
        Producto producto = productoRepo.findById(id).get();
        return ResponseEntity.ok(producto);
    }
     
    private ProductoDto mapToProductoDto(Producto producto){
        return ProductoDto.builder()
        .id(producto.getId())
        .nombre(producto.getNombre())
        .stock(producto.getStock())
        .precio(producto.getPrecio())
        .precio_unitario(producto.getPrecio_unitario())
        .categoria_id(producto.getCategoria())
        .build();
    }
}
