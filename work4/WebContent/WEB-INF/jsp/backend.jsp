<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		
</head>
<body>

<div style="position:fixed;background:gray;width:80%;height:80%;display:none;opacity:0.3"></div>


<div id="first" style="border-width:3px;border-style:solid;border-color:black;padding:5px;background:white;position:fixed;margin-left:12%;width:80%;height:80%;top:0px;left:0px;display:block;"></div>



<div style="border-width:1px;border-style:solid;border-color:red;padding:5px;background:white;position:fixed;width:7%;height:12%;top:20px;left:20px;">
<button style ="text-align:center;" id="supplier1" onclick="sup()" >進貨管理</button>
<button style ="text-align:center;" id="replenishment1" onclick="reple()" >補貨</button>
</div>
<div id="suppliershow1" style="border-width:3px;border-style:solid;border-color:red;padding:5px;background:white;position:fixed;margin-left:12%;width:80%;height:80%;top:0px;left:0px;display:none;">
<input type="text" id="supid" value="6">
<input type="text" id="supname" value="gangun">
<input type="text" id="supaddress" value="yourhome">
<input type="text" id="supemail" value="gan@gan.com.tw">
<input type="text" id="supphone" value="0123456789">
<input type="text" id="supsalesname" value="gggggg">
<input type="text" id="supsalesphone" value="09123456789">
<input type="text" id="supsalesemail" value="gan@gan.com.tw">

<button onclick="supplierquery()">查詢</button> 
<button onclick="supplieradd()">新增</button>
<button onclick="supplierupdate()">修改</button>
<button onclick="supplierdelete()">刪除</button>
<button onclick="supplier1close()">close</button>
<div id="supplierresult"></div>
</div>


<div id="replenishmentshow1" style="border-width:3px;border-style:solid;border-color:red;padding:5px;background:white;position:fixed;margin-left:12%;width:80%;height:80%;top:0px;left:0px;display:none;">
<button onclick="replequery()">查詢</button> 
<div id="replenishmentresult">name</div>
<button onclick="replenishment1close()">close</button>
</div>





<div style="border-width:1px;border-style:solid;border-color:red;padding:5px;background:white;position:fixed;width:7%;height:10%;top:120px;left:20px;">
<button style ="text-align:center;" id="product1" onclick="pro()">產品管理</button> </div><br><br><br><br><br><br><br>

<div id="productshow1" style="border-width:3px;border-style:solid;border-color:green;padding:5px;background:white;position:fixed;margin-left:12%;width:80%;height:80%;top:0px;left:0px;;display:none;">
<input type="text" id="but1x" value="but1x">
<input type="text" id="but1xx" value="but1xx">
<input type="text" id="but1Xxx" value="but1xxx">
<input type="text" id="but1Xxxx" value="but1xxxx">
<input type="text" id="but1Xxxxx" value="but1xxxxx">
<input type="text" id="but1Xxxxxx" value="but1xxxxxx">
<button onclick="product1close()">close</button>
</div>

<script>
<!--這是supplier-->

function sup(){
	var div1 = document.getElementById("suppliershow1");
	var div2 = document.getElementById("productshow1");
	   div1.style.display ="block";
	   div2.style.display ="none";
}
function supplier1close(){
	var div1 = document.getElementById("suppliershow1");
	   div1.style.display ="none";    
}

function supplierquery(){
    $.post("supplier",function(data){
        $("#supplierresult").html(data);
   });
} 

function supplieradd(){	 
   $.post("supplier/supplieradd",
		   {"id":$("#supid").val(),"companyname":$("#supname").val(),"address":$("#supaddress").val(),
	   "email":$("#supemail").val(),"phone":$("#supphone").val(),"salesName":$("#supsalesname").val(),"salesPhone":$("#supsalesphone").val(),"salesEmail":$("#supsalesemail").val()},
           function(data){
           	 $("#supplierresult").html(data);
           }
      );
}
function supplierupdate(){	 
	   $.post("supplier/supplierupdate",
			   {"id":$("#supid").val(),"companyname":$("#supname").val(),"address":$("#supaddress").val(),
		   "email":$("#supemail").val(),"phone":$("#supphone").val(),"salesName":$("#supsalesname").val(),"salesPhone":$("#supsalesphone").val(),"salesEmail":$("#supsalesemail").val()},
	           function(data){
	           	 $("#supplierresult").html(data);
	           }
	      );
	}
function supplierdelete(){	 
	   $.post("supplier/supplierdelete",
			   {"id":$("#supid").val(),"companyname":$("#supname").val(),"address":$("#supaddress").val(),
		   "email":$("#supemail").val(),"phone":$("#supphone").val(),"salesName":$("#supsalesname").val(),"salesPhone":$("#supsalesphone").val(),"salesEmail":$("#supsalesemail").val()},
	           function(data){
	           	 $("#supplierresult").html(data);
	           }
	      );
	}
<!--這是supplier結尾-->
<!--這是reple-->
function reple(){
	var div1 = document.getElementById("suppliershow1");
	var div2 = document.getElementById("productshow1");
	var div3 = document.getElementById("replenishmentshow1");
	   div1.style.display ="none";
	   div2.style.display ="none";
	   div3.style.display="block";
}
function replenishment1close(){
	var div1 = document.getElementById("replenishmentshow1");
	   div1.style.display ="none";    
}




<!--這是reple結尾-->
function pro(){
	var div1 = document.getElementById("productshow1");
	   div1.style.display ="block"; 
}
function product1close(){
	var div1 = document.getElementById("productshow1");
	   div1.style.display ="none"; 
}
</script>




</body>
</html>