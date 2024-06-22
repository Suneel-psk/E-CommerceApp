package in.psk.exception;

/*import lombok.Builder;
By Using this Builder annotation we no need create object by using new operator
@Builder
This builder will work according to spring tool suite version if its not work then it won't register with eureka serevr
*/
public class ExceptionResponse {
	
	private String errCode;
	private String errMsg;
	public ExceptionResponse() {
		
	}
	public ExceptionResponse(String errCode, String errMsg) {
		super();
		this.errCode = errCode;
		this.errMsg = errMsg;
	}
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	

}
