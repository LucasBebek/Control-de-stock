package Autoservicio.Stock.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Autoservicio.Stock.demo.models.Dtos.ProductoRequest;
import Autoservicio.Stock.demo.models.Dtos.ProductoDto;


import Autoservicio.Stock.demo.services.ProductoService;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoControllers {
    
    @Autowired
    private final ProductoService productoService;
    
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProducto(@RequestBody ProductoRequest productoRequest){
        this.productoService.addProducto(productoRequest);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ProductoDto>> getAllProductos(){
        return ResponseEntity.ok(productoService.getAllProductos());
    }

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductoDto> findProductoById(@PathVariable Long id){
        return ResponseEntity.ok(productoService.findProductoById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable Long id){
        
        return ResponseEntity.ok(productoService.deleteProducto(id));
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductoDto> editProducto(@PathVariable Long id, @RequestBody ProductoDto productoDto) {
       return ResponseEntity.ok(productoService.editProducto(id, productoDto));
    }
    
    @GetMapping("/verificarNombre/{nombre}")
    public ResponseEntity<Boolean> verificarNombreExistente(@PathVariable String nombre) {
        // Lógica para verificar si el nombre ya existe en la base de datos
        boolean nombreExistente = productoService.verificarNombreExistente(nombre);
        return ResponseEntity.ok(nombreExistente);
    }
     
}
