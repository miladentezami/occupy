package com.mcm.network.messages.handlers;

import com.mcm.network.SocketMessage;
import com.mcm.network.messages.BaseMessageHandler;
import org.apache.log4j.Logger;

/**
 * Created by Mehrdad on 16/12/11.
 */
public class SendUnitMessageHandler extends BaseMessageHandler {
    private Logger logger = Logger.getLogger(SendUnitMessageHandler.class);
    @Override
    public SocketMessage handle(SocketMessage message) {
        logger.info("Send unit msg: " + message);
        int buildingType = Integer.parseInt(message.Params.get(0));

        return null;
    }
}
