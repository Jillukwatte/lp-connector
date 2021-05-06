package com.epic.lpconnector.repository.mysql;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.epic.lpconnector.entity.mysql.Smppconfiguration;
 

public interface SmppconfigurationMysqlRepository extends JpaRepository<Smppconfiguration, String>{
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "update smssmppconfiguration set isconnected=:isconnected, connectedip=:connectedip  where smppcode=:smppcode")
	void updateSmppconfiguration(@Param("isconnected") int isconnected,@Param("connectedip") String connectedip,@Param("smppcode") String smppcode);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "update smssmppconfiguration set isconnected=:isconnected where smppcode=:smppcode")
	void updateSmppconfiguration(@Param("isconnected") int isconnected,@Param("smppcode") String smppcode);
	
	
	
	
	
	
	
}
