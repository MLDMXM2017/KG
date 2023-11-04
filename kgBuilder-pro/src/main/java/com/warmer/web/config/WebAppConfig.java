package com.warmer.web.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class WebAppConfig {

	/**
	 * 文件保存路径配置
	 */
	@Value("${file.location}")
	private String location; // 指定文件保存的位置

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
