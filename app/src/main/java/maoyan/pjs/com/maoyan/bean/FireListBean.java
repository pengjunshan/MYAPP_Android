package maoyan.pjs.com.maoyan.bean;

import java.util.List;

/**
 * Created by pjs984312808 on 2016/6/25.
 */
public class FireListBean {


    /**
     * expires : 1800
     */

    private ControlBean control;
    /**
     * control : {"expires":1800}
     * status : 0
     * data : {"hasNext":false,"movies":[{"showInfo":"今天151家影院放映2004场","cnms":0,"late":false,"sn":0,"nm":"惊天魔盗团2","img":"http://p1.meituan.net/165.220/movie/2e0b5b5c6c086cc93068fbc212f9f6b0142193.jpg","sc":8.7,"ver":"2D/3D/中国巨幕","rt":"本周五上映","dur":126,"imax":false,"snum":36625,"cat":"动作,喜剧,惊悚","wish":513937,"3d":true,"pn":244,"preSale":0,"vd":"","dir":"朱浩伟","star":"杰西·艾森伯格,马克·鲁法洛,伍迪·哈里森","src":"","scm":"周董变魔术，敌人挡不住","showDate":"","time":"","id":246333},{"showInfo":"今天152家影院放映1828场","cnms":0,"late":false,"sn":0,"nm":"独立日：卷土重来","img":"http://p1.meituan.net/165.220/movie/b408a9322cd0da51d4bdd3261ba3d1c0278866.jpg","sc":8.5,"ver":"3D/IMAX 3D/中国巨幕/全景声","rt":"本周五上映","dur":120,"imax":true,"snum":31935,"cat":"动作,冒险,科幻","wish":164747,"3d":true,"pn":226,"preSale":0,"vd":"","dir":"罗兰·艾默里奇","star":"利亚姆·海姆斯沃斯,杰夫·高布伦,杰西·厄舍","src":"","scm":"外星再入侵，地核将燃尽","showDate":"","time":"","id":246375},{"showInfo":"今天146家影院放映919场","cnms":0,"late":false,"sn":0,"nm":"三人行","img":"http://p1.meituan.net/165.220/movie/1c82df174422d9374f821482f445171b129671.jpg","sc":7.2,"ver":"2D","rt":"本周五上映","dur":88,"imax":false,"snum":17583,"cat":"动作,犯罪,悬疑","wish":72910,"3d":false,"pn":186,"preSale":0,"vd":"","dir":"杜琪峰","star":"赵薇,古天乐,钟汉良","src":"","scm":"悍匪有手段，中枪再作案","showDate":"","time":"","id":246972},{"showInfo":"今天145家影院放映682场","cnms":0,"late":false,"sn":0,"nm":"海底总动员2：多莉去哪儿","img":"http://p0.meituan.net/165.220/movie/4c20a91505854dcd0f9617069c5fec21843230.jpg","sc":8.7,"ver":"2D/3D/IMAX 3D/中国巨幕","rt":"2016-06-17上映","dur":97,"imax":true,"snum":59982,"cat":"动画,喜剧,冒险","wish":144949,"3d":true,"pn":123,"preSale":0,"vd":"","dir":"安德鲁·斯坦顿,安格斯·麦克莱恩","star":"艾伦·德詹尼丝,徐帆,艾伯特·布鲁克斯","src":"","scm":"唠叨鱼多莉，上路找父母","showDate":"","time":"","id":246366},{"showInfo":"今天120家影院放映403场","cnms":0,"late":false,"sn":0,"nm":"魔兽","img":"http://p0.meituan.net/165.220/movie/f94e67dcd5b48f034bd7adc892f1b20695854.jpeg","sc":9.2,"ver":"2D/3D/IMAX 3D/中国巨幕/全景声","rt":"2016-06-08上映","dur":124,"imax":true,"snum":720189,"cat":"动作,冒险,奇幻","wish":479894,"3d":true,"pn":347,"preSale":0,"vd":"","dir":"邓肯·琼斯","star":"崔维斯·费米尔,宝拉·巴顿,本·福斯特","src":"","scm":"怒拳为谁握，联盟斗部落","showDate":"","time":"","id":78421},{"showInfo":"2016-07-08上映","cnms":0,"late":false,"sn":0,"nm":"致青春·原来你还在这里","img":"http://p0.meituan.net/165.220/movie/37e7ed909843270f0880c325b6be7b60436509.jpg","sc":0,"ver":"2D","rt":"2016-07-08上映","dur":98,"imax":false,"snum":4201,"cat":"剧情,爱情","wish":198876,"3d":false,"pn":333,"preSale":1,"vd":"","dir":"周拓如","star":"吴亦凡,刘亦菲,金世佳","src":"","scm":"霸道男学霸，爱上女学渣","showDate":"","time":"","id":246575},{"showInfo":"2016-07-02 下周六上映","cnms":0,"late":false,"sn":0,"nm":"忍者神龟2：破影而出","img":"http://p1.meituan.net/165.220/movie/a375ebfcdc2a396423c368b943813b01179997.jpg","sc":0,"ver":"2D/3D/IMAX 3D/中国巨幕","rt":"下周六上映","dur":113,"imax":true,"snum":1442,"cat":"动作,冒险,喜剧","wish":258637,"3d":true,"pn":249,"preSale":1,"vd":"","dir":"戴夫·格林","star":"梅根·福克斯,皮特·普劳泽克,阿伦·瑞奇森","src":"","scm":"儿时忍者龟，犀牛也回归","showDate":"","time":"","id":13511},{"showInfo":"2016-06-30 下周四上映","cnms":0,"late":false,"sn":0,"nm":"所以\u2026\u2026和黑粉结婚了","img":"http://p1.meituan.net/165.220/movie/79311d41bea3be8f1677c0b69a5868fa289298.jpg","sc":0,"ver":"2D","rt":"下周四上映","dur":99,"imax":false,"snum":6851,"cat":"爱情,喜剧","wish":88614,"3d":false,"pn":121,"preSale":1,"vd":"","dir":"金帝荣","star":"朴灿烈,袁姗姗,姜潮","src":"","scm":"黑粉变新娘，这是闹哪样","showDate":"","time":"","id":343379},{"showInfo":"今天60家影院放映108场","cnms":0,"late":false,"sn":0,"nm":"X战警：天启","img":"http://p1.meituan.net/165.220/movie/ba2386a26648c1875e3fc780950f0ae0144875.jpg","sc":9.1,"ver":"3D/IMAX 3D/中国巨幕/全景声","rt":"2016-06-03上映","dur":144,"imax":true,"snum":444615,"cat":"动作,科幻,奇幻","wish":559919,"3d":true,"pn":692,"preSale":0,"vd":"","dir":"布莱恩·辛格","star":"詹姆斯·麦卡沃伊,迈克尔·法斯宾德,詹妮弗·劳伦斯","src":"","scm":"天启当炮灰，千年洗剪吹","showDate":"","time":"","id":246177},{"showInfo":"今天47家影院放映86场","cnms":0,"late":false,"sn":0,"nm":"近在咫尺的爱恋","img":"http://p1.meituan.net/165.220/movie/a70da0aefb82886efbae696181e966ff620085.jpg","sc":7.5,"ver":"2D","rt":"本周五上映","dur":103,"imax":false,"snum":376,"cat":"爱情,运动,剧情","wish":12564,"3d":false,"pn":49,"preSale":0,"vd":"","dir":"程孝泽","star":"彭于晏,郭采洁,杨子姗","src":"","scm":"真爱在身旁，挥拳为理想","showDate":"","time":"","id":57217},{"showInfo":"2016-07-01 下周五上映","cnms":0,"late":false,"sn":0,"nm":"赏金猎人","img":"http://p1.meituan.net/165.220/movie/45f8587cb425a01c9a279082772a8bd0379497.jpg","sc":0,"ver":"2D/3D","rt":"下周五上映","dur":105,"imax":false,"snum":4126,"cat":"动作,喜剧,剧情,悬疑","wish":121263,"3d":true,"pn":196,"preSale":1,"vd":"","dir":"申太罗","star":"李敏镐,钟汉良,唐嫣","src":"","scm":"编外铁饭碗，收钱抓逃犯","showDate":"","time":"","id":338506},{"showInfo":"2016-07-01 下周五上映","cnms":0,"late":false,"sn":0,"nm":"魔轮","img":"http://p0.meituan.net/165.220/movie/1d44cc6185a7ee4ee1def1f3a0f5821a584683.jpg","sc":0,"ver":"2D/3D","rt":"下周五上映","dur":92,"imax":false,"snum":431,"cat":"悬疑,惊悚,恐怖","wish":8537,"3d":true,"pn":49,"preSale":1,"vd":"","dir":"王早","star":"林心如,何润东,金世佳","src":"","scm":"天涯号起航，失控大逃亡","showDate":"","time":"","id":342741},{"showInfo":"今天18家影院放映20场","cnms":0,"late":false,"sn":0,"nm":"筷仙","img":"http://p1.meituan.net/165.220/movie/31a325f0796cfebbab24776024eeec91100800.jpeg","sc":4.4,"ver":"2D","rt":"2016-06-17上映","dur":87,"imax":false,"snum":12105,"cat":"恐怖,惊悚","wish":20373,"3d":false,"pn":32,"preSale":0,"vd":"","dir":"姬雨","star":"胡影怡,朱璇,周骏","src":"","scm":"笔仙已玩坏，筷仙来作怪","showDate":"","time":"","id":343597},{"showInfo":"2016-07-02 下周六上映","cnms":0,"late":false,"sn":0,"nm":"丑小鸭历险记","img":"http://p1.meituan.net/165.220/movie/0484f8ad5aec878112f1a04715d32b4e360620.jpg","sc":0,"ver":"2D","rt":"下周六上映","dur":81,"imax":false,"snum":85,"cat":"动画,科幻,冒险","wish":2848,"3d":false,"pn":66,"preSale":1,"vd":"","dir":"郑义","star":"朱可可,阿飞,夏倚轩","src":"","scm":"月球机器鸭，化身小飞鸭","showDate":"","time":"","id":368271},{"showInfo":"今天10家影院放映11场","cnms":0,"late":false,"sn":0,"nm":"百鸟朝凤","img":"http://p1.meituan.net/165.220/movie/ef968fd382173c45b0c2d10572ca10b8354896.jpg","sc":9.2,"ver":"2D","rt":"2016-05-06上映","dur":108,"imax":false,"snum":108966,"cat":"历史,音乐,剧情","wish":3981,"3d":false,"pn":105,"preSale":0,"vd":"","dir":"吴天明","star":"陶泽如,郑伟,李岷城","src":"","scm":"两代手艺人，唢呐感情深","showDate":"","time":"","id":248260},{"showInfo":"今天6家影院放映11场","cnms":0,"late":false,"sn":0,"nm":"爱丽丝梦游仙境2：镜中奇遇记","img":"http://p1.meituan.net/165.220/movie/dbcc3eabae012da794fe4b74ed1365fc659390.jpg","sc":8.6,"ver":"2D/3D/IMAX 3D/中国巨幕/全景声","rt":"2016-05-27上映","dur":115,"imax":true,"snum":224941,"cat":"奇幻,冒险,喜剧","wish":248677,"3d":true,"pn":82,"preSale":0,"vd":"","dir":"詹姆斯·波宾","star":"约翰尼·德普,安妮·海瑟薇,米娅·华希科沃斯卡","src":"","scm":"镜中再梦游，拯救老朋友","showDate":"","time":"","id":248680},{"showInfo":"今天10家影院放映10场","cnms":0,"late":false,"sn":0,"nm":"我叫MT之山口山战记","img":"http://p0.meituan.net/165.220/movie/73f6abbb90259d1fa8a88fa907ca3062587352.jpg","sc":7.6,"ver":"3D/中国巨幕","rt":"2016-06-17上映","dur":86,"imax":false,"snum":19160,"cat":"动画,喜剧,冒险","wish":43480,"3d":true,"pn":40,"preSale":0,"vd":"","dir":"核桃","star":"奶茶,YOYO,CBI","src":"","scm":"贱萌牛头人，爆笑刷副本","showDate":"","time":"","id":246045},{"showInfo":"2016-06-27 下周一上映","cnms":0,"late":false,"sn":0,"nm":"大火种","img":"http://p1.meituan.net/165.220/movie/c8545c7bd1f6070f0d52a77bd0ddd8738720802.jpg","sc":0,"ver":"2D","rt":"下周一上映","dur":114,"imax":false,"snum":30,"cat":"剧情,历史,战争","wish":340,"3d":false,"pn":4,"preSale":1,"vd":"","dir":"苗月","star":"白威,陈瑾,王柠","src":"","scm":"誓死护宣言，智斗救火种","showDate":"","time":"","id":337438},{"showInfo":"今天6家影院放映6场","cnms":0,"late":false,"sn":0,"nm":"北京遇上西雅图之不二情书","img":"http://p1.meituan.net/165.220/movie/fe80bc40822d0a5f3168b73089c47d71101133.jpg","sc":8.5,"ver":"2D/中国巨幕","rt":"2016-04-29上映","dur":132,"imax":false,"snum":445400,"cat":"爱情,剧情","wish":307383,"3d":false,"pn":547,"preSale":0,"vd":"","dir":"薛晓路","star":"汤唯,吴秀波,惠英红","src":"","scm":"异国心未远，书信寄情缘","showDate":"","time":"","id":247575},{"showInfo":"今天4家影院放映6场","cnms":0,"late":false,"sn":0,"nm":"南口1937","img":"http://p1.meituan.net/165.220/movie/f4b5d903571ec3c3fc952f86261b04fd227842.jpg","sc":0,"ver":"2D","rt":"本周四上映","dur":98,"imax":false,"snum":105,"cat":"剧情,历史,战争","wish":2034,"3d":false,"pn":26,"preSale":0,"vd":"","dir":"朱丹","star":"孙看,孙洪涛,刘忠元","src":"","scm":"南口抗日战，疆场洒血汗","showDate":"","time":"","id":368071},{"showInfo":"今天5家影院放映5场","cnms":0,"late":false,"sn":0,"nm":"愤怒的小鸟","img":"http://p0.meituan.net/165.220/movie/b721e73740601799c065affb619d837e151622.jpg","sc":8.9,"ver":"3D/中国巨幕","rt":"2016-05-20上映","dur":97,"imax":false,"snum":319381,"cat":"动画,奇幻,冒险","wish":123045,"3d":true,"pn":132,"preSale":0,"vd":"","dir":"费格尔·雷利,克莱·凯蒂","star":"杰森·苏戴奇斯,乔什·盖德,丹尼·麦克布耐德","src":"","scm":"绿猪来偷蛋，鸟儿群奋战","showDate":"","time":"","id":246188},{"showInfo":"今天3家影院放映3场","cnms":0,"late":false,"sn":0,"nm":"叶问2：宗师传奇","img":"http://p0.meituan.net/165.220/movie/70/612717.jpg","sc":8.5,"ver":"2D","rt":"2010-04-27上映","dur":108,"imax":false,"snum":1031,"cat":"动作,历史,传记","wish":211,"3d":false,"pn":63,"preSale":0,"vd":"","dir":"叶伟信","star":"甄子丹,洪金宝,熊黛林","src":"","scm":"叶问搬香港，仇恨值渐长","showDate":"","time":"","id":524},{"showInfo":"2016-07-01 下周五上映","cnms":0,"late":false,"sn":0,"nm":"党的女儿尹灵芝","img":"http://p0.meituan.net/165.220/movie/1dffa0a076e3514234f2029d6b29b3da157605.jpg","sc":0,"ver":"2D","rt":"下周五上映","dur":107,"imax":false,"snum":135,"cat":"剧情,历史","wish":618,"3d":false,"pn":17,"preSale":1,"vd":"","dir":"卫晓茼","star":"郜耀平,张志宏,姚安濂","src":"","scm":"心中有信仰，少年变战士","showDate":"","time":"","id":672123},{"showInfo":"今天2家影院放映2场","cnms":0,"late":false,"sn":0,"nm":"人再囧途之泰囧","img":"http://p0.meituan.net/165.220/movie/38/280521.jpg","sc":8.8,"ver":"2D","rt":"2012-12-12上映","dur":105,"imax":false,"snum":15633,"cat":"喜剧","wish":22543,"3d":false,"pn":232,"preSale":0,"vd":"","dir":"徐峥","star":"徐峥,王宝强,黄渤","src":"","scm":"囧途太荒唐，甩不掉宝强","showDate":"","time":"","id":938},{"showInfo":"今天2家影院放映2场","cnms":0,"late":false,"sn":0,"nm":"同桌的你","img":"http://p0.meituan.net/165.220/movie/__40811615__5745234.jpg","sc":8.6,"ver":"2D","rt":"2014-04-25上映","dur":98,"imax":false,"snum":73036,"cat":"剧情,爱情","wish":24267,"3d":false,"pn":88,"preSale":0,"vd":"","dir":"郭帆","star":"周冬雨,林更新,隋凯","src":"","scm":"初恋要结婚，回国忆青春","showDate":"","time":"","id":78653},{"showInfo":"今天2家影院放映2场","cnms":0,"late":false,"sn":0,"nm":"死亡游戏","img":"http://p1.meituan.net/165.220/movie/c3eec836300c5a9f0429d96921aa168472038.jpg","sc":5.8,"ver":"2D","rt":"2016-06-03上映","dur":90,"imax":false,"snum":5373,"cat":"恐怖,惊悚,悬疑","wish":3301,"3d":false,"pn":145,"preSale":0,"vd":"","dir":"麦子","star":"徐洁儿,陈欢,陈炳强","src":"","scm":"同学生日会，恶鬼来相会","showDate":"","time":"","id":346286},{"showInfo":"2016-07-01 下周五上映","cnms":0,"late":false,"sn":0,"nm":"终极胜利","img":"http://p1.meituan.net/165.220/movie/0c93b5987ae440497dd985982aad1c4b233221.jpg","sc":0,"ver":"2D","rt":"下周五上映","dur":108,"imax":false,"snum":65,"cat":"剧情,战争,历史","wish":4798,"3d":false,"pn":122,"preSale":1,"vd":"","dir":"冼杞然","star":"窦骁,约瑟夫·费因斯,娄宇健","src":"","scm":"辛德勒名单，推出中国版","showDate":"","time":"","id":341123},{"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"sn":0,"nm":"宫锁沉香","img":"http://p0.meituan.net/165.220/movie/__18327195__7709930.jpg","sc":7.8,"ver":"2D","rt":"2013-08-13上映","dur":115,"imax":false,"snum":2509,"cat":"剧情,爱情,古装","wish":3080,"3d":false,"pn":36,"preSale":0,"vd":"","dir":"潘安子","star":"周冬雨,陈晓,赵丽颖","src":"","scm":"唯美清宫戏，阴谋不见底","showDate":"","time":"","id":78176},{"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"sn":0,"nm":"有人赞美聪慧,有人则不","img":"http://p0.meituan.net/165.220/movie/__16523889__6590864.jpg","sc":7.8,"ver":"2D","rt":"2013-11待定","dur":108,"imax":false,"snum":54,"cat":"动画,家庭","wish":184,"3d":false,"pn":98,"preSale":0,"vd":"","dir":"杨瑾","star":"李书晨,王琛,卫永绍","src":"","scm":"离家偷玩耍，乡下过暑假","showDate":"","time":"2013-11","id":78224},{"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"sn":0,"nm":"警察故事2013","img":"http://p0.meituan.net/165.220/movie/__29561506__7176229.jpg","sc":8,"ver":"2D/IMAX 3D","rt":"2013-12-24上映","dur":108,"imax":true,"snum":19131,"cat":"剧情,动作,犯罪","wish":14520,"3d":true,"pn":44,"preSale":0,"vd":"","dir":"丁晟","star":"刘烨,成龙,景甜","src":"","scm":"女儿乱交友，老爹来出头","showDate":"","time":"","id":77192},{"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"sn":0,"nm":"北京爱情故事","img":"http://p0.meituan.net/165.220/movie/__33456063__6265360.jpg","sc":8,"ver":"2D","rt":"2014-02-14上映","dur":121,"imax":false,"snum":28683,"cat":"爱情","wish":12286,"3d":false,"pn":145,"preSale":0,"vd":"","dir":"陈思诚","star":"梁家辉,刘嘉玲,王学兵","src":"","scm":"恋爱分五段，激情不会散","showDate":"","time":"","id":78324},{"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"sn":0,"nm":"催眠大师","img":"http://p1.meituan.net/165.220/movie/__39582689__9041214.jpg","sc":9,"ver":"2D","rt":"2014-04-29上映","dur":102,"imax":false,"snum":46535,"cat":"剧情,悬疑,惊悚","wish":11396,"3d":false,"pn":78,"preSale":0,"vd":"","dir":"陈正道","star":"徐峥,莫文蔚,吕中","src":"","scm":"催眠治心伤，侧击猜真相","showDate":"","time":"","id":78672},{"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"sn":0,"nm":"闺蜜","img":"http://p1.meituan.net/165.220/movie/__48665963__9098444.jpg","sc":8,"ver":"2D","rt":"2014-07-30上映","dur":118,"imax":false,"snum":68741,"cat":"剧情,爱情","wish":30224,"3d":false,"pn":203,"preSale":0,"vd":"","dir":"黄真真","star":"陈意涵,薛凯琪,杨子姗","src":"","scm":"永远好闺蜜，渣男靠边去","showDate":"","time":"","id":78772},{"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"sn":0,"nm":"十万个冷笑话","img":"http://p1.meituan.net/165.220/movie/56cb96b2c6df95b66db4ce719993d5d0666565.jpg","sc":8.2,"ver":"2D","rt":"2014-12-31上映","dur":100,"imax":false,"snum":122608,"cat":"动画,喜剧,奇幻","wish":25775,"3d":false,"pn":79,"preSale":0,"vd":"","dir":"卢恒宇,李姝洁","star":"张杰,皇贞季,宝木中阳","src":"","scm":"男主有点拽，二次元崩坏","showDate":"","time":"","id":246067},{"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"sn":0,"nm":"奔跑吧！兄弟","img":"http://p0.meituan.net/165.220/movie/85f0d9a604e26be5523a848269346697296774.jpg","sc":4.7,"ver":"2D","rt":"2015-01-30上映","dur":88,"imax":false,"snum":361085,"cat":"喜剧,冒险,动作","wish":49025,"3d":false,"pn":118,"preSale":0,"vd":"","dir":"胡笳,岑俊义","star":"杨颖,王宝强,李晨","src":"","scm":"跑男再出发，集体游三亚","showDate":"","time":"","id":246316},{"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"sn":0,"nm":"横冲直撞好莱坞","img":"http://p1.meituan.net/165.220/movie/1c06c9055cb3990e76ee93c2c70789bb145247.jpg","sc":7.7,"ver":"2D/中国巨幕","rt":"2015-06-26上映","dur":119,"imax":false,"snum":282776,"cat":"喜剧,动作,冒险","wish":64522,"3d":false,"pn":273,"preSale":0,"vd":"","dir":"蒂姆·肯德尔","star":"赵薇,黄晓明,佟大为","src":"","scm":"逗比好基友，遇到坏导游","showDate":"","time":"","id":246178},{"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"sn":0,"nm":"通灵之六世古宅","img":"http://p1.meituan.net/165.220/movie/575f1cee324dd206d981b4dfcb1ec1bd1381691.jpg","sc":4.5,"ver":"2D/3D/中国巨幕","rt":"2015-07-24上映","dur":87,"imax":false,"snum":20074,"cat":"惊悚,恐怖","wish":34072,"3d":true,"pn":101,"preSale":0,"vd":"","dir":"彭发","star":"徐娇,张兆辉,毕秀茹","src":"","scm":"古宅心慌慌，通灵少女忙","showDate":"","time":"","id":246249},{"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"sn":0,"nm":"既然青春留不住","img":"http://p0.meituan.net/165.220/movie/90422e83536df2153ecc57ff9703e99c1111187.jpg","sc":8.2,"ver":"2D","rt":"2015-10-23上映","dur":92,"imax":false,"snum":83838,"cat":"喜剧,爱情","wish":78433,"3d":false,"pn":172,"preSale":0,"vd":"","dir":"田蒙","star":"张翰,陈乔恩,施予斐","src":"","scm":"校草撞菠菜，青春已不再","showDate":"","time":"","id":246540},{"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"sn":0,"nm":"我的诗篇","img":"http://p1.meituan.net/165.220/movie/a93a7b21b94073e778d30962a409cb02172463.jpg","sc":0,"ver":"2D","rt":"2015-11-01上映","dur":110,"imax":false,"snum":123,"cat":"纪录片","wish":631,"3d":false,"pn":19,"preSale":0,"vd":"","dir":"吴飞跃,秦晓宇","star":"乌鸟鸟,陈年喜,老井","src":"","scm":"生产线诗歌，朴素却深刻","showDate":"","time":"","id":341084},{"showInfo":"今天暂无场次","cnms":0,"late":false,"sn":0,"nm":"大电影2.0之两个傻瓜的荒唐事","img":"http://p1.meituan.net/165.220/movie/76ac89dad45ac25c676246dc92794b03318660.png","sc":5.6,"ver":"2D","rt":"2007-12-21上映","dur":97,"imax":false,"snum":93,"cat":"喜剧","wish":107,"3d":false,"pn":3,"preSale":0,"vd":"","dir":"阿甘","star":"郭涛,刘心悠,李灿森","src":"","scm":"姚晨王宝强，爆笑太疯狂","showDate":"","time":"","id":536},{"showInfo":"今天暂无场次","cnms":0,"late":false,"sn":0,"nm":"Hold住爱","img":"http://p0.meituan.net/165.220/movie/29/274730.jpg","sc":5.9,"ver":"2D","rt":"2012-08-23上映","dur":95,"imax":false,"snum":754,"cat":"喜剧,爱情,悬疑","wish":280,"3d":false,"pn":300,"preSale":0,"vd":"","dir":"张琦","star":"杨幂,刘恺威,周秀娜","src":"","scm":"假戏变真做，幂威秀爱火","showDate":"","time":"","id":729},{"showInfo":"今天暂无场次","cnms":0,"late":false,"sn":0,"nm":"厨子戏子痞子","img":"http://p0.meituan.net/165.220/movie/__7277442__6071578.jpg","sc":8.3,"ver":"2D","rt":"2013-03-29上映","dur":108,"imax":false,"snum":5760,"cat":"剧情,喜剧,动作","wish":10110,"3d":false,"pn":281,"preSale":0,"vd":"","dir":"管虎","star":"黄渤,刘烨,张涵予","src":"","scm":"三男一台戏，客栈解僵局","showDate":"","time":"","id":969},{"showInfo":"今天暂无场次","cnms":0,"late":false,"sn":0,"nm":"人间蒸发","img":"http://p0.meituan.net/165.220/movie/__6680785__5992311.jpg","sc":7,"ver":"2D","rt":"2013-04-28上映","dur":90,"imax":false,"snum":182,"cat":"悬疑,惊悚","wish":771,"3d":false,"pn":22,"preSale":0,"vd":"","dir":"梁德森","star":"钟丽缇,柳岩,李灿森","src":"","scm":"惊心动魄的寻亲之旅","showDate":"","time":"","id":78094},{"showInfo":"今天暂无场次","cnms":0,"late":false,"sn":0,"nm":"京城81号","img":"http://p1.meituan.net/165.220/movie/__48584093__3431812.jpg","sc":5,"ver":"2D/3D","rt":"2014-07-18上映","dur":90,"imax":false,"snum":122355,"cat":"剧情,悬疑,恐怖","wish":36817,"3d":true,"pn":98,"preSale":0,"vd":"","dir":"叶伟民","star":"吴镇宇,林心如,杨祐宁","src":"","scm":"古宅阴森处，少妇诉凄苦","showDate":"","time":"","id":78267},{"showInfo":"今天暂无场次","cnms":0,"late":false,"sn":0,"nm":"左耳","img":"http://p0.meituan.net/165.220/movie/da55f29972ec0b9692ba7055905892c8123092.jpg","sc":7.9,"ver":"2D","rt":"2015-04-24上映","dur":117,"imax":false,"snum":538075,"cat":"爱情","wish":82116,"3d":false,"pn":315,"preSale":0,"vd":"","dir":"苏有朋","star":"陈都灵,欧豪,杨洋","src":"","scm":"青春要恋爱，别忘堕堕胎","showDate":"","time":"","id":246210},{"showInfo":"今天暂无场次","cnms":0,"late":false,"sn":0,"nm":"美人鱼之海盗来袭","img":"http://p0.meituan.net/165.220/movie/7e15953aa8bc5be4e7bff00913426a06920765.jpg","sc":5.5,"ver":"2D","rt":"2015-07-31上映","dur":85,"imax":false,"snum":21958,"cat":"动画,喜剧,冒险","wish":27716,"3d":false,"pn":38,"preSale":0,"vd":"","dir":"邱浩强","star":"李思娴,郭亚维,宋磊","src":"","scm":"国产美人鱼，俩海盗来袭","showDate":"","time":"","id":248550},{"showInfo":"今天暂无场次","cnms":0,"late":false,"sn":0,"nm":"陪安东尼度过漫长岁月","img":"http://p1.meituan.net/165.220/movie/9f0d994eafbf52e7b0145b7746d1d881246635.jpg","sc":7.8,"ver":"2D","rt":"2015-11-13上映","dur":121,"imax":false,"snum":78381,"cat":"剧情,爱情","wish":120703,"3d":false,"pn":564,"preSale":0,"vd":"","dir":"秦小珍","star":"刘畅,白百何,唐艺昕","src":"","scm":"文艺大暖男，不二常相伴","showDate":"","time":"","id":246583},{"showInfo":"今天暂无场次","cnms":0,"late":false,"sn":0,"nm":"大唐玄奘","img":"http://p0.meituan.net/165.220/movie/c1cbba6359ef62bbb5bdd5311708c828413080.jpg","sc":7.7,"ver":"2D/中国巨幕","rt":"2016-04-29上映","dur":120,"imax":false,"snum":28440,"cat":"剧情,历史","wish":23799,"3d":false,"pn":232,"preSale":0,"vd":"","dir":"霍建起","star":"黄晓明,蒲巴甲,徐峥","src":"","scm":"了却世间恨，尽是取经人","showDate":"","time":"","id":338357},{"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"sn":0,"nm":"记忆碎片","img":"http://p1.meituan.net/165.220/movie/ea15948d63d527d092a70e39cbb74636357253.jpg","sc":6.9,"ver":"2D","rt":"2016-06-03上映","dur":94,"imax":false,"snum":2966,"cat":"悬疑,喜剧,犯罪","wish":4154,"3d":false,"pn":47,"preSale":0,"vd":"","dir":"朴裕焕","star":"雷佳音,夏梓桐,李菁","src":"","scm":"宿醉陷疑案，奋力查嫌犯","showDate":"","time":"","id":345923}]}
     */

