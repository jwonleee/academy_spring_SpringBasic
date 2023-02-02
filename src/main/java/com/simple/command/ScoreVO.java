package com.simple.command;

public class ScoreVO {

	private String name;
	private String kor;
	private String eng;
	
	public ScoreVO() {
		// TODO Auto-generated constructor stub
	}

	public ScoreVO(String name, String kro, String eng) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}
	
	@Override
	public String toString() {
		return "ScoreVO [name=" + name + ", kor=" + kor + ", eng=" + eng + "]";
	}

	//getter, setter
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
