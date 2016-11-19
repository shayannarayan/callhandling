package com.snipe.CallHandling.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.snipe.CallHandling.bo.model.CityBo;
import com.snipe.CallHandling.bo.model.GetCityBo;
import com.snipe.CallHandling.bo.model.GetCountryBo;
import com.snipe.CallHandling.bo.model.GetIndividualProfileBo;
import com.snipe.CallHandling.bo.model.GetProfileOutputBo;
import com.snipe.CallHandling.bo.model.GetSeverityBo;
import com.snipe.CallHandling.bo.model.GetStateBo;
import com.snipe.CallHandling.bo.model.GetTicketACtoTicketidBo;
import com.snipe.CallHandling.bo.model.GetTicketCompBo;
import com.snipe.CallHandling.bo.model.GetTicketOutputBo;
import com.snipe.CallHandling.bo.model.GetTicketStatusBo;
import com.snipe.CallHandling.bo.model.TicketListBo;
import com.snipe.CallHandling.bo.model.TicketListOutputBo;
import com.snipe.CallHandling.bo.model.TicketProdBo;
import com.snipe.CallHandling.common.Common;
import com.snipe.CallHandling.dao.BaseHibernateDao;
import com.snipe.CallHandling.dao.CallHandlingDao;
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

@Repository("dhcDao")
public class CallHandlingUserHibernateDaoImpl implements CallHandlingDao {
	private static final Log LOGGER = LogFactory.getLog(CallHandlingUserHibernateDaoImpl.class);

	@Resource(name = "dhcHibernateDao")
	private BaseHibernateDao<User, Integer> dhcHibernateDao;

	private final String HQL_LOAD_BY_LOGIN = "from ProfileDo where username = :username and password= :password";
	private final String HQL_LOAD_BY_FORGOTPASSWORD = "select password from ProfileDo where email = :email and mobile= :mobile";
	private final String HQL_LOAD_BY_CREATETICKET = "from TicketDi where id= :id";
	private final String HQL_LOAD_ALL_USER = "from User";
	private final String HQL_LOAD_ALL_SEVERITY = "from SeverityDo";
	private final String HQL_LOAD_ALL_STATE = "from StateDo";
	private final String HQL_LOAD_ALL_CITY = "from CityDo";
	private final String HQL_LOAD_ALL_COUNTRY = "from CountryDo";
	private final String HQL_LOAD_ALL_TICKETHISTORY = "from TicketHistoryDo";
	private final String HQL_LOAD_ALL_PROFILE = "from ProfileDo";
	private final String HQL_LOAD_ALL_TICKETCOMP = "from TicketCompDo";
	private final String HQL_LOAD_ALL_TICKET = "from TicketDo";
	private final String HQL_LOAD_ALL_ROLE = "from CreateRoleDo";
	private final String HQL_LOAD_BY_USER = "from User where id = :id";
	private final String HQL_LOAD_ALL_TICKETPROD = "from TicketProdDo";
	private final String HQL_LOAD_ALL_TICKETSTATUS = "from TicketStatusDo";
	private final String HQL_LOAD_ALL_GETPROFILE = "from ProfileDo ";
	private final String HQL_LOAD_ALL_GETUSERROLELIST = "Select u.username, u.status from ProfileDo u where username = :username";	

	
	
	// private final String sql="select
	// pro.firstname,pro.middlename,pro.lastname,pro.email,pro.mobile,pro.contactnumber,pro.username,pro.password,pro.status,rol.code
	// from ProfileDo pro,CreateRoleDo rol where pro.roleid=rol.id ";
	private final String HQL_LOAD_ALL_GETMYPROFILE = "Select p.firstname, p.middlename, p.lastname, p.email, p.mobile, p.contactnumber, p.username, p.roleid from ProfileDo p where username = :username  ";
	private final String HQL_LOAD_ALL_Rollname = "Select r.code, r.status from GetRollNameDo r where id = :id";
	private final String HQL_LOAD_BY_CHANGEPASSWORD = "from ProfileDo where password= :password and username= :username";


	
	
	private final String HQL_LOAD_ALL_GETTICKET = "Select t.id, t.prodid, t.compid, t.contactno, t.problem, t.rating, t.feedbackmsg, t.severityid, t.cityid, t.stateid, t.countryid, t.ticketstatusid, t.status, t.description from TicketDo t where id = :id  ";
	private final String HQL_LOAD_ALL_Productname = "Select tp.id, tp.code, tp.description, tp.status from TicketProdDo tp where id = :id";
	private final String HQL_LOAD_ALL_Cityname = "Select c.id, c.code, c.description, c.stateid, c.status from CityDo c where id = :id";
	private final String HQL_LOAD_ALL_Statename = "Select s.id, s.code, s.description, s.status, s.countryid from StateDo s where id = :id";
	private final String HQL_LOAD_ALL_Countryname = "Select c.id, c.code, c.description, c.status from CountryDo c where id = :id";
	private final String HQL_LOAD_ALL_Ticketstatus = "Select t.id, t.code, t.description, t.status from TicketStatusDo t where id = :id";
	private final String HQL_LOAD_ALL_Ticketcomp = "Select t.id, t.code, t.description, t.ticketprodid, t.status from TicketCompDo t where id = :id";
	private final String HQL_LOAD_ALL_Severity = "Select s.id, s.code, s.description, s.status from SeverityDo s where id = :id";

////	
	private final String HQL_LOAD_ALL_TICKETLIST = "from TicketDo";	
	
	
	// private final String HQL_GET_DOCTOR_HOMESCREEN= "Select d.firstname,
	// d.middlename, d.lastname, d.image, p.userid from Doctorpatientprofile d ,
	// Profile p where p.userid = d.userid and type = :type ";


	
	private final String HQL_LOAD_ALL_CITYVALID = "from CityDo where code= :code";
	private final String HQL_LOAD_ALL_TICKETSTATUSVALID = "from TicketStatusDo where code= :code";
	private final String HQL_LOAD_ALL_TICKETCOMPVALID = "from TicketCompDo where code= :code";
	private final String HQL_LOAD_ALL_TICKETHISTORYVALID = "from TicketHistoryDo where ticketid= :ticketid";
	private final String HQL_LOAD_ALL_TICKETPROVALID = "from TicketProdDo where code= :code";
	private final String HQL_LOAD_ALL_SEVERITYID = "from SeverityDo where code= :code";
	private final String HQL_LOAD_ALL_ROLEVALID = "from CreateRoleDo where code= :code";
	private final String HQL_LOAD_ALL_STATEVALID = "from StateDo where code= :code";
	private final String HQL_LOAD_ALL_COUNTRYVALID = "from CountryDo where code= :code";
	private final String HQL_LOAD_BY_REGVALIDATION = "from ProfileDo where username= :username";
	private final String HQL_LOAD_BY_REGVALIDATIONEMAIL = "from ProfileDo where email= :email";
	private final String HQL_LOAD_BY_REGVALIDATIONMOBILE = "from ProfileDo where mobile= :mobile";
	private final String HQL_LOAD_BY_REGVALIDATIONCONTACT = "from ProfileDo where contactno= :contactno";
	private final String HQL_LOAD_ALL_PRODIDVALID = "from TicketProdDo where id= :id";
	private final String HQL_LOAD_ALL_COPMIDVALID = "from TicketCompDo where id= :id1";
	private final String HQL_LOAD_ALL_SEVERITYIDVALID = "from SeverityDo where severityid= :severityid";
	private final String HQL_LOAD_ALL_CITYIDVALID = "from CityDo where cityid= :cityid";
	private final String HQL_LOAD_ALL_STATEIDVALID = "from StateDo where stateid= :stateid";
	private final String HQL_LOAD_ALL_COUNTRYIDVALID = "from CountryDo where countryid= :countryid";
	private final String HQL_LOAD_ALL_TICKECTSTATUSVALID = "from TicketStatusDo where ticketstatusid= :ticketstatusid";

