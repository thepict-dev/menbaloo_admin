<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<!DOCTYPE html>
<html lang="ko">
	<c:import url="../main/head.jsp">
    	<c:param name="pageTitle" value="사용자 리스트"/>
    </c:import>
    <body>
		<%@include file="../main/lnb.jsp" %>
		<%@include file="../main/header.jsp" %>
	    <div class="contentsContainer">
	        <div class="listContainer">
	            <div class="listInner">
	                <form action="" class="countList">
	                    <p>총 <span>10</span>개</p>
	                    <div class="inputsContainer">
	                        <div class="inputBox listSearch">
	                            <input type="text" name="" id="" placeholder="내용을 입력하세요…">
	                            <a href="#lnk"><img src="/img/admin/search2.png" alt=""></a>
	                        </div>
	                    </div>
	                </form>
	                <div class="buttons">
	                    <a href="" class="smButton"><img src="/img/admin/excel.png" alt="">엑셀 다운로드</a>
	                </div>
	                <div class="ListWrpper">
	                    <ul class="listHead">
	                        <li>순서</li>
	                        <li>카테고리</li>
	                        <li>제목</li>
	                        <li>작성자</li>
	                        <li>등록일</li>
	                        <li>삭제</li>
	                    </ul>
	                    <ul class="listBody">
	                        <li>
	                            <!-- <div class="switchInput">
	                                <input type="checkbox" name="onoff-switch" id="onoff-switch1" />
	                                <label for="onoff-switch1"></label>
	                            </div> -->
	                            <p>1</p>
	                            <p>언론에 비친 SCOUT</p>
	                            <a href="#lnk" class="title">제목목목목목목목목제목목목목목목목목ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</a>
	                            <p>한지현</p>
	                            <p>2024-06-28</p>
	                            <p class="delete"><a href="#lnk"></a></p>
	                        </li>
	                    </ul>
	                    <div class="listButton">
	                        <a href="/user_register.do"><img src="/img/admin/add.png" alt="등록버튼">등록</a>
	                    </div>
	                    <div class="pagination">
	                        <a href="#lnk"><img src="/img/admin/prev.png" alt="이전으로"></a>
	                        <a href="#lnk" class="active">1</a>
	                        <a href="#lnk">2</a>
	                        <a href="#lnk">3</a>
	                        <p>...</p>
	                        <a href="#lnk">99</a>
	                        <a href="#lnk"><img src="/img/admin/next.png" alt="다음으로"></a>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>	
	</body>
</html>