    private int status;
    /**
     * hasNext : false
     * movies : [{"showInfo":"今天151家影院放映2004场","cnms":0,"late":false,"sn":0,"nm":"惊天魔盗团2","img":"http://p1.meituan.net/165.220/movie/2e0b5b5c6c086cc93068fbc212f9f6b0142193.jpg","sc":8.7,"ver":"2D/3D/中国巨幕","rt":"本周五上映","dur":126,"imax":false,"snum":36625,"cat":"动作,喜剧,惊悚","wish":513937,"3d":true,"pn":244,"preSale":0,"vd":"","dir":"朱浩伟","star":"杰西·艾森伯格,马克·鲁法洛,伍迪·哈里森","src":"","scm":"周董变魔术，敌人挡不住","showDate":"","time":"","id":246333},{"showInfo":"今天152家影院放映1828场","cnms":0,"late":false,"sn":0,"nm":"独立日：卷土重来","img":"http://p1.meituan.net/165.220/movie/b408a9322cd0da51d4bdd3261ba3d1c0278866.jpg","sc":8.5,"ver":"3D/IMAX 3D/中国巨幕/全景声","rt":"本周五上映","dur":120,"imax":true,"snum":31935,"cat":"动作,冒险,科幻","wish":164747,"3d":true,"pn":226,"preSale":0,"vd":"","dir":"罗兰·艾默里奇","star":"利亚姆·海姆斯沃斯,杰夫·高布伦,杰西·厄舍","src":"","scm":"外星再入侵，地核将燃尽","showDate":"","time":"","id":246375},{"showInfo":"今天146家影院放映919场","cnms":0,"late":false,"sn":0,"nm":"三人行","img":"http://p1.meituan.net/165.220/movie/1c82df174422d9374f821482f445171b129671.jpg","sc":7.2,"ver":"2D","rt":"本周五上映","dur":88,"imax":false,"snum":17583,"cat":"动作,犯罪,悬疑","wish":72910,"3d":false,"pn":186,"preSale":0,"vd":"","dir":"杜琪峰","star":"赵薇,古天乐,钟汉良","src":"","scm":"悍匪有手段，中枪再作案","showDate":"","time":"","id":246972},{"showInfo":"今天145家影院放映682场","cnms":0,"late":false,"sn":0,"nm":"海底总动员2：多莉去哪儿","img":"http://p0.meituan.net/165.220/movie/4c20a91505854dcd0f9617069c5fec21843230.jpg","sc":8.7,"ver":"2D/3D/IMAX 3D/中国巨幕","rt":"2016-06-17上映","dur":97,"imax":true,"snum":59982,"cat":"动画,喜剧,冒险","wish":144949,"3d":true,"pn":123,"preSale":0,"vd":"","dir":"安德鲁·斯坦顿,安格斯·麦克莱恩","star":"艾伦·德詹尼丝,徐帆,艾伯特·布鲁克斯","src":"","scm":"唠叨鱼多莉，上路找父母","showDate":"","time":"","id":246366},{"showInfo":"今天120家影院放映403场","cnms":0,"late":false,"sn":0,"nm":"魔兽","img":"http://p0.meituan.net/165.220/movie/f94e67dcd5b48f034bd7adc892f1b20695854.jpeg","sc":9.2,"ver":"2D/3D/IMAX 3D/中国巨幕/全景声","rt":"2016-06-08上映","dur":124,"imax":true,"snum":720189,"cat":"动作,冒险,奇幻","wish":479894,"3d":true,"pn":347,"preSale":0,"vd":"","dir":"邓肯·琼斯","star":"崔维斯·费米尔,宝拉·巴顿,本·福斯特","src":"","scm":"怒拳为谁握，联盟斗部落","showDate":"","time":"","id":78421},{"showInfo":"2016-07-08上映","cnms":0,"late":false,"sn":0,"nm":"致青春·原来你还在这里","img":"http://p0.meituan.net/165.220/movie/37e7ed909843270f0880c325b6be7b60436509.jpg","sc":0,"ver":"2D","rt":"2016-07-08上映","dur":98,"imax":false,"snum":4201,"cat":"剧情,爱情","wish":198876,"3d":false,"pn":333,"preSale":1,"vd":"","dir":"周拓如","star":"吴亦凡,刘亦菲,金世佳","src":"","scm":"霸道男学霸，爱上女学渣","showDate":"","time":"","id":246575},{"showInfo":"2016-07-02 下周六上映","cnms":0,"late":false,"sn":0,"nm":"忍者神龟2：破影而出","img":"http://p1.meituan.net/165.220/movie/a375ebfcdc2a396423c368b943813b01179997.jpg","sc":0,"ver":"2D/3D/IMAX 3D/中国巨幕","rt":"下周六上映","dur":113,"imax":true,"snum":1442,"cat":"动作,冒险,喜剧","wish":258637,"3d":true,"pn":249,"preSale":1,"vd":"","dir":"戴夫·格林","star":"梅根·福克斯,皮特·普劳泽克,阿伦·瑞奇森","src":"","scm":"儿时忍者龟，犀牛也回归","showDate":"","time":"","id":13511},{"showInfo":"2016-06-30 下周四上映","cnms":0,"late":false,"sn":0,"nm":"所以\u2026\u2026和黑粉结婚了","img":"http://p1.meituan.net/165.220/movie/79311d41bea3be8f1677c0b69a5868fa289298.jpg","sc":0,"ver":"2D","rt":"下周四上映","dur":99,"imax":false,"snum":6851,"cat":"爱情,喜剧","wish":88614,"3d":false,"pn":121,"preSale":1,"vd":"","dir":"金帝荣","star":"朴灿烈,袁姗姗,姜潮","src":"","scm":"黑粉变新娘，这是闹哪样","showDate":"","time":"","id":343379},{"showInfo":"今天60家影院放映108场","cnms":0,"late":false,"sn":0,"nm":"X战警：天启","img":"http://p1.meituan.net/165.220/movie/ba2386a26648c1875e3fc780950f0ae0144875.jpg","sc":9.1,"ver":"3D/IMAX 3D/中国巨幕/全景声","rt":"2016-06-03上映","dur":144,"imax":true,"snum":444615,"cat":"动作,科幻,奇幻","wish":559919,"3d":true,"pn":692,"preSale":0,"vd":"","dir":"布莱恩·辛格","star":"詹姆斯·麦卡沃伊,迈克尔·法斯宾德,詹妮弗·劳伦斯","src":"","scm":"天启当炮灰，千年洗剪吹","showDate":"","time":"","id":246177},{"showInfo":"今天47家影院放映86场","cnms":0,"late":false,"sn":0,"nm":"近在咫尺的爱恋","img":"http://p1.meituan.net/165.220/movie/a70da0aefb82886efbae696181e966ff620085.jpg","sc":7.5,"ver":"2D","rt":"本周五上映","dur":103,"imax":false,"snum":376,"cat":"爱情,运动,剧情","wish":12564,"3d":false,"pn":49,"preSale":0,"vd":"","dir":"程孝泽","star":"彭于晏,郭采洁,杨子姗","src":"","scm":"真爱在身旁，挥拳为理想","showDate":"","time":"","id":57217},{"showInfo":"2016-07-01 下周五上映","cnms":0,"late":false,"sn":0,"nm":"赏金猎人","img":"http://p1.meituan.net/165.220/movie/45f8587cb425a01c9a279082772a8bd0379497.jpg","sc":0,"ver":"2D/3D","rt":"下周五上映","dur":105,"imax":false,"snum":4126,"cat":"动作,喜剧,剧情,悬疑","wish":121263,"3d":true,"pn":196,"preSale":1,"vd":"","dir":"申太罗","star":"李敏镐,钟汉良,唐嫣","src":"","scm":"编外铁饭碗，收钱抓逃犯","showDate":"","time":"","id":338506},{"showInfo":"2016-07-01 下周五上映","cnms":0,"late":false,"sn":0,"nm":"魔轮","img":"http://p0.meituan.net/165.220/movie/1d44cc6185a7ee4ee1def1f3a0f5821a584683.jpg","sc":0,"ver":"2D/3D","rt":"下周五上映","dur":92,"imax":false,"snum":431,"cat":"悬疑,惊悚,恐怖","wish":8537,"3d":true,"pn":49,"preSale":1,"vd":"","dir":"王早","star":"林心如,何润东,金世佳","src":"","scm":"天涯号起航，失控大逃亡","showDate":"","time":"","id":342741},{"showInfo":"今天18家影院放映20场","cnms":0,"late":false,"sn":0,"nm":"筷仙","img":"http://p1.meituan.net/165.220/movie/31a325f0796cfebbab24776024eeec91100800.jpeg","sc":4.4,"ver":"2D","rt":"2016-06-17上映","dur":87,"imax":false,"snum":12105,"cat":"恐怖,惊悚","wish":20373,"3d":false,"pn":32,"preSale":0,"vd":"","dir":"姬雨","star":"胡影怡,朱璇,周骏","src":"","scm":"笔仙已玩坏，筷仙来作怪","showDate":"","time":"","id":343597},{"showInfo":"2016-07-02 下周六上映","cnms":0,"late":false,"sn":0,"nm":"丑小鸭历险记","img":"http://p1.meituan.net/165.220/movie/0484f8ad5aec878112f1a04715d32b4e360620.jpg","sc":0,"ver":"2D","rt":"下周六上映","dur":81,"imax":false,"snum":85,"cat":"动画,科幻,冒险","wish":2848,"3d":false,"pn":66,"preSale":1,"vd":"","dir":"郑义","star":"朱可可,阿飞,夏倚轩","src":"","scm":"月球机器鸭，化身小飞鸭","showDate":"","time":"","id":368271},{"showInfo":"今天10家影院放映11场","cnms":0,"late":false,"sn":0,"nm":"百鸟朝凤","img":"http://p1.meituan.net/165.220/movie/ef968fd382173c45b0c2d10572ca10b8354896.jpg","sc":9.2,"ver":"2D","rt":"2016-05-06上映","dur":108,"imax":false,"snum":108966,"cat":"历史,音乐,剧情","wish":3981,"3d":false,"pn":105,"preSale":0,"vd":"","dir":"吴天明","star":"陶泽如,郑伟,李岷城","src":"","scm":"两代手艺人，唢呐感情深","showDate":"","time":"","id":248260},{"showInfo":"今天6家影院放映11场","cnms":0,"late":false,"sn":0,"nm":"爱丽丝梦游仙境2：镜中奇遇记","img":"http://p1.meituan.net/165.220/movie/dbcc3eabae012da794fe4b74ed1365fc659390.jpg","sc":8.6,"ver":"2D/3D/IMAX 3D/中国巨幕/全景声","rt":"2016-05-27上映","dur":115,"imax":true,"snum":224941,"cat":"奇幻,冒险,喜剧","wish":248677,"3d":true,"pn":82,"preSale":0,"vd":"","dir":"詹姆斯·波宾","star":"约翰尼·德普,安妮·海瑟薇,米娅·华希科沃斯卡","src":"","scm":"镜中再梦游，拯救老朋友","showDate":"","time":"","id":248680},{"showInfo":"今天10家影院放映10场","cnms":0,"late":false,"sn":0,"nm":"我叫MT之山口山战记","img":"http://p0.meituan.net/165.220/movie/73f6abbb90259d1fa8a88fa907ca3062587352.jpg","sc":7.6,"ver":"3D/中国巨幕","rt":"2016-06-17上映","dur":86,"imax":false,"snum":19160,"cat":"动画,喜剧,冒险","wish":43480,"3d":true,"pn":40,"preSale":0,"vd":"","dir":"核桃","star":"奶茶,YOYO,CBI","src":"","scm":"贱萌牛头人，爆笑刷副本","showDate":"","time":"","id":246045},{"showInfo":"2016-06-27 下周一上映","cnms":0,"late":false,"sn":0,"nm":"大火种","img":"http://p1.meituan.net/165.220/movie/c8545c7bd1f6070f0d52a77bd0ddd8738720802.jpg","sc":0,"ver":"2D","rt":"下周一上映","dur":114,"imax":false,"snum":30,"cat":"剧情,历史,战争","wish":340,"3d":false,"pn":4,"preSale":1,"vd":"","dir":"苗月","star":"白威,陈瑾,王柠","src":"","scm":"誓死护宣言，智斗救火种","showDate":"","time":"","id":337438},{"showInfo":"今天6家影院放映6场","cnms":0,"late":false,"sn":0,"nm":"北京遇上西雅图之不二情书","img":"http://p1.meituan.net/165.220/movie/fe80bc40822d0a5f3168b73089c47d71101133.jpg","sc":8.5,"ver":"2D/中国巨幕","rt":"2016-04-29上映","dur":132,"imax":false,"snum":445400,"cat":"爱情,剧情","wish":307383,"3d":false,"pn":547,"preSale":0,"vd":"","dir":"薛晓路","star":"汤唯,吴秀波,惠英红","src":"","scm":"异国心未远，书信寄情缘","showDate":"","time":"","id":247575},{"showInfo":"今天4家影院放映6场","cnms":0,"late":false,"sn":0,"nm":"南口1937","img":"http://p1.meituan.net/165.220/movie/f4b5d903571ec3c3fc952f86261b04fd227842.jpg","sc":0,"ver":"2D","rt":"本周四上映","dur":98,"imax":false,"snum":105,"cat":"剧情,历史,战争","wish":2034,"3d":false,"pn":26,"preSale":0,"vd":"","dir":"朱丹","star":"孙看,孙洪涛,刘忠元","src":"","scm":"南口抗日战，疆场洒血汗","showDate":"","time":"","id":368071},{"showInfo":"今天5家影院放映5场","cnms":0,"late":false,"sn":0,"nm":"愤怒的小鸟","img":"http://p0.meituan.net/165.220/movie/b721e73740601799c065affb619d837e151622.jpg","sc":8.9,"ver":"3D/中国巨幕","rt":"2016-05-20上映","dur":97,"imax":false,"snum":319381,"cat":"动画,奇幻,冒险","wish":123045,"3d":true,"pn":132,"preSale":0,"vd":"","dir":"费格尔·雷利,克莱·凯蒂","star":"杰森·苏戴奇斯,乔什·盖德,丹尼·麦克布耐德","src":"","scm":"绿猪来偷蛋，鸟儿群奋战","showDate":"","time":"","id":246188},{"showInfo":"今天3家影院放映3场","cnms":0,"late":false,"sn":0,"nm":"叶问2：宗师传奇","img":"http://p0.meituan.net/165.220/movie/70/612717.jpg","sc":8.5,"ver":"2D","rt":"2010-04-27上映","dur":108,"imax":false,"snum":1031,"cat":"动作,历史,传记","wish":211,"3d":false,"pn":63,"preSale":0,"vd":"","dir":"叶伟信","star":"甄子丹,洪金宝,熊黛林","src":"","scm":"叶问搬香港，仇恨值渐长","showDate":"","time":"","id":524},{"showInfo":"2016-07-01 下周五上映","cnms":0,"late":false,"sn":0,"nm":"党的女儿尹灵芝","img":"http://p0.meituan.net/165.220/movie/1dffa0a076e3514234f2029d6b29b3da157605.jpg","sc":0,"ver":"2D","rt":"下周五上映","dur":107,"imax":false,"snum":135,"cat":"剧情,历史","wish":618,"3d":false,"pn":17,"preSale":1,"vd":"","dir":"卫晓茼","star":"郜耀平,张志宏,姚安濂","src":"","scm":"心中有信仰，少年变战士","showDate":"","time":"","id":672123},{"showInfo":"今天2家影院放映2场","cnms":0,"late":false,"sn":0,"nm":"人再囧途之泰囧","img":"http://p0.meituan.net/165.220/movie/38/280521.jpg","sc":8.8,"ver":"2D","rt":"2012-12-12上映","dur":105,"imax":false,"snum":15633,"cat":"喜剧","wish":22543,"3d":false,"pn":232,"preSale":0,"vd":"","dir":"徐峥","star":"徐峥,王宝强,黄渤","src":"","scm":"囧途太荒唐，甩不掉宝强","showDate":"","time":"","id":938},{"showInfo":"今天2家影院放映2场","cnms":0,"late":false,"sn":0,"nm":"同桌的你","img":"http://p0.meituan.net/165.220/movie/__40811615__5745234.jpg","sc":8.6,"ver":"2D","rt":"2014-04-25上映","dur":98,"imax":false,"snum":73036,"cat":"剧情,爱情","wish":24267,"3d":false,"pn":88,"preSale":0,"vd":"","dir":"郭帆","star":"周冬雨,林更新,隋凯","src":"","scm":"初恋要结婚，回国忆青春","showDate":"","time":"","id":78653},{"showInfo":"今天2家影院放映2场","cnms":0,"late":false,"sn":0,"nm":"死亡游戏","img":"http://p1.meituan.net/165.220/movie/c3eec836300c5a9f0429d96921aa168472038.jpg","sc":5.8,"ver":"2D","rt":"2016-06-03上映","dur":90,"imax":false,"snum":5373,"cat":"恐怖,惊悚,悬疑","wish":3301,"3d":false,"pn":145,"preSale":0,"vd":"","dir":"麦子","star":"徐洁儿,陈欢,陈炳强","src":"","scm":"同学生日会，恶鬼来相会","showDate":"","time":"","id":346286},{"showInfo":"2016-07-01 下周五上映","cnms":0,"late":false,"sn":0,"nm":"终极胜利","img":"http://p1.meituan.net/165.220/movie/0c93b5987ae440497dd985982aad1c4b233221.jpg","sc":0,"ver":"2D","rt":"下周五上映","dur":108,"imax":false,"snum":65,"cat":"剧情,战争,历史","wish":4798,"3d":false,"pn":122,"preSale":1,"vd":"","dir":"冼杞然","star":"窦骁,约瑟夫·费因斯,娄宇健","src":"","scm":"辛德勒名单，推出中国版","showDate":"","time":"","id":341123},{"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"sn":0,"nm":"宫锁沉香","img":"http://p0.meituan.net/165.220/movie/__18327195__7709930.jpg","sc":7.8,"ver":"2D","rt":"2013-08-13上映","dur":115,"imax":false,"snum":2509,"cat":"剧情,爱情,古装","wish":3080,"3d":false,"pn":36,"preSale":0,"vd":"","dir":"潘安子","star":"周冬雨,陈晓,赵丽颖","src":"","scm":"唯美清宫戏，阴谋不见底","showDate":"","time":"","id":78176},{"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"sn":0,"nm":"有人赞美聪慧,有人则不","img":"http://p0.meituan.net/165.220/movie/__16523889__6590864.jpg","sc":7.8,"ver":"2D","rt":"2013-11待定","dur":108,"imax":false,"snum":54,"cat":"动画,家庭","wish":184,"3d":false,"pn":98,"preSale":0,"vd":"","dir":"杨瑾","star":"李书晨,王琛,卫永绍","src":"","scm":"离家偷玩耍，乡下过暑假","showDate":"","time":"2013-11","id":78224},{"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"sn":0,"nm":"警察故事2013","img":"http://p0.meituan.net/165.220/movie/__29561506__7176229.jpg","sc":8,"ver":"2D/IMAX 3D","rt":"2013-12-24上映","dur":108,"imax":true,"snum":19131,"cat":"剧情,动作,犯罪","wish":14520,"3d":true,"pn":44,"preSale":0,"vd":"","dir":"丁晟","star":"刘烨,成龙,景甜","src":"","scm":"女儿乱交友，老爹来出头","showDate":"","time":"","id":77192},{"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"sn":0,"nm":"北京爱情故事","img":"http://p0.meituan.net/165.220/movie/__33456063__6265360.jpg","sc":8,"ver":"2D","rt":"2014-02-14上映","dur":121,"imax":false,"snum":28683,"cat":"爱情","wish":12286,"3d":false,"pn":145,"preSale":0,"vd":"","dir":"陈思诚","star":"梁家辉,刘嘉玲,王学兵","src":"","scm":"恋爱分五段，激情不会散","showDate":"","time":"","id":78324},{"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"sn":0,"nm":"催眠大师","img":"http://p1.meituan.net/165.220/movie/__39582689__9041214.jpg","sc":9,"ver":"2D","rt":"2014-04-29上映","dur":102,"imax":false,"snum":46535,"cat":"剧情,悬疑,惊悚","wish":11396,"3d":false,"pn":78,"preSale":0,"vd":"","dir":"陈正道","star":"徐峥,莫文蔚,吕中","src":"","scm":"催眠治心伤，侧击猜真相","showDate":"","time":"","id":78672},{"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"sn":0,"nm":"闺蜜","img":"http://p1.meituan.net/165.220/movie/__48665963__9098444.jpg","sc":8,"ver":"2D","rt":"2014-07-30上映","dur":118,"imax":false,"snum":68741,"cat":"剧情,爱情","wish":30224,"3d":false,"pn":203,"preSale":0,"vd":"","dir":"黄真真","star":"陈意涵,薛凯琪,杨子姗","src":"","scm":"永远好闺蜜，渣男靠边去","showDate":"","time":"","id":78772},{"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"sn":0,"nm":"十万个冷笑话","img":"http://p1.meituan.net/165.220/movie/56cb96b2c6df95b66db4ce719993d5d0666565.jpg","sc":8.2,"ver":"2D","rt":"2014-12-31上映","dur":100,"imax":false,"snum":122608,"cat":"动画,喜剧,奇幻","wish":25775,"3d":false,"pn":79,"preSale":0,"vd":"","dir":"卢恒宇,李姝洁","star":"张杰,皇贞季,宝木中阳","src":"","scm":"男主有点拽，二次元崩坏","showDate":"","time":"","id":246067},{"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"sn":0,"nm":"奔跑吧！兄弟","img":"http://p0.meituan.net/165.220/movie/85f0d9a604e26be5523a848269346697296774.jpg","sc":4.7,"ver":"2D","rt":"2015-01-30上映","dur":88,"imax":false,"snum":361085,"cat":"喜剧,冒险,动作","wish":49025,"3d":false,"pn":118,"preSale":0,"vd":"","dir":"胡笳,岑俊义","star":"杨颖,王宝强,李晨","src":"","scm":"跑男再出发，集体游三亚","showDate":"","time":"","id":246316},{"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"sn":0,"nm":"横冲直撞好莱坞","img":"http://p1.meituan.net/165.220/movie/1c06c9055cb3990e76ee93c2c70789bb145247.jpg","sc":7.7,"ver":"2D/中国巨幕","rt":"2015-06-26上映","dur":119,"imax":false,"snum":282776,"cat":"喜剧,动作,冒险","wish":64522,"3d":false,"pn":273,"preSale":0,"vd":"","dir":"蒂姆·肯德尔","star":"赵薇,黄晓明,佟大为","src":"","scm":"逗比好基友，遇到坏导游","showDate":"","time":"","id":246178},{"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"sn":0,"nm":"通灵之六世古宅","img":"http://p1.meituan.net/165.220/movie/575f1cee324dd206d981b4dfcb1ec1bd1381691.jpg","sc":4.5,"ver":"2D/3D/中国巨幕","rt":"2015-07-24上映","dur":87,"imax":false,"snum":20074,"cat":"惊悚,恐怖","wish":34072,"3d":true,"pn":101,"preSale":0,"vd":"","dir":"彭发","star":"徐娇,张兆辉,毕秀茹","src":"","scm":"古宅心慌慌，通灵少女忙","showDate":"","time":"","id":246249},{"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"sn":0,"nm":"既然青春留不住","img":"http://p0.meituan.net/165.220/movie/90422e83536df2153ecc57ff9703e99c1111187.jpg","sc":8.2,"ver":"2D","rt":"2015-10-23上映","dur":92,"imax":false,"snum":83838,"cat":"喜剧,爱情","wish":78433,"3d":false,"pn":172,"preSale":0,"vd":"","dir":"田蒙","star":"张翰,陈乔恩,施予斐","src":"","scm":"校草撞菠菜，青春已不再","showDate":"","time":"","id":246540},{"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"sn":0,"nm":"我的诗篇","img":"http://p1.meituan.net/165.220/movie/a93a7b21b94073e778d30962a409cb02172463.jpg","sc":0,"ver":"2D","rt":"2015-11-01上映","dur":110,"imax":false,"snum":123,"cat":"纪录片","wish":631,"3d":false,"pn":19,"preSale":0,"vd":"","dir":"吴飞跃,秦晓宇","star":"乌鸟鸟,陈年喜,老井","src":"","scm":"生产线诗歌，朴素却深刻","showDate":"","time":"","id":341084},{"showInfo":"今天暂无场次","cnms":0,"late":false,"sn":0,"nm":"大电影2.0之两个傻瓜的荒唐事","img":"http://p1.meituan.net/165.220/movie/76ac89dad45ac25c676246dc92794b03318660.png","sc":5.6,"ver":"2D","rt":"2007-12-21上映","dur":97,"imax":false,"snum":93,"cat":"喜剧","wish":107,"3d":false,"pn":3,"preSale":0,"vd":"","dir":"阿甘","star":"郭涛,刘心悠,李灿森","src":"","scm":"姚晨王宝强，爆笑太疯狂","showDate":"","time":"","id":536},{"showInfo":"今天暂无场次","cnms":0,"late":false,"sn":0,"nm":"Hold住爱","img":"http://p0.meituan.net/165.220/movie/29/274730.jpg","sc":5.9,"ver":"2D","rt":"2012-08-23上映","dur":95,"imax":false,"snum":754,"cat":"喜剧,爱情,悬疑","wish":280,"3d":false,"pn":300,"preSale":0,"vd":"","dir":"张琦","star":"杨幂,刘恺威,周秀娜","src":"","scm":"假戏变真做，幂威秀爱火","showDate":"","time":"","id":729},{"showInfo":"今天暂无场次","cnms":0,"late":false,"sn":0,"nm":"厨子戏子痞子","img":"http://p0.meituan.net/165.220/movie/__7277442__6071578.jpg","sc":8.3,"ver":"2D","rt":"2013-03-29上映","dur":108,"imax":false,"snum":5760,"cat":"剧情,喜剧,动作","wish":10110,"3d":false,"pn":281,"preSale":0,"vd":"","dir":"管虎","star":"黄渤,刘烨,张涵予","src":"","scm":"三男一台戏，客栈解僵局","showDate":"","time":"","id":969},{"showInfo":"今天暂无场次","cnms":0,"late":false,"sn":0,"nm":"人间蒸发","img":"http://p0.meituan.net/165.220/movie/__6680785__5992311.jpg","sc":7,"ver":"2D","rt":"2013-04-28上映","dur":90,"imax":false,"snum":182,"cat":"悬疑,惊悚","wish":771,"3d":false,"pn":22,"preSale":0,"vd":"","dir":"梁德森","star":"钟丽缇,柳岩,李灿森","src":"","scm":"惊心动魄的寻亲之旅","showDate":"","time":"","id":78094},{"showInfo":"今天暂无场次","cnms":0,"late":false,"sn":0,"nm":"京城81号","img":"http://p1.meituan.net/165.220/movie/__48584093__3431812.jpg","sc":5,"ver":"2D/3D","rt":"2014-07-18上映","dur":90,"imax":false,"snum":122355,"cat":"剧情,悬疑,恐怖","wish":36817,"3d":true,"pn":98,"preSale":0,"vd":"","dir":"叶伟民","star":"吴镇宇,林心如,杨祐宁","src":"","scm":"古宅阴森处，少妇诉凄苦","showDate":"","time":"","id":78267},{"showInfo":"今天暂无场次","cnms":0,"late":false,"sn":0,"nm":"左耳","img":"http://p0.meituan.net/165.220/movie/da55f29972ec0b9692ba7055905892c8123092.jpg","sc":7.9,"ver":"2D","rt":"2015-04-24上映","dur":117,"imax":false,"snum":538075,"cat":"爱情","wish":82116,"3d":false,"pn":315,"preSale":0,"vd":"","dir":"苏有朋","star":"陈都灵,欧豪,杨洋","src":"","scm":"青春要恋爱，别忘堕堕胎","showDate":"","time":"","id":246210},{"showInfo":"今天暂无场次","cnms":0,"late":false,"sn":0,"nm":"美人鱼之海盗来袭","img":"http://p0.meituan.net/165.220/movie/7e15953aa8bc5be4e7bff00913426a06920765.jpg","sc":5.5,"ver":"2D","rt":"2015-07-31上映","dur":85,"imax":false,"snum":21958,"cat":"动画,喜剧,冒险","wish":27716,"3d":false,"pn":38,"preSale":0,"vd":"","dir":"邱浩强","star":"李思娴,郭亚维,宋磊","src":"","scm":"国产美人鱼，俩海盗来袭","showDate":"","time":"","id":248550},{"showInfo":"今天暂无场次","cnms":0,"late":false,"sn":0,"nm":"陪安东尼度过漫长岁月","img":"http://p1.meituan.net/165.220/movie/9f0d994eafbf52e7b0145b7746d1d881246635.jpg","sc":7.8,"ver":"2D","rt":"2015-11-13上映","dur":121,"imax":false,"snum":78381,"cat":"剧情,爱情","wish":120703,"3d":false,"pn":564,"preSale":0,"vd":"","dir":"秦小珍","star":"刘畅,白百何,唐艺昕","src":"","scm":"文艺大暖男，不二常相伴","showDate":"","time":"","id":246583},{"showInfo":"今天暂无场次","cnms":0,"late":false,"sn":0,"nm":"大唐玄奘","img":"http://p0.meituan.net/165.220/movie/c1cbba6359ef62bbb5bdd5311708c828413080.jpg","sc":7.7,"ver":"2D/中国巨幕","rt":"2016-04-29上映","dur":120,"imax":false,"snum":28440,"cat":"剧情,历史","wish":23799,"3d":false,"pn":232,"preSale":0,"vd":"","dir":"霍建起","star":"黄晓明,蒲巴甲,徐峥","src":"","scm":"了却世间恨，尽是取经人","showDate":"","time":"","id":338357},{"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"sn":0,"nm":"记忆碎片","img":"http://p1.meituan.net/165.220/movie/ea15948d63d527d092a70e39cbb74636357253.jpg","sc":6.9,"ver":"2D","rt":"2016-06-03上映","dur":94,"imax":false,"snum":2966,"cat":"悬疑,喜剧,犯罪","wish":4154,"3d":false,"pn":47,"preSale":0,"vd":"","dir":"朴裕焕","star":"雷佳音,夏梓桐,李菁","src":"","scm":"宿醉陷疑案，奋力查嫌犯","showDate":"","time":"","id":345923}]
     */

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
        private boolean hasNext;
        /**
         * showInfo : 今天151家影院放映2004场
         * cnms : 0
         * late : false
         * sn : 0
         * nm : 惊天魔盗团2
         * img : http://p1.meituan.net/165.220/movie/2e0b5b5c6c086cc93068fbc212f9f6b0142193.jpg
         * sc : 8.7
         * ver : 2D/3D/中国巨幕
         * rt : 本周五上映
         * dur : 126
         * imax : false
         * snum : 36625
         * cat : 动作,喜剧,惊悚
         * wish : 513937
         * 3d : true
         * pn : 244
         * preSale : 0
         * vd :
         * dir : 朱浩伟
         * star : 杰西·艾森伯格,马克·鲁法洛,伍迪·哈里森
         * src :
         * scm : 周董变魔术，敌人挡不住
         * showDate :
         * time :
         * id : 246333
         */

