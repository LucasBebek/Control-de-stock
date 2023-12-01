package Autoservicio.Stock.demo.models.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDto {
    
    private Long id;
    private String nombre;
    private Long stock;
    private Double precio;
    private Double precio_unitario;
    
}
