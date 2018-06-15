package org.wecancodeit.reviewsite;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

public class ReviewSiteRepositoryTest {

	ReviewSiteRepository reviewRepo = new ReviewSiteRepository();

	Review review = new Review(1L, "title", "imgUrl", "catagory", "content");

	@Test
	public void shouldAddNewReviewToSiteRepo() {
		int repoSizeBeforeAdding = reviewRepo.getRepoSize();
		reviewRepo.addReview(review);
		int repoSizeAfterAdding = reviewRepo.getRepoSize();
		assertThat(repoSizeAfterAdding, is(equalTo(repoSizeBeforeAdding + 1)));
	}

	@Test
	public void shouldReturnRepoValues() {

		int actualSizeofCollection = reviewRepo.getReviews().size();
		int expectedSizeofCollection = 3;

		assertThat(actualSizeofCollection, is(equalTo(expectedSizeofCollection)));

	}
	
	@Test
	public void shouldReturnAReview() {
		for (Review review : reviewRepo.getReviews()) {
		assertTrue(review instanceof Review);
			
		}
		
	}

	@Test
	public void shouldReturnReviewById() {
		reviewRepo.addReview(review);
		Review actualReviewId = reviewRepo.findById(1L);
		Long expectedReviewId = 1L;
		
		assertThat(actualReviewId.getId(), is(equalTo(expectedReviewId)));
	}
	
}