        private List<MoviesBean> movies;

        public boolean isHasNext() {
            return hasNext;
        }

        public void setHasNext(boolean hasNext) {
            this.hasNext = hasNext;
        }

        public List<MoviesBean> getMovies() {
            return movies;
        }

        public void setMovies(List<MoviesBean> movies) {
            this.movies = movies;
        }

        public static class MoviesBean {
            private String showInfo;
            private int cnms;
            private boolean late;
            private int sn;
            private String nm;
            private String img;
            private double sc;
            private String ver;
            private String rt;
            private int dur;
            private boolean imax;
            private int snum;
            private String cat;
            private int wish;
            @com.google.gson.annotations.SerializedName("3d")
            private boolean value3d;
            private int pn;
            private int preSale;
            private String vd;
            private String dir;
            private String star;
            private String src;
            private String scm;
            private String showDate;
            private String time;
            private int id;

            public String getShowInfo() {
                return showInfo;
            }

            public void setShowInfo(String showInfo) {
                this.showInfo = showInfo;
            }

            public int getCnms() {
                return cnms;
            }

            public void setCnms(int cnms) {
                this.cnms = cnms;
            }

            public boolean isLate() {
                return late;
            }

            public void setLate(boolean late) {
                this.late = late;
            }

            public int getSn() {
                return sn;
            }

