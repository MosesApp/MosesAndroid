package mock.dao;

import java.util.Arrays;
import java.util.List;

import me.mosesapp.moses.dao.MosesDAO;
import me.mosesapp.moses.model.Group;
import mock.model.MockGroup;

/**
 * Created by thiago on 1/10/16.
 */
public class MosesDAOImpl implements MosesDAO {
    @Override
    public List<Group> getGroups() {

        return Arrays.asList((Group) new MockGroup("Test Group"), new MockGroup("Moses' Friends"), new MockGroup("Home"));
    }
}
