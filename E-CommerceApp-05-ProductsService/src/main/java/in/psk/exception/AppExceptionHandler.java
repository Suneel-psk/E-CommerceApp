package in.psk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(value=ProductServiceException.class)
	public ResponseEntity<ExceptionResponse> handleProductService(ProductServiceException pse){
		ExceptionResponse exRep=new ExceptionResponse();
		exRep.setErrCode(pse.getErrCode());
		exRep.setErrMsg(pse.getMessage());
		return new ResponseEntity<>(exRep,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
