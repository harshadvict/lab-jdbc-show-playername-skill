package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Skill;
import utility.ConnectionManager;

public class SkillDAO{
	public Skill getSkillBylD(Long id) throws ClassNotFoundException, SQLException {
		
		//Method used to fetch the skill information from the database based on the skill id.
		
		ConnectionManager conn= new ConnectionManager();
		// calling getConnection method 
		Connection  con =conn.getConnection();
		
		String sql="select * from skill where id=?";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setLong(1, id);
		ResultSet rs= stmt.executeQuery();
		while(rs.next()) {
			Skill skillobj=new Skill(rs.getLong(1), rs.getString(2));
			return skillobj;
		}
		return null;
		
	}
}
