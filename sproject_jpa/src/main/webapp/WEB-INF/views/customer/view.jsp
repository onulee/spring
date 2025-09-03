<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
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
									<c:if test="${preBoard != null }">
										<td><a href="/customer/view?bno=${preBoard.bno}">${preBoard.btitle}</a></td>
									</c:if>
									<c:if test="${preBoard == null }">
										<td>이전글이 없습니다.</td>
									</c:if>
								</tr>

								<tr>
									<th class="next">NEXT</th>
									<c:if test="${nextBoard != null }">
										<td><a href="/customer/view?bno=${nextBoard.bno}">${nextBoard.btitle}</a></td>
									</c:if>
									<c:if test="${nextBoard == null }">
										<td>다음글이 없습니다.</td>
									</c:if>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- //이전다음글 -->
		<script>
						
			//jquery선언			
			$(function(){
				// 전역변수 선언
				let id = '';
				let rpw = '';
				let rcontent = '';
				
				let rdate = '';
				let updateFlag = 0;
				let rno = 1;
				
				// 하단댓글 추가
				$(document).on("click",".replyBtn",function(){
					alert("하단댓글을 저장합니다.");
					console.log("rpw : "+$(".replynum").val());
					console.log("rcontent : "+$(".replyType").val());
					
					rpw = $(".replynum").val();
					rcontent = $(".replyType").val();
					
					//ajax 전송
					$.ajax({
						url:"/reply/write",
						method:"post",
						data:{"id":"${session_id}","bno":"${board.bno}",
							"rpw":rpw,"rcontent":rcontent},
						dataType:"json", //"json" - 데이터를 받음
						success:function(data){
							// 댓글개수증가
							var replyCount = $(".replyCount").text();
							var replyCount = Number(replyCount)+1;
							$(".replyCount").text(replyCount);
							//출력
							console.log(data);
							console.log("댓글번호 : "+data.rno);
							console.log("댓글내용 : "+data.rcontent);
							console.log("게시글번호 : "+data.board.bno);
							console.log("회원아이디 : "+data.member.id);
							//변수
							var rno = data.rno;
							var rcontent = data.rcontent;
							var id = data.member.id;
							var rdate = data.rdate ;
							// html소스를 추가
							var dhtml = `
							<ul id=`+rno+`>
								<li class="name">`+id+` <span>[`+rdate+`]</span></li>
								<li class="txt">`+rcontent+`</li>
								<li class="btn">
									<a class="updateBtn rebtn">수정</a>
									<a class="deleteBtn rebtn">삭제</a>
								</li>
							</ul>
							`;
							
							$(".replyBox").prepend(dhtml); //html태그추가
							
						},
						error:function(){
							alert("실패");
						}
					});
					
					//완료후
					$(".replynum").val("");
					$(".replyType").val("");
					
					
				});//replyBtn
				
				
				
				
				
				
				// 정적,동적html 형태 모두 실행됨.
				// 모두 삭제 가능
				$(document).on("click",".deleteBtn",function(){
					console.log("rno번호 : "+$(this).closest("ul").attr("id"));
					rno = $(this).closest("ul").attr("id");
					
					if(confirm(rno+"번 하단댓글을 삭제하시겠습니까?")){
						alert(rno+"번 하단댓글을 삭제합니다.");
						//ajax선언
						$.ajax({
							url:"/reply/delete",
							method:"delete",
							data:{"rno":rno},
							dataType:"text", //text,json
							success:function(data){
								//alert("성공");
								console.log(data);
								
								// 댓글개수감소
								var replyCount = $(".replyCount").text();
								var replyCount = Number(replyCount)-1;
								$(".replyCount").text(replyCount);
							},
							error:function(){
								alert("실패");
								location.href="/board/list";
							}
						});//ajax
						// html에서 삭제함
						$("#"+rno).remove();
					}//ajax
				});//deleteBtn
				
				//수정 화면 열기
				$(document).on("click",".updateBtn",function(){
					// updateFlag가 0일때만 화면 열기, 1이면 화면 열기 실행 안됨.
					if (updateFlag == 0){
						updateFlag = 1; // 수정화면이 열려 있는 상태
						console.log("rno번호 : "+$(this).closest("ul").attr("id"));
						rno = $(this).closest("ul").attr("id");
						// 전역변수 - id,rcontent,rdate
						id = '${session_id}';
						rcontent = $(this).closest("ul").children(".txt").text();
						rdate = $(this).closest("ul").children(".name").children("span").text();
						console.log("id",id);
						console.log("rcontent",rcontent);
						console.log("rdate",rdate);
						
						let dhtml = `<li class="name"> `+id+` <span> `+rdate+` </span></li>
							<li class="txt"><textarea class="replyType">`+rcontent+`</textarea></li>
							<li class="btn">
								<a class="confirmBtn rebtn">확인</a>
								<a class="cancelBtn rebtn">취소</a>
							</li>`;
						
						$("#"+rno).html(dhtml);
					}else{
						alert("하단댓글 수정화면이 열려 있습니다.\n수정완료후 수정버튼을 클릭하세요.");
					}
				});//updateBtn
				
				
				//수정취소
				$(document).on("click",".cancelBtn",function(){
					alert("하단댓글 수정을 취소합니다.");
					console.log("------하단댓글 수정 취소------");
					console.log("rno",rno);
					console.log("id",id);
					console.log("rcontent",rcontent);
					console.log("rdate",rdate);
					
					let dhtml = `<li class="name">`+id+` <span> `+rdate+` </span></li>
						<li class="txt">`+rcontent+`</li>
						<li class="btn">
							<a class="updateBtn rebtn">수정</a>
							<a class="deleteBtn rebtn">삭제</a>
						</li>`;
					
					$("#"+rno).html(dhtml);
					updateFlag = 0;
				});//cancelBtn
				
				//정적html에서만 구동 , 동적html추가된 형태는 구동되지 않음
				// 최초 불러온 list는 삭제가 가능하지만, 댓글추가된 댓글은 삭제 안됨.
				//$(".deleteBtn").click(()->{
				//	alert("경고");
				//})
				
				// 수정확인
				$(document).on("click",".confirmBtn",function(){
					// rno,id-전역변수, rcontent 가져오면 됨.
					alert("하단댓글을 수정합니다.");
					updateFlag = 0;
					rcontent = $(this).closest("ul").children(".txt").children(".replyType").val();
					console.log("rcontent : ",rcontent);
					//ajax
					$.ajax({
					
						url:"/reply/confirm",
						method:"put",
						data:{"rno":rno,"rcontent":rcontent},
						dataType:"json",
						success:function(data){
							
							//변수
							rno = data.rno;
							rcontent = data.rcontent;
							id = data.member.id;
							rdate = data.rdate ;
							// html소스를 추가
							var dhtml = `
								<li class="name">`+id+` <span>[`+rdate+`]</span></li>
								<li class="txt">`+rcontent+`</li>
								<li class="btn">
									<a class="updateBtn rebtn">수정</a>
									<a class="deleteBtn rebtn">삭제</a>
								</li>
							`;
							
							$("#"+rno).html(dhtml);
						},
						error:function(){
							alert("실패");
						}
					});//ajax
				});//confirmBtn			
			
			
			
			});//jquery
		</script>

					<!-- 댓글-->
					<div class="replyWrite">
						<ul>
							<li class="in">
								<p class="txt">총 <span class="orange replyCount">${replyCount}</span> 개의 댓글이 달려있습니다.</p>
								<p class="password">비밀번호&nbsp;&nbsp;<input type="password" name="rpw" class="replynum" /></p>
								<textarea name="rcontent" class="replyType"></textarea>
							</li>
							<li class="btn"><a class="replyBtn">등록</a></li>
						</ul>
						<p class="ntic">※ 비밀번호를 입력하시면 댓글이 비밀글로 등록 됩니다.</p>
					</div>

					<div class="replyBox">
						
						<c:forEach var="reply" items="${board.reply }">
						<ul id="${reply.rno}">
							<li class="name">${reply.member.id } <span>[${reply.rdate }]</span></li>
							<li class="txt">${reply.rcontent}</li>
							<c:if test="${session_id == reply.member.id }">
							<li class="btn">
								<a class="updateBtn rebtn">수정</a>
								<a class="deleteBtn rebtn">삭제</a>
							</li>
							</c:if>
						</ul>
						</c:forEach>
						

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