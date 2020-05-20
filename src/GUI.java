import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
/*
import OyunOved.GUI.Board;
import OyunOved1.GUI.Click;
import Oyun.GUI.Move;
*/


public class GUI extends JFrame {


	
	
	
         
	
	
	public boolean resetter= false;
	
	Date zaman =new Date();
	Date SonZaman;
	
	int spacing=2;
	
	int neighs=0;
	
	String Zafermesaji="henüz yetmaz !";
	
	public int mx=-100;
	public int my=-100;
	
	public  int EmojiX = 488;
	public int EmojiY = 5;
	public boolean mutlu = true;
	
	public int EmojiRestX=EmojiX+27;
	public int EmojiRestY=EmojiY+50;
	
	
	public  int zamanX = 900;
	public int zamanY = 5;
	public int saniye =0;
	
	
	public int zafermesajiX=560;
	public int zafermesajiY=-50;
	
	
	public  int bayrakX = 350;
	public int bayrakY = 5;
	
	
	public int BayrakMerkezX=bayrakX+30 ;
	public int BayrakMerkezY=bayrakY+65 ;
	
	public boolean bayrak=false;

	
	
	
	
	public boolean yenilgi = false;
	public boolean zafer =false;
	
	
	
	Random rand=new Random();
	int [][]mines =new int[17][9];
	int [][]neighbours=new int [17][9];
	boolean [][] revealed=new boolean [17][9];
	boolean [][] flagged=new boolean[17][9];
	
	public GUI() {
		

		
		
		
		
		
	this.setTitle("my first game in java");
	this.setSize(1026, 625);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	this.setResizable(false);
	Board board=new Board();
	this.setContentPane(board);
	
//----------------------------------------------------------------------------------
	JMenu menu, submenu;  
    JMenuItem i1, i2, i3, i4, i5;  
   
    JMenuBar mb=new JMenuBar();
	menu=new JMenu("Ayarlar");  
    submenu=new JMenu("Sub Menu");  
    i1=new JMenuItem("anas");  
    i2=new JMenuItem("Item 2");  
    i3=new JMenuItem("Item 3");  
    i4=new JMenuItem("Item 4");  
    i5=new JMenuItem("Item 5");  
    menu.add(i1);
    menu.add(i2);
    menu.add(i3);  
    submenu.add(i4);
    submenu.add(i5);  
    menu.add(submenu);  
    mb.add(menu);  
    this.setJMenuBar(mb);  
    this.setLayout(null);  
    this.setVisible(true);  
   /* i1.addActionListener(this);    
    i2.addActionListener(this);    
    i3.addActionListener(this);    
    i4.addActionListener(this); 
    i5.addActionListener(this); 
    
*/
  
	
	   
    
	
	
///----------------------------------------------------------------------------
	
	
	Move move=new Move();
	this.addMouseMotionListener(move);
	Click click =new Click();
	this.addMouseListener(click);
	
	for(int i=0; i<17;i++) {
		for(int j=0; j<9;j++) {
			if(rand.nextInt(100)<20) {
			mines[i][j]=1;	
			}else {
				mines[i][j]=0;
			}
			
			revealed [i][j]=false;
		}
		
		}
	for(int i=0; i<17;i++) {
		for(int j=0; j<9;j++) {
			neighs =0;
			for(int m=0; m<17;m++) {
				for(int n=0; n<9;n++) {
					if(!(i == m && j == n)) {
	              if(isN(i,j,m,n)==true) {
	               	neighs++;
	              }
	}
				}
				
			}
			neighbours[i][j]=neighs;
		}
		
	}
	}

	
	
	
	
	
	
	
	
	public class Board extends JPanel{
		public void paintComponent(Graphics g) {
			
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0,1020,600);
		
