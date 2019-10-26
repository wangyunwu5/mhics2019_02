package cn.own.mhics.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.own.mhics.entity.Person;

public interface PersonDao extends JpaRepository<Person, Integer> {

	@Query("select p from Person as p where p.account=?1")
	Person findOneUserByAccount(String account);

}
