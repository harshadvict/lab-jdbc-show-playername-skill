package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dao.PlayerDAO;
import dao.SkillDAO;
import model.Player;

class Main{
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(" list of player and skill");
		PlayerDAO playerdaoObj=new PlayerDAO();
		List<Player> list =new ArrayList<>();
		list=playerdaoObj.getAllPlayers();
		Iterator<Player> iterator=list.iterator();
		System.out.println();
		System.out.println("ID\t\t"+"NAME\t\t"+"COUNTRY\t\t"+"SKILL\t\t");
		while(iterator.hasNext()) {
			Player playerobj=iterator.next();
			System.out.println();
			System.out.println();
			System.out.println(playerobj.getPlayerld()+"\t\t"+playerobj.getName()+"\t\t"+playerobj.getCountry()+"\t\t"+playerobj.getSkill().getSkillName());
		}
	}
}

