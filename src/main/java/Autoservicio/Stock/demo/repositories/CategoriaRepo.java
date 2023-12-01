package Autoservicio.Stock.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import Autoservicio.Stock.demo.models.entity.Categoria;

public interface CategoriaRepo extends JpaRepository<Categoria, Long> {
    
}
