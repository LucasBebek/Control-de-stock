package Autoservicio.Stock.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Autoservicio.Stock.demo.models.Dtos.ProductoRequest;
import Autoservicio.Stock.demo.models.Dtos.ProductoDto;
import Autoservicio.Stock.demo.models.entity.Producto;

import Autoservicio.Stock.demo.services.ProductoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoControllers {
    
    private final ProductoService productoService;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProducto(@RequestBody ProductoRequest productoRequest){
        this.productoService.addProducto(productoRequest);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductoDto> getAllProductos(){
        return this.productoService.getAllProductos();
    }

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Producto findProductoById(@PathVariable Long id){
        return this.productoService.findProductoById(id).getBody();
    }
}
