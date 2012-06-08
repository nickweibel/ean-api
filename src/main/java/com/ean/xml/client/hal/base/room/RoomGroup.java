
package com.ean.xml.client.hal.base.room;

import java.util.ArrayList;
import java.util.List;

public class RoomGroup {
    protected List<Room> room;

    private RoomGroup() {
        //Do nothing
    }

    public RoomGroup(List<Room> room) {
        this.room = room;
    }

    public static RoomGroup getDefaultRoomGroup() {
        RoomGroup roomGroup = new RoomGroup();

        roomGroup.getRoom().add(new Room(2));

        return roomGroup;
    }

    /**
     * Gets the value of the room property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the room property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoom().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Room }
     * 
     * 
     */
    public List<Room> getRoom() {
        if (room == null) {
            room = new ArrayList<Room>();
        }
        return this.room;
    }

}
