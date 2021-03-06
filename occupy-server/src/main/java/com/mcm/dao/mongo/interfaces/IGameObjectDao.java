package com.mcm.dao.mongo.interfaces;

import com.mcm.entities.mongo.gameObjects.BaseGameObject;
import com.mcm.entities.mongo.gameObjects.playerObjects.BasePlayerObject;
import com.mcm.entities.mongo.gameObjects.playerObjects.Tower;

import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by alirezaghias on 10/19/2016 AD.
 */

public interface IGameObjectDao extends IBaseMongoDao<BaseGameObject> {
    LinkedHashSet<BaseGameObject> gameObjectsNear(BasePlayerObject playerObject);
    List<Tower> getAllTowersInBox(double[] lowerLeft, double[] upperRight);
    Tower findTowerById(String id);
}
