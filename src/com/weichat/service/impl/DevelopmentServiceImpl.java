package com.weichat.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.DevelopmentDao;
import com.weichat.model.Productpeoper;
import com.weichat.service.DevelopmentService;
/**
 * 建设情况业务接口的实现类
 * 
 * 
 * 项目名称：WeiChat 类名称：DevelopmentServiceImpl.java 类描述：TODO 
 * 创建人：李帅康  创建时间：下午2:24:32 
 * 修改人：李帅康  修改时间： 下午2:24:32
 * 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Service("developmentServiceImpl")
public class DevelopmentServiceImpl implements DevelopmentService {
	@Resource(name = "developmentDaoImpl")
	private DevelopmentDao developmentDao;
	
	@Override
	public List<Productpeoper> findProductpeoperById(Double id) {
		// TODO Auto-generated method stub
		return developmentDao.findProductpeoperById(id);
	}

}
