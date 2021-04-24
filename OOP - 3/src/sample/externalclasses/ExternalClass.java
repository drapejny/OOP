package sample.externalclasses;

import sample.things.Thing;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ExternalClass implements Externalizable {

    private Thing thing;

    public Thing getThing() {
        return thing;
    }

    public void setThing(Thing thing) {
        this.thing = thing;
    }

    public ExternalClass() {
    }

    public ExternalClass(Thing thing) {
        this.thing = thing;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getThing());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        thing = (Thing) in.readObject();
    }
}
