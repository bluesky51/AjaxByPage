<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="org.apache.commons.dbutils.*"
	import="org.apache.commons.dbutils.handlers.*" import="com.sky.utils.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
input[type='button'] {
	border: 1px solid gray;
	background-color: #ffffff;
	width: 50px;
	height: 30px;
	color: gray;
}
</style>
<script type="text/javascript">
	var pageNo = 1;
	var totalPage = 1;
	var current_input;
	window.onload = function() {
		current_input = document.getElementById("ww");
		test1(1);
	}

	function test1(current_page) {
		var xhr = null;
		if (window.XMLHttpRequest) {
			xhr = new XMLHttpRequest();
		} else {
			xhr = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xhr.open("post", "ShowServlet?pageNo=" + current_page + "&pageSize=10");
		xhr.send();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				if (xhr.status == 200) {
					var result = xhr.responseText;
					var res = JSON.parse(result);
					pageNo = res.pageNo;
					totalPage = res.totalPage;
					var startPage = res.startPage;
					var endPage = res.endPage;

					var qq = document.getElementById("qq");
					var result = "";
					for (var i = startPage; i <= endPage; i++) {
						result += "<a href='javascript:void(0);' onclick='test3(this)'"
								+ " style='border: 1px solid gray;";
						if (i == pageNo) {
							result += "background-color: #00ff00;"
						} else {
							result += "background-color: #ffffff;"
						}
						result += "display:inline-block; text-align:center;line-height:20px;"
								+ "width:40px;height: 20px;color: gray;text-decoration:none;font-size:15px;'"
								+ ">" + i + "</a>&nbsp;&nbsp;&nbsp;";
					}
					qq.innerHTML = result;

					var ss = document.getElementById("ss");
					ss.innerHTML = pageNo + "/" + totalPage;

					current_input.value = pageNo;
					var lists = res.list;

					var s = "<table width='70%'><tr><td>名称</td><td>价格</td><td>分类</td></tr>"
					for (var i = 0; i < lists.length; i++) {
						s += "<tr><td>" + lists[i].name + "</td><td>"
								+ lists[i].price + "</td><td>"
								+ lists[i].category + "</td></tr>";
					}
					s += "</table>";
					var divs = document.getElementById("content");
					divs.innerHTML = s;
				}
			}
		}
	}
	/*  */
	function test3(a2) {
		pageNo = a2.innerHTML;
		test1(pageNo);
	}

	/* 下一页 */
	function testNext() {
		if (pageNo >= totalPage) {
			pageNo = totalPage;
		} else {
			pageNo = pageNo + 1;
		}
		test1(pageNo);
	}
	/* 上一页 */
	function testPre() {
		if (pageNo == 1) {
			pageNo = 1;
		} else {
			pageNo = pageNo - 1;
		}
		test1(pageNo);
	}
	/* 尾页 */
	function testLast() {
		test1(totalPage);
	}
	/* 跳转到指定页 */
	function test2() {
		var count = document.getElementById("ww").value;
		pageNo = count;
		test1(count);
	}
</script>
</head>
<body>

	<div id="qq"></div>

	<div id="content"></div>
	<input type="button" value="首页" onclick="test1(1)" />
	<input type="button" value="上一页" onclick="testPre()" />
	<span id="ss"></span>
	<input type="button" value="下一页" onclick="testNext()" />
	<input type="button" value="尾页" onclick="testLast()" /> 跳转到

	<input type="text" value="1" id="ww"
		style="width: 50px; height: 30px; text-align: center; border: 1px solid gray;" />
	页
	<input type="button" value="确定" onclick="test2()" />
</body>
</html>