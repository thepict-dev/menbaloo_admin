<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="ko">
	<c:import url="../main/head.jsp">
    	<c:param name="pageTitle" value="사용자 리스트"/>
    </c:import>
    <body>
	    
		<%@include file="../main/lnb.jsp" %>
		<c:import url="../main/header.jsp">
	    	<c:param name="title" value="행사 관리"/>
	    	<c:param name="subtitle" value="행사 등록"/>
	    </c:import>
	    <div class="contentsContainer">
	        <div class="listContainer">
	            <div class="listInner">
	            	<form action="" id="register" name="register" method="post" enctype="multipart/form-data" class="boardForm">
	                    <div class="inputsContainer">
	                        <div class="inputBox">
	                            <p class="inputCaption">제목*</p>
	                            <input type="text" name="title" id="title" placeholder="내용을 입력하세요…" value="${pictVO.title}">
	                        </div>
	                    </div>
	                    <div class="inputsContainer">
	                        <div class="inputBox">
	                            <p class="inputCaption">일시*</p>
	                            <input type="text" name="event_date" id="event_date" placeholder="내용을 입력하세요…" value="${pictVO.event_date}">
	                        </div>
	                    </div>
	                     <div class="inputsContainer">
	                        <div class="inputBox">
	                            <p class="inputCaption">장소*</p>
	                            <input type="text" name="address" id="address" placeholder="내용을 입력하세요…" value="${pictVO.address}">
	                        </div>
	                    </div>
	                     <div class="inputsContainer">
	                        <div class="inputBox">
	                            <p class="inputCaption">주최*</p>
	                            <input type="text" name="depart" id="depart" placeholder="내용을 입력하세요…" value="${pictVO.depart}">
	                        </div>
	                    </div>
	                     <div class="inputsContainer">
	                        <div class="inputBox">
	                            <p class="inputCaption">지역*</p>
	                            <input type="text" name="location" id="location" placeholder="내용을 입력하세요…" value="${pictVO.location}">
	                        </div>
	                    </div>
	                    <div class="inputsContainer">
	                        <div class="inputBox">
	                            <p class="inputCaption">썸네일이미지
	                                <label for="attach_file">파일추가</label>
	                                <input type="file" id="attach_file" name="attach_file" multiple style="display: none;">
	                            </p>
	                            <ul class="fileList">
	                                
	                            </ul>
	                            <p class="fileCaption">첨부 파일은 각 10MB 아래의 확장자 파일만 가능합니다.<br>
	                                (jpeg, png, gif, bmp, tif)</p>
	                        </div>
	                    </div>
	                    <div class="btnContainer">
	                        <a href="/event/event_list.do" class="normalButton white">목록으로</a>
	                        <a href="#lnk" onclick="button1_click()" class="basicButton blue"><img src="/img/admin/add2.png" alt="완료">완료</a>
	                    </div>
	                    
	                    <input type='hidden' name="saveType" id="saveType" value='${pictVO.saveType}' /> 
						<input type='hidden' name="idx" id="idx" value='${pictVO.idx}' /> 
	                </form>
	            </div>
	        </div>
	    </div>
	    <script>

			$('#event_date').datetimepicker({
				format : "Y-m-d H:i:00"
			});
			
			function button1_click() {
				var title = $('#title').val();
				var event_date = $('#event_date').val();
				var address = $('#address').val();
				var depart = $('#depart').val();
				var location = $('#location').val();
				
				
				if (title == "" || title == undefined) {
					window.alert("제목을 입력해주세요.");
					$('#title').focus();
					return false;
				}
				if (event_date == "" || event_date == undefined) {
					window.alert("일시를 입력해주세요.");
					$('#event_date').focus();
					return false;
				}
				if (address == "" || address == undefined) {
					window.alert("장소를 입력해주세요.");
					$('#address').focus();
					return false;
				}
				if (depart == "" || depart == undefined) {
					window.alert("주최를 입력해주세요.");
					$('#depart').focus();
					return false;
				}
				if (location == "" || location == undefined) {
					window.alert("지역을 입력해주세요.");
					$('#location').focus();
					return false;
				}
	
				
				var text = "등록하시겠습니까?";
				if (saveType == 'update') {
					text = "수정하시겠습니까?"
				}
		
				if (confirm(text)) {
					$("#register").attr("action", "/event/event_save.do");
					$("#register").submit();
				}
			}
		</script>
	</body>
	
</html>