package MemoEx;

import java.time.LocalDateTime;
import java.util.Date;

public class MemoVO {
    private int idx; // 글 번호
    private String writer; // 작성자 이름
    private String password; // 비밀번호
    private String content; // 게시글
    private LocalDateTime createdDate; // 작성일 ( 컴퓨터 시스템의 날짜와 시간 ==> Calendar

    public MemoVO() {}
    public MemoVO(int idx, String writer, String password, String content) {
        this.idx = idx;
        this.writer = writer;
        this.password = password;
        this.content = content;
    }

    public String getDisplay() {
        return idx + ") " + writer + " , " + password + " , " + content;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx){
        this.idx = idx;
    }

    public String getWriter() {
        return writer;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public String getPassword(){
            return password;
    }

    public void setCreatedDate(LocalDateTime date){this.createdDate = date;}
    public void setContent(String content){this.content = content;}
}
