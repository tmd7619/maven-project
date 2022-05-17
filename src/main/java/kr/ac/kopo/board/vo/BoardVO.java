package kr.ac.kopo.board.vo;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class BoardVO {
	
	
	private int no;
	@Length(min=2 , max=40,  message="최소 2글자 이상 최대 40글자마 가능합니다.")
	@NotEmpty(message="필수항목입니다")
	private String title;
//	@Pattern(regexp = "^[A-Za-z]*&", message="특수기호는 사용할 수 없습니다") // 비밀번호 입력 시 , 특수기호 포함 넣기로 가능!
	@NotEmpty(message="필수항목입니다")
	private String writer;
	@NotEmpty(message="필수항목입니다")
	private String content;
	private int viewCnt;
	private String regDate;
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", viewCnt="
				+ viewCnt + ", regDate=" + regDate + "]";
	}
	
	
	
	

}
