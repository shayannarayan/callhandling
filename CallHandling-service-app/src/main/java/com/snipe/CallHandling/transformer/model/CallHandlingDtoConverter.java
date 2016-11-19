package com.snipe.CallHandling.transformer.model;

import java.util.HashMap;
import java.util.List;

import javax.ws.rs.core.Response;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import com.snipe.CallHandling.bo.model.ChangePasswordBo;
import com.snipe.CallHandling.bo.model.CityBo;
import com.snipe.CallHandling.bo.model.CountryBo;
import com.snipe.CallHandling.bo.model.ForgotPassordBo;
import com.snipe.CallHandling.bo.model.GetCityBo;
import com.snipe.CallHandling.bo.model.GetCountryBo;
import com.snipe.CallHandling.bo.model.GetRoleBo;
import com.snipe.CallHandling.bo.model.GetSeverityBo;
import com.snipe.CallHandling.bo.model.GetStateBo;
import com.snipe.CallHandling.bo.model.GetTicketBo;
import com.snipe.CallHandling.bo.model.GetTicketCompBo;
import com.snipe.CallHandling.bo.model.GetTicketHistoryBo;
import com.snipe.CallHandling.bo.model.GetTicketProdBo;
import com.snipe.CallHandling.bo.model.GetTicketStatusBo;
import com.snipe.CallHandling.bo.model.LoginBo;
import com.snipe.CallHandling.bo.model.ProfileBo;
import com.snipe.CallHandling.bo.model.RoleBo;
import com.snipe.CallHandling.bo.model.SeverityBo;
import com.snipe.CallHandling.bo.model.StateBo;
import com.snipe.CallHandling.bo.model.TicketBo;
import com.snipe.CallHandling.bo.model.TicketCompBo;
import com.snipe.CallHandling.bo.model.TicketHistoryBo;
import com.snipe.CallHandling.bo.model.TicketListBo;
import com.snipe.CallHandling.bo.model.TicketProdBo;
import com.snipe.CallHandling.bo.model.TicketStatusBo;
import com.snipe.CallHandling.bo.model.UserBO;
import com.snipe.CallHandling.bo.model.UserRoleListBo;
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

public class CallHandlingDtoConverter{

	public static  UserBO convertDOTOBO(User userDO){
		ModelMapper modelMapper = new ModelMapper();
		UserBO userBo = modelMapper.map(userDO, UserBO.class);
		return userBo;
	}
	
	public static  User convertBOTODO(UserBO userBO){
		ModelMapper modelMapper = new ModelMapper();
		User user = modelMapper.map(userBO, User.class);
		return user;
	}
	
	public static  List<UserBO> convertDOsTOBOs(List<User> userDOs){
	    java.lang.reflect.Type targetListType = new TypeToken<List<UserBO>>() {}.getType();
	    List<UserBO> userBos = new ModelMapper().map(userDOs, targetListType);
		return userBos;
	}

