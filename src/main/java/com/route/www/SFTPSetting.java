package com.route.www;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "images.sftp") 
public class SFTPSetting {
    public String host = "host";
    public String port = "port";
    public int timeout = 6000;
    public String username = "username";
    public String password = "password";
    public int SFTP_DEFAULT_PORT = 22;
    public String path = "";
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSFTP_DEFAULT_PORT() {
		return SFTP_DEFAULT_PORT;
	}
	public void setSFTP_DEFAULT_PORT(int sFTP_DEFAULT_PORT) {
		SFTP_DEFAULT_PORT = sFTP_DEFAULT_PORT;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
    
}