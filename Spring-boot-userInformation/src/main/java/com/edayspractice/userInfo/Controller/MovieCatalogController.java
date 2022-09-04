
package com.edayspractice.userInfo.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.edayspractice.userInfo.Repository.CatalogRepository;
import com.edayspractice.userInfo.Utils.Info;
import com.edayspractice.userInfo.Utils.ResponseTemplateVo;
import com.edayspractice.userInfo.model.CatalogItems;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/catalog/")
public class MovieCatalogController {

	org.jboss.logging.Logger log = LoggerFactory.logger(getClass());

	@Autowired
	private CatalogRepository catlogRep;

	@Autowired
	private RestTemplate restTemplate;

	/*
	 * @Autowired private RestTemplate restTemplate;
	 */

	@PostMapping(value = "/addMethod")
	public CatalogItems saveCatalog(@RequestBody CatalogItems catalogItems) {
		return catlogRep.save(catalogItems);
	}

	@GetMapping("/getCataLog/{id}")
	public Object findMovieById(@PathVariable("id") Integer userId) {
		return catlogRep.findById(userId);
	}

	@GetMapping(value = "/getCataLog")
	public List<CatalogItems> getAllCatalog() {
		List<CatalogItems> catlogList = catlogRep.findAll();
		log.info("getAllCatalog=" + catlogList);
		return catlogList;
	}
@HystrixCommand(fallbackMethod = "getFallBackCatalog")
	@GetMapping(value = "/getCataLogInfo/{id}")
	public ResponseTemplateVo getCatalogWithInfo(@PathVariable("id") Integer userId) {
		ResponseTemplateVo responseTemplateVo = new ResponseTemplateVo();
		CatalogItems user = catlogRep.findById(userId).get();
		log.info("USER Details=" + user.getDeptId());
		Info info = restTemplate.getForObject("http://department-information/api/movieInfo/" + user.getDeptId(),
				Info.class);
		log.info("Info Details=" + info);
		responseTemplateVo.setCatalogItems(user);
		responseTemplateVo.setInfo(info);
		return responseTemplateVo;
	}

	
	
	  public ResponseTemplateVo getFallBackCatalog(@PathVariable("id") Integer
	  userId) { return new ResponseTemplateVo(new
	  CatalogItems("No service is available", "", 0),new Info("No Service","")); }
	 
}
/*
 * @RequestMapping(value="/userid", method = RequestMethod.GET, produces = {
 * "application/JSON"}) public List<Object> getCatalog(@PathVariable("userid")
 * String userid){ UserRating userrating =
 * restTemplate.getForObject("http://localhost:8082/api/movieRating/"+userid,
 * UserRating.class);
 * 
 * return userrating.getUserRating().stream().map(rating-> { return
 * getCatalogItem(rating); }).collect(Collectors.toList());
 * 
 * }
 */

/*
 * @HystrixCommand(fallbackMethod ="getFallCatalog" ) private Object
 * getCatalogItem(MovieRating rating) { Movie movie =
 * restTemplate.getForObject("http://localhost:8081/api/catalog/"+rating.
 * getRating(), Movie.class); return
 * CatalogItems(movie.getName(),rating.getRating()); }
 * 
 * public List<CatalogItems> getFallCatalog(@PathVariable("userid") String
 * userid) { return Arrays.asList(new CatalogItems("No Movie", "", "")); }
 */
