package com.player.main;

import java.util.List;
import java.util.Scanner;

import com.player.exception.BusinessException;
import com.player.model.Player;
import com.player.service.PlayerSearchService;
import com.player.service.impl.PlayerSearchServiceImpl;

public class PlayerMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Vinay's Player Search APP V1.0");
		System.out.println("--------------------------------------------------");
		PlayerSearchService playerSearchService=new PlayerSearchServiceImpl();
		int ch = 0;
		do {
			System.out.println("Player Search MENU");
			System.out.println("======================");
			System.out.println("1)By ID");
			System.out.println("2)By Last Name");
			System.out.println("3)By Age");
			System.out.println("4)By Gender");
			System.out.println("5)By Contact");
			System.out.println("6)By TeamName");
			System.out.println("7)All Players");
			System.out.println("8)EXIT");
			System.out.println("Please enter appropriate choice(1-8) :) ");
			try {
				ch = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {

			}
			switch (ch) {
			case 1:
				System.out.println("Please Enter Player ID to get Player Details");
				try {
					int id = Integer.parseInt(scanner.nextLine());
					//Code Here for SERVICE LAYER
					Player player=playerSearchService.getPlayerById(id);
					if(player!=null) {
						System.out.println("We found a player by ID = "+id+". Details are : ");
						System.out.println(player);
					}
				} catch (NumberFormatException e) {
					System.out.println("ID should be number only.. Kindly Re-enter");
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 2:	
				System.out.println("Please Enter The Last Name For The Players That You Wish To Locate");
				String lastName=scanner.nextLine();
				try {
					List<Player> playersListName=playerSearchService.getPlayersByLastName(lastName);
					if(playersListName!=null && playersListName.size()>0) {
						System.out.println("We Found "+playersListName.size()+" player/s with the name '"+lastName+"'. Details are:");
						for(Player p:playersListName) {
							System.out.println(p);
						}
					}
				} catch (BusinessException e1) {
					System.out.println(e1.getMessage());
				}

				break;

			case 3:
				
				System.out.println("Please Enter Player an Age to get Player Details");
				try {
					int age = Integer.parseInt(scanner.nextLine());
					List<Player> playersList=playerSearchService.getPlayersByAge(age);
					if(playersList!=null && playersList.size()>0) {
						System.out.println("We Found "+playersList.size()+" player/s in the DB.. Details are:");
						for(Player p:playersList) {
							System.out.println(p);
						}
					}
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}

				break;
				
			case 4:
				System.out.println("Please enter gender(M/F/O) to get the Players with that gender ");
				String gender=scanner.nextLine();
				try {
					List<Player> playersListGender=playerSearchService.getPlayersByGender(gender);
					if(playersListGender!=null && playersListGender.size()>0) {
						System.out.println("We Found "+playersListGender.size()+" no of player/s in the DB..with gender "+gender+" Details are:");
						for(Player p:playersListGender) {
							System.out.println(p);
						}
					}
				} catch (BusinessException e1) {
					System.out.println(e1.getMessage());
				}

				break;
				
			case 5:
				System.out.println("Please Enter Player Contact Number to get Player Details");
				try {
					long contact = Integer.parseInt(scanner.nextLine());
					
					//System.out.println("Entered = "+contact);
					//Code Here for SERVICE LAYER
					Player player=playerSearchService.getPlayerByContactNumber(contact);
					if(player!=null) {
						System.out.println("We found a player by Contact Number = "+contact+" Details are : ");
						System.out.println(player);
					}
				} catch (NumberFormatException e) {
					System.out.println("ID should be number only.. Kindly Re-enter");
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 6:
				System.out.println("Please Enter The Team Name For The Players That You Wish To Locate");
				String teamName = scanner.nextLine();
				try {
					List<Player> playersListTeam = playerSearchService.getPlayersByTeamName(teamName);
					if(playersListTeam!=null && playersListTeam.size()>0) {
						System.out.println("We Found "+playersListTeam.size()+" player/s on Team '"+teamName+"'. Details are:");
						for(Player p:playersListTeam) {
							System.out.println(p);
						}
					}
				} catch (BusinessException e1) {
					System.out.println(e1.getMessage());
				}

				break;
				
			case 7:
				System.out.println("Fetching All The Players From the DB");
				try {
					List<Player> playersList=playerSearchService.getAllPlayers();
					if(playersList!=null && playersList.size()>0) {
						System.out.println("We Found "+playersList.size()+" no of player/s in the DB.. Details are");
						for(Player p:playersList) {
							System.out.println(p);
						}
					}
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 8:
				System.out.println(
						"Thank YOU for using Vinay's Player Search App V1.0... We would expect you back very soon :)");

				break;
			default:
				System.out.println("Invalid Choice!!!! Please enter choice between 1-8 only");
				break;
			}
		} while (ch != 8);
		scanner.close();

	}

}
