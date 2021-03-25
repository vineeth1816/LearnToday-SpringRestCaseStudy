package com.cognizant.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Model.Course;
import com.cognizant.Model.Message;
import com.cognizant.Model.Trainer;
import com.cognizant.Services.TrainerDao;

@RestController
public class TrainerController {
	@Autowired
	public TrainerDao trainerdao;
	
	@PostMapping("/api/Trainer")
	public ResponseEntity<Object> trainerSignUp(@RequestBody Trainer trainer){
		try {
		boolean newTrainer = trainerdao.trainerSignUp(trainer);
		}catch(RuntimeException e) {
			return new ResponseEntity<Object>("",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(trainer,HttpStatus.OK); 
		
	}
	
	@PutMapping("/api/Trainer/{id}")
	public ResponseEntity<Object> updatePassword(@PathVariable int id,@RequestBody Trainer trainer){
		boolean updated;
		try {
		 updated = trainerdao.updatePassword(id,trainer);
		}catch(RuntimeException e) {
			return new ResponseEntity<Object>(e,HttpStatus.BAD_REQUEST);
		}
			
		if(updated)
			return new ResponseEntity<Object>("Data updated successfully",HttpStatus.OK);
		else {
			Message m = new Message();
			m.setMessage("Searched Data not Found");
			return new ResponseEntity<Object>(m,HttpStatus.NOT_FOUND);
		}
		
	}
	

}
