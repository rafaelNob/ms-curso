package com.devsuperior.hrworker.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;


@RefreshScope
@RestController
@RequestMapping("/workers")
public class WorkerController {
	
	private static final Logger logger = LoggerFactory.getLogger(WorkerController.class);
	@Autowired
	private WorkerRepository rep;
	
	@Value("${test.config}")
	private String valor;
	
	@GetMapping("/configs")
	public ResponseEntity<Void> config() {
		logger.info("LOGGERR " + valor);
		return ResponseEntity.noContent().build();

	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		return ResponseEntity.ok(rep.findAll());

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		return ResponseEntity.ok(rep.findById(id).get());

	}

}
