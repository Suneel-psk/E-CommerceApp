package in.psk.mapper;

import org.modelmapper.ModelMapper;

import in.psk.dtos.ProductDto;
import in.psk.entity.Products;

public class ProductMapper {

	private static final ModelMapper mapper = new ModelMapper();

	public static ProductDto convertToDto(Products product) {
		return mapper.map(product, ProductDto.class);

	}

	public static Products convertToEntity(ProductDto productDto) {
		return mapper.map(productDto, Products.class);

	}

}
