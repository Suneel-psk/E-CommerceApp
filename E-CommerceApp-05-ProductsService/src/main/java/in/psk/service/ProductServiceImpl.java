package in.psk.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import in.psk.dtos.ProductDto;
import in.psk.entity.Products;
import in.psk.mapper.ProductMapper;

import in.psk.repo.PrdouctRepository;
import in.psk.utils.FileUtils;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private PrdouctRepository productRepo;

	@Override
	public ProductDto saveProduct(ProductDto productDto, MultipartFile file) throws Exception {
		String fileName = FileUtils.saveFile(file.getName(), file);
		productDto.setImage(fileName);
		Products productEntity = ProductMapper.convertToEntity(productDto);
		productRepo.save(productEntity);
		return productDto;
	}

	@Override
	public ProductDto updateProduct(Integer productId, ProductDto productDto, MultipartFile file) throws Exception {
		Products product = productRepo.findById(productId).orElseThrow();
		if (product != null) {
			String fileName = FileUtils.saveFile(file.getName(), file);
			if (fileName != null) {
				productDto.setImage(fileName);
			}
			Products productEntity = ProductMapper.convertToEntity(productDto);
			Products productData = productRepo.save(productEntity);
			return ProductMapper.convertToDto(productData);
		} else {
			return null;
		}
	}

	@Override
	public ProductDto deleteProduct(Integer productId) {
		Products product = productRepo.findById(productId).orElseThrow();
		if (product != null) {
			productRepo.deleteById(productId);
			return ProductMapper.convertToDto(product);
		}
		return null;
	}

	@Override
	public List<ProductDto> getProducts() {
		List<Products> products = productRepo.findAll();
		return products.stream().map(ProductMapper::convertToDto).collect(Collectors.toList());
	}

	@Override
	public ProductDto getProductById(Integer productId) {
		Products product = productRepo.findById(productId).orElseThrow();
		return ProductMapper.convertToDto(product);
	}

	@Override
	public boolean updateStock(Integer productId, Integer quantity) {
		Products product = productRepo.findById(productId).orElseThrow();
		if (product != null) {
			product.setStock(quantity);
			productRepo.save(product);
			return true;
		} else {
			return false;
		}
	}

}
