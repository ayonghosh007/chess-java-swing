package lib;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
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

	public Cursor getCursor(String fileName) {
		try {
			BufferedImage cursorImg = ImageIO.read(Help.class.getResource("../assets/"+ fileName + ".png"));

			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Dimension bestSize = toolkit.getBestCursorSize(32, 32);
			BufferedImage resizedImage = new BufferedImage(bestSize.width, bestSize.height, BufferedImage.TYPE_INT_ARGB);

			Graphics2D g2d = resizedImage.createGraphics();
			g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			g2d.drawImage(cursorImg, 0, 0, bestSize.width, bestSize.height, null);
			g2d.dispose();

			Point hotspot = new Point(bestSize.width / 2, bestSize.height / 2);

			Cursor customCursor = toolkit.createCustomCursor(resizedImage, hotspot, fileName);

			return customCursor;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Cursor.getDefaultCursor();
		}
	}

	public Color getRGBOf(Color col) {
		return new Color(col.getRGB() & 0x00ffffff);
	}
}
