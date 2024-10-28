package com.neuedu.cj.service;

import java.util.List;

import com.neuedu.cj.dao.StationDao;
import com.neuedu.cj.model.PageBean;
import com.neuedu.cj.model.Station;

public class StationService {
	/**
	 * 业务层分页查询商品的方法
	 * @param currPage
	 * @return
	 * @throws Exception 
	 */
	public PageBean finByPage(int currPage) throws Exception {
		PageBean pageBean = new PageBean();
		//设置PageBean的参数:
		//设置当前页数:
		pageBean.setCurrPage(currPage);
		//设置媒体显示的记录数:
		int pageSize=10;
		pageBean.setPageSize(pageSize);
		//设置总记录数:
		StationDao stationDao = new StationDao();
		int totalCount =stationDao.finCount();
		pageBean.setTotalCount(totalCount);
		//设置总页数:
		/*int totalPage =0;
		if (totalCount % pageSize==0){
			totalPage = totalCount / pageSize;
		}else{
			totalPage = totalCount / pageSize+1;
		}*/
		double tc=totalCount;
		//引用对象可以直接转成Int
		Double totalpage = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(totalpage.intValue());
		//设置每页显示的数据的集合;
		//需要传入从哪里到哪里，第一页显示就是（当前页码-1）*pageSize()
		int begin = (currPage-1)*pageSize;
	
		List<Station> list = stationDao.findbypage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

}
