package com.ean.xml.client.hal.util;

import com.ean.xml.client.hal.base.errors.EanWsError;
import com.ean.xml.client.hal.base.errors.ErrorAttribute;
import com.ean.xml.client.hal.base.errors.ErrorAttributes;
import com.ean.xml.client.hal.base.errors.ErrorCategory;
import com.ean.xml.client.hal.base.errors.ErrorHandling;
import com.ean.xml.client.hal.base.itinerary.Itinerary;
import com.ean.xml.client.hal.base.properties.CancelPolicyInfo;
import com.ean.xml.client.hal.base.properties.CancelPolicyInfoList;
import com.ean.xml.client.hal.base.properties.HotelAvailOption;
import com.ean.xml.client.hal.base.properties.HotelDetails;
import com.ean.xml.client.hal.base.properties.HotelImage;
import com.ean.xml.client.hal.base.properties.HotelImages;
import com.ean.xml.client.hal.base.properties.PropertyAmenities;
import com.ean.xml.client.hal.base.properties.PropertyAmenity;
import com.ean.xml.client.hal.base.properties.ValueAdd;
import com.ean.xml.client.hal.base.properties.ValueAdds;
import com.ean.xml.client.hal.base.rates.BaseRateInfo;
import com.ean.xml.client.hal.base.rates.BaseRateInfoNightlyRatesPerRoom;
import com.ean.xml.client.hal.base.rates.HotelRateInfo;
import com.ean.xml.client.hal.base.rates.NightlyRate;
import com.ean.xml.client.hal.base.rates.RateInfos;
import com.ean.xml.client.hal.base.rates.RatePlanType;
import com.ean.xml.client.hal.base.rates.surcharge.BaseRateInfoSurcharges;
import com.ean.xml.client.hal.base.rates.surcharge.Surcharge;
import com.ean.xml.client.hal.base.rates.surcharge.SurchargeType;
import com.ean.xml.client.hal.base.request.ServerInfo;
import com.ean.xml.client.hal.base.room.BedType;
import com.ean.xml.client.hal.base.room.BedTypes;
import com.ean.xml.client.hal.base.room.Room;
import com.ean.xml.client.hal.base.room.RoomAmenities;
import com.ean.xml.client.hal.base.room.RoomAmenity;
import com.ean.xml.client.hal.base.room.RoomGroup;
import com.ean.xml.client.hal.base.room.RoomType;
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
    private DateTimeFormatter DATE_FORMATTER = DateTimeFormat.forPattern("MM/dd/yyyy");

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
    private void addElementString(String targetName, String targetValue) {
        if (StringUtils.isNotBlank(targetValue)) {
            this.addElement(targetName).setText(targetValue);
        }
    }

    private void addElementDateTime(String targetName, DateTime dateTime) {
        if (dateTime != null) {
            this.addElement(targetName).setText(dateTime.toString(DATE_FORMATTER));
        }
    }

    private void addElementInteger(String targetName, Integer targetValue) {
        if (targetValue != null) {
            this.addElement(targetName).setText(String.valueOf(targetValue));
        }
    }

    private void addElementLong(String targetName, Long targetValue) {
        if (targetValue != null) {
            this.addElement(targetName).setText(String.valueOf(targetValue));
        }
    }

    private void addElementFloat(String targetName, Float targetValue) {
        if (targetValue != null) {
            this.addElement(targetName).setText(String.valueOf(targetValue));
        }
    }

    private void addElementBoolean(String targetName, Boolean targetValue) {
        if (targetValue != null && targetValue) {
            this.addElement(targetName).setText(String.valueOf(targetValue));
        }
    }

    private void addElement(Element targetValue){
        if (targetValue != null) {
            this.add(targetValue);
        }
    }

    // HELPING ELEMENT RETRIEVAL
    private Element getElement(String target) {
        return this.element(target);
    }

    private String getStringValue(String target) {
        Element node = this.element(target);
        return node != null ? this.getText() : null;
    }

    private Integer getIntegerValue(String target) {
        Element node = this.element(target);
        return (node != null) ? Integer.valueOf(node.getText()) : null;
    }

    private int getIntegerValuePrimitive(String target) {
        Integer value = getIntegerValue(target);
        return value != null ? value : 0;
    }

    private  Float getFloatValue(String target) {
        Element node = this.element(target);
        return (node != null) ? Float.valueOf(node.getText()) : null;
    }

    private Long getLongValue(String target) {
        Element node = this.element(target);
        return (node != null) ? Long.valueOf(node.getText()) : null;
    }

    private long getLongValuePrimitive(String target) {
        Long value = getLongValue(target);
        return value != null ? value : 0;
    }

    private Boolean getBooleanValue(String target) {
        Element node = this.element(target);
        return (node != null) ? Boolean.valueOf(node.getText()): null;
    }

    private boolean getBooleanValuePrimitive(String target) {
        Boolean value = getBooleanValue(target);
        return value != null ? value : false;
    }

    private DateTime getDateTime(String target) {
        Element node = this.element(target);
        return (node != null) ? DateTime.parse(node.getText(), DATE_FORMATTER) : null;
    }

    private String getAttributeStringValue(String target) {
        Attribute attribute = this.attribute(target);
        return attribute != null ? attribute.getValue() : null;
    }

    private Integer getAttributeIntegerValue(String target) {
        Attribute attribute = this.attribute(target);
        return (attribute != null) ? Integer.valueOf(attribute.getValue()) : null;
    }

    private int getAttributeIntegerValuePrimitive(String target) {
        Integer value = getAttributeIntegerValue(target);
        return value != null ? value : 0;
    }

    private Long getAttributeLongValue(String target) {
        Attribute attribute = this.attribute(target);
        return attribute != null ? Long.valueOf(attribute.getValue()) : null;
    }

    private long getAttributeLongValuePrimitive(String target) {
        Long value = getAttributeLongValue(target);
        return value != null ? value : 0;
    }

    private Float getAttributeFloatValue(String target) {
        Attribute attribute = this.attribute(target);
        return (attribute != null) ? Float.valueOf(attribute.getValue()) : null;
    }

    private Boolean getAttributeBooleanValue(String target) {
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
                Element element = container.addElement("Room");
                element.addElement("numberOfAdults").setText(String.valueOf(room.getNumberOfAdults()));
                element.addElement("numberOfChildren").setText(String.valueOf(room.getNumberOfChildren()));
                element.addElement("childAges").setText(StringUtils.join(room.getChildAges(), ","));
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
    public EanWsError getEanWsError() {
        EanWsError error = null;
        EanElement node = (EanElement) this.element("EanWsError");

        if (node != null) {
            error = new EanWsError();
            error.setItineraryId(node.getItineraryId());
            error.setHandling(node.getHandling());
            error.setCategory(node.getErrorCategory());
            error.setExceptionConditionId(node.getExceptionConditionId());
            error.setPresentationMessage(node.getPresentationMessage());
            error.setVerboseMessage(node.getVerboseMessage());
            error.setErrorAttributes(node.getErrorAttributes());
            error.setServerInfo(node.getServerInfo());
        }

        return error;
    }

    private long getItineraryId() {
        return this.getLongValuePrimitive("itineraryId");
    }

    private ErrorHandling getHandling() {
        String errorHandling = this.getStringValue("handling");
        return errorHandling != null ? ErrorHandling.fromValue(errorHandling) : null;
    }

    private ErrorCategory getErrorCategory() {
        String category = this.getStringValue("category");
        return category != null ? ErrorCategory.fromValue(category) : null;
    }

    private int getExceptionConditionId() {
        return this.getIntegerValuePrimitive("exceptionConditionId");
    }

    private String getPresentationMessage() {
        return this.getStringValue("presentationMessage");
    }

    private String getVerboseMessage() {
        return this.getStringValue("verboseMessage");
    }

    private ErrorAttributes getErrorAttributes() {
        ErrorAttributes errorAttributes = null;
        EanElement node = (EanElement) this.element("ErrorAttributes");

        if (node != null) {
            errorAttributes = new ErrorAttributes();
            errorAttributes.setErrorAttributesMap(getErrorAttributesMap());
        }

        return errorAttributes;
    }

    private ErrorAttributes.ErrorAttributesMap getErrorAttributesMap() {
        ErrorAttributes.ErrorAttributesMap attributesMap = new ErrorAttributes.ErrorAttributesMap();
        List<EanElement> nodeList = this.elements("entry");

        if (nodeList != null) {
            for (EanElement node : nodeList) {
                ErrorAttributes.ErrorAttributesMap.Entry entry = new ErrorAttributes.ErrorAttributesMap.Entry();
                entry.setKey(node.getKey());
                entry.setValue(node.getValue());

                attributesMap.getEntry().add(entry);
            }
        }

        return attributesMap;
    }

    private ErrorAttribute getKey() {
        String errorAttribute = this.getStringValue("key");
        return errorAttribute != null ? ErrorAttribute.fromValue(errorAttribute) : null;
    }

    private String getValue() {
        return this.getStringValue("value");
    }

    public ServerInfo getServerInfo() {
        ServerInfo serverInfo = null;
        EanElement node = (EanElement) this.element("ServerInfo");

        if (node != null) {
            serverInfo = new ServerInfo();
            serverInfo.setServerTime(node.getServerTime());
            serverInfo.setTimestamp(node.getTimestamp());
            serverInfo.setInstance(node.getInstance());
        }

        return serverInfo;
    }

    private String getServerTime() {
        return this.getAttributeStringValue("serverTime");
    }

    private long getTimestamp() {
        return this.getAttributeLongValuePrimitive("timestamp");
    }

    private String getInstance() {
        return this.getAttributeStringValue("instance");
    }

    public String getCustomerSessionId() {
        return this.getStringValue("customerSessionId");
    }

    public long getHotelId() {
        return this.getLongValuePrimitive("hotelId");
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
        List<HotelRoomResponse> responseList = new ArrayList<HotelRoomResponse>();;

        if (elementList != null) {
            for (EanElement node : elementList) {
                HotelRoomResponse hotelRoomResponse = new HotelRoomResponse();

                hotelRoomResponse.setCancellationPolicy(node.getCancellationPolicy());
                hotelRoomResponse.setPolicy(node.getPolicy());
                hotelRoomResponse.setRateCode(node.getRateCode());
                hotelRoomResponse.setRoomTypeCode(node.getRoomTypeCode());;
                hotelRoomResponse.setRateDescription(node.getRateDescription());
                hotelRoomResponse.setRoomTypeDescription(node.getRoomTypeDescription());
                hotelRoomResponse.setSupplierType(node.getSupplierType());
                hotelRoomResponse.setTaxRate(node.getTaxRate());
                hotelRoomResponse.setOtherInformation(node.getOtherInformation());
                hotelRoomResponse.setRateChange(node.getRateChange());
                hotelRoomResponse.setNonRefundable(node.getNonRefundablePrimitive());
                hotelRoomResponse.setGuaranteeRequired(node.getGuaranteeRequired());
                hotelRoomResponse.setDepositRequired(node.getDepositRequired());
                hotelRoomResponse.setImmediateChargeRequired(node.getImmediateChargeRequired());
                hotelRoomResponse.setCurrentAllotment(node.getCurrentAllotment());
                hotelRoomResponse.setPropertyId(node.getPropertyId());
                hotelRoomResponse.setPromoId(node.getPromoId());
                hotelRoomResponse.setPromoDescription(node.getPromoDescription());
                hotelRoomResponse.setPromoType(node.getPromoType());
                hotelRoomResponse.setPromoDetailText(node.getPromoDetailText());
                hotelRoomResponse.setSmokingPreferences(node.getSmokingPreferences());
                hotelRoomResponse.setRateOccupancyPerRoom(node.getRateOccupancyPerRoom());
                hotelRoomResponse.setDeepLink(node.getDeepLink());
                hotelRoomResponse.setBedTypes(node.getBedTypes());
                hotelRoomResponse.setCancelPolicyInfoList(node.getCancelPolicyInfoList());
                hotelRoomResponse.setRateInfos(node.getRateInfos());
                hotelRoomResponse.setValueAdds(node.getValueAdds());
                hotelRoomResponse.setRoomType(node.getRoomType());
                hotelRoomResponse.setQuotedOccupancy(node.getQuotedOccupancy());
                hotelRoomResponse.setMinGuestAge(node.getMinGuestAge());

                responseList.add(hotelRoomResponse);
            }
        }

        return responseList;
    }

    private String getCancellationPolicy() {
        return this.getStringValue("cancellationPolicy");
    }

    private String getPolicy() {
        return this.getStringValue("policy");
    }

    private String getRateCode() {
        return this.getStringValue("rateCode");
    }

    private String getRoomTypeCode() {
        return this.getStringValue("roomTypeCode");
    }

    private String getRateDescription() {
        return this.getStringValue("rateDescription");
    }

    private String getRoomTypeDescription() {
        return this.getStringValue("roomTypeDescription");
    }

    private SupplierType getSupplierType() {
        return SupplierType.fromValue(this.getStringValue("supplierType"));
    }

    private String getTaxRate() {
        return this.getStringValue("taxRate");
    }

    private String getOtherInformation() {
        return this.getStringValue("otherInformation");
    }

    private boolean getRateChange() {
        return this.getBooleanValuePrimitive("rateChange");
    }

    private Boolean getNonRefundable() {
        return this.getBooleanValue("nonRefundable");
    }

    private boolean getNonRefundablePrimitive() {
        return this.getBooleanValuePrimitive("nonRefundable");
    }

    private boolean getGuaranteeRequired() {
        return this.getBooleanValuePrimitive("guaranteeRequired");
    }

    private boolean getDepositRequired() {
        return this.getBooleanValuePrimitive("depositRequired");
    }

    private boolean getImmediateChargeRequired() {
        return this.getBooleanValuePrimitive("immediateChargeRequired");
    }

    private int getCurrentAllotment() {
        return this.getIntegerValuePrimitive("currentAllotment");
    }

    private String getPropertyId() {
        return this.getStringValue("propertyId");
    }

    private String getPromoId() {
        return this.getStringValue("promoId");
    }

    private String getPromoDescription() {
        return this.getStringValue("promoDescription");
    }

    private String getPromoType() {
        return this.getStringValue("promoType");
    }

    private String getPromoDetailText() {
        return this.getStringValue("promoDetailText");
    }

    private BedTypes getBedTypes() {
        BedTypes bedTypes = null;
        EanElement node = (EanElement) this.getElement("bedTypes");

        if (node != null) {
            bedTypes = new BedTypes();
            bedTypes.setSize(node.getSizeAttribute());
            bedTypes.getBedType().addAll(node.getBedTypeList());
        }

        return bedTypes;
    }

    private Integer getSizeAttribute() {
        return this.getAttributeIntegerValue("size");
    }

    public int getSizeAttributePrimitive() {
        return this.getAttributeIntegerValuePrimitive("size");
    }

    private List<BedType> getBedTypeList() {
        List<BedType> bedTypeList = new ArrayList<BedType>();
        List<EanElement> nodeList = this.elements("BedType");

        if (nodeList != null) {

            for (EanElement node : nodeList) {
                BedType bedType = new BedType();
                bedType.setId(node.getIdAttribute());
                bedType.setDescription(node.getDescription());
                bedTypeList.add(bedType);
            }
        }
        return bedTypeList;
    }

    private int getIdAttribute() {
        return this.getAttributeIntegerValuePrimitive("id");

    }

    private String getDescription() {
        return this.getStringValue("description");
    }

    private CancelPolicyInfoList getCancelPolicyInfoList() {
        CancelPolicyInfoList cancelPolicyInfoList = null;
        EanElement node = (EanElement) this.getElement("CancelPolicyInfoList");

        if (node != null) {
            cancelPolicyInfoList = new CancelPolicyInfoList();
            cancelPolicyInfoList.getCancelPolicyInfo().addAll(getCancelPolicyInfo());
        }

        return cancelPolicyInfoList;
    }

    private List<CancelPolicyInfo> getCancelPolicyInfo() {
        List<CancelPolicyInfo> cancelPolicyInfoList = null;
        List<EanElement> nodeList = this.elements("CancelPolicyInfo");

        if (nodeList != null) {
            cancelPolicyInfoList = new ArrayList<CancelPolicyInfo>();

            for (EanElement node : nodeList) {
                CancelPolicyInfo cancelPolicyInfo = new CancelPolicyInfo();

                cancelPolicyInfo.setVersionId(node.getVersionId());
                cancelPolicyInfo.setCancelTime(node.getCancelTime());
                cancelPolicyInfo.setStartWindowHours(node.getStartWindowHours());
                cancelPolicyInfo.setNightCount(node.getNightCount());
                cancelPolicyInfo.setPercent(node.getPercent());
                cancelPolicyInfo.setCurrencyCode(node.getCurrencyCode());
                cancelPolicyInfo.setTimeZoneDescription(node.getTimeZoneDescription());

                cancelPolicyInfoList.add(cancelPolicyInfo);
            }
        }

        return cancelPolicyInfoList;
    }

    private int getVersionId() {
        return this.getIntegerValuePrimitive("versionId");
    }

    private String getCancelTime() {
        return this.getStringValue("cancelTime");
    }

    private String getStartWindowHours() {
        return this.getStringValue("startWindowHours");
    }

    private int getNightCount() {
        return this.getIntegerValuePrimitive("nightCount");
    }

    private String getPercent() {
        return this.getStringValue("percent");
    }

    private String getCurrencyCode() {
        return this.getStringValue("currencyCode");
    }

    private String getTimeZoneDescription() {
        return this.getStringValue("timeZoneDescription");
    }

    private String getSmokingPreferences() {
        return this.getStringValue("smokingPreferences");
    }

    private int getRateOccupancyPerRoom() {
        return this.getIntegerValuePrimitive("rateOccupancyPerRoom");
    }

    private int getQuotedOccupancy() {
        return this.getIntegerValuePrimitive("quotedOccupancy");
    }

    private int getMinGuestAge() {
        return this.getIntegerValuePrimitive("minGuestAge");
    }

    private RateInfos getRateInfos() {
        EanElement node = (EanElement) this.getElement("RateInfos");
        RateInfos rateInfos = null;

        if (node != null) {
            rateInfos = new RateInfos();
            rateInfos.setSize(node.getSize());
            rateInfos.getRateInfo().addAll(node.getRateInfoList());
        }

        return rateInfos;
    }

    private Integer getSize() {
        return this.getIntegerValue("size");
    }

    private List<HotelRateInfo> getRateInfoList() {
        List<HotelRateInfo> hotelRateInfoList = new ArrayList<HotelRateInfo>();
        List<EanElement> nodeList = this.elements("RateInfo");

        if (nodeList != null) {
            for (EanElement node : nodeList) {
                HotelRateInfo hotelRateInfo = new HotelRateInfo();

                hotelRateInfo.setRateChange(node.getRateChangeAttribute());
                hotelRateInfo.setPromo(node.getPromoAttribute());
                hotelRateInfo.setPriceBreakdown(node.getPriceBreakdownAttribute());

                hotelRateInfo.setRoomGroup(node.getRoomGroup());
                hotelRateInfo.setChargeableRateInfo(node.getChargeableRateInfo());
                hotelRateInfo.setConvertedRateInfo(node.getConvertedRateInfo());

                hotelRateInfo.setNonRefundable(node.getNonRefundable());
                hotelRateInfo.setOnline(node.getOnline());
                hotelRateInfo.setRatePlanType(node.getRatePlanType());
            }
        }

        return hotelRateInfoList;
    }

    private Boolean getRateChangeAttribute() {
        return this.getAttributeBooleanValue("rateChange");
    }

    private Boolean getPromoAttribute() {
        return this.getAttributeBooleanValue("promo");
    }
    
    private Boolean getPriceBreakdownAttribute() {
        return this.getAttributeBooleanValue("priceBreakdown");
    }

    private RoomGroup getRoomGroup() {
        EanElement node = (EanElement) this.element("RoomGroup");
        RoomGroup roomGroup = null;

        if (node != null) {
            roomGroup = new RoomGroup(node.getRoomList());
        }

        return roomGroup;
    }

    private List<Room> getRoomList() {
        List<EanElement> nodeList = this.elements("Room");
        List<Room> roomList = new ArrayList<Room>();

        if (nodeList != null) {
            for (EanElement node : nodeList) {
                Room room = new Room(getNumberOfAdults());
                room.setNumberOfChildren(node.getNumberOfChildren());
                room.getChildAges().addAll(node.getChildAges());

                roomList.add(room);
            }
        }

        return roomList;
    }

    private int getNumberOfAdults() {
        return this.getIntegerValuePrimitive("numberOfAdults");
    }

    private Integer getNumberOfChildren() {
        return this.getIntegerValue("numberOfChildren");
    }

    private List<Integer> getChildAges() {
        List<EanElement> nodeList = this.elements("childAges");
        List<Integer> childAgesList = new ArrayList<Integer>();

        if (nodeList != null) {
            for (EanElement node : nodeList) {
                if (node != null) {
                    Integer childAges = Integer.valueOf(node.getText());

                    if (childAges != null) {
                        childAgesList.add(childAges);}
                }
            }
        }

        return childAgesList;
    }

    private BaseRateInfo getChargeableRateInfo() {
        EanElement node = (EanElement) this.getElement("ChargeableRateInfo");

        return node != null ? node.getBaseRateInfo() : null;
    }
    
    private BaseRateInfo getBaseRateInfo() {
        BaseRateInfo rateInfo = new BaseRateInfo();

        rateInfo.setCommissionableUsdTotal(this.getCommissionableUsdTotal());
        rateInfo.setTotal(this.getTotal());
        rateInfo.setSurchargeTotal(this.getSurchargeTotal());
        rateInfo.setNightlyRateTotal(this.getNightlyRateTotal());
        rateInfo.setAverageBaseRate(this.getAverageBaseRate());
        rateInfo.setAverageRate(this.getAverageRate());
        rateInfo.setMaxNightlyRate(this.getMaxNightlyRate());
        rateInfo.setCurrencyCode(this.getCurrencyCode());

        rateInfo.setNightlyRatesPerRoom(this.getNightlyRatesPerRoom());
        rateInfo.setSurcharges(this.getSurcharges());
        
        return rateInfo;
    }

    private Float getCommissionableUsdTotal() {
        return this.getFloatValue("commissionableUsdTotal");
    }

    private Float getTotal() {
        return this.getFloatValue("total");
    }

    private Float getSurchargeTotal() {
        return this.getFloatValue("surchargeTotal");
    }

    private Float getNightlyRateTotal() {
        return this.getFloatValue("nightlyRateTotal");
    }

    private Float getAverageBaseRate() {
        return this.getFloatValue("averageBaseRate");
    }

    private Float getAverageRate() {
        return this.getFloatValue("averageRate");
    }

    private Float getMaxNightlyRate() {
        return this.getFloatValue("maxNightlyRate");
    }

    private BaseRateInfoNightlyRatesPerRoom getNightlyRatesPerRoom() {
        BaseRateInfoNightlyRatesPerRoom ratesPerRoom = null;
        EanElement node = (EanElement) this.element("NightlyRatesPerRoom");

        if (node != null) {
            ratesPerRoom = new BaseRateInfoNightlyRatesPerRoom();
            ratesPerRoom.setSize(node.getSizeAttributePrimitive());
            ratesPerRoom.getNightlyRate().addAll(node.getNightlyRateList());
        }

        return ratesPerRoom;
    }

    private List<NightlyRate> getNightlyRateList() {
        List<NightlyRate> nightlyRateList = new ArrayList<NightlyRate>();
        List<EanElement> nodeList = this.elements("NightlyRate");

        if (nodeList != null) {
            for (EanElement node : nodeList) {
                NightlyRate nightlyRate = new NightlyRate();

                nightlyRate.setPromo(node.getPromoAttribute());
                nightlyRate.setRate(node.getRate());
                nightlyRate.setBaseRate(node.getBaseRate());

                nightlyRateList.add(nightlyRate);
            }
        }

        return nightlyRateList;
    }
    
    private Float getRate() {
        return this.getFloatValue("rate");
    }
    
    private Float getBaseRate() {
        return this.getFloatValue("baseRate");
    }

    private BaseRateInfoSurcharges getSurcharges() {
        BaseRateInfoSurcharges surcharges = null;
        EanElement node = (EanElement) this.element("Surcharges");

        if (node != null) {
            surcharges = new BaseRateInfoSurcharges();
            surcharges.setSize(node.getSizeAttributePrimitive());
            surcharges.getSurcharge().addAll(node.getSurchargeList());
        }

        return surcharges;
    }

    private List<Surcharge> getSurchargeList() {
        List<Surcharge> surchargeList = new ArrayList<Surcharge>();
        List<EanElement> nodeList = this.elements("Surcharge");

        if (nodeList != null) {
            for (EanElement node : nodeList) {
                Surcharge surcharge = new Surcharge();

                surcharge.setAmount(node.getAmountAttribute());
                surcharge.setType(node.getSurchargeTypeAttribute());

                surchargeList.add(surcharge);
            }
        }

        return surchargeList;
    }

    private Float getAmountAttribute() {
        return this.getAttributeFloatValue("amount");
    }

    private SurchargeType getSurchargeTypeAttribute() {
        String surchargeTypeString = this.getAttributeStringValue("type");
        return surchargeTypeString != null ? SurchargeType.fromValue(surchargeTypeString) : null;
    }

    private BaseRateInfo getConvertedRateInfo() {
        EanElement node = (EanElement) this.element("ConvertedRateInfo");

        return node.getBaseRateInfo();
    }

    private Boolean getOnline() {
        return this.getBooleanValue("online");
    }

    private RatePlanType getRatePlanType() {
        String ratePlanType = this.getStringValue("ratePlanType");
        return ratePlanType != null ? RatePlanType.fromValue(ratePlanType) : null;
    }

    private ValueAdds getValueAdds() {
        ValueAdds valueAdds = null;
        EanElement node = (EanElement) this.element("ValueAdds");

        if (node != null) {
            valueAdds = new ValueAdds();
            valueAdds.setSize(node.getSizeAttribute());
            valueAdds.getValueAdd().addAll(node.getValueAddList());
        }

        return valueAdds;
    }

    private List<ValueAdd> getValueAddList() {
        List<ValueAdd> valueAddList = new ArrayList<ValueAdd>();
        List<EanElement> nodeList = this.elements("ValueAdd");

        if (nodeList != null) {
            for (EanElement node : nodeList) {
                ValueAdd valueAdd = new ValueAdd();

                valueAdd.setId(node.getIdAttribute());
                valueAdd.setDescription(node.getDescription());

                valueAddList.add(valueAdd);
            }
        }

        return valueAddList;
    }

    private RoomType getRoomType() {
        RoomType roomType = null;
        EanElement node = (EanElement) this.element("RoomType");

        if (node != null) {
            roomType = new RoomType();
            roomType.setRoomCode(node.getRoomCodeAttribute());
            roomType.setRoomTypeId(node.getRoomTypeIdAttribute());
            roomType.setDescription(node.getDescription());
            roomType.setDescriptionLong(node.getDescriptionLong());
            roomType.setRoomAmenities(node.getRoomAmenities());
        }

        return roomType;
    }

    private String getRoomCodeAttribute() {
        return this.getAttributeStringValue("roomCode");
    }

    private long getRoomTypeIdAttribute() {
        return this.getAttributeLongValuePrimitive("roomTypeId");
    }

    private String getDescriptionLong() {
        return this.getStringValue("descriptionLong");
    }

    private RoomAmenities getRoomAmenities() {
        RoomAmenities roomAmenities = null;
        EanElement node = (EanElement) this.element("roomAmenities");

        if (node != null) {
            roomAmenities = new RoomAmenities();
            roomAmenities.setSize(node.getSizeAttributePrimitive());
            roomAmenities.getRoomAmenity().addAll(node.getRoomAmenityList());
        }

        return roomAmenities;
    }

    private List<RoomAmenity> getRoomAmenityList() {
        List<RoomAmenity> roomAmenityList = new ArrayList<RoomAmenity>();
        List<EanElement> nodeList = this.elements("RoomAmenity");

        if (nodeList != null) {
            for (EanElement node : nodeList) {
                RoomAmenity roomAmenity = new RoomAmenity();

                roomAmenity.setAmenityId(node.getAttributeAmenityId());
                roomAmenity.setAmenity(node.getAmenity());

                roomAmenityList.add(roomAmenity);
            }
        }

        return roomAmenityList;
    }

    private long getAttributeAmenityId() {
        return this.getAttributeLongValuePrimitive("amenityId");
    }

    private long getAmenityId() {
        return this.getIntegerValuePrimitive("amenityId");
    }

    private String getAmenity() {
        return this.getStringValue("amenity");
    }

    private String getDeepLink() {
        return this.getStringValue("deepLink");
    }

    public HotelDetails getHotelDetails() {
        HotelDetails hotelDetails = null;
        EanElement node = (EanElement) this.element("HotelDetails");

        if (node != null) {
            hotelDetails = new HotelDetails();
            hotelDetails.setNumberOfRooms(node.getNumberOfRooms());
            hotelDetails.setNumberOfFloors(node.getNumberOfFloors());
            hotelDetails.setCheckInTime(node.getCheckInTime());
            hotelDetails.setCheckOutTime(node.getCheckOutTime());
            hotelDetails.setPropertyInformation(node.getPropertyInformation());
            hotelDetails.setAreaInformation(node.getAreaInformation());
            hotelDetails.setPropertyDescription(node.getPropertyDescription());
            hotelDetails.setHotelPolicy(node.getHotelPolicy());
            hotelDetails.setRoomInformation(node.getRoomInformation());
            hotelDetails.setDrivingDirections(node.getDrivingDirections());
            hotelDetails.setCheckInInstructions(node.getCheckInInstructions());
        }

        return hotelDetails;
    }

    private Integer getNumberOfRooms() {
        return this.getIntegerValue("numberOfRooms");
    }

    private Integer getNumberOfFloors() {
        return this.getIntegerValue("numberOfFloors");
    }

    private String getCheckInTime() {
        return this.getStringValue("checkInTime");
    }

    private String getCheckOutTime() {
        return this.getStringValue("checkOutTime");
    }

    private String getPropertyInformation() {
        return this.getStringValue("propertyInformation");
    }

    private String getAreaInformation() {
        return this.getStringValue("areaInformation");
    }

    private String getPropertyDescription() {
        return this.getStringValue("propertyDescription");
    }

    private String getHotelPolicy() {
        return this.getStringValue("hotelPolicy");
    }

    private String getRoomInformation() {
        return this.getStringValue("roomInformation");
    }

    private String getDrivingDirections() {
        return this.getStringValue("drivingDirections");
    }

    public PropertyAmenities getPropertyAmenities() {
        PropertyAmenities propertyAmenities = null;
        EanElement node = (EanElement) this.element("PropertyAmenities");

        if (node != null) {
            propertyAmenities = new PropertyAmenities();
            propertyAmenities.setSize(getSizeAttributePrimitive());
            propertyAmenities.getPropertyAmenity().addAll(getPropertyAmenityList());
        }

        return propertyAmenities;
    }

    private List<PropertyAmenity> getPropertyAmenityList() {
        List<PropertyAmenity> propertyAmenityList = new ArrayList<PropertyAmenity>();
        List<EanElement> nodeList = this.elements("PropertyAmenity");

        if (nodeList != null) {
            for (EanElement node : nodeList) {
                PropertyAmenity propertyAmenity = new PropertyAmenity();
                propertyAmenity.setAmenityId(node.getAmenityId());
                propertyAmenity.setAmenity(node.getAmenity());
            }
        }

        return propertyAmenityList;
    }

    public HotelImages getHotelImages() {
        HotelImages hotelImages = null;
        EanElement node = (EanElement) this.element("HotelImages");

        if (node != null) {
            hotelImages = new HotelImages();
            hotelImages.setSize(node.getSizeAttributePrimitive());
            hotelImages.getHotelImage().addAll(getHotelImageList());
        }

        return hotelImages;
    }

    private List<HotelImage> getHotelImageList() {
        List<HotelImage> hotelImageList = new ArrayList<HotelImage>();
        List<EanElement> nodeList = this.elements("HotelImage");

        if (nodeList != null) {
            for (EanElement node : nodeList) {
                HotelImage hotelImage = new HotelImage();
                hotelImage.setHotelImageId(node.getHotelImageId());
                hotelImage.setName(node.getImageName());
                hotelImage.setCategory(node.getCategory());
                hotelImage.setType(node.getType());
                hotelImage.setCaption(node.getCaption());
                hotelImage.setUrl(node.getUrl());
                hotelImage.setThumbnailUrl(node.getThumbnailUrl());
                hotelImage.setSupplierId(node.getSupplierId());
                hotelImage.setWidth(node.getWidth());
                hotelImage.setHeight(node.getHeight());
                hotelImage.setByteSize(node.getByteSize());

                hotelImageList.add(hotelImage);
            }
        }

        return hotelImageList;
    }

    private long getHotelImageId() {
        return this.getAttributeLongValuePrimitive("hotelImageId");
    }

    private String getImageName() {
        return this.getStringValue("imageName");
    }

    private int getCategory() {
        return this.getIntegerValuePrimitive("category");
    }

    private int getType() {
        return this.getIntegerValuePrimitive("type");
    }

    private String getCaption() {
        return this.getStringValue("caption");
    }

    private String getUrl() {
        return this.getStringValue("url");
    }

    private String getThumbnailUrl() {
        return this.getStringValue("thumbnailUrl");
    }

    private long getSupplierId() {
        return this.getLongValuePrimitive("supplierId");
    }

    private long getWidth() {
        return this.getLongValuePrimitive("width");
    }

    private long getHeight() {
        return this.getLongValuePrimitive("height");
    }

    private long getByteSize() {
        return this.getLongValuePrimitive("byteSize");
    }

    public String getEcho() {
        return this.getStringValue("echo");
    }

    public List<Itinerary> getItineraryList() {
        List<Itinerary> itineraryList = new ArrayList<Itinerary>();
        List<EanElement> nodeList = this.elements("Itinerary");

        if (nodeList == null) {
            for (EanElement node : nodeList) {
                Itinerary itinerary = new Itinerary();

                //TODO Continue this
//                itinerary.setItineraryId(node.getItineraryId());
//                itinerary.setAffiliateId(node.getAffiliateId());
//                itinerary.setCreationDate(node.getCreationDate());
//                itinerary.setItineraryStartDate(node.getItineraryStartDate());
//                itinerary.setItineraryEndDate(node.getItineraryEndDate());
//                itinerary.setAffiliateCustomerId(node.getAffilaiteCustomerId());
//                itinerary.setCustomer(node.getCustomer());
//                itinerary.getHotelConfirmation().addAll(node.getHotelConfirmationList());

                itineraryList.add(itinerary);
            }
        }

        return itineraryList;
    }
}