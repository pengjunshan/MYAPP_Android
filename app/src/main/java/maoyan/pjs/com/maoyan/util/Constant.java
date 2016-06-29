package maoyan.pjs.com.maoyan.util;

/**
 * Created by pjs984312808 on 2016/6/23.
 */
public class Constant {

    //引导页面
    public static String GuideUrl="http://api.meituan.com/dianying/posters.json?city_id=1&poster_type=1&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=hiapk&utm_medium=android&utm_term=6.8.0&utm_content=860311023305964&ci=1&net=255&dModel=MI%203&uuid=F096369352E4004DD3758BF83FE24AC312445F9B51AD3D8FCE2A0CD57754F6E4&lat=0.0&lng=0.0&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463656383990&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=09cbe8d3-3cb0-4e54-bc41-8f0b3387cdf2&__skcy=RbOZVh%2BK%2Bf86K3WlGJYg4ls7DIU%3D";

    //热映界面-ViewPager
    public static String FireVPUrl="http://advert.mobile.meituan.com/api/v3/adverts?cityid=1&category=11&version=6.8.0&new=0&app=movie&clienttp=android&uuid=FCFAB9D8DD339645D629C8372A29A2C6AD16F9C9E87AF9AC0D656B29DD5AC6DE&devid=866641027400542&uid=&movieid=&partner=1&apptype=1&smId=&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=qq&utm_medium=android&utm_term=6.8.0&utm_content=866641027400542&ci=1&net=255&dModel=HM%20NOTE%201LTETD&lat=40.100855&lng=116.378273&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463730432992&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=01f9c5c0-eb56-4e19-92fb-b86b16ad79da&__skcy=5K8wRR%2FKYAZDTgmAzbhrXi%2FomzU%3D";

    //热映界面list
    public static String FireListUrl="http://api.meituan.com/mmdb/movie/v3/list/hot.json?ci=1&limit=12&token=khqtetvUORxgrW0qNK8CwQSM0A4AAAAAYAIAADDnHoQR8o9sEPycPV7_k2R8lC7ClkidRlDZ6kvQ4pBrFeBMV-e7Cen9-NP-33PtIA&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD100&movieBundleVersion=6901&utm_source=baidumobile1&utm_medium=android&utm_term=6.9.0&utm_content=869402021153646&net=255&dModel=m1%20metal&uuid=28C0DE2C5A3F109C808BE007F1011AE88795D9EFF3B99C9B3601DCF7840739F9&lat=0.0&lng=0.0&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1466919017564&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=1821587c-057d-477b-a36c-69837c2874b6&__skcy=a37Ln0qItaxew3QND9GY4MfQzg8%3D";
    //待映界面下部list数据
    public static String WaitListUrl="http://api.meituan.com/mmdb/movie/v2/list/rt/order/coming.json?ci=1&limit=12&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=xiaomi&utm_medium=android&utm_term=6.8.0&utm_content=868030022327462&net=255&dModel=MI%205&uuid=0894DE03C76F6045D55977B6D4E32B7F3C6AAB02F9CEA042987B380EC5687C43&lat=40.100673&lng=116.378619&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463704714271&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=1a0b4a9b-44ec-42fc-b110-ead68bcc2824&__skcy=sXcDKbGi20CGXQPPZvhCU3%2FkzdE%3D";

    //海外热映 国家名称
    public static String CountryUrl="http://api.meituan.com/mmdb/movie/oversea/areas.json?token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=xiaomi&utm_medium=android&utm_term=6.8.0&utm_content=868030022327462&ci=1&net=255&dModel=MI%205&uuid=0894DE03C76F6045D55977B6D4E32B7F3C6AAB02F9CEA042987B380EC5687C43&lat=40.100673&lng=116.378619&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463704930917&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=e3df01ab-d811-4ff8-868d-9b4a665ee352&__skcy=FZG8h%2Fw31ebpODD3EnjMbBAPTiE%3D";

    //海外热映 美国
    public static String USUrl="http://api.meituan.com/mmdb/movie/oversea/coming.json?area=NA&offset=0&limit=10&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=hiapk&utm_medium=android&utm_term=6.8.0&utm_content=860311023305964&ci=1&net=255&dModel=MI%203&uuid=F096369352E4004DD3758BF83FE24AC312445F9B51AD3D8FCE2A0CD57754F6E4&lat=40.099337&lng=116.379463&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463979002816&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=ff7d7258-bf35-49b1-8350-438616853e0b&__skcy=oNlmWR0dK8QqRyoPuJ9SQPBnvk0%3D";

    //海外热映 韩国
    public static String KRUrl="http://api.meituan.com/mmdb/movie/oversea/hot.json?area=KR&offset=0&limit=10&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=hiapk&utm_medium=android&utm_term=6.8.0&utm_content=860311023305964&ci=1&net=255&dModel=MI%203&uuid=F096369352E4004DD3758BF83FE24AC312445F9B51AD3D8FCE2A0CD57754F6E4&lat=40.099337&lng=116.379463&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463979233089&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=5245fc26-6931-4d8e-8202-4fa32944ea28&__skcy=IQYM%2F257Pcv7b%2FfH8U60gxAsVWg%3Dhttp://api.meituan.com/mmdb/movie/oversea/hot.json?area=KR&offset=0&limit=10&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=hiapk&utm_medium=android&utm_term=6.8.0&utm_content=860311023305964&ci=1&net=255&dModel=MI%203&uuid=F096369352E4004DD3758BF83FE24AC312445F9B51AD3D8FCE2A0CD57754F6E4&lat=40.099337&lng=116.379463&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463979233089&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=5245fc26-6931-4d8e-8202-4fa32944ea28&__skcy=IQYM%2F257Pcv7b%2FfH8U60gxAsVWg%3D";

