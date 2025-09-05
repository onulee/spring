<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	if("${flag}" == "-1") alert("게시글이 삭제 되었습니다.");
	if("${flag}" == "1") alert("게시글이 등록 되었습니다.");
	if("${flag}" == "2") alert("게시글이 수정 되었습니다.");
	if("${flag}" == "3") alert("답변달기가 등록 되었습니다.");
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
					<h2><strong>공공데이터</strong><span>쟈뎅샵 소식을 전해드립니다.</span></h2>
					
					<div class="orderDivMt">
						<table summary="NO, 제목, 등록일, 조회수 순으로 공지사항을 조회 하실수 있습니다." class="orderTable2" border="1" cellspacing="0">
							<caption>공지사항 보기</caption>
							<colgroup>
							<col width="10%" class="tnone" />
							<col width="14%" />
							<col width="17%" class="tw25" />
							<col width="14%" class="tw25" />
							<col width="28%" class="tnone" />
							<col width="*" class="tnone" />
							</colgroup>
							<thead>
								<th scope="col" class="tnone">NO.</th>
								<th scope="col">사진제목</th>
								<th scope="col">촬영작가</th>
								<th scope="col">촬영날짜</th>
								<th scope="col" class="tnone">촬영지</th>
								<th scope="col" class="tnone">사진</th>
							</thead>
							<tbody id="tbody">
								<!-- api 리스트 출력 -->

							</tbody>
						</table>
					</div>
						


					<div class="btnAreaList">
					    <div class="bwright">
							<ul>
								<li><a href="/customer/write" class="sbtnMini">글쓰기</a></li>
							</ul>
						</div>
						<!-- 페이징이동1 -->
						<div class="allPageMoving1">
						<c:if test="${page<2}">
							<a class="n">
								<img src="/images/btn/btn_pre2.gif" alt="처음으로"/>
							</a>
							<a class="pre">
								<img src="/images/btn/btn_pre1.gif" alt="앞페이지로"/>
							</a>
						</c:if>
						<c:if test="${page>=2}">
							<a href="/customer/list" class="n">
								<img src="/images/btn/btn_pre2.gif" alt="처음으로"/>
							</a>
							<a href="/customer/list?page=${page-1}" class="pre">
								<img src="/images/btn/btn_pre1.gif" alt="앞페이지로"/>
							</a>
						</c:if>
						<c:forEach var="i" begin="${startpage}" end="${endpage}">
							<c:if test="${page == i }">
							  <strong>${i}</strong>
							</c:if>
							<c:if test="${page != i }">
							  <a href="/customer/list?page=${i}">${i}</a>
							</c:if>
						</c:forEach>
						<c:if test="${page<maxpage}">
						<a href="/customer/list?page=${page+1}" class="next">
							<img src="/images/btn/btn_next1.gif" alt="뒤페이지로"/>
						</a>
						<a href="/customer/list?page=${maxpage}" class="n">
							<img src="/images/btn/btn_next2.gif" alt="마지막페이지로"/>
						</a>
						</c:if>
						<c:if test="${page>=maxpage}">
						<a class="next">
							<img src="/images/btn/btn_next1.gif" alt="뒤페이지로"/>
						</a>
						<a class="n">
							<img src="/images/btn/btn_next2.gif" alt="마지막페이지로"/>
						</a>
						</c:if>

						</div>
						<!-- //페이징이동1 -->
					</div>

					<div class="searchWrap">
						<div class="search">
							<ul>
								<form action="/customer/search" name="searchFrm">
								<li class="web"><img src="/images/txt/txt_search.gif" alt="search" /></li>
								<li class="se">
									<select name="category">
										<option value="all" />전체</option>
										<option value="btitle" />제목</option>
										<option value="bcontent" />내용</option>
									</select>
								</li>
								<li>
									<input type="text" name="search" class="searchInput" />
								</form>
								</li>
								<li class="web"><a onclick="searchBtn()"><img src="/images/btn/btn_search.gif" alt="검색" /></a></li>
								<li class="mobile"><a><img src="/images/btn/btn_search_m.gif" alt="검색" /></a></li>
								<script>
								   function searchBtn(){
									   alert("검색을 진행합니다.");
									   searchFrm.submit();
								   }
								</script>
							</ul>
						</div>
					</div>
					<!-- //포토 구매후기 -->


				</div>
			</div>
			<!-- //contents -->

		</div>
	</div>
	<!-- //container -->
	
	<!-- //공공데이터 api 가져오기 -->
	<script>
	  $.ajax({
		 url:"/api/api",
		 method:"get",
		 data:{"page":"1"},
		 dataType:"json",
		 success:function(data){
			 alert("공공데이터 api를 가져옵니다.");
			 console.log(data);
			 console.log("------------------")
			 console.log(data.response.body.items.item);
			 var dhtml = ``;
			 var apiList = data.response.body.items.item; //item까지 해야 함.
			 for(var i=0;i<apiList.length;i++){
			 dhtml += `
				 <tr>
					<td class="tnone">`+apiList[i].galContentId+`</td>
					<td class="left">`+apiList[i].galTitle+`</td>
					<td>`+apiList[i].galPhotographer+`</td>
					<td>`+apiList[i].galPhotographyMonth+`</td>
					<td class="tnone right">`+apiList[i].galPhotographyLocation+`</td>
					<td><img src='`+apiList[i].galWebImageUrl+`' width="50%"/></td>
				</tr>
			 `;
			 }//for
			 
			 $("#tbody").html(dhtml);
			 
			 
			 
			 
			 
			 
		 },
		 error:function(){
			 alert("실패");
		 }
		 
	  });
	</script>
	
	
	
	

<%@ include file="../layout/footer.jsp" %>
