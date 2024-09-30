<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="ko">
	<c:import url="../main/head.jsp">
    	<c:param name="pageTitle" value="팝업 등록"/>
    </c:import>
    <body>
	    
		<%@include file="../main/lnb.jsp" %>
		<c:import url="../main/header.jsp">
	    	<c:param name="title" value="팝업 관리"/>
	    	<c:param name="subtitle" value="팝업 등록"/>
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
	                            <p class="inputCaption">이동링크*</p>
	                            <input type="text" name="link_url" id="link_url" placeholder="내용을 입력하세요…" value="${pictVO.link_url}">
	                        </div>
	                    </div>
	                   
	                    
	                    <div class="inputsContainer">
	                        <div class="inputBox">
	                            <p class="inputCaption">썸네일 이미지
	                                <label for="attach_file">파일추가</label>
	                                <input type="file" id="attach_file" name="attach_file" multiple style="display: none;">
	                            </p>
	                            <div class="fileList">
	                                <p></p>
	                                <button><img src="/img/admin/close2.png" alt=""></button>
	                            </div>
	                            <p class="fileCaption">첨부 파일은 10MB 아래의 확장자 파일만 가능합니다.<br>
	                                (jpeg, png, gif, bmp, tif)</p>
	                        </div>
	                    </div>
	                    
	                    <div class="btnContainer">
	                        <a href="/popup/popup_list.do" class="normalButton white">목록으로</a>
	                        <a href="#lnk" onclick="button1_click()" class="basicButton blue"><img src="/img/admin/add2.png" alt="완료">완료</a>
	                    </div>
	                    
	                    <input type='hidden' name="saveType" id="saveType" value='${pictVO.saveType}' /> 
						<input type='hidden' name="idx" id="idx" value='${pictVO.idx}' /> 
	                </form>
	            </div>
	        </div>
	    </div>
	    <script>

		 	// 파일 입력 변경 이벤트 리스너
		    $('#attach_file').on('change', function(e) {
		        var fileName = e.target.files[0].name;
		        $('.fileList p').text(fileName);
		        $('.fileList').css('display', 'flex');
		    });
	
		    // 파일 삭제 버튼 클릭 이벤트
		    $('.fileList button').on('click', function(e) {
		        e.preventDefault();
		        $('.fileList p').text('');
		        $('#attach_file').val('');
		        $('.fileList').hide();
		    });
	
		    // 초기 상태에서 fileList 숨김
		    $('.fileList').hide();
	
	    
			function button1_click() {
				var title = $('#title').val();
				
				
				
				if (title == "" || title == undefined) {
					window.alert("제목을 입력해주세요.");
					$('#title').focus();
					return false;
				}

				var text = "등록하시겠습니까?";
				if (saveType == 'update') {
					text = "수정하시겠습니까?"
				}
		
				if (confirm(text)) {
					$("#register").attr("action", "/popup/popup_save.do");
					$("#register").submit();
				}
			}
		</script>
	</body>
	
</html>