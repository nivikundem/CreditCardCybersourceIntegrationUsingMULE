package com.cybersource.interceptor;
import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.interceptor.AbstractEnvelopeInterceptor;
import org.mule.management.stats.ProcessingTime;

public class Logger extends AbstractEnvelopeInterceptor{

	private static Log logger = LogFactory.getLog(Logger.class);
	
	private String apiEndpoint;
	private String flowname;
	private long startTime;
	
	@Override
	public MuleEvent before(MuleEvent event) throws MuleException {
		try {
			 startTime=Calendar.getInstance().getTimeInMillis();
			 flowname = (String) event.getFlowConstruct().getName();			
			 apiEndpoint = event.getMessage().getInboundProperty("http.request.uri");
			 String payload=event.getMessageAsString();			
			 logger.info("[" + event.getMessage().getMessageRootId() + "] ["+flowname+"] [Audit Begin] [endpoint:"+apiEndpoint +"] [" + payload + "]");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return event;
	}

	@Override
	public MuleEvent after(MuleEvent event) throws MuleException {
		return event;
	}

	@Override
	public MuleEvent last(MuleEvent event, ProcessingTime time, long startTime,
			boolean exceptionWasThrown) throws MuleException {
		long processingTime= Calendar.getInstance().getTimeInMillis()-this.startTime;
		 String payload=event.getMessageAsString();
		 logger.info("[" + event.getMessage().getMessageRootId() + "] ["+flowname+"] [Audit End] [endpoint:"+apiEndpoint +"]  [processingTime:" + processingTime + "] [" + payload + "]");

		return event;
	}

}
