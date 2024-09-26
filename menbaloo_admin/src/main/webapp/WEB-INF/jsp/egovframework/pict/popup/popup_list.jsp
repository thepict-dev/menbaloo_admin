<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<!DOCTYPE html>
<html lang="ko">
	<c:import url="../main/head.jsp">
    	<c:param name="pageTitle" value="팝업 리스트"/>
    </c:import>
    
    <body>
		<%@include file="../main/lnb.jsp" %>
		<c:import url="../main/header.jsp">
	    	<c:param name="title" value="팝업 관리"/>
	    	<c:param name="subtitle" value="팝업 리스트"/>
	    </c:import>
	    <div class="contentsContainer">
	        <div class="listContainer">
	            <div class="listInner">
	                <form action="" class="countList" id="search_fm" name="search_fm" method="get">
	                    <p>총 <span>${totalCnt}</span>개</p>
	                    <div class="inputsContainer">
	                        <div class="inputBox listSearch">
	                            <input type="text" name="search_text" id="search_text" placeholder="내용을 입력하세요…" value="${pictVO.search_text}">
	                            <a href="#lnk" onclick="search_list();"><img src="/img/admin/search2.png" alt=""></a>
	                        </div>
	                    </div>
	                </form>
	               
	                <div class="ListWrpper">
	                    <ul class="listHead popup">
	                        <li>순서</li>
	                        <li>제목</li>
	                        <li>링크</li>
	                        <li>이미지링크</li>
	                        <li>삭제</li>
	                    </ul>
	                    <ul class="listBody popup">
	                    	<c:forEach var="resultList" items="${resultList}" varStatus="status">
		                        <li>
		                            <p>${status.count}</p>
		                            <a href="/popup/popup_register.do?idx=${resultList.idx}"><p>${resultList.title}</p></a>
		                            <p>${resultList.link_url}</p>
		                            <a href="#lnk" onclick="img_show('${resultList.image_url}')">이미지 확인</a>
		                            <p class="delete"><a href="#lnk" onclick="menbal_del('${resultList.idx}')"></a></p>
		                        </li>
	                        </c:forEach>
	                    </ul>
	                    
	                    <div class="listButton">
	                        <a href="/popup/popup_register.do"><img src="/img/admin/add.png" alt="등록버튼">등록</a>
	                    </div>
	                    
	                    <div class="pagination">
	                    	<c:if test="${pictVO.pageNumber ne 1}">
								<li><a href="/popup/popup_list.do?search_text=${param.search_text}&pageNumber=${pictVO.pageNumber - 10 < 1 ? 1 : pictVO.pageNumber - 10}"><img src="/img/admin/prev.png" alt=""></a></li>
							</c:if>	
							
							<c:forEach var="i" begin="${pictVO.startPage}" end="${pictVO.endPage}">
								<c:if test="${i eq pictVO.pageNumber}">
									<li class="active"><a href="/popup/popup_list.do?search_text=${param.search_text}&pageNumber=${i}" >${i}</a></li>
								</c:if>
								<c:if test="${i ne pictVO.pageNumber}">
									<li><a href="/popup/popup_list.do?search_text=${param.search_text}&pageNumber=${i}" >${i}</a></li>
								</c:if>
							</c:forEach>	
	                    
		                    <c:if test="${pictVO.lastPage ne pictVO.pageNumber}">
								<li><a href="/popup/popup_list.do?search_text=${param.search_text}&pageNumber=${pictVO.pageNumber + 10 > pictVO.lastPage ?  pictVO.lastPage : pictVO.pageNumber + 10}"><img src="/img/admin/next.png" alt=""></a></li>
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
			$("#search_fm").attr("action", "/popup/popup_list.do");
			$("#search_fm").submit();
		}
		function menbal_del(idx){
			if (confirm("삭제 하시겠습니까?")) {
				$('#idx').val(idx)
				$("#register").attr("action", "/popup/popup_delete.do");
				$("#register").submit();
			}
		}
		
	</script>
</html>