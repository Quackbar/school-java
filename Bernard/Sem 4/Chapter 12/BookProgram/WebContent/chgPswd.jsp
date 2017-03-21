<head>
<title>WebStocks: Change Password</title>

<SCRIPT LANGUAGE=JAVASCRIPT>
<!--
  function checkPswds(myForm)
  {
    if(myForm.pswd1.value == "")
    {
      alert("Please enter a new password.");
      myForm.pswd1.focus();
    }
    else
    if(myForm.pswd2.value == "")
    {
      alert("Please re-enter password to verify.");
      myForm.pswd2.focus();
    }
    else
    if(myForm.pswd1.value != myForm.pswd2.value)
    {
      alert("Please re-enter - passwords do not match.");
      myForm.pswd1.value="";
      myForm.pswd2.value="";
      myForm.pswd1.focus();
    }
    else
    {
      myForm.logout.value = null;
      myForm.WSaction.value = "chgPswd";
      myForm.submit();
    }
  }
  
  function goBack(myForm)
  {
  <% 
    if(session.getAttribute("pswdExpired") != null)
    {
  %>   
       myForm.logout.value = "Log out";
       myForm.submit();
   <%  
    }
    else
    {
   %>       
<!--     history.back();
-->      myForm.action="../mainForm.jsp";
         myForm.submit();
   <%  
    }
   %>  
  }
  
//-->
</SCRIPT>
</head>
<body text="#824423" onLoad="document.chgPswdForm.pswd1.focus()">
<div align="center">
  <center>
<table border="0" cellspacing="0" width="55%" height="253" cellpadding="0">
  <tr>
  <td height="25">
    <p align="center">
    <font size="5">Stock Tracker</font>
  </td>
  </tr>
  <tr>
    <td width="42%" height="227">
    <form name="chgPswdForm" method="POST" action="../webstocks/WebStocks">
        <center>
       <table border="0" width="461" height="161">
          <tr>
            <td align="center">
            <b>Change Current Password for User</b>
            </td>
          </tr>
          <tr>
            <td align="center">
            <b>
               <%
               // display user name
               out.println(session.getAttribute("userName"));
               %>
            </b>
            </td>
          </tr>
          <tr>
            <td height="101" align="center">
               <b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               Enter New Password:</b>
            <input type="password" name="pswd1" size="34"><p>
               <b>Enter New Password Again:
               </b>
            <input type="password" name="pswd2" size="34"></td>
            </td>
          </tr>
          <tr>
            <td align="center" height="56">
               &nbsp;&nbsp;
               <input type="button" value="Change" name="chgPswd" 
                          onClick="checkPswds(chgPswdForm)">
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <input type="button" value="Cancel" onClick="goBack(chgPswdForm)">
             </td>
          </tr>
          </table>
        </center>
     <input type="hidden" name="WSaction">
     <input type="hidden" name="logout">
     </td>
    </form>
    </td>
  </tr>
 </table>
  </center>
</div>
</body>