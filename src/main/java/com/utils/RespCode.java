package com.utils;

/**
 * 系统响应码定义<br/>
 * 根据需要各系统继承此类以扩展消息描述
 *系统级别 10XX
 * 用户相关 12xx
 * 绑卡
 * 认证
 * 借款
 * 还款
 *
 * @author fuli
 * @version 1.0
 * @date 2017-03-22 16:08
 */
public class RespCode {

	public static final RespCode SUCCESS = new RespCode("1000", "成功");
	public static final RespCode FAILED = new RespCode("1001", "失败");
	public static final RespCode REQUEST_INVALID_SIGN_ERROR = new RespCode("1005", "非法请求");
	public static final RespCode UNSUPPORT_ERROR = new RespCode("1006", "暂不支持");
	public static final RespCode SYSTEM_ERROR = new RespCode("9999", "服务器操作错误");
	public static final RespCode PARAM_NO_BLANK = new RespCode("1061", "参数不能为空");
	public static final RespCode PARAM_ERROR = new RespCode("1062", "参数错误");
	public static final RespCode RISK_ACTIVATE_LIMIT = new RespCode("1030", "系统升级中，请于明日再试。");


	// 消息业务响应码
	public static final RespCode CONNECTION_TIMEOUT = new RespCode("2000", "连接超时");
	public static final RespCode TEMPLATE_NOT_EXIT = new RespCode("2001", "短信模版不存在");
	public static final RespCode ACCOUNT_NOT_EXIT = new RespCode("2002", "短信通道账户不存在");

	public static final RespCode USER_AUTH_NOT_EXIST_ERROR = new RespCode( "1200", "用户认证信息不存在");
	public static final RespCode USER_FACE_AUTH_ERROR = new RespCode("1203", "相似度较低，请保证本人操作或尝试调亮光线");
	public static final RespCode USER_CARD_INFO_EXIST_ERROR = new RespCode( "1205", "请先完成实名信息提交");
	public static final RespCode LT_USER_ACCOUNT_NOT_EXIST_ERROR = new RespCode( "1207", "账户不存在");
	public static final RespCode USER_FACE_AUTH_NOT_SUPPORT = new RespCode("1208", "人脸识别系统正在升级中，请稍后再试");
	public static final RespCode LINKMAN_PHONE_ERROR = new RespCode("1210", "校验联系人号码错误");

	public static final RespCode LT_USER_NOT_EXIST_ERROR = new RespCode( "1209", "用户不存在");
	public static final RespCode AUTH_ALL_AUTH_ERROR = new RespCode( "1206", "信用认证未完成");
	public static final RespCode H5_NEW_USER_LIMIT = new RespCode( "1211", "还款专用，不可操作");
	public static final RespCode EMERGENCY_CONTACT_CHECK_ERROR = new RespCode("1209", "很抱歉，认证失败。建议您更换其他常用联系人后再次尝试");


	public static final RespCode USER_BANKCARD_NOT_EXIST_ERROR = new RespCode( "1202", "用户银行卡不存在");
	public static final RespCode LT_REQUEST_VERIFY_BORROWNO_REPAYNO_IS_NULL = new RespCode( "1628", "借款编号或还款编号为空");

