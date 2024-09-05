/**
 * @author NITYA GAUTAM
 * @Date: 09/03/2015
 * @Name: TIC TAC TOE
 */
//import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;


public class TicTacToe extends JFrame implements ActionListener{
    
   static JFrame frame;
   static JPanel panel, panel_banner, panel_cmds, title_banner;
   static JLabel ltitle, player_1, player_2, ltotal;
   static JTextField tf1, tf2, tf3;
   static JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b_restart,b_help;
   static int result_player1, result_player2, total, pressed_cnt;
   static String symbol_player1, symbol_player2;
   
   static String turn, symbol, msg, won_symbol;
   static String cmd1, cmd2,cmd3, cmd4, cmd5, cmd6, cmd7, cmd8, cmd9;
   
   static long time_s, time_e;
   //Constructor.
   TicTacToe(){
        time_s=System.currentTimeMillis();
       //variables
         total=pressed_cnt=0;
         turn ="player1"; 
         won_symbol="";
       //default player turn
         symbol_player1=symbol_player2=""; //default symbol
         result_player1=result_player2=0;  //default score
         
       //setting up labels.
         ltitle= new JLabel("TIC TAC TOE");
         ltitle.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 48));
         player_1= new JLabel("Current Turn : ");
         player_2= new JLabel(": ");
         ltotal=new JLabel("Game Count: ");
         
       //setting up text fields
         tf1=new JTextField("Player1",10);
         tf1.setEditable(false);
         tf2=new JTextField("",10);
         tf2.setEditable(false);
         tf3=new JTextField("0",10);
         tf3.setEditable(false);
         
       //setting up buttons.
         b1=new JButton("-"); b2=new JButton("--"); b3=new JButton("---");
         b4=new JButton("----"); b5=new JButton("-----"); b6=new JButton("------");
         b7=new JButton("-------"); b8=new JButton("--------"); b9=new JButton("---------");
        //setting button background color
         b1.setBackground(java.awt.Color.WHITE);  b2.setBackground(java.awt.Color.WHITE);  b3.setBackground(java.awt.Color.WHITE);
         b4.setBackground(java.awt.Color.WHITE);  b5.setBackground(java.awt.Color.WHITE);  b6.setBackground(java.awt.Color.WHITE);
         b7.setBackground(java.awt.Color.WHITE);  b8.setBackground(java.awt.Color.WHITE);  b9.setBackground(java.awt.Color.WHITE);         
         
         b_restart = new JButton("START AGAIN");
         b_help=new JButton("HELP/ABOUT");
       //setting up panel.
         //panel for banner.
           panel_banner = new JPanel();
           panel_banner.setBackground(Color.lightGray);
           panel_banner.setLayout(new java.awt.GridLayout(3,2));
                                 
           panel_banner.add(player_1);
           panel_banner.add(tf1);
           //panel_banner.add(player_2);
           //panel_banner.add(tf2);
           panel_banner.add(ltotal);
           panel_banner.add(tf3);
           
           panel_banner.add(b_restart);
           panel_banner.add(b_help);
           
         //Title panner, seperate pannal for second part in main window
           title_banner = new JPanel();
           title_banner.setLayout(new java.awt.GridLayout(2,1));
           title_banner.add(ltitle);
           title_banner.add(panel_banner);
         //panel for buttons
           panel=new JPanel();
           panel.setLayout(new java.awt.GridLayout(3,3));
           panel.add(b1); panel.add(b2); panel.add(b3);
           panel.add(b4); panel.add(b5); panel.add(b6);
           panel.add(b7); panel.add(b8); panel.add(b9);
         //panel for commands and results
           panel_cmds= new JPanel();
           //panel_cmds.setLayout(new java.awt.GridLayout(4,1));
           //panel_cmds.add(ltitle);
           panel_cmds.add(title_banner);


       //Seeting up frame.
         frame = new JFrame("GAME: TIC TAC TOE [NNG] <BETA>");
         frame.setSize(650, 300);
         frame.setResizable(false);
        
         frame.setLayout(new java.awt.GridLayout(1,2));
         frame.setAlwaysOnTop(true);
         frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
         frame.setVisible(true);
         
       //adding components.
         //frame.add(panel_banner);
         //frame.add(ltitle);
         frame.add(panel);
         frame.add(panel_cmds);
       
       //welcome message
         JOptionPane.showMessageDialog(frame, "WELCOME TO THIS GAME", "WELCOME", JOptionPane.INFORMATION_MESSAGE);
         
       //registering action listener
         b_help.addActionListener(this);
         b_restart.addActionListener(this);
         
         b1.addActionListener(this); b2.addActionListener(this); b3.addActionListener(this);
         b4.addActionListener(this); b5.addActionListener(this); b6.addActionListener(this);
         b7.addActionListener(this); b8.addActionListener(this); b9.addActionListener(this);
   }//end of construtor.
   
   //Destructor
   @Override
   public void finalize(){
       time_e=System.currentTimeMillis();
       
       if((time_e-time_s)>100){
           JOptionPane.showMessageDialog(null,"Looks like, you spent time with this game. we appriciate it.","Exit",JOptionPane.INFORMATION_MESSAGE);
       }
   }
  
   public static void updateResult(){
         //JOptionPane.showMessageDialog(panel_banner, "Updating result", "TIC TAC TOE", JOptionPane.INFORMATION_MESSAGE);
         tf1.setText(String.valueOf(result_player1));
         tf2.setText(String.valueOf(result_player2));
         
   }
  
   public static void resetAll(){
       b1.setText("-"); b1.setEnabled(true); b1.setBackground(java.awt.Color.WHITE);
       b2.setText("--"); b2.setEnabled(true); b2.setBackground(java.awt.Color.WHITE);
       b3.setText("---"); b3.setEnabled(true); b3.setBackground(java.awt.Color.WHITE);
       b4.setText("----"); b4.setEnabled(true); b4.setBackground(java.awt.Color.WHITE);
       b5.setText("-----"); b5.setEnabled(true); b5.setBackground(java.awt.Color.WHITE);
       b6.setText("------"); b6.setEnabled(true); b6.setBackground(java.awt.Color.WHITE);
       b7.setText("-------"); b7.setEnabled(true); b7.setBackground(java.awt.Color.WHITE);
       b8.setText("--------"); b8.setEnabled(true); b8.setBackground(java.awt.Color.WHITE);
       b9.setText("---------"); b9.setEnabled(true); b9.setBackground(java.awt.Color.WHITE);
       
       result_player1=result_player2=0;
       turn="player1";
       won_symbol="";
       pressed_cnt=0;
       tf1.setText(turn);
       tf3.setText(String.valueOf(total));
   }
   
   public static void gameOver(String symbol_won){
       if(symbol_won.equals("O")){
           msg="Player 1 Won";
           JOptionPane.showMessageDialog(frame,msg, "Game Over", JOptionPane.INFORMATION_MESSAGE);
       }
       else if(symbol_won.equals("X")){
           msg="Player 2 Won";
           JOptionPane.showMessageDialog(frame,msg, "Game Over", JOptionPane.INFORMATION_MESSAGE);
       }
       else{
           msg="Nobody won!, Better luck next time.";
           JOptionPane.showMessageDialog(panel_banner, msg, "Game Over", JOptionPane.INFORMATION_MESSAGE);
       }
       symbol="X";  total++;
       resetAll();
   }
   /**
    * 
    * @param index
    */
    public static void isAvilable(int index){
       
       if(index==1){
           //cmd1.equals("X"); cmd2.equals("X"); cmd3.equals("X");
                   
                   if((cmd1.equals("X") && cmd2.equals("X") && cmd3.equals("X")) || (cmd1.equals("O") && cmd2.equals("O") && cmd3.equals("O")) ){
                        //avil=true;
                        b1.setBackground(java.awt.Color.yellow);
                        b2.setBackground(java.awt.Color.yellow);
                        b3.setBackground(java.awt.Color.yellow);
                        won_symbol=symbol;
                        //gameOver(won_symbol);
                        msg=won_symbol.equalsIgnoreCase("X")?"Player 1 won":"Player 2 won";
                        JOptionPane.showMessageDialog(frame,msg+" \n\n We are going to reset now.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        symbol="X";  total++;
                        resetAll();
                    }
                    else if((cmd1.equals("X") && cmd4.equals("X") && cmd7.equals("X")) || (cmd1.equals("O") && cmd4.equals("O") && cmd7.equals("O"))){
                        b1.setBackground(java.awt.Color.yellow);
                        b4.setBackground(java.awt.Color.yellow);
                        b7.setBackground(java.awt.Color.yellow);
                        won_symbol=symbol;
                        //gameOver(won_symbol);
                        msg=won_symbol.equalsIgnoreCase("X")?"Player 1 won":"Player 2 won";
                        JOptionPane.showMessageDialog(frame,msg+" \n\n We are going to reset now.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        symbol="X";  total++;
                        resetAll();
                        
                    }
                    else if((cmd1.equals("X") && cmd5.equals("X") && cmd9.equals("X")) || (cmd1.equals("O") && cmd5.equals("O") && cmd9.equals("O"))){
                        b1.setBackground(java.awt.Color.yellow);
                        b5.setBackground(java.awt.Color.yellow);
                        b9.setBackground(java.awt.Color.yellow);
                        won_symbol=symbol;
                        //gameOver(won_symbol);
                        msg=won_symbol.equalsIgnoreCase("X")?"Player 1 won":"Player 2 won";
                        JOptionPane.showMessageDialog(frame,msg+" \n\n We are going to reset now.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        symbol="X";  total++;
                        resetAll();               
                    }
                    else if(pressed_cnt==9){
                        won_symbol="";
                        gameOver(won_symbol);
                    }
       }
       if(index==2){
           //cmd1.equals("X"); cmd2.equals("X"); cmd3.equals("X");
            //JOptionPane.showMessageDialog(panel_banner, "Under isavilable, cmd1="+cmd1+", cmd2="+cmd2+", cmd3"+cmd3, "Testing...", JOptionPane.INFORMATION_MESSAGE);   
                   
                   if((cmd1.equals("X") && cmd2.equals("X") && cmd3.equals("X")) || (cmd1.equals("O") && cmd2.equals("O") && cmd3.equals("O")) ){
                        //avil=true;
                        b1.setBackground(java.awt.Color.yellow);
                        b2.setBackground(java.awt.Color.yellow);
                        b3.setBackground(java.awt.Color.yellow);
                        won_symbol=symbol;
                        //gameOver(won_symbol);
                        msg=won_symbol.equalsIgnoreCase("X")?"Player 1 won":"Player 2 won";
                        JOptionPane.showMessageDialog(frame,msg+" \n\n We are going to reset now.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        symbol="X";  total++;
                        resetAll();
                    }
                    else if((cmd2.equals("X") && cmd5.equals("X") && cmd8.equals("X")) || (cmd2.equals("O") && cmd5.equals("O") && cmd8.equals("O"))){
                        b2.setBackground(java.awt.Color.yellow);
                        b5.setBackground(java.awt.Color.yellow);
                        b8.setBackground(java.awt.Color.yellow); 
                        won_symbol=symbol;
                        //gameOver(won_symbol);
                        msg=won_symbol.equalsIgnoreCase("X")?"Player 1 won":"Player 2 won";
                        JOptionPane.showMessageDialog(frame,msg+" \n\n We are going to reset now.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        symbol="X";  total++;
                        resetAll();
                    }
                    else if(pressed_cnt==9){
                        won_symbol="";
                        gameOver(won_symbol);
                    }
       }
       if(index==3){
           //cmd1.equals("X"); cmd2.equals("X"); cmd3.equals("X");
            //JOptionPane.showMessageDialog(panel_banner, "Under isavilable, cmd1="+cmd1+", cmd2="+cmd2+", cmd3"+cmd3, "Testing...", JOptionPane.INFORMATION_MESSAGE);   
                   
                   if((cmd1.equals("X") && cmd2.equals("X") && cmd3.equals("X")) || (cmd1.equals("O") && cmd2.equals("O") && cmd3.equals("O")) ){
                        //avil=true;
                        b1.setBackground(java.awt.Color.yellow);
                        b2.setBackground(java.awt.Color.yellow);
                        b3.setBackground(java.awt.Color.yellow);
                        won_symbol=symbol;
                        //gameOver(won_symbol);
                        msg=won_symbol.equalsIgnoreCase("X")?"Player 1 won":"Player 2 won";
                        JOptionPane.showMessageDialog(frame,msg+" \n\n We are going to reset now.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        symbol="X";  total++;
                        resetAll();
                    }
                    else if((cmd3.equals("X") && cmd6.equals("X") && cmd9.equals("X")) || (cmd3.equals("O") && cmd6.equals("O") && cmd9.equals("O"))){
                        b3.setBackground(java.awt.Color.yellow);
                        b6.setBackground(java.awt.Color.yellow);
                        b9.setBackground(java.awt.Color.yellow); 
                        won_symbol=symbol;
                        //gameOver(won_symbol);
                        msg=won_symbol.equalsIgnoreCase("X")?"Player 1 won":"Player 2 won";
                        JOptionPane.showMessageDialog(frame,msg+" \n\n We are going to reset now.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        symbol="X";  total++;
                        resetAll();
                    }
                    else if((cmd3.equals("X") && cmd5.equals("X") && cmd7.equals("X")) || (cmd3.equals("O") && cmd5.equals("O") && cmd7.equals("O"))){
                        b3.setBackground(java.awt.Color.yellow);
                        b5.setBackground(java.awt.Color.yellow);
                        b7.setBackground(java.awt.Color.yellow); 
                        won_symbol=symbol;
                        //gameOver(won_symbol);
                        msg=won_symbol.equalsIgnoreCase("X")?"Player 1 won":"Player 2 won";
                        JOptionPane.showMessageDialog(frame,msg+" \n\n We are going to reset now.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        symbol="X";  total++;
                        resetAll();
                    }
                    else if(pressed_cnt==9){
                        won_symbol="";
                        gameOver(won_symbol);
                    }
       }
       if(index==4){
           //cmd1.equals("X"); cmd2.equals("X"); cmd3.equals("X");
            //JOptionPane.showMessageDialog(panel_banner, "Under isavilable, cmd1="+cmd1+", cmd2="+cmd2+", cmd3"+cmd3, "Testing...", JOptionPane.INFORMATION_MESSAGE);   
                   
                   if((cmd1.equals("X") && cmd4.equals("X") && cmd7.equals("X")) || (cmd1.equals("O") && cmd4.equals("O") && cmd7.equals("O")) ){
                        //avil=true;
                        b1.setBackground(java.awt.Color.yellow);
                        b4.setBackground(java.awt.Color.yellow);
                        b7.setBackground(java.awt.Color.yellow);
                        won_symbol=symbol;
                        //gameOver(won_symbol);
                        msg=won_symbol.equalsIgnoreCase("X")?"Player 1 won":"Player 2 won";
                        JOptionPane.showMessageDialog(frame,msg+" \n\n We are going to reset now.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        symbol="X";  total++;
                        resetAll();
                    }
                    else if((cmd4.equals("X") && cmd5.equals("X") && cmd6.equals("X")) || (cmd4.equals("O") && cmd5.equals("O") && cmd6.equals("O"))){
                        b4.setBackground(java.awt.Color.yellow);
                        b5.setBackground(java.awt.Color.yellow);
                        b6.setBackground(java.awt.Color.yellow); 
                        won_symbol=symbol;
                        //gameOver(won_symbol);
                        msg=won_symbol.equalsIgnoreCase("X")?"Player 1 won":"Player 2 won";
                        JOptionPane.showMessageDialog(frame,msg+" \n\n We are going to reset now.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        symbol="X";  total++;
                        resetAll();
                    }
                    else if(pressed_cnt==9){
                        won_symbol="";
                        gameOver(won_symbol);
                    }
       }       
       if(index==5){
           //cmd1.equals("X"); cmd2.equals("X"); cmd3.equals("X");
            //JOptionPane.showMessageDialog(panel_banner, "Under isavilable, cmd1="+cmd1+", cmd2="+cmd2+", cmd3"+cmd3, "Testing...", JOptionPane.INFORMATION_MESSAGE);   
                   
                   if((cmd2.equals("X") && cmd5.equals("X") && cmd8.equals("X")) || (cmd2.equals("O") && cmd5.equals("O") && cmd8.equals("O")) ){
                        //avil=true;
                        b2.setBackground(java.awt.Color.yellow);
                        b5.setBackground(java.awt.Color.yellow);
                        b8.setBackground(java.awt.Color.yellow);
                        won_symbol=symbol;
                        //gameOver(won_symbol);
                        msg=won_symbol.equalsIgnoreCase("X")?"Player 1 won":"Player 2 won";
                        JOptionPane.showMessageDialog(frame,msg+" \n\n We are going to reset now.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        symbol="X";  total++;
                        resetAll();
                    }
                    else if((cmd4.equals("X") && cmd5.equals("X") && cmd6.equals("X")) || (cmd4.equals("O") && cmd5.equals("O") && cmd6.equals("O"))){
                        b4.setBackground(java.awt.Color.yellow);
                        b5.setBackground(java.awt.Color.yellow);
                        b6.setBackground(java.awt.Color.yellow);
                        won_symbol=symbol;
                        //gameOver(won_symbol);
                        msg=won_symbol.equalsIgnoreCase("X")?"Player 1 won":"Player 2 won";
                        JOptionPane.showMessageDialog(frame,msg+" \n\n We are going to reset now.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        symbol="X";  total++;
                        resetAll();
                    }
                    else if((cmd3.equals("X") && cmd5.equals("X") && cmd7.equals("X")) || (cmd3.equals("O") && cmd5.equals("O") && cmd7.equals("O"))){
                        b3.setBackground(java.awt.Color.yellow);
                        b5.setBackground(java.awt.Color.yellow);
                        b7.setBackground(java.awt.Color.yellow); 
                        won_symbol=symbol;
                        //gameOver(won_symbol);
                        msg=won_symbol.equalsIgnoreCase("X")?"Player 1 won":"Player 2 won";
                        JOptionPane.showMessageDialog(frame,msg+" \n\n We are going to reset now.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        symbol="X";  total++;
                        resetAll();
                    }
                    else if((cmd1.equals("X") && cmd5.equals("X") && cmd9.equals("X")) || (cmd1.equals("O") && cmd5.equals("O") && cmd9.equals("O"))){
                        b1.setBackground(java.awt.Color.yellow);
                        b5.setBackground(java.awt.Color.yellow);
                        b9.setBackground(java.awt.Color.yellow);
                        won_symbol=symbol;
                        //gameOver(won_symbol);
                        msg=won_symbol.equalsIgnoreCase("X")?"Player 1 won":"Player 2 won";
                        JOptionPane.showMessageDialog(frame,msg+" \n\n We are going to reset now.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        symbol="X";  total++;
                        resetAll();
                    }
                    else if(pressed_cnt==9){
                        won_symbol="";
                        gameOver(won_symbol);
                    }
       }
       if(index==6){
           //cmd1.equals("X"); cmd2.equals("X"); cmd3.equals("X");
            //JOptionPane.showMessageDialog(panel_banner, "Under isavilable, cmd1="+cmd1+", cmd2="+cmd2+", cmd3"+cmd3, "Testing...", JOptionPane.INFORMATION_MESSAGE);   
                   
                   if((cmd3.equals("X") && cmd6.equals("X") && cmd9.equals("X")) || (cmd3.equals("O") && cmd6.equals("O") && cmd9.equals("O")) ){
                        //avil=true;
                        b3.setBackground(java.awt.Color.yellow);
                        b6.setBackground(java.awt.Color.yellow);
                        b9.setBackground(java.awt.Color.yellow);
                        won_symbol=symbol;
                        //gameOver(won_symbol);
                        msg=won_symbol.equalsIgnoreCase("X")?"Player 1 won":"Player 2 won";
                        JOptionPane.showMessageDialog(frame,msg+" \n\n We are going to reset now.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        symbol="X";  total++;
                        resetAll();
                    }
                    else if((cmd4.equals("X") && cmd5.equals("X") && cmd6.equals("X")) || (cmd4.equals("O") && cmd5.equals("O") && cmd6.equals("O"))){
                        b4.setBackground(java.awt.Color.yellow);
                        b5.setBackground(java.awt.Color.yellow);
                        b6.setBackground(java.awt.Color.yellow); 
                        won_symbol=symbol;
                        //gameOver(won_symbol);
                        msg=won_symbol.equalsIgnoreCase("X")?"Player 1 won":"Player 2 won";
                        JOptionPane.showMessageDialog(frame,msg+" \n\n We are going to reset now.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        symbol="X";  total++;
                        resetAll();
                    }
                    else if(pressed_cnt==9){
                        won_symbol="";
                        gameOver(won_symbol);
                    }
       }
       if(index==7){
           //cmd1.equals("X"); cmd2.equals("X"); cmd3.equals("X");
            //JOptionPane.showMessageDialog(panel_banner, "Under isavilable, cmd1="+cmd1+", cmd2="+cmd2+", cmd3"+cmd3, "Testing...", JOptionPane.INFORMATION_MESSAGE);   
                   
                   if((cmd1.equals("X") && cmd4.equals("X") && cmd7.equals("X")) || (cmd1.equals("O") && cmd4.equals("O") && cmd7.equals("O")) ){
                        //avil=true;
                        b1.setBackground(java.awt.Color.yellow);
                        b4.setBackground(java.awt.Color.yellow);
                        b7.setBackground(java.awt.Color.yellow);
                        won_symbol=symbol;
                        //gameOver(won_symbol);
                        msg=won_symbol.equalsIgnoreCase("X")?"Player 1 won":"Player 2 won";
                        JOptionPane.showMessageDialog(frame,msg+" \n\n We are going to reset now.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        symbol="X";  total++;
                        resetAll();
                    }
                    else if((cmd7.equals("X") && cmd8.equals("X") && cmd9.equals("X")) || (cmd7.equals("O") && cmd8.equals("O") && cmd9.equals("O"))){
                        b7.setBackground(java.awt.Color.yellow);
                        b8.setBackground(java.awt.Color.yellow);
                        b9.setBackground(java.awt.Color.yellow);     
                        won_symbol=symbol;
                        //gameOver(won_symbol);
                        msg=won_symbol.equalsIgnoreCase("X")?"Player 1 won":"Player 2 won";
                        JOptionPane.showMessageDialog(frame,msg+" \n\n We are going to reset now.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        symbol="X";  total++;
                        resetAll();
                    }
                    else if((cmd3.equals("X") && cmd5.equals("X") && cmd7.equals("X")) || (cmd3.equals("O") && cmd5.equals("O") && cmd7.equals("O"))){
                        b3.setBackground(java.awt.Color.yellow);
                        b5.setBackground(java.awt.Color.yellow);
                        b7.setBackground(java.awt.Color.yellow); 
                        won_symbol=symbol;
                        //gameOver(won_symbol);
                        msg=won_symbol.equalsIgnoreCase("X")?"Player 1 won":"Player 2 won";
                        JOptionPane.showMessageDialog(frame,msg+" \n\n We are going to reset now.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        symbol="X";  total++;
                        resetAll();
                    }
                    else if(pressed_cnt==9){
                        won_symbol="";
                        gameOver(won_symbol);
                    }
       }
       if(index==8){
           //cmd1.equals("X"); cmd2.equals("X"); cmd3.equals("X");
            //JOptionPane.showMessageDialog(panel_banner, "Under isavilable, cmd1="+cmd1+", cmd2="+cmd2+", cmd3"+cmd3, "Testing...", JOptionPane.INFORMATION_MESSAGE);   
                   
                   if((cmd2.equals("X") && cmd5.equals("X") && cmd8.equals("X")) || (cmd2.equals("O") && cmd5.equals("O") && cmd8.equals("O")) ){
                        //avil=true;
                        b2.setBackground(java.awt.Color.yellow);
                        b5.setBackground(java.awt.Color.yellow);
                        b8.setBackground(java.awt.Color.yellow);
                        won_symbol=symbol;
                        //gameOver(won_symbol);
                        msg=won_symbol.equalsIgnoreCase("X")?"Player 1 won":"Player 2 won";
                        JOptionPane.showMessageDialog(frame,msg+" \n\n We are going to reset now.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        symbol="X";  total++;
                        resetAll();
                    }
                    else if((cmd7.equals("X") && cmd8.equals("X") && cmd9.equals("X")) || (cmd7.equals("O") && cmd8.equals("O") && cmd9.equals("O"))){
                        b7.setBackground(java.awt.Color.yellow);
                        b8.setBackground(java.awt.Color.yellow);
                        b9.setBackground(java.awt.Color.yellow);   
                        won_symbol=symbol;
                        //gameOver(won_symbol);
                        msg=won_symbol.equalsIgnoreCase("X")?"Player 1 won":"Player 2 won";
                        JOptionPane.showMessageDialog(frame,msg+" \n\n We are going to reset now.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        symbol="X";  total++;
                        resetAll();
                    }
                    else if(pressed_cnt==9){
                        won_symbol="";
                        gameOver(won_symbol);
                    }
       }       
       if(index==9){
           //cmd1.equals("X"); cmd2.equals("X"); cmd3.equals("X");
            //JOptionPane.showMessageDialog(panel_banner, "Under isavilable, cmd1="+cmd1+", cmd2="+cmd2+", cmd3"+cmd3, "Testing...", JOptionPane.INFORMATION_MESSAGE);   
                   
                   if((cmd7.equals("X") && cmd8.equals("X") && cmd9.equals("X")) || (cmd7.equals("O") && cmd8.equals("O") && cmd9.equals("O")) ){
                        //avil=true;
                        b7.setBackground(java.awt.Color.yellow);
                        b8.setBackground(java.awt.Color.yellow);
                        b9.setBackground(java.awt.Color.yellow);
                        won_symbol=symbol;
                        //gameOver(won_symbol);
                        msg=won_symbol.equalsIgnoreCase("X")?"Player 1 won":"Player 2 won";
                        JOptionPane.showMessageDialog(frame,msg+" \n\n We are going to reset now.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        symbol="X";  total++;
                        resetAll();
                    }
                    else if((cmd3.equals("X") && cmd6.equals("X") && cmd9.equals("X")) || (cmd3.equals("O") && cmd6.equals("O") && cmd9.equals("O"))){
                        b3.setBackground(java.awt.Color.yellow);
                        b6.setBackground(java.awt.Color.yellow);
                        b9.setBackground(java.awt.Color.yellow); 
                        won_symbol=symbol;
                        //gameOver(won_symbol);
                        msg=won_symbol.equalsIgnoreCase("X")?"Player 1 won":"Player 2 won";
                        JOptionPane.showMessageDialog(frame,msg+" \n\n We are going to reset now.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        symbol="X";  total++;
                        resetAll();
                    }
                    else if((cmd1.equals("X") && cmd5.equals("X") && cmd9.equals("X")) || (cmd1.equals("O") && cmd5.equals("O") && cmd9.equals("O"))){
                        b1.setBackground(java.awt.Color.yellow);
                        b5.setBackground(java.awt.Color.yellow);
                        b9.setBackground(java.awt.Color.yellow); 
                        won_symbol=symbol;
                        //gameOver(won_symbol);
                        msg=won_symbol.equalsIgnoreCase("X")?"Player 1 won":"Player 2 won";
                        JOptionPane.showMessageDialog(frame,msg+" \n\n We are going to reset now.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        symbol="X";  total++;
                        resetAll();
                    }
                    else if(pressed_cnt==9){
                        won_symbol="";
                        gameOver(won_symbol);
                    }
       }       
   }
  
    //Overriding
   @Override
   public void actionPerformed(ActionEvent ae){
       int ind=0;
       tf3.setText(String.valueOf(total));
       String cmd= ae.getActionCommand();
    //getting action command of each button.
       cmd1=b1.getActionCommand(); cmd2=b2.getActionCommand(); cmd3=b3.getActionCommand();
       cmd4=b4.getActionCommand(); cmd5=b5.getActionCommand(); cmd6=b6.getActionCommand();
       cmd7=b7.getActionCommand(); cmd8=b8.getActionCommand(); cmd9=b9.getActionCommand();
    //Symbol selection.
       if(turn.equals("player1") && !(cmd.equals("HELP/ABOUT")) && !(cmd.equals("START AGAIN"))){
           symbol="X";
           turn="player2";
       }
       else if(turn.equals("player2") && !(cmd.equals("HELP/ABOUT")) && !(cmd.equals("START AGAIN"))){
           symbol="O";
           turn="player1";
       }
       //Echoing turn on textfield1
          tf1.setText("Now: "+turn);
    //according to buuton.   
       if(cmd.equals("HELP/ABOUT")){
           msg="\tTIC TAC TOE PROGRAM \n"+
               "/^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\\\n"+
               "|    Its a double player game. \n"+
               "| Default Symbol:              \n"+
               "| Player 1= X                  \n"+
               "| Player 2= O                  \n"+
               "\\____________________________\n"+
               " _______\n"+
               "| Details: \\\n"+
               "|^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n"+
               "| Developer  : ASHUTOSH MISHRA[BIT MESRA(MCA/10050/2013)]    \n"+
               "| Date       : 08-03-2015                                    \n"+
               "| Tools      : javax,awt                                     \n"+
               "\\_________________________________________________________\n";
           JOptionPane.showMessageDialog(panel_banner, msg, "HELP", JOptionPane.INFORMATION_MESSAGE); 
           //result_player1++;
       }//for help button.
       
       if(cmd.equals("START AGAIN")){
           int status;
           status=JOptionPane.showConfirmDialog(panel_banner, "ARE YOU SURE", "RESTART", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
           if(status==0){
               resetAll();
           }
           else{
               JOptionPane.showMessageDialog(panel_banner, "You may continue...", "TIC TAC TOE", JOptionPane.INFORMATION_MESSAGE);
           }
       }//for restart button.
       
       if(cmd.equals("-")){
            b1.setText(symbol);
            b1.setEnabled(false);
            cmd1=b1.getActionCommand();
            ind=1;
            //Counting pressed button
              pressed_cnt++;
       }
       else if(cmd.equals("--")){
           b2.setText(symbol);
           b2.setEnabled(false);
           cmd2=b2.getActionCommand();
           ind=2;
           //Counting pressed button
             pressed_cnt++;
       }
       else if(cmd.equals("---")){
           b3.setText(symbol);
           b3.setEnabled(false);
           cmd3=b3.getActionCommand();
           ind=3;
           //Counting pressed button
             pressed_cnt++;
       }
       else if(cmd.equals("----")){
           b4.setText(symbol);
           b4.setEnabled(false);
           cmd4=b4.getActionCommand();
           ind=4;
           //Counting pressed button
             pressed_cnt++;
       }
       else if(cmd.equals("-----")){
           b5.setText(symbol);
           b5.setEnabled(false);
           cmd5=b5.getActionCommand();
           ind=5;
           //Counting pressed button
             pressed_cnt++;
       }
       else if(cmd.equals("------")){
           b6.setText(symbol);
           b6.setEnabled(false);
           cmd6=b6.getActionCommand();
           ind=6;
           //Counting pressed button
             pressed_cnt++;
       }
       else if(cmd.equals("-------")){
           b7.setText(symbol);
           b7.setEnabled(false);
           cmd7=b7.getActionCommand();
           ind=7;
           //Counting pressed button
             pressed_cnt++;
       }
       else if(cmd.equals("--------")){
           b8.setText(symbol);
           b8.setEnabled(false);
           cmd8=b8.getActionCommand();
           ind=8;
           //Counting pressed button
             pressed_cnt++;
       }
       else if(cmd.equals("---------")){
           b9.setText(symbol);
           b9.setEnabled(false);
           cmd9=b9.getActionCommand();
           ind=9;
           //Counting pressed button
             pressed_cnt++;
       }
       isAvilable(ind);
       if(pressed_cnt==9){
           //gameOver(symbol);
       }
     //logic after pressing any key during game.
         
         //cmd=String.valueOf(ae.getSource());
         //JOptionPane.showMessageDialog(panel_banner, "getSource(): "+cmd, "TIC TAC TOE", JOptionPane.INFORMATION_MESSAGE);
         //cmd=String.valueOf(ae.getID());
         //JOptionPane.showMessageDialog(panel_banner, "GetID(): "+cmd, "TIC TAC TOE", JOptionPane.INFORMATION_MESSAGE);
         //cmd=ae.paramString();
         //JOptionPane.showMessageDialog(panel_banner, "GetParam(): "+cmd, "TIC TAC TOE", JOptionPane.INFORMATION_MESSAGE);
    
     //updateResult(); 
         
   }//end of override function actionPerformed.
   
   public static void main(String arg[]) throws Exception{
       TicTacToe t1;
       t1=new TicTacToe();
       
       //t1.finalize();
   }
}
