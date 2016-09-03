/******************
 * 
 * @author 
 * @description This is the main method that passes 
 * 
 *
 */
package model;

import java.util.Scanner;

public class Main {
	public void mains(String [] args) {
		
		//create the routing table
		IP_NIC_Pair[] routingTable = new IP_NIC_Pair[4];
		Scanner input = new Scanner(System.in);
		String userInput = "";
		
		//fill routing table with IP/Subnet addresses and NIC
		routingTable[0] = new IP_NIC_Pair("135.46.56.0/22","Interface 0");
		routingTable[1] = new IP_NIC_Pair("135.46.60.0/22","Interface 1");
		routingTable[2] = new IP_NIC_Pair("192.53.40.0/23","Router 1");
		routingTable[3] = new IP_NIC_Pair("default"    ,"Router 2");
		
		do{
			System.out.println("Enter an IP and Subnet to send: \"ex: 192.168.1.12/22\"");
			System.out.println("Or type \"q\" to quit");
			
			System.out.println();
			
			userInput = input.nextLine();
			
			if(!userInput.equals("q")) {
				Router sendPacket = new Router(userInput,routingTable);
			}
				
			System.out.println();
			
		}while(!userInput.equals("q"));
		
		
		/*(a) 135.46.63.10
		(b) 135.46.57.14 
		(c) 135.46.52.2 
		(d) 192.53.40.7 
		(e) 192.53.56.7*/
		
	}
}
	