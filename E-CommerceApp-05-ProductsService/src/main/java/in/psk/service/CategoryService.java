package in.psk.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import in.psk.dtos.CategoryDto;
import in.psk.entity.Category;


public interface CategoryService {

	//Add 
	public CategoryDto saveCategory(CategoryDto categoryDto,MultipartFile  file)throws Exception;
	//Update
	public CategoryDto updateCategory(Integer categoryId,CategoryDto categoryDto,MultipartFile file)throws Exception;
	//Delete
	public CategoryDto deleteCategory(Integer categoryId);
	//GetAllCategorys
	public List<CategoryDto> geAllCategorys();
	//GetCategoryById
	public CategoryDto getCategoryById(Integer categoryId);
}
