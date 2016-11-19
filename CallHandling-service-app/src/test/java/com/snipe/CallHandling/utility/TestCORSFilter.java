package com.snipe.CallHandling.utility;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import com.snipe.CallHandling.utility.CORSFilter;




public class TestCORSFilter {

	CORSFilter corsFilter = new CORSFilter();
		
	@Test
	public void testFilter() {
		try {
			ContainerResponseContext cres = PowerMockito.mock(ContainerResponseContext.class);
			ContainerRequestContext requestContext = PowerMockito.mock(ContainerRequestContext.class);

			MultivaluedMap<String, Object> multiValueMap = new MultivaluedHashMap<String, Object>();
			PowerMockito.when(cres.getHeaders()).thenReturn(multiValueMap);
			corsFilter.filter(requestContext, cres);
			Assert.assertTrue(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
