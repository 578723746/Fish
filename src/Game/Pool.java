package Game;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Pool extends JPanel{
	
	/*背景图片*/
	BufferedImage background;
	Fish fish;
	Net net;
	Fish[] fishs;
	
	public Pool() {
		fishs = new Fish[9];
		for (int i = 0; i < 9; i++) {
			fishs[i] = new Fish("images/fish0"+(i+1));
		}
		
		
		try {
			background = ImageIO.read(new File("images/bg.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		fish = new Fish();
		net = new Net();
	}
	
	public void action() {
		
		// 监控鼠标
		// 移动
		this.addMouseMotionListener(
				new MouseMotionListener() {
					@Override
					public void mouseMoved(MouseEvent e) {
						net.x = e.getX();
						net.y = e.getY();
					}
					
					@Override
					public void mouseDragged(MouseEvent e) {
						
					}
				});
		this.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				
				for (int i = 0; i < fishs.length; i++) {
					Fish f = fishs[i];
					if(f.x > e.getX()-net.width/2 && f.x+f.width < e.getX()+net.width/2
					 &&f.y > e.getY()-net.hight/2 && f.y+f.hight < e.getY()+net.hight/2){
						f.isShow = false;
					}
				}
			}
		});
		
		while (true) {
			fish.x -= fish.step;
			if (fish.x <= -fish.width) {
				fish.x = background.getWidth();
				fish.y = new Random().nextInt(background.getHeight()-fish.hight);
			} 
			fish.current = fish.images[fish.index++ %10];
			
			for (int i = 0; i < fishs.length; i++) {
				Fish f = fishs[i];
				f.move();
			}
			
			try {
				Thread.sleep(1000/24);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
	}
	
	public void step() {
		
	}
	
	public void paint(Graphics g) {
		//1.画背景
		g.drawImage(background, 0, 0, null);
		//2.画鱼、渔网
		g.drawImage(fish.current, fish.x, fish.y, null);
		for (int i = 0; i < fishs.length; i++) {
			Fish f = fishs[i];
			if (f.isShow) {
				g.drawImage(f.current, f.x, f.y, null);
			}
		}
		g.drawImage(net.current, net.x-net.width/2, net.y-net.hight/2, null);
	}
}
