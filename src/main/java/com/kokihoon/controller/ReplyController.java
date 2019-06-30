package main.java.com.kokihoon.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import main.java.com.kokihoon.common.Criteria;
import main.java.com.kokihoon.common.PageMaker;
import main.java.com.kokihoon.model.param.ReplyVO;
import main.java.com.kokihoon.service.ReplyService;


@RestController
@RequestMapping("/replies")
public class ReplyController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ReplyVO replyVO) {
	    ResponseEntity<String> entity = null;
	    try {
	        replyService.create(replyVO);
	        entity = new ResponseEntity<>("regSuccess", HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	    return entity;
	}
	
	@RequestMapping(value = "/all/{articleNo}", method = RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("articleNo") Integer articleNo) {
	    ResponseEntity<List<ReplyVO>> entity = null;
	    try {
	    	
	    	System.out.println(articleNo+"----------------------------------------5");
	    	System.out.println(replyService.getReplies(articleNo));
	        entity = new ResponseEntity<>(replyService.getReplies(articleNo), HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	    return entity;
	}
	
	@RequestMapping(value = "/{articleNo}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPaging(@PathVariable("articleNo") Integer articleNo,
	                                                      @PathVariable("page") Integer page) {

	    ResponseEntity<Map<String, Object>> entity = null;

	    try {
	    	
	        Criteria criteria = new Criteria();
	        criteria.setPage(page);
	        
	        List<ReplyVO> replies = replyService.list(articleNo, criteria);
	        System.out.println(replies+"444444444444444444444444444");
	        int repliesCount = replyService.countReplies(articleNo);

	        PageMaker pageMaker = new PageMaker(criteria);
	        pageMaker.setTotalCount(repliesCount);
	        
	        System.out.println(pageMaker+"000000000000000000000");
	        Map<String, Object> map = new HashMap<>();
	        map.put("replies", replies);
	        map.put("pageMaker", pageMaker);

	        entity = new ResponseEntity<>(map, HttpStatus.OK);

	    } catch (Exception e) {

	        e.printStackTrace();
	        entity = new ResponseEntity<>(HttpStatus.OK);

	    }

	    return entity;
	}
	
	@RequestMapping(value = "/{replyNo}", method = {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> update(@PathVariable("replyNo") Integer replyNo, @RequestBody ReplyVO replyVO) {
	    ResponseEntity<String> entity = null;
	    try {
	        replyVO.setReplyNo(replyNo);
	        replyService.update(replyVO);
	        entity = new ResponseEntity<>("modSuccess", HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	    return entity;
	}
	
	@RequestMapping(value = "/{replyNo}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("replyNo") Integer replyNo) {
	    ResponseEntity<String> entity = null;
	    try {
	        replyService.delete(replyNo);
	        entity = new ResponseEntity<>("delSuccess", HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	    return entity;
	}
}
