package manager;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchId'");
    }

    @Override
    public boolean insertPlayer(Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertPlayer'");
    }

    @Override
    public boolean deletePlayer(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePlayer'");
    }

    @Override
    public boolean updatePlayer(Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePlayer'");
    }

    @Override
    public ArrayList<Player> playerListForSalary(int minSalary, int maxSalary) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'playerListForSalary'");
    }

    @Override
    public ArrayList<Player> bestPlayers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bestPlayers'");
    }

    @Override
    public ArrayList<Player> playerListForType(int type) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'playerListForType'");
    }
}
