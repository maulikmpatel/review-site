package org.wecancodeit.reviewsite;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewSiteController.class)

public class ReviewSiteControllerTest {

	@Resource
	MockMvc mvc;
	@MockBean
	ReviewSiteRepository reviewRepo;
	@Mock
	Review review;

	ReviewSiteController controller = new ReviewSiteController();

	@Test
	public void shouldReturnReviews() throws Exception {
		mvc.perform(get("/reviews"))
			.andExpect(view()
				.name(is(equalTo("reviews"))));
	}
	@Test
	public void shouldReturn2xxSuccessReviews() throws Exception{
		mvc.perform(get("/reviews"))
			.andExpect(status()
					.is2xxSuccessful());
		
	}
	@Test
	public void shouldReturnAllReviews() throws Exception {
		mvc.perform(get("/reviews"))
			.andExpect(model()
			.attribute("reviews", reviewRepo.getReviews()));
	}
	@Test
		public void geteviewShouldReturnReviewView() throws Exception {
			mvc.perform(get("/reviews/42")).andExpect(view().name(is(equalTo("review"))));
		}
	@Test
		public void getReviewShouldBeOk() throws Exception {
			mvc.perform(get("/reviews/42")).andExpect(status().is2xxSuccessful());
		}
	@Test
		public void getReviewShouldReturnOneReview() throws Exception {
			mvc.perform(get("/reviews/2")).andExpect(model().attribute("review", is(reviewRepo.findById(2L))));
		}
	
}
