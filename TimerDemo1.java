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
   private final static int SCREEN_HEIGHT = 600;
   private final static int PLAYER_WIDTH = 20;
   private final static int PLAYER_HEIGHT = 20;   
   private final static int ENEMY_HEIGHT = 20;
   private final static int ENEMY_WIDTH = 20;
   
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
     
   public TimerDemo1()             
   {
      playerX = SCREEN_WIDTH / 2 - 10; //10 subtracted to compensate for player width (20). 
                                  
      enemy1X = -20
      enemy2X = -20
      enemy3X = -20
      enemy4X = -20
      enemy5X = -20
                           
      enemyMoveAmount = 5;  
      playerMoveAmount = 6;
      
      bulletMoveAmount = 10;    
      bullet1X = -10;                    bullet1Y = 180;
      
      addKeyListener(this);         // necessary to make the KeyListener work correctly
                             
   
      enemy1Timer = new Timer(100, new ActionListener()
      {

         public void actionPerformed(ActionEvent evt)
         {
            if (enemy1X < 0)
            {
               enemy1X = (int) (Math.random() * (SCREEN_WIDTH - ENEMY_WIDTH));
            }
            else 
            {
               enemy1Y += enemyMoveAmount;
            }
            if enemy1Y > (SCREEN_HEIGHT - 30);
            {
               gameOver();
            }      
            repaint();
         }

      });
      
      enemy2Timer = new Timer(100, new ActionListener()
      {

         public void actionPerformed(ActionEvent evt)
         {
            if (enemy2X < 0)
            {
               enemy2X = (int) (Math.random() * (SCREEN_WIDTH - ENEMY_WIDTH));
            }
            else 
            {
               enemy2Y += enemyMoveAmount;
            }
            if enemy2Y > (SCREEN_HEIGHT - 30);
            {
               gameOver();
            }      
            repaint();
         }

      });
      
      enemy3Timer = new Timer(100, new ActionListener()
      {

         public void actionPerformed(ActionEvent evt)
         {
            if (enemy3X < 0)
            {
               enemy3X = (int) (Math.random() * (SCREEN_WIDTH - ENEMY_WIDTH));
            }
            else 
            {
               enemy3Y += enemyMoveAmount;
            }
            if enemy3Y > (SCREEN_HEIGHT - 30);
            {
               gameOver();
            }      
            repaint();
         }

      });

      enemy4Timer = new Timer(100, new ActionListener()
      {

         public void actionPerformed(ActionEvent evt)
         {
            if (enemy4X < 0)
            {
               enemy4X = (int) (Math.random() * (SCREEN_WIDTH - ENEMY_WIDTH));
            }
            else 
            {
               enemy4Y += enemyMoveAmount;
            }
            if enemy4Y > (SCREEN_HEIGHT - 30);
            {
               gameOver();
            }      
            repaint();
         }

      });

      enemy5Timer = new Timer(100, new ActionListener()
      {

         public void actionPerformed(ActionEvent evt)
         {
            if (enemy5X < 0)
            {
               enemy5X = (int) (Math.random() * (SCREEN_WIDTH - ENEMY_WIDTH));
            }
            else 
            {
               enemy5Y += enemyMoveAmount;
            }
            if enemy5Y > (SCREEN_HEIGHT - 30);
            {
               gameOver();
            }      
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
   
   public void gameOver()
   {
      enemy1Timer.stop
      enemy2Timer.stop
      enemy3Timer.stop
      enemy4Timer.stop
      enemy5Timer.stop
      timerBullet.stop
      
      System.out.println("You lose." + " Your score was: " + playerScore);
   }

   public void paint(Graphics g)
   {
      requestFocus();
      g.setColor(Color.gray);
      g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_WIDTH);         // repaint background
     
      g.setColor(Color.black);                              // repaint enemy 1
      g.fillRect(enemyX, 20, 20, 20);
          
      g.setColor(Color.blue);                               // repaint player at bottom of screen  
      g.fillRect(playerX, 200, PLAYER_WIDTH, PLAYER_HEIGHT);
                                      
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



