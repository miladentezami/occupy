package com.mcm.network.messages.handlers;

import com.mcm.network.SocketMessage;
import com.mcm.network.messages.BaseMessageHandler;
import org.apache.log4j.Logger;

/**
 * Created by Mehrdad on 16/12/11.
 */
public class MoveTowerMessageHandler extends BaseMessageHandler {
    private Logger logger = Logger.getLogger(MoveTowerMessageHandler.class);

    @Override
    public SocketMessage handle(SocketMessage message) {
        logger.info("Move Tower msg: " + message);

        double lat = Double.parseDouble(message.Params.get(0));
        double lon = Double.parseDouble(message.Params.get(1));

        message.Params.clear();


        message.Params.add(String.valueOf(35.70283f));
        message.Params.add(String.valueOf(51.40641f));


        message.Params.add(String.valueOf(35.70200f));
        message.Params.add(String.valueOf(51.40987f));


        message.Params.add(String.valueOf(35.70536f));
        message.Params.add(String.valueOf(51.40976f));


//        message.Params.add(String.valueOf(35.70374f));
//        message.Params.add(String.valueOf(51.40529f));

        message.Params.add(String.valueOf(35.702305));
        message.Params.add(String.valueOf(51.400487));


        return message;
    }
}