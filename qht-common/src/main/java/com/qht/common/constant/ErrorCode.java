package com.qht.common.constant;

/**
 * 错误编码
 * 
 * @author 草原狼
 * @date Jul 11, 2018 2:50:46 PM
 */
public interface ErrorCode {
	// 0~100，公共状态码，其他业务不得占用
	public String CODE_0 = "0";
	public String _0 = "操作成功";

	public String CODE_1 = "1";
	public String _1 = "操作失败";

	public String PARAM_IS_NULL = "2";
	public String _2 = "{0}参数为空指针";

	public String PARAM_IS_EMPTY = "3";
	public String _3 = "{0}参数为空";

	public String PARAM_NOT_INT = "4";
	public String _4 = "{0}参数非整型";

	public String PARAM_FORMAT_ERROR = "5";
	public String _5 = "{0}参数格式错误";

	public String RPC_INVOKE_FAIL = "6";
	public String _6 = "rpc调用失败";

	public String PARAM_RANGE_ERROR = "7";
	public String _7 = "{0}参数范围错误";

	public String CAN_NOT_PARSE_SIGN = "8";
	public String _8 = "不能解析签名";

	public String APPID_NOT_EXISTS = "9";
	public String _9 = "appid不存在";

	public String SIGN_VERIFY_ERROR = "10";
	public String _10 = "签名验证错误";

	public String CRYPT_ERROR = "11";
	public String _11 = "加密或解密错误";

	public String REQUEST_TIMEOUT = "12";
	public String _12 = "请求超时";

	/**
	 * 201 操作已完成
	 */
	public String _201 = "操作已完成";

	/**
	 * 300 密码有误
	 */
	public String _300 = "密码有误";

	/**
	 * 301 密码有误或没有该用户
	 */
	public String _301 = "密码有误或没有该用户";

	/**
	 * 302 信息有误
	 */
	public String _302 = "信息有误";

	/**
	 * 303 原密码有误
	 */
	public String _303 = "原密码有误";

	/**
	 * 304 该用户已存在
	 */
	public String _304 = "该用户已存在";

	/**
	 * 305 该公告信息已经发布，不能修改
	 */
	public String _305 = "该公告信息已经发布，不能修改";

	/**
	 * 306 该用户需短信验证
	 */
	public String _306 = "该用户需短信验证";

	/**
	 * 307 服务商ID不能为空
	 */
	public String CODE_307 = "307";
	public String _307 = "服务商ID不能为空";

	/**
	 * 308 token已过时，请重新登录！
	 */
	public String _308 = "token已过时，请重新登录！";

	/**
	 * 309 版本过旧请升级！
	 */
	public String _309 = "版本过旧请升级！";

	/**
	 * 310 没有该用户
	 */
	public String _310 = "没有该用户";
	/**
	 * 311 没有Session
	 */
	public String _311 = "没有Session";
	/**
	 * 312 验证码错误
	 */
	public String _312 = "验证码错误";
	/**
	 * 313 验证码失效 请重新获取
	 */
	public String _313 = "验证码失效 请重新获取";
	
	/**
	 * 315 手机号码已存在
	 */
	public String _315 = "手机号码已存在";
	/**
	 * 316 含有非法字符，请重新输入
	 */
	public String _316 = "含有非法字符，请重新输入";
	
	/**
	 * 319 数据不正确或数据不完整
	 */
	public String _319 = "数据不正确或数据不完整";
	/**
	 * 320 该树节点有数据不能删除
	 */
	public String _320 = "该树节点有数据不能删除";
	/**
	 * 无法修改密码
	 */
	public String _321 = "老密码不正确，无法修改成新密码";
	/**
	 * 设置密码失败
	 */
	public String _322 = "设置密码失败，没有对应的用户ID";

	/**
	 * 当前业务流程已经存在_业务ID
	 */
	public String _323 = "当前业务流程已经存在{0}";

	/**
	 * 当前业务流程已经存在_业务ID
	 */
	public String _324 = "当前业务流程不存在{0}";

	/**
	 * 当前业务流程已经结束_业务ID
	 */
	public String _325 = "当前业务流程已经结束{0}";

	/**
	 * 当前业务流程已经结束_不同意
	 */
	public String _326 = "审核人员不同意，当前业务流程已经结束";

	public String _327 = "没有发现审核信息";

	public String _328 = "无有效数据或导入数据量超过限制";
	
	/**
	 * 329 服务商ID不能为空
	 */
	public String CODE_329 = "329";
	public String _329 = "系统中不存在该ID的供应商";
	
	/**
	 * 330 足迹信息不能为空
	 */
	public String CODE_330 = "330";
	public String _330 = "足迹信息不能为空";
	
	/**
	 * 331足迹信息ID不能为空
	 */
	public String CODE_331 = "331";
	public String _331 = "足迹信息ID不能为空";
	
	
	/**
	 * 采购人ID不能为空
	 */
	public String CODE_332 = "332";
	public String _332 = "采购人ID不能为空";
	
	/**
	 * 用户ID不能为空
	 */
	public String CODE_333 = "333";
	public String _333 = "用户ID不能为空";
	
	/**
	 * 采购单位ID不能为空
	 */
	public String CODE_334 = "334";
	public String _334 = "采购单位ID不能为空";
	
	
	/**
	 * 采购单位ID不能为空
	 */
	public String CODE_335 = "335";
	public String _335 = "采购类目不能为空";
	
	/**
	 * 站内消息ID不能为空
	 */
	public String CODE_336 = "336";
	public String _336 = "站内消息ID不能为空";
	
	
	/**
	 * 用户类型不能识别
	 */
	public String CODE_337 = "337";
	public String _337 = "用户类型不能识别";

	/**
	 * 406 没有该设备
	 */
	public String _406 = "没有该设备";

	

	/**
	 * 411 操作太频繁，请稍后再试
	 */
	public String _411 = "操作太频繁，请稍后再试";

	/**
	 * 412 你账号已在其他客户端登录，如非本人操作，请修改登录密码
	 */
	public String _412 = "你账号已在其他客户端登录，如非本人操作，请修改登录密码";

	
	
	/**
	 * 415 请求信息不合法
	 */
	public String _415 = "请求信息不合法";
	/**
	 * 416 ticket失效
	 */
	public String _416 = "ticket失效";
	
	

	

	public String _419 = "查询不到对象关系";

	public String _420 = "查询不到微信绑定关系";

	public String _421 = "{0}呼叫路线错误";

	

	public String _423 = "微信绑定关系已存在";

	public String _424 = "对象树关系不正确";

	/**
	 * 425 该门编号已存在
	 */
	

	public String _426 = "微信appid不存在";
	
	

	/**
	 * 500 权限不足
	 */
	public String _500 = "权限不足";

	/**
	 * 501 没有该管理员
	 */
	public String _501 = "没有该管理员";

	/**
	 * 502 密码有误或没有该管理员
	 */
	public String _502 = "密码有误或没有该管理员";

	/**
	 * 503 该功能在该平台已被禁止，请在网页端操作
	 */
	public String _503 = "该功能在该平台已被禁止，请在网页端操作";

	/**
	 * 504 操作异常
	 */
	public String _504 = "操作异常";
	/**
	 * 505 操作失败
	 */
	public String _505 = "操作失败";
	/**
	 * 506 服务断路
	 */
	public String _506 = "服务断路";

	/**
	 * 播放时长为空
	 */
	public String _601 = "播放时长为空";

	/**
	 * 操作日志信息不全
	 */
	public String _701 = "操作日志信息不全";

	/**
	 * 没有对应的操作码
	 */
	public String _702 = "没有对应的操作码";

}
