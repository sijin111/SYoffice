package com.syoffice.app.board.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.syoffice.app.board.domain.BoardVO;
import com.syoffice.app.board.domain.NoticeBoardVO;

//=== SqlSessionTemplate 을 사용하지 않는 Mapper Interface 예제(myBatis 3.0 이상 부터 사용가능함) === //
@Mapper	  // @Mapper 어노테이션을 붙여서 DAO 역할의 Mapper 인터페이스 파일을 만든다. 
		  // EmpDAO 인터페이스를 구현한 DAO 클래스를 생성하면 오류가 뜨므로 절대로 DAO 클래스를 생성하면 안된다.!!! 
		  // @Mapper 어노테이션을 사용하면 빈으로 등록되며 Service단에서 @Autowired 하여 사용할 수 있게 된다. 

public interface BoardDAO {
	
	
	// 부서 게시판 글쓰기 insert(파일첨부가 없는)
	int deptBoardWrite(BoardVO boardvo);
	
	// 부서 게시판 마지막글번호 조회해오기(파일첨부시 필요)
	List<Integer> board_no();
	
	// 부서별 게시판 파일첨부 테이블에 insert(파일 첨부가 있는 경우라면)
	int BoardWrite_withFile(BoardVO boardvo);
	
	// 공지사항 게시판 글쓰기 insert(파일첨부가 없는)
	int noticeBoardWrite(NoticeBoardVO noticevo);
	
	// 공지사항게시판 마지막 글번호 조회(파일첨부시 필요)
	List<Integer> notice_no();

	// 공지사항 게시판 파일첨부 테이블에 insert(파일 첨부가 있는 경우라면)
	int NoticeWrite_withFile(NoticeBoardVO noticevo);
	
	// 페이징 처리를 안한 검색어가 없는 공지사항 게시판 또는 부서게시판 전체 글목록 보여주기
	List<Map<String, String>> boardListNoSearch(String boardLocation);

	// 총 게시물 건수 (totalCount) 구하기 --> 검색이 있을 때와 검색이 없을때로 나뉜다.
	int getTotalCount(Map<String, String> paraMap);

	// 글목록 가져오기(페이징 처리 했으며, 검색어가 있는것 또는 검색어가 없는 것 모두 다 포함한 것이다.)
	List<Map<String, String>> boardListSearch_withPaging(Map<String, String> paraMap);

	// 글 조회수 증가는 없고 단순히 공지사항 게시판의 글 1개만 조회를 해오는 것
	NoticeBoardVO getNoticeBoardView_no_increase_readCount(Map<String, String> paraMap);

	// 글 1개 조회하기
	NoticeBoardVO getView(Map<String, String> paraMap);

	// 공지사항 게시판 글 조회수 1증가하기
	int increase_noticeViewCount(String notice_no);

	// 공지사항 게시판 글수정하기
	int update_notice_board(NoticeBoardVO noticeboardvo);

	// 파일첨부가 있는 글 삭제
	Map<String, String> noticeBoardView_delete(String notice_no);

	// 파일첨부, 사진이미지가 들었는 경우의 글 삭제하기
	int noticeBoarDel(String notice_no);

	// 첨부파일 있는지 없는지 확인 0: 없음, 그외 있음
	List<Map<String, String>> ischeckAttachfile(String notice_no);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 부서별게시판과 공지사항게시판에 글쓰기 insert(파일 첨부가 없는 경우라면)
//	int Board_Write(Map<String, String> paraMap);
	



	// 부서별 게시판과 공지사항 게시판 글쓰기에서 작성한 임시저장글 insert 해주기
//	int TempBoard_Write(Map<String, String> paraMap);

	// 페이징 처리를 안한 검색어가 없는 공지사항게시판 또는 부서게시판에 작성한 임시저장글 목록 보여주기
//	List<Map<String, String>> temporaryBoardSearch(String boardLocation);



















































}
