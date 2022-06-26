package com.drxgb.javafxutils;

import javafx.scene.paint.Color;

public interface ColorParser
{
	static String toCssHexColor(Color color)
	{
		return color.toString().replace("0x", "#");
	}
	
	static String toCssRgbColor(Color color)
	{
		StringBuilder sb = new StringBuilder();
		final int r = (int) (color.getRed() * 255);
		final int g = (int) (color.getGreen() * 255);
		final int b = (int) (color.getBlue() * 255);
		
		sb.append("rgb(")
			.append(r)
			.append(", ")
			.append(g)
			.append(", ")
			.append(b)
			.append(")");
		
		return sb.toString();
	}
	
	static String toCssRgbaColor(Color color)
	{
		StringBuilder sb = new StringBuilder();
		final int r = (int) (color.getRed() * 255);
		final int g = (int) (color.getGreen() * 255);
		final int b = (int) (color.getBlue() * 255);
		
		sb.append("rgba(")
			.append(r)
			.append(", ")
			.append(g)
			.append(", ")
			.append(b)
			.append(", ")
			.append(color.getOpacity())
			.append(")");
		
		return sb.toString(); 
	}
}
