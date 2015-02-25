<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Телефонная книга</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
</head>
<body>


<div class="col-md-2">
    <form style="float: left">
<textarea name="phonenum" rows="30" class="form-control" id="phnum">

</textarea>
        <a href="javascript:void(0);" id="sub">Cохранить</a>
    </form>
</div>
<div class="col-md-3">
    <textarea rows="30" id="novalidate">

    </textarea>
</div>
<div class="col-md-6">
    <jsp:include page="/getPage"></jsp:include>
</div>

<script>
 $(document).ready(function() {

     function validate() {

         var value = $("#phnum").val();
         var noValid = " ";
         var valid = " ";
         var re = /\s*,\s*/
         var phones = value.split(re);

         for(var i=0; i<phones.length; i++) {
             if(!phones[i].match(/7\d{10}$/)) {
                 noValid+=phones[i] + " ";
             } else {
                 valid+=phones[i];
             }
         }

         $("#novalidate").val(noValid);

         return valid;
     }



    $(".page").click(function() {
         var id = $(this).data("id");
                 $.ajax({
                     type: "POST",
                     url: "/getPages",
                     data: "id="+id
                 });
     });

        function savePhone() {

            var valid = validate();

            var phones = valid.split(/\s*,\s*/);

            $.ajax({
                type: "POST",
                url: "/savePhone",
                data: JSON.stringify(phones)
            });
        }

        $("#sub").click(savePhone);

    })

</script>
</body>
</html>

