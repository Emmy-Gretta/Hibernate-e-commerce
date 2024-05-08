package rca.ac.rw.mis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rca.ac.rw.mis.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
