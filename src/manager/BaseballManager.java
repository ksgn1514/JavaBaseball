package manager;

import java.util.ArrayList;

import dto.Batter;
import dto.Pitcher;
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
        Player findPlayer = null;
		
		for (int i = 0; i < playerList.size(); i++) {
			findPlayer = playerList.get(i);
			if (id.equals(findPlayer.getId())) {
				return findPlayer;
			}
		}
		return null;
    }

    @Override
    public boolean insertPlayer(Player player) {
        if (searchId(player.getId()) != null) {
			return false;
		}
		playerList.add(player);
		return true;
    }

    @Override
    public boolean deletePlayer(String id) {
        Player player = null;
		for (int i = 0; i < playerList.size(); i++) {
			player = playerList.get(i);
			if (id.equals(player.getId())) {
				playerList.remove(i);
				return true;
			}
		}
		return false;
    }

    @Override
    public boolean updatePlayer(Player player) {

        return false;
    }

    @Override
    public ArrayList<Player> playerListForSalary(int minSalary, int maxSalary) {
        ArrayList<Player> list = new ArrayList<>();
		Player player = null;
		
		for (int i = 0; i < playerList.size(); i++) {
			player = playerList.get(i);
			if (minSalary <= player.getSalary() && player.getSalary() <= maxSalary) {
				list.add(player);
			}
		}
		return list;
    }

    @Override
    public ArrayList<Player> bestPlayers() {
        ArrayList<Player> list = new ArrayList<>();
		Player player = null;
		int cnt;
		
		for (int i = 0; i < playerList.size(); i++) {
			player = playerList.get(i);
			cnt = 0;
			for (int j = 0; j < playerList.size(); j++) {
				if (player.getWar() < playerList.get(j).getWar()) {
					cnt++;
				}
			}
			if (cnt == 0) list.add(player);
		}
		return list;
    }

    @Override
    public ArrayList<Player> playerListForType(int type) {
        // (1:전체 2:투수 3:타자)
        ArrayList<Player> list = new ArrayList<>();
        Player player = null;

        for (int i = 0; i < playerList.size(); i++) {
            player = playerList.get(i);

            if (type == 1) {
                list.add(player);
            } else if (type == 2) {
                if (playerList.get(i) instanceof Pitcher) {
                    list.add(player);
                }
            } else if (type == 3) {
                if (playerList.get(i) instanceof Batter) {
                    list.add(player);
                }
            }
        }
        return list;
    }
}
