package hu.pallas.vizsga;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stopper implements ActionListener{
 

	JFrame frame = new JFrame();
	JButton startGomb = new JButton("START");
	JButton resetGomb = new JButton("RESET");
	JLabel timeLabel = new JLabel();
	JLabel cimke = new JLabel();
	
	int elteltIdo = 0;
	int ezredMasodperc = 0;
	int masodperc =0;
	int perc =0;
	int ora =0;
	
	boolean futAzOra = false;
	private int ablakSzeles;
	private int ablakMagas;
	private boolean latszik; 
	
	
	public int getAblakSzeles() {
		return ablakSzeles;
	}

	public void setAblakSzeles(int ablakSzeles) {
		this.ablakSzeles = ablakSzeles;
	}

	public int getAblakMagas() {
		return ablakMagas;
	}

	public void setAblakMagas(int ablakMagas) {
		this.ablakMagas = ablakMagas;
	}

	public boolean isLatszik() {
		return latszik;
	}

	public void setLatszik(boolean latszik) {
		this.latszik = latszik;
	}

	String ezredMasodperc_string = String.format("%03d", ezredMasodperc);
	String masodperc_string = String.format("%02d", masodperc);
	String perc_string = String.format("%02d", perc);
	String ora_string = String.format("%02d", ora);
	String oraCimke = "Óra";
	String percCimke = "Perc";
	String mpercCimke = "Másodperc";
 
	Timer timer = new Timer(1000, new ActionListener() {
  
		public void actionPerformed(ActionEvent e) {
   
		   elteltIdo=elteltIdo+1000;
		   ora = (elteltIdo/3600000);
		   perc = (elteltIdo/60000) % 60;
		   masodperc = (elteltIdo/1000) % 60;
		   
		   masodperc_string = String.format("%02d", masodperc);
		   perc_string = String.format("%02d", perc);
		   ora_string = String.format("%02d", ora);
		   timeLabel.setText(ora_string+":"+perc_string+":"+masodperc_string);
		   
		}
  
	});
 
 
	public void stopperGUI(){
  
		  timeLabel.setText(ora_string+":"+perc_string+":"+masodperc_string);
		  timeLabel.setBounds(50,30,300,100);
		  timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
		  timeLabel.setForeground(Color.RED);
		  timeLabel.setBackground(Color.CYAN);
		  timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		  timeLabel.setOpaque(true);
		  timeLabel.setHorizontalAlignment(JTextField.CENTER);
		  
		  cimke.setText(oraCimke +" : "+ percCimke+" : " + mpercCimke);
		  cimke.setBounds(50,5,300,20);
		  cimke.setFont(new Font("Verdana",Font.PLAIN,15));
		 
		  cimke.setHorizontalAlignment(JTextField.CENTER);
		  
		  startGomb.setBounds(100,140,100,50);
		  startGomb.setFont(new Font("Arial",Font.PLAIN,20));
		  startGomb.setFocusable(false);
		  startGomb.addActionListener(this);
		  
		  resetGomb.setBounds(200,140,100,50);
		  resetGomb.setFont(new Font("Arial",Font.PLAIN,20));
		  resetGomb.setFocusable(false);
		  resetGomb.addActionListener(this);
		  
		  frame.add(startGomb);
		  frame.add(resetGomb);
		  frame.add(timeLabel);
		  frame.add(cimke);
		  
		  frame.setTitle("Bazsi Pallas STOPPER");
		  frame.setLocationRelativeTo(null);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setSize(getAblakSzeles(), getAblakMagas());		
		  frame.setLayout(null);
		  frame.setVisible(isLatszik());
	}
 
 @Override
 public void actionPerformed(ActionEvent e) {
  try {
	  if(e.getSource()==startGomb) {
	   
		   if(!futAzOra) {
		    futAzOra=true;
		    startGomb.setText("PAUSE");
		    start();
		   }
		   else {
		    futAzOra=false;
		    startGomb.setText("START");
		    stop();
		   }
		   
	  }
	  
	  if(e.getSource()==resetGomb) {
		   futAzOra=false;
		   startGomb.setText("START");
		   reset();
	  }
  }catch (Exception error) {
	  frame.setTitle("ERROR ERROR ERROR" + error);
  }
	  
 }
 
 	void start() {
 		timer.start();
 	}
 
 	void stop() {
 		timer.stop();
 	}
 
 	void reset() {
	  timer.stop();
	  elteltIdo = 0;
	  masodperc = 0;
	  perc = 0;
	  ora = 0;
	  
	  masodperc_string = String.format("%02d", masodperc);
	  perc_string = String.format("%02d", perc);
	  ora_string = String.format("%02d", ora);       
	  timeLabel.setText(ora_string+":"+perc_string+":"+masodperc_string);
	}
}