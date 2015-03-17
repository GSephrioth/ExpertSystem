package com.cxz.service;

import com.cxz.entity.User;

public interface IUserManage {
	public void addUser(User user);
	public void modifyUser(User user);
	public void deleteUser(User user);
}
