package com.sky.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sky.domain.ShopBean;
import com.sky.service.ShopService;
import com.sky.service.impl.ShopServiceImpl;

import net.sf.json.JSONObject;

public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String pageNo1 = request.getParameter("pageNo");
		String pageSize1 = request.getParameter("pageSize");
		int pageNo = Integer.parseInt(pageNo1);
		int pageSize = Integer.parseInt(pageSize1);
		// TODO Auto-generated catch block
		ShopService shopService = new ShopServiceImpl();
		try {
			ShopBean shopBean = shopService.getDataByPage(pageNo, pageSize);
			response.getWriter().write(JSONObject.fromObject(shopBean).toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
