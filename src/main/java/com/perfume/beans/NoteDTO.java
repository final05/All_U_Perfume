package com.perfume.beans;

import lombok.Data;

@Data
public class NoteDTO {
	
	private String n_number;
	private String note_eng;
	private String note_kor;
	private String note_type_name;
	private String[] note_type_num;
	private String n_pic;
}
