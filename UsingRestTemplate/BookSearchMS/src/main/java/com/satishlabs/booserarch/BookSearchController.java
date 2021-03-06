package com.satishlabs.booserarch;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BookSearchController {
	
	@GetMapping("/mybook/{bookId}")
	public BookInfo getBookById(@PathVariable Integer bookId) {
		System.out.println("===BookSearchController ***  getBookById()===");
		BookInfo bookInfo = new BookInfo(bookId, "Spring Boot", "Satish", "Satish Labs", "Java");
	
		//Opton1: Using RestTemplate
				
		String baseURL = "http://localhost:9000";
		System.out.println("Base URL :"+baseURL);
		
		String endpoint = baseURL+"/bookPrice/"+bookId;
		RestTemplate restTemplate = new RestTemplate();
		
		System.out.println("endpoint :"+endpoint);
		
		ResponseEntity<BookPriceInfo> responseEntity = restTemplate.getForEntity(endpoint, BookPriceInfo.class);
		BookPriceInfo bookPriceInfo = responseEntity.getBody();
		bookInfo.setPrice(bookPriceInfo.getPrice());
		bookInfo.setOffer(bookPriceInfo.getOffer());
		bookInfo.setServerPort(bookPriceInfo.getServerPort());
		
		return bookInfo;
	}
}
