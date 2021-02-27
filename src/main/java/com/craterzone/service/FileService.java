package com.craterzone.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.craterzone.client.AWSClient;
import com.craterzone.client.AzureClient;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;

@Service
public class FileService
{
	private static final Logger logger = LoggerFactory.getLogger(FileService.class);
	
	@Autowired
	@Qualifier("AWSClient")
	private ServiceEngine awsClient;
	
	@Autowired
	@Qualifier("AzureClient")
	private AzureClient azureClient;

	public String Fileupload(MultipartFile file,String clientName){
		
		if(clientName.equals("AWS")) 
			return awsClient.upload(file);
		
		
		else if(clientName.equals("Azure")) 
			return azureClient.upload(file).toString();
		
		return "No File Upload";
	
	}
	
	
	
	
	
}
