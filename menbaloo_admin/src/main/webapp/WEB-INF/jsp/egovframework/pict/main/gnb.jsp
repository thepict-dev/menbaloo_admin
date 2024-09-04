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


<c:set var="gnb" value="${fn:indexOf(url, 'gnb')}"/>
<c:set var="intro" value="${fn:indexOf(url, 'intro')}"/>

<c:set var="user_list" value="${fn:indexOf(url, 'user_list')}"/>
<c:set var="user_register" value="${fn:indexOf(url, 'user_register')}"/>

<c:set var="board_list" value="${fn:indexOf(url, 'board_list')}"/>
<c:set var="board_register" value="${fn:indexOf(url, 'board_register')}"/>

<c:set var="event_list" value="${fn:indexOf(url, 'event_list')}"/>
<c:set var="event_register" value="${fn:indexOf(url, 'event_register')}"/>

<c:set var="popup_list" value="${fn:indexOf(url, 'popup_list')}"/>
<c:set var="popup_register" value="${fn:indexOf(url, 'popup_register')}"/>

<c:set var="status_list" value="${fn:indexOf(url, 'status_list')}"/>

<nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
    <div class="sb-sidenav-menu">
        <div class="nav">
        	
            <a class="nav-link" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts1" aria-expanded="true" aria-controls="collapseLayouts1">
				게시판관리
            </a>
            <div class="collapse <c:if test="${board_register ne -1}">show</c:if>" id="collapseLayouts1" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link <c:if test="${board_register ne -1}">active</c:if>" href="/board/board_register.do">게시물 등록</a>
                </nav>
            </div>
            <div class="collapse <c:if test="${board_list ne -1}">show</c:if>" id="collapseLayouts1" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link <c:if test="${board_list ne -1}">active</c:if>" href="/board/board_list.do">게시물 리스트</a>
                </nav>
            </div>
            
            <a class="nav-link" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts2" aria-expanded="true" aria-controls="collapseLayouts2">
				이벤트관리
            </a>
            <div class="collapse <c:if test="${event_register ne -1}">show</c:if>" id="collapseLayouts2" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link <c:if test="${event_register ne -1}">active</c:if>" href="/event/event_register.do">이벤트 등록</a>
                </nav>
            </div>
            <div class="collapse <c:if test="${event_list ne -1}">show</c:if>" id="collapseLayouts2" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link <c:if test="${event_list ne -1}">active</c:if>" href="/event/event_list.do">이벤트 리스트</a>
                </nav>
            </div>
            
            <a class="nav-link" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts3" aria-expanded="true" aria-controls="collapseLayouts3">
				팝업관리
            </a>
            <div class="collapse <c:if test="${popup_register ne -1 }">show</c:if>" id="collapseLayouts3" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link <c:if test="${popup_register ne -1}">active</c:if>" href="/popup/popup_register.do">팝업 등록</a>
                </nav>
            </div>
            <div class="collapse <c:if test="${popup_list ne -1 }">show</c:if>" id="collapseLayouts3" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link <c:if test="${popup_list ne -1}">active</c:if>" href="/popup/popup_list.do">팝업 리스트</a>
                </nav>
            </div>
            
            <a class="nav-link" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts4" aria-expanded="true" aria-controls="collapseLayouts4">
				통계관리
            </a>
            <div class="collapse <c:if test="${status_list ne -1 }">show</c:if>" id="collapseLayouts4" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link <c:if test="${status_list ne -1}">active</c:if>" href="/status/status_list.do">통계 리스트</a>
                </nav>
            </div>
         
		</div>
	</div>
</nav>
<script>
	function tttt() {
		alert("준비중입니다.")
	}
</script>

<script src="../../../../../js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="../../../../../js/scripts.js"></script>
<script src="../../../../../js/Chart.min.js" crossorigin="anonymous"></script>
<script src="../../../../../js/simple-datatables@latest.js" crossorigin="anonymous"></script>