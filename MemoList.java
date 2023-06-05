package MemoEx;

import java.util.ArrayList;

public class MemoList {
    private ArrayList<MemoVO> memos; // 메모들 저장하는 ArrayList

    public MemoList() {
        memos = new ArrayList<>(); // MemoVO 객체를 저장하기 위한 ArrayList 객체
    }

    public void addMemo(MemoVO memo) {
        // 메모를 리스트에 추가하는 메서드
    }

    public MemoVO getMemo(int idx) {
        // idx에 해당하는 메모를 리스트에서 가져오는 메서드
        return null; // 일단 임시로 null로 적어놨습니다.
    }

    public void updateMemo(int idx) {
        // idx에 해당하는 메모를 업데이트하는 메서드 (수정)
    }

    public void deleteMemo(int idx) {
        // idx에 해당하는 메모를 리스트에서 삭제하는 메서드
    }

    public void printAllMemos() {
        // 리스트에 있는 모든 메모를 출력하는 메서드
        System.out.println("========== 메모 목록 ==========");
        for (MemoVO memo : memos) {
            System.out.println("글 번호: " + memo.getIdx());
            System.out.println("작성자: " + memo.getWriter());
            System.out.println("작성일: " + memo.getCreatedDate());
            System.out.println("글 내용: " + memo.getContent());
            System.out.println("==============================");
        }
    }
}
