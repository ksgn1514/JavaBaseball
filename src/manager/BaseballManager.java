package dao;

import java.util.ArrayList;

import dto.Player;

public class BaseballManager implements AbstractBaseballManager {
    
    /**
	 * 선수 정보를 저장할 리스트
	 */
	private ArrayList<Player> playerList;
	
	/**
	 * 생성자
	 */
	public BaseballManager () {
			playerList = new ArrayList<Player>();
	}

    @Override
    public Player searchId(String id) {

        return null;
    }

    @Override
    public boolean insertPlayer(Player player) {

        return false;
    }

    @Override
    public boolean deletePlayer(String id) {
        
        return false;
    }

    @Override
    public boolean updatePlayer(Player player) {

        return false;
    }

    @Override
    public ArrayList<Player> playerListForSalary(int minSalary, int maxSalary) {

        return null;
    }

    @Override
    public ArrayList<Player> bestPlayers() {

        return null;
    }

    @Override
    public ArrayList<Player> playerListForType(int type) {

        return null;
    }
}
