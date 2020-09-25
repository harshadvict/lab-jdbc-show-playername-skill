package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.Skill;
import utility.ConnectionManager;

public class PlayerDAO{
	public List< Player > getAllPlayers() throws ClassNotFoundException, SQLException{
		
		
		//Method used to fetch all the players and their corresponding skill from the database.
		ConnectionManager conn= new ConnectionManager();
		// calling getConnection method 
		Connection  con =conn.getConnection();
		
		String sql="select * from player";
		PreparedStatement stmt =con.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
		List<Player> listPlayer=new ArrayList<>();
		
		while(rs.next()){
			Player playerobj=new Player(null,null,null, null);
			playerobj.setPlayerld(rs.getLong(1));
			playerobj.setName(rs.getString(2));
			playerobj.setCountry(rs.getString(3));
		    Long skill_id=rs.getLong(4);
		    SkillDAO skilldaoObj=new SkillDAO();
		    Skill skillobj=skilldaoObj.getSkillBylD(skill_id);
		    playerobj.setSkill(skillobj);
		    listPlayer.add(playerobj);
			}
		return listPlayer;
		
	}
}
