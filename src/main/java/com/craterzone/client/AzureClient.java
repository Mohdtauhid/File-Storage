package com.craterzone.client;

import java.io.IOException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.craterzone.service.FileService;
import com.craterzone.service.ServiceEngine;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.BlobContainerPublicAccessType;
import com.microsoft.azure.storage.blob.BlobRequestOptions;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.microsoft.azure.storage.blob.ListBlobItem;
@Component
@Qualifier("AzureClient")
public class AzureClient implements ServiceEngine {
	private static final Logger logger = LoggerFactory.getLogger(AzureClient.class);

	@Autowired
	private CloudBlobClient cloudBlobClient;

	@Autowired
	private CloudBlobContainer cloudBlobContainer;

	@Override
	public String upload(MultipartFile multipartFile) {
		URI uri = null;
		CloudBlockBlob blob = null;
		try {
			blob = cloudBlobContainer.getBlockBlobReference(multipartFile.getOriginalFilename());
			blob.upload(multipartFile.getInputStream(), -1);
			uri = blob.getUri();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (StorageException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return uri+"";
	}



}
