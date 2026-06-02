package lib;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Help {
	public static Image getImage(String fileName) {

		Image imag = (new ImageIcon(Help.class.getResource("../assets/" + fileName))).getImage();
		return imag;
	}

}
