package me.mosesapp.moses.dao;

import java.util.List;

import me.mosesapp.moses.model.Group;
import me.mosesapp.moses.model.GroupUser;
import me.mosesapp.moses.model.User;

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

    /**
     * Gets authenticated user's friends
     *
     * @return List of user's friends
     */
    List<User> getFriends();

    /**
     * Get users in group
     *
     * @param groupID Group ID
     * @return users in group
     */
    List<GroupUser> getGroupUser(Long groupID);

    /**
     * Get all supported currencies
     *
     * @return supported currencies
     */
    List<me.mosesapp.moses.model.Currency> getCurrencies();

}
