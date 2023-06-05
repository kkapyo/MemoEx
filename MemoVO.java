package MemoEx;

import java.util.Date;

public class MemoVO {
    private int idx; // 글 번호
    private String writer; // 작성자 이름
    private String password; // 비밀번호
    private String content; // 게시글
    private Date createdDate; // 작성일 ( 컴퓨터 시스템의 날짜와 시간 ==> Calendar

    // Getter  Setter 메서드
    public int getIdx(){
        return idx;
    }

    public void setIdx(int idx){
        this.idx = idx;
    }

    public String getPassword(){
        return password;
    }
}
