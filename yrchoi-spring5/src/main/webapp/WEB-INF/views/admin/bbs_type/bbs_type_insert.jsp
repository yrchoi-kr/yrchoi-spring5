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
            <h1 class="m-0">게시판 생성</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">게시판생성관리</li>
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
          <div class="card-body table-responsive p-0">
          <!-- 글쓰기 폼 -->
          <div class="card card-primary">
            <div class="card-header">
              <h3 class="card-title">생성</h3>
            </div>
            <!-- /.card-header -->
            <!-- form start -->
            <!-- 첨부파일을 전송할때 enctype=필수  없으면 , 첨부파일이 전송X -->
            <form name="form_write" method="post" action="/admin/bbs_type/bbs_type_insert" enctype="multipart/form-data">
              <div class="card-body">
                <div class="form-group">
                  <!-- PK고유키, 식별자는 중복체크는 생략 -->
                  <label for="board_type">게시판타입</label>
                  <input value="" name="board_type" type="text" style="ime-mode:disabled" class="form-control" id="board_type" placeholder="게시판 타입을 입력해 주세요" required>
                </div>
                <div class="form-group">
                  <label for="content">게시판이름</label>
                  <input value="" name="board_name" type="text" id="board_name" class="form-control" placeholder="게시판명을 입력해주세요." required></input>
                </div>
                <div class="form-group">
                  <label for="board_sun">출력순서</label>
                  <input value="0" name="board_sun" type="number" class="form-control" id="board_sun" placeholder="출력순서를 입력해 주세요" required>
                </div>
                
              </div>
              <!-- /.card-body -->

              <div class="card-footer text-right">
                <button type="submit" class="btn btn-primary">생성</button>
                <a href="/admin/bbs_type/bbs_type_list" class="btn btn-default">목록</a>
              </div>
            </form>
          </div>
          <!-- // 글쓰기 폼 -->
          </div>
          <!-- /.card-body -->
        </div>
        <!-- //콘텐츠 내용 -->
        <!-- 페이징 처리 -->
        <div class="col-12 text-right">
          <a herf="board_write.html" class="btn btn-primary mb-3">글쓰기</a>
          <ul class="pagination justify-content-center">
              <li class="paginate_button page-item previous disabled" id="example2_previous">
                <a href="#" aria-controls="example2" data-dt-idx="0" tabindex="0" class="page-link">Previous</a>
              </li>
              <li class="paginate_button page-item active">
                <a href="#" aria-controls="example2" data-dt-idx="1" tabindex="0" class="page-link">1</a>
              </li>
              <li class="paginate_button page-item ">
                <a href="#" aria-controls="example2" data-dt-idx="2" tabindex="0" class="page-link">2</a>
              </li>
              <li class="paginate_button page-item ">
                <a href="#" aria-controls="example2" data-dt-idx="3" tabindex="0" class="page-link">3</a>
              </li>
              <li class="paginate_button page-item ">
                <a href="#" aria-controls="example2" data-dt-idx="4" tabindex="0" class="page-link">4</a>
              </li>
              <li class="paginate_button page-item ">
                <a href="#" aria-controls="example2" data-dt-idx="5" tabindex="0" class="page-link">5</a>
              </li>
              <li class="paginate_button page-item ">
                <a href="#" aria-controls="example2" data-dt-idx="6" tabindex="0" class="page-link">6</a>
              </li>
              <li class="paginate_button page-item next" id="example2_next">
                <a href="#" aria-controls="example2" data-dt-idx="7" tabindex="0" class="page-link">Next</a>
              </li>
          </ul>
        </div>
        <!-- //페이징 처리 -->
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

<%@ include file="../include/footer.jsp" %>