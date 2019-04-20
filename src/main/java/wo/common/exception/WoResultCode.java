package wo.common.exception;

import org.springframework.util.StringUtils;

public class WoResultCode {

	
	private String msg = "未知错误!";

	private Integer code = 0;
	
	private Long count ;
	
	private Object data = "";


	public WoResultCode() {
	}

	public WoResultCode(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public WoResultCode(Integer code, String msg,Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	public WoResultCode(Integer code, String msg, Long count, Object data) {
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public WoResultCode setMsg(String msg) {
		if (!StringUtils.isEmpty(msg)) {
			this.msg = msg;
		}
		return this;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static WoResultCode getUnknownCode() {
		return new WoResultCode();
	}
	
	public void setMsgArgs(Object... args) {
		if (args == null || args.length == 0) {
			return;
		}
		msg = String.format(msg, args);
	}
}
