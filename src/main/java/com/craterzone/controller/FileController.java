package com.craterzone.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.craterzone.service.FileService;

@RestController
@RequestMapping("/")
public class FileController {
	@Autowired
	FileService fileService;

	@Autowired
	    FileController(FileService fileService) 
		{
	        this.fileService = fileService;
	    }

	@PostMapping
	public ResponseEntity<String> uploadFile(@RequestParam(value = "file") MultipartFile file,@RequestParam(value ="clientName") String clientName) {
		
		String Url= fileService.Fileupload(file,clientName);
		if (Url==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else
			return ResponseEntity.ok(Url);
	
	}


}