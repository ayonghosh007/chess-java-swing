package lib;

import java.awt.Color;
import java.awt.Image;

public class Settings {

	private int light = 0xd5ba90;
	private int dark = 0x956d49;
	private int back = 0x302e2b;
	private String image = "wood.png";

	public Settings() {
		// TODO Auto-generated constructor stub
	}

	public Color lightColor() {
		Color col = new Color(light);

		if(image != null) {
			col = new Color(col.getRed(),
							col.getGreen(),
							col.getBlue(),
							255 * 4 / 5);
		}

		return col;
	}

	public Color darkColor() {
		Color col = new Color(dark);

		if(image != null) {
			col = new Color(col.getRed(),
							col.getGreen(),
							col.getBlue(),
							255 * 4 / 5);
		}

		return col;
	}

	public Color backColor() {
		Color col = new Color(back);

		return col;
	}

	public Image getImage() {
		return Help.getImage(image);
	}
}
