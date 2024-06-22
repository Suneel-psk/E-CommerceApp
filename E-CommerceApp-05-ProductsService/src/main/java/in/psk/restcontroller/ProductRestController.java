package in.psk.restcontroller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.psk.constants.AppConstants;
import in.psk.dtos.CategoryDto;
import in.psk.dtos.ProductDto;
import in.psk.entity.Products;
import in.psk.props.AppProperties;
import in.psk.response.ApiResponse;
import in.psk.service.CategoryServiceImpl;
import in.psk.service.ProductServiceImpl;

@RestController
public class ProductRestController {
	@Autowired
	private ProductServiceImpl productService;
	
	@Autowired
	private AppProperties props;

	@PostMapping("/products")
	public ResponseEntity<ApiResponse<ProductDto>> createProduct(@RequestParam("product") String product,
			@RequestParam("file") MultipartFile file) throws Exception {
		Map<String,String> messages=props.getMessages();
		ApiResponse<ProductDto> response = new ApiResponse<ProductDto>();
		ObjectMapper mapper = new ObjectMapper();
		ProductDto productDto = mapper.readValue(product, ProductDto.class);
		ProductDto saveProduct = productService.saveProduct(productDto, file);
		if (saveProduct != null) {
			response.setStatus(200);
			response.setMessage(messages.get(AppConstants.ADD_PRODUCT));
			response.setData(saveProduct);
		} else {
			response.setStatus(500);
			response.setMessage(messages.get(AppConstants.ADD_PRODUCT_ERR));
		}
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping("/product")
	public ResponseEntity<ApiResponse<ProductDto>> updateProduct(@PathVariable("productId") Integer productId,
			@RequestParam("product") String product, @RequestParam("file") MultipartFile file) throws Exception {
		Map<String,String> messages=props.getMessages();
		ApiResponse<ProductDto> response = new ApiResponse<ProductDto>();
		ObjectMapper mapper = new ObjectMapper();
		ProductDto productDto = mapper.readValue(product, ProductDto.class);
		ProductDto updatedProduct = productService.updateProduct(productId, productDto, file);
		if (updatedProduct != null) {
			response.setStatus(200);
			response.setMessage(messages.get(AppConstants.UPDATE_PRODUCT));
			response.setData(updatedProduct);
		} else {
			response.setStatus(500);
			response.setMessage(messages.get(AppConstants.UPDATE_PRODUCT_ERR));
		}
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@DeleteMapping("/product/{productId}")
	public ResponseEntity<ApiResponse<ProductDto>> deleteProduct(@PathVariable("productId") Integer productId) {
		Map<String,String> messages=props.getMessages();
		ApiResponse<ProductDto> response=new ApiResponse<ProductDto>();
		ProductDto deletedProduct=productService.deleteProduct(productId);
		if (deletedProduct != null) {
			response.setStatus(200);
			response.setMessage(messages.get(AppConstants.DELETE_PRODUCT));
			response.setData(deletedProduct);
		} else {
			response.setStatus(500);
			response.setMessage(messages.get(AppConstants.DELETE_PRODUCT_ERR));
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/products")
	public ResponseEntity<ApiResponse<List<ProductDto>>> getAllProducts() {
		Map<String,String> messages=props.getMessages();
		ApiResponse<List<ProductDto>> response=new ApiResponse<>();
		List<ProductDto> productDto = productService.getProducts();
		if(productDto!=null) {
			response.setStatus(200);
			response.setMessage(messages.get(AppConstants.FETCH_PRODUCTS));
			response.setData(productDto);
		}else {
			response.setStatus(500);
			response.setMessage(messages.get(AppConstants.FETCH_PRODUCTS_ERR));
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/product/{productId}")
	public ResponseEntity<ApiResponse<ProductDto>> getProduct(@PathVariable("productId") Integer productId) {
		Map<String,String> messages=props.getMessages();
		ApiResponse<ProductDto> response=new ApiResponse<ProductDto>();
		ProductDto productDto = productService.getProductById(productId);
		if (productDto != null) {
			response.setStatus(200);
			response.setMessage(messages.get(AppConstants.SELECT_PRODUCT));
			response.setData(productDto);
		} else {
			response.setStatus(500);
			response.setMessage(messages.get(AppConstants.SELECT_PRODUCT_ERR));
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
