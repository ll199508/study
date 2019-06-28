package com.ll.springcloudapi.entities;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.io.Serializable;
@Data
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5085872946661268208L;
	@NotEmpty(message="用户名不能为空！")
	private String username;
	@Size(min=6,max=10,message = "密码长度必须6到10位")
	private String password;
	private String phone;
	private String email;
	
	
	

}
