package com.drxgb.javafxutils;

/**
 * Classe que realiza tratativas diversas com valores numéricos.
 * @author Dr.XGB
 * @version 1.0
 */
public abstract class ValueHandler {
	
	/*
	 * ===========================================================
	 * 				*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Delimita um valor mínimo e máximo para o valor de entrada.
	 * @param value Valor a ser tratado.
	 * @param min Valor mínimo da tratativa.
	 * @param max Valor máximo da tratativa.
	 * @return Valor tratado dentro do método, deixando sempre entre
	 * o valor mínimo e o máximo.
	 */
	public static double clamp(double value, double min, double max) {
		value = (value < min) ? min : value;
		value = (value > max) ? max : value;
		return value;
	}
	
	/**
	 * Delimita um valor mínimo e máximo para o valor de entrada.
	 * @param value Valor a ser tratado.
	 * @param min Valor mínimo da tratativa.
	 * @param max Valor máximo da tratativa.
	 * @return Valor tratado dentro do método, deixando sempre entre
	 * o valor mínimo e o máximo.
	 */
	public static int clamp(int value, int min, int max) {
		return (int) clamp((double) value, (double) min, (double) max);
	}
	
	/**
	 * Delimita um valor mínimo e máximo para o valor de entrada.
	 * @param value Valor a ser tratado.
	 * @param min Valor mínimo da tratativa.
	 * @param max Valor máximo da tratativa.
	 * @return Valor tratado dentro do método, deixando sempre entre
	 * o valor mínimo e o máximo.
	 */
	public static float clamp(float value, float min, float max) {
		return (float) clamp((double) value, (double) min, (double) max);
	}
	
	/**
	 * Delimita um valor mínimo e máximo para o valor de entrada.
	 * @param value Valor a ser tratado.
	 * @param min Valor mínimo da tratativa.
	 * @param max Valor máximo da tratativa.
	 * @return Valor tratado dentro do método, deixando sempre entre
	 * o valor mínimo e o máximo.
	 */
	public static long clamp(long value, long min, long max) {
		return (long) clamp((double) value, (double) min, (double) max);
	}
	
	/**
	 * Delimita um valor mínimo e máximo para o valor de entrada.
	 * @param value Valor a ser tratado.
	 * @param min Valor mínimo da tratativa.
	 * @param max Valor máximo da tratativa.
	 * @return Valor tratado dentro do método, deixando sempre entre
	 * o valor mínimo e o máximo.
	 */
	public static short clamp(short value, short min, short max) {
		return (short) clamp((double) value, (double) min, (double) max);
	}
	
	/**
	 * Delimita um valor mínimo e máximo para o valor de entrada.
	 * @param value Valor a ser tratado.
	 * @param min Valor mínimo da tratativa.
	 * @param max Valor máximo da tratativa.
	 * @return Valor tratado dentro do método, deixando sempre entre
	 * o valor mínimo e o máximo.
	 */
	public static byte clamp(byte value, byte min, byte max) {
		return (byte) clamp((double) value, (double) min, (double) max);
	}
	
}
