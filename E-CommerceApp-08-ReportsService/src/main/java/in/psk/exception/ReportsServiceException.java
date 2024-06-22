package in.psk.exception;

public class ReportsServiceException extends RuntimeException {
	private String errCode;

	public ReportsServiceException() {

	}

	public ReportsServiceException(String msg, String errCode) {
		super(msg);
		this.errCode = errCode;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

}
