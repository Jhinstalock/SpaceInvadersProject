import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TimerDemo1 extends JFrame implements KeyListener
{
   private boolean gameStarted = false;
   private int gameStarter; 
   
   private Timer gameStart;
   private Timer sendEnemies;
   
   private Timer enemy1Timer;
   private Timer enemy2Timer;
   private Timer enemy3Timer;
   private Timer enemy4Timer;
   private Timer enemy5Timer;
              
   private Timer playerTimer;
          
   private Timer bullet1Timer;
   private Timer bullet2Timer;
   private Timer bullet3Timer;
   private Timer bullet4Timer;
   private Timer bullet5Timer;
          
   private int playerX;
   private int playerY = SCREEN_HEIGHT - 30;
                
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
                              
   private int bullet1X;
   private int bullet2X;
   private int bullet3X;
   private int bullet4X;
   private int bullet5X;
   
   private int bullet1Y;
   private int bullet2Y;
   private int bullet3Y;
   private int bullet4Y;
   private int bullet5Y;
                
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
                                  
      enemy1X = -20;
      enemy2X = -20;
      enemy3X = -20;
      enemy4X = -20;
      enemy5X = -20;
                           
      enemyMoveAmount = 5;  
      playerMoveAmount = 6;
      bulletMoveAmount = 10; 
         
      bullet1X = -10;                    
      bullet1Y = SCREEN_HEIGHT - 40; //ADJUST IF NECESSARY
      bullet2X = -10;                    
      bullet2Y = SCREEN_HEIGHT - 40; //ADJUST IF NECESSARY
      bullet3X = -10;                    
      bullet3Y = SCREEN_HEIGHT - 40; //ADJUST IF NECESSARY
      bullet4X = -10;                    
      bullet4Y = SCREEN_HEIGHT - 40; //ADJUST IF NECESSARY
      bullet5X = -10;                    
      bullet5Y = SCREEN_HEIGHT - 40; //ADJUST IF NECESSARY
      
      addKeyListener(this);         // necessary to make the KeyListener work correctly
                             
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
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
            if (enemy1Y > (SCREEN_HEIGHT - 30));
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
            if (enemy2Y > (SCREEN_HEIGHT - 30));
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
            if (enemy3Y > (SCREEN_HEIGHT - 30));
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
            if (enemy4Y > (SCREEN_HEIGHT - 30));
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
            if (enemy5Y > (SCREEN_HEIGHT - 30));
            {
               gameOver();
            }      
            repaint();
         }

      });
              
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////      
      
      /* DONT NEED THIS IF ITS PLAYER CONTROLLED.
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
      */ 
       
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      bullet1Timer = new Timer(50, new ActionListener()
      {

         public void actionPerformed(ActionEvent evt)
         {            
            bullet1Y -= bulletMoveAmount;
                                        
            if (bullet1X >= enemy1X && bullet1X <= enemy1X + ENEMY_WIDTH && bullet1Y >= enemy1Y && bullet1Y <= enemy1Y + ENEMY_HEIGHT){enemy1Timer.stop();bullet1Timer.stop();}                           
            else if (bullet1X >= enemy2X && bullet1X <= enemy2X + ENEMY_WIDTH && bullet1Y >= enemy2Y && bullet1Y <= enemy2Y + ENEMY_HEIGHT){enemy2Timer.stop();bullet1Timer.stop();}  
            else if (bullet1X >= enemy3X && bullet1X <= enemy3X + ENEMY_WIDTH && bullet1Y >= enemy3Y && bullet1Y <= enemy3Y + ENEMY_HEIGHT){enemy3Timer.stop();bullet1Timer.stop();} 
            else if (bullet1X >= enemy4X && bullet1X <= enemy4X + ENEMY_WIDTH && bullet1Y >= enemy4Y && bullet1Y <= enemy4Y + ENEMY_HEIGHT){enemy4Timer.stop();bullet1Timer.stop();}  
            else if (bullet1X >= enemy5X && bullet1X <= enemy5X + ENEMY_WIDTH && bullet1Y >= enemy5Y && bullet1Y <= enemy5Y + ENEMY_HEIGHT){enemy5Timer.stop();bullet1Timer.stop();}          
            else if (bullet1Y <= 0)              
            {
               bullet1Timer.stop();
            }
                        
            repaint();
         }

      });  

      bullet2Timer = new Timer(50, new ActionListener()
      {

         public void actionPerformed(ActionEvent evt)
         {            
            bullet2Y -= bulletMoveAmount;        
           
            
            if (bullet2X >= enemy1X && bullet2X <= enemy1X + ENEMY_WIDTH && bullet2Y >= enemy1Y && bullet2Y <= enemy1Y + ENEMY_HEIGHT){enemy1Timer.stop();bullet2Timer.stop();}                           
            else if (bullet2X >= enemy2X && bullet2X <= enemy2X + ENEMY_WIDTH && bullet2Y >= enemy2Y && bullet2Y <= enemy2Y + ENEMY_HEIGHT){enemy2Timer.stop();bullet2Timer.stop();}  
            else if (bullet2X >= enemy3X && bullet2X <= enemy3X + ENEMY_WIDTH && bullet2Y >= enemy3Y && bullet2Y <= enemy3Y + ENEMY_HEIGHT){enemy3Timer.stop();bullet2Timer.stop();} 
            else if (bullet2X >= enemy4X && bullet2X <= enemy4X + ENEMY_WIDTH && bullet2Y >= enemy4Y && bullet2Y <= enemy4Y + ENEMY_HEIGHT){enemy4Timer.stop();bullet2Timer.stop();}  
            else if (bullet2X >= enemy5X && bullet2X <= enemy5X + ENEMY_WIDTH && bullet2Y >= enemy5Y && bullet2Y <= enemy5Y + ENEMY_HEIGHT){enemy5Timer.stop();bullet2Timer.stop();}          
            else if (bullet2Y <= 0)              
            {
               bullet2Timer.stop();
            }
                        
            repaint();
         }

      });

      bullet3Timer = new Timer(50, new ActionListener()
      {

         public void actionPerformed(ActionEvent evt)
         {            
            bullet3Y -= bulletMoveAmount;        
           
            
            if (bullet3X >= enemy1X && bullet3X <= enemy1X + ENEMY_WIDTH && bullet3Y >= enemy1Y && bullet3Y <= enemy1Y + ENEMY_HEIGHT){enemy1Timer.stop();bullet3Timer.stop();}                           
            else if (bullet3X >= enemy2X && bullet3X <= enemy2X + ENEMY_WIDTH && bullet3Y >= enemy2Y && bullet3Y <= enemy2Y + ENEMY_HEIGHT){enemy2Timer.stop();bullet3Timer.stop();}  
            else if (bullet3X >= enemy3X && bullet3X <= enemy3X + ENEMY_WIDTH && bullet3Y >= enemy3Y && bullet3Y <= enemy3Y + ENEMY_HEIGHT){enemy3Timer.stop();bullet3Timer.stop();} 
            else if (bullet3X >= enemy4X && bullet3X <= enemy4X + ENEMY_WIDTH && bullet3Y >= enemy4Y && bullet3Y <= enemy4Y + ENEMY_HEIGHT){enemy4Timer.stop();bullet3Timer.stop();}  
            else if (bullet3X >= enemy5X && bullet3X <= enemy5X + ENEMY_WIDTH && bullet3Y >= enemy5Y && bullet3Y <= enemy5Y + ENEMY_HEIGHT){enemy5Timer.stop();bullet3Timer.stop();}
            else if (bullet3Y <= 0)              
            {
               bullet3Timer.stop();
            }             
           
            repaint();
         }

      });

      bullet4Timer = new Timer(50, new ActionListener()
      {

         public void actionPerformed(ActionEvent evt)
         {            
            bullet4Y -= bulletMoveAmount;        
           
            
            if (bullet4X >= enemy1X && bullet4X <= enemy1X + ENEMY_WIDTH && bullet4Y >= enemy1Y && bullet4Y <= enemy1Y + ENEMY_HEIGHT){enemy1Timer.stop();bullet4Timer.stop();}                           
            else if (bullet4X >= enemy2X && bullet4X <= enemy2X + ENEMY_WIDTH && bullet4Y >= enemy2Y && bullet4Y <= enemy2Y + ENEMY_HEIGHT){enemy2Timer.stop();bullet4Timer.stop();}  
            else if (bullet4X >= enemy3X && bullet4X <= enemy3X + ENEMY_WIDTH && bullet4Y >= enemy3Y && bullet4Y <= enemy3Y + ENEMY_HEIGHT){enemy3Timer.stop();bullet4Timer.stop();} 
            else if (bullet4X >= enemy4X && bullet4X <= enemy4X + ENEMY_WIDTH && bullet4Y >= enemy4Y && bullet4Y <= enemy4Y + ENEMY_HEIGHT){enemy4Timer.stop();bullet4Timer.stop();}  
            else if (bullet4X >= enemy5X && bullet4X <= enemy5X + ENEMY_WIDTH && bullet4Y >= enemy5Y && bullet4Y <= enemy5Y + ENEMY_HEIGHT){enemy5Timer.stop();bullet4Timer.stop();}
            else if (bullet4Y <= 0)              
            {
               bullet4Timer.stop();
            }
                        
            repaint();
         }

      });

      bullet5Timer = new Timer(50, new ActionListener()
      {

         public void actionPerformed(ActionEvent evt)
         {            
            bullet5Y -= bulletMoveAmount;        
           
            
            if (bullet5X >= enemy1X && bullet5X <= enemy1X + ENEMY_WIDTH && bullet5Y >= enemy1Y && bullet5Y <= enemy1Y + ENEMY_HEIGHT){enemy1Timer.stop();bullet5Timer.stop();}                           
            else if (bullet5X >= enemy2X && bullet5X <= enemy2X + ENEMY_WIDTH && bullet5Y >= enemy2Y && bullet5Y <= enemy2Y + ENEMY_HEIGHT){enemy2Timer.stop();bullet5Timer.stop();}  
            else if (bullet5X >= enemy3X && bullet5X <= enemy3X + ENEMY_WIDTH && bullet5Y >= enemy3Y && bullet5Y <= enemy3Y + ENEMY_HEIGHT){enemy3Timer.stop();bullet5Timer.stop();} 
            else if (bullet5X >= enemy4X && bullet5X <= enemy4X + ENEMY_WIDTH && bullet5Y >= enemy4Y && bullet5Y <= enemy4Y + ENEMY_HEIGHT){enemy4Timer.stop();bullet5Timer.stop();}  
            else if (bullet5X >= enemy5X && bullet5X <= enemy5X + ENEMY_WIDTH && bullet5Y >= enemy5Y && bullet5Y <= enemy5Y + ENEMY_HEIGHT){enemy5Timer.stop();bullet5Timer.stop();}
            else if (bullet5Y <= 0)              
            {
               bullet5Timer.stop();
            }          
           
            repaint();
         }

      });

      gameStart = new Timer(10000, new ActionListener()
      {
         public void actionPerformed(ActionEvent evt)
         {
            gameStarter++;
            if (gameStarted == false)
               {
                  if (gameStarter >= 2)
                     {
                        gameStarted = true;
                        sendEnemies.start(); //STARTS THE GAME A FEW SECONDS AFTER LOAD.
                        gameStart.stop();
                     }
               }
         }
      });
      
      
      sendEnemies = new Timer(2000, new ActionListener()
      {
         public void actionPerformed(ActionEvent evt)
         {
            if (enemy1Timer.isRunning() == false)
               {
                  enemy1Timer.start();
               }                      
            else if (enemy2Timer.isRunning() == false)
               {
                  enemy2Timer.start();
               }
            else if (enemy3Timer.isRunning() == false)
               {
                  enemy3Timer.start();
               }
            else if (enemy4Timer.isRunning() == false)
               {
                  enemy4Timer.start();
               }
            else if (enemy5Timer.isRunning() == false)
               {
                  enemy5Timer.start();
               }              
         }
      }); 
               
   }   
   
   public void gameOver()
   {
      enemy1Timer.stop();
      enemy2Timer.stop();
      enemy3Timer.stop();
      enemy4Timer.stop();
      enemy5Timer.stop();
      bullet1Timer.stop();
      
      System.out.println("You lose." + " Your score was: " + playerScore);
   }

   public void paint(Graphics g)
   {
      requestFocus();
      g.setColor(Color.gray);
      g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);         // repaint background
     
      g.setColor(Color.black);                              // repaint enemy 1
      g.fillRect(enemy1X, enemy1Y, 20, 20);
      g.setColor(Color.black);                              // repaint enemy 2
      g.fillRect(enemy2X, enemy2Y, 20, 20);
      g.setColor(Color.black);                              // repaint enemy 3
      g.fillRect(enemy3X, enemy3Y, 20, 20);
      g.setColor(Color.black);                              // repaint enemy 4
      g.fillRect(enemy4X, enemy4Y, 20, 20);
      g.setColor(Color.black);                              // repaint enemy 5
      g.fillRect(enemy5X, enemy5Y, 20, 20);
          
      g.setColor(Color.blue);                               // repaint player at bottom of screen  
      g.fillRect(playerX, (playerY), PLAYER_WIDTH, PLAYER_HEIGHT);
                                      
      g.fillRect(bullet1X - 2, bullet1Y, 4, 10);  // repaint bullet 1    
      g.fillRect(bullet2X - 2, bullet2Y, 4, 10);  // repaint bullet 2
      g.fillRect(bullet3X - 2, bullet3Y, 4, 10);  // repaint bullet 3
      g.fillRect(bullet4X - 2, bullet4Y, 4, 10);  // repaint bullet 4
      g.fillRect(bullet5X - 2, bullet5Y, 4, 10);  // repaint bullet 5
      
      /*    
      g.setColor(Color.black);                              // update status
      g.drawString("score: " + playerScore, 30, 250);
      g.drawString("press spacebar to fire bullet", 10, 280);
      */
   }
  
   public void keyTyped(KeyEvent key)
   {  
      /*
      int keyCode = key.getKeyCode();
      switch( keyCode )
      {
         case KeyEvent.VK_LEFT:
            break;
         case KeyEvent.VK_RIGHT:
            break;
      }
      */
      //*
      if (key.getKeyChar() == KeyEvent.VK_SPACE && !bullet1Timer.isRunning())
      {  
         bullet1X = playerX + (PLAYER_WIDTH / 2);     
         bullet1Y = playerY; //change the "30" if it's off.          
         bullet1Timer.start();
      }
      else if (key.getKeyCode == 97)    //(key.getKeyChar() == KeyEvent.VK_D) //Works for Uppercase //Left
      {
         System.out.println("a");
         if (playerX > 0)
         {
            playerX -= 5;
            repaint();
         }
      }
      else if (key.KEY_TYPED == 100)    //(key.getKeyChar()== KeyEvent.VK_A) //Works for Uppercase
      {  
         System.out.println("d");
         if ((playerX + PLAYER_WIDTH) < SCREEN_WIDTH)
         {
            playerX += 5;
            repaint();
            
         }
      }
      //*/    
   }
  
   public void keyPressed(KeyEvent e) { }
   public void keyReleased(KeyEvent e) { }
  
   public static void main(String[] args)
   {
      TimerDemo1 prog = new TimerDemo1();
      prog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      prog.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
      prog.setVisible(true);
      
   }// end of main method

}// end of class



