package cn.own.mhics.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.own.mhics.entity.Resource;

public interface ResourceDao extends JpaRepository<Resource, Integer> {

	@Query("select re  from Resource re left join RoleResource rr on re.reId = rr.reId left join Role r on rr.roId = r.roleId where r.roleId=?1")
	List<Resource> getResourceByRole(Integer roleId);


}