		for(int i=0; i<17;i++) {
			for(int j=0; j<9;j++) {
				g.setColor(Color.gray);
				
				
				
				if(mx>=spacing+i*60 && mx<spacing+i*60+60-2 && my>=spacing+j*60+60+26 && my<spacing+j*60+60+85-2*spacing) {
					
					g.setColor(Color.lightGray);
				}
				if(revealed [i][j]== true) {
					g.setColor(Color.white);
					if(mines[i][j]==1) {
						g.setColor(Color.red);}
									}
	
				g.fillRect(spacing+i*60, spacing+j*60+60, 60-2*spacing, 60-2*spacing);
				if(revealed [i][j]== true) {
					g.setColor(Color.black);
					if(mines[i][j]==0 && neighbours[i][j]!=0) {
						if(neighbours[i][j]==1) {
							g.setColor(Color.blue);

						}else if(neighbours[i][j]==2) {
							g.setColor(Color.green);

						}else if(neighbours[i][j]==3) {
							g.setColor(Color.red);

						}else if(neighbours[i][j]==4) {
							g.setColor(new Color(0,0,128));

						}else if(neighbours[i][j]==5) {
							g.setColor(new Color(178,34,34));

						}else if(neighbours[i][j]==6) {
							g.setColor(new Color(72,209,204));

						}else if(neighbours[i][j]==7) {
							g.setColor(Color.black);

						}
					g.setFont(new Font("Tahoma" , Font.BOLD , 30));
                    g.drawString(Integer.toString(neighbours[i][j]),i*60+20, j*60+100);
				}else if(mines[i][j]==1) {
					g.fillRect(i*60+25, j*60+60+15, 10, 30);
					g.fillRect(i*60+15, j*60+60+25, 30, 10);
					g.fillRect(i*60+20, j*60+60+20, 20, 20);
					g.fillRect(i*60+29, j*60+60+10, 2, 40);
					g.fillRect(i*60+10, j*60+60+29, 40, 2);
				}
				}
				if(flagged[i][j] == true) {
				
				g.setColor(Color.black);
				g.fillRect(i*60+13, j*60+60+8, 13, 13);
				g.fillRect(i*60+25, j*60+60+8, 3, 30);
				g.fillRect(i*60+19, j*60+60+39, 14, 5);
				g.fillRect(i*60+16, j*60+60+43, 20, 8);
				g.setColor(Color.red);
				g.fillRect(i*60+15, j*60+60+10, 8, 8);
				
				}
				}
		}
		
		
	
		
//---------------------------------ayarlar için-------------------------------------
		class MenuBar {
			  
	          JMenu menu, submenu;  
	          JMenuItem i1, i2, i3, i4, i5;  
	          MenuBar(){  
	          JMenuBar mb=new JMenuBar();  
	          menu=new JMenu("Menu");  
	          submenu=new JMenu("Sub Menu");  
	          i1=new JMenuItem("Item 1");  
	          i2=new JMenuItem("Item 2");  
	          i3=new JMenuItem("Item 3");  
	          i4=new JMenuItem("Item 4");  
	          i5=new JMenuItem("Item 5");  
	          menu.add(i1);
	          menu.add(i2);
	          menu.add(i3);  
	          submenu.add(i4);
	          submenu.add(i5);  
	          menu.add(submenu);  
	          mb.add(menu); 
	       
	}
	
	       /*
	          public void actionPerformed(final ActionEvent e) {
	        	  
	        	  i1.addActionListener((ActionListener) this);    
	        	   
	        	  
	          	if(e.getSource()==i1) {
	          		
	          		
	          		restAll();
	          	}
	          	
	          	
	          	// TODO Auto-generated method stub

	          } 
	          	
		*/
		
		
    	   
		}
		
		
		
//emoji için ................................................
		
