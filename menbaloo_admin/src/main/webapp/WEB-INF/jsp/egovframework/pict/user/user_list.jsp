<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<!DOCTYPE html>
<html lang="ko">
	<c:import url="../main/header.jsp">
    	<c:param name="pageTitle" value="사용자 리스트"/>
    </c:import>
    
    <body class="sb-nav-fixed">
        <%@include file="../main/navigation.jsp" %>
        <div id="layoutSidenav">
	        <div id="layoutSidenav_nav">
				<%@include file="../main/gnb.jsp" %>
			</div>
			
			<div id="layoutSidenav_content">
				<main class="contents">
					<h2 class="contents-title">사용자 리스트</h2>
					<div class="contents-box">
						<div class="card">
						    <div class="card-body">
							    <div class="search-form">
							    	<form action="" id="search_fm" name="search_fm" method="get" class="search-box">
								    	<input type="text" id="search_text" name="search_text" value="${pictVO.search_text}" class="input" placeholder="검색어를 입력하세요." autocomplete="off">
								    	<button type="button" onclick="search();" class="btn"><i class="fa-solid fa-magnifying-glass"></i></button>
							    	</form>
							    </div>
						    	<div class="tbl-basic tbl-hover">
							        <table style="text-align : left">
							        	<colgroup>
							        		<col style="width:10%;">
							        		<col style="width:20%;">
							        		<col style="width:20%;">
							        		<col style="width:15%;">
							        		<col style="width:15%;">
							        		<col style="width:10%;">
							        		<col style="width:10%;">
							        	</colgroup>
							            <thead>
							                <tr class="thead">
							                    <th>순서</th>
							                    <th>소속</th>
							                    <th>연락처</th>
							                    <th>아이디</th>
							                    <th>이름</th>
							                    <th>초기화</th>
							                    <th>삭제</th>
							                </tr>
							            </thead>
							            <tbody>
								            <c:forEach var="resultList" items="${resultList}" varStatus="status">
								                <tr>
							                    	<td>${status.count}</td>
							                    	<td>${resultList.depart}</td>
							                    	<td>${resultList.mobile}</td>
							                    	<td class="opt-tl"><a href="javascript:void(0);" onclick="user_mod('${resultList.idx}');" class="link">${resultList.id}</a></td>
							                    	<td class="opt-tl"><a href="javascript:void(0);" onclick="user_mod('${resultList.idx}');" class="link">${resultList.nick_name}</a></td>
							                    	<td>
							                    		<button type="button" onclick="javascript:user_reset('${resultList.idx}', '${resultList.id}')" class="btn-basic btn-fill btn-sm">초기화</button>
									            	</td>
							                    	<td>
							                    		<button type="button" onclick="javascript:user_delete('${resultList.idx}')" class="btn-basic btn-fill btn-sm">삭제</button>
									            	</td>
								                </tr>
							                </c:forEach>
							            </tbody>
						            </table>
				            	</div>
				            </div>
			            </div>
		            </div>
		            <!-- <div style="float : right; margin-right: 20%">
			            <button type="button" id="button1" onclick="board_list();">게시글 리스트</button>
		            </div> -->
				</main>
			</div>
		</div>
		<form action="" id="register" name="register" method="post" enctype="multipart/form-data">
			<input type='hidden' name="idx" id="idx" value='' />
			<input type='hidden' name="id" id="id" value='' />
			<input type='hidden' name="use_at" id="use_at" value='' />
			<input type='hidden' name="type" id="type" value='' />
		</form>
		<script>

			function user_mod(idx){
				location.href= "/user/user_register.do?idx="+ idx;
			}
			function user_list(){
				location.href= "/user/user_list.do";
			}
			function user_reset(idx, id) {
				if (confirm("비밀번호를 초기화 하시겠습니까?")) {
					$('#idx').val(idx)
					$('#id').val(id)
					$("#register").attr("action", "/user/user_reset.do");
					$("#register").submit();
				}
			}
			function user_delete(idx) {
				if (confirm("삭제 하시겠습니까?")) {
					$('#idx').val(idx)
					$("#register").attr("action", "/user/user_delete.do");
					$("#register").submit();
				}
			}
			function search(){
				$("#search_fm").attr("action", "/user/user_list.do");
				$("#search_fm").submit();
			}
		</script>
            
		<script src="../../../../../js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
		<script src="../../../../../js/scripts.js"></script>
		<script src="../../../../../js/Chart.min.js" crossorigin="anonymous"></script>
		<script src="../../../../../js/simple-datatables@latest.js" crossorigin="anonymous"></script>
		
    </body>
</html>