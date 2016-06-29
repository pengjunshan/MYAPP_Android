package maoyan.pjs.com.maoyan.bean;

import java.util.List;

/**
 * Created by pjs984312808 on 2016/6/28.
 */
public class CinemaListBean {

    /**
     * expires : 43200
     */

    private ControlBean control;
    /**
     * control : {"expires":43200}
     * status : 0
     * data : {"chaoyangqu":[{"deal":0,"distance":0,"follow":0,"imax":0,"brd":"17.5影城","dis":"望京","nm":"17.5影城(比如世界店)","poiId":75603,"ct":"","sellPrice":22,"sellmin":0,"sell":true,"preferential":0,"addr":"chaoyangqu京顺路111号比如世界购物中心1层（近太阳宫北街）","area":"chaoyangqu","lat":39.9684,"lng":116.46204,"brdId":23854,"dealPrice":0,"referencePrice":70,"showCount":0,"id":48},{"deal":0,"distance":0,"follow":0,"imax":0,"brd":"17.5影城","dis":"管庄","nm":"17.5影城(管庄店)","poiId":1677952,"ct":"","sellPrice":22,"sellmin":0,县","lat":40.461918,"lng":115.97629,"brdId":384262,"dealPrice":39,"referencePrice":40,"showCount":0,"id":13}]}
     */

    private int status;
    private DataBean data;

    public ControlBean getControl() {
        return control;
    }

