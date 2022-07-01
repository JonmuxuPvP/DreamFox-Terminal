package dev.jonmuxu;

import java.util.ArrayList;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

public class DreamManager {
	private ArrayList<Dream> dreams;
	private File folder;
	
	public DreamManager(String directory) {
		this.folder = new File(directory);
		this.dreams = getDreams();
	}

	private ArrayList<Dream> getDreams() {
		ArrayList<Dream> array = new ArrayList<>();	

		for (File file : folder.listFiles()) {
			try {
				String title, content;
				StringBuilder sb = new StringBuilder();
				Scanner sc = new Scanner(file);

				while (sc.hasNextLine()) {
					sb.append(sc.nextLine());	
				}

				title = file.getName();
				content = sb.toString();

				array.add(new Dream(title, content, null));
			} catch (Exception e) {}
		}
		return array;
	}

	public void listDreams() {
		for (Dream dream : dreams) {
			System.out.println(dream.getTitle());
		}
	}

	public void listDreams(String filter) {
		
	}

	public void setPath(String newPath) throws FileNotFoundException {
		this.folder = new File(newPath);
	}

	public void showStatistics() {
		int totalDreams = dreams.size();

		int totalWords = 0;
		int lucidDreams = 0;
		int normalDreams = 0;

		for (Dream dream : dreams) {
			totalWords += dream.getContent().split("\\s+").length;	
			if (dream.isLucid()) {
				lucidDreams++;
			} else {
				normalDreams++;
			}
		}

		System.out.println("Total Dreams: " + totalDreams);
		System.out.println("Lucid Dreams: " + lucidDreams);
		System.out.println("Normal Dreams: " + normalDreams);
		System.out.println("Total Words: " + totalWords);
	}

}
