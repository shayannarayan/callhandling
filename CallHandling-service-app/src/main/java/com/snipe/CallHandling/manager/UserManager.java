package com.snipe.CallHandling.manager;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Response;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

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
import com.snipe.CallHandling.domain.model.TicketDo;

public interface UserManager {
	
	List<UserBO> getAllUser();
	
	UserBO getUser(@NotBlank @NotEmpty @NotNull int id);
	
	UserBO createUser(UserBO user);

	Response createTicket(TicketBo ticket);

	Response createProfile(ProfileBo profile);

	Response createTicketComp(TicketCompBo ticketCompBo);
          
	Response ticketComps();

	Response tickets();
  
	Response createTicketHistory(TicketHistoryBo ticketHistorybo);

	Response createTicketProd(TicketProdBo ticketProdBo);

	Response getTicketProd();

	Response createTicketStatus(TicketStatusBo ticketStatusBo);

	Response getTicketStatus(); 

	Response createRole(RoleBo roleBo);

	Response getTicketHistory();

	Response createSeverity(SeverityBo severityBo);

	Response getSeverity();
   
	Response getRole();

	Response createCity(CityBo cityBo);

	Response getCity();

	Response createState(StateBo stateBo);

	Response getState();

	Response createCountry(CountryBo countryBo);

	Response getCountry();

	Response login(LoginBo login);

	Response getProfiles();

	Response getMyProfile(String username);

	Response changePassword(ChangePasswordBo changePassword);

	Response updateUser(ProfileBo updateUser);

	Response getTicket(int id);
	
	Response ForgotPassword(ForgotPassordBo bo);

	Response getUserRoleList();

	Response ticketlist();






  
	           
               
}            
      