		g.setColor(Color.yellow);
		g.fillOval(EmojiX, EmojiY, 50, 50);
		g.setColor(Color.black);
		g.fillOval(EmojiX+12, EmojiY+12, 10, 10);
		g.fillOval(EmojiX+30 , EmojiY+12, 10, 10);
		if(mutlu==true) {
			g.fillRect(EmojiX+17, EmojiY+36, 18, 3);
			g.fillRect(EmojiX+14, EmojiY+33, 4, 4);
			g.fillRect(EmojiX+35, EmojiY+33, 4, 4);

		}else {
			g.fillRect(EmojiX+17, EmojiY+33, 18, 3);
			g.fillRect(EmojiX+14, EmojiY+35, 4, 4);
			g.fillRect(EmojiX+35, EmojiY+35, 4, 4);
		}

		
		
		
//bayrak için..............................................
		g.setColor(Color.black);
		g.fillRect(bayrakX+13, bayrakY+8, 13, 13);
		g.fillRect(bayrakX+25, bayrakY+8, 3, 30);
		g.fillRect(bayrakX+19, bayrakY+39, 14, 5);
		g.fillRect(bayrakX+16, bayrakY+43, 20, 8);
		
		if(bayrak==true) {
			g.setColor(Color.red);
		}
		g.drawOval(bayrakX-5, bayrakY, 60, 55);
		g.drawOval(bayrakX-4, bayrakY+1, 58, 53);
		g.drawOval(bayrakX-3, bayrakY+2, 56, 51);
		
		
		g.setColor(Color.red);
		g.fillRect(bayrakX+15, bayrakY+10, 8, 8);
   
		

		
		
		
		
		
//zaman için................................................
		
		g.setColor(Color.black);
		g.fillRect(zamanX, zamanY, 118, 52);
		if(zafer==false && yenilgi==false) {
		
		saniye =((int)(new Date().getTime()-zaman.getTime())/1000);
		}
		if(saniye>999) {saniye = 999;}
		//System.out.println(saniye);
		
		g.setColor(Color.white);
		if(zafer==true) {
		g.setColor(Color.green);
		}else if(yenilgi==true) {
			g.setColor(Color.red);

		}
		
		g.setFont(new Font("Tahoma" , Font.BOLD , 50));
		if(saniye<10) {
		g.drawString("00"+Integer.toString(saniye),zamanX+10, zamanY+45);
		}
		
		if(saniye>=10 && saniye <100) {
			g.drawString("0"+Integer.toString(saniye),zamanX+10, zamanY+45);
			}
		if(saniye>=100) {
			g.drawString(Integer.toString(saniye),zamanX+10, zamanY+45);
			}
		
		
		
		
		
//mesaj için ...................................................
		
		if(zafer == true ) {
			g.setColor(Color.green);
			Zafermesaji="kazandınnız..";
			
		}else if(yenilgi == true) {
			
			g.setColor(Color.red);
			Zafermesaji="Kaybettınız..";
		}
		
		if(zafer==true || yenilgi == true) {
			
			zafermesajiY= -50 +(int)(new Date().getTime() - SonZaman.getTime())/10;
			if(zafermesajiY>45) {
				zafermesajiY=45;
				}
		
			g.drawString(Zafermesaji,zafermesajiX,zafermesajiY);
			
		}
		
		}
	    }
	
	
	
	
	
	
	
	
	
	
	
	public class Move implements MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent arg0) {

		}

		@Override
		public void mouseMoved(MouseEvent e) {
			mx= e.getX();
			my= e.getY();
			/*System.out.println("the mouse was moved");
			
			System.out.println("X "+ mx+" , "+ "Y "+ my);
			*/
		}
		
		
	}
	
	public class Click implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			
			mx= e.getX();
			my= e.getY();
			
				
        if(inBoxX() != -1 && inBoxY()!= -1) {
        
        	//  System.out.println("the mouse is in the ["+ inBoxX()+","+ inBoxY()+"], Number of mine neighs: "+ neighbours[inBoxX()][inBoxY()]);
          if(bayrak ==true && revealed[inBoxX()][inBoxY()]== false)  {
        	if(flagged[inBoxX()][inBoxY()]==false) {
        		flagged[inBoxX()][inBoxY()]=true;
        		
        	}else {
        		flagged[inBoxX()][inBoxY()]=false;
        	}
        }
        	
           else { if(flagged[inBoxX()][inBoxY()]==false) {
    		     revealed[inBoxX()][inBoxY()]= true;
        	}
        }
        }
        
        
        if(inEmoji()==true) {
        	restAll();
        	System.out.println("emoji is true");
        }
        
        
      if(inBayrak ()==true){
        	if(bayrak==false) {
        	bayrak =true;
        	
        	}else {
        		
        		bayrak =false;
        	}
        }        
        
 
      
		}