	public static final RespCode LT_USER_BANKCARD_EXIST_ERROR = new RespCode("1604","该卡已被绑定，请更换银行卡");
	public static final RespCode LT_USER_BANKCARD_EXIST_ERROR_XS_MS = new RespCode("1609","此卡已绑定，请返回选择");
	public static final RespCode LT_SMS_VERIFICATION_ERROR = new RespCode("1603","请勿频繁操作");
	public static final RespCode LT_SMS_SEND_FAILED = new RespCode("1605","发送的短信验证码失败");
	public static final RespCode LT_AUTH_CARD_IS_INVALID_ERROR = new RespCode("1606","暂不支持该银行");
	public static final RespCode LT_USER_BANKCARD_NOT_EXIST_ERROR = new RespCode("1611","用户银行卡不存在");
	public static final RespCode LT_USER_BANKCARD_WRONG_PHONE_NUMBER_OR_NON_BANK_RESERVED = new RespCode("1612", "手机号错或非银行预留手机号");
	public static final RespCode LT_AUTH_BINDCARD_ERROR = new RespCode("1608","验证码校验失败");
	public static final RespCode UPS_AUTH_SIGN_ERROR = new RespCode("1309","签约失败");
	public static final RespCode MS_FAIL = new RespCode("1815", "调用马上获取信息失败");
	public static final RespCode MS_BILL_INIT_ERROR = new RespCode("1816", "马上初始化账单失败");
	public static final RespCode MS_CREDIT_AUTH_CONTRACT_LOAD_FAIL = new RespCode("1813", "获取授权协议失败");
	public static final RespCode THIRD_ORDERNO_BUILD_ERROR = new RespCode( "1310", "构建订单错误");
	public static final RespCode INSURANCE_AGREEMENT_IS_NOT_CHECK = new RespCode( "1207", "保险协议未勾选");
	public static final RespCode BANK_CARD_PAY_ERR = new RespCode( "1501", "银行卡支付失败");
	public static final RespCode UPS_COLLECT_NOTICE_ERROR = new RespCode( "1310", "ups还款通知错误");
	public static final RespCode LT_UPS_AUTH_SIGN_ERROR = new RespCode( "1607", "当前银行卡绑定失败,请尝试绑定其他银行卡");
	public static final RespCode LT_USER_AUTH_NOT_EXIST_ERROR = new RespCode( "1614", "用户未授权");
	public static final RespCode XS_REPAY_LIMIT = new RespCode( "1615", "很抱歉，暂不可操作 请在&param进行还款");

	// 主动业务校验异常提示 12
	public static final RespCode SMS_MOBILE_ERROR = new RespCode("1200", "请先获取验证码");
	public static final RespCode USER_BANKCARD_SMS_VALID_ERROR = new RespCode("1299", "验证码已失效，请重新发起还款");
	public static final RespCode USER_REGIST_SMS_ALREADY_ERROR = new RespCode("1201", "验证码已验证");
	public static final RespCode SMS_CODE_SEND_TIMES_LIMITED = new RespCode("1202", "当日获取次数超限，请明日再试\n");
	public static final RespCode USER_REGIST_SMS_ERROR = new RespCode("1107", "验证码有误，请重新输入");
	public static final RespCode USER_LOGIN_SMS_VALID_ERROR = new RespCode("1108", "验证码错误次数超限，请重新获取");
	public static final RespCode USER_REGIST_SMS_OVERDUE = new RespCode("1203", "验证码已经过期");
	public static final RespCode USER_CANNOT_REPEAT_OPERATE_ERROR = new RespCode("1204", "请勿重复操作");
	public static final RespCode LT_BANK_CARD_INVALID = new RespCode("1630", "银行卡无效");
	public static final RespCode LT_BANK_CARD_IN_MAINTAIN = new RespCode("1631", "银行处于维护中");


	public static final RespCode UPS_COLLECT_ERROR = new RespCode("1309", "单笔代收失败");
	public static final RespCode XS_REPAY_ERROR = new RespCode("1310", "未知异常，请联系客服");


	public static final RespCode BORROW_BILL_NOT_EXIST = new RespCode("1420", "借款账单不存在");
	public static final RespCode BORROW_CONFIRM_ERROR = new RespCode("1421", "借款确认请勿重复提交");
	public static final RespCode BORROW_CONFIRM_NOT_WITHIN_THE_ALLOWABLE_TIME_LIMIT = new RespCode("1423", "借款拥挤，请于明日再来试试吧");
	public static final RespCode BORROW_PROTOCAL_NOT_EXIST = new RespCode("1423", "借款协议不存在");



