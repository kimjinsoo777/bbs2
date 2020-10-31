$(document).ready(function (){
    $('#id').focus();
    //로그인 버튼
    $('#loginBtn').on('click',function (){
        window.location.href = '/login';
    });

    //회원가입 버튼
    $('#joinBtn').on('click',function (){
        window.location.href = '/join';
    });

    //뒤로가기 버튼
    $('#back').on('click', function (){
        window.location.href = '/'
    });

    //회원가입
    $('#join').on('click', function (){
       let data = {
           id : $('#id').val(),
           password : $('#password').val(),
           name : $('#name').val()
       }

       $.ajax({
          data : data,
          type : 'post',
          url : '/rest/join',
          success : function (){
              alert("회원가입 완료");
              window.location.href = '/login';
          },
           error : function (error){
              alert(JSON.stringify(error));
           }

       });
    });

    $('#login').on('click', function (){
        let data = {
            id : $('#id').val(),
            password : $('#password').val()
        }

        $.ajax({
            data : data,
            type : 'post',
            url : '/rest/login',
            success : function (){
                window.location.href = '/';
            },
            error : function (error){
                alert(JSON.stringify(error));
            }
        });
    });
    $('#logout').on('click', function (){
        window.location.href = '/logout';
    });

    $('#writeBtn').on('click', function (){
        window.location.href = '/write';
    });

    //로그인 엔터
    $("#loginForm").keypress(function (event){
       if(event.which == 13){
           $("#login").first().trigger("click");
       }

    });

    //글쓰기
    $('#write').on('click', function (){
        let data = {
            title : $('#title').val(),
            content : $('#content').val(),
            writer : $('#writer').val(),
            mno : $('#mno').val()
        }

        $.ajax({
            data : data,
            type : 'post',
            url : '/rest/write',
            success : function () {
                alert('글 등록 완료!');
                window.location.href = '/';
            }
        });
    });

    //글수정
    $('#update').on('click', function (){
        let data = {
            title : $('#title').val(),
            content : $('#content').val(),
            bno : $('#bno').val()
        }

        $.ajax({
            data : data,
            type : 'put',
            url : '/rest/update',
            success : function (){
                alert('수정 완료!');
                window.location.href = '/';
            }
        });
    });

    //글삭제
    $('#delete').on('click', function (){
        let data = {
            bno : $('#bno').val()
        }

        $.ajax({
            data : data,
            type : 'delete',
            url : '/rest/delete',
            success : function (){
                alert('삭제 완료!');
                window.location.href = '/';
            }
        });
    });

    //추천
    $('#reco').on('click', function (){
        let data = {
            bno : $('#bno').val()
        }
        $.ajax({
            data : data,
            type : 'put',
            url : '/rest/reco',
            success : function (){
                alert('해당 게시글을 추천하였습니다.');
            }

        });
    });

    //댓글
    $('#reply').on('click', function (){
        let bno = $('#bno').val()

        let data = {
            reWriter : $('#reWriter').val(),
            reContent : $('#reContent').val(),
            bno : $('#bno').val()
        }

        $.ajax({
            data : data,
            type : 'post',
            url : '/rest/reply',
            success : function (){
                window.location.href = '/select/'+bno;
            }
        });
    });
});