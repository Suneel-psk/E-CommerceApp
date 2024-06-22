package in.psk.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import in.psk.dtos.ProductDto;
import in.psk.entity.Products;

public interface ProductService {

	//AddProduct
	public ProductDto saveProduct(ProductDto productDto,MultipartFile file)throws Exception;
	//UpdateProduct
	public ProductDto updateProduct(Integer productId,ProductDto productDto,MultipartFile file)throws Exception;
	//DeleteProduct
	public ProductDto deleteProduct(Integer productId);
	//GetAllProducts
	public List<ProductDto> getProducts();
	//GetProductById
	public ProductDto getProductById(Integer productId);
	//Update Stock
	public boolean updateStock(Integer productId,Integer quantity);
	
}
