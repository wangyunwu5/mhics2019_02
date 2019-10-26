package cn.own.mhics.server;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.own.mhics.dao.PersonDao;
import cn.own.mhics.entity.Person;

@Service
@Transactional
public class UserService {
	@Autowired
	private PersonDao personDao;
	
	public Person findOneUserByAccount(String account) {
	  return personDao.findOneUserByAccount(account);
	}

}
