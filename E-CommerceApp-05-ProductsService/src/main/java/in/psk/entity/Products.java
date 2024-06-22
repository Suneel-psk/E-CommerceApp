package in.psk.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "products_rt")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_seq_generator")
    @SequenceGenerator(name="products_seq_generator", sequenceName = "CATEGORY_RT_SEQ", allocationSize = 1)
	@Column(name = "PRODUCT_ID")
	private Integer productId;
	@Column(name = "PRODUCT_NAME")
	private String productName;
	@Column(name = "DESCRIPTION")
	private String desc;
	@Column(name = "PRICE")
	private Integer price;
	@Column(name = "STOCK")
	private Integer stock;
	@Column(name = "IMAGE")
	private String image;
	@Column(name = "DISCOUNT")
	private Integer discount;
	@Column(name="PRICE_BEFORE_DISCOUNT")
	private Integer priceBeforeDiscount;
	@CreationTimestamp
	@Column(name="CREATED_DT",updatable=false)
	private LocalDate createdDate;
	@Column(name="UPDATED_DT",insertable=false)
	private LocalDate updatedDate;
	
	@ManyToOne
	@JoinColumn(name = "categoryId",nullable=false)
	private Category category;

	public Integer getPriceBeforeDiscount() {
		return priceBeforeDiscount;
	}

	public void setPriceBeforeDiscount(Integer priceBeforeDiscount) {
		this.priceBeforeDiscount = priceBeforeDiscount;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	

	

}
