package com.satishlabs.bookprice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookPriceController {

	@Value(value="${server.port}")
	String serverPort;

	@GetMapping("/bookPrice/{bookId}")
	public BookPriceInfo getBookPrice(@PathVariable Integer bookId) {

		System.out.println("==BookPriceController ===  getBookPrice()===");

		BookPriceInfo bookPriceInfo = new BookPriceInfo(bookId, 2500, 20, serverPort);
		return bookPriceInfo;
	}
}
