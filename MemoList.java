package MemoEx;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class MemoList {
    private static LinkedList<MemoVO> memos; // 메모들 저장하는 ArrayList


    public MemoList() {
        memos = new LinkedList<>();
    }   // MemoVO 객체를 저장하기 위한 ArrayList 객체

    public static void addMemo(String name, String pw, String memo) {
        memos.add(new MemoEx.MemoVO(name, pw, memo));
        // 메모를 리스트에 추가하는 메서드
    }

    public static void displayMemo() {
        MemoVO memo = memos.get(0);
        System.out.println(memo.getDisplay());
    }
    public MemoVO getMemo(int idx) {
        // idx에 해당하는 메모를 리스트에서 가져오는 메서드
        return null; // 일단 임시로 null로 적어놨습니다.
    }

    public void updateMemo(int idx) {
        // idx에 해당하는 메모를 업데이트하는 메서드 (수정)
        if(memos.get(idx) == null){
            System.out.println("메모가 존재하지 않습니다.");
        }
        else{
            //수정
            System.out.print("패스워드 입력 : ");
            Scanner sc = new Scanner(System.in);
            String psw = sc.next();
            if(memos.get(idx).getPassword().equals(psw)){       //패스워드 맞는지 화깅ㄴ
                System.out.println("수정할 내용을 입력해주세요.");
                String str = sc.next();
                memos.get(idx).setContent(str);                 //게시글 수정
                memos.get(idx).setCreatedDate(LocalDateTime.now());//날짜 수
                System.out.println("수정했습니다.");

            }
            else {
                System.out.println("비밀번호가 틀립니다.");
            }
        }
    }

    public void deleteMemo(int idx) {
        // idx에 해당하는 메모를 리스트에서 삭제하는 메서드
    }

    public void printAllMemos() {
        // 리스트에 있는 모든 메모를 출력하는 메서드
    }

    // 다른 메서드 추가할거있을까요?
}
