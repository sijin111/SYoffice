package com.syoffice.app.mail.model;

import java.util.List;
import java.util.Map;

import com.syoffice.app.mail.domain.MailAttachVO;
import com.syoffice.app.mail.domain.MailVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MailDAO {
	
	// === 메일박스의 총 페이지수 가져오기 === //
	int getMailBoxTotalPage(Map<String, String> paraMap);

	// === 메일박스 가져오기 === //
	List<Map<String, String>> getMailBox(Map<String, String> paraMap);

	// === 메일의 개수 가져오기 === //
	Map<String, Integer> getMailCount(Map<String, String> paraMap);

	// === 조직도 활용한 수신,참조인 추가용 회원 한 명의 정보를 가져오기 === //
	Map<String, String> getEmployeeInfo(Long emp_id);
	
	// 메일 번호 채번
	int getMailNo();
		
	// === 메일 정보 입력하기 === //
	int sendMail(Map<String, String> paraMap);
	
	// === 메일 수신입력 === //
	int intoMailBox(Map<String, String> paraMap);

	// === 메일 첨부파일 정보 입력하기 === //
	void insertAttachFile(Map<String, Object> paraMap);

	// === 메일 상세조회하기 === //
	List<MailVO> getMailDetail(Map<String, String> paraMap);

	// === 메일 읽음처리 === //
	void mailRead(Map<String, String> paraMap);

	// === 메일 첨부파일, 발신인 정보 가져오기 === //
	List<MailVO> getMailAttachFile(Map<String, String> paraMap);

	// === 한개의 첨부파일 정보를 가져오기 === //
	MailAttachVO getMailOneAttachFile(String atmailNo);
}
