package com.snipe.CallHandling.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.snipe.CallHandling.bo.model.ChangePasswordBo;
import com.snipe.CallHandling.bo.model.CityBo;
import com.snipe.CallHandling.bo.model.CountryBo;
import com.snipe.CallHandling.bo.model.ForgotPassordBo;
import com.snipe.CallHandling.bo.model.GetIndividualProfileBo;
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
import com.snipe.CallHandling.domain.model.TicketDo;
import com.snipe.CallHandling.exception.CallHandlingException;
import com.snipe.CallHandling.manager.UserManager;
import com.snipe.CallHandling.service.CallHandlingService;

@Path("/v1")
@Service("dhcService")
public class CallHandlingServiceImpl implements CallHandlingService {

	@Resource(name = "dhcUser")
	private UserManager userManager;   

	
	/**
	 * {@link com.snipe.CallHandling.service.CallHandlingService#getAllUsers()}
	 */
	@GET
	@Path("/users")
	@Produces("application/json")
	public List<UserBO> getAllUsers() throws CallHandlingException{
		return userManager.getAllUser();
	}

	@GET
	@Path("/users/{userid}")
	@Produces("application/json")
	public UserBO getUser(@PathParam("userid") int userid) throws CallHandlingException {
		return userManager.getUser(userid);
	}
	
	@POST
	@Path("user")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserBO createUser(UserBO user) throws CallHandlingException {
		return userManager.createUser(user);	
	}


	@GET
	@Path("/echo")
	public void echo() {
		System.out.println("DHCServiceImpl.echo()");
	}
	
	@POST     
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)   
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(LoginBo login) throws CallHandlingException{
		return userManager.login(login);        
	}

	@POST
	@Path("createTicket")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTicket(TicketBo ticket) throws CallHandlingException {
		return userManager.createTicket(ticket);	
	}  
	
	@POST
	@Path("createProfile")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createProfile(ProfileBo profile) throws CallHandlingException {
		return userManager.createProfile(profile);	
	} 
	
	@POST
	@Path("createTicketComp")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTicketComp(TicketCompBo ticketCompBo) throws CallHandlingException {
		return userManager.createTicketComp(ticketCompBo);	
	}
	@POST
	@Path("createTicketHistory")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTicketHistory(TicketHistoryBo ticketHistorybo) throws CallHandlingException {
		return userManager.createTicketHistory(ticketHistorybo);	
	} 
	 
	@POST
	@Path("createTicketProd")   
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTicketProd(TicketProdBo ticketProdBo) throws CallHandlingException {
		return userManager.createTicketProd(ticketProdBo);	
	} 
	      
	@POST
	@Path("createTicketStatus")    
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTicketStatus(TicketStatusBo ticketStatusBo) throws CallHandlingException {
		return userManager.createTicketStatus(ticketStatusBo);	
	} 
	
    
	@POST
	@Path("createRole")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createRole(RoleBo roleBo) throws CallHandlingException {
		return userManager.createRole(roleBo);	
	} 
	
	@POST
	@Path("createSeverity")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createSeverity(SeverityBo severityBo) throws CallHandlingException {
		return userManager.createSeverity(severityBo);	
	} 
	  
	@POST 
	@Path("createCity")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCity(CityBo cityBo) throws CallHandlingException {
		return userManager.createCity(cityBo);   	
	}
	
	@POST
	@Path("createState")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createState(StateBo stateBo) throws CallHandlingException {
		return userManager.createState(stateBo);   	  
	}
	
	@POST
	@Path("createCountry")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCountry(CountryBo countryBo) throws CallHandlingException {
		return userManager.createCountry(countryBo);   	  
	}
	  
	@GET     
	@Path("/getTicketStatus")
	@Produces("application/json")
	public Response getTicketStatus() throws CallHandlingException{
		return userManager.getTicketStatus();    
	}
	
	@GET     
	@Path("/getSeverity")
	@Produces("application/json")
	public Response getSeverity() throws CallHandlingException{
		return userManager.getSeverity();    
	}   
	
	@GET     
	@Path("/getTicketHistory")
	@Produces("application/json")     
	public Response getTicketHistory() throws CallHandlingException{
		return userManager.getTicketHistory();    
	}
	
	@GET     
	@Path("/getTicketProd")
	@Produces("application/json")
	public Response getTicketProd() throws CallHandlingException{
		return userManager.getTicketProd();    
	}
	  
 
	@GET   
	@Path("/ticketComps")
	@Produces("application/json")
	public Response ticketComps() throws CallHandlingException{
		return userManager.ticketComps();  
	}
	           
	@GET  
	@Path("/tickets")      
	@Produces("application/json")
	public Response tickets() throws CallHandlingException{
		return userManager.tickets();    
	}
	
	@GET    
	@Path("/getRole")      
	@Produces("application/json")
	public Response getRole() throws CallHandlingException{
		return userManager.getRole();    
	}
	
	@GET    
	@Path("/getCity")      
	@Produces("application/json")
	public Response getCity() throws CallHandlingException{
		return userManager.getCity();    
	}
	
	@GET    
	@Path("/getState")      
	@Produces("application/json")
	public Response getState() throws CallHandlingException{
		return userManager.getState();    
	}
	
	@GET    
	@Path("/getCountry")      
	@Produces("application/json")
	public Response getCountry() throws CallHandlingException{
		return userManager.getCountry();    
	}
	
	@GET    
	@Path("/getProfiles")      
	@Produces("application/json")
	public Response getProfiles() throws CallHandlingException{
		return userManager.getProfiles();    
	}
	
	
	@GET       
	@Path("/getMyProfile/{username}")    
	@Consumes(MediaType.APPLICATION_JSON)      
	@Produces(MediaType.APPLICATION_JSON)  
	public Response getMyProfile(@PathParam("username") String username) throws CallHandlingException {
		return userManager.getMyProfile(username);
	} 
	
	@POST
	@Path("changepassword")
	@Consumes(MediaType.APPLICATION_JSON)      
	@Produces(MediaType.APPLICATION_JSON)  
	public Response changepassword(ChangePasswordBo changePassword) throws CallHandlingException{
		return userManager.changePassword(changePassword);
	}  
	
	
	@POST       
	@Path("/UpdateEmployee")              
	@Consumes(MediaType.APPLICATION_JSON)    
	@Produces(MediaType.APPLICATION_JSON)  
	public Response updateUser(ProfileBo updateUser) throws CallHandlingException {
		return  userManager.updateUser(updateUser);	  
	} 
	
	@GET       
	@Path("/getTicket/{id}")    
	@Consumes(MediaType.APPLICATION_JSON)      
	@Produces(MediaType.APPLICATION_JSON)  
	public Response getTicket(@PathParam("id") int id) throws CallHandlingException {
		return userManager.getTicket(id);
	}	
	
	@POST
	@Path("/forgotPassword")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response ForgotPassword(ForgotPassordBo forgotpassword) throws CallHandlingException{
		return userManager.ForgotPassword(forgotpassword);
	}
	

	@GET  
	@Path("/getUserRoleList")      
	@Produces("application/json")
	public Response getUserRoleList() throws CallHandlingException{
		return userManager.getUserRoleList();    
	}

	@GET  
	@Path("/ticketlist")      
	@Produces("application/json")
	public Response ticketlist() throws CallHandlingException{
		return userManager.ticketlist();    
	}
}      
   