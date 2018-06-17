package org.wecancodeit.reviewsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ReviewSiteController {

	@Autowired
	ReviewSiteRepository reviewRepository;
	
	@RequestMapping ("/reviews")
	public String getReviews(Model model) {
		model.addAttribute("reviews", reviewRepository.getReviews());
		return "reviews";
	}
	@RequestMapping ("/reviews/{id}")
	public String getReview(@PathVariable(name = "id")Long id, Model model) {
		model.addAttribute("review", reviewRepository.findById(id));
		return "review";
	}



}
