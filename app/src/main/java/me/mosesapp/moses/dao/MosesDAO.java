package me.mosesapp.moses.dao;

import java.util.List;

import me.mosesapp.moses.model.Group;

/**
 * Created by thiago on 1/10/16.
 */
public interface MosesDAO {

    /**
     * Gets all groups from authenticated user.
     *
     * @return List of the user's groups
     */
    List<Group> getGroups();

}
