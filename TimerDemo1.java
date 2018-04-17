import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TimerDemo1 extends JFrame implements KeyListener
{
   private Timer enemy1Timer;
   private Timer enemy2Timer;
   private Timer enemy3Timer;
   private Timer enemy4Timer;
   private Timer enemy5Timer;           
   private Timer playerTimer;       
   private Timer timerBullet;
          
   private int playerX; //don't need a Y - player moves horizontally only.
                
   private int enemy1X;
   private int enemy2X;
   private int enemy3X;
   private int enemy4X;
   private int enemy5X;
   
   private int enemy1Y;
   private int enemy2Y;
   private int enemy3Y;
   private int enemy4Y;
   private int enemy5Y;
                 
   private int bulletY;             
   private int bulletX;
                
   private int enemyMoveAmount;        
   private int playerMoveAmount;       
   private int bulletMoveAmount;
       
   private int playerScore;         
   private final static int SCREEN_WIDTH = 300;   
   
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
     
   public TimerDemo1()             
   {
      playerX = SCREEN_WIDTH / 2 - 10; //10 subtracted to compensate for player width (20).                             
      enemy1X = 60;                      
         enemy1MoveAmount = 5;  
      playerMoveAmount = 6;
      
      bulletMoveAmount = 10;    
      bullet1X = -10;                    bullet1Y = 180;
      
      
      
      
      
      addKeyListener(this);         // necessary to make the KeyListener work correctly
      
      
      
      
     
   
      enemyTimer = new Timer(100, new ActionListener()
      {

         public void actionPerformed(ActionEvent evt)
         {

            if (enemyX <= 0)            
            {
               enemyMoveAmount = 5;
            }
            else if (enemyX >= SCREEN_WIDTH - 20)
            {
               enemyMoveAmount = -5;
            }
             
            enemyX += enemyMoveAmount;
            repaint();
         }

      });
      
      
      enemyTimer2 = new Timer(100, new ActionListener()
      {

         public void actionPerformed(ActionEvent evt)
         {

            if (enemy2X <= 0)                 
            {
               enemy2MoveAmount = 5;
            }
            else if (enemy2X >= SCREEN_WIDTH - 20) 
            {
               enemy2MoveAmount = -5;
            }
             
            enemyX += enemyMoveAmount;       
            repaint();
         }

      });
              
      
      
      playerTimer = new Timer(100, new ActionListener()
      {

         public void actionPerformed(ActionEvent evt)
         {

            if (playerX <= 0)                   
            {
               playerMoveAmount = 6;
            }
            else if (playerX >= SCREEN_WIDTH - 20)   
            {
               playerMoveAmount = -6;
            }
             
            playerX += playerMoveAmount;        
            repaint();
         }

      });  
       
      
      timerBullet = new Timer(50, new ActionListener()
      {

         public void actionPerformed(ActionEvent evt)
         {            
            bulletY -= bulletMoveAmount;        
           
            
            if (bulletX >= enemyX && bulletX <= enemyX + 20 
                           && bulletY <= 10 && bulletY >= 0)
            {
               playerScore++;
               timerBullet.stop();                                       
            }
            else if (bulletY <= 0)              
            {
               timerBullet.stop();
            }
             
           
            repaint();
         }

      });  
           
      enemyTimer.start();
      playerTimer.start();
   }

   public void paint(Graphics g)
   {
      requestFocus();
      g.setColor(Color.gray);
      g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_WIDTH);         // repaint background
     
      g.setColor(Color.black);                              // repaint enemy 1
      g.fillRect(enemyX, 20, 20, 20);
          
      g.setColor(Color.blue);                               // repaint player at bottom of screen  
      g.fillRect(playerX, 200, 20, 20);
                                      
      g.fillRect(bulletX - 2, bulletY, 4, 10);  // repaint bullet
      
      
      
          
      g.setColor(Color.black);                              // update status
      g.drawString("score: " + playerScore, 30, 250);
      g.drawString("press spacebar to fire bullet", 10, 280);
   }
  
   public void keyTyped(KeyEvent key)
   {
      // space bar shoots the bullet
      if (key.getKeyChar() == ' ' && !timerBullet.isRunning())
      {
         bulletX = playerX;     
         bulletY = 180;          
         timerBullet.start();
      }
          
   }
  
   public void keyPressed(KeyEvent e) { }
   public void keyReleased(KeyEvent e) { }
  
   public static void main(String[] args)
   {
      TimerDemo1 prog = new TimerDemo1();
      prog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      prog.setSize(SCREEN_WIDTH, SCREEN_WIDTH);
      prog.setVisible(true);
      
   }// end of main method

}// end of class