	public static final RespCode BORROW_AMOUNT_LESS_ALLOW_CAN_BORROW_ERROR = new RespCode("1204", "借钱金额低于最低可借金额");
	public static final RespCode BORROW_WEAK_RISK_FAIL_INFO = new RespCode("1205", "抱歉，由于信用评分不足本次借款失败，请过段时间再来尝试");
	public static final RespCode LT_COLLECTION_BANK_UNDER_MAINTENANCE = new RespCode("1236", "抱歉，收款银行正在维护中，请稍后再试");
	public static final RespCode BORROW_PERIOD_INEFFECT = new RespCode("1207", "借钱期数无效，请重新选择");
	public static final RespCode BORROW_VERIFYING_NOT_SUPPORTED = new RespCode("1212", "渠道暂不支持待放款");
	// code与前端定的不能改
	public static final RespCode RISK_VERIFY_ERROR = new RespCode("1311", "风控审批失败");
	public static final RespCode BORROW_RISK_VERIFY_ERROR = new RespCode("1312", "借款审批失败");
	public static final RespCode CALL_THIRDPARTY_ERROR = new RespCode("1209", "系统繁忙，稍后重试");
	public static final RespCode BORROW_NOT_EXIST = new RespCode("1210", "借钱不存在");
	public static final RespCode BORROW_CASH_REPAY_AMOUNT_ERROR = new RespCode("1401", "还款金额有误请重新检查");
	public static final RespCode BORROW_IS_SETTLEMENTED_ERROR = new RespCode("1403", "该笔借款已结清，请误重复提交！");
	public static final RespCode BORROW_HAS_UNFINISH_OVERDEU_BILL_ERROR = new RespCode("1404", "请先结清逾期的账单，再进行提前结清");
	public static final RespCode BORROW_BILLDAY_CAN_NOT_EARLY_SETTLEMENT_ERROR = new RespCode("1425", "账单日不允许提前结清");
	public static final RespCode BORROW_BORROWDAY_CAN_NOT_EARLY_SETTLEMENT_ERROR = new RespCode("1426", "借款当日不允许提前结清");
	public static final RespCode BORROW_CAN_NOT_EARLY_SETTLEMENT_ERROR = new RespCode("1427", "有还款中的订单，暂不允许提前结清");
	public static final RespCode BORROW_SETTLE_CRT_APPLY_DEALING_WITH = new RespCode("1428", "您有一笔结清证明正在处理中，请稍后再试");
	public static final RespCode BORROW_SETTLE_CRT_APPLY_COUNT_LIMIT = new RespCode("1429", "今日申请次数过多，请明天再试");
	public static final RespCode BORROW_SETTLE_CRT_APPLY_MAIL_CONFIG = new RespCode("1430", "结清证明邮件配置缺失");

	public static final RespCode HAVE_A_REPAYMENT_PROCESSING_ERROR = new RespCode("1500", "有一笔还款正在处理中");
	public static final RespCode FUND_NOT_HIT_DIALOG = new RespCode("2002", "没有配置资方信息");
	public static final RespCode LT_SMS_VERIFICATIONV1_ERROR = new RespCode("1699", "暂不支持此银行卡，请更换银行卡支付");
	public static final RespCode LT_SMS_VERIFICATIONV2_ERROR = new RespCode("1699", "验证码错误，请重新输入");
	public static final RespCode LT_REALNAME_INCONFORMITY = new RespCode("1600", "身份证校验不通过");
	public static final RespCode LT_GET_CREDIT_INFO_ERROR = new RespCode("1602", "对不起，您额度审批暂未通过，请于30天后重新提交审核，给您带来的不便敬请谅解");
	public static final RespCode LT_REQUEST_VERIFY_REALNAME_ERROR = new RespCode("1613", "获取数据失败");
	public static final RespCode LT_REPAY_BANK_UNDER_MAINTENANCE = new RespCode("1633", "抱歉，该银行正在维护中，请稍后再试");
	public static final RespCode LT_SEND_BORROW_SMS_LIMIT = new RespCode("1635", "当日操作已达上限，请于明日再试");
	public static final RespCode DXAL_NOT_REPAY = new RespCode("1636", "功能暂未开通，请您前往“沃钱包”或”联通手机营业厅“APP进行还款");
	public static final RespCode BORROWING_ORDER = new RespCode("1637", "很抱歉，您有借款未结清，请结清后再行尝试");
	public static final RespCode OVERDUE_BORROWING_ORDER = new RespCode("1637", "很抱歉，您有逾期账单未还，请还款后再次尝试");
	public static final RespCode REAL_NAME_DOING = new RespCode("1636", "身份认证中，请稍后");
	public static final RespCode ORDER_LOANING = new RespCode("1636", "您有借款正在放款中，请稍后(订单状态更新或有延迟)");
	public static final RespCode USER_IDNUMBER_EXIST = new RespCode("1644", "该身份证已被其他手机号绑定");
	public static final RespCode RISK_REFUSE = new RespCode("1636", "很抱歉，审核失败，您暂时无法借款");
	public static final RespCode BORROW_AUDITING = new RespCode("1636", "您有借款正在放款审核中，请稍后(预计3分钟内完成)");
	public static final RespCode MS_BORROW_AUDITING = new RespCode("1636", "额度审批中，请稍后(预计1个工作日内完成)");
	public static final RespCode  ID_NUMBER_ON_OVERDUE = new RespCode("1641", "您的身份证即将过期，请更新身份证后再来");
	public static final RespCode AU_AMOUNT_INVALIDATED = new RespCode("1642", "很抱歉，您当前额度已失效，请重新申请");
	public static final RespCode ID_NUMBER_OVERDUE = new RespCode("1643", "很抱歉，您当前的认证信息已失效，请重新认证后再行操作");
















