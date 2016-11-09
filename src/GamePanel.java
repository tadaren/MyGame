import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel{

	private Player player;

	private Enemy[] enemy = new Enemy[5];

	private JFrame frame;

	public GamePanel(){
		player = new Player(0,0,15);
		for(int i = 0; i < enemy.length; i++){
			enemy[i] = new Enemy(0,0,10);
		}
		frame = new JFrame("GAME");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(10, 10, 500, 500);
		frame.add(this);
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode() == KeyEvent.VK_UP){
					player.pressKey("up");
				}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
					player.pressKey("down");
				}else if(e.getKeyCode() == KeyEvent.VK_LEFT){
					player.pressKey("left");
				}else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
					player.pressKey("right");
				}
			}
			@Override
			public void keyReleased(KeyEvent e){
				if(e.getKeyCode() == KeyEvent.VK_UP){
					player.releaseKey("up");
				}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
					player.releaseKey("down");
				}else if(e.getKeyCode() == KeyEvent.VK_LEFT){
					player.releaseKey("left");
				}else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
					player.releaseKey("right");
				}
			}
		});

		frame.setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, getWidth(), getHeight());
		g2.setColor(Color.RED);
		player.paint(g2);
		g2.setColor(Color.CYAN);
		for(int i = 0; i < enemy.length; i++){
			enemy[i].paint(g2);
		}
		player.move(getWidth(), getHeight());

		repaint();
	}


	public static void main(String[] args) {
		new GamePanel();
	}

}