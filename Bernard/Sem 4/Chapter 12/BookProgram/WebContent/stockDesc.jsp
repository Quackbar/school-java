<head>
<title>WebStocks: Enter Stock Description</title>
</head>
<body text="#824423" onLoad="document.form.stockDesc.focus()">
<div align="center">
  <center>
<table border="0" cellspacing="0" width="55%" height="253">
  <tr>
  <td height="25">
    <p align="center">
    <font size="5">WebStocks</font>
  </td>
  </tr>
  <tr>
    <td width="42%" height="227">
    <form name="form" method="POST" action="../webstocks/WebStocks">
        <center>
       <table border="0" width="461" height="123">
          <tr>
            <td height="84" align="center">
               <b>Enter Description for stock symbol: 
               <%
               // display stock symbol
               out.println(session.getAttribute("stockSymbol"));
               %>
               </b>
               <p>
            <input type="text" name="stockDesc" size="61"></td>
            </td>
          </tr>
          <tr>
            <td align="center">
               &nbsp;&nbsp;
               <input type="submit" value="Add Stock" onClick="form.WSaction.value='addStockDesc'">
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<!--               <input type="submit" value="Cancel" onClick="form.WSaction.value='cancelAddStockDesc'">
-->               <input type="submit" value="Cancel" onClick="form.action='../mainForm.jsp'">
             </td>
          </tr>
          </table>
        </center>
     <input type="hidden" name="WSaction"></td>
    </form>
    </td>
  </tr>
</table>
  </center>
</div>
</body>