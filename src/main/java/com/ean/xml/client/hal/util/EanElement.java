package com.ean.xml.client.hal.util;

import com.ean.xml.client.hal.base.properties.HotelAvailOption;
import com.ean.xml.client.hal.base.room.Room;
import com.ean.xml.client.hal.base.room.RoomGroup;
import com.ean.xml.client.hal.base.supplier.SupplierType;
import com.ean.xml.client.hal.responses.HotelRoomResponse;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.tree.DefaultElement;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class EanElement extends DefaultElement {
    public DateTimeFormatter DATE_FORMATTER = DateTimeFormat.forPattern("MM/dd/yyyy");

    // CONSTRUCTORS
    public EanElement(String name) {
        super(name);
    }

    public EanElement(QName qname) {
        super(qname);
    }

    public EanElement(QName qname, int attributeCount) {
        super(qname, attributeCount);
    }

    public EanElement(String name, Namespace namespace) {
        super(name, namespace);
    }

    // HELPING ELEMENT ADDS
    public void addElementString(String targetName, String targetValue) {
        if (StringUtils.isNotBlank(targetValue)) {
            this.addElement(targetName).setText(targetValue);
        }
    }

    public void addElementDateTime(String targetName, DateTime dateTime) {
        if (dateTime != null) {
            this.addElement(targetName).setText(dateTime.toString(DATE_FORMATTER));
        }
    }

    public void addElementInteger(String targetName, Integer targetValue) {
        if (targetValue != null) {
            this.addElement(targetName).setText(String.valueOf(targetValue));
        }
    }

    public void addElementLong(String targetName, Long targetValue) {
        if (targetValue != null) {
            this.addElement(targetName).setText(String.valueOf(targetValue));
        }
    }

    public void addElementFloat(String targetName, Float targetValue) {
        if (targetValue != null) {
            this.addElement(targetName).setText(String.valueOf(targetValue));
        }
    }

    public void addElementBoolean(String targetName, Boolean targetValue) {
        if (targetValue != null && targetValue) {
            this.addElement(targetName).setText(String.valueOf(targetValue));
        }
    }

    public void addElement(Element targetValue){
        if (targetValue != null) {
            this.add(targetValue);
        }
    }

    // HELPING ELEMENT RETRIEVAL
    public Element getElement(String target) {
        return this.element(target);
    }

    public String getStringValue(String target) {
        Element node = this.element(target);
        return node != null ? this.getText() : null;
    }

    public Integer getIntegerValue(String target) {
        Element node = this.element(target);
        return (node != null) ? Integer.valueOf(node.getText()) : null;
    }

    public  float getFloatValue(String target) {
        Element node = this.element(target);
        return (node != null) ? Float.valueOf(node.getText()) : -1;
    }

    public long getLongValue(String target) {
        Element node = this.element(target);
        return (node != null) ? Long.valueOf(node.getText()) : -1;
    }

    public boolean getBooleanValue(String target) {
        Element node = this.element(target);
        return (node != null) ? Boolean.valueOf(node.getText()): false;
    }

    public DateTime getDateTime(String target) {
        Element node = this.element(target);
        return (node != null) ? DateTime.parse(node.getText(), DATE_FORMATTER) : DateTime.now();
    }

    public int getAttributeIntegerValue(String target) {
        Attribute attribute = this.attribute(target);
        return (attribute != null) ? Integer.valueOf(attribute.getValue()) : -1;
    }

    public float getAttributeFloatValue(String target) {
        Attribute attribute = this.attribute(target);
        return (attribute != null) ? Float.valueOf(attribute.getValue()) : -1;
    }

    public boolean getAttributeBooleanValue(String target) {
        Attribute attribute = this.attribute(target);
        return (attribute != null) ? Boolean.valueOf(attribute.getValue()) : false;
    }

    // REQUEST HELPERS
    public void addHotelId(long hotelId) {
        addElementLong("hotelId", hotelId);
    }

    public void addArrivalDate(DateTime arrivalDate) {
        addElementDateTime("arrivalDate", arrivalDate);
    }

    public void addDepartureDate(DateTime arrivalDate) {
        addElementDateTime("departureDate", arrivalDate);
    }

    public void addRoomGroup(RoomGroup roomGroup) {
        if (roomGroup != null) {
            Element container = DocumentHelper.createElement("RoomGroup");

            for (Room room : roomGroup.getRoom()) {
                EanElement element = (EanElement) container.addElement("Room");
                element.addElementInteger("numberOfAdults", room.getNumberOfAdults());
                element.addElementInteger("numberOfChildren", room.getNumberOfChildren());
                element.addElementString("childAges", StringUtils.join(room.getChildAges(), ","));
            }

            addElement(container);
        }
    }

    public void addRateKey(String rateKey) {
        addElementString("rateKey", rateKey);
    }

    public void addNumberOfBedRooms(Integer numberOfBedRooms) {
        addElementInteger("numberOfBedRooms", numberOfBedRooms);
    }

    public void addSupplierType(SupplierType supplierType) {
        if (supplierType != null) {
            addElementString("supplierType", supplierType.value());
        }
    }

    public void addRateCode(String rateCode) {
        addElementString("rateCode", rateCode);
    }

    public void addRoomTypeCode(String roomTypeCode) {
        addElementString("roomTypeCode", roomTypeCode);
    }

    public void addIncludeDetails(Boolean includeDetails) {
        addElementBoolean("includeDetails", includeDetails);
    }

    public void addHotelAvailOption(List<HotelAvailOption> hotelAvailOptions) {
        if (hotelAvailOptions.size() > 0) {
            addElementString("options", StringUtils.join(hotelAvailOptions, ","));
        }
    }

    // RESPONSE HELPERS

    public String getCustomerSessionId() {
        return this.getStringValue("customerSessionId");
    }

    public long getHotelId() {
        return this.getLongValue("hotelId");
    }

    public DateTime getArrivalDate() {
        return this.getDateTime("arrivalDate");
    }

    public DateTime getDepartureDate() {
        return this.getDateTime("departureDate");
    }

    public String getHotelName() {
        return this.getStringValue("hotelName");
    }

    public String getHotelAddress() {
        return this.getStringValue("hotelAddress");
    }

    public String getHotelCity() {
        return this.getStringValue("hotelCity");
    }

    public String getHotelStateProvince() {
        return this.getStringValue("hotelStateProvince");
    }

    public String getHotelCountry() {
        return this.getStringValue("hotelCountry");
    }

    public Integer getNumberOfRoomsRequested() {
        return this.getIntegerValue("numberOfRoomsRequested");
    }

    public String getCheckInInstructions() {
        return this.getStringValue("checkInInstructions");
    }

    public String getTripAdvisorRating() {
        return this.getStringValue("tropAdvisorRating");
    }

    public String getRateKey() {
        return this.getStringValue("rateKey");
    }

    public List<HotelRoomResponse> getHotelRoomResponseList() {
        List<Element> elementList = elements("hotelRomeResponse");
        for (Element node : elementList) {

        }

        return null;  //TODO finish implement this
    }

    public String getCancellationPolicy() {
        return this.getStringValue("cancellationPolicy");
    }


}
