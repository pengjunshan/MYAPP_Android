package maoyan.pjs.com.maoyan.bean;

import java.util.List;

/**
 * Created by pjs984312808 on 2016/6/29.
 */
public class WaitExpctBean {

    /**
     * boardtype : 6
     * content : 《猫眼想看月度榜》——将昨日国内待映的影片，按照之前30天的想看数增量从高到低排列，取前50名，每天上午10点更新，相关数据来源于“猫眼电影库”。
     * created : 2016-06-29
     * id : 6
     * movies : [{"dir":"周拓如","id":246575,"img":"http://p0.meituan.net/w.h/movie/37e7ed909843270f0880c325b6be7b60436509.jpg","monthWish":87225,"nm":"致青春·原来你还在这里","rt":"2016-07-08","star":"吴亦凡,刘亦菲,金世佳","wish":220708},{"dir":"戴夫·格林","id":13511,"img":"http://p1.meituan.net/w.h/movie/a375ebfcdc2a396423c368b943813b01179997.jpg","monthWish":73647,"nm":"忍者神龟2：破影而出","rt":"2016-07-02","star":"梅根·福克斯,皮特·普劳泽克,阿伦·瑞奇森","wish":273701},{"dir":"梁旋,张春","id":246591,"img":"http://p1.meituan.net/w.h/movie/a607ab45bcc9e8486328b39bff0132a4420994.jpg","monthWish":70012,"nm":"大鱼海棠","rt":"2016-07-08","wish":147035},{"dir":"申太罗","id":338506,"img":"http://p1.meituan.net/w.h/movie/45f8587cb425a01c9a279082772a8bd0379497.jpg","monthWish":63518,"nm":"赏金猎人","rt":"2016-07-01","star":"李敏镐,钟汉良,唐嫣","wish":137264},{"dir":"梁乐民,陆剑青","id":341289,"img":"http://p0.meituan.net/w.h/movie/d196d1391e1dc1eff190275a57a60d6c261789.jpg","monthWish":56542,"nm":"寒战2","rt":"2016-07-08","star":"郭富城,梁家辉,杨采妮","wish":145764},{"dir":"赵真奎","id":246231,"img":"http://p0.meituan.net/w.h/movie/d119c886583c2cb8764283b9b58395e2807646.jpg","monthWish":47495,"nm":"夏有乔木 雅望天堂","rt":"2016-08-05","star":"吴亦凡,韩庚,卢杉","wish":229310},{"dir":"金帝荣","id":343379,"img":"http://p1.meituan.net/w.h/movie/79311d41bea3be8f1677c0b69a5868fa289298.jpg","monthWish":45538,"nm":"所以\u2026\u2026和黑粉结婚了","rt":"2016-06-30","star":"朴灿烈,袁姗姗,姜潮","wish":100550},{"dir":"雷尼·哈林","id":246307,"img":"http://p1.meituan.net/w.h/movie/5ff2a0181044df25a2c1f8492fe0589211151892.jpg","monthWish":45189,"nm":"绝地逃亡","rt":"2016-07-22","star":"成龙,范冰冰,约翰尼·诺克斯维尔","wish":201187},{"dir":"刘镇伟","id":247259,"img":"http://p0.meituan.net/w.h/movie/20a716c33bef81fa038c8c0554725c0a80811.jpg","monthWish":34427,"nm":"大话西游3","rt":"2016-08-19","star":"韩庚,唐嫣,莫文蔚","wish":128265},{"dir":"李仁港","id":79203,"img":"http://p0.meituan.net/w.h/movie/9076b97b6c9a853f1a343b2f4384eac87566851.jpg","monthWish":31996,"nm":"盗墓笔记","rt":"2016-08-05","star":"井柏然,鹿晗,马思纯","wish":309341}]
     * paging : {"hasMore":true,"limit":10,"offset":0,"total":50}
     * shareHidden : 1
     * title : 猫眼想看月度榜
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int boardtype;
        private String content;
        private String created;
        private int id;
        /**
         * hasMore : true
         * limit : 10
         * offset : 0
         * total : 50
         */

        private PagingBean paging;
        private int shareHidden;
        private String title;
        /**
         * dir : 周拓如
         * id : 246575
         * img : http://p0.meituan.net/w.h/movie/37e7ed909843270f0880c325b6be7b60436509.jpg
         * monthWish : 87225
         * nm : 致青春·原来你还在这里
         * rt : 2016-07-08
         * star : 吴亦凡,刘亦菲,金世佳
         * wish : 220708
         */

        private List<MoviesBean> movies;

        public int getBoardtype() {
            return boardtype;
        }

        public void setBoardtype(int boardtype) {
            this.boardtype = boardtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public PagingBean getPaging() {
            return paging;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public int getShareHidden() {
            return shareHidden;
        }

        public void setShareHidden(int shareHidden) {
            this.shareHidden = shareHidden;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<MoviesBean> getMovies() {
            return movies;
        }

        public void setMovies(List<MoviesBean> movies) {
            this.movies = movies;
        }

        public static class PagingBean {
            private boolean hasMore;
            private int limit;
            private int offset;
            private int total;

            public boolean isHasMore() {
                return hasMore;
            }

            public void setHasMore(boolean hasMore) {
                this.hasMore = hasMore;
            }

            public int getLimit() {
                return limit;
            }

            public void setLimit(int limit) {
                this.limit = limit;
            }

            public int getOffset() {
                return offset;
            }

            public void setOffset(int offset) {
                this.offset = offset;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }
        }

        public static class MoviesBean {
            private String dir;
            private int id;
            private String img;
            private int monthWish;
            private String nm;
            private String rt;
            private String star;
            private int wish;

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public int getMonthWish() {
                return monthWish;
            }

            public void setMonthWish(int monthWish) {
                this.monthWish = monthWish;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public String getRt() {
                return rt;
            }

            public void setRt(String rt) {
                this.rt = rt;
            }

            public String getStar() {
                return star;
            }

            public void setStar(String star) {
                this.star = star;
            }

            public int getWish() {
                return wish;
            }

            public void setWish(int wish) {
                this.wish = wish;
            }
        }
    }
}
