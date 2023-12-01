package Autoservicio.Stock.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Autoservicio.Stock.demo.models.entity.Producto;

public interface ProductoRepo extends JpaRepository<Producto, Long>{
    
}
