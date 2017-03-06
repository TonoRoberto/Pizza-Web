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

public class PortaPizze extends JFrame{
	
	
	
	PortaPizze(Map<Integer,List<String>> val){
		
		
		
		this.setTitle("LOGIN");
		
		
		JLabel titolo=new JLabel("                                                                          PIZZA WEB");
		JPanel jP=new JPanel();
		
		JTextArea  nome= new JTextArea();
		
		nome.setText("DISPONIBLITA IN CODA: ");
		JButton bIns= new JButton("VISUALIZZA");
		bIns.setSize(2,10);
		
		this.add(titolo,BorderLayout.NORTH);		
		jP.add(nome);
		jP.add(bIns);
		
		this.add(jP,BorderLayout.CENTER);
		
		
		
		bIns.addActionListener(e->{
			
			
			
			
				JOptionPane.showOptionDialog(null, "DISPONIBILE", "Warning",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						null, null, null);
			
		});
		
		
		// cambio colore di sfondo		
		jP.setBackground(Color.CYAN);		
		this.setBackground(Color.RED);
		
		this.setVisible(true);
		this.setSize(600, 200);
		
		
	}

}
