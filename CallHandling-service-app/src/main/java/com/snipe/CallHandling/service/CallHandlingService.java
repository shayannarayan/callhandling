package com.snipe.CallHandling.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.snipe.CallHandling.bo.model.ChangePasswordBo;
import com.snipe.CallHandling.bo.model.CityBo;
import com.snipe.CallHandling.bo.model.CountryBo;
import com.snipe.CallHandling.bo.model.ForgotPassordBo;
import com.snipe.CallHandling.bo.model.LoginBo;
import com.snipe.CallHandling.bo.model.ProfileBo;
import com.snipe.CallHandling.bo.model.RoleBo;
import com.snipe.CallHandling.bo.model.SeverityBo;
import com.snipe.CallHandling.bo.model.StateBo;
import com.snipe.CallHandling.bo.model.TicketBo;
import com.snipe.CallHandling.bo.model.TicketCompBo;
import com.snipe.CallHandling.bo.model.TicketHistoryBo;
import com.snipe.CallHandling.bo.model.TicketProdBo;
import com.snipe.CallHandling.bo.model.TicketStatusBo;
import com.snipe.CallHandling.bo.model.UserBO;
import com.snipe.CallHandling.exception.CallHandlingException;
/**
 * Purpose: This service used as webService interface for the client requests 
 * it process and response based method invoked and parameters of request
 * 
 * Created Date:
 * Modified Date:
 * @author Laxmikanth
 *
 */
public interface CallHandlingService {

	/**
	 * This method loads all the users like list of admin's, engineers, managers and customers
	 * @return list of users represents admin, engineer, manager and customer
	 * @throws CallHandlingException 
	 */
	public List<UserBO> getAllUsers() throws CallHandlingException;

	
	public Response getUserRoleList() throws CallHandlingException;
	
	@GET
	@Path("/users/{userid}")
	@Produces("application/json")
	public UserBO getUser(@PathParam("userid") int userid) throws CallHandlingException;
	
	
	@POST
	@Path("user")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserBO createUser(UserBO user) throws CallHandlingException; 

	
	
	@POST     
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)   
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(LoginBo login) throws CallHandlingException;
		

	@POST
	@Path("createTicket")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTicket(TicketBo ticket) throws CallHandlingException;
	
	@POST
	@Path("createProfile")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createProfile(ProfileBo profile) throws CallHandlingException; 
	
	@POST
	@Path("createTicketComp")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTicketComp(TicketCompBo ticketCompBo) throws CallHandlingException;
	
	@POST
	@Path("createTicketHistory")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTicketHistory(TicketHistoryBo ticketHistorybo) throws CallHandlingException;
	 
	@POST
	@Path("createTicketProd")   
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTicketProd(TicketProdBo ticketProdBo) throws CallHandlingException;
	      
	@POST
	@Path("createTicketStatus")    
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTicketStatus(TicketStatusBo ticketStatusBo) throws CallHandlingException;
	
    
	@POST
	@Path("createRole")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createRole(RoleBo roleBo) throws CallHandlingException;
	
	@POST
	@Path("createSeverity")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createSeverity(SeverityBo severityBo) throws CallHandlingException;
	  
	@POST 
	@Path("createCity")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCity(CityBo cityBo) throws CallHandlingException;
	
	@POST
	@Path("createState")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createState(StateBo stateBo) throws CallHandlingException;
	
	@POST
	@Path("createCountry")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCountry(CountryBo countryBo) throws CallHandlingException;
	
	@Path("/getTicketStatus")
	@Produces("application/json")
	public Response getTicketStatus() throws CallHandlingException;
	
	@GET     
	@Path("/getSeverity")
	@Produces("application/json")
	public Response getSeverity() throws CallHandlingException;  
	
	@GET     
	@Path("/getTicketHistory")
	@Produces("application/json")     
	public Response getTicketHistory() throws CallHandlingException;
	
	@GET     
	@Path("/getTicketProd")
	@Produces("application/json")
	public Response getTicketProd() throws CallHandlingException;
	  
 
	@GET   
	@Path("/ticketComps")
	@Produces("application/json")
	public Response ticketComps() throws CallHandlingException;
	           
	@GET  
	@Path("/tickets")      
	@Produces("application/json")
	public Response tickets() throws CallHandlingException;
	
	@GET    
	@Path("/getRole")      
	@Produces("application/json")
	public Response getRole() throws CallHandlingException;
	
	@GET    
	@Path("/getCity")      
	@Produces("application/json")
	public Response getCity() throws CallHandlingException;
	
	@GET    
	@Path("/getState")      
	@Produces("application/json")
	public Response getState() throws CallHandlingException;
	
	@GET    
	@Path("/getCountry")      
	@Produces("application/json")
	public Response getCountry() throws CallHandlingException;
	
	@GET    
	@Path("/getProfiles")      
	@Produces("application/json")
	public Response getProfiles() throws CallHandlingException;
	
	
	@GET       
	@Path("/getMyProfile/{username}")    
	@Consumes(MediaType.APPLICATION_JSON)      
	@Produces(MediaType.APPLICATION_JSON)  
	public Response getMyProfile(@PathParam("username") String username) throws CallHandlingException;
	
	@POST
	@Path("changepassword")
	@Consumes(MediaType.APPLICATION_JSON)      
	@Produces(MediaType.APPLICATION_JSON)  
	public Response changepassword(ChangePasswordBo changePassword) throws CallHandlingException;
	
	
	@POST       
	@Path("/UpdateEmployee")              
	@Consumes(MediaType.APPLICATION_JSON)    
	@Produces(MediaType.APPLICATION_JSON)  
	public Response updateUser(ProfileBo updateUser) throws CallHandlingException;
	
	@GET       
	@Path("/getTicket/{id}")    
	@Consumes(MediaType.APPLICATION_JSON)      
	@Produces(MediaType.APPLICATION_JSON)  
	public Response getTicket(@PathParam("id") int id) throws CallHandlingException;
	
	@POST
	@Path("/forgotPassword")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response ForgotPassword(ForgotPassordBo forgotpassword) throws CallHandlingException;
	
	
}
