package maoyan.pjs.com.maoyan.bean;

import java.util.List;

/**
 * Created by pjs984312808 on 2016/7/2.
 */
public class ShopgrideBean {

    /**
     * list : [{"dealid":38292972,"pic":"http://p0.meituan.net/348.348/movie/36aba8e808faa11da5e015add2d0c1b2139888.jpg@60q","price":35,"title":"GetD魔兽电影主题3D眼镜（预售）","value":99},{"dealid":38330793,"pic":"http://p0.meituan.net/348.348/movie/b2d68f14b9ff41b75211af78cb767a5a273569.jpg@60q","price":89,"title":"愤怒的小鸟毛绒玩具 大电影儿童公仔玩具","value":119},{"dealid":38319221,"pic":"http://p0.meituan.net/348.348/movie/e09ae917fa6e238237cab5e7570c933f410487.jpg@60q","price":68,"title":"愤怒的小鸟经典常规款公仔 30cm","value":78},{"dealid":38319215,"pic":"http://p0.meituan.net/348.348/movie/b2d68f14b9ff41b75211af78cb767a5a273569.jpg@60q","price":88,"title":"愤怒的小鸟经典款大号公仔 37CM","value":98},{"dealid":38319224,"pic":"http://p1.meituan.net/348.348/movie/2fea2c8ac8b3c090c699c4421cdd8f32355332.jpg@60q","price":48,"title":"愤怒的小鸟经典款小公仔 22cm","value":60},{"dealid":38319228,"pic":"http://p0.meituan.net/348.348/movie/dfa76dd2a59ca7fdb3738b726bfd439d366839.jpg@60q","price":28,"title":"愤怒的小鸟系列经典款迷你公仔3件包邮！","value":38},{"dealid":38330823,"pic":"http://p1.meituan.net/348.348/movie/55ea6ecf7d045450c80dedbe0da85d4f44402.jpg@60q","price":199,"title":"《魔兽世界》正版模型 洛萨之剑","value":209},{"dealid":38330820,"pic":"http://p0.meituan.net/348.348/movie/1b5b9c6814b1268c047f2da9073eef5050289.jpg@60q","price":199,"title":"《魔兽世界》 杜隆坦之斧升级版","value":209},{"dealid":38330819,"pic":"http://p0.meituan.net/348.348/movie/a174a9391c38afd0320c8c6164706e3130991.jpg@60q","price":39,"title":"《魔兽世界》正版3D眼镜联盟款","value":69},{"dealid":38330818,"pic":"http://p0.meituan.net/348.348/movie/ec71dc9533a98f9a1045eeb252f517af23998.jpg@60q","price":39,"title":"《魔兽世界》正版3D眼镜部落款","value":69}]
     * total : 823
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int total;
        /**
         * dealid : 38292972
         * pic : http://p0.meituan.net/348.348/movie/36aba8e808faa11da5e015add2d0c1b2139888.jpg@60q
         * price : 35
         * title : GetD魔兽电影主题3D眼镜（预售）
         * value : 99
         */

        private List<ListBean> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private int dealid;
            private String pic;
            private int price;
            private String title;
            private int value;

            public int getDealid() {
                return dealid;
            }

            public void setDealid(int dealid) {
                this.dealid = dealid;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }
    }
}
