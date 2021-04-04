package com.devsuperior.hrpayroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.hrpayroll.client.WorkerFeigClient;
import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;



@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeigClient client;
	
	public Payment getPayment(long workerId , int day) {
		
		Worker w = client.findById(workerId).getBody();
		return new Payment(w.getName(),w.getDailyIncome(), day);
	}

}
