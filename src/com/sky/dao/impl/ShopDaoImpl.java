package com.sky.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sky.dao.ShopDao;
import com.sky.domain.Shop;
import com.sky.utils.C3P0Utils;
import com.sky.utils.ManagerTransactionUtils;

public class ShopDaoImpl implements ShopDao {

	@Override
	public long QueryTotalCount() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		Object obj = queryRunner.query(ManagerTransactionUtils.getConnection(),"select count(*) from products", new ScalarHandler());
		long totalCount = (long) obj;
		return totalCount;
	}

	@Override
	public List<Shop> QueryDataByPage(int pageNo, int pageSize) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		int startPos = (pageNo - 1) * pageSize;
		List<Shop> list = queryRunner.query(ManagerTransactionUtils.getConnection(),
				"select * from products order by " + "id asc limit " + startPos + "," + pageSize,
				new BeanListHandler<Shop>(Shop.class));
		return list;
	}

}
