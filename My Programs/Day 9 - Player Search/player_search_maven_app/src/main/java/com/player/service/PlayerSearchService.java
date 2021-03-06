package com.player.service;

import java.util.List;

import com.player.exception.BusinessException;
import com.player.model.Player;

public interface PlayerSearchService {

	public Player getPlayerById(int id)throws BusinessException;
	public List<Player> getAllPlayers()throws BusinessException;
	public List<Player> getPlayersByLastName(String lastName)throws BusinessException;
	public List<Player> getPlayersByAge(int age)throws BusinessException;
	public Player getPlayerByContactNumber(long contact)throws BusinessException;
	public List<Player> getPlayersByTeamName(String teamName)throws BusinessException;
	public List<Player> getPlayersByGender(String gender)throws BusinessException;
	
}
