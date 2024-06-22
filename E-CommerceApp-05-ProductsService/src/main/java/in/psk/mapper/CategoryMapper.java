package in.psk.mapper;

import org.modelmapper.ModelMapper;

import in.psk.dtos.CategoryDto;
import in.psk.entity.Category;

public class CategoryMapper {

	private static final ModelMapper mapper = new ModelMapper();

	public static CategoryDto convertToDto(Category category) {
		return mapper.map(category, CategoryDto.class);
	}

	public static Category convertToEntity(CategoryDto categoryDto) {
		return mapper.map(categoryDto, Category.class);
	}

}
