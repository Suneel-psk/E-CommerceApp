package in.psk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.psk.dtos.CartDto;
import in.psk.entity.Cart;
import in.psk.mapper.CartMapper;
import in.psk.repo.CartRepository;
@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepo;
	@Override
	public CartDto addToCart(CartDto cartDto) {
		Cart cartEntity=CartMapper.convertToEntity(cartDto);
		Cart cart=cartRepo.save(cartEntity);
		return CartMapper.convertTODto(cart);
	}

	@Override
	public CartDto updateCartQuantity(CartDto cartDto) {
		Cart cartEntity=CartMapper.convertToEntity(cartDto);
		Cart cart=cartRepo.findById(cartEntity.getCartId()).orElseThrow();
		cart.setQuantity(cartEntity.getQuantity());
		return CartMapper.convertTODto(cart);
	}

	@Override
	public CartDto deleteCartById(Integer cartId) {
		Cart cart=cartRepo.findById(cartId).orElseThrow();
		if(cart!=null) {
			cartRepo.deleteById(cartId);
			return CartMapper.convertTODto(cart);
		}else {
			return null;
		}
		
	}

	@Override
	public CartDto getCartById(Integer cartId) {
		Cart cart=cartRepo.findById(cartId).orElseThrow();
		return CartMapper.convertTODto(cart);
	}

}
