package in.psk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
	@ExceptionHandler(value = ReportsServiceException.class)
	public ResponseEntity<ExceptionResponse> handlerReportsService(ReportsServiceException rse) {

		ExceptionResponse exResp = new ExceptionResponse();
		exResp.setErrCode(rse.getErrCode());
		exResp.setMessage(rse.getMessage());
		return new ResponseEntity<>(exResp, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
