package com.perfume.beans;




public class PerfumeDTO  {
	private int p_number;
	private int f_number;
	private String f_name;
	private String topnote;
	private String heartnote;
	private String basenote;
	private String gender;
	private String season;
	private String d_number;
	private String  f_pic;
	private String keyword;
	private String[] c_gender; 
	private String[] c_season;
	private String[] c_note;
	private String topnote_num;
	private String heartnote_num;
	private String basenote_num;
	private String result;
	private String name;
	private String note;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
	
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	public int getP_number() {
		return p_number;
	}
	public void setP_number(int p_number) {
		this.p_number = p_number;
	}
	
	
	public int getF_number() {
		return f_number;
	}
	public void setF_number(int f_number) {
		this.f_number = f_number;
	}
	
	
	
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	
	
	
	public String getTopnote() {
		return topnote;
	}
	public void setTopnote(String topnote) {
		this.topnote = topnote;
	}
	
	
	
	
	public String getHeartnote() {
		return heartnote;
	}
	public void setHeartnote(String heartnote) {
		this.heartnote = heartnote;
	}
	
	
	
	
	public String getBasenote() {
		return basenote;
	}
	public void setBasenote(String basenote) {
		this.basenote = basenote;
	}
	
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		if (gender == null ) {
			this.gender = "5";
			return;
		}
		this.gender = gender;
	}
	
	
	
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		if (season == null ) {
			this.season = "5";
			return;
		}
		this.season = season;
	}
	
	
	
	
	public String getD_number() {
		return d_number;
	}
	public void setD_number(String d_number) {
		this.d_number = d_number;
	}
	
	
	
	
	public String getF_pic() {
		return f_pic;
	}
	public void setF_pic(String f_pic) {
		this.f_pic = f_pic;
	}
	
	
	
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
	
	
	
	public String[] getC_gender() {
		return c_gender;
	}
	public void setC_gender(String[] c_gender) {
		this.c_gender = c_gender;
	}
	
	
	
	
	
	public String[] getC_season() {
		return c_season;
	}
	public void setC_season(String[] c_season) {
		this.c_season = c_season;
	}
	
	
	
	
	
	public String[] getC_note() {
		return c_note;
	}
	public void setC_note(String[] c_note) {
		this.c_note = c_note;
	}
	
	
	
	
	
	public String getTopnote_num() {
		return topnote_num;
	}
	public void setTopnote_num(String topnote_num) {
		this.topnote_num = topnote_num;
	}
	
	
	
	
	
	public String getHeartnote_num() {
		return heartnote_num;
	}
	public void setHeartnote_num(String heartnote_num) {
		this.heartnote_num = heartnote_num;
	}
	
	
	
	
	public String getBasenote_num() {
		return basenote_num;
	}
	public void setBasenote_num(String basenote_num) {
		this.basenote_num = basenote_num;
	}
	

	
	

}
