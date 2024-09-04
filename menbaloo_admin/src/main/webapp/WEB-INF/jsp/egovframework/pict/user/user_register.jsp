<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%><!DOCTYPE html>
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
	                <form action="" class="boardForm">
	                    <div class="inputsContainer">
	                        <div class="inputBox">
	                            <p class="inputCaption">카테고리*</p>
	                            <select name="" id="" class="lgThinInput">
	                                <option value="">공지사항</option>
	                                <option value="">언론에 비친 SCOUT</option>
	                                <option value="">정보 공개</option>
	                            </select>
	                        </div>
	                        <div class="inputBox">
	                            <p class="inputCaption">제목*</p>
	                            <input type="text" name="" id="" placeholder="내용을 입력하세요…">
	                        </div>
	                    </div>
	                    <div class="inputBox">
	                        <p class="inputCaption">내용*</p>
	                        <div class="editor">
	
	                        </div>
	                    </div>
	                    <div class="inputsContainer">
	                        <div class="inputBox">
	                            <p class="inputCaption">첨부파일
	                                <label for="input-file">파일추가</label>
	                                <input type="file" id="input-file" multiple style="display: none;">
	                            </p>
	                            <ul class="fileList">
	                                
	                            </ul>
	                            <p class="fileCaption">첨부 파일은 각 10MB 이내의 파일을 최대 5개까지 가능하며, 아래의 확장자 파일만 가능합니다.<br>
	                                (doc, docx, xls, xlsx, ppt, pptx, hwp, txt, pdf, ndoc, nxls, nppt, jpg, jpeg, png, gif, bmp, tif)</p>
	                        </div>
	                    </div>
	                    <div class="btnContainer">
	                        <a href="/board_list.do" class="normalButton white">목록으로</a>
	                        <a href="#lnk" class="basicButton blue"><img src="/img/admin/add2.png" alt="완료">완료</a>
	                    </div>
	                </form>
	            </div>
	        </div>
	    </div>
	</body>
</html>