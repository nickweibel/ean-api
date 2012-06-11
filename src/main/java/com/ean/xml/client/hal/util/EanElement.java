package com.ean.xml.client.hal.util;

import com.ean.xml.client.hal.base.properties.CancelPolicyInfo;
import com.ean.xml.client.hal.base.properties.CancelPolicyInfoList;
import com.ean.xml.client.hal.base.properties.HotelAvailOption;
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

    private  Float getFloatValue(String target) {
        Element node = this.element(target);
        return (node != null) ? Float.valueOf(node.getText()) : null;
    }

    private Long getLongValue(String target) {
        Element node = this.element(target);
        return (node != null) ? Long.valueOf(node.getText()) : null;
    }

    private Boolean getBooleanValue(String target) {
        Element node = this.element(target);
        return (node != null) ? Boolean.valueOf(node.getText()): null;
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

    private Long getAttributeLongValue(String target) {
        Attribute attribute = this.attribute(target);
        return attribute != null ? Long.valueOf(attribute.getValue()) : null;
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
        Boolean rateChange = this.getBooleanValue("rateChange");
        return rateChange != null ? rateChange : false;
    }

    private Boolean getNonRefundable() {
        return this.getBooleanValue("nonRefundable");
    }

    private boolean getNonRefundablePrimitive() {
        Boolean nonRefundable = getNonRefundable();
        return nonRefundable != null ? nonRefundable : false;
    }

    private boolean getGuaranteeRequired() {
        Boolean guaranteeRequired = this.getBooleanValue("guaranteeRequired");
        return guaranteeRequired != null ? guaranteeRequired : false;
    }

    private boolean getDepositRequired() {
        Boolean depositRequired = this.getBooleanValue("depositRequired");
        return depositRequired != null ? depositRequired : false;
    }

    private boolean getImmediateChargeRequired() {
        Boolean immediateChargeRequired = this.getBooleanValue("immediateChargeRequired");
        return immediateChargeRequired != null ? immediateChargeRequired : false;
    }

    private int getCurrentAllotment() {
        Integer currentAllotment = this.getIntegerValue("currentAllotment");
        return currentAllotment != null ? currentAllotment : 0;
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
        BedTypes bedTypes = new BedTypes();
        EanElement node = (EanElement) this.getElement("bedTypes");

        if (node != null) {
            bedTypes.setSize(node.getSizeAttribute());

            bedTypes.getBedType().addAll(node.getBedTypeList());
        }

        return bedTypes;
    }

    private Integer getSizeAttribute() {
        return this.getAttributeIntegerValue("size");
    }

    public int getSizeAttributePrimitive() {
        Integer size = getSizeAttribute();
        return size != null ? size : 0;
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
        Integer id = this.getAttributeIntegerValue("id");
        return id != null ? id : 0;
    }

    private String getDescription() {
        return this.getStringValue("description");
    }

    private CancelPolicyInfoList getCancelPolicyInfoList() {
        CancelPolicyInfoList cancelPolicyInfoList = new CancelPolicyInfoList();
        EanElement node = (EanElement) this.getElement("CancelPolicyInfoList");

        if (node != null) {
            cancelPolicyInfoList.getCancelPolicyInfo().addAll(getCancelPolicyInfo());
        }

        return cancelPolicyInfoList;
    }

    private List<CancelPolicyInfo> getCancelPolicyInfo() {
        List<CancelPolicyInfo> cancelPolicyInfoList = new ArrayList<CancelPolicyInfo>();
        List<EanElement> nodeList = this.elements("CancelPolicyInfo");

        if (nodeList != null) {
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
        Integer versionId = this.getIntegerValue("versionId");
        return versionId != null ? versionId : 0;
    }

    private String getCancelTime() {
        return this.getStringValue("cancelTime");
    }

    private String getStartWindowHours() {
        return this.getStringValue("startWindowHours");
    }

    private int getNightCount() {
        Integer nightCount = this.getIntegerValue("nightCount");
        return nightCount != null ? nightCount : 0;
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
        Integer rateOccupancyPerRoom = this.getIntegerValue("rateOccupancyPerRoom");
        return rateOccupancyPerRoom != null ? rateOccupancyPerRoom : 0;
    }

    private int getQuotedOccupancy() {
        Integer quotedOccupancy = this.getIntegerValue("quotedOccupancy");
        return quotedOccupancy != null ? quotedOccupancy : 0;
    }

    private int getMinGuestAge() {
        Integer minGuestAge = this.getIntegerValue("minGuestAge");
        return minGuestAge != null ? minGuestAge : 0;
    }

    private RateInfos getRateInfos() {
        EanElement node = (EanElement) this.getElement("RateInfos");
        RateInfos rateInfos = new RateInfos();

        if (node != null) {
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
        Integer numberOfAdults = this.getIntegerValue("numberOfAdults");
        return numberOfAdults != null ? numberOfAdults : 0;
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
        BaseRateInfoNightlyRatesPerRoom ratesPerRoom = new BaseRateInfoNightlyRatesPerRoom();
        EanElement node = (EanElement) this.element("NightlyRatesPerRoom");

        if (node != null) {
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
        BaseRateInfoSurcharges surcharges = new BaseRateInfoSurcharges();
        EanElement node = (EanElement) this.element("Surcharges");

        if (node != null) {
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
        ValueAdds valueAdds = new ValueAdds();
        EanElement node = (EanElement) this.element("ValueAdds");

        if (node != null) {
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
        RoomType roomType = new RoomType();
        EanElement node = (EanElement) this.element("RoomType");

        if (node != null) {
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
        Long roomTypeId = this.getAttributeLongValue("roomTypeId");
        return roomTypeId != null ? roomTypeId : 0;
    }

    private String getDescriptionLong() {
        return this.getStringValue("descriptionLong");
    }

    private RoomAmenities getRoomAmenities() {
        RoomAmenities roomAmenities = new RoomAmenities();
        EanElement node = (EanElement) this.element("roomAmenities");

        if (node != null) {
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

                roomAmenity.setAmenityId(node.getAmenityId());
                roomAmenity.setAmenity(node.getAmenity());

                roomAmenityList.add(roomAmenity);
            }
        }

        return roomAmenityList;
    }

    private long getAmenityId() {
        Long amenityId = this.getAttributeLongValue("amenityId");
        return amenityId != null ? amenityId : 0;
    }

    private String getAmenity() {
        return this.getStringValue("amenity");
    }

    private String getDeepLink() {
        return this.getStringValue("deepLink");
    }
}