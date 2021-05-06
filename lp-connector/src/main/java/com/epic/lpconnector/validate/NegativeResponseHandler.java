package com.epic.lpconnector.validate;

import org.jsmpp.extra.NegativeResponseException;
import org.jsmpp.util.IntUtil;

public class NegativeResponseHandler {

	public static boolean RetrySend(NegativeResponseException negres) {
		boolean retry = false;
		if (IntUtil.toHexString(negres.getCommandStatus()).contains("00000014")) { // Message queue full
			retry = true;
		} else if (IntUtil.toHexString(negres.getCommandStatus()).contains("00000058")) { // Throttling error
			retry = true;
		}   
		return retry;
	}
	
	public static boolean RetrySend(NullPointerException nullpo) {
		boolean retry = false;
		if (!nullpo.getLocalizedMessage().isEmpty()) { // Message queue full
			retry = true;
		}
		return retry;
	}

}
