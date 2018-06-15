package org.wecancodeit.reviewsite;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service

public class ReviewSiteRepository {
 
	private  Map<Long, Review> reviewRepository = new HashMap<Long, Review>();
	
	
	public ReviewSiteRepository() {	
		Review item1 = new Review(2L,"title","url","catagory", "content");
		Review item2 = new Review(3L,"title","url","catagory","content");
		Review item3 = new Review(4L,"title","url","catagory","content");
		
		
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
