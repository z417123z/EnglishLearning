package com.lzq.domain.common;

/**
 * 自定义协议或接口 服务器和客户端变成的接口 面向接口变成
 * 
 * 服务器给客户端返回的信息 
 * 
 * @author 86139
 *
 */
public class ReturnMessage {
	private String status;					//状态 ok nook
	private Object messageObject;			//如果是ok object返回一些对象信息 比如新增的user 如果是nook 返回的是错误信息

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getMessageObject() {
		return messageObject;
	}
	public void setMessageObject(Object messageObject) {
		this.messageObject = messageObject;
	}
	
	
	
}
