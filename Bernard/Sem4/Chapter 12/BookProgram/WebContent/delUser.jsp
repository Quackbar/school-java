<head>
<title>WebStocks: Delete User</title>
</head>
<body text="#824423">
<%@ page import="java.util.*" %>
<%
   ArrayList al = (ArrayList)session.getAttribute("userData");
%>

<div align="center">
  <center>
<table border="0" cellspacing="0" width="55%" height="253" cellpadding="0">
  <tr>
  <td height="25">
    <p align="center">
    <font size="5">WebStocks</font>
  </td>
  </tr>
  <tr>
    <td width="42%" height="227">
    <form name="delUserForm" method="POST" action="../webstocks/WebStocks">
        <center>
       <table border="0" width="461" height="230">
          <tr>
            <td height="41" align="center" colspan="3" width="459">
               <b>Verify Delete of User</b>
            </td>
          </tr>
          <tr>
            <td height="35" align="left" width="145">&nbsp;</td>
            <td align="left" width="86">
               <b>User ID:</b>
            </td>
            <td height="35" align="left" width="224"><%= (String)al.get(0) %></td>
          </tr>
          <tr>
            <td height="28" align="left" width="145">&nbsp;</td>
            <td align="left" width="86">
               <b>First Name:</b>
            </td>
            <td height="28" align="left" width="224"><%= (String)al.get(1) %></td>
          </tr>
          <tr>
            <td height="27" align="left" width="145">&nbsp;</td>
            <td align="left" width="86">
               <b>Last Name:</b>
            </td>
            <td height="27" align="left" width="224"><%= (String)al.get(2) %></td>
          </tr>
          <tr>
            <td height="32" align="center" width="145">&nbsp;</td>
            <td align="left" width="86">
               <b>User is:</b>
            </td>
            <td height="32" align="left" width="224"><%= (String)al.get(3) %></td>
          </tr>
          <tr>
            <td align="center" colspan="3" width="459" height="43">
               <input type="submit" value="Delete" onClick="form.WSaction.value='delUser'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<!--               <input type="button" value="Cancel" onClick="history.go(-2)"></td>
-->               <input type="submit" value="Cancel" onClick="form.action='../mainForm.jsp'">
          </tr>
          </table>
        </center>
     <input type="hidden" name="WSaction"></td>
     <input type="hidden" name="delUserID" value="<%= (String)al.get(0) %>"></td>
    </form>
    </td>
  </tr>
</table>
  </center>
</div>
</body>