import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BrickBreakerGame extends JPanel implements KeyListener, ActionListener {
    private int ballX = 120;
    private int ballY = 350;
    private int ballDirectionX = -1;
    private int ballDirectionY = -2;

    private int playerX = 310;
    private int bricksCount = 21;

    private Timer timer;
    private boolean play = false;

    private int score = 0;

    private int brickX;
    private int brickY;

    private int bricks[][] = new int[3][7];

    public BrickBreakerGame() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(5, this);
        timer.start();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                bricks[i][j] = 1;
            }
        }
    }

    public void paint(Graphics g) {
        // Background
        g.setColor(Color.black);
        g.fillRect(1, 1, 692, 592);

        // Bricks
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (bricks[i][j] == 1) {
                    brickX = j * 90 + 80;
                    brickY = i * 50 + 50;
                    g.setColor(Color.white);
                    g.fillRect(brickX, brickY, 80, 30);
                }
            }
        }

        // Paddle
        g.setColor(Color.green);
        g.fillRect(playerX, 550, 100, 8);

        // Ball
        g.setColor(Color.yellow);
        g.fillOval(ballX, ballY, 20, 20);

        // Score
        g.setColor(Color.white);
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString("Score: " + score, 600, 30);

        // Game Over
        if (bricksCount == 0) {
            play = false;
            g.setColor(Color.red);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("You Win! Score: " + score, 260, 300);
        }
        if (ballY > 570) {
            play = false;
            g.setColor(Color.red);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Game Over! Score: " + score, 260, 300);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if (play) {
            if (new Rectangle(ballX, ballY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
                ballDirectionY = -ballDirectionY;
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 7; j++) {
                    if (bricks[i][j] == 1) {
                        int brickX = j * 90 + 80;
                        int brickY = i * 50 + 50;
                        Rectangle brickRect = new Rectangle(brickX, brickY, 80, 30);
                        Rectangle ballRect = new Rectangle(ballX, ballY, 20, 20);

                        if (ballRect.intersects(brickRect)) {
                            bricks[i][j] = 0;
                            bricksCount--;
                            score += 5;

                            if (ballX + 19 <= brickRect.x || ballX + 1 >= brickRect.x + brickRect.width) {
                                ballDirectionX = -ballDirectionX;
                            } else {
                                ballDirectionY = -ballDirectionY;
                            }
                        }
                    }
                }
            }

            ballX += ballDirectionX;
            ballY += ballDirectionY;
            if (ballX < 0) {
                ballDirectionX = -ballDirectionX;
            }
            if (ballY < 0) {
                ballDirectionY = -ballDirectionY;
            }
            if (ballX > 670) {
                ballDirectionX = -ballDirectionX;
            }
        }

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (playerX >= 600) {
                playerX = 600;
            } else {
                moveRight();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (playerX < 10) {
                playerX = 10;
            } else {
                moveLeft();
            }
        }
    }

    public void moveRight() {
        play = true;
        playerX += 20;
    }

    public void moveLeft() {
        play = true;
        playerX -= 20;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        BrickBreakerGame game = new BrickBreakerGame();
        frame.setBounds(10, 10, 700, 600);
        frame.setTitle("Brick Breaker Game");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.setVisible(true);
    }
}
