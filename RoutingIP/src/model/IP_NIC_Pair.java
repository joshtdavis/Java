package model;
/******************
 * @description this class is used to pair 
 * together an IP/Subnet address with a NIC.
 ******************/
public class IP_NIC_Pair {
	
	private String IP;
	private String NIC;
		
	public IP_NIC_Pair(String IP, String NIC) {
		this.IP = IP;
		this.NIC = NIC;
	}
		
	String getIP() { return IP; }
	String getNIC(){ return NIC;}
}