<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- HEAD ------------------------------------------------------------------------------------ -->
<!-- head가 맨 나중?나중에 나온 요소가 레이어 맨위로... ---------------------------------------->
<header class="topnav w3-card-4" id="topNav">
	<a href="#" class="active">마켓경영</a>
	<a href="#">쇼핑하기</a>
	<a href="#">장바구니</a>
	<a href="#">마이페이지</a>
	<a href="#">로그아웃</a>
	<a href="javascript:void(0);" class="icon" onclick="responsiveMenuPopUp()">
		<i class="fa fa-bars"></i>
	</a>
</header>

<script>
	/* Toggle between adding and removing the "responsive" class to topnav when the user clicks on the icon */
	function responsiveMenuPopUp() {
		var x = document.getElementById("topNav");
		if (x.className === "topnav w3-card-4") {
			x.className += " responsive";
		} else {
			x.className = "topnav w3-card-4";
		}
	}

	window.onresize = function () {
		var x = document.getElementById("topNav");
		x.className = "topnav w3-card-4";
	}
</script>