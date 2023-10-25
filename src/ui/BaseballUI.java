package ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import dto.Player;
import manager.BaseballManager;
import manager.DBConfig;
import ui.components.AddUI;
import ui.components.DeleteUI;
import ui.components.SearchUI;
import ui.components.UpdateUI;

public class BaseballUI {

    Scanner input = new Scanner(System.in);
    

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
                    case 1: new SearchUI();	break;
					case 2: new AddUI();	break;
					case 3: new DeleteUI();	break;
					case 4: new UpdateUI();	break;
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
	 * 프로그램 종료
	 */
	public void exit() {
		System.out.println("프로그램을 종료합니다.");
		return;
	}
}
