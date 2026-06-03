package lib;

import java.awt.Color;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Settings {

	private String theme;
	private int light;
	private int dark;
	private int back;
	private String image;
	private String coin_theme;

	File file;

	public Settings() {
		// TODO Auto-generated constructor stub
		file = new File("src/assets/settings.ini");
		if(!file.exists()) {
			try {
				file.createNewFile();
				defaultSet();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String read = reader.readLine();
			theme = read.substring(read.indexOf('=') + 2).trim();

			read = reader.readLine();
			light = Integer.parseInt(read.substring(read.indexOf('=') + 4).trim(), 16);

			read = reader.readLine();
			dark = Integer.parseInt(read.substring(read.indexOf('=') + 4).trim(), 16);

			read = reader.readLine();
			back = Integer.parseInt(read.substring(read.indexOf('=') + 4).trim(), 16);

			read = reader.readLine();
			image = read.substring(read.indexOf('=') + 2).trim();

			if(image.equals("null"))
				image = null;

			read = reader.readLine();
			coin_theme = read.substring(read.indexOf('=') + 2).trim();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getTheme() {
		return theme;
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
		if(image == null)
			return null;

		return Help.getImage(image);
	}

	public String coinStyle() {
		return coin_theme;
	}

	private void defaultSet() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("current_theme = Walnut\r\n"
            		+ "light = 0xd5ba90\r\n"
            		+ "dark = 0x956d49\r\n"
            		+ "back = 0x302e2b\r\n"
            		+ "img = wood.png\r\n"
            		+ "coin_theme = staunty");
            writer.close();
        } catch (IOException e) {
        	e.printStackTrace();
        }
	}
}
