package com.shayshab.dttaskapi.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataModel {
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("pages")
    @Expose
    private Integer pages;
    @SerializedName("information")
    @Expose
    private Information information;
    @SerializedName("offers")
    @Expose
    private List<Offer> offers = null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
    public class Information {

        @SerializedName("app_name")
        @Expose
        private String appName;
        @SerializedName("appid")
        @Expose
        private Integer appid;
        @SerializedName("virtual_currency")
        @Expose
        private String virtualCurrency;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("language")
        @Expose
        private String language;
        @SerializedName("support_url")
        @Expose
        private String supportUrl;

        public String getAppName() {
            return appName;
        }

        public void setAppName(String appName) {
            this.appName = appName;
        }

        public Integer getAppid() {
            return appid;
        }

        public void setAppid(Integer appid) {
            this.appid = appid;
        }

        public String getVirtualCurrency() {
            return virtualCurrency;
        }

        public void setVirtualCurrency(String virtualCurrency) {
            this.virtualCurrency = virtualCurrency;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getSupportUrl() {
            return supportUrl;
        }

        public void setSupportUrl(String supportUrl) {
            this.supportUrl = supportUrl;
        }

    }

    public class Offer {

        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("offer_id")
        @Expose
        private Integer offerId;
        @SerializedName("teaser")
        @Expose
        private String teaser;
        @SerializedName("required_actions")
        @Expose
        private String requiredActions;
        @SerializedName("link")
        @Expose
        private String link;
        @SerializedName("offer_types")
        @Expose
        private List<OfferType> offerTypes = null;
        @SerializedName("thumbnail")
        @Expose
        private Thumbnail thumbnail;
        @SerializedName("payout")
        @Expose
        private Integer payout;
        @SerializedName("time_to_payout")
        @Expose
        private TimeToPayout timeToPayout;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getOfferId() {
            return offerId;
        }

        public void setOfferId(Integer offerId) {
            this.offerId = offerId;
        }

        public String getTeaser() {
            return teaser;
        }

        public void setTeaser(String teaser) {
            this.teaser = teaser;
        }

        public String getRequiredActions() {
            return requiredActions;
        }

        public void setRequiredActions(String requiredActions) {
            this.requiredActions = requiredActions;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public List<OfferType> getOfferTypes() {
            return offerTypes;
        }

        public void setOfferTypes(List<OfferType> offerTypes) {
            this.offerTypes = offerTypes;
        }

        public Thumbnail getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(Thumbnail thumbnail) {
            this.thumbnail = thumbnail;
        }

        public Integer getPayout() {
            return payout;
        }

        public void setPayout(Integer payout) {
            this.payout = payout;
        }

        public TimeToPayout getTimeToPayout() {
            return timeToPayout;
        }

        public void setTimeToPayout(TimeToPayout timeToPayout) {
            this.timeToPayout = timeToPayout;
        }

        public class OfferType {

            @SerializedName("offer_type_id")
            @Expose
            private Integer offerTypeId;
            @SerializedName("readable")
            @Expose
            private String readable;

            public Integer getOfferTypeId() {
                return offerTypeId;
            }

            public void setOfferTypeId(Integer offerTypeId) {
                this.offerTypeId = offerTypeId;
            }

            public String getReadable() {
                return readable;
            }

            public void setReadable(String readable) {
                this.readable = readable;
            }

        }



        public class Thumbnail {

            @SerializedName("lowres")
            @Expose
            private String lowres;
            @SerializedName("hires")
            @Expose
            private String hires;

            public String getLowres() {
                return lowres;
            }

            public void setLowres(String lowres) {
                this.lowres = lowres;
            }

            public String getHires() {
                return hires;
            }

            public void setHires(String hires) {
                this.hires = hires;
            }

        }



        public class TimeToPayout {

            @SerializedName("amount")
            @Expose
            private Integer amount;
            @SerializedName("readable")
            @Expose
            private String readable;

            public Integer getAmount() {
                return amount;
            }

            public void setAmount(Integer amount) {
                this.amount = amount;
            }

            public String getReadable() {
                return readable;
            }

            public void setReadable(String readable) {
                this.readable = readable;
            }

        }


    }






}
