package in.psk.service;

import java.time.LocalDate;
import java.util.List;

import in.psk.dto.ProductOrderDto;

public interface OrderService {
	
	public List<ProductOrderDto> addOrder(List<ProductOrderDto> productOrders);
	
	public ProductOrderDto updateOrder(ProductOrderDto productOrderDto);
	
	public List<ProductOrderDto> getOrdersByUserId(Integer userId);
	
	public List<ProductOrderDto> getOrdersByDateAndStatus(LocalDate orderDate,
			String orderStatus);
	
	public List<ProductOrderDto> getAllOrders();
	
}