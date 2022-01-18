package com.perfume.beans;

import lombok.Data;

@Data
public class PerfumeDTO {
	private int p_number;
	private int f_number;
	private String f_name;
	private String topnote;
	private String heartnote;
	private String basenote;
	private int gender;
	private int season;
	private int d_number;
	private String  f_pic;
	private String keyword;
	private int [] c_gender; 
	private int [] c_season;
	private int [] c_note;

}
