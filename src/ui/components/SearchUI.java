package ui.components;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import dto.Player;
import manager.BaseballManager;
import manager.DBConfig;

public class SearchUI {

    Scanner input = new Scanner(System.in);
    BaseballManager manager = DBConfig.manager;

    public SearchUI(){
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
    
}
