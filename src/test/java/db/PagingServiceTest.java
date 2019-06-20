package test.java.db;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import main.java.com.kokihoon.common.Criteria;
import main.java.com.kokihoon.model.param.BoardVO;
import main.java.com.kokihoon.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:webapp/WEB-INF/root-context.xml"})
public class PagingServiceTest {
	
	@Inject
	private BoardService boardService;
	
	@Test
	public void listAllTest() throws Exception {
		Criteria cri = new Criteria();
		cri.setPage(1);
		cri.setPerPageNum(10);
		
		List<BoardVO> boards = boardService.listAll(cri);
		
		for(BoardVO board : boards) {
			System.out.println(board);
		}
	}
}
