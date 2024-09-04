<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<!DOCTYPE html>
<html lang="ko">
	<c:import url="../main/head.jsp">
    	<c:param name="pageTitle" value="피드 리스트"/>
    </c:import>
    
    <body>
		<%@include file="../main/lnb.jsp" %>
		<c:import url="../main/header.jsp">
	    	<c:param name="title" value="피드 관리"/>
	    	<c:param name="subtitle" value="피드 댓글 리스트"/>
	    </c:import>
	    <div class="contentsContainer">
	        <div class="listContainer">
	            <div class="listInner">
	                
	                <div class="ListWrpper">
	                    <ul class="listHead feedreply">
	                        <li>순서</li>
	                        <li>작성자</li>
	                        <li>내용</li>
	                        <li>등록일</li>
	                        <li>삭제</li>
	                    </ul>
	                    <ul class="listBody feedreply">
	                    	<c:forEach var="resultList" items="${resultList}" varStatus="status">
		                        <li>
		                            <p>${status.count}</p>
		                            <p>${resultList.nickname}</p>
		                            <p>${resultList.comment}</p>
		                            <p>${resultList.created_at}</p>
		                            <p class="delete"><a href="#lnk" onclick="menbal_del('${resultList.idx}', '${resultList.feed_id}')"></a></p>
		                        </li>
	                        </c:forEach>
	                    </ul>
	                    
	                    <div class="listButton">
	                        <a href="/feed/feed_list.do"><img src="/img/admin/add.png" alt="등록버튼">돌아가기</a>
	                    </div>
	                   
	                </div>
	            </div>
	        </div>
	    </div>
	    <form action="" id="register" name="register" method="post" enctype="multipart/form-data">
			<input type='hidden' name="idx" id="idx" value='' />
			<input type='hidden' name="feed_id" id="feed_id" value='' />
		</form>
	</body>
	<script>


		function menbal_del(idx, feed_id){
			if (confirm("해당 댓글을 삭제 하시겠습니까?")) {
				$('#idx').val(idx)
				$('#feed_id').val(feed_id)
				
				$("#register").attr("action", "/feed/feed_reply_del.do");
				$("#register").submit();
			}
		}

		
	</script>
</html>