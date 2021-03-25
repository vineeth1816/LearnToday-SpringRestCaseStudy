package com.cognizant.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.cognizant.Model.Trainer;
@Service
public class TrainerDao {

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public boolean trainerSignUp(Trainer trainer) throws RuntimeException {
		
		int inserted ;
		try {
		inserted= jdbcTemplate.update("insert into Trainer values(?,?)", trainer.getTrainerId(),trainer.getPassword());
		}catch(RuntimeException e) {
			throw e;
		}
		return true;
		
	}

	public boolean updatePassword(int id, Trainer trainer) throws RuntimeException {
		int updated;
		try {
			updated = jdbcTemplate.update("update Trainer set Password=? where TrainerId=?",trainer.getPassword(),id);
		}catch(RuntimeException e) {
			throw e;
		}
		if(updated > 0)
			return true;
		return false;
	}
}
