package MemoEx;

import java.util.Date;

public class MemoVO {
    private int idx; // 글 번호
    private String writer; // 작성자 이름
    private String password; // 비밀번호
    private String content; // 게시글
    private Date createdDate; // 작성일 ( 컴퓨터 시스템의 날짜와 시간 ==> Calendar
    private Date modifiedDate; // 수정

    // Getter  Setter 메서드

    public MemoVO(String writer, String password, String content) {
        this.writer = writer;
        this.password = password;
        this.content = content;
    }

    public String getDisplay() {
        return writer + " , " + password + " , " + content;
    }

    public int getIdx() {
        return idx;
    }

    public String getWriter() {
        return writer;
    }

    public String getContent() {
        return content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
}
