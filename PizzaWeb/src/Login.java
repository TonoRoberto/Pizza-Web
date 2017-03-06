import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Login extends JFrame{
	
	
	
	Login(Map<Integer,List<String>> val){
		
		
		
		this.setTitle("LOGIN");
		
		
		JLabel titolo=new JLabel("                                                                          PIZZA WEB");
		JPanel jP=new JPanel();
		JPanel jP2=new JPanel();
		
		JTextArea  nome= new JTextArea();
		JTextArea  nome2= new JTextArea();
		
		nome.setText("-----");
		nome2.setText("-----");
		JButton bIns= new JButton("LOGIN CLIENTE");
		bIns.setSize(2,10);
		
		JButton bInspp= new JButton("LOGIN PORTA PIZZE");
		bInspp.setSize(2,10);
		
		
		this.add(titolo,BorderLayout.NORTH);		
		
		//cliente
		jP.add(nome);
		jP.add(bIns);
		//porta pizze
		jP2.add(nome2);
		jP2.add(bInspp);
		
		this.add(jP,BorderLayout.CENTER);
		this.add(jP2,BorderLayout.SOUTH);
		
		
		
		bIns.addActionListener(e->{
			
			
			if(!nome.getText().equals("-----")){
				Prenotazione prenotazione = new Prenotazione(val);
			}
			else
				JOptionPane.showOptionDialog(null, "INSERISCI UN NOME VALIDO", "Warning",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						null, null, null);
			
		});
		
		bInspp.addActionListener(e->{
			
			
			if(!nome2.getText().equals("-----")){
				PortaPizze portaPizze = new PortaPizze(val);
			}
			else
				JOptionPane.showOptionDialog(null, "INSERISCI UN NOME VALIDO", "Warning",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						null, null, null);
			
		});
		
		
		// cambio colore di sfondo		
		jP.setBackground(Color.CYAN);		
		jP2.setBackground(Color.CYAN);		
		this.setBackground(Color.RED);
		
		this.setVisible(true);
		this.setSize(600, 200);
		
		
	}

}
