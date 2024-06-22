package in.psk.service;

import in.psk.dtos.CartDto;


public interface CartService {
	
	//AddToCart
	public CartDto addToCart(CartDto cartDto);
	//UpdateCart
	public CartDto updateCartQuantity(CartDto cartDto);
	//delteCartById
	public CartDto deleteCartById(Integer cartId);
	//getCartById
	public CartDto getCartById(Integer cartId);

}
