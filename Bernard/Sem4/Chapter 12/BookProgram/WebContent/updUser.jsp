<head>
<title>WebStocks: Update User</title>
<%@ page import="java.util.*" %>
<%
   ArrayList al = (ArrayList)session.getAttribute("userData");
%>

<SCRIPT LANGUAGE=JAVASCRIPT>
<!--
  function checkFields(myForm)
  {
    if(myForm.userFirstName.value == "")
    {
      alert("Please enter a first name.");
    }
    else
    if(myForm.userLastName.value == "")
    {
      alert("Please enter a last name.");
    }
    else
    if(myForm.pswd1.value != "")
    {
      if(myForm.pswd2.value == "")
      {
        alert("Please re-enter password to verify.");
      }
      else
      if(myForm.pswd1.value != myForm.pswd2.value)
      {
        alert("Please re-enter - passwords do not match.");
      }
      else
      {
        myForm.WSaction.value = "updUser";
        myForm.submit();
      }
    }
    else
    {
      myForm.WSaction.value = "updUser";
      myForm.submit();
    }
  }
//-->
</SCRIPT>

</head>
<body text="#824423">

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
    <form name="myForm" method="POST" action="../webstocks/WebStocks">
        <center>
       <table border="0" width="636" height="123">
          <tr>
            <td height="41" align="center" colspan="7" width="621">
               <b>Update User</b>
            </td>
          </tr>

          <tr>
            <td height="35" align="left" width="101">&nbsp;</td>
            <td align="left" width="107">
               <b>User ID:</b>
            </td>
            <td height="35" align="left" colspan="4" width="394"><%= (String)al.get(0) %></td>
            <td height="35" align="left" width="26">&nbsp;</td>
          </tr>

          <tr>
            <td height="35" align="left" width="101">&nbsp;</td>
            <td align="left" width="107">
               <b>First Name:</b>
            </td>
            <td height="35" align="left" colspan="4" width="394" dir="ltr">
              <input type="text" name="userFirstName" size="55" value="<%= (String)al.get(1) %>">
            </td>
            <td height="35" align="left" width="26">&nbsp;</td>
          </tr>

          <tr>
            <td height="35" align="left" width="101">&nbsp;</td>
            <td align="left" width="107">
               <b>Last Name:</b>
            </td>
            <td height="35" align="left" colspan="4" width="394">
              <input type="text" name="userLastName" size="55" value="<%= (String)al.get(2) %>">
            </td>
            <td height="35" align="left" width="26">&nbsp;</td>
          </tr>

          <tr>
            <td height="35" align="left" width="101">&nbsp;</td>
            <td align="left" width="107">
               <b>Password:</b>
            </td>
            <td height="35" align="left" colspan="4" width="394">
              <input type="password" name="pswd1" size="55">
            </td>
            <td height="35" align="left" width="26">&nbsp;</td>
          </tr>

          <tr>
            <td height="35" align="left" width="101">&nbsp;</td>
            <td align="left" valign="bottom" width="107">
               <b>Re-enter<br>Password:</b>
            </td>
            <td height="35" align="left" valign="bottom" colspan="4" width="394">
              <input type="password" name="pswd2" size="55">
            </td>
            <td height="35" align="left" width="26">&nbsp;</td>
          </tr>

          <tr>
            <td height="35" align="left" width="101">&nbsp;</td>
            <td align="left" width="107">
               <b>Auto Expires:</b>
            </td>
            <td height="35" align="left" width="53">
              <input type="radio" name="autoExpires" value="Yes"
                <% if( ((String)al.get(4)).equals("Yes") ) { %>
                CHECKED
                <% } %> ><b>Yes</b>
            </td>
            <td height="35" align="left" width="83">
              <input type="radio" name="autoExpires" value="No"
                <% if( ((String)al.get(4)).equals("No") ) { %>
                CHECKED
                <% } %>               
              ><b>No</b>
            </td>
            <td height="35" align="left" width="275">
              <b>Uses left: </b><%= (String)al.get(5) %></td>
            <td height="35" align="left" width="15">&nbsp;</td>
            <td height="35" align="left" width="26">&nbsp;</td>
          </tr>

          <tr>
            <td height="35" align="left" width="101">&nbsp;</td>
            <td align="left" width="107">
              <input type="checkbox" name="isAdmin" value="Yes"
                <% if( ((String)al.get(3)).equals("Administrator") ) { %>
                CHECKED
                <% } %> ><b>Is Admin</b>
            </td>
            <td height="35" align="left" colspan="4" width="394">
            </td>
            <td height="35" align="left" width="26">&nbsp;</td>
          </tr>
          </table>

          <table width="278">
          <tr>
            <td align="center" width="272" colspan="2">
               <input type="button" value="Update User" onClick="checkFields(myForm)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<!--               <input type="button" value="Cancel" onClick="history.go(-2)">
-->               <input type="submit" value="Cancel" onClick="form.action='../mainForm.jsp'">
             </td>
          </tr>
          </table>
        </center>
     </td>
     <input type="hidden" name="WSaction">
     <input type="hidden" name="userID" value="<%= (String)al.get(0) %>">
    </form>
    </td>
  </tr>
</table>
  </center>
</div>
</body>