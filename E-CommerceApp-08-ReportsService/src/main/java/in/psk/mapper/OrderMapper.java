package in.psk.mapper;

import org.modelmapper.ModelMapper;

import in.psk.dtos.OrdersDto;
import in.psk.entity.Orders;

public class OrderMapper {

	private static final ModelMapper mapper = new ModelMapper();

	public static OrdersDto convertToDto(Orders order) {
		return mapper.map(order, OrdersDto.class);
	}

	public static Orders convertToEntity(OrdersDto ordersDto) {
		return mapper.map(ordersDto, Orders.class);
	}
}
