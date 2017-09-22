package com.sky.dao;

import java.sql.SQLException;
import java.util.List;

import com.sky.domain.Shop;


public interface ShopDao {
   /**
    * 获取好数据库中数据的总条数
    * @return
    * @throws SQLException
    */
	public long QueryTotalCount() throws SQLException ;
	/**
	 * 
	 * @param pageNo：第几页，
	 * @param pageSize 每页多少条数据
	 * @return
	 * @throws SQLException
	 */
	public List<Shop> QueryDataByPage(int pageNo, int pageSize) throws SQLException;
}
