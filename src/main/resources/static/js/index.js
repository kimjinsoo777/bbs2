$(document).ready(function (){
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
});