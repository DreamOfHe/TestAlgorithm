package com.hlx.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyMethod {
	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
}
