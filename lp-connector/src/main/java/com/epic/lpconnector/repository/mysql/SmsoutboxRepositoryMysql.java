package com.epic.lpconnector.repository.mysql;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query; 
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.epic.lpconnector.entity.mysql.SmsoutboxMysql;
 

public interface SmsoutboxRepositoryMysql extends JpaRepository<SmsoutboxMysql, Integer>{
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "INSERT INTO smsoutbox (REFNO,MOBILE,MESSAGE,STATUS,DELSTATUS,DELREFNO,BULKID,BULKTYPE,PARTCOUNT,TELCO,"
			+ "DEPARTMENT,CHANNEL,CATEGORY,RESPONSECODE,LASTUPDATEDUSER,LASTUPDATEDTIME,CREATEDTIME,MTPORT,CHARGE,DELCONTENT) "
			+ "VALUES (:refno, :mobile, :message, :status, :deliverystatus, :deliveryref, :bulkid, :bulktype,:partcount,:telco,"
			+ ":department,:channel,:category,:responsecode,:lastupdateduser ,now(),now(),:mtport,:charge,:delcontent)")  //now //sysdate
	void insertSmsoutbox(
			@Param("refno") String refno ,
			@Param("mobile") String mobile, 
			@Param("message") String message,
			@Param("status") String status, 
			@Param("deliverystatus") String deliverystatus,
			@Param("deliveryref") String deliveryref,
			@Param("bulkid") int bulkid,
			@Param("bulktype") String bulktype, 
			@Param("partcount") int partcount,
			@Param("telco") String telco,
			@Param("department") String department,
			@Param("channel") String channel,
			@Param("category") String category,
			@Param("responsecode") String responsecode,
			@Param("lastupdateduser") String lastupdateduser,
			@Param("mtport") String mtport,
			@Param("charge") double charge,
			@Param("delcontent") String delcontent
			);
	
	
	@Query(value = "SELECT * from smsoutbox where delrefno =:deliveryref", nativeQuery = true)
	List<SmsoutboxMysql> findByDeliveryref(@Param("deliveryref") String deliveryref);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "update smsoutbox set delstatus=:deliverystatus where delrefno=:deliveryref")
	void updateSmsoutboxDeliveryStatus(@Param("deliverystatus") String deliverystatus,@Param("deliveryref") String deliveryref);
	
	
	
	
	
	
	
}
