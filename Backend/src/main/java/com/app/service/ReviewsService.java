//package com.app.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.app.dao.ReviewsDao;
//import com.app.pojo.Reviews;
//
//@Service
//@Transactional
//public class ReviewsService {
//	
//	@Autowired
//	private ReviewsDao dao;
//	
//	public Reviews addReview(Reviews review) {
//		return dao.save(review);
//	}
//	
//	public Optional<Reviews> getReviewDetailsById(Long reviewId) {
//		return dao.findById(reviewId);
//	}
//	
//	public List<Reviews> getAllReviews() {
//		return dao.findAll();
//	}
//}