//-------------------------ayarlar-----------------------------------
		
		/*
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()== anas) {
				
				
				System.out.println("alhamdullah ");
			}
			
		}
*///--------------------------------------------------------------------------------
		
		
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		
	}
	
	
	public void ZaferDurumu() {
		
		if ( yenilgi == false) {
			for(int i=0; i<17;i++) {
			
				for(int j=0; j<9;j++) {
					if(revealed[i][j]==true && mines[i][j]==1) {
					mutlu=false;
					yenilgi=true;
					SonZaman= new Date();
					}
					}
				}
		}
		if(ToplamBoxRevealed()>= 153- MinesToplam() && zafer==false) {
			
			zafer=true;
			SonZaman= new Date();

			
		}
	}
	
	public int MinesToplam() {
		int toplam=0;
		for(int i=0; i<17;i++) {
			
			for(int j=0; j<9;j++) {
				if(mines[i][j]==1) {
					toplam++;	
				}
			}
			}
		return toplam;
	}
	
	public int ToplamBoxRevealed() {
		int toplam=0;
		for(int i=0; i<17;i++) {
			
			for(int j=0; j<9;j++) {
				if(revealed[i][j]==true) {
					toplam++;	
				}
			}
			}
		return toplam;
	}
	
	
	
	
	
	
	public void restAll() {
		
		mutlu=true;
		yenilgi=false;
		zafer=false;
		
		bayrak=false;
		
	
		
		zafermesajiY=-50;
		zaman =new Date();
		
		
		for(int i=0; i<17;i++) {
			for(int j=0; j<9;j++) {
				if(rand.nextInt(100)<20) {
				mines[i][j]=1;	
				}else {
					mines[i][j]=0;
				}
				
				revealed [i][j]=false;
				flagged[i][j]=false;
			}
			
			}
		for(int i=0; i<17;i++) {
			for(int j=0; j<9;j++) {
				neighs =0;
				for(int m=0; m<17;m++) {
					for(int n=0; n<9;n++) {
						if(!(i == m && j == n)) {
		              if(isN(i,j,m,n)==true) {
		               	neighs++;
		              }
		}
					}
				}
				}
			}
	}
	
	
	
	public boolean inEmoji() {
		
		int r = (int)Math.sqrt ((mx-EmojiRestX)*(mx-EmojiRestX)+(my-EmojiRestY)*(my-EmojiRestY));
		if(r < 25) {
			return true;
		}
		
		return false;
	}
	
	
	
	
	
   public boolean inBayrak() {
		
		int r = (int)Math.sqrt ((mx-BayrakMerkezX)*(mx-BayrakMerkezX)+(my-BayrakMerkezY)*(BayrakMerkezY));
		if(r < 25) {
			return true;
		}
		
		return false;
     	}
	
   
   
	
	
	
	
	
	public int inBoxX() {
		for(int i=0; i<17;i++) {
			for(int j=0; j<9;j++) {
				if(mx>=spacing+i*60 && mx<spacing+i*60+60-2 && my>=spacing+j*60+60+26 && my<spacing+j*60+60+85-2*spacing) {
                    return i;
                 }	
				}
				}
		return(-1);
	}
public int inBoxY() {
	for(int i=0; i<17;i++) {
		for(int j=0; j<9;j++) {
		    if(mx>=spacing+i*60 && mx<spacing+i*60+60-2 && my>=spacing+j*60+60+26 && my<spacing+j*60+60+85-2*spacing) {
              return j;
		    }
			}
			}
	return(-1);
	
	}
	


public boolean isN(int mx ,int my, int cx, int cy) {
	
	if(mx-cx<2 && mx-cx>-2 && my-cy <2 && my - cy>-2 && mines[cx][cy]==1) {
		return (true);
		
	}
	return(false);
		
}



	}

