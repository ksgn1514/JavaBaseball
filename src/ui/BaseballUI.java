package ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import dto.Player;
import manager.BaseballManager;

public class BaseballUI {

    Scanner input = new Scanner(System.in);
    BaseballManager manager = new BaseballManager();

    /**
     * constructor
     */
    public BaseballUI() {
        int menuNum = 0;

        //프로그램 종료시까지 무한 반복
		while (true) {
			printMainMenu();
			try {
				menuNum = input.nextInt();
				switch (menuNum) {
                    case 1: search();	break;
					case 2: add();		break;
					case 3: delete();	break;
					case 4: update();	break;
					case 0: exit();		return;
					default:
						System.out.println("[오류] 다시 선택하세요.");
				}
			}
			catch (Exception e) {
				System.out.println("[오류] 입력형식이 잘못되었습니다.");
				input.nextLine();
			}
		}
    }

    /**
	 * 메인 메뉴 출력
	 */
	public void printMainMenu() {
		System.out.println();
		System.out.println("[ 야구 선수 정보 관리 ]");
        System.out.println("1. 선수 정보 검색");
		System.out.println("2. 선수 정보 입력");
		System.out.println("3. 선수 정보 삭제");
		System.out.println("4. 선수 정보 수정");

		System.out.println("0. 프로그램 종료");
		System.out.print("** 번호 선택 > ");
	}

    /**
	 * 선수 정보 검색
	 */
    public void search(){
        int num = 0;
        ArrayList<Player> list =null;

        try {
			System.out.println();
			System.out.println("[ 검색 ]");
			System.out.println("1. 전체");
			System.out.println("2. 투수");
			System.out.println("3. 타자");
			System.out.println("4. 베스트 플레이어");
			System.out.println("5. 연봉 검색");
			System.out.print("** 메뉴 선택 > ");
		
			num = input.nextInt();
			
			switch (num) {
			case 1 : 
				list = manager.playerListForType(1);
				break;
			case 2 : 
				list = manager.playerListForType(2);
				break;
			case 3 : 
				list = manager.playerListForType(3);
				break;
			case 4:
				list = manager.bestPlayers();
				break;
			case 5:
                int min, max =0;
				System.out.print("최저 연봉 : ");
				min = input.nextInt();
				System.out.print("최고 연봉 : ");
				max = input.nextInt();
				
				list = manager.playerListForSalary(min, max);
				break;
			default:
				System.out.println("[오류] 잘못 선택했습니다.");
				return;
			}
			print(list);		
		}
		catch (InputMismatchException ex) {
			System.out.println("[오류] 입력형식이 잘못되었습니다.");
			input.nextLine();
		}
    }

    
    /**
	 * 선수 정보 입력
	 */
    public void add(){
        System.out.println("선수 정보 입력");
    }

    /**
	 * 선수 정보 삭제
	 */
    public void delete(){
        System.out.println("선수 정보 삭제");
    }

    /**
	 * 선수 정보 수정
	 */
    public void update(){
        System.out.println("선수 정보 수정");
    }

    /**
	 * 목록 출력 
	 */
	public void print(ArrayList<Player> list) {
		System.out.println();
		
		if (list == null || list.size() == 0) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("총 " + list.size() + "건의 검색 결과가 있습니다.");
	}

    /**
	 * 프로그램 종료
	 */
	public void exit() {
		System.out.println("프로그램을 종료합니다.");
		return;
	}
}