    public void setControl(ControlBean control) {
        this.control = control;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class ControlBean {
        private int expires;

        public int getExpires() {
            return expires;
        }

        public void setExpires(int expires) {
            this.expires = expires;
        }
    }

    public static class DataBean {
        /**
         * deal : 0
         * distance : 0
         * follow : 0
         * imax : 0
         * brd : 17.5影城
         * dis : 望京
         * nm : 17.5影城(比如世界店)
         * poiId : 75603
         * ct :
         * sellPrice : 22.0
         * sellmin : 0
         * sell : true
         * preferential : 0
         * addr : chaoyangqu京顺路111号比如世界购物中心1层（近太阳宫北街）
         * area : chaoyangqu
         * lat : 39.9684
         * lng : 116.46204
         * brdId : 23854
         * dealPrice : 0.0
         * referencePrice : 70.0
         * showCount : 0
         * id : 48
         */

        private List<chaoyangquBean> chaoyangqu;
        /**
         * deal : 1
         * distance : 0
         * follow : 0
         * imax : 0
         * brd : 17.5影城
         * dis : 北太平庄
         * nm : 17.5影城(今典花园店)
         * poiId : 273950
         * ct :
         * sellPrice : 27.0
         * sellmin : 0
         * sell : true
         * preferential : 0
         * addr : haidianqu文慧园路9号今典花园9号楼空间蒙太奇大厦1层
         * area : haidianqu
         * lat : 39.95334
         * lng : 116.36104
         * brdId : 23854
         * dealPrice : 30.0
         * referencePrice : 60.0
         * showCount : 0
         * id : 154
         */

        private List<haidianquBean> haidianqu;

        private List<dongchengquBean> dongchengqu;


        private List<fengtaiquBean> fengtaiqu;


        private List<daxingquBean> daxingqu;


        private List<xichengquBean> xichengqu;

        private List<tongzhouquBean> tongzhouqu;


        private List<changpingquBean> changpingqu;

        private List<fangshanquBean> fangshanqu;

        private List<shunyiquBean> shunyiqu;

        private List<mentougouquBean> mentougouqu;


        private List<shijingshanquBean> shijingshanqu;


        private List<huairouquBean> huairouqu;

        private List<pingguquBean> pingguqu;


        private List<miyunxianBean> miyunxian;


        private List<yanqingxianBean> yanqingxian;

        public List<chaoyangquBean> getchaoyangqu() {
            return chaoyangqu;
        }

        public void setchaoyangqu(List<chaoyangquBean> chaoyangqu) {
            this.chaoyangqu = chaoyangqu;
        }

        public List<haidianquBean> gethaidianqu() {
            return haidianqu;
        }

        public void sethaidianqu(List<haidianquBean> haidianqu) {
            this.haidianqu = haidianqu;
        }

        public List<dongchengquBean> getdongchengqu() {
            return dongchengqu;
        }

        public void setdongchengqu(List<dongchengquBean> dongchengqu) {
            this.dongchengqu = dongchengqu;
        }

        public List<fengtaiquBean> getfengtaiqu() {
            return fengtaiqu;
        }

        public void setfengtaiqu(List<fengtaiquBean> fengtaiqu) {
            this.fengtaiqu = fengtaiqu;
        }

        public List<daxingquBean> getdaxingqu() {
            return daxingqu;
        }

        public void setdaxingqu(List<daxingquBean> daxingqu) {
            this.daxingqu = daxingqu;
        }

        public List<xichengquBean> getxichengqu() {
            return xichengqu;
        }

        public void setxichengqu(List<xichengquBean> xichengqu) {
            this.xichengqu = xichengqu;
        }

        public List<tongzhouquBean> gettongzhouqu() {
            return tongzhouqu;
        }

        public void settongzhouqu(List<tongzhouquBean> tongzhouqu) {
            this.tongzhouqu = tongzhouqu;
        }

        public List<changpingquBean> getchangpingqu() {
            return changpingqu;
        }

        public void setchangpingqu(List<changpingquBean> changpingqu) {
            this.changpingqu = changpingqu;
        }

        public List<fangshanquBean> getfangshanqu() {
            return fangshanqu;
        }

        public void setfangshanqu(List<fangshanquBean> fangshanqu) {
            this.fangshanqu = fangshanqu;
        }

        public List<shunyiquBean> getshunyiqu() {
            return shunyiqu;
        }

        public void setshunyiqu(List<shunyiquBean> shunyiqu) {
            this.shunyiqu = shunyiqu;
        }

        public List<mentougouquBean> getmentougouqu() {
            return mentougouqu;
        }

        public void setmentougouqu(List<mentougouquBean> mentougouqu) {
            this.mentougouqu = mentougouqu;
        }

        public List<shijingshanquBean> getshijingshanqu() {
            return shijingshanqu;
        }

        public void setshijingshanqu(List<shijingshanquBean> shijingshanqu) {
            this.shijingshanqu = shijingshanqu;
        }

        public List<huairouquBean> gethuairouqu() {
            return huairouqu;
        }

        public void sethuairouqu(List<huairouquBean> huairouqu) {
            this.huairouqu = huairouqu;
        }

        public List<pingguquBean> getpingguqu() {
            return pingguqu;
        }

        public void setpingguqu(List<pingguquBean> pingguqu) {
            this.pingguqu = pingguqu;
        }

        public List<miyunxianBean> getmiyunxian() {
            return miyunxian;
        }

        public void setmiyunxian(List<miyunxianBean> miyunxian) {
            this.miyunxian = miyunxian;
        }

        public List<yanqingxianBean> getyanqingxian() {
            return yanqingxian;
        }

        public void setyanqingxian(List<yanqingxianBean> yanqingxian) {
            this.yanqingxian = yanqingxian;
        }

        public static class chaoyangquBean {
            private int deal;
            private int distance;
            private int follow;
            private int imax;
            private String brd;
            private String dis;
            private String nm;
            private int poiId;
            private String ct;
            private double sellPrice;
            private int sellmin;
            private boolean sell;
            private int preferential;
            private String addr;
            private String area;
            private double lat;
            private double lng;
            private int brdId;
            private double dealPrice;
            private double referencePrice;
            private int showCount;
            private int id;

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public double getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(double sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public double getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(double dealPrice) {
                this.dealPrice = dealPrice;
            }

            public double getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(double referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class haidianquBean {
            private int deal;
            private int distance;
            private int follow;
            private int imax;
            private String brd;
            private String dis;
            private String nm;
            private int poiId;
            private String ct;
            private double sellPrice;
            private int sellmin;
            private boolean sell;
            private int preferential;
            private String addr;
            private String area;
            private double lat;
            private double lng;
            private int brdId;
            private double dealPrice;
            private double referencePrice;
            private int showCount;
            private int id;

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public double getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(double sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public double getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(double dealPrice) {
                this.dealPrice = dealPrice;
            }

            public double getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(double referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class dongchengquBean {
            private int deal;
            private int distance;
            private int follow;
            private int imax;
            private String brd;
            private String dis;
            private String nm;
            private int poiId;
            private String ct;
            private double sellPrice;
            private int sellmin;
            private boolean sell;
            private int preferential;
            private String addr;
            private String area;
            private double lat;
            private double lng;
            private int brdId;
            private double dealPrice;
            private double referencePrice;
            private int showCount;
            private int id;

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public double getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(double sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public double getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(double dealPrice) {
                this.dealPrice = dealPrice;
            }

            public double getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(double referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class fengtaiquBean {
            private int deal;
            private int distance;
            private int follow;
            private int imax;
            private String brd;
            private String dis;
            private String nm;
            private int poiId;
            private String ct;
            private double sellPrice;
            private int sellmin;
            private boolean sell;
            private int preferential;
            private String addr;
            private String area;
            private double lat;
            private double lng;
            private int brdId;
            private double dealPrice;
            private double referencePrice;
            private int showCount;
            private int id;

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public double getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(double sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public double getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(double dealPrice) {
                this.dealPrice = dealPrice;
            }

            public double getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(double referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class daxingquBean {
            private int deal;
            private int distance;
            private int follow;
            private int imax;
            private String brd;
            private String dis;
            private String nm;
            private int poiId;
            private String ct;
            private double sellPrice;
            private int sellmin;
            private boolean sell;
            private int preferential;
            private String addr;
            private String area;
            private double lat;
            private double lng;
            private int brdId;
            private double dealPrice;
            private double referencePrice;
            private int showCount;
            private int id;

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public double getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(double sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public double getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(double dealPrice) {
                this.dealPrice = dealPrice;
            }

            public double getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(double referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class xichengquBean {
            private int deal;
            private int distance;
            private int follow;
            private int imax;
            private String brd;
            private String dis;
            private String nm;
            private int poiId;
            private String ct;
            private double sellPrice;
            private int sellmin;
            private boolean sell;
            private int preferential;
            private String addr;
            private String area;
            private double lat;
            private double lng;
            private int brdId;
            private double dealPrice;
            private double referencePrice;
            private int showCount;
            private int id;

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public double getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(double sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public double getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(double dealPrice) {
                this.dealPrice = dealPrice;
            }

            public double getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(double referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class tongzhouquBean {
            private int deal;
            private int distance;
            private int follow;
            private int imax;
            private String brd;
            private String dis;
            private String nm;
            private int poiId;
            private String ct;
            private double sellPrice;
            private int sellmin;
            private boolean sell;
            private int preferential;
            private String addr;
            private String area;
            private double lat;
            private double lng;
            private int brdId;
            private double dealPrice;
            private double referencePrice;
            private int showCount;
            private int id;

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public double getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(double sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public double getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(double dealPrice) {
                this.dealPrice = dealPrice;
            }

            public double getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(double referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class changpingquBean {
            private int deal;
            private int distance;
            private int follow;
            private int imax;
            private String brd;
            private String dis;
            private String nm;
            private int poiId;
            private String ct;
            private double sellPrice;
            private int sellmin;
            private boolean sell;
            private int preferential;
            private String addr;
            private String area;
            private double lat;
            private double lng;
            private int brdId;
            private double dealPrice;
            private double referencePrice;
            private int showCount;
            private int id;

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public double getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(double sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public double getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(double dealPrice) {
                this.dealPrice = dealPrice;
            }

            public double getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(double referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class fangshanquBean {
            private int deal;
            private int distance;
            private int follow;
            private int imax;
            private String brd;
            private String dis;
            private String nm;
            private int poiId;
            private String ct;
            private double sellPrice;
            private int sellmin;
            private boolean sell;
            private int preferential;
            private String addr;
            private String area;
            private double lat;
            private double lng;
            private int brdId;
            private double dealPrice;
            private double referencePrice;
            private int showCount;
            private int id;

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public double getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(double sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public double getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(double dealPrice) {
                this.dealPrice = dealPrice;
            }

            public double getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(double referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class shunyiquBean {
            private int deal;
            private int distance;
            private int follow;
            private int imax;
            private String brd;
            private String dis;
            private String nm;
            private int poiId;
            private String ct;
            private double sellPrice;
            private int sellmin;
            private boolean sell;
            private int preferential;
            private String addr;
            private String area;
            private double lat;
            private double lng;
            private int brdId;
            private double dealPrice;
            private double referencePrice;
            private int showCount;
            private int id;

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public double getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(double sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public double getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(double dealPrice) {
                this.dealPrice = dealPrice;
            }

            public double getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(double referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class mentougouquBean {
            private int deal;
            private int distance;
            private int follow;
            private int imax;
            private String brd;
            private String dis;
            private String nm;
            private int poiId;
            private String ct;
            private double sellPrice;
            private int sellmin;
            private boolean sell;
            private int preferential;
            private String addr;
            private String area;
            private double lat;
            private double lng;
            private int brdId;
            private double dealPrice;
            private double referencePrice;
            private int showCount;
            private int id;

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public double getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(double sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public double getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(double dealPrice) {
                this.dealPrice = dealPrice;
            }

            public double getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(double referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class shijingshanquBean {
            private int deal;
            private int distance;
            private int follow;
            private int imax;
            private String brd;
            private String dis;
            private String nm;
            private int poiId;
            private String ct;
            private double sellPrice;
            private int sellmin;
            private boolean sell;
            private int preferential;
            private String addr;
            private String area;
            private double lat;
            private double lng;
            private int brdId;
            private double dealPrice;
            private double referencePrice;
            private int showCount;
            private int id;

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public double getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(double sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public double getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(double dealPrice) {
                this.dealPrice = dealPrice;
            }

            public double getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(double referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class huairouquBean {
            private int deal;
            private int distance;
            private int follow;
            private int imax;
            private String brd;
            private String dis;
            private String nm;
            private int poiId;
            private String ct;
            private double sellPrice;
            private int sellmin;
            private boolean sell;
            private int preferential;
            private String addr;
            private String area;
            private double lat;
            private double lng;
            private int brdId;
            private double dealPrice;
            private double referencePrice;
            private int showCount;
            private int id;

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public double getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(double sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public double getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(double dealPrice) {
                this.dealPrice = dealPrice;
            }

            public double getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(double referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class pingguquBean {
            private int deal;
            private int distance;
            private int follow;
            private int imax;
            private String brd;
            private String dis;
            private String nm;
            private int poiId;
            private String ct;
            private double sellPrice;
            private int sellmin;
            private boolean sell;
            private int preferential;
            private String addr;
            private String area;
            private double lat;
            private double lng;
            private int brdId;
            private double dealPrice;
            private double referencePrice;
            private int showCount;
            private int id;

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public double getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(double sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public double getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(double dealPrice) {
                this.dealPrice = dealPrice;
            }

            public double getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(double referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class miyunxianBean {
            private int deal;
            private int distance;
            private int follow;
            private int imax;
            private String brd;
            private String dis;
            private String nm;
            private int poiId;
            private String ct;
            private double sellPrice;
            private int sellmin;
            private boolean sell;
            private int preferential;
            private String addr;
            private String area;
            private double lat;
            private double lng;
            private int brdId;
            private double dealPrice;
            private double referencePrice;
            private int showCount;
            private int id;

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public double getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(double sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public double getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(double dealPrice) {
                this.dealPrice = dealPrice;
            }

            public double getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(double referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class yanqingxianBean {
            private int deal;
            private int distance;
            private int follow;
            private int imax;
            private String brd;
            private String dis;
            private String nm;
            private int poiId;
            private String ct;
            private double sellPrice;
            private int sellmin;
            private boolean sell;
            private int preferential;
            private String addr;
            private String area;
            private double lat;
            private double lng;
            private int brdId;
            private double dealPrice;
            private double referencePrice;
            private int showCount;
            private int id;

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public double getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(double sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public double getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(double dealPrice) {
                this.dealPrice = dealPrice;
            }

            public double getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(double referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }

}
