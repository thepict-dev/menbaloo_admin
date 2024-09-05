<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<!DOCTYPE html>
<html lang="ko">
	<c:import url="../main/head.jsp">
    	<c:param name="pageTitle" value="코스이력 리스트"/>
    </c:import>
    
    <body>
		<%@include file="../main/lnb.jsp" %>
		<c:import url="../main/header.jsp">
	    	<c:param name="title" value="코스이력 관리"/>
	    	<c:param name="subtitle" value="코스이력 리스트"/>
	    </c:import>
	    <div class="contentsContainer">
	        <div class="listContainer">
	            <div class="listInner">
	                <form action="" class="countList" id="search_fm" name="search_fm" method="get">
	                    <p>총 <span>${board_cnt}</span>개</p>
	                    <div class="inputsContainer">
	                        <div class="inputBox listSearch">
	                            <input type="text" name="search_text" id="search_text" placeholder="내용을 입력하세요…" value="${pictVO.search_text}">
	                            <a href="#lnk" onclick="search_list();"><img src="/img/admin/search2.png" alt=""></a>
	                        </div>
	                    </div>
	                </form>
	                <div class="ListWrpper">
	                    <ul class="listHead history">
	                        <li>순서</li>
	                        <li>성명</li>
	                        <li>시작일시</li>
	                        <li>종료일시</li>
	                        <li>걸음수</li>
	                        <li>등록일</li>
	                        <li>이미지확인</li>
	                        <li>삭제</li>
	                    </ul>
	                    <ul class="listBody history">
	                    	<c:forEach var="resultList" items="${resultList}" varStatus="status">
		                        <li>
		                            <p>${status.count}</p>
		                            <p>${resultList.nickname}</p>
		                            <p>${resultList.start}</p>
		                            <p>${resultList.end}</p>
		                            <p>${resultList.steps}</p>
		                            <p>${resultList.created_at}</p>
		                            <a href="#lnk" onclick="img_show('${resultList.image}')">이미지 확인</a>
		                            <p class="delete"><a href="#lnk" onclick="menbal_del('${resultList.idx}')"></a></p>
		                        </li>
	                        </c:forEach>
	                    </ul>
	                    <!-- 
	                    <div class="listButton">
	                        <a href="/user_register.do"><img src="/img/admin/add.png" alt="등록버튼">등록</a>
	                    </div>
	                     -->
	                    <div class="pagination">
	                    	<c:if test="${pictVO.pageNumber ne 1}">
								<li><a href="/history/history_list.do?search_text=${param.search_text}&pageNumber=${pictVO.pageNumber - 10 < 1 ? 1 : pictVO.pageNumber - 10}"><img src="/img/admin/prev.png" alt=""></a></li>
							</c:if>	
							
							<c:forEach var="i" begin="${pictVO.startPage}" end="${pictVO.endPage}">
								<c:if test="${i eq pictVO.pageNumber}">
									<li class="active"><a href="/history/history_list.do?search_text=${param.search_text}&pageNumber=${i}" >${i}</a></li>
								</c:if>
								<c:if test="${i ne pictVO.pageNumber}">
									<li><a href="/history/history_list.do?search_text=${param.search_text}&pageNumber=${i}" >${i}</a></li>
								</c:if>
							</c:forEach>	
	                    
		                    <c:if test="${pictVO.lastPage ne pictVO.pageNumber}">
								<li><a href="/history/history_list.do?search_text=${param.search_text}&pageNumber=${pictVO.pageNumber + 10 > pictVO.lastPage ?  pictVO.lastPage : pictVO.pageNumber + 10}"><img src="/img/admin/next.png" alt=""></a></li>
							</c:if>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	    <form action="" id="register" name="register" method="post" enctype="multipart/form-data">
			<input type='hidden' name="idx" id="idx" value='' />
			
		</form>
		<%@include file="../main/modal/img_modal.jsp" %>
	</body>
	<script>
		function img_show(img_url){
			if(img_url == '' || img_url == null || img_url == undefined){
				alert("등록된 이미지가 없습니다.")
				return false;
			}
			$('#imgModalWrapper').css("display", "flex");
			$('#modal_img').attr("src", img_url)
		}
		function search_list(){
			$("#search_fm").attr("action", "/history/history.do");
			$("#search_fm").submit();
		}
		function menbal_del(idx){
			if (confirm("해당 코스이력을 삭제 하시겠습니까?")) {
				$('#idx').val(idx)
				$("#register").attr("action", "/history/history_del.do");
				$("#register").submit();
			}
		}

		
	</script>
</html>