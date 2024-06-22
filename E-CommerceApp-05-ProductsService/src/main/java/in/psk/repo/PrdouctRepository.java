package in.psk.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.psk.entity.Products;

public interface PrdouctRepository extends JpaRepository<Products,Integer> {

}
