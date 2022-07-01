package dev.jonmuxu;

import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

public class DreamFox {
	private final String NAME = "dreamfox";	
	private boolean isRunning;
	private Scanner keyboard;

	private DreamManager dreamManager;

	public DreamFox() {
		this.keyboard = new Scanner(System.in);
		this.isRunning = true;	

		String defaultPath = "";
		try {
			File f = new File("/mnt/l/Jonmuxu/Programming Languages/Java/DreamFox-Terminal/config.txt");
			Scanner sc = new Scanner(f);
			defaultPath = sc.nextLine().split("=")[1];
		} catch (Exception e) {} 

		this.dreamManager = new DreamManager(defaultPath);
	}

	public void run() {
		while (isRunning) {
			System.out.print(NAME + "> ");
			parseCommand(keyboard.nextLine());	
		}
	}

	private void parseCommand(String input) {
		String[] split = input.split("\\s+");
		String command = split[0];

		switch (command) {
			case "list":
				this.dreamManager.listDreams();				
				break;

			case "statistics":
				this.dreamManager.showStatistics();
				break;

			case "setpath":
				if (split.length > 1) {
					String path = split[1];
					checkPath(path);
				} else {
					System.out.println("Usage: setpath [path]");
				}
				break;

			case "exit":
				isRunning = false;
				break;

			case "clear":
				try {
					if (System.getProperty("os.name").contains("Windows")) {
						new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
					} else {
						System.out.print("\033\143"); // only Linux
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			default:
				System.out.println("Invalid command");
		}
	}

	private void checkPath(String path) {
		try {
			File directory = new File(path);
			if (directory.exists()) {
				this.dreamManager.setPath(path);
			} else {
				System.out.println("Path to directory does not exist");
			}
		} catch (FileNotFoundException e) {
			System.out.println("invalid path");
		}
	}

	private void checkFilter(String[] command) {
		
	}

}