	public List<User> getAllUsers() {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In getAll User");
		}
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(HQL_LOAD_ALL_USER);
		List<User> users = query.list();
		return users;
	}

	public void setDhcHibernateDao(BaseHibernateDao<User, Integer> dhcHibernateDao) {
		this.dhcHibernateDao = dhcHibernateDao;
	}

	public User getUser(int id) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In get User");
		}
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(HQL_LOAD_BY_USER);
		query.setParameter("id", id);
		List<User> user = query.list();
		return user.get(0);
	}

	public User createUser(User user) {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In createUser");
		}
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		session.saveOrUpdate(user);
		return user;
	}

	public Response createTicket(TicketDo createMap) {
		// TODO Auto-generated method stub
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In createUser");
		}

		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		session.saveOrUpdate(createMap);
		HashMap map = new HashMap();
		map.put("data", Common.common());

		return Response.ok(map).build();
	}

	public Response createProfile(ProfileDo createProfile) {
		// TODO Auto-generated method stub
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In createUser");
		}
		HashMap map = new HashMap();
		map.put("data", Common.common());
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();

		Query query = session.createQuery(HQL_LOAD_BY_REGVALIDATION);
		String username = createProfile.getUsername();
		query.setParameter("username", username);
		List<ProfileDo> user = query.list();

		if (user.isEmpty()) {
			Query query1 = session.createQuery(HQL_LOAD_BY_REGVALIDATIONEMAIL);
			String email = createProfile.getEmail();
			query1.setParameter("email", email);
			List<ProfileDo> user1 = query1.list();
			if (user1.isEmpty()) {

				Query query2 = session.createQuery(HQL_LOAD_BY_REGVALIDATIONMOBILE);
				String mobile = createProfile.getMobile();
				query2.setParameter("mobile", mobile);
				List<ProfileDo> user2 = query2.list();
				if (user2.isEmpty()) {
					Query query3 = session.createQuery(HQL_LOAD_BY_REGVALIDATIONCONTACT);
					String contactno = createProfile.getContactnumber();
					query3.setParameter("contactno", contactno);
					List<ProfileDo> user3 = query3.list();
					if (user3.isEmpty()) {
						session.saveOrUpdate(createProfile);
						// object.put("data",Common.common());
						// HashMap map=new HashMap();
					//	ArrayList al = new ArrayList();
					//	ArrayList dl = new ArrayList();
					//	map.put("status", "true");

					//	map.put("data", al);

					//	map.put("error", dl);
						// return map;
						
						return Response.ok(map).build();
						
					} else {
						map.put("status", "ContactNo already exist...!!!");
					}
				} else {
					map.put("status", "Mobile number already exist");
				}
			} else {
				map.put("status", "Email already exist");
			}
		} else {
			map.put("status", "Username already exist");
		}
	
		return Response.ok(map).build();
	}

	public Response createTicketComp(TicketCompDo ticketComp) {
		// TODO Auto-generated method stub
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In createUser");
		}
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query que = session.createQuery(HQL_LOAD_ALL_TICKETCOMPVALID);
		String code = ticketComp.getCode();
		que.setParameter("code", code);
		List<TicketCompDo> comp = que.list();
		HashMap map = new HashMap();
		if (comp.isEmpty()) {
			session.saveOrUpdate(ticketComp);

			map.put("data", Common.common());

		} else {
			map.put("data", "code is already exist");
		}

		return Response.ok(map).build();
	}

	/*
	 * public static BufferedImage decodeToImage(String imageString) {
	 * 
	 * BufferedImage image = null; byte[] imageByte; try {
	 * sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder(); imageByte
	 * = decoder.decodeBuffer(imageString); ByteArrayInputStream bis = new
	 * ByteArrayInputStream(imageByte); image = ImageIO.read(bis); bis.close();
	 * } catch (Exception e) { e.printStackTrace(); } return image; }
	 */

	/*
	 * public Response createTicketHistory(TicketHistoryDo ticketHistory) { //
	 * TODO Auto-generated method stub if(LOGGER.isDebugEnabled()) {
	 * LOGGER.debug("In createUser"); }
	 * 
	 * /* int ticketid=ticketHistory.getTicketid(); String
	 * description=ticketHistory.getDescription(); String
	 * attachment=ticketHistory.getAttachment(); int
	 * status=ticketHistory.getStatus();
	 * 
	 * String path =null;
	 * 
	 * 
	 * File files = new File("D:\\Directory2\\Sub2\\Sub-Sub2"); if
	 * (files.exists()) { if (files.mkdirs()) { System.out.println(
	 * "Multiple directories are created!"); } else { System.out.println(
	 * "Failed to create multiple directories!"); } }
	 * 
	 * 
	 * 
	 * File file = new File(
	 * "D:\\CallHandlingAttachments\\Attachments\\" + ticketid+ ""); if
	 * (!file.exists()) { if (file.mkdir()) { System.out.println(
	 * "Directory is created!"); } else {
	 * 
	 * System.out.println("Failed to create directory!"); } }
	 * 
	 * 
	 * String prescriptionquery=null; BufferedImage newImg; newImg =
	 * decodeToImage(attachment); if(!(attachment==null)) { try { path =
	 * "D:/CallHandlingAttachments/Attachments/"+ticketid+".png";
	 * ImageIO.write(newImg, "png", new File(path)); } catch (IOException e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); }
	 * prescriptionquery =
	 * "insert into \"ticket_history\" (ticketid,description,status,attachment)values('"
	 * + ticketid + "','" + description+ "','" + status + "','" + ticketid+
	 * " .png ')"; // documentquery =
	 * "INSERT INTO\"attachment\" ( type, userid, path, time, date, fromid, duserid, puserid, creationdate, modificationdate, status)VALUES( 'png', '"
	 * + userId+ "','Prescription/" + userId+ "/"+ appointmentId+
	 * ".png' , 'null', '" + com.currentstringdate() + "', 0, 0, '" + userId+
	 * "', '" + com.currentstringdate() + "', '" + com.currentstringdate() +
	 * "', 'true');";
	 * 
	 * System.out.println(prescriptionquery+"\n");
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * else { //prescriptionquery =
	 * "insert into \"prescription\" (appid,symptoms,medicinename,medicineunit,test,reconsultation,creationdate,modificationdate,byuserid,touserid,status,prescriptions,disease)values('"
	 * + appointmentId + "','" + symptoms+ "','" + medicinename + "','" +
	 * medicineunit + "','" + test + "','" + reconsultation + "','" +
	 * com.currentstringdate() + "','" + com.currentstringdate() + "','" +
	 * byuserid+ "','" + userId+ "','true','"+ prescriptions+"','" + disease+
	 * "')"; //System.out.println(prescriptionquery); System.out.println(
	 * "else   dkjhbfvkdbfv"); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * /* try { result =
	 * servicedao.appointment1(prescriptionquery,documentquery); } catch
	 * (Exception exe) { try { throw new
	 * DHCServiceException(Common.ERROR_DOCTOR_NOT_FOUND); } catch
	 * (DHCServiceException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } return result;
	 * 
	 */

	// Session session =
	// dhcHibernateDao.getSessionFactory().getCurrentSession();

	// Query que=session.createQuery(HQL_LOAD_ALL_TICKETHISTORYVALID);

	// SQLQuery query2 = session.createSQLQuery(prescriptionquery);

	/*
	 * int ticketid=createHistoryConvertBOTODO.getId();
	 * que.setParameter("ticketid",ticketid); List<TicketHistoryDo>
	 * tickethistory=que.list(); HashMap map=new HashMap();
	 * if(tickethistory.isEmpty()) {
	 * session.saveOrUpdate(createHistoryConvertBOTODO);
	 * 
	 * map.put("data", Common.common());
	 * 
	 * } else { map.put("data","code is already exist"); }
	 * 
	 * 
	 * 
	 * return Response.ok(map).build(); }
	 * 
	 */

	public Response createTicketProd(TicketProdDo createTicketProd) {
		// TODO Auto-generated method stub
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In createUser");
		}

		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query que = session.createQuery(HQL_LOAD_ALL_TICKETPROVALID);
		String code = createTicketProd.getCode();
		que.setParameter("code", code);
		List<TicketProdDo> comp = que.list();
		HashMap map = new HashMap();
		if (comp.isEmpty()) {
			session.saveOrUpdate(createTicketProd);

			map.put("data", Common.common());

		} else {
			map.put("data", "code is already exist");
		}

		return Response.ok(map).build();
	}

	public Response createTicketStatus(TicketStatusDo createTicketStatusConvertBOTODO) {
		// TODO Auto-generated method stub
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In createUser");
		}
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query que = session.createQuery(HQL_LOAD_ALL_TICKETSTATUSVALID);
		String code = createTicketStatusConvertBOTODO.getCode();
		que.setParameter("code", code);
		List<TicketStatusDo> city = que.list();
		HashMap map = new HashMap();
		if (city.isEmpty()) {
			session.saveOrUpdate(createTicketStatusConvertBOTODO);

			map.put("data", Common.common());

		} else {
			map.put("data", "code is already exist");
		}

		return Response.ok(map).build();
	}

	public Response createSeverity(SeverityDo createSeverity) {
		// TODO Auto-generated method stub
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In createUser");
		}
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();

		Query que = session.createQuery(HQL_LOAD_ALL_SEVERITYID);
		String code = createSeverity.getCode();
		que.setParameter("code", code);
		List<SeverityDo> severity = que.list();
		HashMap map = new HashMap();
		if (severity.isEmpty()) {
			session.saveOrUpdate(createSeverity);

			map.put("data", Common.common());

		} else {
			map.put("data", "code is already exist");
		}

		return Response.ok(map).build();
	}

	public Response createRole(CreateRoleDo createRoleConvertBOTODO) {
		// TODO Auto-generated method stub
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In createUser");
		}
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query que = session.createQuery(HQL_LOAD_ALL_ROLEVALID);
		String code = createRoleConvertBOTODO.getCode();
		que.setParameter("code", code);
		List<CreateRoleDo> role = que.list();
		HashMap map = new HashMap();
		if (role.isEmpty()) {
			session.saveOrUpdate(createRoleConvertBOTODO);

			map.put("data", Common.common());

		} else {
			map.put("data", "code is already exist");
		}

		return Response.ok(map).build();
	}

	public Response createCity(CityDo createCityConvertBOTODO) {
		// TODO Auto-generated method stub
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In createUser");
		}
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query que = session.createQuery(HQL_LOAD_ALL_CITYVALID);
		String code = createCityConvertBOTODO.getCode();
		que.setParameter("code", code);
		List<CityDo> city = que.list();
		HashMap map = new HashMap();
		if (city.isEmpty()) {
			session.saveOrUpdate(createCityConvertBOTODO);

			map.put("data", Common.common());

		} else {
			map.put("data", "code is already exist");
		}

		return Response.ok(map).build();
	}

	public Response createState(StateDo createStateConvertBOTODO) {
		// TODO Auto-generated method stub
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In createUser");
		}
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query que = session.createQuery(HQL_LOAD_ALL_STATEVALID);
		String code = createStateConvertBOTODO.getCode();
		que.setParameter("code", code);
		List<StateDo> state = que.list();
		HashMap map = new HashMap();
		if (state.isEmpty()) {
			session.saveOrUpdate(createStateConvertBOTODO);

			map.put("data", Common.common());

		} else {
			map.put("data", "code is already exist");
		}

		return Response.ok(map).build();
	}

	public Response createCountry(CountryDo createCountryConvertBOTODO) {
		// TODO Auto-generated method stub
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In createUser");
		}
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();

		Query que = session.createQuery(HQL_LOAD_ALL_COUNTRYVALID);
		String code = createCountryConvertBOTODO.getCode();
		que.setParameter("code", code);
		List<CountryDo> country = que.list();
		HashMap map = new HashMap();
		if (country.isEmpty()) {
			session.saveOrUpdate(createCountryConvertBOTODO);

			map.put("data", Common.common());

		} else {
			map.put("data", "code is already exist");
		}

		return Response.ok(map).build();
	}

	public List<TicketCompDo> getTicketComp() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In getAll User");
		}
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(HQL_LOAD_ALL_TICKETCOMP);
		List<TicketCompDo> getTicketComp = query.list();
		return getTicketComp;
	}

	public List<TicketDo> getTickets() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In getAll User");
		}
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(HQL_LOAD_ALL_TICKET);
		List<TicketDo> getTicket = query.list();
		return getTicket;
	}

	public List<TicketProdDo> getTicketProd() {
		// TODO Auto-generated method stub
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In getAll User");
		}
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(HQL_LOAD_ALL_TICKETPROD);
		List<TicketProdDo> getTicketProd = query.list();
		return getTicketProd;
	}

	public List<TicketStatusDo> getTicketStatus() {
		// TODO Auto-generated method stub
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In getAll User");
		}
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(HQL_LOAD_ALL_TICKETSTATUS);
		List<TicketStatusDo> getTicketStatus = query.list();
		return getTicketStatus;
	}

	public List<TicketHistoryDo> getTicketHistory() {
		// TODO Auto-generated method stub
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In getAll User");
		}
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(HQL_LOAD_ALL_TICKETHISTORY);
		List<TicketHistoryDo> getTicketHistory = query.list();
		return getTicketHistory;
	}

	public List<SeverityDo> getSeverity() {
		// TODO Auto-generated method stub
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In getAll User");
		}
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(HQL_LOAD_ALL_SEVERITY);
		List<SeverityDo> getTicketHistory = query.list();
		return getTicketHistory;
	}

	public List<CreateRoleDo> getRole() {
		// TODO Auto-generated method stub
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In getAll User");
		}
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(HQL_LOAD_ALL_ROLE);
		List<CreateRoleDo> getTicketHistory = query.list();
		return getTicketHistory;
	}

	public List<CityDo> getCity() {
		// TODO Auto-generated method stub
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In getAll User");
		}
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(HQL_LOAD_ALL_CITY);
		List<CityDo> getTicketHistory = query.list();
		return getTicketHistory;
	}

	public List<StateDo> getState() {
		// TODO Auto-generated method stub
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In getAll User");
		}
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(HQL_LOAD_ALL_STATE);
		List<StateDo> getState = query.list();
		return getState;
	}

	public List<CountryDo> getCounrty() {
		// TODO Auto-generated method stub
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In getAll User");
		}
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(HQL_LOAD_ALL_COUNTRY);
		List<CountryDo> getCountry = query.list();
		return getCountry;
	}

	public Response login(ProfileDo login) {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In createUser");
		}
		HashMap map = new HashMap();
		map.put("data", Common.common());
		try {
			Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
			Query query = session.createQuery(HQL_LOAD_BY_LOGIN);
			String username = login.getUsername();
			String password = login.getPassword();

			query.setParameter("username", username);
			query.setParameter("password", password);

			List<ProfileDo> user = query.list();

			if (user.isEmpty()) {
				map.put("status", "username/password doesnot exist login failed");
			} else {
				map.put("status", "success");
				map.put("data", user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.ok(map).build();
	}

	public List<ProfileDo> getProfiles() {
		// TODO Auto-generated method stub
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In getAll User");
		}
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(HQL_LOAD_ALL_GETPROFILE);
		List<ProfileDo> getProfiles = query.list();

		// System.out.println("aaa");

		return getProfiles;
	}
	


	public Response getMyProfile(String username) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In get User");
		}

		GetProfileOutputBo getProfileOutputBo = new GetProfileOutputBo();
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(HQL_LOAD_ALL_GETMYPROFILE);
		query.setParameter("username", username);
		// List<ProfileDo> user1 = query.list();
		String firstname = null;
		String middlename = null;
		String lastname = null;
		String emailid = null;
		String mobileno = null;
		String contactno = null;
		String usernamee = null;
		Integer id = null;

		List<Object> result = (List<Object>) query.list();
		Iterator itr = result.iterator();

		while (itr.hasNext()) {

			Object[] obj = (Object[]) itr.next();

			firstname = String.valueOf(obj[0]);
			System.out.println("patientuserid" + firstname);
			middlename = String.valueOf(obj[1]);
			lastname = String.valueOf(obj[2]);
			emailid = String.valueOf(obj[3]);
			mobileno = String.valueOf(obj[4]);
			contactno = String.valueOf(obj[5]);
			usernamee = String.valueOf(obj[6]);

			id = Integer.parseInt(String.valueOf(obj[7]));
			System.out.println("appointmentid" + id);

		}

		String rolename = null;
		Query query1 = session.createQuery(HQL_LOAD_ALL_Rollname);
		query1.setParameter("id", id);

		// String trln = user1.get(9).toString();
		List<Object> result1 = (List<Object>) query1.list();
		System.out.println("dddddd" + result1.size());
		Iterator itr1 = result1.iterator();

		if (itr1.hasNext()) {

			Object[] objc = (Object[]) itr1.next();
			rolename = String.valueOf(objc[0]);
			System.out.println("rolename=" + rolename);
			List<GetIndividualProfileBo> getIndividualProfileBos = new ArrayList<GetIndividualProfileBo>();

			GetIndividualProfileBo getIndividualProfileBo = new GetIndividualProfileBo();

			getIndividualProfileBo.setFirstname(firstname);
			getIndividualProfileBo.setMiddlename(middlename);
			getIndividualProfileBo.setLastname(lastname);
			getIndividualProfileBo.setEmail(emailid);
			getIndividualProfileBo.setMobile(mobileno);
			getIndividualProfileBo.setContactnumber(contactno);
			getIndividualProfileBo.setUsername(usernamee);
			getIndividualProfileBo.setCode(rolename);

			getIndividualProfileBos.add(getIndividualProfileBo);

			ArrayList errorarray = new ArrayList();
			getProfileOutputBo.setSuccess("true");
			getProfileOutputBo.setData(getIndividualProfileBos);
			getProfileOutputBo.setErrors(errorarray);
		}

		else {
			ArrayList dataarray = new ArrayList();
			ArrayList errorarrays = new ArrayList();
			errorarrays.add("failure");
			getProfileOutputBo.setSuccess("false");
			getProfileOutputBo.setData(dataarray);
			getProfileOutputBo.setErrors(errorarrays);

		}

		return Response.ok(getProfileOutputBo).build();
	}

	public Response createTicketHistory(TicketHistoryDo ticketHistory) {
		// TODO Auto-generated method stub
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In createUser");
		}
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();

		session.saveOrUpdate(ticketHistory);
		HashMap map = new HashMap();
		map.put("data", Common.common());

		return Response.ok(map).build();

	}

	public Response changePassword(ProfileDo changepasswordconvertBOTODO, String currentpassword) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("in change Password");
		}
		HashMap map = new HashMap();
		ArrayList al = new ArrayList();
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query query1 = session.createQuery(HQL_LOAD_BY_CHANGEPASSWORD);
		query1.setParameter("password", currentpassword);
		String username = changepasswordconvertBOTODO.getUsername();
		// System.out.println("username"+username);
		query1.setParameter("username", username);
		// System.out.println("password"+currentpassword);
		List<ProfileDo> change = query1.list();
		// System.out.println("change"+change.toString());
		// System.out.println("size"+change.size());
		if (!(change.isEmpty())) {
			String sql = "update ProfileDo set password= :newpassword where username= :username ";
			Query query = session.createQuery(sql);
			// System.out.println("query created"+query);
			// session.update(query);
			// System.out.println("updated");
			// ChangePasswordBo ch=new ChangePasswordBo();
			String newpassword = changepasswordconvertBOTODO.getPassword();
			String username1 = changepasswordconvertBOTODO.getUsername();

			query.setParameter("newpassword", newpassword);
			// System.out.println("newpass set"+newpassword);
			query.setParameter("username", username1);
			// System.out.println("username set"+username1);
			int res = query.executeUpdate();
			// session.update(query);
			// System.out.println("res"+res);
			// List<RegistrationDO> changePas=query.list();

			// System.out.println("executd");

			map.put("data", Common.common());
			// al.add("success");
		} else {
			map.put("message", "current password/employeeid doesn't exist");
		}
		return Response.ok(map).build();
	}

	public Response updateUser(ProfileDo updateProfileconvertBOTODO) {
		// TODO Auto-generated method stub
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("in updateUser");
		}
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();

		// session.saveOrUpdate(updateUser);

		String sql = "update ProfileDo set firstname= :firstname,middlename= :middlename,lastname= :lastname,email= :email,mobile= :mobile,contactnumber= :contactnumber where username= :username";
		Query query = session.createQuery(sql);
		String firstname = updateProfileconvertBOTODO.getFirstname();
		String middlename = updateProfileconvertBOTODO.getMiddlename();
		String lastname = updateProfileconvertBOTODO.getLastname();

		// String workmailid=updateUser.getEmailid();

		String email = updateProfileconvertBOTODO.getEmail();

		// String accesscardnumber=updateUser.getAccesscardnumber();
		// Date dateofbirth=updateUser.getDateofbirth();
		// Date dateofjoining=updateUser.getDateofjoining();

		String mobile = updateProfileconvertBOTODO.getMobile();
		String contactnumber = updateProfileconvertBOTODO.getContactnumber();
		String username = updateProfileconvertBOTODO.getUsername();

		// String gender=updateUser.getGender();
		// String shift=updateUser.getShift();
		// String createdby=updateUser.getCreatedby();
		// String modifiedby=updateUser.getModifiedby();
		// String rolename=updateUser.getRolename();
		// String deptname=updateUser.getDeptname();
		// String employeeid=updateUser.getEmployeeid();
		// String mobilenumber=updateUser.getMobilenumber();
		// query.setParameter("employeeid", employeeid);
		// query.setParameter("mobilenumber", mobilenumber);

		query.setParameter("username", username);
		query.setParameter("firstname", firstname);
		query.setParameter("middlename", middlename);
		query.setParameter("lastname", lastname);

		// query.setParameter("workmailid", workmailid);

		query.setParameter("email", email);

		// query.setParameter("accesscardnumber", accesscardnumber);

		query.setParameter("mobile", mobile);
		query.setParameter("contactnumber", contactnumber);

		/*
		 * query.setParameter("status", status);
		 * query.setParameter("remotelogin", remotelogin);
		 * query.setParameter("gender", gender); query.setParameter("shift",
		 * shift); query.setParameter("createdby", createdby);
		 * query.setParameter("modifiedby", modifiedby);
		 * query.setParameter("rolename", rolename);
		 * query.setParameter("deptname", deptname);
		 */
		// session.update(updateUser);

		int res = query.executeUpdate();
		HashMap map = new HashMap();
		ArrayList al = new ArrayList();
		if (res == 1) {

			al.add(Common.common());
			map.put("data", al);
		} else {
			al.add("error occured...! Username doesnot exist");
			map.put("data", al);
		}
		return Response.ok(map).build();
	}

	private TicketProdBo getTicketProdBo(int prodId) {
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query loadProdbyTicketIdQuery = session.createQuery(HQL_LOAD_ALL_Productname);
		loadProdbyTicketIdQuery.setParameter("id", prodId);

		List<Object> prodctListResult = (List<Object>) loadProdbyTicketIdQuery.list();
		Iterator itr1 = prodctListResult.iterator();
		TicketProdBo ticketProdBo = null;
		if (itr1.hasNext()) {
			ticketProdBo = new TicketProdBo();
			Object[] objc = (Object[]) itr1.next();
			ticketProdBo.setId(Integer.parseInt(String.valueOf(objc[0])));
			ticketProdBo.setCode(String.valueOf(objc[1]));
			ticketProdBo.setDescription(String.valueOf(objc[2]));
			ticketProdBo.setStatus(Integer.parseInt(String.valueOf(objc[3])));
		}

		return ticketProdBo;
	}

	private GetCityBo getCityBo(int cityId) {
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query loadCitybyTicketIdQuery = session.createQuery(HQL_LOAD_ALL_Cityname);
		loadCitybyTicketIdQuery.setParameter("id", cityId);

		List<Object> cityListResult = (List<Object>) loadCitybyTicketIdQuery.list();
		Iterator itr1 = cityListResult.iterator();
		GetCityBo getCityBo = null;
		if (itr1.hasNext()) {
			getCityBo = new GetCityBo();
			Object[] objc = (Object[]) itr1.next();
			getCityBo.setId(Integer.parseInt(String.valueOf(objc[0])));
			getCityBo.setCode(String.valueOf(objc[1]));
			getCityBo.setDescription(String.valueOf(objc[2]));
			getCityBo.setStateid(Integer.parseInt(String.valueOf(objc[3])));
			getCityBo.setStatus(Integer.parseInt(String.valueOf(objc[4])));
		}

		return getCityBo;
	}

	private GetStateBo getStateBo(int stateId) {
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query loadStatebyTicketIdQuery = session.createQuery(HQL_LOAD_ALL_Statename);
		loadStatebyTicketIdQuery.setParameter("id", stateId);

		List<Object> stateListResult = (List<Object>) loadStatebyTicketIdQuery.list();
		Iterator itr1 = stateListResult.iterator();
		GetStateBo ticketStateBo = null;
		if (itr1.hasNext()) {
			ticketStateBo = new GetStateBo();
			Object[] objc = (Object[]) itr1.next();
			ticketStateBo.setId(Integer.parseInt(String.valueOf(objc[0])));
			ticketStateBo.setCode(String.valueOf(objc[1]));
			ticketStateBo.setDescription(String.valueOf(objc[2]));
			ticketStateBo.setStatus(Integer.parseInt(String.valueOf(objc[3])));
			ticketStateBo.setCountryid(Integer.parseInt(String.valueOf(objc[4])));
		}

		return ticketStateBo;
	}

	private GetCountryBo getCountryBo(int countryId) {
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query loadCountrybyTicketIdQuery = session.createQuery(HQL_LOAD_ALL_Countryname);
		loadCountrybyTicketIdQuery.setParameter("id", countryId);

		List<Object> countryListResult = (List<Object>) loadCountrybyTicketIdQuery.list();
		Iterator itr1 = countryListResult.iterator();
		GetCountryBo ticketCountryBo = null;
		if (itr1.hasNext()) {
			ticketCountryBo = new GetCountryBo();
			Object[] objc = (Object[]) itr1.next();
			ticketCountryBo.setId(Integer.parseInt(String.valueOf(objc[0])));
			ticketCountryBo.setCode(String.valueOf(objc[1]));
			ticketCountryBo.setDescription(String.valueOf(objc[2]));
			ticketCountryBo.setStatus(Integer.parseInt(String.valueOf(objc[3])));

		}

		return ticketCountryBo;
	}

	private GetTicketStatusBo getTicketStatusBo(int ticketstatusId) {
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query loadTicketStatusbyTicketIdQuery = session.createQuery(HQL_LOAD_ALL_Ticketstatus);
		loadTicketStatusbyTicketIdQuery.setParameter("id", ticketstatusId);

		List<Object> ticketstatusListResult = (List<Object>) loadTicketStatusbyTicketIdQuery.list();
		Iterator itr1 = ticketstatusListResult.iterator();
		GetTicketStatusBo ticketStatusBo = null;
		if (itr1.hasNext()) {
			ticketStatusBo = new GetTicketStatusBo();
			Object[] objc = (Object[]) itr1.next();
			ticketStatusBo.setId(Integer.parseInt(String.valueOf(objc[0])));
			ticketStatusBo.setCode(String.valueOf(objc[1]));
			ticketStatusBo.setDescription(String.valueOf(objc[2]));
			ticketStatusBo.setStatus(Integer.parseInt(String.valueOf(objc[3])));

		}

		return ticketStatusBo;
	}

	private GetTicketCompBo getTicketCompBo(int ticketcompId) {
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query loadTicketcompbyTicketIdQuery = session.createQuery(HQL_LOAD_ALL_Ticketcomp);
		loadTicketcompbyTicketIdQuery.setParameter("id", ticketcompId);

		List<Object> ticketcompListResult = (List<Object>) loadTicketcompbyTicketIdQuery.list();
		Iterator itr1 = ticketcompListResult.iterator();
		GetTicketCompBo ticketcompBo = null;
		if (itr1.hasNext()) {
			ticketcompBo = new GetTicketCompBo();
			Object[] objc = (Object[]) itr1.next();
			ticketcompBo.setId(Integer.parseInt(String.valueOf(objc[0])));
			ticketcompBo.setCode(String.valueOf(objc[1]));
			ticketcompBo.setDescription(String.valueOf(objc[2]));
			ticketcompBo.setTicketprodid(Integer.parseInt(String.valueOf(objc[3])));
			ticketcompBo.setStatus(Integer.parseInt(String.valueOf(objc[4])));

		}

		return ticketcompBo;
	}

	private GetSeverityBo getSeverityBo(int severityId) {
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query loadTicketseveritybyTicketIdQuery = session.createQuery(HQL_LOAD_ALL_Severity);
		loadTicketseveritybyTicketIdQuery.setParameter("id", severityId);

		List<Object> ticketseverityListResult = (List<Object>) loadTicketseveritybyTicketIdQuery.list();
		Iterator itr1 = ticketseverityListResult.iterator();
		GetSeverityBo ticketseverityBo = null;
		if (itr1.hasNext()) {
			ticketseverityBo = new GetSeverityBo();
			Object[] objc = (Object[]) itr1.next();
			ticketseverityBo.setId(Integer.parseInt(String.valueOf(objc[0])));
			ticketseverityBo.setCode(String.valueOf(objc[1]));
			ticketseverityBo.setDescription(String.valueOf(objc[2]));
			ticketseverityBo.setStatus(Integer.parseInt(String.valueOf(objc[3])));

		}

		return ticketseverityBo;
	}

	public Response getTicket(int id) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In get User");
		}
		List<GetTicketACtoTicketidBo> getTicketACtoTicketidBos = new ArrayList<GetTicketACtoTicketidBo>();

		GetTicketOutputBo getTicketOutputBo = new GetTicketOutputBo();
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(HQL_LOAD_ALL_GETTICKET);
		query.setParameter("id", id);

		List<Object> result = (List<Object>) query.list();
		System.out.println("dddddd" + result.size());
		Iterator itr = result.iterator();
		GetTicketACtoTicketidBo getTicketACtoTicketidBo = null;
		while (itr.hasNext()) {
			getTicketACtoTicketidBo = new GetTicketACtoTicketidBo();
			Object[] obj = (Object[]) itr.next();
			getTicketACtoTicketidBo.setId(Integer.parseInt(String.valueOf(obj[0])));

			getTicketACtoTicketidBo.setTicketCompBo(getTicketCompBo(Integer.parseInt(String.valueOf(obj[1]))));

			getTicketACtoTicketidBo.setProductBo(getTicketProdBo(Integer.parseInt(String.valueOf(obj[2]))));

			getTicketACtoTicketidBo.setContactno(String.valueOf(obj[3]));
			getTicketACtoTicketidBo.setProblem(String.valueOf(obj[4]));
			getTicketACtoTicketidBo.setRating(Integer.parseInt(String.valueOf(obj[5])));
			getTicketACtoTicketidBo.setFeedbackmsg(String.valueOf(obj[6]));

			getTicketACtoTicketidBo.setSeverityBo(getSeverityBo(Integer.parseInt(String.valueOf(obj[7]))));

			getTicketACtoTicketidBo.setCityBo(getCityBo(Integer.parseInt(String.valueOf(obj[8]))));
			getTicketACtoTicketidBo.setStateBo(getStateBo(Integer.parseInt(String.valueOf(obj[9]))));
			getTicketACtoTicketidBo.setCountryBo(getCountryBo(Integer.parseInt(String.valueOf(obj[10]))));
			getTicketACtoTicketidBo.setTicketStatusBo(getTicketStatusBo(Integer.parseInt(String.valueOf(obj[11]))));
			getTicketACtoTicketidBo.setStatus(Integer.parseInt(String.valueOf(obj[12])));
			getTicketACtoTicketidBo.setDescription(String.valueOf(obj[13]));

		}

		getTicketACtoTicketidBos.add(getTicketACtoTicketidBo);

		ArrayList errorarray = new ArrayList();
		getTicketOutputBo.setSuccess("true");
		getTicketOutputBo.setData(getTicketACtoTicketidBos);
		getTicketOutputBo.setErrors(errorarray);

		/*
		 * int res = query.executeUpdate(); HashMap map = new HashMap(); return
		 * Response.ok(map).build();
		 */

		return Response.ok(getTicketOutputBo).build();
	}

	public Response ForgotPassword(ProfileDo forgotPasswordconvertBOTODO) {
		// TODO Auto-generated method stub
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In createUser");
		}
		HashMap object = new HashMap();
		try {
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(HQL_LOAD_BY_FORGOTPASSWORD);
		String emailId = forgotPasswordconvertBOTODO.getEmail();
		String mobile = forgotPasswordconvertBOTODO.getMobile();
		
	
		System.out.println("emaiid" + emailId);
		System.out.println("mobile" + mobile);
	
		query.setParameter("email", emailId);
		query.setParameter("mobile", mobile);
		
		List<ProfileDo> user = query.list();
		Iterator itr = user.iterator();
		System.out.println("user" + user.size());		 
		 
		if (user.isEmpty()) {
		object.put("status", "username/password doesnot exist login failed");
		} else {
		object.put("status", "success");
	
		Common common=Common.getInstance();
		//user.get(0).getPassword();
		
		List<ProfileDo> po=new ArrayList<ProfileDo>() ;
		
		po.add((ProfileDo) user);
			
	String msg="hi";
	//	String stremail="emailId";
		Common.email(po.get(0).getPassword(), emailId);
		
		
		
		
	//	System.out.println("msg" + msg);	
	//	System.out.println("stremail" + stremail);
		}
		} catch (Exception e) {
		 e.printStackTrace();
		}
		return Response.ok(object).build();
	}

	public List<ProfileDo> getUserRoleList() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In getAll User");
		}
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(HQL_LOAD_ALL_GETUSERROLELIST);
		List<ProfileDo> getUserRoleList = query.list();
		return getUserRoleList;
	}

	
	
	
	public Response ticketlist() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In getAll User");
		}
		List<TicketListBo> ticketListBos = new ArrayList<TicketListBo>();

		TicketListOutputBo ticketListOutputBo = new TicketListOutputBo();
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(HQL_LOAD_ALL_TICKETLIST);
		
		List<Object> result = (List<Object>) query.list();
		System.out.println("dddd" + result.size());
		Iterator itr = result.iterator();
		TicketListBo ticketList = null;
		
		
		while (itr.hasNext()) {
			ticketList = new TicketListBo();
			Object[] obj = (Object[]) itr.next();
			ticketList.setId(Integer.parseInt(String.valueOf(obj[0])));
			
			System.out.println("obj1" +obj[0]);

			ticketList.setTicketCompBo(getTicketCompBo(Integer.parseInt(String.valueOf(obj[1]))));

			ticketList.setProductBo(getTicketProdBo(Integer.parseInt(String.valueOf(obj[2]))));

			ticketList.setContactno(String.valueOf(obj[3]));
			ticketList.setProblem(String.valueOf(obj[4]));
			ticketList.setRating(Integer.parseInt(String.valueOf(obj[5])));
			ticketList.setFeedbackmsg(String.valueOf(obj[6]));

			ticketList.setSeverityBo(getSeverityBo(Integer.parseInt(String.valueOf(obj[7]))));

			ticketList.setCityBo(getCityBo(Integer.parseInt(String.valueOf(obj[8]))));
			ticketList.setStateBo(getStateBo(Integer.parseInt(String.valueOf(obj[9]))));
			ticketList.setCountryBo(getCountryBo(Integer.parseInt(String.valueOf(obj[10]))));
			ticketList.setTicketStatusBo(getTicketStatusBo(Integer.parseInt(String.valueOf(obj[11]))));
			ticketList.setStatus(Integer.parseInt(String.valueOf(obj[12])));
			ticketList.setDescription(String.valueOf(obj[13]));

		} 
		
		ticketListBos.add(ticketList);

		ArrayList errorarray = new ArrayList();
		ticketListOutputBo.setSuccess("true");
		ticketListOutputBo.setData(ticketListBos);
		ticketListOutputBo.setErrors(errorarray);

		
		// int res = query.executeUpdate(); HashMap map = new HashMap(); return
		 //Response.ok(map).build();
		 

		return Response.ok(ticketListOutputBo).build();


		
		
		
	}

