package pe.edu.idat.api_ventas_idat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.idat.api_ventas_idat.model.Product;

import java.util.List;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, Integer> {

    //FUNCIONES JPA
    //select * from product where discontinued = 0;

    List<Product> findBydiscontinued(Boolean discontinued);

    //Sintaxis JPQL
    @Query("SELECT p FROM Product p WHERE p.discomtinued=0")
    List<Product> obtenerProductosActivos();

    @Query(value = "SELECT * FROM products WHERE discontinued=0",
            nativeQuery = true)
    List<Product> obtenerProductosActivosSQL();

}
