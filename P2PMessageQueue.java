/**
 * This Queue maintains the queue of messages coming from connected clients.
 */
public class P2PMessageQueue {

    private P2PMessage head = null;
    private P2PMessage tail = null;


    /**
     * This method allows adding a message object to the existing queue.
     * @param oMessage
     */
    public synchronized void enqueue(P2PMessage oMessage){



        if (hasNodes() == false) {
            tail = oMessage;
            head = oMessage;

        }
        else {
            tail.next = oMessage;
            tail = oMessage;
        }

    }


    /**
     * This method allows removing a message object from the existing queue.
     * @return
     */
    public synchronized P2PMessage dequeue(){

        P2PMessage holdHead = head;
		if (holdHead != null){
		    head = holdHead.next;

        }
        else {
            tail = null;
        }
        return holdHead;

    }


    public boolean hasNodes(){


        return head != null;
    }
}

