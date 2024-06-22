package in.psk.service;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import in.psk.dtos.CategoryDto;
import in.psk.entity.Category;
import in.psk.mapper.CategoryMapper;
import in.psk.repo.CategoryRepository;
import in.psk.utils.FileUtils;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public CategoryDto saveCategory(CategoryDto categoryDto, MultipartFile file) throws Exception {
		Category category = CategoryMapper.convertToEntity(categoryDto);
		String fileName = FileUtils.saveFile(file.getName(), file);
		category.setCategoryImage(fileName);
		Category categorydata = categoryRepo.save(category);
		return CategoryMapper.convertToDto(categorydata);
	}

	@Override
	public CategoryDto updateCategory(Integer categoryId, CategoryDto categoryDto, MultipartFile file)
			throws Exception {
		Category category = CategoryMapper.convertToEntity(categoryDto);
		String fileName = FileUtils.saveFile(file.getName(), file);
		category.setCategoryImage(fileName);
		Category categoryData = categoryRepo.save(category);
		return CategoryMapper.convertToDto(categoryData);
	}

	@Override
	public CategoryDto deleteCategory(Integer categoryId) {
		Category category = categoryRepo.findById(categoryId).orElseThrow();
		if (category != null) {
			categoryRepo.deleteById(categoryId);
			CategoryDto categoryDto = CategoryMapper.convertToDto(category);
			return categoryDto;
		} else {
			return null;
		}
	}

	@Override
	public List<CategoryDto> geAllCategorys() {
		List<Category> category = categoryRepo.findAll();

		return category.stream().map(CategoryMapper::convertToDto).collect(Collectors.toList());
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Category category = categoryRepo.findById(categoryId).orElseThrow();
		CategoryDto categoryDto = CategoryMapper.convertToDto(category);
		return categoryDto;
	}

}
