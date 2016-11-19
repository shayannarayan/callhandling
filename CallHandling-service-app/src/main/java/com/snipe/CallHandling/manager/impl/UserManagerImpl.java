package com.snipe.CallHandling.manager.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
import com.snipe.CallHandling.common.Common;
import com.snipe.CallHandling.dao.CallHandlingDao;
import com.snipe.CallHandling.domain.model.TicketDo;
import com.snipe.CallHandling.domain.model.TicketHistoryDo;
import com.snipe.CallHandling.domain.model.User;
import com.snipe.CallHandling.exception.CallHandlingException;
import com.snipe.CallHandling.exception.ErrorCodeEnum;
import com.snipe.CallHandling.exception.ExceptionInfo;
import com.snipe.CallHandling.manager.UserManager;
import com.snipe.CallHandling.transformer.model.CallHandlingDtoConverter;

@Component("dhcUser")
@Transactional("dhcTransactionManager")
public class UserManagerImpl implements UserManager {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(UserManagerImpl.class);
	
	@Resource(name = "dhcDao")
	private CallHandlingDao dhcDao;    

	public List<UserBO> getAllUser() {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("UserManagerImpl :: In getAll Users");
		}
		try{
			return CallHandlingDtoConverter.convertDOsTOBOs(dhcDao.getAllUsers());
			
		}catch(CallHandlingException dhe){
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
		
	}
	
