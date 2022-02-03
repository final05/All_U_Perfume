package com.perfume.beans;

import lombok.Data;

@Data
public class NoteDTO {
	
	private int n_number;
	private String note_eng;
	private String note_kor;
	private String note_type_name;
	private int note_type_num;
	private String n_pic;
}
