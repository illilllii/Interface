package com.cos.movie.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class SaveReqDto {
	private String title;
	private double rating;
	private Timestamp makeDate;
}
