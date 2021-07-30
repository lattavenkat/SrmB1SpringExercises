<html>
<body>
<%= com.org.stringfunction.StrFunc.concat("Hi ")%></br>
<%= com.org.stringfunction.StrFunc.contain("trainee")%>
<%= com.org.datefunction.DateFunc.getMyDate()%>
<p id="dt">Waiting onclick</p>
<button type="button" onclick="myFunction()">Check Date</button>
<script>
    function myFunction() { 
	var ts = new Date(); 
    document.getElementById("dt").innerHTML = ts;
}
</script>
</body>
</html>
