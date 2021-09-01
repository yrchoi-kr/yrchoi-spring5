<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!-- html5가 아닌 JS로 유효성 검사 코어 임포트 -->
	 <script src="/resources/home/js/jquery.validate.js"></script>
	 <script src="/resources/home/js/additional-methods.js"></script>
<style>
.gender {
	padding: 4px 10px;
    font-size: 14px;
}
</style>
<script>
// 회원가입 유효성 검사 체크
$(document).ready(function() {
	$(".appForm").validate({
		rules: {
			password: "required",
			password_chk: {
				equalTo: "#password_lbl"
			}
		}
	});
	$.extend($.validator.messages, {
		required: "필수 항목 입니다.",
		email: "유효하지 않는 Email주소 입니다.",
		digits: "숫자만 입력 가능합니다.",
		equalTo: "비밀번호가 일치하지 않습니다."
	});
});
</script>
<!-- 메인콘텐츠영역 -->
<div id="container">
	<!-- 메인상단위치표시영역 -->
	<div class="location_area customer">
		<div class="box_inner">
			<h2 class="tit_page">스프링 <span class="in">in</span> 자바</h2>
			<p class="location">고객센터 <span class="path">/</span> 회원가입</p>
			<ul class="page_menu clear">
				<li><a href="#" class="on">회원가입</a></li>
			</ul>
		</div>
	</div>	
	<!-- //메인상단위치표시영역 -->

	<!-- 메인본문영역 -->
	<div class="bodytext_area box_inner">
		<!-- 폼영역 -->
		<form method="POST" name="join_form" action="/join" class="appForm">
			<fieldset>
				<legend>회원가입폼</legend>
				<p class="info_pilsoo pilsoo_item">필수입력</p>
				<ul class="app_list">
					<li class="clear">
						<label for="user_id_lbl" class="tit_lbl pilsoo_item">ID</label>
						<div class="app_content"><input type="text" name="user_id" class="w100p" id="user_id_lbl" placeholder="ID를 입력해주세요" required/></div>
					</li>
					<li class="clear">
						<label for="password_lbl" class="tit_lbl pilsoo_item">비밀번호</label>
						<div class="app_content"><input type="password" name="user_pw" class="w100p" id="password_lbl" placeholder="비밀번호를 입력해주세요" required/></div>
					</li>
					<li class="clear">
						<label for="password_chk_lbl" class="tit_lbl pilsoo_item">비밀번호확인</label>
						<div class="app_content"><input type="password" name="password_chk" class="w100p" id="password_chk_lbl" placeholder="비밀번호를 다시 입력해주세요" required/></div>
					</li>
					<li class="clear">
						<label for="user_name_lbl" class="tit_lbl pilsoo_item">이름</label>
						<div class="app_content"><input type="text" name="user_name" class="w100p" id="user_name_lbl" placeholder="이름을 입력해주세요" required/></div>
					</li>
					<li class="clear">
						<label for="email_lbl" class="tit_lbl pilsoo_item">이메일</label>
						<div class="app_content"><input type="email" name="email" class="w100p" id="email_lbl" placeholder="이메일을 입력해주세요." required/></div>
					</li>
					<!-- <li class="clear">
						<label for="point_lbl" class="tit_lbl pilsoo_item">포인트</label>
						<div class="app_content"><input type="digits" name="point" class="w100p" id="point_lbl"required readonly/></div>
					</li> -->
					<!-- <li class="clear">
						<label for="enabled_lbl" class="tit_lbl pilsoo_item">로그인 여부</label>
						<div class="app_content radio_area">
							<input type="radio" name="enabled" class="css-radio" id="enabled_lbl" checked="" />
							<label for="man_lbl">허용</label>
							<input checked type="radio" name="enabled" class="css-radio" id="enabled_lbl" />
							<label for="woman_lbl">비허용</label>
						</div>
					</li> -->
					<!-- <li class="clear">
						<label for="gender_lbl" class="tit_lbl pilsoo_item">권한여부</label>
						<div class="app_content radio_area">
							<select name="levels" class="gender" required>
								<option value="ROLE_USER">일반 사용자</option>
							</select>
						</div>
					</li> -->
					
					<li class="clear">
						<label for="agree_lbl" class="tit_lbl pilsoo_item">개인정보활용동의</label>
						<div class="app_content checkbox_area"><input type="checkbox"" name="agree" class="css-checkbox" id="agree_lbl" required checked/>
						<label for="agree_lbl" class="agree">동의함</label>
						</div>
					</li>
				</ul>
				<p class="btn_line">
				<button type="submit" class="btn_baseColor" id="btn_insert" disabled style="opacity:0.5">회원가입</button>
				</p>	
			</fieldset>
		</form>
		<!-- //폼영역 -->
	</div>
	<!-- //메인본문영역 -->
</div>
<!-- //메이콘텐츠영역 -->

<script>
$(document).ready(function() {
	$("#user_id_lbl").change(function() {
		if($(this).val() != ""){
			$.ajax({
				type:"get",
				url:"/id_check_old?user_id="+$(this).val(),
				dataType:"json",
				success:function(result){
					//alert(JSON.stringify(result));
					//alert(result.memberCnt);
					if(result.memberCnt == 0){ //중복ID가 존재하지 않으면
						$("#btn_insert").attr("disabled", false);
						$("#btn_insert").css("opacity", "1");
						$("#msg").remove();
						$("#user_id_lbl").after("<div id='msg' style='color:blue'>사용가능한 ID입니다.</div>");
					}else{
						$("#btn_insert").attr("disabled", true);
						$("#btn_insert").css("opacity", "0.5");
						$("#msg").remove();
						$("#user_id_lbl").after("<div id='msg' style='color:red'>중복ID가 존재합니다.</div>");
					}
				},error:function(){
					alert("RestAPI서버가 작동하지 않습니다.");
				}
			});
		}
	});
});
</script>