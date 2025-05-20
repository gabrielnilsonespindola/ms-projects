package com.gabrielespindola.hr_payroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gabrielespindola.hr_payroll.entities.Payment;
import com.gabrielespindola.hr_payroll.entities.Worker;
import com.gabrielespindola.hr_payroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	

	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(long workerId, int days) {
	
		
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
