
package com.ean.xml.client.hal.requests;

import com.ean.xml.client.hal.base.properties.HotelListOption;
import com.ean.xml.client.hal.base.rates.RatePlanType;
import com.ean.xml.client.hal.base.request.SearchRadiusUnitType;
import com.ean.xml.client.hal.base.request.SortType;
import com.ean.xml.client.hal.base.room.MultiRoomAvailType;
import com.ean.xml.client.hal.base.room.RoomGroup;
import com.ean.xml.client.hal.base.supplier.SupplierCacheTolerance;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class HotelListRequest
        extends HotelBaseRequest
{

    private String address;
    private String city;
    private String stateProvinceCode;
    private String postalCode;
    private String countryCode;
    private String destinationId;
    private String destinationString;
    private List<Long> hotelIdList;
    private Double latitude;
    private Double longitude;
    private Integer searchRadius;
    private SearchRadiusUnitType searchRadiusUnit;
    private SortType sort;
    private String propertyName;
    private List<Integer> amenities;
    private Float minStarRating;
    private Float maxStarRating;
    private Float minTripAdvisorRating;
    private Float maxTripAdvisorRating;
    private Integer minRate;
    private Integer maxRate;
    private List<String> propertyCategory;
    private String supplierType;
    private Integer numberOfBedRooms;
    private Integer numberOfResults;
    private Integer maxRatePlanCount;
    private DateTime arrivalDate;
    private DateTime departureDate;
    private RoomGroup roomGroup;
    private RatePlanType rateType;
    private String cacheLocation;
    private String cacheKey;
    private List<HotelListOption> options;
    private MultiRoomAvailType multiRoomAvail;
    private String merchantScoringSource;
    private Integer scoringAlgorithmId;
    private Boolean ignoreMmOverrides;
    private SupplierCacheTolerance supplierCacheTolerance;
    private Boolean datelessSupplierSort;
    private final Integer DEFAULT_NUM_OF_RESULTS = 25;
    private final Integer DEFAULT_DAYS_FROM_TODAY = 2;
    private final Integer DEFAULT_LENGTH_OF_STAY = 2;
    private final String GUID_REGEX = "([0-9A-Z]{8})(-[0-9A-Z]{4}){3}(-[0-9A-Z]{12})";

    /**
     * Creates a new HotelListRequest object that will be used to retrieve a list of Hotels.
     *
     * @param arrivalDate a JodaTime date that marks the start of travel
     * @param departureDate a JodaTime date that marks the completion of travel
     * @param numberOfResults the number of results that the list will contain, if less than this number is found than
     *                        that is returned
     * @param city the city in which to conduct a search
     * @param stateProvinceCode the provincial code in which the city resides
     * @param countryCode the country code in which the city resides
     */
    public HotelListRequest(DateTime arrivalDate, DateTime departureDate, Integer numberOfResults,
                            String city, String stateProvinceCode, String countryCode) {
        init(arrivalDate, departureDate, numberOfResults);

        this.city = city;
        this.stateProvinceCode = stateProvinceCode;
        this.countryCode = countryCode;
    }

    /**
     *
     * Creates a new HotelListRequest object that will be used to retrieve a list of Hotels.
     *
     * @param arrivalDate a JodaTime date that marks the start of travel
     * @param departureDate a JodaTime date that marks the completion of travel
     * @param numberOfResults the number of results that the list will contain, if less than this number is found than
     *                        that is returned
     * @param destinationStringOrID this string can be either a destinationString or destinationID, the string is
     *                              matched against a GUID regex, if it matches than it is assumed the string is a
     *                              destinationID, if it does not match it is assumed to be a destinationString
     */
    public HotelListRequest(DateTime arrivalDate, DateTime departureDate, Integer numberOfResults,
                            String destinationStringOrID) {
        init(arrivalDate, departureDate, numberOfResults);
        Pattern p = Pattern.compile(GUID_REGEX);
        if (p.matcher(destinationStringOrID).matches()) {
            this.destinationId = destinationStringOrID;
        } else {
            this.destinationString = destinationStringOrID;
        }
    }


    /**
     * Creates a new HotelListRequest object that will be used to retrieve a list of Hotels.
     *
     * @param arrivalDate a JodaTime date that marks the start of travel
     * @param departureDate a JodaTime date that marks the completion of travel
     * @param numberOfResults the number of results that the list will contain, if less than this number is found than
     *                        that is returned
     * @param hotelIdList this is a List of HotelIDs
     */
    public HotelListRequest(DateTime arrivalDate, DateTime departureDate, Integer numberOfResults,
                            List<Long> hotelIdList) {
        init(arrivalDate, departureDate, numberOfResults);
        this.hotelIdList = hotelIdList;
    }

    /**
     * Creates a new HotelListRequest object that will be used to retrieve a list of Hotels.
     *
     * @param arrivalDate a JodaTime date that marks the start of travel
     * @param departureDate a JodaTime date that marks the completion of travel
     * @param numberOfResults the number of results that the list will contain, if less than this number is found than
     *                        that is returned
     * @param latitude latitude of the center of a geo-location in which to conduct the search
     * @param longitude longitude of the center of a geo-location in which to conduct the search
     * @param searchRadius how far out from the lat/long in which to search for hotels
     * @param unitType in what unit of measure to search
     */
    public HotelListRequest(DateTime arrivalDate, DateTime departureDate, Integer numberOfResults,
                            Double latitude, Double longitude, Integer searchRadius, SearchRadiusUnitType unitType) {
        init(arrivalDate, departureDate, numberOfResults);
        this.latitude = latitude;
        this.longitude = longitude;
        this.searchRadius = searchRadius;
        this.searchRadiusUnit = unitType;
    }

    private void init(DateTime arrivalDate, DateTime departureDate, Integer numberOfResults) {
        this.arrivalDate = null == arrivalDate ? DateTime.now().plusDays(DEFAULT_DAYS_FROM_TODAY) : arrivalDate;
        this.departureDate = null == departureDate ? arrivalDate.plusDays(DEFAULT_LENGTH_OF_STAY) : departureDate;
        this.numberOfResults = null == numberOfResults ? DEFAULT_NUM_OF_RESULTS : numberOfResults;
    }

    /**
     * Gets the value of the address property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the city property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the stateProvinceCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStateProvinceCode() {
        return stateProvinceCode;
    }

    /**
     * Sets the value of the stateProvinceCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStateProvinceCode(String value) {
        this.stateProvinceCode = value;
    }

    /**
     * Gets the value of the postalCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the countryCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * Gets the value of the destinationId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDestinationId() {
        return destinationId;
    }

    /**
     * Sets the value of the destinationId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDestinationId(String value) {
        this.destinationId = value;
    }

    /**
     * Gets the value of the destinationString property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDestinationString() {
        return destinationString;
    }

    /**
     * Sets the value of the destinationString property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDestinationString(String value) {
        this.destinationString = value;
    }

    /**
     * Gets the value of the hotelIdList property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hotelIdList property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHotelIdList().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     *
     *
     */
    public List<Long> getHotelIdList() {
        if (hotelIdList == null) {
            hotelIdList = new ArrayList<Long>();
        }
        return this.hotelIdList;
    }

    /**
     * Gets the value of the latitude property.
     *
     * @return
     *     possible object is
     *     {@link Double }
     *
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * Sets the value of the latitude property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     *
     */
    public void setLatitude(Double value) {
        this.latitude = value;
    }

    /**
     * Gets the value of the longitude property.
     *
     * @return
     *     possible object is
     *     {@link Double }
     *
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * Sets the value of the longitude property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     *
     */
    public void setLongitude(Double value) {
        this.longitude = value;
    }

    /**
     * Gets the value of the searchRadius property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getSearchRadius() {
        return searchRadius;
    }

    /**
     * Sets the value of the searchRadius property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setSearchRadius(Integer value) {
        this.searchRadius = value;
    }

    /**
     * Gets the value of the searchRadiusUnit property.
     *
     * @return
     *     possible object is
     *     {@link SearchRadiusUnitType }
     *
     */
    public SearchRadiusUnitType getSearchRadiusUnit() {
        return searchRadiusUnit;
    }

    /**
     * Sets the value of the searchRadiusUnit property.
     *
     * @param value
     *     allowed object is
     *     {@link SearchRadiusUnitType }
     *
     */
    public void setSearchRadiusUnit(SearchRadiusUnitType value) {
        this.searchRadiusUnit = value;
    }

    /**
     * Gets the value of the sort property.
     *
     * @return
     *     possible object is
     *     {@link SortType }
     *
     */
    public SortType getSort() {
        return sort;
    }

    /**
     * Sets the value of the sort property.
     *
     * @param value
     *     allowed object is
     *     {@link SortType }
     *
     */
    public void setSort(SortType value) {
        this.sort = value;
    }

    /**
     * Gets the value of the propertyName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * Sets the value of the propertyName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPropertyName(String value) {
        this.propertyName = value;
    }

    /**
     * Gets the value of the amenities property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the amenities property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAmenities().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     *
     *
     */
    public List<Integer> getAmenities() {
        if (amenities == null) {
            amenities = new ArrayList<Integer>();
        }
        return this.amenities;
    }

    /**
     * Gets the value of the minStarRating property.
     *
     * @return
     *     possible object is
     *     {@link Float }
     *
     */
    public Float getMinStarRating() {
        return minStarRating;
    }

    /**
     * Sets the value of the minStarRating property.
     *
     * @param value
     *     allowed object is
     *     {@link Float }
     *
     */
    public void setMinStarRating(Float value) {
        this.minStarRating = value;
    }

    /**
     * Gets the value of the maxStarRating property.
     *
     * @return
     *     possible object is
     *     {@link Float }
     *
     */
    public Float getMaxStarRating() {
        return maxStarRating;
    }

    /**
     * Sets the value of the maxStarRating property.
     *
     * @param value
     *     allowed object is
     *     {@link Float }
     *
     */
    public void setMaxStarRating(Float value) {
        this.maxStarRating = value;
    }

    /**
     * Gets the value of the minTripAdvisorRating property.
     *
     * @return
     *     possible object is
     *     {@link Float }
     *
     */
    public Float getMinTripAdvisorRating() {
        return minTripAdvisorRating;
    }

    /**
     * Sets the value of the minTripAdvisorRating property.
     *
     * @param value
     *     allowed object is
     *     {@link Float }
     *
     */
    public void setMinTripAdvisorRating(Float value) {
        this.minTripAdvisorRating = value;
    }

    /**
     * Gets the value of the maxTripAdvisorRating property.
     *
     * @return
     *     possible object is
     *     {@link Float }
     *
     */
    public Float getMaxTripAdvisorRating() {
        return maxTripAdvisorRating;
    }

    /**
     * Sets the value of the maxTripAdvisorRating property.
     *
     * @param value
     *     allowed object is
     *     {@link Float }
     *
     */
    public void setMaxTripAdvisorRating(Float value) {
        this.maxTripAdvisorRating = value;
    }

    /**
     * Gets the value of the minRate property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getMinRate() {
        return minRate;
    }

    /**
     * Sets the value of the minRate property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setMinRate(Integer value) {
        this.minRate = value;
    }

    /**
     * Gets the value of the maxRate property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getMaxRate() {
        return maxRate;
    }

    /**
     * Sets the value of the maxRate property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setMaxRate(Integer value) {
        this.maxRate = value;
    }

    /**
     * Gets the value of the propertyCategory property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the propertyCategory property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPropertyCategory().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     */
    public List<String> getPropertyCategory() {
        if (propertyCategory == null) {
            propertyCategory = new ArrayList<String>();
        }
        return this.propertyCategory;
    }

    /**
     * Gets the value of the supplierType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSupplierType() {
        return supplierType;
    }

    /**
     * Sets the value of the supplierType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSupplierType(String value) {
        this.supplierType = value;
    }

    /**
     * Gets the value of the numberOfBedRooms property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getNumberOfBedRooms() {
        return numberOfBedRooms;
    }

    /**
     * Sets the value of the numberOfBedRooms property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setNumberOfBedRooms(Integer value) {
        this.numberOfBedRooms = value;
    }

    /**
     * Gets the value of the numberOfResults property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getNumberOfResults() {
        return numberOfResults;
    }

    /**
     * Sets the value of the numberOfResults property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setNumberOfResults(Integer value) {
        this.numberOfResults = value;
    }

    /**
     * Gets the value of the maxRatePlanCount property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getMaxRatePlanCount() {
        return maxRatePlanCount;
    }

    /**
     * Sets the value of the maxRatePlanCount property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setMaxRatePlanCount(Integer value) {
        this.maxRatePlanCount = value;
    }

    /**
     * Gets the value of the arrivalDate property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public DateTime getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Sets the value of the arrivalDate property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setArrivalDate(DateTime value) {
        this.arrivalDate = value;
    }

    /**
     * Gets the value of the departureDate property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public DateTime getDepartureDate() {
        return departureDate;
    }

    /**
     * Sets the value of the departureDate property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDepartureDate(DateTime value) {
        this.departureDate = value;
    }

    /**
     * Gets the value of the roomGroup property.
     *
     * @return
     *     possible object is
     *     {@link RoomGroup }
     *
     */
    public RoomGroup getRoomGroup() {
        return roomGroup;
    }

    /**
     * Sets the value of the roomGroup property.
     *
     * @param value
     *     allowed object is
     *     {@link RoomGroup }
     *
     */
    public void setRoomGroup(RoomGroup value) {
        this.roomGroup = value;
    }

    /**
     * Gets the value of the rateType property.
     *
     * @return
     *     possible object is
     *     {@link RatePlanType }
     *
     */
    public RatePlanType getRateType() {
        return rateType;
    }

    /**
     * Sets the value of the rateType property.
     *
     * @param value
     *     allowed object is
     *     {@link RatePlanType }
     *
     */
    public void setRateType(RatePlanType value) {
        this.rateType = value;
    }

    /**
     * Gets the value of the cacheLocation property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCacheLocation() {
        return cacheLocation;
    }

    /**
     * Sets the value of the cacheLocation property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCacheLocation(String value) {
        this.cacheLocation = value;
    }

    /**
     * Gets the value of the cacheKey property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCacheKey() {
        return cacheKey;
    }

    /**
     * Sets the value of the cacheKey property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCacheKey(String value) {
        this.cacheKey = value;
    }

    /**
     * Gets the value of the options property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the options property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOptions().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HotelListOption }
     *
     *
     */
    public List<HotelListOption> getOptions() {
        if (options == null) {
            options = new ArrayList<HotelListOption>();
        }
        return this.options;
    }

    /**
     * Gets the value of the multiRoomAvail property.
     *
     * @return
     *     possible object is
     *     {@link MultiRoomAvailType }
     *
     */
    public MultiRoomAvailType getMultiRoomAvail() {
        return multiRoomAvail;
    }

    /**
     * Sets the value of the multiRoomAvail property.
     *
     * @param value
     *     allowed object is
     *     {@link MultiRoomAvailType }
     *
     */
    public void setMultiRoomAvail(MultiRoomAvailType value) {
        this.multiRoomAvail = value;
    }

    /**
     * Gets the value of the merchantScoringSource property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMerchantScoringSource() {
        return merchantScoringSource;
    }

    /**
     * Sets the value of the merchantScoringSource property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMerchantScoringSource(String value) {
        this.merchantScoringSource = value;
    }

    /**
     * Gets the value of the scoringAlgorithmId property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getScoringAlgorithmId() {
        return scoringAlgorithmId;
    }

    /**
     * Sets the value of the scoringAlgorithmId property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setScoringAlgorithmId(Integer value) {
        this.scoringAlgorithmId = value;
    }

    /**
     * Gets the value of the ignoreMmOverrides property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isIgnoreMmOverrides() {
        return ignoreMmOverrides;
    }

    /**
     * Sets the value of the ignoreMmOverrides property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setIgnoreMmOverrides(Boolean value) {
        this.ignoreMmOverrides = value;
    }

    /**
     * Gets the value of the supplierCacheTolerance property.
     *
     * @return
     *     possible object is
     *     {@link SupplierCacheTolerance }
     *
     */
    public SupplierCacheTolerance getSupplierCacheTolerance() {
        return supplierCacheTolerance;
    }

    /**
     * Sets the value of the supplierCacheTolerance property.
     *
     * @param value
     *     allowed object is
     *     {@link SupplierCacheTolerance }
     *
     */
    public void setSupplierCacheTolerance(SupplierCacheTolerance value) {
        this.supplierCacheTolerance = value;
    }

    /**
     * Gets the value of the datelessSupplierSort property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isDatelessSupplierSort() {
        return datelessSupplierSort;
    }

    /**
     * Sets the value of the datelessSupplierSort property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setDatelessSupplierSort(Boolean value) {
        this.datelessSupplierSort = value;
    }

}
