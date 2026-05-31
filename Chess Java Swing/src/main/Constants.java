package main;

import java.awt.Dimension;
import java.awt.Toolkit;

import window.Frame;

public interface Constants {

	public static final Dimension SCREEN = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static final Frame frame = new Frame();
}
