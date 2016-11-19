package com.snipe.CallHandling.dao;

import java.util.List;

import javax.ws.rs.core.Response;

import com.snipe.CallHandling.bo.model.TicketHistoryBo;
import com.snipe.CallHandling.domain.model.CityDo;
import com.snipe.CallHandling.domain.model.CountryDo;
import com.snipe.CallHandling.domain.model.CreateRoleDo;
import com.snipe.CallHandling.domain.model.ProfileDo;
import com.snipe.CallHandling.domain.model.SeverityDo;
import com.snipe.CallHandling.domain.model.StateDo;
import com.snipe.CallHandling.domain.model.TicketCompDo;
import com.snipe.CallHandling.domain.model.TicketDo;
import com.snipe.CallHandling.domain.model.TicketHistoryDo;
import com.snipe.CallHandling.domain.model.TicketProdDo;
import com.snipe.CallHandling.domain.model.TicketStatusDo;
import com.snipe.CallHandling.domain.model.User;
import com.snipe.CallHandling.domain.model.UserRoleListDo;

public interface CallHandlingDao {

	void setDhcHibernateDao(BaseHibernateDao<User, Integer> dhcHibernateDao);
	
	List<User> getAllUsers();
	
	User getUser(int id);
	
	User createUser(User user);

	Response createTicket(TicketDo createMap);

	Response createProfile(ProfileDo createProfile);

	Response createTicketComp(TicketCompDo ticketComp);

	List<ProfileDo> getProfiles();

	List<TicketCompDo> getTicketComp();
  
	List<TicketDo> getTickets();

	Response createTicketHistory(TicketHistoryDo  ticketHistory);

	Response createTicketProd(TicketProdDo createTicketProd);

	List<TicketProdDo> getTicketProd();  

	Response createTicketStatus(TicketStatusDo createTicketStatusConvertBOTODO);

	List<TicketStatusDo> getTicketStatus();

	List<TicketHistoryDo> getTicketHistory();

	Response createSeverity(SeverityDo createSeverity);

	List<SeverityDo> getSeverity();

	List<CreateRoleDo> getRole();

	Response createRole(CreateRoleDo createRoleConvertBOTODO);

	Response createCity(CityDo createCityConvertBOTODO);

	List<CityDo> getCity();

	Response createState(StateDo createStateConvertBOTODO);

	List<StateDo> getState();

	Response createCountry(CountryDo createCountryConvertBOTODO);

	List<CountryDo> getCounrty();

	Response login(ProfileDo loginConvertBOTODO);

	Response getMyProfile(String username);

	Response changePassword(ProfileDo changepasswordconvertBOTODO, String currentpassword);

	Response updateUser(ProfileDo updateProfileconvertBOTODO);

	Response getTicket(int id);

	Response ForgotPassword(ProfileDo forgotPasswordconvertBOTODO);

	List<ProfileDo> getUserRoleList();

	Response ticketlist();

  
        
     
}        