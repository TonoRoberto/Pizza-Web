import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.util.*;
//______________
import java.util.List;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.hsqldb.Database;

import java.awt.*;
import java.awt.event.*;



public class Premi extends JFrame{
	
	int n=0,punti=0;
	
	Premi(Map<Integer,List<String>> val){
		this.setVisible(true);
		this.setSize(600, 600);
		
		JPanel jp=new JPanel(new FlowLayout(1,30,1));
		
		List<JButton> menu=new ArrayList<>();
		
		JButton bCompra=new JButton("RITIRA PREMI");
		
		JTextArea text=new JTextArea();
		text.setText("PUNTI:   "+val.toString());
		
		this.setTitle("RITIRA PREMI");
		
		
		this.add(jp);
		
		bCompra.addActionListener(e->{
			text.setText("N PREMI ORDINATI:   "+"--");
			JOptionPane.showOptionDialog(null, "PRESO ", "Warning",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					null, null, null);
		});
		
		
		
		//_______________
				
		val.get(1).forEach(s->{
			menu.add(new JButton(s));
			jp.add(menu.get(n));
			n++;
		});
		
		//_______________
		
		//jp.add(text);
		this.add(bCompra,new BorderLayout().SOUTH);
		
		
		menu.forEach(b->{
			b.addActionListener(e->{
				b.setEnabled(false);
				punti--;
			});
				
		});
		
		
		// cambio colore di sfondo
		jp.setBackground(Color.CYAN);		
		this.setBackground(Color.RED);
				
		
	}

}





