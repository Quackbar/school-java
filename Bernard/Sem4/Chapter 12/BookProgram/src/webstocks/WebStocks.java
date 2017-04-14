package webstocks;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.net.*;

@WebServlet("/WebStocks")

public class WebStocks extends HttpServlet{
	StockTrackerDB db;
	public void init() throws ServletException{
		try{
			db = new StockTrackerDB();
		}
		catch(SQLException e){
			System.out.println("WebStocks: SQLException creating new database object.");
			e.printStackTrace();
			System.exit(1);
		}
		catch(ClassNotFoundException e){
			System.out.println("WebStocks: ClassNotFoundException creating new database object.");
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void destroy(){
		try{
			db.close();
		}
		catch(IOException e){
			System.out.println("WebStocks: IOException closing database.");
			e.printStackTrace();
			System.exit(1);
		}
		catch(SQLException e){
			System.out.println("WebStocks: SQLException closing database.");
			e.printStackTrace();
			System.exit(1);
		}
		catch(ClassNotFoundException e){
			System.out.println("WebStocks: ClassNotFoundException closing database.");
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doPost(req,res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		User user = null;
		String userID;
		String password;
		boolean validAction = true;

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		res.setHeader("Expires", "Tues, 01 Jan 1980 00:00:00 GMT");

		HttpSession session = req.getSession(true);

		if(logonValidated(req, res, session)){
			if(session.getAttribute("uses") != null)
				session.removeAttribute("uses");

			if(session.getAttribute("userList") != null)
				session.removeAttribute("userList");

			if(session.getAttribute("pswdExpires") != null)
				session.removeAttribute("pswdExpirest");

			userID = (String)session.getAttribute("userID");

			if(req.getParameter("logout") != null && req.getParameter("logout").equals("Log out")){
				session.invalidate();
				res.sendRedirect("index.html");
			}
			else{
				try{
					String action = req.getParameter("WSaction");
					if(action != null){
						if(action.equals("addStock")){
							addStock(req, session);
						}
						else if(action.equals("addStockDesc")){
							addStockDesc(req, session);
						}
						else if(action.equals("delStock")){
							delStock(req, session);
						}
						else if(action.equals("chgPswd")){
							chgPswd(req, session);
						}
						else if(action.equals("getQuote")){
							String stock = req.getParameter("stockSymbol");
							String quoteRequest = getQuote(stock);
							session.setAttribute("quote", quoteRequest);
							session.setAttribute("forwardTo", "mainForm.jsp");
						}
						else if(action.equals("clearQuote")){
							if(session.getAttribute("quote") != null)
								session.removeAttribute("quote");
							session.setAttribute("forwardTo", "mainForm.jsp");
						}
						else if(action.equals("addUser")){
							addUser(req);
							session.setAttribute("forwardTo", "mainForm.jsp");
						}
						else if(action.equals("relDelUser")){
							ArrayList userData = getUserData(req.getParameter("delUserID"));
							if(userData.size() > 0){
								session.setAttribute("userData", userData);
								session.setAttribute("forwardTo", "delUser.jsp");
							}
							else
								session.setAttribute("forwardTo", "badUserID.html");
						}
						else if(action.equals("delUser")){
							delUser(req.getParameter("delUserID"));
							session.setAttribute("forwardTo", "mainForm.jsp");
						}
						else if(action.equals("reqUpdUser")){
							ArrayList userData = getUserData(req.getParameter("updUserID"));
							if(userData.size() > 0){
								session.setAttribute("userData", userData);
								session.setAttribute("forwardTo", "updUser.jsp");
							}
							else
								session.setAttribute("forwardTo", "badUserID.html");
						}
						else if(action.equals("updUser")){
							updUser(req);
							session.setAttribute("forwardTo", "mainForm.jsp");
						}
						else if(action.equals("listUsers")){
							listUsers(session);
							session.setAttribute("forwardTo", "listUsers.jsp");
						}
						else
							validAction = false;
						if(validAction){
							RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/" + (String)session.getAttribute("forwardTo"));
							dispatcher.forward(req,res);
						}
						else{
							out.println("<html>");
							out.println("<head>");
							out.println("<title>WebStocks Internal Error </title>");
							out.println("</head>");
							out.println("<body text = \"#824423\" bgcolor = \"white\">");
							out.println("<h1>Internal Error</h1>");
							out.println("An invalid action was requested: " + action);
							out.println("</body>");
							out.println("</html>");								
						}
					}
					else{
						out.println("<html>");
						out.println("<head>");
						out.println("<title>WebStocks Internal Error</title>");
						out.println("</head>");
						out.println("<body text = \"#824423\" bgcolor = \"white\">");
						out.println("<h1>Internal Error</h1>");
						out.println("A null action was requested" + action);
						out.println("</body>");
						out.println("</html>");
					}
				}
				catch(PasswordException ex){
					out.println("<html>");
					out.println("<head>");
					out.println("<title>WebStocks Password Error</title>");
					out.println("</head>");
					out.println("<body text = \"#824423\" bgcolor = \"white\">");
					out.println("<h1>Invalid Password</h1>");
					out.println(ex.getMessage());
					out.println("</body>");
					out.println("</html>");
				}
				catch(SQLException ex){
					out.println("<html>");
					out.println("<head>");
					out.println("<title>WebStocks Error</title>");
					out.println("</head>");
					out.println("<body text = \"#824423\" bgcolor = \"white\">");
					out.println("<h1>SQL Exception</h1>");
					out.println(ex.getMessage());
					out.println("</body>");
					out.println("</html>");
				}
				catch(IOException ex){
					out.println("<html>");
					out.println("<head>");
					out.println("<title>WebStocks Error</title>");
					out.println("</head>");
					out.println("<body text = \"#824423\" bgcolor = \"white\">");
					out.println("<h1>IO Exception</h1>");
					out.println(ex.getMessage());
					out.println("</body>");
					out.println("</html>");
				}
				catch(ClassNotFoundException ex){
					out.println("<html>");
					out.println("<head>");
					out.println("<title>WebStocks Password Error</title>");
					out.println("</head>");
					out.println("<body text = \"#824423\" bgcolor = \"white\">");
					out.println("<h1>Class not found</h1>");
					out.println(ex.getMessage());
					out.println("</body>");
					out.println("</html>");
				}
			}
		}
	}
	
	public boolean logonValidated(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws ServletException, IOException{
		User user = null;
		String userID;
		String password;
		boolean valid = false;
		int tries = 0;
		
		PrintWriter out = res.getWriter();
		
		if(session.getAttribute("userName") == null){
			if(session.getAttribute("attempt") == null)
				session.setAttribute("attempt", new Integer(0));
			
			tries = ((Integer)(session.getAttribute("attempt"))).intValue();
			if(tries < 3){
				userID = req.getParameter("userID");
				password = req.getParameter("password");
				if(userID != null && password != null){
					session.setAttribute("userID", userID);
					try{
						user = getUser(userID);
						if(validUserPswd(user, password)){
							session.setAttribute("userName", user.getFirstName() + " " + user.getLastName());
							session.removeAttribute("attempt");
							
							if(user.pswdIsExpiring())
								session.setAttribute("uses", new Integer(user.getPswdUses()));
							
							if(user.isAdmin())
								session.setAttribute("admin", new Boolean(true));
							
							session.setAttribute("stocks", getStockList(userID));
							RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("mainForm.jsp");
							dispatcher.forward(req,res);
						}
						else{
							throw new PasswordInvalidException("Invalid user id");
						}
					}
					catch(PasswordExpiredException ex){
						session.setAttribute("pswdExpired", "yes");
						session.setAttribute("userName", user.getFirstName() + " " + user.getLastName());
						session.setAttribute("pswd", password);
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("chgPswd.jsp");
						dispatcher.forward(req,res);
					}
					catch(PasswordInvalidException ex){
						session.setAttribute("attempt", new Integer(++tries));
						ex.resetCount();
						
						if(tries < 3){
							out.println("<html>");
							out.println("<head>");
							out.println("<title>WebStocks Logon Error</title>");
							out.println("</head>");
							out.println("<body text = \"#824423\" bgcolor = \"white\">");
							out.println("<h1>Invalid User ID or Password</h1>");
							out.println(ex.getMessage());
							out.println("</body>");
							out.println("</html>");
						}
						else{
							out.println("<html>");
							out.println("<head>");
							out.println("<title>WebStocks Logon Error</title>");
							out.println("</head>");
							out.println("<body text = \"#824423\" bgcolor = \"white\">");
							out.println("<h1>Too many attempts to log on!</h1>");
							out.println(ex.getMessage());
							out.println("</body>");
							out.println("</html>");
						}
					}
					catch(PasswordException ex){
						out.println("<html>");
						out.println("<head>");
						out.println("<title>WebStocks Logon Error</title>");
						out.println("</head>");
						out.println("<body text = \"#824423\" bgcolor = \"white\">");
						out.println("<h1>PasswordException</h1>");
						out.println(ex.getMessage());
						out.println("</body>");
						out.println("</html>");
					}
					catch(ClassNotFoundException ex){
						out.println("<html>");
						out.println("<head>");
						out.println("<title>WebStocks Logon Error</title>");
						out.println("</head>");
						out.println("<body text =\"#824423\" bgcolor =\"white\">");
						out.println("<h1>ClassNotFoundException</h1>");
						out.println(ex.getMessage());
						out.println("</body>");
						out.println("</html>");
					}
					catch(SQLException ex){
						out.println("<html>");
						out.println("<head>");
						out.println("<title>WebStocks Logon Error</title>");
						out.println("</head>");
						out.println("<body text = \"#824423\" bgcolor = \"white\">");
						out.println("<h1>SQLException</h1>");
						out.println(ex.getMessage());
						out.println("</body>");
						out.println("</html>");
					}
				}
				else{
						out.println("<html>");
						out.println("<head>");
						out.println("<title>WebStocks Logon Error</title>");
						out.println("</head>");
						out.println("<body text = \"#824423\" bgcolor = \"white\">");
						out.println("<h1>Missing User ID or Password</h1>");
						out.println("</body>");
						out.println("</html>");
				}
			}
			else{
				out.println("<html>");
				out.println("<head>");
				out.println("<title>WebStocks Logon Error</title>");
				out.println("</head>");
				out.println("<body text = \"#824423\" bgcolor = \"white\">");
				out.println("<h1>Session invalidated.</h1><br>" + "<h1> The maximum for log on attempts was exceeded!</h1>");
				out.println("</body>");
				out.println("</html>");
			}
		}
		else
			valid = true;
		
		return valid;
	}
	
	private String getQuote(String stockSymbol) throws IOException{
		StringBuffer buf = new StringBuffer();
		String dataLine;
		
		try{
			URL servicePage = new URL("http://quote.yahoo.com/d/quotes.csv?symbols=" + stockSymbol + "&format=sl1d1t1c1ohgv&ext=csv");
			URLConnection conURL = servicePage.openConnection();
			conURL.connect();
			BufferedReader data = new BufferedReader(new InputStreamReader(conURL.getInputStream()));
			
			while((dataLine = data.readLine()) != null)
				buf.append(dataLine + "\n");
		}
		catch(MalformedURLException ex){
			System.out.println("Bad URL: " + ex.getMessage());
		}
		
		return buf.toString();
	}
	
	private void addStock(HttpServletRequest req, HttpSession session) throws ClassNotFoundException, ServletException, IOException, SQLException{
		String userID = (String)session.getAttribute("userID");
		String stockSymbol = req.getParameter("stockSymbol");
		String stockDesc = null;
		boolean hasStock = false;
		
		ArrayList al = (ArrayList)session.getAttribute("stocks");
		for(int i = 0; i < al.size(); ++i)
			if(stockSymbol.equals((String)al.get(i)))
				hasStock = true;
		
		if(hasStock)
			session.setAttribute("forwardTo", "mainForm.jsp");
		else{
			synchronized(db){
				stockDesc = db.getStockDesc(stockSymbol);
			}
			
			if(stockDesc == null){
				session.setAttribute("stockSymbol", stockSymbol.toUpperCase());
				session.setAttribute("forwardTo", "stockDesc.jsp");
			}
			else{
				addToUserStocks(userID, stockSymbol);
				session.setAttribute("stocks", getStockList(userID));
				session.setAttribute("forwardTo", "mainForm.jsp");
			}
		}
	}
	
	private void addStockDesc(HttpServletRequest req, HttpSession session) throws ClassNotFoundException, IOException, SQLException{
		String userID = (String)session.getAttribute("userID");
		String stockSymbol = (String)session.getAttribute("stockSymbol");
		String stockDesc = req.getParameter("stockDesc");
		
		synchronized(db){
			db.addStock(stockSymbol, stockDesc);
			addToUserStocks(userID, stockSymbol);
		}
		session.setAttribute("stocks", getStockList(userID));
		session.setAttribute("forwardTo", "mainForm.jsp");
	}
	
	private void addToUserStocks(String userID, String stockSymbol) throws ClassNotFoundException, IOException, SQLException{
		stockSymbol.trim();
		synchronized(db){
			db.addUserStocks(userID, stockSymbol.toUpperCase());
		}
	}
	
	private void delStock(HttpServletRequest req, HttpSession session) throws IOException, SQLException, ClassNotFoundException{
		String userID = (String)session.getAttribute("userID");
		String stockSymbol = req.getParameter("stockSymbol");
		synchronized(db){
			db.delUserStocks(userID, stockSymbol);
		}
		session.setAttribute("stocks", getStockList(userID));
		session.setAttribute("forwardTo", "mainForm.jsp");
	}
	
	private void chgPswd(HttpServletRequest req, HttpSession session) throws IOException, ClassNotFoundException, SQLException, PasswordException{
		String pswd1 = req.getParameter("pswd1");
		String pswd = (String)session.getAttribute("pswd");
		String userID = (String)session.getAttribute("userID");
		User user = null;
		
		if(session.getAttribute("pswdExpired") != null)
			session.removeAttribute("pswdExpired");
		
		synchronized(db){
			user = db.getUser(userID);
			user.changePassword(pswd, pswd1);
			db.updUser(user);
		}
		
		session.setAttribute("forwardTo", "mainForm.jsp");
		
		if(user.pswdIsExpiring())
			session.setAttribute("uses", new Integer(user.getPswdUses()));
		
		if(user.isAdmin())
			session.setAttribute("admin", new Boolean(true));
		
		session.setAttribute("stocks", getStockList(userID));
	}
	
	private void addUser(HttpServletRequest req) throws ClassNotFoundException, IOException, SQLException, PasswordException{
		String userID = req.getParameter("userID");
		String userFirstName = req.getParameter("userFirstName");
		String userLastName = req.getParameter("userLastName");
		String newPassword = req.getParameter("pswd1");
		String autoExpires = req.getParameter("autoExpires");
		String numUses = req.getParameter("uses");
		String adminChecked = req.getParameter("isAdmin");
		
		boolean isAdmin, autoExp;
		int uses = 0;
		
		if(adminChecked != null && adminChecked.equals("Yes"))
			isAdmin = true;
		else
			isAdmin = false;
		if(autoExpires.equals("Yes"))
			autoExp = true;
		else
			autoExp = false;
		if(autoExp && numUses != null)
			uses = Integer.parseInt(numUses);
		
		User user = new User(userID, userFirstName, userLastName, newPassword, autoExp, uses, isAdmin);
		user.expirePassword();
		
		synchronized(db){
			db.addUser(user);
		}
	}
	
	private void delUser(String userID) throws IOException, ClassNotFoundException, SQLException{
		if(userID != null){
			synchronized(db){
				User user = db.getUser(userID);
				db.delUser(user);
			}
		}
	}
	
	private void updUser(HttpServletRequest req) throws  IOException, ClassNotFoundException, SQLException, PasswordException{
		String userID = req.getParameter("userID");
		String userFirstName = req.getParameter("userFirstName");
		String userLastName = req.getParameter("userLastName");
		String newPassword = req.getParameter("pswd1");
		String autoExpires = req.getParameter("autoExpires");
		String isAdmin = req.getParameter("isAdmin");
		
		synchronized(db){
			User user = db.getUser(userID);
			if(newPassword.length() > 0)
				user.adminChangePassword(newPassword);
			user.setFirstName(userFirstName);
			user.setLastName(userLastName);
			
			if(isAdmin != null && isAdmin.equals("Yes"))
				user.setAdmin(true);
			else
				user.setAdmin(false);
			
			if(autoExpires.equals("Yes"))
				user.setAutoExpires(true);
			else
				user.setAutoExpires(false);
			
			db.updUser(user);
		}
	}
	
	private boolean validUserPswd(User user, String password) throws ClassNotFoundException, IOException, SQLException, PasswordException{
		boolean valid = false;
		
		if(user != null){
			user.validate(password);
			if(user.pswdAutoExpires())
				synchronized(db){
					db.updUser(user);
				}
			valid = true;
		}
		return valid;
	}

	private ArrayList getStockList(String userID) throws ClassNotFoundException, IOException, SQLException{
		ArrayList al = null;
		synchronized(db){
			al = db.listUserStocks(userID);
		}
		return al;
	}
	
	private void listUsers(HttpSession session) throws ClassNotFoundException, IOException, SQLException{
		ArrayList rs;
		synchronized(db){
			rs = db.listUsers();
		}
		session.setAttribute("userList", rs);
	}
	
	private User getUser(String userID) throws ClassNotFoundException, IOException, SQLException{
		User user = null;
		synchronized(db){
			user = db.getUser(userID);
		}
		return user;
	}
	
	private ArrayList getUserData(String userID) throws ClassNotFoundException, IOException, SQLException{
		ArrayList userData = new ArrayList();
		User user = null;
		
		synchronized(db){
			user = db.getUser(userID);
		}
		
		if(user != null){
			userData.add(userID);
			userData.add(user.getFirstName());
			userData.add(user.getLastName());
			if(user.isAdmin())
				userData.add("Administrator");
			else
				userData.add("Nonadministrator");
			if(user.pswdAutoExpires())
				userData.add("Yes");
			else
				userData.add("No");
			userData.add(String.valueOf(user.getPswdUses()));
		}
		return userData;
	}
}