package com.devsuperior.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/payments")
public class PaymentResource {
	
	
	@Autowired
	private PaymentService serv;
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping("/{workerId}/days/{day}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId,@PathVariable Integer day ){
		Payment paym = serv.getPayment(workerId, day);
		
		return ResponseEntity.ok(paym);
		
	}
	
	public ResponseEntity<Payment> getPaymentAlternative( Long workerId, Integer day){
		Payment paym = new Payment("brann", 800.0, day);
		return ResponseEntity.ok(paym);
		
	}
	

}
