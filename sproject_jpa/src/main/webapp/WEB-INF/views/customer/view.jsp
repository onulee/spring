<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<script type="text/javascript">
	if("${flag}" == "1") alert("게시글이 수정 되었습니다.");
	
	//게시글 삭제
	function deleteBtn(){
		if(confirm("${board.bno} 번 게시글을 삭제하시겠습니까?")){
			location.href="/customer/delete?bno=${board.bno}";
		}
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
				<div id="customer">
					<h2><strong>NOTICE</strong><span>쟈뎅샵 소식을 전해드립니다.</span></h2>

					<div class="viewDivMt">
						<div class="viewHead">
							<div class="subject">
								<ul>
									<li>${board.btitle}</li>
								</ul>
							</div>
							<div class="day">
								<p class="txt">작성자
								<span>${board.member.name}</span>
								</p>
							</div>
							<div class="day">
								<p class="txt">작성일
								<span>
									<fmt:formatDate value="${board.bdate}" pattern="yyyy.MM.dd"/>
								</span>
								</p>
							</div>
						</div>

						<div class="viewContents">
							${board.bcontent }
							<br/><br/>

							감사합니다.
						</div>
						<c:if test="${board.bfile != null }">
						<div class="viewContents">
							<img src="/upload/${board.bfile}" width="50%" >
						</div>
						</c:if>
					</div>


					<!-- 이전다음글 -->
					<div class="pnDiv web">
						<table summary="이전다음글을 선택하여 보실 수 있습니다." class="preNext" border="1" cellspacing="0">
							<caption>이전다음글</caption>
							<colgroup>
							<col width="100px" />
							<col width="*" />
							</colgroup>
							<tbody>
								<tr>
									<th class="pre">PREV</th>
									<td><a href="#">상품 재입고는 언제 되나요?</a></td>
								</tr>

								<tr>
									<th class="next">NEXT</th>
									<td>다음 글이 없습니다.</td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- //이전다음글 -->


					<!-- 댓글-->
					<div class="replyWrite">
						<ul>
							<li class="in">
								<p class="txt">총 <span class="orange">3</span> 개의 댓글이 달려있습니다.</p>
								<p class="password">비밀번호&nbsp;&nbsp;<input type="password" class="replynum" /></p>
								<textarea class="replyType"></textarea>
							</li>
							<li class="btn"><a href="#" class="replyBtn">등록</a></li>
						</ul>
						<p class="ntic">※ 비밀번호를 입력하시면 댓글이 비밀글로 등록 됩니다.</p>
					</div>

					<div class="replyBox">
						

						<ul>
							<li class="name">jjabcde <span>[2014-03-04&nbsp;&nbsp;15:01:59]</span></li>
							<li class="txt">대박!!! 이거 저한테 완전 필요한 이벤트였어요!!</li>
							<li class="btn">
								<a href="#" class="rebtn">수정</a>
								<a href="#" class="rebtn">삭제</a>
							</li>
						</ul>

						<!-- 비밀글, 하단댓글수정 -->
						<!-- 
						<ul>
							<li class="name">jjabcde <span>[2014-03-04&nbsp;&nbsp;15:01:59]</span></li>
							<li class="txt">
								<a href="password.html" class="passwordBtn"><span class="orange">※ 비밀글입니다.</span></a>
							</li>
						</ul>
						
						<ul>
							<li class="name">jjabcde <span>[2014-03-04&nbsp;&nbsp;15:01:59]</span></li>
							<li class="txt"><textarea class="replyType"></textarea></li>
							<li class="btn">
								<a href="#" class="rebtn">수정</a>
								<a href="#" class="rebtn">삭제</a>
							</li>
						</ul>
						 -->
						
					</div>
					<!-- //댓글 -->


					<!-- Btn Area -->
					<div class="btnArea btline">
						<div class="bRight">
							<ul>
							    <c:if test="${session_id != null }">
									<li><a href="/customer/reply?bno=${board.bno}" class="sbtnMini mw">답변달기</a></li>
									<c:if test="${session_id == board.member.id }">
										<li><a href="/customer/update?bno=${board.bno}" class="sbtnMini mw">수정</a></li>
										<li><a onclick="deleteBtn()" class="sbtnMini mw">삭제</a></li>
									</c:if>
							    </c:if>
								<li><a href="/customer/list" class="sbtnMini mw">목록</a></li>
							</ul>
						</div>
					</div>
					<!-- //Btn Area -->
					
				</div>
			</div>
			<!-- //contents -->


		</div>
	</div>
	<!-- //container -->

<%@ include file="../layout/footer.jsp" %>