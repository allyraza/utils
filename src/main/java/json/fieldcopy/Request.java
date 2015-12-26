package json.fieldcopy;

/**
 * Created by mkhanwalkar on 12/2/15.
 */
public class Request {

    Envelope envelope ;
    Payload payload ;

    public Envelope getEnvelope() {
        return envelope;
    }

    public void setEnvelope(Envelope envelop) {
        this.envelope = envelop;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }
}
