package dev.jonmuxu;

import java.time.LocalDate;

public class Dream {
	private String title;
	private String content;
	private LocalDate date;
	private boolean isLucid;

	public Dream(String title, String content, LocalDate date) {
		this.title = title;
		this.content = content;
		this.date = date;
		this.isLucid = this.title.toLowerCase().contains("Lucid");
	}

	public boolean isLucid() {
		return this.isLucid;
	}

	public String getTitle() {
		return this.title;
	}

	public String getContent() {
		return this.content;
	}

	public String getDate() {
		return this.date.toString();
	}

	@Override
	public String toString() {
		return this.content;
	}
}
