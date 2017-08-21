package com.chen.entity;

public class Answer {
	private int title_id;
	private String rightAnswer;
	private String userAnswer;
	private String interpret;
	private boolean isRight;
	public int getTitle_id() {
		return title_id;
	}
	public void setTitle_id(int title_id) {
		this.title_id = title_id;
	}
	public String getRightAnswer() {
		return rightAnswer;
	}
	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	public String getUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}
	public String getInterpret() {
		return interpret;
	}
	public void setInterpret(String interpret) {
		this.interpret = interpret;
	}
	public boolean isRight() {
		return isRight;
	}
	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}
	
}