	public UserBO getUser(int id){
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("UserManagerImpl :: In getUser :"+id);
		}
		try{
		return CallHandlingDtoConverter.convertDOTOBO(dhcDao.getUser(id));
		}catch(CallHandlingException dhe){
			LOGGER.error("Error in loading by user Id ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}

	public UserBO createUser(UserBO user) {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("UserManagerImpl :: In createUser");
		}
		try{
			return CallHandlingDtoConverter.convertDOTOBO(dhcDao.createUser(CallHandlingDtoConverter.convertBOTODO(user)));
		}catch(CallHandlingException dhe){
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}

	public Response createTicket(TicketBo ticket) {
		// TODO Auto-generated method stub
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("UserManagerImpl :: In createUser");
		}
		try{
			return dhcDao.createTicket(CallHandlingDtoConverter.createTicketConvertBOTODO(ticket));
		}catch(CallHandlingException dhe){
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}

	public Response createProfile(ProfileBo profile) {
		// TODO Auto-generated method stub
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("UserManagerImpl :: In createUser");
		}
		try{  
			return dhcDao.createProfile(CallHandlingDtoConverter.createProfileConvertBOTODO(profile));
		}catch(CallHandlingException dhe){
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}

	public Response createTicketComp(TicketCompBo ticketCompBo) {
		// TODO Auto-generated method stub
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("UserManagerImpl :: In createUser");
		}
		try{  
			return dhcDao.createTicketComp(CallHandlingDtoConverter.ticketCompCreateProfileConvertBOTODO(ticketCompBo));
		}catch(CallHandlingException dhe){
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}
	
	
	public Response createTicketProd(TicketProdBo ticketProdBo) {
		// TODO Auto-generated method stub
		if(LOGGER.isDebugEnabled()) {   
			LOGGER.debug("UserManagerImpl :: In createUser");  
		}
		try{      
			return dhcDao.createTicketProd(CallHandlingDtoConverter.createTicketProdConvertBOTODO(ticketProdBo));
		}catch(CallHandlingException dhe){
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}  
	   
	public Response createTicketStatus(TicketStatusBo ticketStatusBo) {
		// TODO Auto-generated method stub
		if(LOGGER.isDebugEnabled()) {   
			LOGGER.debug("UserManagerImpl :: In createUser");  
		}
		try{      
			return dhcDao.createTicketStatus(CallHandlingDtoConverter.createTicketStatusConvertBOTODO(ticketStatusBo));
		}catch(CallHandlingException dhe){
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}       

	public Response createRole(RoleBo roleBo) {
		// TODO Auto-generated method stub
		if(LOGGER.isDebugEnabled()) {   
			LOGGER.debug("UserManagerImpl :: In createUser");  
		}
		try{        
			return dhcDao.createRole(CallHandlingDtoConverter.createRoleConvertBOTODO(roleBo));
		}catch(CallHandlingException dhe){
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}
	public Response createState(StateBo stateBo) {
		// TODO Auto-generated method stub
		if(LOGGER.isDebugEnabled()) {   
			LOGGER.debug("UserManagerImpl :: In createUser");  
		}
		try{          
			return dhcDao.createState(CallHandlingDtoConverter.createStateConvertBOTODO(stateBo));
		}catch(CallHandlingException dhe){
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}
	
	public Response createCity(CityBo cityBo) {
		// TODO Auto-generated method stub 
		if(LOGGER.isDebugEnabled()) {   
			LOGGER.debug("UserManagerImpl :: In createUser");  
		}  
		try{           
			return dhcDao.createCity(CallHandlingDtoConverter.createCityConvertBOTODO(cityBo));
		}catch(CallHandlingException dhe){
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}   


	public Response ticketComps() {
		// TODO Auto-generated method stub
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("UserManagerImpl :: In getAll Users");
		}    
		try{     
			return CallHandlingDtoConverter.getTicketCompconvertDOsTOBOs(dhcDao.getTicketComp());
			  
		}catch(CallHandlingException dhe){
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}

	public Response tickets() {
		// TODO Auto-generated method stub
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("UserManagerImpl :: In getAll Users");
		}      
		try{       
			return CallHandlingDtoConverter.getTicketsConvertDOsTOBOs(dhcDao.getTickets());
			    
		}catch(CallHandlingException dhe){
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}

	public Response getTicketProd() {
		// TODO Auto-generated method stub
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("UserManagerImpl :: In getAll Users");
		}      
		try{       
			return CallHandlingDtoConverter.getTicketProdConvertDOsTOBOs(dhcDao.getTicketProd());
			    
		}catch(CallHandlingException dhe){      
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}

	public Response getTicketStatus() {
		// TODO Auto-generated method stub
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("UserManagerImpl :: In getAll Users");
		}      
		try{       
			return CallHandlingDtoConverter.getTicketStatusConvertDOsTOBOs(dhcDao.getTicketStatus());
			    
		}catch(CallHandlingException dhe){      
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}

	public Response getTicketHistory() {
		// TODO Auto-generated method stub
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("UserManagerImpl :: In getAll Users");
		}      
		try{       
			return CallHandlingDtoConverter.getTicketHistoryConvertDOsTOBOs(dhcDao.getTicketHistory());
			    
		}catch(CallHandlingException dhe){      
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}

	public Response createSeverity(SeverityBo severityBo) {
		// TODO Auto-generated method stub
		if(LOGGER.isDebugEnabled()) {   
			LOGGER.debug("UserManagerImpl :: In createUser");  
		}
		try{      
			return dhcDao.createSeverity(CallHandlingDtoConverter.createSeverityStatusConvertBOTODO(severityBo));
		}catch(CallHandlingException dhe){
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}

	public Response createCountry(CountryBo countryBo) {
		// TODO Auto-generated method stub
		if(LOGGER.isDebugEnabled()) {   
			LOGGER.debug("UserManagerImpl :: In createUser");  
		}
		try{      
			return dhcDao.createCountry(CallHandlingDtoConverter.createCountryConvertBOTODO(countryBo));
		}catch(CallHandlingException dhe){
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}
	public Response getSeverity() {
		// TODO Auto-generated method stub
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("UserManagerImpl :: In getAll Users");
		}      
		try{       
			return CallHandlingDtoConverter.getSeverityConvertDOsTOBOs(dhcDao.getSeverity());
			      
		}catch(CallHandlingException dhe){      
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}

	public Response getRole() {
		// TODO Auto-generated method stub
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("UserManagerImpl :: In getAll Users");
		}        
		try{       
			return CallHandlingDtoConverter.getRoleConvertDOsTOBOs(dhcDao.getRole());
			      
		}catch(CallHandlingException dhe){      
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}

	public Response getCity() {
		// TODO Auto-generated method stub
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("UserManagerImpl :: In getAll Users");
		}        
		try{       
			return CallHandlingDtoConverter.getCityConvertDOsTOBOs(dhcDao.getCity());
			      
		}catch(CallHandlingException dhe){      
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}

	public Response getState() {
		// TODO Auto-generated method stub
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("UserManagerImpl :: In getAll Users");
		}        
		try{       
			return CallHandlingDtoConverter.getStateConvertDOsTOBOs(dhcDao.getState());
			      
		}catch(CallHandlingException dhe){      
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}

	public Response getCountry() {
		// TODO Auto-generated method stub
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("UserManagerImpl :: In getAll Users");
		}        
		try{       
			return CallHandlingDtoConverter.getCounrtyConvertDOsTOBOs(dhcDao.getCounrty());
			      
		}catch(CallHandlingException dhe){      
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}

	public Response login(LoginBo login) {
		// TODO Auto-generated method stub
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug("UserManagerImpl :: In getAll Users");  
		} 
		          
		try{    
			return dhcDao.login(CallHandlingDtoConverter.loginConvertBOTODO(login));
			    
		}catch(CallHandlingException dhe){        
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		    
	}          
	}


	public Response getProfiles() {
		// TODO Auto-generated method stub
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("UserManagerImpl :: In getAll Users");
		}        
		try{       
			return CallHandlingDtoConverter.getProfileConvertDOsTOBOs(dhcDao.getProfiles());
			      
		}catch(CallHandlingException dhe){      
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}

	public Response getMyProfile(String username) {
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug("UserManagerImpl :: In getAll Users");  
		}     
		                 
		try{ 
			return dhcDao.getMyProfile(username);   
			          
		}catch(CallHandlingException dhe){        
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		    
		}
	}

	public Response createTicketHistory(TicketHistoryBo ticketHistorybo) {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("UserManagerImpl :: In createUser");
		}
		try{      
			

			if(ticketHistorybo.getAttachment()==null)
			{
				System.out.println("Attachment is empty");

			}
			else
			{
				System.out.println("Attachment is not empty");
				
			BufferedImage newImg;
			Common common=Common.getInstance();
	        newImg = common.decodeToImage(ticketHistorybo.getAttachment());
	        try {
	        	String path="D:/TicketImages/"+ ticketHistorybo.getDescription()+ ".png";
				ImageIO.write(newImg, "png", new File(path));
				ticketHistorybo.setAttachment(path);
			} catch (IOException e)
	        {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
			
			return dhcDao.createTicketHistory(CallHandlingDtoConverter.createHistoryConvertBOTODO(ticketHistorybo));
			//return dhcDao.createTicketHistory(ticketHistorybo);
		}catch(CallHandlingException dhe){
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}

	public Response changePassword(ChangePasswordBo changePassword) {
		// TODO Auto-generated method stub
		if(LOGGER.isDebugEnabled()) {  
			LOGGER.debug("UserManagerImpl :: In createUser");
		}    
		try{    
			changePassword.getCurrentpassword();
			return dhcDao.changePassword(CallHandlingDtoConverter.changepasswordconvertBOTODO(changePassword),changePassword.getCurrentpassword());
		}catch(CallHandlingException dhe){  
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}

	public Response updateUser(ProfileBo updateUser) {
		// TODO Auto-generated method stub
		if(LOGGER.isDebugEnabled()) {  
			LOGGER.debug("UserManagerImpl :: In createUser");
		}     
		try{      
			return dhcDao.updateUser(CallHandlingDtoConverter.updateProfileconvertBOTODO(updateUser));
		}catch(CallHandlingException dhe){  
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}

	public Response getTicket(int id) {
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug("UserManagerImpl :: In getAll Users");  
		}     
		                 
		try{ 
			return dhcDao.getTicket(id);   
			          
		}catch(CallHandlingException dhe){        
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		    
		}
	}

	public Response ForgotPassword(ForgotPassordBo bo) {
		// TODO Auto-generated method stub
		if(LOGGER.isDebugEnabled()) {  
			LOGGER.debug("UserManagerImpl :: In ForgotPassword");
		}     
		try{      
			return dhcDao.ForgotPassword(CallHandlingDtoConverter.ForgotPasswordconvertBOTODO(bo));
		}catch(CallHandlingException dhe){  
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
		
		/*if(LOGGER.isDebugEnabled()){
			LOGGER.debug("UserManagerImpl :: In getAll Users");  
		} 
		          
		try{    
			return dhcDao.login(UserDtoConverter.loginConvertBOTODO(login));
			    
		}catch(CallHandlingException dhe){        
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		    
	} */  
	}

	public Response getUserRoleList() {
		// TODO Auto-generated method stub
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("UserManagerImpl :: In getAll Users");
		}      
		try{       
			return CallHandlingDtoConverter.getUserRoleListConvertDOsTOBOs(dhcDao.getUserRoleList());
			    
		}catch(CallHandlingException dhe){
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}

	public Response ticketlist() {
		// TODO Auto-generated method stub
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("UserManagerImpl :: In getAll Users");
		}      
		try{       
			return dhcDao.ticketlist();
			    
		}catch(CallHandlingException dhe){
			LOGGER.error("Error in loading all users info ",dhe);
			throw new CallHandlingException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}


}
   