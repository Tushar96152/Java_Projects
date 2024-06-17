package org.api.SpringStarter.Controller;

import java.io.File;

import org.api.SpringStarter.helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileUploadController {
     @Autowired
	private FileUploadHelper fileUploadHelper;
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> upladFile(@RequestParam("file") MultipartFile file)
	{  
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		System.out.println(file.getContentType());
//		System.out.println(file.getName());
		
		try
		{
			
		
	
		if(file.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must contain file");
		}
		//
		if(!file.getContentType().equals("image/png"))
				{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only png content file are allowed");
				}
		//file upload code..
		//where to upload file on server - > uplad_Dir=path(/bootrestbook/src/main/resources/static/image)
		
		boolean f = fileUploadHelper.uploadFile(file);
		
		  if (f) {
			//return ResponseEntity.ok("file is successfully uplaoded");
			  return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
		}
		}
		
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("somerthing went wrong try again");
	}
}
