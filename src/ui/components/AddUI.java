package ui.components;

import java.util.Scanner;

import manager.BaseballManager;
import manager.DBConfig;

/**
 * 선수 정보 입력
 */
public class AddUI {

    Scanner input = new Scanner(System.in);
    BaseballManager manager = DBConfig.manager;

    public AddUI() {
        System.out.println("선수 정보 입력");
    }

}
