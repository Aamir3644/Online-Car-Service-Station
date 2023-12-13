//package com.app.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.app.pojo.Reviews;
//import com.app.service.ReviewsService;
//
//@RestController
//@RequestMapping("/reviews")
//public class ReviewsController {
//	
//	@Autowired
//	private ReviewsService service;
//	
//	@PostMapping
//	public Reviews addReview(@RequestBody Reviews review) {
//		return service.addReview(review);
//	}
//	
//	@PutMapping
//	public Reviews updateReview(@RequestBody Reviews review)
//	{
//		service.getReviewDetailsById(review.getReviewId());
//		return service.addReview(review);
//	}
//	
//	@GetMapping
//	public List<Reviews> getAllReviews()
//	{
//		return service.getAllReviews();
//	}
//}
