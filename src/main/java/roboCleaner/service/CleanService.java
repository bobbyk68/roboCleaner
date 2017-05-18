package roboCleaner.service;

import roboCleaner.core.Message;
import roboCleaner.core.ResponseMessage;

public interface CleanService {
	
	public ResponseMessage cleanRoom(Message request);

}
