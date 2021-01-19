package com.cos.movie.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {
	List<Movie> movies = new ArrayList<>();
	int count = 1;
	public List<Movie> findAll() {
		return movies;
	}

	public Movie findById(int id) {
		for (Movie movie : movies) {
			if(id==movie.getId()) {
				return movie;
			}
		}
		return null;
	}

	public void save(SaveReqDto dto) {
		String title = dto.getTitle();
		double rating = dto.getRating();
		Timestamp makeDate = dto.getMakeDate();
		movies.add(new Movie(count, title, rating, makeDate));
		count++;

	}
	
	public void delete(int id) {
		movies.removeIf(movie -> movie.getId() == id);
	}
	
	public void update(SaveReqDto dto, int id) {
		String title = dto.getTitle();
		double rating = dto.getRating();
		Timestamp makeDate = dto.getMakeDate();
		for (int i = 0; i < movies.size(); i++) {
			if(movies.get(i).getId() == id) {
//				movies.get(i).setTitle(title);
//				movies.get(i).setRating(rating);
//				movies.get(i).setMakeDate(makeDate);
				if(dto.getTitle() != null || dto.getTitle() != "") {
					movies.get(i).setTitle(title);
				}
				if(dto.getRating() > 0.0) {
					movies.get(i).setRating(rating);
				}
				if(dto.getMakeDate() != null) {
					movies.get(i).setMakeDate(makeDate);
				}
				
				break;
			}
		}
		
		
	}

}
