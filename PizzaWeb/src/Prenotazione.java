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



public class Prenotazione extends JFrame{
	
	int n=0,prezzo=0,punti=0;
	JButton tmp;
	
	Prenotazione(Map<Integer,List<String>> val){
		this.setVisible(true);
		this.setSize(600, 600);
		
		JPanel jp=new JPanel(new FlowLayout(1,30,1));
		JPanel jp2=new JPanel();
		
		List<JButton> menu=new ArrayList<>();
		
		JButton bCompra=new JButton("PRENOTA");
		JButton bpremi=new JButton("RITIRA PREMI");
		
		
		JTextArea text=new JTextArea();
		text.setText("$:   "+val.toString());
		
		this.setTitle("PRENOTAZIONE");
		
		
		this.add(jp);
		
		bCompra.addActionListener(e->{
			text.setText("$:   "+"--");
			JOptionPane.showOptionDialog(null, "N PIZZE ODINATE= "+this.prezzo, "Warning",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					null, null, null);
		});
		
		
		
		//_______________
		
		val.get(0).forEach(s->{
			tmp=new JButton(s);
			tmp.setSize(new Dimension(2,7));
			menu.add(tmp);
			jp.add(menu.get(n));
			n++;
		});
		
		//_______________
		
		//jp.add(text);
		jp2.add(bCompra);
		jp2.add(bpremi);
		
		this.add(jp2,new BorderLayout().SOUTH);
		
		menu.forEach(b->{
			b.setSize(new Dimension(2,7));
			
			b.addActionListener(e->{
				b.setEnabled(false);
				prezzo++;
				punti++;
			});
				
		});
		
		//premi
		bpremi.addActionListener(e->{
			new Premi(val);
		});
		
		
		// cambio colore di sfondo
		jp.setBackground(Color.CYAN);		
		this.setBackground(Color.RED);
		
		
	}

}





