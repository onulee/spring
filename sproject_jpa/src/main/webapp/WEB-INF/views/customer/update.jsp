<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<script type="text/javascript">
	if("${session_id}" == ""){
		alert("로그인을 하셔야 글쓰기가 가능합니다.");
		location.href = "/member/login";
	}
	
	function updateBtn(){
		updateFrm.submit();
	}
</script>


	<!-- container -->
	<div id="container">

		<div id="location">
			<ol>
				<li><a href="#">HOME</a></li>
				<li><a href="#">CUSTOMER</a></li>
				<li class="last">NOTICE</li>
			</ol>
		</div>
		
		<div id="outbox">		
			<div id="left">
				<div id="title2">CUSTOMER<span>고객센터</span></div>
				<ul>	
					<li><a href="#" id="leftNavi1">NOTICE</a></li>
					<li><a href="#" id="leftNavi2">1:1문의</a></li>
					<li><a href="#" id="leftNavi3">FAQ</span></a></li>
					<li class="last"><a href="#" id="leftNavi4">이용안내</a></li>
				</ul>			
			</div><script type="text/javascript">initSubmenu(1,0);</script>
			

			<!-- contents -->
			<div id="contents">
				<div id="mypage">
					<h2><strong>NOTICE</strong><span>쟈뎅샵 소식을 전해드립니다.</span></h2>
					<form action="/customer/update" method="post" name="updateFrm" enctype="multipart/form-data">
					    <input type="hidden" name="bno" value="${board.bno}" />
						<div class="checkDivTab">
							<table summary="분류, 구매여부, 작은이미지, 평가, 제목, 상세 내용 순으로 포토 구매후기를 작성 하실수 있습니다." class="checkTable" border="1" cellspacing="0">
								<caption>게시판 수정</caption>
								<colgroup>
								<col width="19%" class="tw30" />
								<col width="*" />
								</colgroup>
								<tbody>
									<tr>
										<th scope="row"><span>제목</span></th>
										<td>
											<input type="text" class="wlong" name="btitle" value="${board.btitle}" />
										</td>
									</tr>
									<tr>
										<th scope="row"><span>작성자</span></th>
										<td>
											<input type="text" class="wlong" name="name" value="${session_name }" readonly />
										</td>
									</tr>
									<tr>
										<th scope="row"><span>상세 내용</span></th>
										<td>
											<textarea class="tta" name="bcontent">${board.bcontent}</textarea>
										</td>
									</tr>	
									<tr>
										<th scope="row"><span>파일첨부</span></th>
										<td>
											<input type="file" name="file" class="fileType" />
										</td>
									</tr>
									<tr>
										<th scope="row"><span>이미지</span></th>
										<td>
											<c:if test="${board.bfile !=null }">
											  <img src="/upload/${board.bfile}" width="200px">
											</c:if>
											<c:if test="${board.bfile ==null }">
											  해당 이미지가 없습니다.
											</c:if>
										</td>
									</tr>
																
								</tbody>
							</table>
						</div>
	
						<!-- Btn Area -->
						<div class="btnArea">
							<div class="bCenter">
								<ul>																
									<li><a class="nbtnbig" onclick="location.href='/customer/list'" >취소</a></li>
									<li><a class="sbtnMini" onclick="updateBtn()">확인</a></li>
								</ul>
							</div>
						</div>
						<!-- //Btn Area -->
					</form>
				</div>
			</div>
			<!-- //contents -->


		</div>
	</div>
	<!-- //container -->

<%@ include file="../layout/footer.jsp" %>