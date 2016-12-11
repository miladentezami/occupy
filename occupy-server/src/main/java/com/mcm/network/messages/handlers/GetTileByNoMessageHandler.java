package com.mcm.network.messages.handlers;

import com.mcm.network.SocketMessage;
import com.mcm.network.messages.BaseMessageHandler;
import com.mcm.service.Tile;
import org.apache.axis.encoding.Base64;
import org.apache.log4j.Logger;

/**
 * Created by Mehrdad on 16/12/11.
 */
public class GetTileByNoMessageHandler extends BaseMessageHandler {
    private Logger logger = Logger.getLogger(GetTileByNoMessageHandler.class);
    @Override
    public SocketMessage handle(SocketMessage message) {
        logger.info("Get Tile by no msg: " + message);
        int tileX = Integer.parseInt(message.Params.get(0));
        int tileY = Integer.parseInt(message.Params.get(1));

        Tile tile = new Tile(tileX,tileY);

        message.Params.clear();
        message.Params.add(Base64.encode(tile.getImage()));

        message.Params.add(String.valueOf(tile.getCenter().getX()));
        message.Params.add(String.valueOf(tile.getCenter().getY()));

        message.Params.add(String.valueOf(tile.getBoundingBox().north));
        message.Params.add(String.valueOf(tile.getBoundingBox().east));
        message.Params.add(String.valueOf(tile.getBoundingBox().south));
        message.Params.add(String.valueOf(tile.getBoundingBox().west));

        return message;
    }
}
