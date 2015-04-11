package Game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Net {
	/* 坐标 */
	int x;
	int y;
	
	/* 图片资源  */
	BufferedImage current;
	
	/* 图片宽度、高度  */
	int width;
	int hight;
	
	public Net() {
		x = 100;
		y = 100;
		
		try {
			current = ImageIO.read(new File("images/net09.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		width = current.getWidth();
		hight = current.getHeight();
	}
}
