package Game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Fish {
	
	/*鱼的位置 */
	int x;
	int y;
	
	/*图片资源*/
	BufferedImage current;
	BufferedImage[] images;
	
	/*正在显示的当前图片的位置*/
	int index;
	
	/*宽度和高度*/
	int width;
	int hight;
	
	/*速度（步长）*/
	int step;
	
	boolean isShow;
	
	public Fish() {
		x = 720;
		y = 100;
		step = 5;
		isShow = true;
		
		images = new BufferedImage[10];
		for(int i = 0;i<=9;i++){
			try {
				images[i] = ImageIO.read(new File("images/fish14_0"+i+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			current = images[index];
		width = current.getWidth();
		hight = current.getHeight();
	}
	
	/**
	 *  有参构造方法
	 * @param name
	 *  name = images/fish01
	 *  name = images/fish02
	 */
	public Fish(String name){
		images = new BufferedImage[10];
		for (int i = 0; i < 10; i++) {
			try {
				images[i] = ImageIO.read(new File(name+"_0"+i+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		current = images[0];
		width = current.getWidth();
		hight = current.getHeight();
		step = 5;
		index = 0;
		x = 800;
		y = new Random().nextInt(480-hight);
		isShow = true;
	}
	
	/* 鱼的移动 */
	public void move(){
		current = images[index++ % 10];
		x -= step;
		if (x <= -width) {
			x = 800;
			y = new Random().nextInt(480-hight);
			isShow = true;
		}
	}
}
