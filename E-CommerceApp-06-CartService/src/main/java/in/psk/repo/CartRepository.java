package in.psk.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.psk.entity.Cart;

public interface CartRepository  extends JpaRepository<Cart,Integer>{

}
