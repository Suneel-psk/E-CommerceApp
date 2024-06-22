package in.psk.exception;

public class CartServiceException extends RuntimeException{
	private String errCode;
	public CartServiceException() {
		
	}
	public CartServiceException(String msg,String errCode) {
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