	public static final RespCode LT_RISK_CREDIT_VALID_FAILED = new RespCode("1702", "额度授信失败");
	public static final RespCode FUNC_PARAM_ERROR = new RespCode("1711", "资方未认证");
	public static final RespCode USER_AUTH_NOT_PASS = new RespCode("1711", "认证未通过");
	public static final RespCode USER_CREDIT_INVALID = new RespCode("1711", "额度已失效");
	public static final RespCode FUND_REBORROW_NOT_SUPPORT = new RespCode("1711", "您存在一笔借款未结清");
	public static final RespCode FUND_OVERDUE_REBORROW_NOT_SUPPORT = new RespCode("1711", "您存在一笔逾期借款未结清");
	public static final RespCode FUND_BORROW_COUNT_LIMIT = new RespCode("1711", "您有借款正在处理中，请稍后再试");
	public static final RespCode EXPECT_BORROW_CANCLE_SUCCESS = new RespCode("1712", "当前无待放款");
	public static final RespCode BORROW_SAVE_FAILED = new RespCode("1713", "借款失败，请稍后再试");
	public static final RespCode LT_BANK_BILL_EXISTED = new RespCode("1636", "银行账单已存在");
	public static final RespCode MS_REPAY_LIMIT = new RespCode("1815", "很抱歉，&param点期间暂不支持还款，请于其他时间进行还款");
	public static final RespCode XS_BORROW_RATE_LIMIT = new RespCode("1816", "当前额度已用完，请于明日再试");
	public static final RespCode XS_OFF_REPAY_AMOUNT_ERROR = new RespCode("1817", "还款金额错误");
	public static final RespCode XS_OFF_REPAY_CREDITAMOUNT_ERROR = new RespCode("1818", "还款减免金额错误");
	public static final RespCode XS_OFF_REPAY_PAYNO_ERROR = new RespCode("1819", "还款单号有误");
	public static final RespCode XS_OFF_REPAY_EARLY_ERROR = new RespCode("1820", "提前结清金额有误");
	public static final RespCode XS_OFF_REPAY_RECY_QUERY_ERROR = new RespCode("1821", "锡商回收信息查询失败");
	public static final RespCode EB_OFFICE_WEBSITE_MOBILE_ERROR = new RespCode("1822", "手机号不合法，请重新输入");
	public static final RespCode EB_OFFICE_WEBSITE_FEEDBACK_TOO_LONG = new RespCode("1823", "输入内容过长，请重新输入");

	//催收系统错误码 19开头
	public static final RespCode COLLECTION_NOTIFY_REPAY_FAIL = new RespCode("1900", "通知催收还款失败");

	public static final RespCode NO_EVENT = new RespCode("2801", "无事件");

	public static final RespCode UPLOAD_FILE_FAIL = new RespCode("3001", "上传文件失败");

	//验证码
	public static final RespCode USER_HAS_IMAGE_CODE_ERROR = new RespCode("6001", "请填写图形验证码");
	public static final RespCode USER_GET_IMAGE_CODE_ERROR = new RespCode("6002", "请获取图形验证码");
	public static final RespCode USER_IMAGE_CODE_ERROR = new RespCode("6003", "图形验证码错误");
	public static final RespCode USER_HAS_OTHER_REGIST_ERROR = new RespCode("6004", "已通过其他平台注册了my钱包，请通过短信快捷登录或者点击忘记密码重设密码登录my钱包");
	public static final RespCode USER_HAS_REGIST_ERROR = new RespCode("6005", "该号码已经注册");
	public static final RespCode BORROW_INFO_ERROR = new RespCode("6006", "借款人信息认证失败");
	public static final RespCode USER_FACE_OUT_COUNT = new RespCode("6007", "人脸超过次数限制 ");
	public static final RespCode USER_FACE_ERROR = new RespCode("6008", "人脸失败 ");

	public final String code;
	public final String msg;

	public RespCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
