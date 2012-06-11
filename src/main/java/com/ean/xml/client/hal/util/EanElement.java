package com.ean.xml.client.hal.util;

import com.ean.xml.client.hal.base.properties.CancelPolicyInfoList;
import com.ean.xml.client.hal.base.properties.HotelAvailOption;
import com.ean.xml.client.hal.base.rates.RateInfos;
import com.ean.xml.client.hal.base.room.BedType;
import com.ean.xml.client.hal.base.room.BedTypes;
import com.ean.xml.client.hal.base.room.Room;
import com.ean.xml.client.hal.base.room.RoomGroup;
import com.ean.xml.client.hal.base.supplier.SupplierType;
import com.ean.xml.client.hal.responses.HotelRoomResponse;
import java.util.ArrayList;
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

    public  Float getFloatValue(String target) {
        Element node = this.element(target);
        return (node != null) ? Float.valueOf(node.getText()) : null;
    }

    public Long getLongValue(String target) {
        Element node = this.element(target);
        return (node != null) ? Long.valueOf(node.getText()) : null;
    }

    public Boolean getBooleanValue(String target) {
        Element node = this.element(target);
        return (node != null) ? Boolean.valueOf(node.getText()): null;
    }

    public DateTime getDateTime(String target) {
        Element node = this.element(target);
        return (node != null) ? DateTime.parse(node.getText(), DATE_FORMATTER) : null;
    }

    public Integer getAttributeIntegerValue(String target) {
        Attribute attribute = this.attribute(target);
        return (attribute != null) ? Integer.valueOf(attribute.getValue()) : null;
    }

    public Float getAttributeFloatValue(String target) {
        Attribute attribute = this.attribute(target);
        return (attribute != null) ? Float.valueOf(attribute.getValue()) : null;
    }

    public Boolean getAttributeBooleanValue(String target) {
        Attribute attribute = this.attribute(target);
        return (attribute != null) ? Boolean.valueOf(attribute.getValue()) : null;
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
        Long hotelId = this.getLongValue("hotelId");
        return hotelId != null ? hotelId : 0;
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
        List<EanElement> elementList = elements("hotelRomeResponse");
        List<HotelRoomResponse> responseList = new ArrayList<HotelRoomResponse>();

        if (elementList != null) {
            for (EanElement node : elementList) {
                HotelRoomResponse hotelRoomResponse = new HotelRoomResponse();

                hotelRoomResponse.setCancellationPolicy(node.getCancellationPolicy());
                hotelRoomResponse.setRateCode(node.getRateCode());
                hotelRoomResponse.setRoomTypeCode(node.getRoomTypeCode());
                hotelRoomResponse.setRateDescription(node.getRateDescription());
                hotelRoomResponse.setRoomTypeDescription(node.getRoomTypeDescription());
                hotelRoomResponse.setSupplierType(node.getSupplierType());
                hotelRoomResponse.setTaxRate(node.getTaxRate());
                hotelRoomResponse.setRateChange(node.getRateChange());
                hotelRoomResponse.setNonRefundable(node.getNonRefundable());
                hotelRoomResponse.setGuaranteeRequired(node.getGuaranteeRequired());
                hotelRoomResponse.setDepositRequired(node.getDepositRequired());
                hotelRoomResponse.setImmediateChargeRequired(node.getImmediateChargeRequired());
                hotelRoomResponse.setCurrentAllotment(node.getCurrentAllotment());
                hotelRoomResponse.setPropertyId(node.getPropertyId());
                hotelRoomResponse.setPromoId(node.getPromoId());
                hotelRoomResponse.setPromoDescription(node.getPromoDescription());
                hotelRoomResponse.setBedTypes(node.getBedTypes());
                hotelRoomResponse.setCancelPolicyInfoList(node.getCancelPolicyInfoList());
                hotelRoomResponse.setSmokingPreferences(node.getSmokingPreferences());
                hotelRoomResponse.setRateOccupancyPerRoom(node.getRateOccupancyPerRoom());
                hotelRoomResponse.setQuotedOccupancy(node.getQuotedOccupancy());
                hotelRoomResponse.setMinGuestAge(node.getMinGuestAge());
                hotelRoomResponse.setRateInfos(node.getRateInfos());
                hotelRoomResponse.setDeepLink(node.getDeepLink());

                responseList.add(hotelRoomResponse);
            }
        }

        return responseList;
    }

    public String getCancellationPolicy() {
        return this.getStringValue("cancellationPolicy");
    }

    public String getRateCode() {
        return this.getStringValue("rateCode");
    }

    public String getRoomTypeCode() {
        return this.getStringValue("roomTypeCode");
    }

    public String getRateDescription() {
        return this.getStringValue("rateDescription");
    }

    public String getRoomTypeDescription() {
        return this.getStringValue("roomTypeDescription");
    }

    public SupplierType getSupplierType() {
        return SupplierType.fromValue(this.getStringValue("supplierType"));
    }

    public String getTaxRate() {
        return this.getStringValue("taxRate");
    }

    public boolean getRateChange() {
        Boolean rateChange = this.getBooleanValue("rateChange");
        return rateChange != null ? rateChange : false;
    }

    public boolean getNonRefundable() {
        Boolean nonRefundable = this.getBooleanValue("nonRefundable");
        return nonRefundable != null ? nonRefundable : false;
    }

    public boolean getGuaranteeRequired() {
        Boolean guaranteeRequired = this.getBooleanValue("guaranteeRequired");
        return guaranteeRequired != null ? guaranteeRequired : false;
    }

    public boolean getDepositRequired() {
        Boolean depositRequired = this.getBooleanValue("depositRequired");
        return depositRequired != null ? depositRequired : false;
    }

    public boolean getImmediateChargeRequired() {
        Boolean immediateChargeRequired = this.getBooleanValue("immediateChargeRequired");
        return immediateChargeRequired != null ? immediateChargeRequired : false;
    }

    public int getCurrentAllotment() {
        Integer currentAllotment = this.getIntegerValue("currentAllotment");
        return currentAllotment != null ? currentAllotment : 0;
    }

    public String getPropertyId() {
        return this.getStringValue("propertyId");
    }

    public String getPromoId() {
        return this.getStringValue("promoId");
    }

    public String getPromoDescription() {
        return this.getStringValue("promoDescription");
    }

    public BedTypes getBedTypes() {
        BedTypes bedTypes = new BedTypes();
        EanElement node = (EanElement) this.getElement("bedTypes");

        if (node != null) {
            bedTypes.setSize(node.getAttributeIntegerValue("size"));

            bedTypes.getBedType().addAll(node.getBedTypeList());
        }

        return bedTypes;
    }

    public List<BedType> getBedTypeList() {
        List<BedType> bedTypeList = new ArrayList<BedType>();
        List<EanElement> nodeList = this.elements("BedType");

        if (nodeList != null) {
            for (EanElement node : nodeList) {
                BedType bedType = new BedType();

                Integer id = node.getAttributeIntegerValue("id");
                bedType.setId(id != null ? id : 0);

                bedType.setDescription(node.getDescription());

                bedTypeList.add(bedType);
            }
        }
        return bedTypeList;
    }

    public String getDescription() {
        return this.getStringValue("description");
    }

    public CancelPolicyInfoList getCancelPolicyInfoList() {
        //TODO implement
        return null;
    }

    public String getSmokingPreferences() {
        return this.getStringValue("smokingPreferences");
    }

    public int getRateOccupancyPerRoom() {
        Integer rateOccupancyPerRoom = this.getIntegerValue("rateOccupancyPerRoom");
        return rateOccupancyPerRoom != null ? rateOccupancyPerRoom : 0;
    }

    public int getQuotedOccupancy() {
        Integer quotedOccupancy = this.getIntegerValue("quotedOccupancy");
        return quotedOccupancy != null ? quotedOccupancy : 0;
    }

    public int getMinGuestAge() {
        Integer minGuestAge = this.getIntegerValue("minGuestAge");
        return minGuestAge != null ? minGuestAge : 0;
    }

    public RateInfos getRateInfos() {
        //TODO implement
        return null;
    }

    public String getDeepLink() {
        this.getStringValue("deepLink");
    }
}