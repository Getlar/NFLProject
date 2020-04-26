package org.ttbdlk;

import java.io.IOException;
import java.util.ArrayList;

public interface DAO {
    void DbConnect() throws IOException;
    ArrayList<Player> GetPlayersData() throws IOException;
    ArrayList<Team> GetTeamsData() throws IOException;
    void pushDataToTeams(Team team) throws IOException;
    void pushDataToDreamTeams(Team newDreamTeam) throws IOException;
    void pushDataToPlayers(Player player) throws IOException;
    void updateDataInDreamTeams(Team t1,Team t2) throws IOException;
    void deleteDreamTeam(String name) throws IOException;
    void pushPlayerToDreamTeam(Team dreamTeam, Player player) throws IOException;
    int playersInTheDreamTeam(Team dreamTeam) throws IOException;
    ArrayList<Team> getDreamTeams() throws IOException;
    ArrayList<Player> getPlayersFromDreamTeam(Team dreamTeam) throws IOException;
    void exchangePlayers(Team dreamTeam, Player in, Player out) throws IOException;
    //temporary
    void updateDataInPlayers(int pick, String name) throws IOException;
    int height(int feet, int inch);
    int weight(int lbs);
}
