<head>
<title>WebStocks: Main Form</title>
<SCRIPT LANGUAGE=JAVASCRIPT>
<!--
	function checkSymbol(stockAction){
		if(document.mainForm.stockSymbol.value == ""){
			alert("Please enter a stock symbol.");
			document.mainForm.stockSymbol.focus();
		}
		else{
			document.mainForm.stockSymbol.value
				= document.mainform.stockSymbol.value.toUpperCase();
			setAction(stockAction);
		}
	}
	
	function clearQuote(){
		mainForm.quoteList.value = "";
		setAction("clearQuote");
	}
	
	function setAction(doEvent){
		document.mainForm.WSaction.value= doEvent;
		document.mainForm.submit();
	}
	
	function checkUses(){
		<%
		int uses;
		if(session.getAttribute("uses") != null){
			uses = ((Integer)(session.getAttribute("uses"))).intValue();
		%>
			alert("Password is expiring after "+ <%= uses %> +" more use(s).");
			
			
			<%
			}
		%>
	}
	//-->
	</SCRIPT>
	</head>
	<body text="#824423" onLoad="checkUses()">
	<%@ page import="java.util.*" %>
	 <center>
	 <table border="0" cellspacing="0" width="55%" height="369" cellpadding="0">
		 <tr>
		    <td height="27" align="center">
		      <font size="5">WebStocks</font>
		    </td>
		  </tr>
		 <tr>
		   <td width="42%" height="341" align="center">
		     <form name="mainForm" method="POST" action="../webstocks/Webstocks">
		       <table border ="2">
		         <tr>
		           <td width="491" height="261" align="center">
		      		 <table border="0" width="84%" cellpadding="2" height="119" cellspacing="0">
		       
		         <tr>
		           <td height="26" colspan="3">
		             <b>User:
		             <%-- display uesr name form DB --%>
		             <%= (String)session.getAttribute("userName") %>
		             </b>
		            </td>
		           <td align="right">
		             <input type="submit" name="logout" value="Log out">
		            </td>
		           </tr>
		           <tr>
		              <td width="42%" align="right" height="18">&nbsp;</td>
		              <td width="9%" height="18">&nbsp;</td>
		              <td width="176%" height="18" colspan = "2"></td>
		           </tr>
		           <tr>
		             <td width="42%" align="right" height="26">
		              <input type="button" name="addStock" value="       Add Stock      " onClick="checkSymbol('addStock')">
		              
		             </td>
		             <td width="9%" height="26">&nbsp;</td>
		             <td width="176%" height="26" colspan="2" align="right">
		               <input type="text" name="stockSymbol" size="20">
		               </td>
		              </tr>
		              <tr>
		                <td width="42" align="right" height="26">           
		             		<input type="button" value="    Delete Stock    " name="delStock" onClick="checkSymbol('delStock')">
		             		
		             </td>
		              <td width="9%" height="26">&nbsp;</td>
		              <td width="176%" height="26" colspan="2" align="right">
		                <Select size="1" name="StockList" onChange="mainForm.stockSymbol.value=mainForm.StockList.value">
		                
		                <%
		                ArrayList al = (ArrayList)session.getAttribute("stocks");
		                if(al.size() < 1){
		                %>
		                	<option selected>Add a stock</option>
		                <%
		                }
		                else{
		                %>
		                	<option selected>Select a stock</option>
		                <%
		                	for(int i=0; i < al.size(); ++i){
		                	%>
		                		<option value = <%= (String)al.get(i) %> >
		                			<%= (String)al.get(i) %>
		                			</option>
		                			<%
		                			}
		                		}
		                		%>
		                		</select>
		                	    </td>
		                	  </tr>
		                	 <tr>
		                	 	<td width="42%" align="left" dir="ltr" height="24">&nbsp;</td>
		              			<td width="9%" height="24">&nbsp;</td>
		             			<td width="176%" height="18" colspan = "2">&nbsp;</td>
		             		   </tr>
		             		  <tr>
		             		    <td width="42%" align="right" height="37">
		             		      <input type="button" value="Get Stock Quote" name="getQuote" onClick="checkSymbol('getQuote')"></td>
		             		    
		             		    <td width="9%" height="37">&nbsp;</td>
		             		    <td width="176%" height="37" colspan="2" align="right">
		             		      <input type="button" value="Clear Stock Quote" onClick="clearQuote()"></td>
		             		      
		             		  </tr>
		             		  <tr>
		             		    <td width="154%" align="center" height="103" colspan="4">
		             		      <textarea rows="5" name="quoteList" cols="46"><%
		             		      if(session.getAttribute("quote") !=null) {
		             		    	  StringBuffer[] data = new StringBuffer[9];
		             		    	  StringBuffer spacer =             
		             		    			  	new StringBuffer("                  ");
		             		    	  StringTokenizer st = new StringTokenizer(
		             		    			  (String)session.getAttribute("quote"), "\",\n");
		             		    	  
		             		    	  out.println("Symbol Price Trade Date/Time");
		             		    	  out.println("     Change     Open     High     Low    Volume");
		             		    	  out.println("===============================================");
		             		    	  
		             		    	  while(st.hasMoreTokens()){
		             		    		  for(int i=0; i < 9;i++)
		             		    		  	data[i] = new StringBuffer(st.nextToken());
		             		    			  
	             		    			  out.print(data[0]);  
	             		    			  out.print(spacer.substring(0, (12 - (data[0].length()+data[1].length()))));
	             		    			  
	             		    			  out.print(data[1]); 
	             		    			  out.print(" ");
	             		    			  out.print(data[2]);  
	             		    			  out.print(" ");
	             		    			  out.print(data[3]);  
	             		    			  out.print(spacer.substring(0, (10 - (data[4].length()))));
	             		    			  out.print(data[4]);  
	             		    			  out.print(spacer.substring(0, (8 - (data[5].length()))));
	             		    			  out.print(data[5]);  
	             		    			  out.print(spacer.substring(0, (8 - (data[6].length()))));
	             		    			  out.print(data[6]);  
	             		    			  out.print(spacer.substring(0, (8 - (data[7].length()))));
	             		    			  out.print(data[7]);  
	             		    			  out.print(spacer.substring(0, (11 - (data[8].length()))));
	             		    			  out.print(data[8]);  
	             		    			  out.println("\n");
		             		    		 }
		             		    	  }
		             		    	  %>
		             		    	  </textarea>
		             		    	</td>
		             		       </tr>
		             		       <%  if(session.getAttribute("admin") != null){
		             		       %>
		             		       		<tr>
		             		       			<td width="44%" align="right" height="26">
		             		       				<input type="submit" value="      Add User      " name="addUser" onClick="mainForm.action='..//addUser.html'">
		             		       			
		             		       			
		             		       			</td>
		             		       			<td width="11%" align="right" height="26">&nbsp;</td>
		             		       			<td width="123%" align="right" height="26" colspan="2">
		             		       				<input type="submit" value="     Update User     " name="updUser" onClick="mainForm.action='..//reqUpdUser.html'">
		             		       				
		             		       				
		             		       			</td>
		             		       		   </tr>
		             		       		   <tr>
		             		       			<td width="44%" align="right" height="26">
		             		       				<input type="submit" value="      Delete User      " name="delUser" onClick="mainForm.action='..//reqDelUser.html'">
		             		       			
		             		       			
		             		       			</td>
		             		       			<td width="11%" align="right" height="26">&nbsp;</td>
		             		       			<td width="123%" align="right" height="26" colspan="2">
		             		       				<input type="submit" value="       List Users       " name="listUsers" onClick="setAction('listUsers')">
		             		       				
		             		       				
		             		       			</td>
		             		       		   </tr>
		             		       		 <%
		             		       			}
		             		       		 %>
		             		       		 </table>
		             		       	</td>
		             		       </tr>
		             		       </table>
		             		       <input type="hidden" name="WSaction">
		             		 </form>
		             		</td>
		             	</tr>
		             </table>
		             </center>
		             </body>		
}