package com.craterzone.service;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface ServiceEngine 
{
	public String upload(@RequestParam(value = "file") MultipartFile file);


}
