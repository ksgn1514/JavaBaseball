package ui.components;

import java.util.Scanner;

import dto.Player;
import manager.DBConfig;

public class UpdateUI {
    // 스캐너 선언
	Scanner input = new Scanner(System.in);

    public UpdateUI() {
        Player player = null;
		String id = null;
		int salary = 0;
		
		System.out.println();
		System.out.println("[ 선수 수정 ]");
		System.out.print("** 수정할 선수 번호 > ");
		id = input.next();
		
		player = DBConfig.manager.searchId(id);
		if (player == null) {
			System.out.println("[오류] 해당 번호의 선수 정보가 없습니다.");
			return;
		}
		
		try {
			System.out.print("** 수정할 선수 연봉 > ");
			salary = input.nextInt();
		}
		catch (Exception e) {
			System.out.println("[오류] 입력형식이 잘못되었습니다.");
			input.nextLine();
			return;
		}
		
		player.setSalary(salary);
		boolean res = DBConfig.manager.updatePlayer(player);
		if (res) {
			System.out.println("[정보] 수정되었습니다.");
		}
		else {
			System.out.println("[정보] 수정 실패했습니다.");
		}
    }
}
