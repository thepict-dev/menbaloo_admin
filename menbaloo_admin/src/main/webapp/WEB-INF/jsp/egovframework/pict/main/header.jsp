<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="header">
    <div class="headerTop">
        <h1><a href="/"><span>경</span></a></h1>
        <div class="headerInner">
            <p class="proTitle">프로젝트 대표 이름 예를들어 지역혁신플랫폼</p>
            <div class="profileWrap">
                <div class="profile">
                    <div class="profileTexts">
                        <p>한지현</p>
                        <span>클라이언트명<span>•</span>관리자</span>
                    </div>
                </div>
                <div class="topBtns">
                    <a href=""><img src="/img/admin/logout.png" alt="">로그아웃</a>
                    <a href="">홈페이지 바로가기</a>
                </div>
            </div>
        </div>
    </div>
    <div class="breadCrumb">
        <ul class="crumb">
            <li>사용자</li>
            <li>사용자 리스트</li>
        </ul>
    </div>
</div>


<script>
	function fn_logout() {
		if(confirm("로그아웃 하시겠습니까?")){
			location.href="/logout.do"
		}
	}
</script>