            public void setSn(int sn) {
                this.sn = sn;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public double getSc() {
                return sc;
            }

            public void setSc(double sc) {
                this.sc = sc;
            }

            public String getVer() {
                return ver;
            }

            public void setVer(String ver) {
                this.ver = ver;
            }

            public String getRt() {
                return rt;
            }

            public void setRt(String rt) {
                this.rt = rt;
            }

            public int getDur() {
                return dur;
            }

            public void setDur(int dur) {
                this.dur = dur;
            }

            public boolean isImax() {
                return imax;
            }

            public void setImax(boolean imax) {
                this.imax = imax;
            }

            public int getSnum() {
                return snum;
            }

            public void setSnum(int snum) {
                this.snum = snum;
            }

            public String getCat() {
                return cat;
            }

            public void setCat(String cat) {
                this.cat = cat;
            }

            public int getWish() {
                return wish;
            }

            public void setWish(int wish) {
                this.wish = wish;
            }

            public boolean isValue3d() {
                return value3d;
            }

            public void setValue3d(boolean value3d) {
                this.value3d = value3d;
            }

            public int getPn() {
                return pn;
            }

            public void setPn(int pn) {
                this.pn = pn;
            }

            public int getPreSale() {
                return preSale;
            }

            public void setPreSale(int preSale) {
                this.preSale = preSale;
            }

            public String getVd() {
                return vd;
            }

            public void setVd(String vd) {
                this.vd = vd;
            }

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public String getStar() {
                return star;
            }

            public void setStar(String star) {
                this.star = star;
            }

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public String getScm() {
                return scm;
            }

            public void setScm(String scm) {
                this.scm = scm;
            }

            public String getShowDate() {
                return showDate;
            }

            public void setShowDate(String showDate) {
                this.showDate = showDate;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
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
