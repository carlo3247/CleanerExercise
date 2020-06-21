package com.example.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.exercise.json.Input;
import com.example.exercise.json.Output;

import java.util.List;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostMapping(value = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Output> cleanerExercise(@RequestBody Input input) {
		try {
			Navigator exercise = new Navigator(input.getAreaSize(), input.getStartingPosition(), input.getOilPatches());
			int cleanedPatches = exercise.navigate(input.getNavigationInstructions());
			List<Integer> currentPosition = exercise.getCurrentPosition();
			Output output = new Output(cleanedPatches, currentPosition);
			return new ResponseEntity<Output>(output, HttpStatus.OK);
		} catch (NullPointerException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing field in JSON.", e);
		} catch (IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		} catch (IllegalStateException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown exception occured.", e);
		}
	}
}
