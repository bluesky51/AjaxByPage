package com.sky.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.sky.dao.ShopDao;
import com.sky.dao.impl.ShopDaoImpl;
import com.sky.domain.Shop;
import com.sky.domain.ShopBean;
import com.sky.service.ShopService;
import com.sky.utils.ManagerTransactionUtils;

public class ShopServiceImpl implements ShopService{

	ShopDao shopDao=   new  ShopDaoImpl();
	@Override
	public long getTotalCount() throws SQLException {
		// TODO Auto-generated method stub
		return shopDao.QueryTotalCount();
	}

	@Override
	public ShopBean getDataByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		ShopBean shopBean =new ShopBean();
		try {
			ManagerTransactionUtils.beginTransaction();
			shopBean.setPageNo(pageNo);
			int totalPage = (int)Math.ceil(shopDao.QueryTotalCount()/pageSize);
			shopBean.setTotalPage(totalPage);
			int startPage = 0;
			int endPage = 0;
			
			if (totalPage > 0) {        
				if (totalPage < 6) {
					startPage = 1;
					endPage = totalPage;
				} else {
					if (pageNo <4) { 
						startPage = 1;
						endPage = 5;
					} else if (totalPage - pageNo < 6) {
						startPage = totalPage - 4;
						endPage = totalPage;
					} else {
						startPage = pageNo - 2;
						endPage = pageNo + 2;
					}
				}
			}
			shopBean.setStartPage(startPage);
			shopBean.setEndPage(endPage);
			List<Shop> list =shopDao.QueryDataByPage(pageNo, pageSize);
			shopBean.setList(list);
			ManagerTransactionUtils.commitTransaction();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			ManagerTransactionUtils.rollBackTransaction();
		}
		
		return shopBean;
	}

	@Override
	public int getTotalPage(long totalCount,int pageSize) throws SQLException {
		// TODO Auto-generated method stub
		int totalPage = (int)Math.ceil(getTotalCount()/pageSize);
		return totalPage;
	}

}
