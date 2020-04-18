package org.ttbdlk;

import java.util.ArrayList;

public interface DAO {
    void DbConnect();
    ArrayList<Player> GetPlayersData();
    ArrayList<Team> GetTeamsData();
    void pushDataToTeams(Team team);
    void pushDataToPlayers(Player player);
    void updateDataInTeams(Team team);
    void deleteData(int name);
    void createTable();
}
