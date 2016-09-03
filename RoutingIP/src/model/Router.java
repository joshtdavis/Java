/******************************
 * @description This class takes an IP/Subnet string and
 * IP_NIC_Pair object as arguments to the constructor. The 
 * constructor then converts this to binary and determines which
 * interface to send the packet to by checking the routing table
 * (the IP_NIC_Pair object).
 */
package model;

import java.lang.Math;

public class Router {
	private String route;
	public Router(String ip_addr, IP_NIC_Pair[] table) {
		
		//break the IP/Subnet into tokens
		String[] parsedAddr = tokenizeAddr(ip_addr);
		
		//convert subnet to binary
		String subnet = subnetToBinary(parsedAddr[4]);
		//convert IP to binary
		String ip     = ipToBinary(parsedAddr);
		
		//print
		//System.out.println("Sub in bin: " + subnet);
		//System.out.println("IP in bin : " + ip);
		
		//AND subnet mask and ip to extact network ip
		String network = extractNetwork(ip, subnet);
		//print
		//System.out.println("Net in bin: " + network);
		
		//convert network ip to dot notation
		String networkDotAddr = binaryToDot(network);
		//print
		//System.out.println("Net in dot: " + networkDotAddr);
		
		
		route = compareNetToTable(networkDotAddr, table);
		//System.out.println("Route to: " + route);
		
	}
	
	
	//splits up the IP/Subnet address into an array
	private String[] tokenizeAddr(String addr) {
		return  addr.split("\\.|/");
	}
	
	//helper function for ipToBinary. Converts an int to binary
	private String octetToBinary(String octet) {
		String binary = "";
		int intOctet = Integer.parseInt(octet);
		
		for(int i = 7; i >= 0; i--) {
			if((intOctet - (Math.pow(2,i))) >= 0) {
				binary += 1;
				intOctet -= Math.pow(2,i);
			}else{
				binary += 0;
			}
		}
		return binary;
	}
	
	//converts an entire IP address to binary
	private String ipToBinary(String[] ip) {
		String binary = "";
		for(int i = 0; i < ip.length-1; i++) {
			binary += octetToBinary(ip[i]);
		}
		return binary;
	}
	
	//converts the subnet from slash notation ("/22") to binary
	private String subnetToBinary(String subnetMask){
		String binaryAddr = "";
		int subnet = Integer.parseInt(subnetMask);
		
		for(int i = 0; i < 32; i++){
			if(subnet > 0) {
				binaryAddr += "1";
			} else {
				binaryAddr += "0";
			}
			subnet--;	
		}
		
		return binaryAddr;
    }
	
	private String extractNetwork(String ip, String subnet) {
		String binary = "";
		for(int i = 0; i < ip.length(); i++) {
			
			if(ip.charAt(i) == '1' & subnet.charAt(i) == '1') {
				binary += "1";
			}else{
				binary += "0";
			}
		}
		return binary;
	}
	
	//converts binary address 4 octet to dot notation
	private String binaryToDot(String binary) {
		String dotAddr = "";
		int count = 7;
		int sumOfPowers = 0;
		for(int i = 0; i < 32; i++) {
			if(binary.charAt(i) == '1') {
				sumOfPowers += Math.pow(2, count);
			}
			
			if(count == 0) {
				dotAddr += sumOfPowers; 
				sumOfPowers = 0;
				if( i != 31){dotAddr += ".";}
				count = 8; }
			count--;
		}
		return dotAddr;
	}
	
	//determines if the IP that was passed to the constructor
	//is able to reach a network. If so, the interface is returned.
	//Otherwise it is sent to the default gateway
	private String compareNetToTable(String network, IP_NIC_Pair[] table) {
		String routee = "default";
		for(int i = 0; i < table.length; i++) {
			String net = table[i].getIP().length() > 11 ?
						 table[i].getIP().substring(0, 11) : "default";
			if(network.equals(net)) {
				return table[i].getNIC();
			}
		}
		return routee;
	}
	public String getRoute(){
		return route;
	}
}
