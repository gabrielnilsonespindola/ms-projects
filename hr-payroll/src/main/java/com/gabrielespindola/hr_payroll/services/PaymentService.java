package com.gabrielespindola.hr_payroll.services;

import org.springframework.stereotype.Service;

import com.gabrielespindola.hr_payroll.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(long workerId, int days) {
		return new Payment("Bob", 200.0, days);
	}

}
