package cn.own.mhics.server;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.own.mhics.dao.PersonDao;
import cn.own.mhics.dao.ResourceDao;
import cn.own.mhics.dao.RoleDao;
import cn.own.mhics.entity.Person;
import cn.own.mhics.entity.Resource;
import cn.own.mhics.entity.Role;

@Service
@Transactional
public class UserService {
	@Autowired
	private PersonDao personDao;
	@Autowired
	private ResourceDao resourceDao;
	@Autowired
	private RoleDao roleDao;
	
	public Person findOneUserByAccount(String account) {
	  return personDao.findOneUserByAccount(account);
	}

	public List<Role> getRoleByAccount(String account) {
		return roleDao.getRoleByAccount(account);
	}

	public List<Resource> getResourceByRole(Integer roleId) {
		return resourceDao.getResourceByRole(roleId);
	}

	public List<Person> getUserList() {
		return personDao.getUserList();
	}
}
