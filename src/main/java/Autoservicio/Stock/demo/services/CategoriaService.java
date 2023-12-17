package Autoservicio.Stock.demo.services;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

import Autoservicio.Stock.demo.models.Dtos.CategoriaDto;
import Autoservicio.Stock.demo.models.Dtos.CategoriaRequest;
import Autoservicio.Stock.demo.models.Dtos.ProductoDto;
import Autoservicio.Stock.demo.models.entity.Categoria;
import Autoservicio.Stock.demo.models.entity.Producto;
import Autoservicio.Stock.demo.repositories.CategoriaRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoriaService {
    private final CategoriaRepo categoriaRepo;

    public void addCategoria(CategoriaRequest categoriaRequest){
        Categoria categoria = Categoria.builder()
        .nombre_categoria(categoriaRequest.getNombre_categoria())
        .build();
     categoriaRepo.save(categoria);
     log.info("categoria agregada", categoria);
    }

    public List<CategoriaDto> getAllCategorias(){
      List<Categoria> categorias = categoriaRepo.findAll();
      List<CategoriaDto> listCategorias = new ArrayList<>();

      for(Categoria categoria : categorias){
        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.setId(categoria.getId());
        categoriaDto.setNombre_categoria(categoria.getNombre_categoria());

        listCategorias.add(categoriaDto);
      }
          return listCategorias;
    }

    public ProductoDto findCategoriaById(Long id){
        Categoria categoria = categoriaRepo.findById(id).orElseThrow();
        
        return ProductoDto.builder()
        .id(categoria.getId())
        .categoria_name(categoria.getNombre_categoria())
        .build();
    }
}
