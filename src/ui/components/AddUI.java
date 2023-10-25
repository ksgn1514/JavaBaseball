package ui.components;

import java.util.InputMismatchException;
import java.util.Scanner;

import dto.Batter;
import dto.Pitcher;
import dto.Player;
import manager.BaseballManager;
import manager.DBConfig;

/**
 * 선수 정보 입력
 */
public class AddUI {

    Scanner input = new Scanner(System.in);
    BaseballManager manager = DBConfig.manager;

    public AddUI() {
       int num = 0;
		Player player = null;
		
		String id;
		String name;
		String team;
		int salary;
		double war;
		
		double era;	
		int inning;
		int wins;
		int losses;	
		int save;
		int hold;
		
		double average;
		int atbat;
		int rbi;
		int score;
				
		//선수 구분 선택
		try {
			System.out.println();
			System.out.println("[ 선수 등록 ]");
			System.out.println("1. 투수");
			System.out.println("2. 타자");
			System.out.print("** 선수 구분 선택 > ");
			num = input.nextInt();
			
			if (num < 1 || num > 2) {
				System.out.println("[오류] 잘못 선택했습니다.");
				return;
			}
		
			//선수 정보 입력
			while (true) {
				System.out.print("선수 고유 번호 > ");
				id = input.next();
			
				if (manager.searchId(id) == null) break;
				System.out.println("[오류] 이미 존재하는 번호입니다.");
			}
			
			System.out.print("선수 이름 > ");
			name = input.next();
			System.out.print("소속팀 > ");
			team = input.next();
			System.out.print("연봉 > ");
			salary = input.nextInt();
			System.out.print("WAR > ");
			war = input.nextDouble();
			
			switch (num) {
			case 1:
				System.out.print("평균 자책 > ");
				era= input.nextDouble();
				System.out.print("이닝 > ");
				inning = input.nextInt();
				System.out.print("승 > ");
				wins = input.nextInt();
				System.out.print("패 > ");
				losses = input.nextInt();
				System.out.print("세이브 > ");
				save = input.nextInt();
				System.out.print("홀드 > ");
				hold = input.nextInt();
				
				player = new Pitcher(id, name, team, salary, war, era, inning, wins, losses, save, hold);
				break;
			case 2:
				System.out.print("타율 > ");
				average = input.nextDouble();
				System.out.print("타수 > ");
				atbat = input.nextInt();
				System.out.print("타점 > ");
				rbi = input.nextInt();
				System.out.print("득점 > ");
				score = input.nextInt();
				
				player = new Batter(id, name, team, salary, war, average, atbat, rbi, score);
				break;
			}
			}
			catch (InputMismatchException e) {
				System.out.println("[오류] 입력형식이 잘못되었습니다.");
				input.nextLine();
				return;
			}
			
			boolean res = manager.insertPlayer(player);
			if (res) {
				System.out.println("[정보] 저장되었습니다.");
			}
			else {
				System.out.println("[정보] 저정 실패했습니다.");
			}
    }

}
