package org.wecancodeit.reviewsite;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service

public class ReviewSiteRepository {
 
	private  Map<Long, Review> reviewRepository = new HashMap<Long, Review>();
	
	public Map<Long, Review> getReviewRepository() {
		return reviewRepository;
	}
	
	public ReviewSiteRepository() {	
		Review item1 = new Review(2L,"Italian Pasta's","/images/traditional-italian-food-table.jpg","Fav Foods Group One", "Italian has a rich history of edible delights and traditional foods, Pasta are among the most basic staples of an Italian diet, and is a great source od carbs");
		Review item2 = new Review(3L,"Cantina Mexicana","images/mexican.jpeg","Fav Foods Group Two","Mexican food is among my personal favorites, as a generaliztion. There are many differences based on the location of where the food originated. But any way you look at it, it's all amazing");
		Review item3 = new Review(4L,"Indian House of Curry","/images/indian curry.jpg","Fav Foods Group Three","Curry is yummy in my tummy. 'Nuff Said. i mean seriously, Curry is like the 5th, 6th, and 7th food groups unto itself.");
		
		
		this.addReview(item1);
		this.addReview(item2);
		this.addReview(item3);
	}


	public void addReview(Review review) {
		reviewRepository.put(review.getId(), review);
	}

	public int getRepoSize() {
		return reviewRepository.size();
	}

	public Collection<Review> getReviews() {
		return reviewRepository.values();
	}

	public Review findById(Long id) {
		return reviewRepository.get(id);
	}

}
