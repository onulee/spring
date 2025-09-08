<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<%@ include file="../layout/header.jsp" %>
	<!-- container -->
	<div id="container">

		<div id="location">
			<ol>
				<li><a href="#">HOME</a></li>
				<li><a href="#">MEMBERSHIP</a></li>
				<li class="last">회원가입</li>
			</ol>
		</div>
		
		<div id="outbox">		
			<div id="left">
				<div id="title2">MEMBERSHIP<span>멤버쉽</span></div>
				<ul>	
					<li><a href="#" id="leftNavi1">로그인</a></li>
					<li><a href="#" id="leftNavi2">회원가입</a></li>
					<li><a href="#" id="leftNavi3">아이디/<span>비밀번호 찾기</span></a></li>
					<li><a href="#" id="leftNavi4">회원약관</a></li>
					<li><a href="#" id="leftNavi5">개인정보<span>취급방침</span></a></li>
					<li class="last"><a href="#" id="leftNavi6">이메일무단<span>수집거부</span></a></li>
				</ul>			
			</div><script type="text/javascript">initSubmenu(2,0);</script>


			<!-- contents -->
			<div id="contents">
				<div id="member">
					<h2><strong>회원가입</strong><span>회원으로 가입하시면 보다 더 다양한 혜택을 누리실 수 있습니다.</span></h2>
					
					<!-- STEP -->
					<div class="stepWrap">
						<div class="step stepon">
							<p class="web">STEP 01</p>
							<p class="txt">실명확인</p>
							<p class="ck"><img src="../images/bg/bg_step.png" alt="현재위치" /></p>
						</div>

						<div class="step">
							<p class="web">STEP 02</p>
							<p class="txt">약관 동의</p>
						</div>

						<div class="step">
							<p class="web">STEP 03</p>
							<p class="txt"><span>회원정보</span> <span>입력</span></p>
						</div>

						<div class="step">
							<p class="web">STEP 04</p>
							<p class="txt"><span>회원가입</span> <span>완료</span></p>
						</div>
					</div>
					<!-- //STEP -->
						

					<div class="alertBox">
						<ul>
							<li>회원님의 실명확인 및 가입 여부를 확인하는 절차입니다.</li>
							<li>회원님의 개인 정보 보호를 위해 실명확인을 실시하고 있습니다.</li>
						</ul>
					</div>
						<script>
						   function emailSend(){
							   alert("이메일 전송합니다.");
							   let email = $("#email").val();
							   console.log(email);
							   //ajax구문
							   $.ajax({
								   url:"/member/emailSend",
								   method:"post",
								   data:{"email":email},
								   dataType:"text",
								   success:function(data){
									   alert("성공");
									   console.log(data);
								   },
								   error:function(){
									   alert("실패");
								   }
								   
							   });//ajax
							   
						   }
						
						</script>
	
						<h3>본인 확인</h3>
						<div class="informbox">
							<div class="inform">
								<ul>
									<li><input type="text" class="nameType" onfocus="this.className='mfocus'" onblur="if (this.value.length==0) {this.className='nameType'}else {this.className='mfocusnot'}" style="ime-mode:inactive;" /></li>
									<li><input type="text" id="email" class="emailType" onfocus="this.className='mfocus'" onblur="if (this.value.length==0) {this.className='emailType'}else {this.className='mfocusnot'}" /></li>
								</ul>
	
								<div class="btn"><a onclick="emailSend()" class="gbtn">이메일 인증</a></div>
							</div>
						</div>
						
						<h3>인증번호 확인</h3>
						<div class="informbox">
							<div class="inform">
								<ul>
									<li><input type="text" class="emailType" onfocus="this.className='mfocus'" onblur="if (this.value.length==0) {this.className='emailType'}else {this.className='mfocusnot'}" /></li>
								</ul>
	
								<div class="btn"><a class="gbtn">인증번호 확인</a></div>
							</div>
						</div>
	
	
						<p class="alert">쟈뎅 온라인 쇼핑몰에서는 2012년 8월 18일로 시행되는 정보통신망 이용 촉진 및 정보 보호 등에 관한 법률 “주민등록번호의 <span>사용 제한”과 관련하여 주민등록번호를 수집하지 않습니다.</span></p>
	
				</div>
			</div>
			<!-- //contents -->


		</div>
	</div>
	<!-- //container -->
<%@ include file="../layout/footer.jsp" %>