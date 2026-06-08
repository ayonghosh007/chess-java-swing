package lib;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

import com.formdev.flatlaf.extras.FlatSVGIcon;

public class Help implements Constants {

	public Image getImage(String fileName) {
		Image imag = (new ImageIcon(Help.class.getResource("../assets/" + fileName))).getImage();
		return imag;
	}

	public FlatSVGIcon getSVG(String fileName) {
		FlatSVGIcon svg = new FlatSVGIcon("assets/pieces/" + settings.coinStyle() + "/" + fileName, PIECE_SIZE.width, PIECE_SIZE.height);

		return svg;
	}

	public Color getRGBOf(Color col) {
		return new Color(col.getRGB() & 0x00ffffff);
	}
}
