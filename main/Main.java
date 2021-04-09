package com.movieapp.main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Select an option:\n1-User login\n2-Admin login\n3-Exit");

		int opt = sc.nextInt();
		if (opt == 1) {
			new User();
		} else if (opt == 2) {
			new Admin();
		}
		sc.close();
	}
}

