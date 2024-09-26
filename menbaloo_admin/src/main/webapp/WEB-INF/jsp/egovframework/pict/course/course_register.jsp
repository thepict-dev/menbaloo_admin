<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="ko">
	<c:import url="../main/head.jsp">
    	<c:param name="pageTitle" value="코스 등록"/>
    </c:import>
    <body>
	    
		<%@include file="../main/lnb.jsp" %>
		<c:import url="../main/header.jsp">
	    	<c:param name="title" value="코스 관리"/>
	    	<c:param name="subtitle" value="코스 등록"/>
	    </c:import>
	    <div class="contentsContainer">
	        <div class="listContainer">
	            <div class="listInner">
	            	<form action="" id="register" name="register" method="post" enctype="multipart/form-data" class="boardForm">
	                    <div class="inputsContainer">
	                        <div class="inputBox">
	                            <p class="inputCaption">행정구역*</p>
	                            <select name="administrative" id="administrative" class="lgThinInput">
	                                <option value="강원특별자치도" <c:if test="${pictVO.administrative eq '강원특별자치도'}">selected</c:if>>강원특별자치도</option>
	                            </select>
	                        </div>
	                    </div>
	                    <div class="inputsContainer">
	                        <div class="inputBox">
	                            <p class="inputCaption">기초행정구역*</p>
	                            <select name="local" id="local" class="lgThinInput">
	                                <option value="춘천" <c:if test="${pictVO.local eq '춘천'}">selected</c:if>>춘천</option>
	                                <option value="속초" <c:if test="${pictVO.local eq '속초'}">selected</c:if>>속초</option>
	                                <option value="양양" <c:if test="${pictVO.local eq '양양'}">selected</c:if>>양양</option>
	                                <option value="원주" <c:if test="${pictVO.local eq '원주'}">selected</c:if>>원주</option>
	                                <option value="강릉" <c:if test="${pictVO.local eq '강릉'}">selected</c:if>>강릉</option>
	                                <option value="고성" <c:if test="${pictVO.local eq '고성'}">selected</c:if>>고성</option>
	                            </select>
	                        </div>
	                    </div>
	                    <div class="inputsContainer">
	                        <div class="inputBox">
	                            <p class="inputCaption">관리 지회*</p>
	                            <select name="management" id="management" class="lgThinInput">
	                                <option value="1" <c:if test="${pictVO.management eq '1'}">selected</c:if>>춘천시지회</option>
	                                <option value="2" <c:if test="${pictVO.management eq '2'}">selected</c:if>>속초시지회</option>
	                                <option value="3" <c:if test="${pictVO.management eq '3'}">selected</c:if>>양양군지회</option>
	                                <option value="4" <c:if test="${pictVO.management eq '4'}">selected</c:if>>원주시지회</option>
	                                <option value="5" <c:if test="${pictVO.management eq '5'}">selected</c:if>>강릉시지회</option>
	                                <option value="6" <c:if test="${pictVO.management eq '6'}">selected</c:if>>고성군지회</option>
	                            </select>
	                        </div>
	                    </div>
	                     <div class="inputsContainer">
	                        <div class="inputBox">
	                            <p class="inputCaption">코스명*</p>
	                            <input type="text" name="title" id="title" placeholder="내용을 입력하세요…" value="${pictVO.title}">
	                        </div>
	                    </div>
	                     <div class="inputsContainer">
	                        <div class="inputBox">
	                            <p class="inputCaption">주소*</p>
	                            <input type="text" name="address" id="address" placeholder="내용을 입력하세요…" value="${pictVO.address}">
	                        </div>
	                    </div>
	                    <div class="inputsContainer">
	                        <div class="inputBox">
	                            <p class="inputCaption">코스거리*</p>
	                            <input type="text" name="length" id="length" placeholder="미터단위로 입력 ex) 100m -> 100" value="${pictVO.length}">
	                        </div>
	                    </div>
	                    
	                    <div class="inputBox">
	                        <p class="inputCaption">내용*</p>
							<textarea rows="30" cols="50" id="introduce" name="introduce">${pictVO.introduce}</textarea>
	                    </div>
	                    
	                    <div class="inputsContainer">
	                        <div class="inputBox">
	                            <p class="inputCaption">코스종류*</p>
	                            <select name="course_type" id="course_type" class="lgThinInput">
	                                <option value="1" <c:if test="${pictVO.course_type eq '1'}">selected</c:if>>숲길</option>
	                                <option value="2" <c:if test="${pictVO.course_type eq '2'}">selected</c:if>>공원</option>
	                                <option value="3" <c:if test="${pictVO.course_type eq '3'}">selected</c:if>>바다</option>
	                                <option value="4" <c:if test="${pictVO.course_type eq '4'}">selected</c:if>>하천</option>
	                                <option value="5" <c:if test="${pictVO.course_type eq '5'}">selected</c:if>>기타</option>
	                            </select>
	                        </div>
	                    </div>
	                    
	                    <div class="inputsContainer">
	                        <div class="inputBox">
	                            <p class="inputCaption">흙종류*</p>
	                            <select name="send_type" id="send_type" class="lgThinInput">
	                                <option value="1" <c:if test="${pictVO.send_type eq '1'}">selected</c:if>>황토</option>
	                                <option value="2" <c:if test="${pictVO.send_type eq '2'}">selected</c:if>>모래</option>
	                                <option value="3" <c:if test="${pictVO.send_type eq '3'}">selected</c:if>>마사토</option>
	                                <option value="4" <c:if test="${pictVO.send_type eq '4'}">selected</c:if>>잔디</option>
	                                <option value="5" <c:if test="${pictVO.send_type eq '5'}">selected</c:if>>기타</option>
	                            </select>
	                        </div>
	                    </div>
	                    
	                    <div class="inputsContainer">
	                        <div class="inputBox">
	                            <p class="inputCaption">화장실유무*</p>
	                            <input type="checkbox" name="toilet" id="toilet" value="O" <c:if test="${pictVO.toilet eq 'O'}">checked</c:if>><label for="toilet">화장실</label>
	                        </div>
	                    </div>
	                    
	                    <div class="inputsContainer">
	                        <div class="inputBox">
	                            <p class="inputCaption">세족실유무*</p>
	                            <input type="checkbox" name="foot" id="foot" value="O" <c:if test="${pictVO.foot eq 'O'}">checked</c:if>><label for="foot">세족실</label>
	                        </div>
	                    </div>
	                    
	                    <div class="inputsContainer">
	                        <div class="inputBox">
	                            <p class="inputCaption">VR주소</p>
	                            <input type="text" name="vr_link" id="vr_link" placeholder="https:// 포함입력" value="${pictVO.vr_link}">
	                        </div>
	                    </div>
	                    
	                    <div class="inputsContainer">
	                        <div class="inputBox">
	                            <p class="inputCaption">썸네일 이미지
	                                <label for="attach_file">파일추가</label>
	                                <input type="file" id="attach_file" name="attach_file" multiple style="display: none;">
	                            </p>
	                            <ul class="fileList">
	                                
	                            </ul>
	                            <p class="fileCaption">첨부 파일은 각 10MB 아래의 확장자 파일만 가능합니다.<br>
	                                (jpeg, png, gif, bmp, tif)</p>
	                        </div>
	                    </div>
	                    
	                    <div class="inputsContainer">
	                        <div class="inputBox">
	                            <p class="inputCaption">첨부 이미지
	                                <label for="attach_file1">파일추가</label>
	                                <input type="file" id="attach_file1" name="attach_file1" multiple style="display: none;">
	                            </p>
	                            <ul class="fileList">
	                                
	                            </ul>
	                            <p class="fileCaption">첨부 파일은 각 10MB 아래의 확장자 파일만 가능합니다.<br>
	                                (jpeg, png, gif, bmp, tif)</p>
	                        </div>
	                    </div>
	                    <div class="btnContainer">
	                        <a href="/course/course_list.do" class="normalButton white">목록으로</a>
	                        <a href="#lnk" onclick="button1_click()" class="basicButton blue"><img src="/img/admin/add2.png" alt="완료">완료</a>
	                    </div>
	                    
	                    <input type='hidden' name="saveType" id="saveType" value='${pictVO.saveType}' /> 
						<input type='hidden' name="idx" id="idx" value='${pictVO.idx}' /> 
	                </form>
	            </div>
	        </div>
	    </div>
	    <script>


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
					$("#register").attr("action", "/course/course_save.do");
					$("#register").submit();
				}
			}
		</script>
	</body>
	
</html>