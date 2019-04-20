package wo.common.util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import wo.common.exception.WoResultCode;



public class PSysConstant {
	private final static Logger LOG = LogManager.getLogger(PSysConstant.class);
	
	public final static String APP_JSON = "application/json";
	
	public final static String SESSION_USER = "woUser";
	
	public final static WoResultCode ERR_LOGIN = new WoResultCode (102, "用户名或者密码不正确！");
	
	public final static WoResultCode ERR_LOGIN_NOT = new WoResultCode (104, "请登录！");
	
	public final static WoResultCode ERR_LOGIN_DEPT = new WoResultCode(105, "用户未关联部门！");

	public static final WoResultCode ERR_LOGIN_ROLE = new WoResultCode(106, "用户未关联该角色！");
	
	public static final WoResultCode ERR_PWD_OLD = new WoResultCode(107, "旧密码不正确！");

	public static final WoResultCode ERR_PWD_NEW = new WoResultCode(108, "新密码不能为空！");
	
	public static final WoResultCode ERR_PWD_SAME = new WoResultCode(109, "两次输入的新密码不一致！");
	
	public static final WoResultCode ERR_PWD_SAME2 = new WoResultCode(110, "新旧密码不能一样！");
	
	public final static WoResultCode ERR_DEPT_NO = new WoResultCode(200, "部门编号不能为空！");
	
	public final static WoResultCode ERR_DEPT_CHILD_NO = new WoResultCode(201, "下级部门编号必须以上级部门编号开头！");
	
	// public final static WoResultCode ERR_DEPT_PARENT = new WoResultCode(202, "未查询到上级部门！");
	
	public final static WoResultCode ERR_POSI_DEPT = new WoResultCode(210, "职务必须设置部门！");
	
	public final static WoResultCode ERR_STAFF_EXIST = new WoResultCode(220, "相同手机号码的人员已经存在！");
	
	public final static WoResultCode ERR_EMPTY = new WoResultCode(221, "%s不能为空！");
	
	public final static WoResultCode ERR_TASK = new WoResultCode(222, "您当前没有可执行的任务！");
}
