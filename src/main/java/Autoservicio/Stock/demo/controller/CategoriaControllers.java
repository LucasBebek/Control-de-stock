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

import Autoservicio.Stock.demo.models.Dtos.CategoriaDto;
import Autoservicio.Stock.demo.models.Dtos.CategoriaRequest;
import Autoservicio.Stock.demo.services.CategoriaService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoriaControllers {
    
    @Autowired
    private final CategoriaService categoriaService;
    
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCategoria(@RequestBody CategoriaRequest categoriaRequest){
        this.categoriaService.addCategoria(categoriaRequest);
    }
    
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CategoriaDto>> getAllCategorias(){
        return ResponseEntity.ok(categoriaService.getAllCategorias());
    }
     
    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CategoriaDto> findCategoriaById(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.findCategoriaById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategoria(@PathVariable Long id){
        
        return ResponseEntity.ok(categoriaService.deleteCategoria(id));
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CategoriaDto> editCategoria(@PathVariable Long id, @RequestBody CategoriaDto categoriaDto) {
       return ResponseEntity.ok(categoriaService.editCategoria(id, categoriaDto));
    }
    // @GetMapping("/verificarNombre/{nombre_categoria}")
    // public ResponseEntity<Boolean> verificarNombreExistente(@PathVariable String nombre_categoria) {
    //     // Lógica para verificar si el nombre ya existe en la base de datos
    //     boolean nombreExistente = categoriaService.verificarNombreExistente(nombre_categoria);
    //     return ResponseEntity.ok(nombreExistente);
    // }
    
}
