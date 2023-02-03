package com.simple.command;

public class ScoreVO {

	private int num;
	private String name;
	private String kor;
	private String eng;
	
	public ScoreVO() {
		// TODO Auto-generated constructor stub
	}

	public ScoreVO(int num, String name, String kor, String eng) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKor() {
		return kor;
	}

	public void setKor(String kor) {
		this.kor = kor;
	}

	public String getEng() {
		return eng;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}
	
}
