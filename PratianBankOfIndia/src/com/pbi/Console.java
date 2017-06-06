package com.pbi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console 
{
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static String readLine() {
		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	public static float readFloat() {
		return Float.parseFloat(readLine());
	}
	public static double readDouble() {
		return Double.parseDouble(readLine());
	}
	public static int readInt() {
		return Integer.parseInt(readLine());
	}
	public static char readChar() {
		return readLine().charAt(0);
	}
	public static boolean readBoolean() {
		return Boolean.parseBoolean(readLine());
	}
}

