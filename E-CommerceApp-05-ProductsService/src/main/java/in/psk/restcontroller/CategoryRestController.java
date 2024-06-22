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
import in.psk.entity.Category;
import in.psk.props.AppProperties;
import in.psk.response.ApiResponse;
import in.psk.service.CategoryServiceImpl;

@RestController
public class CategoryRestController {
	@Autowired
	private CategoryServiceImpl categoryService;

	@Autowired
	private AppProperties props;

	@PostMapping("/categorys")
	public ResponseEntity<ApiResponse<CategoryDto>> createCategory(@RequestParam("category") String category,
			@RequestParam("file") MultipartFile file) throws Exception {
		Map<String, String> messages = props.getMessages();
		ApiResponse<CategoryDto> response = new ApiResponse<CategoryDto>();
		ObjectMapper mapper = new ObjectMapper();
		CategoryDto categoryDto = mapper.readValue(category, CategoryDto.class);
		CategoryDto savedCategory = categoryService.saveCategory(categoryDto, file);
		if (savedCategory != null) {
			response.setStatus(200);
			response.setMessage(messages.get(AppConstants.ADD_CATEGORY));
			response.setData(savedCategory);
		} else {
			response.setStatus(500);
			response.setMessage(messages.get(AppConstants.ADD_CATEGORY_ERR));
		}
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping("/category/{categorId}")
	public ResponseEntity<ApiResponse<CategoryDto>> updateCategory(@PathVariable("categoryId") Integer categoryId,
			@RequestParam("category") String category, @RequestParam("file") MultipartFile file) throws Exception {
		Map<String, String> messages = props.getMessages();
		ApiResponse<CategoryDto> response = new ApiResponse<CategoryDto>();
		ObjectMapper mapper = new ObjectMapper();
		CategoryDto categoryDto = mapper.readValue(category, CategoryDto.class);

		CategoryDto updatedCategory = categoryService.updateCategory(categoryId, categoryDto, file);
		if (updatedCategory != null) {
			response.setStatus(200);
			response.setMessage(messages.get(AppConstants.UPDATE_CATEGORY));
			response.setData(updatedCategory);
		} else {
			response.setStatus(500);
			response.setMessage(messages.get(AppConstants.UPDATE_CATEGORY_ERR));
		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@DeleteMapping("/category/{categoryId}")
	public ResponseEntity<ApiResponse<CategoryDto>> deleteCategory(@PathVariable("categoryId") Integer categoryId) {
		Map<String, String> messages = props.getMessages();
		ApiResponse<CategoryDto> response = new ApiResponse<CategoryDto>();
		CategoryDto deletedCategory = categoryService.deleteCategory(categoryId);
		if (deletedCategory != null) {
			response.setStatus(200);
			response.setMessage(messages.get(AppConstants.DELETE_CATEGORY));
			response.setData(deletedCategory);
		} else {
			response.setStatus(500);
			response.setMessage(messages.get(AppConstants.DELETE_CATEGORY_ERR));
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/categorys")
	public ResponseEntity<ApiResponse<List<CategoryDto>>> getAllCategorys() {
		Map<String, String> messages = props.getMessages();
		ApiResponse<List<CategoryDto>> response = new ApiResponse<>();
		List<CategoryDto> categoryDtoList = categoryService.geAllCategorys();
		if (categoryDtoList != null) {
			response.setStatus(200);
			response.setMessage(messages.get(AppConstants.FETCH_CATEGORYS));
			response.setData(categoryDtoList);
		} else {
			response.setStatus(500);
			response.setMessage(messages.get(AppConstants.FETCH_CATEGORYS_ERR));
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("category/{categoryId}")
	public ResponseEntity<ApiResponse<CategoryDto>> getCategory(@PathVariable("categoryId") Integer categoryId) {
		Map<String, String> messages = props.getMessages();
		ApiResponse<CategoryDto> response = new ApiResponse<CategoryDto>();
		CategoryDto categoryDto = categoryService.getCategoryById(categoryId);
		if (categoryDto != null) {
			response.setStatus(200);
			response.setMessage(messages.get(AppConstants.SELECT_CATEGORY));
			response.setData(categoryDto);
		} else {
			response.setStatus(500);
			response.setMessage(messages.get(AppConstants.SELECT_CATEGORY_ERR));
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