    //海外热映 日本
    public static String JPUrl="http://api.meituan.com/mmdb/movie/oversea/hot.json?area=JP&offset=10&limit=10&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=hiapk&utm_medium=android&utm_term=6.8.0&utm_content=860311023305964&ci=1&net=255&dModel=MI%203&uuid=F096369352E4004DD3758BF83FE24AC312445F9B51AD3D8FCE2A0CD57754F6E4&lat=40.099337&lng=116.379463&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463979347735&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=81a99289-f2ad-4e77-b39c-c899764cbf0a&__skcy=ekzQcZxVLz93KYT7pqaKbPIu%2FGo%3D";


    //影院viewpager
    public static String CinemaVP="http://advert.mobile.meituan.com/api/v3/adverts?cityid=1&category=12&version=6.8.0&new=0&app=movie&clienttp=android&uuid=2C2C0ECD557F366849954BEF88D0017AE8F745F113619A0301F4E4E123A4CD7E&devid=000000000000000&uid=&movieid=&partner=1&apptype=1&smId=&utm_campaign=AmovieBpushC110189035496448D-1&movieBundleVersion=6801&utm_source=hiapk&utm_medium=android&utm_term=6.8.0&utm_content=000000000000000&ci=1&net=255&dModel=Google%20Nexus%204%20-%204.3%20-%20API%2018%20-%20768x1280_1&lat=0.0&lng=0.0&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1466950481658&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=376da951-e975-440d-82b9-f4ac14788679&__skcy=a51B0teaxlLzzW5QEnyfCrcq2S0%3D";

    //影院List
    public static String CinemaList="http://m.maoyan.com/cinemas.json";

    //影院自己定位
    public static String CinemaLocation="http://api.meituan.com/group/v1/city/latlng/40.100609,116.379419?tag=0&__vhost=api.mobile.meituan.com&utm_campaign=AmovieBmovieCD100&movieBundleVersion=6901&utm_source=baidumobile1&utm_medium=android&utm_term=6.9.0&utm_content=869402021153646&ci=1&net=255&dModel=m1%20metal&uuid=28C0DE2C5A3F109C808BE007F1011AE88795D9EFF3B99C9B3601DCF7840739F9&lat=40.100609&lng=116.379419&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1466919887167&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=95ebe12d-34d4-44c7-ac81-84999238cb2d&__skcy=V20eSp4FVyIhwwKjcrFXS%2FPzTZ4%3D";

    //发现-viewpager
    public static String FindVP="http://advert.mobile.meituan.com/api/v3/adverts?cityid=1&category=14&version=6.8.0&new=0&app=movie&clienttp=android&uuid=22C117E01E15F95B04242F2BFCC4575F5F5EA8EDB0193ED973FED7FA7B2829BD&devid=353918059801163&uid=&movieid=&partner=1&apptype=1&smId=&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=goapk&utm_medium=android&utm_term=6.8.0&utm_content=353918059801163&ci=1&net=255&dModel=Nexus%204&lat=40.100654&lng=116.37805&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463655698510&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=d4f1e217-fd38-4cda-8d82-ef52b331a71a&__skcy=PL%2BjGyr5ANh3wbigOteOnFr7PLU%3D";

    //发现RadioButton
    public static String FindRadioButton="http://api.meituan.com/sns/v2/buttons.json?__vhost=api.maoyan.com&utm_campaign=AmovieBmovieC110189035496448D100&movieBundleVersion=6901&utm_source=baidumobile1&utm_medium=android&utm_term=6.9.0&utm_content=869402021153646&ci=1&net=255&dModel=m1%20metal&uuid=28C0DE2C5A3F109C808BE007F1011AE88795D9EFF3B99C9B3601DCF7840739F9&lat=40.099691&lng=116.379849&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1466944454392&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=4d91f230-f3a6-4b30-be47-535f32662bef&__skcy=P%2F3L0aHPYjEixgVGWW3%2BfvZokVg%3D";

    //发现list
    public static String FindList="http://api.meituan.com/sns/v4/feed.json?offset=0&limit=10&timestamp=0&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieC110189035496448D100&movieBundleVersion=6901&utm_source=baidumobile1&utm_medium=android&utm_term=6.9.0&utm_content=869402021153646&ci=1&net=255&dModel=m1%20metal&uuid=28C0DE2C5A3F109C808BE007F1011AE88795D9EFF3B99C9B3601DCF7840739F9&lat=40.099691&lng=116.379849&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1466944454477&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=ce21806c-859d-470d-9e17-f8b39c3cff45&__skcy=QoQpYrnAsakUImzbUn3%2B07PiKKc%3D";
}
