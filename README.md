# Celery
Study
<!DOCTYPE html>
<html>
  <head>
    <title>计算器</title>
    <meta charset="utf-8" />
    <style type="text/css">
      .panel {
        border: 4px solid #ddd;
        width: 192px;
        margin: 100px auto;
        /*border-radius: 6px;*/
      }
      .panel p, .panel input {
        font-family: "微软雅黑";
        font-size: 20px;
        margin: 4px;
        float: left;
        /*border-radius: 4px;*/
      }
      .panel p {
        width: 122px;
        height: 26px;
        border: 1px solid #ddd;
        padding: 6px;
        overflow: hidden;
      }
      .panel input {
        width: 40px;
        height: 40px;
        border:1px solid #ddd;
      }
    </style>
    <script src="../js/jquery-1.11.1.js"></script>
    <script>
		window.onload = function(){
			console.log(1);
			var div = document.getElementById("jsq");
			console.log(1);
			div.onclick = function(e){
				var obj = e.srcElement || e.target;
				console.log(1);
				if(obj.nodeName != "INPUT"){
					return false;
				}
				var p = document.getElementById("screen");
				if(obj.value == "C"){
					p.innerHTML = "";
				}else if(obj.value == "="){
					try{
						p.innerHTML = eval(p.innerHTML);
					}catch(ex){
						p.innerHTML = "Error";
					}
				}else{
					p.innerHTML += obj.value;
				}
			}		
		}	
    </script>
  </head>
  <body>
    <div class="panel"  id="jsq">
      <div>
        <p id="screen"></p>
        <input type="button" value="C">
        <div style="clear:both"></div>
      </div>
      <div>
        <input type="button" value="7">
        <input type="button" value="8">
        <input type="button" value="9">
        <input type="button" value="/">
        
        <input type="button" value="4">
        <input type="button" value="5">
        <input type="button" value="6">
        <input type="button" value="*">
        
        <input type="button" value="1">
        <input type="button" value="2">
        <input type="button" value="3">
        <input type="button" value="-">
        
        <input type="button" value="0">
        <input type="button" value=".">
        <input type="button" value="=">
        <input type="button" value="+">
        
        <div style="clear:both"></div>
      </div>
    </div>    
  </body>
</html>
