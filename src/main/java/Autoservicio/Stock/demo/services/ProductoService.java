package Autoservicio.Stock.demo.services;

import java.util.ArrayList;
import java.util.List;


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
        List<Producto> productos = productoRepo.findAll();
        List<ProductoDto> listProductos = new ArrayList<>();

        for(Producto producto : productos){
          ProductoDto productoDto = new ProductoDto();
          productoDto.setId(producto.getId());
          productoDto.setNombre(producto.getNombre());
          productoDto.setPrecio(producto.getPrecio());
          productoDto.setPrecio_unitario(producto.getPrecio_unitario());
          productoDto.setStock(producto.getStock());
          productoDto.setCategoria_name(producto.getCategoria().getNombre_categoria());

          listProductos.add(productoDto);
        }
        return listProductos;
    } 
    
    public ProductoDto findProductoById(Long id){
        Producto producto = productoRepo.findById(id).orElseThrow();
        
        return ProductoDto.builder()
        .id(producto.getId())
        .nombre(producto.getNombre())
        .precio(producto.getPrecio())
        .precio_unitario(producto.getPrecio_unitario())
        .stock(producto.getStock())
        .categoria_name(producto.getCategoria().getNombre_categoria())//getNombre_Categoria recupera el nombre de la categoria asociada al producto, no el id
        .build();
    }
     
 
}
