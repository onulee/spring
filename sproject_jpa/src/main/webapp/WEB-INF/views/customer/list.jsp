<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
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
					<h2><strong>NOTICE</strong><span>쟈뎅샵 소식을 전해드립니다.</span></h2>
					
					<div class="orderDivMt">
						<table summary="NO, 제목, 등록일, 조회수 순으로 공지사항을 조회 하실수 있습니다." class="orderTable2" border="1" cellspacing="0">
							<caption>공지사항 보기</caption>
							<colgroup>
							<col width="10%" class="tnone" />
							<col width="*" />
							<col width="14%" class="tw25" />
							<col width="14%" class="tw25" />
							<col width="14%" class="tnone" />
							</colgroup>
							<thead>
								<th scope="col" class="tnone">NO.</th>
								<th scope="col">제목</th>
								<th scope="col">작성자</th>
								<th scope="col">작성일</th>
								<th scope="col" class="tnone">조회수</th>
							</thead>
							<tbody>
								<c:forEach var="board" items="${list}">
								<tr>
									<td class="tnone">${board.bno}</td>
									<td class="left">
										<a href="/customer/view?bno=${board.bno}">
										<c:forEach var="j" begin="1" end="${board.bindent}">▶</c:forEach>
										${board.btitle}
										</a>
										<img src="/images/ico/ico_new.gif" alt="NEW" />
									</td>
									<td>${board.member.name }</td>
									<td>
									  <fmt:formatDate value="${board.bdate}" pattern="yyyy-MM-dd"/>
									</td>
									<td class="tnone right">${board.bhit}</td>
								</tr>
								</c:forEach>

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
								<li class="web"><img src="/images/txt/txt_search.gif" alt="search" /></li>
								<li class="se">
									<select>
										<option value="" />제목</option>
									</select>
								</li>
								<li><input type="text" class="searchInput" /></li>
								<li class="web"><a href="#"><img src="/images/btn/btn_search.gif" alt="검색" /></a></li>
								<li class="mobile"><a href="#"><img src="/images/btn/btn_search_m.gif" alt="검색" /></a></li>
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

<%@ include file="../layout/footer.jsp" %>
