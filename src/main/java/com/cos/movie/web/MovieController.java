package com.cos.movie.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.movie.domain.CommonDto;
import com.cos.movie.domain.Movie;
import com.cos.movie.domain.MovieRepository;
import com.cos.movie.domain.SaveReqDto;

@RestController
public class MovieController {
	MovieRepository movieRepository;
	
	public MovieController(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	@GetMapping("/movie")
	public CommonDto<List<Movie>> findAll() {
		System.out.println("findAll()");
		return new CommonDto<>(HttpStatus.OK.value(), movieRepository.findAll());
	}
	
	@GetMapping("/movie/{id}")
	public CommonDto<Movie> findById(@PathVariable int id) {
		System.out.println("findById() : " + id);
		return new CommonDto<>(HttpStatus.OK.value(), movieRepository.findById(id));
	}
	
	@PostMapping("/movie")
	public CommonDto<String> save(@RequestBody SaveReqDto dto) {
		System.out.println("save()");
		System.out.println("save : " + dto);
		
		movieRepository.save(dto);

		return new CommonDto<String>(HttpStatus.OK.value(), "ok");
	}
	
	@DeleteMapping("/movie/{id}")
	public CommonDto<String> delete(@PathVariable int id) {
		movieRepository.delete(id);
		return new CommonDto<String>(HttpStatus.OK.value(), "ok");
	}
	
	@PutMapping("/movie/{id}")
	public CommonDto<String> update(@RequestBody SaveReqDto dto, @PathVariable int id) {
		System.out.println("update()");
		movieRepository.update(dto, id);
		
		return new CommonDto<String>(HttpStatus.OK.value(), "ok");
	}
}
