package main.java.com.kokihoon.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.com.kokihoon.dao.BoardFileDao;

@Repository
public class BoardFileDaoImpl implements BoardFileDao {

    private static final String NAMESPACE = "main.java.com.kokihoon.mapper.BoardFileMapper";

	@Autowired
	SqlSession session;
    

    @Override
    public void addFile(String fileName) throws Exception {
    	session.insert(NAMESPACE + ".addFile", fileName);
    }
}