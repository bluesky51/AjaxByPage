package com.sky.service;

import java.sql.SQLException;
import com.sky.domain.ShopBean;

public interface ShopService {
	/**
	 * 获取好数据库中数据的总条数
	 * 
	 * @return
	 * @throws SQLException
	 */
	public long getTotalCount() throws SQLException;

	/**
	 * 
	 * @param pageNo：第几页，
	 * @param pageSize
	 *            每页多少条数据
	 * @return
	 * @throws SQLException
	 */
	public ShopBean getDataByPage(int pageNo, int pageSize) throws SQLException;

	/**
	 * 获取总页数
	 * @param totalCount
	 * @param pageSize
	 * @return
	 * @throws SQLException
	 */
	public int getTotalPage(long totalCount,int pageSize) throws SQLException;

}