/*		public Response getTicket(int id) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In get User");
		}
		List<GetTicketACtoTicketidBo> getTicketACtoTicketidBos = new ArrayList<GetTicketACtoTicketidBo>();

		GetTicketOutputBo getTicketOutputBo = new GetTicketOutputBo();
		Session session = dhcHibernateDao.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(HQL_LOAD_ALL_GETTICKET);
		query.setParameter("id", id);

		List<Object> result = (List<Object>) query.list();
		System.out.println("dddddd" + result.size());
		Iterator itr = result.iterator();
		GetTicketACtoTicketidBo getTicketACtoTicketidBo = null;
		while (itr.hasNext()) {
			getTicketACtoTicketidBo = new GetTicketACtoTicketidBo();
			Object[] obj = (Object[]) itr.next();
			getTicketACtoTicketidBo.setId(Integer.parseInt(String.valueOf(obj[0])));

			getTicketACtoTicketidBo.setTicketCompBo(getTicketCompBo(Integer.parseInt(String.valueOf(obj[1]))));

			getTicketACtoTicketidBo.setProductBo(getTicketProdBo(Integer.parseInt(String.valueOf(obj[2]))));

			getTicketACtoTicketidBo.setContactno(String.valueOf(obj[3]));
			getTicketACtoTicketidBo.setProblem(String.valueOf(obj[4]));
			getTicketACtoTicketidBo.setRating(Integer.parseInt(String.valueOf(obj[5])));
			getTicketACtoTicketidBo.setFeedbackmsg(String.valueOf(obj[6]));

			getTicketACtoTicketidBo.setSeverityBo(getSeverityBo(Integer.parseInt(String.valueOf(obj[7]))));

			getTicketACtoTicketidBo.setCityBo(getCityBo(Integer.parseInt(String.valueOf(obj[8]))));
			getTicketACtoTicketidBo.setStateBo(getStateBo(Integer.parseInt(String.valueOf(obj[9]))));
			getTicketACtoTicketidBo.setCountryBo(getCountryBo(Integer.parseInt(String.valueOf(obj[10]))));
			getTicketACtoTicketidBo.setTicketStatusBo(getTicketStatusBo(Integer.parseInt(String.valueOf(obj[11]))));
			getTicketACtoTicketidBo.setStatus(Integer.parseInt(String.valueOf(obj[12])));
			getTicketACtoTicketidBo.setDescription(String.valueOf(obj[13]));

		}

		getTicketACtoTicketidBos.add(getTicketACtoTicketidBo);

		ArrayList errorarray = new ArrayList();
		getTicketOutputBo.setSuccess("true");
		getTicketOutputBo.setData(getTicketACtoTicketidBos);
		getTicketOutputBo.setErrors(errorarray);

		
		// int res = query.executeUpdate(); HashMap map = new HashMap(); return
		 //Response.ok(map).build();
		 

		return Response.ok(getTicketOutputBo).build();
	}      
	
*/
	
}
