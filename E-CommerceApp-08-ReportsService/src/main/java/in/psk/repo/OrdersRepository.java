package in.psk.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.psk.entity.Orders;

public interface OrdersRepository  extends JpaRepository<Orders,Integer>{

	public List<Orders> findByOrderStatus(String orderStatus);
	
	public List<Orders> findByOrderDateBetween(LocalDate startDate,LocalDate endDate);
}
