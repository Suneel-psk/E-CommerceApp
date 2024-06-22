package in.psk.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.psk.constants.AppConstants;
import in.psk.dtos.CartDto;
import in.psk.props.AppProperties;
import in.psk.response.ApiResponse;
import in.psk.service.CartService;

@RestController
public class CartRestController {

	@Autowired
	private CartService cartServ;
	@Autowired
	private AppProperties props;

	@PostMapping("/cart")
	public ResponseEntity<ApiResponse<CartDto>> addToCart(@RequestBody CartDto cartDto){
		Map<String,String> messages=props.getMessages();
		ApiResponse<CartDto> response=new ApiResponse<>();
		CartDto cart=cartServ.addToCart(cartDto);
		if(cart!=null) {
			response.setStatus(200);
			response.setMessage(messages.get(AppConstants.CART_ADD));
			response.setData(cart);
		}else {
			response.setStatus(400);
			response.setMessage(messages.get(AppConstants.CART_ADD_ERR));
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}

	@PutMapping("/updatecart")
	public ResponseEntity<ApiResponse<CartDto>> updateCart(@RequestBody CartDto cartDto) {
		Map<String, String> messages = props.getMessages();
		ApiResponse<CartDto> response = new ApiResponse<>();
		CartDto cart = cartServ.updateCartQuantity(cartDto);
		if (cart != null) {
			response.setStatus(200);
			response.setMessage(messages.get(AppConstants.UPDATE_CART));
			response.setData(cart);
		} else {
			response.setStatus(400);
			response.setMessage(messages.get(AppConstants.UPDATE_CART_ERR));
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/cart/{cartId}")
	public ResponseEntity<ApiResponse<CartDto>> getCartById(@PathVariable Integer cartId) {
		Map<String, String> messages = props.getMessages();
		ApiResponse<CartDto> response = new ApiResponse<>();
		CartDto cart = cartServ.getCartById(cartId);
		if (cart != null) {
			response.setStatus(200);
			response.setMessage(messages.get(AppConstants.CART_FETCH));
			response.setData(cart);
		} else {
			response.setStatus(400);
			response.setMessage(messages.get(AppConstants.CART_FETCH_ERR));
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/deletecart/{cartId}")
	public ResponseEntity<ApiResponse<CartDto>> deleteCartById(@PathVariable Integer cartId) {
		Map<String, String> messages = props.getMessages();
		ApiResponse<CartDto> response = new ApiResponse<>();
		CartDto cart = cartServ.deleteCartById(cartId);
		if (cart != null) {
			response.setStatus(200);
			response.setMessage(messages.get(AppConstants.DELETE_CART));
			response.setData(cart);
		} else {
			response.setStatus(400);
			response.setMessage(messages.get(AppConstants.DELETE_CART_ERR));
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
