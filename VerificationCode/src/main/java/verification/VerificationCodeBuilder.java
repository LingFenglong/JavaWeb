package verification;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.util.Random;

/**
 * 用于生成验证码图片
 */
public class VerificationCodeBuilder {
	private int width;
	private int height;
	private static Random random = new Random();
	
	public final static int DEFAULT_HEIGHT = 40;
	public final static int DEFAULT_WIDTH = 160;

	public VerificationCodeBuilder(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	public RenderedImage build(String verificationCode) {
		BufferedImage verificationCodeImage = 
				new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = verificationCodeImage.getGraphics();
		g.setFont(new Font("微软雅黑", Font.BOLD, height - 10));
		// 设置画笔颜色
		g.setColor(getRandomColor());
		
		// 填充背景颜色
		g.fillRect(0, 0, width, height);
		
		// 画干扰线
		for (int i = 0; i < 50; i++) {
			if (i % 10 == 0) {
				g.setColor(getRandomColor());
			}
			g.drawLine(
					random.nextInt(width),
					random.nextInt(height), 
					random.nextInt(width), 
					random.nextInt(height)
				);
		}
		
		for (int i = 0; i < 4; i++) {
			g.setColor(getRandomColor());
			g.drawString("" + verificationCode.charAt(i), i * width / 4 + 8, height - 10);
		}

		g.dispose();
		
		return verificationCodeImage;
	}
	
	public String getRandomString() {
		// 取随机产生的认证码(4位) 共62个
		String source[] = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
				"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
				"l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
				"6", "7", "8", "9" };
		StringBuilder stringBuilder = new StringBuilder();
		
		for (int i = 0; i < 4; i++) {
			stringBuilder.append(source[random.nextInt(62)]);
		}
		
		return stringBuilder.toString();
	}

	private Color getRandomColor() {
		return new Color(
				random.nextInt(0, 256), 
				random.nextInt(0, 256), 
				random.nextInt(0, 256)
			);
	}

	public int getwidth() {
		return width;
	}

	public void setwidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
