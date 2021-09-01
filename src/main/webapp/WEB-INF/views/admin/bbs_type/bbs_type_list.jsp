<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../include/header.jsp" %>

 <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">게시판 관리</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">게시판 관리</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <!-- 콘텐츠 내용 -->
        <div class="card">
          <div class="card-header">
            <h3 class="card-title" style="padding-top: 5px;">목록</h3>
          </div>
          <!-- /.card-header -->
          <div class="card-body table-responsive p-0">
            <table class="table table-hover">
              <!-- 줄바꿈않할때 다음 클래스추가 text-nowrap  -->
              <thead class="text-center">
                <!-- 아래 링크주소에 jsp에서 프로그램 처리 예정 -->
                <tr>
                  <th>BOARD_TYPE</th>
                  <th>게시판 이름</th>
                  <th>순서</th>
                </tr>
              </thead>
              <tbody class="text-center">
               <c:forEach var="boardTypeVO" items="${listBoardTypeVO}">
                <tr style="cursor: pointer;" onclick="location.replace('/admin/bbs_type/bbs_type_update?board_type=${boardTypeVO.board_type}');">
                  <td>${boardTypeVO.board_type }</td>
                  <td>${boardTypeVO.board_name }</td>
                  <td>${boardTypeVO.board_sun }</td>
                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
          <!-- /.card-body -->
        </div>
        <!-- //콘텐츠 내용 -->
        <!-- 페이징 처리 -->
        <div class="col-12 text-right">
          <a href="/admin/bbs_type/bbs_type_insert" class="btn btn-primary mb-3">게시판 생성</a>
                  
        </div>
        <!-- //페이징 처리 -->
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->


<%@ include file="../include/footer.jsp" %>