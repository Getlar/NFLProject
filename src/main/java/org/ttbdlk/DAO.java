package org.ttbdlk;

import java.util.ArrayList;

public interface DAO {
    void DbConnect();
    ArrayList<Player> GetPlayersData();
    ArrayList<Team> GetTeamsData();
    void pushDataToTeams(Team team);
    void pushDataToDreamTeams(Team newDreamTeam);
    void pushDataToPlayers(Player player);
    void updateDataInTeams(Team team);
    void deleteData(int name);
    void pushPlayerToDreamTeam(Team dreamTeam, Player player);
    int playersInTheDreamTeam(Team dreamTeam);
    ArrayList<Team> getDreamTeams();
    ArrayList<Player> getPlayersFromDreamTeam(Team dreamTeam);
    void exchangePlayers(Team dreamTeam, Player in, Player out);
}
