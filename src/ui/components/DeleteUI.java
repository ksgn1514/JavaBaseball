package ui.components;

import java.util.Scanner;

import manager.DBConfig;

public class DeleteUI {

    public DeleteUI(){
        // 스캐너 선언
	    Scanner input = new Scanner(System.in);

        String id = null;
		
		System.out.println();
		System.out.println("[ 선수 삭제 ]");
		System.out.print("** 삭제할 선수 번호 > ");
		id = input.next();
		
		boolean res = DBConfig.manager.deletePlayer(id);
		if (res) {
			System.out.println("[정보] 삭제되었습니다.");
		}
		else {
			System.out.println("[정보] 삭제 대상이 존재하지 않습니다.");
		}
    }    
}
