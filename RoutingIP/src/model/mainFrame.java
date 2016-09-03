package model;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

import javax.swing.SwingConstants;

public class mainFrame extends JFrame {

	private JPanel contentPane;
	static IP_NIC_Pair[] routingTable;
	static Router sendPacket;
	private Timer t;
	private int i=0;
	private int interval = 1000;
	private JButton btnGo;
	private JProgressBar pBarI1R1;
	private JProgressBar pBarI0R2;
	private JProgressBar pBarR0I1;
	private JProgressBar pBarR0I0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		initialize();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame frame = new mainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private JTextField userInput;
	public mainFrame() {
		setTitle("Routing Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 30, 24, 35, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 46, 35, 25, 83, 33, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel router1 = new JLabel("Router1");
		GridBagConstraints gbc_router1 = new GridBagConstraints();
		gbc_router1.anchor = GridBagConstraints.EAST;
		gbc_router1.insets = new Insets(0, 0, 5, 5);
		gbc_router1.gridx = 2;
		gbc_router1.gridy = 1;
		contentPane.add(router1, gbc_router1);
		
		JLabel router2 = new JLabel("Router2");
		GridBagConstraints gbc_router2 = new GridBagConstraints();
		gbc_router2.anchor = GridBagConstraints.NORTH;
		gbc_router2.insets = new Insets(0, 0, 5, 5);
		gbc_router2.gridx = 14;
		gbc_router2.gridy = 1;
		contentPane.add(router2, gbc_router2);
		
		pBarI1R1 = new JProgressBar();
		pBarI1R1.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_pBarI1R1 = new GridBagConstraints();
		gbc_pBarI1R1.fill = GridBagConstraints.VERTICAL;
		gbc_pBarI1R1.gridheight = 5;
		gbc_pBarI1R1.insets = new Insets(0, 0, 5, 5);
		gbc_pBarI1R1.gridx = 2;
		gbc_pBarI1R1.gridy = 2;
		contentPane.add(pBarI1R1, gbc_pBarI1R1);
		//pBarI1R1.setValue(49);
		
		pBarI0R2 = new JProgressBar();
		pBarI0R2.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_pBarI0R2 = new GridBagConstraints();
		gbc_pBarI0R2.fill = GridBagConstraints.VERTICAL;
		gbc_pBarI0R2.gridheight = 5;
		gbc_pBarI0R2.insets = new Insets(0, 0, 5, 5);
		gbc_pBarI0R2.gridx = 14;
		gbc_pBarI0R2.gridy = 2;
		contentPane.add(pBarI0R2, gbc_pBarI0R2);
		//pBarI0R2.setValue(49);
		
		JLabel intrFace1 = new JLabel("Interface1");
		GridBagConstraints gbc_intrFace1 = new GridBagConstraints();
		gbc_intrFace1.ipadx = 1;
		gbc_intrFace1.insets = new Insets(0, 0, 5, 5);
		gbc_intrFace1.gridx = 2;
		gbc_intrFace1.gridy = 7;
		contentPane.add(intrFace1, gbc_intrFace1);
		
		pBarR0I1 = new JProgressBar();
		GridBagConstraints gbc_pBarR0I1 = new GridBagConstraints();
		gbc_pBarR0I1.fill = GridBagConstraints.HORIZONTAL;
		gbc_pBarR0I1.gridwidth = 3;
		gbc_pBarR0I1.insets = new Insets(0, 0, 5, 5);
		gbc_pBarR0I1.gridx = 3;
		gbc_pBarR0I1.gridy = 7;
		contentPane.add(pBarR0I1, gbc_pBarR0I1);
		//pBarR0I1.setValue(49);
		
		JLabel lblRouter = new JLabel("Router 0");
		GridBagConstraints gbc_lblRouter = new GridBagConstraints();
		gbc_lblRouter.insets = new Insets(0, 0, 5, 5);
		gbc_lblRouter.gridx = 7;
		gbc_lblRouter.gridy = 7;
		contentPane.add(lblRouter, gbc_lblRouter);
		
		pBarR0I0 = new JProgressBar();
		GridBagConstraints gbc_pBarR0I0 = new GridBagConstraints();
		gbc_pBarR0I0.fill = GridBagConstraints.HORIZONTAL;
		gbc_pBarR0I0.gridwidth = 5;
		gbc_pBarR0I0.insets = new Insets(0, 0, 5, 5);
		gbc_pBarR0I0.gridx = 9;
		gbc_pBarR0I0.gridy = 7;
		contentPane.add(pBarR0I0, gbc_pBarR0I0);
		//pBarR0I0.setValue(49);
		
		JLabel intrFace2 = new JLabel("Interface0");
		GridBagConstraints gbc_intrFace2 = new GridBagConstraints();
		gbc_intrFace2.ipadx = 1;
		gbc_intrFace2.insets = new Insets(0, 0, 5, 5);
		gbc_intrFace2.gridx = 14;
		gbc_intrFace2.gridy = 7;
		contentPane.add(intrFace2, gbc_intrFace2);
		
		JLabel lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 7;
		gbc_lblNewLabel.gridy = 8;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblDestination = new JLabel("IP Address Destination CIDR notation");
		GridBagConstraints gbc_lblDestination = new GridBagConstraints();
		gbc_lblDestination.gridwidth = 2;
		gbc_lblDestination.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDestination.insets = new Insets(0, 0, 5, 5);
		gbc_lblDestination.gridx = 3;
		gbc_lblDestination.gridy = 9;
		contentPane.add(lblDestination, gbc_lblDestination);
		
		JLabel lblSendsPacket = new JLabel("Sends Packet");
		GridBagConstraints gbc_lblSendsPacket = new GridBagConstraints();
		gbc_lblSendsPacket.insets = new Insets(0, 0, 5, 5);
		gbc_lblSendsPacket.gridx = 14;
		gbc_lblSendsPacket.gridy = 9;
		contentPane.add(lblSendsPacket, gbc_lblSendsPacket);
		
		userInput = new JTextField();
		GridBagConstraints gbc_userInput = new GridBagConstraints();
		gbc_userInput.insets = new Insets(0, 0, 5, 5);
		gbc_userInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_userInput.gridx = 3;
		gbc_userInput.gridy = 10;
		contentPane.add(userInput, gbc_userInput);
		userInput.setColumns(10);
		
		btnGo = new JButton("GO");
		btnGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				i=0;
				btnGo.setEnabled(false);
				pBarI1R1.setValue(0);
				pBarI0R2.setValue(0);
				pBarR0I1.setValue(0);
				pBarR0I0.setValue(0);
				sendPacket = new Router(userInput.getText(),routingTable);
				runRoute();
			}
		});
		GridBagConstraints gbc_btnGo = new GridBagConstraints();
		gbc_btnGo.insets = new Insets(0, 0, 5, 5);
		gbc_btnGo.gridx = 14;
		gbc_btnGo.gridy = 10;
		contentPane.add(btnGo, gbc_btnGo);
	}
	public void runRoute(){
		
		if(sendPacket.getRoute().equals("Interface 1")){
			//JOptionPane.showMessageDialog(null, "Interface 1 choosen. Graphic to follow");
			doGraphic(pBarR0I1);
		}
		else{
			if(sendPacket.getRoute().equals("Interface 0")){
				//JOptionPane.showMessageDialog(null, "Interface 0 choosen. Graphic to follow");
				doGraphic(pBarR0I0);
			}
			else{
				if(sendPacket.getRoute().equals("Router 1")){
					//JOptionPane.showMessageDialog(null, "Router 1 choosen. Graphic to follow");
					doGraphic(pBarR0I1,pBarI1R1);
				}
				else{
					//JOptionPane.showMessageDialog(null, "Router 2 choosen. Graphic to follow");
					doGraphic(pBarR0I0,pBarI0R2);
				}
			}
		}
	}
	private void doGraphic(){
		doGraphic(null,null);
	}
	
	private void doGraphic(JProgressBar jpb){
		//JOptionPane.showMessageDialog(null, "Graphic jpb here progress bar " + jpb.getName());
		doGraphic(jpb,null);
	}
	
	private void doGraphic(final JProgressBar jpb1, final JProgressBar jpb2){
		//JOptionPane.showMessageDialog(null, "Graphic jpb1 here progress bar " + jpb1.getName());
		if(jpb1 == null){
			//JOptionPane.showMessageDialog(null, "Graphic jpb1 is null here progress bar " + jpb1.getName());
			// no progress bars most likely there is an error 
		}
		else{
			//JOptionPane.showMessageDialog(null, "Graphic jpb1 else here progress bar " + jpb1.getName());
			if(jpb2 == null){
				//JOptionPane.showMessageDialog(null, "Graphic jpb1 jpb2 is null here progress bar " + jpb1.getName());
				// only one progress bar needed
				
				t = new Timer(interval, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent ae){
						//JOptionPane.showMessageDialog(null, "timer started here ");
						if(i==20){
							//JOptionPane.showMessageDialog(null, "i is 20 ");
							t.stop();
							//JOptionPane.showMessageDialog(null, "timer stoped here ");
							btnGo.setEnabled(true);
						}
						i++;
						//JOptionPane.showMessageDialog(null, "i is" + i);
						jpb1.setValue(i*5);
						//JOptionPane.showMessageDialog(null, "progress bar updated");
						
					}
				});
				t.start();
			}
				else{
					// two progress bars are needed
					t = new Timer(interval, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent ae){
							t.start();
							if(i<=20){
								jpb1.setValue(i);
								i++;
							}
							else{
								if(i==40){
									t.stop();
									btnGo.setEnabled(true);
								}
								i++;
								jpb2.setValue((i-20)*5);
							}	
							
						}
					});
					t.start();
				}
		}
	}
	//public void timer(JProgressBar pb){
	//	Timer t = new Timer();
	//}
	
	private static void initialize(){
		//create the routing table
				routingTable = new IP_NIC_Pair[4];
				Scanner input = new Scanner(System.in);
				String userInput = "";
				
				//fill routing table with IP/Subnet addresses and NIC
				routingTable[0] = new IP_NIC_Pair("135.46.56.0/22","Interface 0");
				routingTable[1] = new IP_NIC_Pair("135.46.60.0/22","Interface 1");
				routingTable[2] = new IP_NIC_Pair("192.53.40.0/23","Router 1");
				routingTable[3] = new IP_NIC_Pair("default"    ,"Router 2");
				
	}

}
