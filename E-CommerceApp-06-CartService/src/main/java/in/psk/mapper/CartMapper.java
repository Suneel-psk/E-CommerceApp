package in.psk.mapper;

import org.modelmapper.ModelMapper;

import in.psk.dtos.CartDto;
import in.psk.entity.Cart;

public class CartMapper {
	private static final ModelMapper mapper = new ModelMapper();

	public static CartDto convertTODto(Cart cart) {
		return mapper.map(cart, CartDto.class);
	}

	public static Cart convertToEntity(CartDto cartDto) {
		return mapper.map(cartDto, Cart.class);
	}

}
