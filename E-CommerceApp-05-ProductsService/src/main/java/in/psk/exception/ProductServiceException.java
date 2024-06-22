package in.psk.exception;

public class ProductServiceException extends RuntimeException {

	private  String errCode;
	public ProductServiceException() {
		
	}
	public ProductServiceException(String msg,String errCode) {
		super(msg);
		this.errCode=errCode;
		
	}
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	
}