	public static TicketDo createTicketConvertBOTODO(TicketBo ticket) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new ModelMapper();
		TicketDo createTicket = modelMapper.map(ticket, TicketDo.class);
		return createTicket; 
	}

	public static ProfileDo createProfileConvertBOTODO(ProfileBo profile) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new ModelMapper();
		ProfileDo createProfile = modelMapper.map(profile, ProfileDo.class);
		return createProfile; 
	}  

	public static TicketCompDo ticketCompCreateProfileConvertBOTODO(TicketCompBo ticketCompBo) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new ModelMapper();
		TicketCompDo ticketComp = modelMapper.map(ticketCompBo, TicketCompDo.class);
		return ticketComp; 
	}
	
	public static TicketHistoryDo createHistoryConvertBOTODO(TicketHistoryBo ticketHistory) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new ModelMapper();
		TicketHistoryDo createCicketHistory = modelMapper.map(ticketHistory, TicketHistoryDo.class);
		return createCicketHistory;      
	}  
	
	public static TicketProdDo createTicketProdConvertBOTODO(TicketProdBo ticketProdBo) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new ModelMapper();
		TicketProdDo ticketProd = modelMapper.map(ticketProdBo, TicketProdDo.class);
		return ticketProd;             
	}
	
	public static TicketStatusDo createTicketStatusConvertBOTODO(TicketStatusBo ticketStatusBo) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new ModelMapper();
		TicketStatusDo ticketStatusDo = modelMapper.map(ticketStatusBo, TicketStatusDo.class);
		return ticketStatusDo;     
	}  

	public static SeverityDo createSeverityStatusConvertBOTODO(SeverityBo severityBo) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new ModelMapper();
		SeverityDo severityDo = modelMapper.map(severityBo, SeverityDo.class);
		return severityDo; 
	}    
	
	public static CreateRoleDo createRoleConvertBOTODO(RoleBo roleBo) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new ModelMapper();
		CreateRoleDo createRoleDo = modelMapper.map(roleBo, CreateRoleDo.class);
		return createRoleDo;     
	}
	public static CityDo createCityConvertBOTODO(CityBo cityBo) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new ModelMapper();
		CityDo createRoleDo = modelMapper.map(cityBo, CityDo.class);
		return createRoleDo;     
	}  
	public static StateDo createStateConvertBOTODO(StateBo stateBo) {
		// TODO Auto-generated method stub  
		ModelMapper modelMapper = new ModelMapper();
		StateDo createRoleDo = modelMapper.map(stateBo, StateDo.class);   
		return createRoleDo;
	}
	
	public static CountryDo createCountryConvertBOTODO(CountryBo countryBo) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new ModelMapper();
		CountryDo countryDo = modelMapper.map(countryBo, CountryDo.class);   
		return countryDo;    
	}


	 public static Response getProfilesconvertDOsTOBOs(List<ProfileDo> profiles) {
		 java.lang.reflect.Type targetListType = new TypeToken<List<ProfileBo>>() {}.getType();
		    List<ProfileBo> userBos = new ModelMapper().map(profiles, targetListType);
		    HashMap map=new HashMap();
			map.put("data",userBos);
			
			return Response.ok(map).build();      
	}

	public static Response getTicketCompconvertDOsTOBOs(List<TicketCompDo> ticketComp) {
		java.lang.reflect.Type targetListType = new TypeToken<List<GetTicketCompBo>>() {}.getType();
	    List<GetTicketCompBo> ticketComps = new ModelMapper().map(ticketComp, targetListType);
	    HashMap map=new HashMap();
		map.put("data",ticketComps);
		
		return Response.ok(map).build();    
	}

	 public static Response getTicketsConvertDOsTOBOs(List<TicketDo> tickets) {
		 java.lang.reflect.Type targetListType = new TypeToken<List<GetTicketBo>>() {}.getType();
		    List<GetTicketBo> getTickets = new ModelMapper().map(tickets, targetListType);
		    HashMap map=new HashMap();
			map.put("data",getTickets);
			
			return Response.ok(map).build();      
	}

	public static Response getTicketProdConvertDOsTOBOs(List<TicketProdDo> ticketProd) {
		// TODO Auto-generated method stub
		java.lang.reflect.Type targetListType = new TypeToken<List<GetTicketProdBo>>() {}.getType();
	    List<GetTicketProdBo> getTicketsProd = new ModelMapper().map(ticketProd, targetListType);
	  
		HashMap map=new HashMap();
		map.put("data",getTicketsProd);
		
		return Response.ok(map).build();   
		  
	}

	public static Response getTicketStatusConvertDOsTOBOs(List<TicketStatusDo> ticketStatus) {
		// TODO Auto-generated method stub
		java.lang.reflect.Type targetListType = new TypeToken<List<GetTicketStatusBo>>() {}.getType();
	    List<GetTicketStatusBo> getTicketsStatus = new ModelMapper().map(ticketStatus, targetListType);
	    HashMap map=new HashMap();
		map.put("data",getTicketsStatus);
		
		return Response.ok(map).build();      
	}

	public static Response getTicketHistoryConvertDOsTOBOs(List<TicketHistoryDo> ticketHistory) {
		// TODO Auto-generated method stub
		java.lang.reflect.Type targetListType = new TypeToken<List<GetTicketHistoryBo>>() {}.getType();
	    List<GetTicketHistoryBo> getTicketsHistory= new ModelMapper().map(ticketHistory, targetListType);
	    HashMap map=new HashMap();
		map.put("data",getTicketsHistory);
		
		return Response.ok(map).build();
		}

	public static Response getSeverityConvertDOsTOBOs(List<SeverityDo> severity) {
		// TODO Auto-generated method stub
		java.lang.reflect.Type targetListType = new TypeToken<List<GetSeverityBo>>() {}.getType();
	    List<GetSeverityBo> getTicketsStatus = new ModelMapper().map(severity, targetListType);
	    HashMap map=new HashMap();
		map.put("data",getTicketsStatus);
		
		return Response.ok(map).build();
		}

	public static Response getRoleConvertDOsTOBOs(List<CreateRoleDo> role) {
		// TODO Auto-generated method stub
		java.lang.reflect.Type targetListType = new TypeToken<List<GetRoleBo>>() {}.getType();
	    List<GetRoleBo> getRole = new ModelMapper().map(role, targetListType);
	    HashMap map=new HashMap();
		map.put("data",getRole);
		
		return Response.ok(map).build();    
	}

	public static Response getCityConvertDOsTOBOs(List<CityDo> city) {
		// TODO Auto-generated method stub
		java.lang.reflect.Type targetListType = new TypeToken<List<GetCityBo>>() {}.getType();
	    List<GetCityBo> getCity = new ModelMapper().map(city, targetListType);
	    HashMap map=new HashMap();
		map.put("data",getCity);
		
		return Response.ok(map).build(); 
	}
  
	public static Response getStateConvertDOsTOBOs(List<StateDo> state) {
		// TODO Auto-generated method stub
		java.lang.reflect.Type targetListType = new TypeToken<List<GetStateBo>>() {}.getType();
	    List<GetStateBo> getState = new ModelMapper().map(state, targetListType);
	    HashMap map=new HashMap();
		map.put("data",getState);
		
		return Response.ok(map).build();   
	}

	public static Response getCounrtyConvertDOsTOBOs(List<CountryDo> counrty) {
		// TODO Auto-generated method stub
		java.lang.reflect.Type targetListType = new TypeToken<List<GetCountryBo>>() {}.getType();
	    List<GetCountryBo> getCountry = new ModelMapper().map(counrty, targetListType);
	    HashMap map=new HashMap();
		map.put("data",getCountry);
		
		return Response.ok(map).build();  
	}

	public static Response getProfileConvertDOsTOBOs(List<ProfileDo> profiles) {
		// TODO Auto-generated method stub
		java.lang.reflect.Type targetListType = new TypeToken<List<ProfileBo>>() {}.getType();
	    List<ProfileBo> getProfiles = new ModelMapper().map(profiles, targetListType);
	    HashMap map=new HashMap();
		map.put("data",getProfiles);
		
		return Response.ok(map).build();  
	}

	public static ProfileDo changepasswordconvertBOTODO(ChangePasswordBo changePassword) {
		ModelMapper modelMapper=new ModelMapper();    
		String currentPass=changePassword.getCurrentpassword();
		String username=changePassword.getUsername();
		String newPass=changePassword.getNewpassword(); 
	  //String currentPassword=changePassword.get();
		ProfileDo reg=new ProfileDo();   
		reg.setUsername(username);
		reg.setPassword(newPass);
		   
		//RegistrationDO changePass=modelMapper.map(changePassword, RegistrationDO.class); 
		return reg; 
	}



	public static ProfileDo updateProfileconvertBOTODO(ProfileBo updateUser) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new ModelMapper();
		ProfileDo updateprofile = modelMapper.map(updateUser, ProfileDo.class);
		return updateprofile; 
	}

	public static ProfileDo ForgotPasswordconvertBOTODO(ForgotPassordBo bo) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new ModelMapper();
		ProfileDo updateprofile = modelMapper.map(bo, ProfileDo.class);
		return updateprofile; 
	}
	
	public static ProfileDo loginConvertBOTODO(LoginBo login) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new ModelMapper();
		ProfileDo countryDo = modelMapper.map(login, ProfileDo.class);   
		return countryDo;    
	}

	
	public static Response getUserRoleListConvertDOsTOBOs(List<ProfileDo> list) {
		 java.lang.reflect.Type targetListType = new TypeToken<List<UserRoleListBo>>() {}.getType();
		    List<UserRoleListBo> getUserRoleList = new ModelMapper().map(list, targetListType);
		    HashMap map=new HashMap();
			map.put("data",getUserRoleList);
			
			return Response.ok(map).build(); 
	}

/*	public static Response getTicketListConvertDOsTOBOs(List<TicketDo> ticketlist) {
		 java.lang.reflect.Type targetListType = new TypeToken<List<TicketListBo>>() {}.getType();
		    List<TicketListBo> getTicketList = new ModelMapper().map(ticketlist, targetListType);
		    HashMap map=new HashMap();
			map.put("data",getTicketList);
			
			return Response.ok(map).build(); 
	} */

}

	    
 
  	    
      
	     
	  
  
	          
          
