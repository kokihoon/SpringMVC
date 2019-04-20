package main.java.com.kokihoon.controller;

import java.util.List;
import java.util.Map;

import javax.activation.CommandMap;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import main.java.com.kokihoon.model.param.BoardVO;
import main.java.com.kokihoon.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
    BoardService boardServcie;
    
    @RequestMapping(value="/list")
    public ModelAndView list() throws Exception {
        
    	List<BoardVO> list = boardServcie.listAll();
        ModelAndView mav = new ModelAndView("/board/list");
        
        mav.addObject("list", list);
        
        return mav;
        
    }
 	
}
