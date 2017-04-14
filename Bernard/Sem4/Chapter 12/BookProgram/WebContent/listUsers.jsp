<head>
<title>WebStocks: List Users</title>
</head>
<body text="#824423">
<%@ page import="java.util.*" %>
<div align="center">
  <center>
<table border="0" cellspacing="0" width="55%" height="253" style="border-collapse: collapse" cellpadding="0">
  <tr>
  <td height="25">
    <p align="center">
    <font size="5">WebStocks</font>
  </td>
  </tr>
  <tr>
    <td width="42%" height="227">
    <form name="form" method="POST">
        <center>
       <table border="0" width="461" height="123">
          <tr>
            <td height="25" align="center">
              <font size="5">User List</font>
            </td>
          </tr>
          <tr>
            <td height="84" align="center">
            
            <textarea rows="10" name="report" cols="40">
  <%
    // display user list from DB
    out.println("\nUser ID\tUser Name\tAdministrator");
    out.println(  "=======\t===============\t=============");

    ArrayList rs = (ArrayList)session.getAttribute("userList");
    if(rs.size() > 0)
    {
        for(int i=0; i < rs.size(); ++i)
        {
        out.print(rs.get(i)+"\t");
        out.print(rs.get(++i)+" ");
        out.print(rs.get(++i)+"\t");
        out.println(rs.get(++i));
        }
    }
  %>
            </textarea>
            </td>
          </tr>
          <tr>
            <td align="center">
               <input type="submit" value="Close" onClick="form.action='../mainForm.jsp'">
             </td>
          </tr>
          </table>
        </center>
    </form>
    </td>
  </tr>
</table>
  </center>
</div>
</body>