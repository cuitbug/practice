package wo.common.exception;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class WoExceptionHandler {
	private final static Logger LOG = LogManager.getLogger(WoExceptionHandler.class);
	
	@ExceptionHandler(WoException.class)
	@ResponseBody
	public Object handleWo(WoException exception) {
		LOG.error("", exception);
		return exception.getCode();
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Object handleOther(Exception exception) {
		LOG.error("", exception);
		return WoResultCode.getUnknownCode().setMsg("操作失败！");
	}
}
