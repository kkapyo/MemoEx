package MemoEx;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;

public class MemoList {
    private static List<MemoVO> memos; // 메모들 저장하는 ArrayList

    public MemoList() {
        memos = new LinkedList<>(); // MemoVO 객체를 저장하기 위한 ArrayList 객체
    }

    public static void addMemo(String name, String pw, LocalDateTime date, String memo) {
        int num = memos.size() + 1;
        memos.add(new MemoEx.MemoVO(num, name, pw, date, memo));
        // 메모를 리스트에 추가하는 메서드
    }

    public static void displayMemo() {
        MemoVO memo = memos.get(memos.size() - 1);
        System.out.println(memo.getDisplay());
    }

    public MemoVO getMemo(int idx) {
        // idx에 해당하는 메모를 리스트에서 가져오는 메서드
        return null; // 일단 임시로 null로 적어놨습니다.
    }

    public void updateMemo(int idx) {
        // idx에 해당하는 메모를 업데이트하는 메서드 (수정)
        int adjustedIndex = idx - 1;
        if(memos.get(adjustedIndex) == null){
            System.out.println("메모가 존재하지 않습니다.");
        }
        else{
            //수정
            System.out.print("패스워드 입력 : ");
            Scanner sc = new Scanner(System.in);
            String psw = sc.next();
            if(memos.get(adjustedIndex).getPassword().equals(psw)){       //패스워드 맞는지 화깅ㄴ
                System.out.println("수정할 내용을 입력해주세요.");
                String str = sc.next();
                memos.get(adjustedIndex).setContent(str);                 //게시글 수정
                memos.get(adjustedIndex).setCreatedDate(LocalDateTime.now());//날짜 수
                System.out.println("수정했습니다.");


                updateIdx(idx);
                memos.get(idx).setIdx(1);
            }
            else {
                System.out.println("비밀번호가 틀립니다.");
            }
        }
    }

    public MemoVO getMemo(int idx){
        for(MemoVO m : memos){
            if(m.getIdx() == idx) {
                return m;
            }
        }
        return null;
    }

    public int getMemoIndex(int idx){
        int cnt = 0;
        for(MemoVO m : memos){
            cnt++;
            if(m.getIdx() == idx) {
                return cnt;
            }
        }
        return 0;
    }

    public void updateIdx(int idx){
        int i = 1;
        for(MemoVO m : memos){
            if(m.getIdx() < idx) {
                m.setIdx(m.getIdx()+1);

            }
        }
        for(MemoVO m : memos){
            if(m.getIdx() == idx+i) {
                m.setIdx(idx+i-1);
                i++;
            }
        }
    }

    public void deleteMemo(int idx) {

        ////////////////////////////////////////////////////////////////////////
        // (1) idx값으로 MemoVO 객체 얻기
        //MemoVO memo = memos.get(idx);

        // (2) 삭제 시 글 번호를 넘겨 받고 리스트에서 글 번호에 해당하는  글 1건을 얻어와 리턴
        MemoVO memo = getMemo(idx);
        ////////////////////////////////////////////////////////////////////////

        if(memo == null){
            System.out.println("해당 메모가 존재하지 않습니다.");
            return;
        }
        else {
            Scanner sc = new Scanner(System.in);
            System.out.println("비밀번호를 입력 해주세요");
            System.out.print("입력: ");
            String pw = sc.nextLine();

            if(memo.getPassword().equals(pw)){
                // 비밀번호 일치시 삭제

                ////////////////////////////////////////////////////////////////////////
                // (1) 인덱스값으로 해당 객체 제거하기
                //memos.remove(idx);

                // (2) loop로 하나씩 getIdx()으로 돌면서 해당 idx가 맞으면 그 인덱스 return
                int index = getMemoIndex(idx);
                memos.remove(index-1);
                ////////////////////////////////////////////////////////////////////////

                // 글 삭제 후 글 번호를 다시 붙여준다.
                //글이 삭제된 후 새 글이 입력될 때 idx가 기존 idx값에 이어서 1씩 증가할 수 있도록 count의 값을 수정한다.
                updateIdx(idx);

                System.out.println("선택하신 " + idx + "번 글이 삭제가 되었습니다.");
                return;
            }
            else {
                // 비밀번호 불일치
                System.out.println("비밀번호가 일치 하지 않습니다!");
                System.out.println("선택하신 " + idx + " 글  삭제가 되지 않습니다.");
                return;
            }
        }
    }

    public void printAllMemos() {
        System.out.println("========== 메모 목록 ==========");
        if (memos.isEmpty()) {
            System.out.println("글 목록이 없습니다.");
            try {
                Thread.sleep(1000); // 1초 지연
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return; // 메인으로 돌아가기
        }

        for (MemoVO memo : memos) {
            System.out.println("글 번호: " + memo.getIdx());
            System.out.println("작성자: " + memo.getWriter());
            System.out.println("작성일: " + memo.getCreatedDate());
            System.out.println("글 내용: " + memo.getContent());
            System.out.println("==============================");
        }

        System.out.println("\n1. 돌아가기");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            try {
                Thread.sleep(1000); // 1초 지연
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
