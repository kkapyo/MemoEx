package MemoEx;

import java.util.Scanner;

public class MemoApp {
    private static MemoList memoList;

    public static void memoDelete(){
        Scanner scDel = new Scanner(System.in);
        String choiceDel = scDel.nextLine();
        memoList.deleteMemo(Integer.parseInt(choiceDel));
    }

    public static void main(String[] args) {
        memoList = new MemoList(); // MemoList 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 메인 메뉴 루프
        while (true) {
            System.out.println("┌  4조 메모장    ┐");
            System.out.println("│   1. 입력     │");
            System.out.println("│   2. 목록     │");
            System.out.println("│   3. 수정     │");
            System.out.println("│   4. 삭제     │"); // 내 파트
            System.out.println("│   5. 종료     │");
            System.out.print("메뉴를 선택하세요: ");
            String choiceStr = scanner.nextLine();
            int count = 0;
            int choice;
            try {
                choice = Integer.parseInt(choiceStr); // 입력된 문자열을 정수롤 변환
            } catch (NumberFormatException e) { // 변환할 수 없을 경우 예외처리
                System.out.println("잘못된 입력입니다. 1 부터 5까지의 숫자를 입력해주세요.");
                continue;
            }

            switch (choice) {
                case 1:
                    // 입력 메뉴 추가
                    memoInput();
                    break;
                case 2:
                    // 목록 보기 메뉴
                    memoList.printAllMemos();
                    break;
                case 3:
                    // 수정 메뉴
                    System.out.println("몇번 째 글을 수정할까요?");
                    //글 목록 출력
                    Scanner sc = new Scanner(System.in);
                    String num = sc.next();
                    int number = 0;
                    try {
                        number = Integer.parseInt(num);
                    }
                    catch (NumberFormatException e){
                        System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                    }

                    memoList.updateMemo(number-1);
                    break;

                case 4:
                    // 삭제 메뉴
                    memoDelete();
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다. 다시 선택해주세요.");
                    break;
            }
        }
    }


    private static void memoInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 입력하세요 >> ");
        String nameInput = sc.nextLine();
        System.out.print("비밀번호를 입력하세요 >>");
        String pwInput = sc.nextLine();
        System.out.print("메모를 입력하세요 >>");
        String memoInput = sc.nextLine();
        MemoVO memo = new MemoVO();
        MemoList.addMemo(nameInput, pwInput, memoInput);
        MemoList.displayMemo();
    }


    // 필요한 경우 추가 메서드
}
