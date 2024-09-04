<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn"	   uri="http://java.sun.com/jsp/jstl/functions"%>

<%
	String url = request.getRequestURL().toString();
	pageContext.setAttribute("url", url);
	
%>
<c:set var="connection_status" value="${fn:indexOf(url, 'connection_status')}"/>
<c:set var="connection_user" value="${fn:indexOf(url, 'connection_user')}"/>
<c:set var="lecture" value="${fn:indexOf(url, 'lecture')}"/>
<c:set var="lecture_list" value="${fn:indexOf(url, 'lecture_list')}"/>
<c:set var="lecture_register" value="${fn:indexOf(url, 'lecture_register')}"/>
<c:set var="status" value="${fn:indexOf(url, 'status')}"/>

<div class="lnb">
    <nav>
        <div class="nav">
            <div class="depth1 <c:if test="${user_list ne -1}">active</c:if>">
                <span><img src="/img/admin/lnb_icons/user.png" alt=""></span>
                <a href="#lnk">사용자<span><img src="/img/admin/lnb_icons/lnb-arr.png" alt=""></span></a>
            </div>
            <ul class="depth2">
                <li class="<c:if test="${user_list ne -1}">active</c:if>"><a href="/user/user_list.do">사용자 리스트</a></li>
            </ul>
        </div>
    </nav>
</div>

<script>
	function tttt() {
		alert("준비중입니다.")
	}
</script>

<script src="../../../../../js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="../../../../../js/scripts.js"></script>
<script src="../../../../../js/Chart.min.js" crossorigin="anonymous"></script>
<script src="../../../../../js/simple-datatables@latest.js" crossorigin="anonymous"></script>