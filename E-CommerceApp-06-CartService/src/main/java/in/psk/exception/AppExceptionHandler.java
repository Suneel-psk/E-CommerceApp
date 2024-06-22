package in.psk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
	@ExceptionHandler(value = CartServiceException.class)
	public ResponseEntity<ExceptionResponse> handleCartService(CartServiceException cse)

	{
		ExceptionResponse exResp = new ExceptionResponse();
		exResp.setErrCode(cse.getErrCode());
		exResp.setErrMsg(cse.getMessage());
		return new ResponseEntity<>(exResp,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
