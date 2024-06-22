package in.psk.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="CART_RT")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_seq_generator")
    @SequenceGenerator(name="cart_seq_generator", sequenceName = "CART_RT_SEQ", allocationSize = 1) // Set allocationSize to 1
	@Column(name="CART_ID")
	private Integer cartId;
	@Column(name="USER_ID")
	private Integer userId;
	@Column(name="PRODUCT_ID")
	private Integer productId;
	@Column(name="QUANTITY")
	private Integer quantity;
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	

}
