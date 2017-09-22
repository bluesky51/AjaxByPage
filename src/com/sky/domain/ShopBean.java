package com.sky.domain;

import java.util.List;

public class ShopBean {
	public  List<Shop> list;
    public  int pageNo;
    public int totalPage;
	int startPage = 0;
	int endPage = 0;
	
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public List<Shop> getList() {
		return list;
	}
	public void setList(List<Shop> list) {
		this.list = list;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	@Override
	public String toString() {
		return "ShopBean [list=" + list + ", pageNo=" + pageNo + ", totalPage=" + totalPage + "]";
	}
    
}
