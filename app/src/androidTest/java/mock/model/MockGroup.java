package mock.model;

import me.mosesapp.moses.model.Group;

/**
 * Created by thiago on 1/10/16.
 */
public class MockGroup extends Group {
    public MockGroup(){
        this.setName("Test Group");
    }

    public MockGroup(String name){
        this.setName(name);
    }
}
