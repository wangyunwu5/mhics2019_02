package cn.own.mhics.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.own.mhics.entity.Role;

public interface RoleDao extends JpaRepository<Role, Integer> {

	@Query("select r from Person p left join PersonRole pr on p.userId = pr.userId"
			+ " left join Role r on r.roleId = pr.roleId where p.account =?1")
	List<Role> getRoleByAccount(String account);

}
