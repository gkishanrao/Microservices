package io.javaExpert.InfoService.Controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Optional;

import io.javaExpert.InfoService.KafkaConfigure.KafkaConfigure;
import io.javaExpert.InfoService.Model.Info;
import io.javaExpert.InfoService.Repository.InfoRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 36000)
public class InfoController {

	@Autowired
	private InfoRepository movieRep;

	@Autowired
	private KafkaTemplate<String, Info> kafkaTemplate;


	@Async
	@GetMapping(value = "/movieInfo")
	public CompletableFuture<List<Info>> getAllMovie() {
		List<Info> infoList = movieRep.findAll();
		return CompletableFuture.completedFuture(infoList);
	}

	@GetMapping("/publish/{deptName}/{deptCode}")
	public Info LoadMessageToKafka( @PathVariable("deptName") String deptName, @PathVariable("deptCode") String deptCode) {
		Info msg = new Info(deptName, deptCode);
		kafkaTemplate.send(KafkaConfigure.TestTopic, msg);
		return msg;
	}

	@PostMapping(value = "/addMethod")
	public Info saveMovie(@RequestBody Info info) {
		return movieRep.save(info);
	}

	@GetMapping("movieInfo/{id}")
	public Object findMovieById(@PathVariable("id") Integer id) {
		return movieRep.findById(id);
	}

	/*
	 * @GetMapping(value="/movieInfo" ) public List<Info> getAllMovie(){ return
	 * movieRep.findAll(); }
	 */
}
