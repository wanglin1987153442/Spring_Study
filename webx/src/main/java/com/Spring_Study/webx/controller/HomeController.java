package com.Spring_Study.webx.controller;


import com.Spring_Study.webx.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @author wl
 * @ClassNameHomeController
 * @Description TODO
 * @Date 2020/3/24
 * @Version 1.0
 */
@Controller
public class HomeController {
@GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "hello1111");
        User[] users = {
                new User("1", "王锋", "wangfeng351", "小王", "江苏徐州", "1999.02.23", "双鱼", "14752191369", "1244353765", "1244353765@qq.com", "http://ww1.sinaimg.cn/large/0084EtCNgy1gcd67rpn01j30hs0hsgmi.jpg", "https://github.com/wangfeng351", "编程，听歌，吃，运动", "不能输给自己！！！", "#76f0ed"),
                new User("2", "颜子皓", "yzh888", "小颜", "江苏无锡", "2000.03.06", "双鱼", "19825088733", "3149991705", "3149991705@qq.com", "http://ww1.sinaimg.cn/large/007YO3iLgy1gcd72p3hmxj30i60c90tr.jpg", "https://github.com/yzh888", "音乐，电影，捉蜂王", "要想生活过得去", "#ff0000"),
                new User("3", "刘恋", "ll2313673906", "花无泪", "贵州毕节", "1996.09.15", "天秤", "19850099791", "2313673906", "2313673906@qq.com", "https://student-manage-ll.oss-cn-beijing.aliyuncs.com/img/timg.jpg", "https://github.com/ll2313673906", "吃饭，看电影", "就喜欢你看不惯我，又灭不掉我的样子", "#003A44"),
                new User("4", "席光平", "CodeJasmine", "糖醋排骨", "安徽阜阳", "1999.08.18", "处女", "18851137516", "2816540069", "2816540069@qq.com", "https://dss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1312059974,1893880587&fm=111&gp=0.jpg", "https://github.com/CodeJasmine", "吃，喝，rush B", "没有理所当然的成功，也没有毫无道理的平庸", "#EEE9E9"),
                new User("5", "曹暝桕", "caomingjiu", "asdfghjkl", "江苏无锡", "2000.03.09", "双鱼", "15152231582", "2731964526", "15152231582@163.com", "https://student-manage-ll.oss-cn-beijing.aliyuncs.com/img/timg.jpg", "https://github.com/caomingjiu", "打游戏", "没有理所当然的成功，也没有毫无道理的平庸", "#EEE9E9"
                ),
                new User("6", "陶永新", "taoyongxin", "Tao.", "江苏扬州", "2000.01.01", "摩羯", "17826012341", "1427177855", "tyxu1427177855@126.com", "https://avatars0.githubusercontent.com/u/55398415?s=460&v=4", "https://github.com/taoyongxin", "篮球、追剧", "Kepp Calm and Carry On（保持冷静，继续前行）", "#bdbebd"
                ),
                new User("7", "侯粤嘉", "hyj200091", "无梦相赠", "湖南郴州", "2000.09.01", "处女", "18851853957", "2298090131", " 2298090131@qq.com", "https://avatar-cdn.shimo.im/IZuPjlOpBRUTU7oZ/bluetian.jpg__avatar", "https://github.com/hyj200091", "篮球", "虚度年华", "#ffe699"
                ),
                new User("8", "曾传志", "czzeng-code", "夢想，理應飛翔", "江西赣州", "1999.10.18", "天秤", "18851697603", "599984243", "599984243@qq.com", "https://ae01.alicdn.com/kf/U84c4005a0b274d39901e3b7ca2b37f52p.png", "https://github.com/czzeng-code", "羽毛球，音乐, 电影", "年轻就要醒着拼", "#87CEFA"
                ),
                new User("9", "管江宇", "2501015371", "Faith", "江苏南京", "2000.06.19", "双子", "18851862391", "2501015371", "gjy0619@126.com", "http://img2.imgtn.bdimg.com/it/u=4132984704,2110908246&fm=11&gp=0.jpg", "https://github.com/2501015371", "篮球，健身，游戏", "青春在于拼搏", "#ff0000"
                ),
                new User("10", "韩源", "Macabaka", "玛卡巴卡", "山西忻州", "2000.02.06", "水瓶", "18851860919", "2641013950", "2641013950@qq.com", "https://avatars1.githubusercontent.com/u/51700682?s=60&v=4", "https://github.com/Macabaka", "吃饭、睡觉、打豆豆", "丰碑无语，行胜于言", "#eeeeee"
                ),
                new User("11", "孙文龙", "Kuzma77", "Kuzma", "江苏淮安", "2000.07.09", "巨蟹", "18805167526", "2673327266", "2673327266@qq.com", "https://avatars1.githubusercontent.com/u/55436087?s=60&v=4", "https://github.com/Kuzma77", "篮球，音乐，摄影，电影", "路还很长，天总会亮。", "#CAFF70"
                ),
                new User("12", "赵玉杰", "LibraZYJ", "Libra", "江苏南京", "2000.02.28", "天秤", "18852017973", "1836686674", "1836686674@qq.com", "https://avatars0.githubusercontent.com/u/55378225?s=460&v=4", "https://github.com/LibraZYJ", "吃饭、睡觉、打豆豆", "我就站在你面前，你看我几分像从前！", "#757575"
                ),
                new User("13", "谢晓茜", "xiexiaoqian", " 原味冰淇淋", "重庆开州", "1999.04.30", "金牛", "17783208600", "2320832818", "2320832818@qq.com", "https://avatars1.githubusercontent.com/u/55443431?s=460&v=4", "https://github.com/xiexiaoqian", "乒乓球，电影，户外运动", "Beasty", "#90F7EC"
                ),
                new User("14", "杨晶", "yj846272692", "毛毛", "江苏盐城", "1997.12.29", "摩羯", "18452555712", "846272692", " 846272692@qq.com", "https://avatars3.githubusercontent.com/u/45115317?s=460&v=4", "https://github.com/yj846272692", "骑行、音乐、书法", "一蓑烟雨任平生", "#B0C4DE"),

                new User("15", "杨阳", "RuErJieFei", "杨阳", "江苏南通", "2000.04.28", "金牛", "17625835438", "1294898797", "1294898797@qq.com", "https://s2.ax1x.com/2020/02/29/3sH5vT.jpg", "https://github.com/RuErJieFei", "看电视、看别人的电视", "别太一样", "#bc3639"
                ),
                new User("16", "王林", "wanglin1987153442", "林林", "四川自贡", "1999.01.21", "水瓶", "18094247962", "1987153442", "1987153442@qq.com", "https://p1.pstatp.com/large/pgc-image/1539249812874260d011c57", "https://github.com/wanglin1987153442", "运动，听歌", "就这？就这？就这？就这！", "#bc3639"
                ),
                new User("17", "苏玉溪", "suyuxi1", "苏先森", "广西玉林", "1999.04.12", "白羊座", "13457513856", "2296887348", "2296887348@qq.com", "https://avatars0.githubusercontent.com/u/55439911?s=400&v=4", "https://github.com/suyuxi1", "听歌，看电影", "生活总得风雨交加", "#EEE9E9"
                ),
                new User("18", "赵肖龙", "zhao-rgb", "撒野", "江苏无锡", "2000.4.20", "金牛", "18851860805", "1019916061", "1019916061@qq.com", "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2436369410,2358044874&fm=11&gp=0.jpg", "https://github.com/zhao-rgb", "打球", "撒野啊", "#90F7EC"
                ),
                new User("19", "袁腾飞", "RRapids", "Rapids", " 安徽阜阳", " 1998.07.30", " 狮子座", "18851856989", "798763046", " 798763046@qq.com", "https://avatars0.githubusercontent.com/u/44634313?s=460&v=4", "https://github.com/RRapids", "打球", "若青春只顾疯狂，卑微就越来越近", "#D8E3F3"
                ),
                new User("20", "张浩杰", "GitHub-fly", "寻寻觅", "山西晋城", "1999.05.11", "巨蟹座", "18851999738", "1224178565", "1224178565@qq.com", "https://avatars0.githubusercontent.com/u/55377835?s=400&u=419aec24500e2df96f5df5d8c405bf27bf7a6fd8&v=4", "https://github.com/GitHub-fly", "什么也不懂，什么都不会", "寻寻觅觅，冷冷清清", "#AFEEEE"
                ),
                new User("21", "尚宇驰", "ycshang123", "盏茶浅抿", "江苏徐州", "2000.04.02", "白羊座", "18094246920", "351234359", "351234359@qq.com", "https://avatars3.githubusercontent.com/u/55419799?s=400&u=06400cc24a3dd8b97880a631daad51e37a6792d8&v=4", "https://github.com/ycshang123", "追剧、编程、电影、音乐", "少年抬头，仰望明天。仰望，就有希望。", "#AFEEEE"
                ),
                new User("23", "黄敬理", "huangjingliANBAO", "小黄", "广西灵山", "1999.01.01", "天秤座", "18278743357", "2368046759", "2368046759@qq.com", "https://aadsadas.oss-cn-beijing.aliyuncs.com/img/avatar.jpg", "https://github.com/huangjingliANBAO", "看足球 小视频", "有事情做真好", "#33993B"
                ),
                new User("24", "唐小梁", "1802343117", "XL码的唐", "广西贵港", "1998.07.16", "巨蟹座", "18805167507", "1255965856", "1255965856@qq.com", "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3245007520,4182163415&fm=11&gp=0.jpg", "https://github.com/", "一切的不务正业都是我的爱好", "真常应物，真常得性；常应常静，常清静矣", "#000000"
                ),
                new User("25", "倪涛涛", "1914866205", "事在人为", "江苏徐州", "1999.05.27", "双子座", "18851855106", "1914866205", "1914866205@qq.com", "https://avatars0.githubusercontent.com/u/58495771?s=460&v=4", "https://github.com/1914866205", "学习，跑步，聊天", "事在人为", "#dcdcdc"
                ),
                new User("26", "黄启佳", "CHINAHUANGQIJIA", "小半吻", "广西桂林", "19991117", "天枰座", "19850099797", "1559022933", "1559022933@qq.com", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3550182100,2419420153&fm=26&gp=0.jpg", "https://github.com/CHINAHUANGQIJIA", "音乐，美术，鼓乐，球类运动", "公平", "#dcdcdc"
                ),
                new User("27", "秦健", "Mrqinforce", "N", "江苏苏州", "2000.02.17", "水瓶座", "13739173619", "1293340422", "1293340422@qq.com", "https://pic2.zhimg.com/80/v2-b89c9d9d283288b3060910f1fa258edb_720w.jpg", "https://github.com/Mrqinforce", "打球", "专注", "#D8E3F3"
                ),
                new User("28", "陈蓉琪", "1802343228", "mob", "湖南衡阳", "2001.2.15", "水瓶座", "18851699003", "2631315464", "2631315464@qq.com", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2082891025,152975432&fm=26&gp=0.jpg", "https://github.com/1802343228", " 动漫 游戏 音乐 jk制服", "走出舒适圈", "#000000"
                ),
                new User("30", "郁杰原", "yjyqq123", "枫津栈", "江苏盐城", "2000.01.22", "水瓶座", "15370000688", "2641617428", "2641617428@qq.com", "http://pic1.zhimg.com/50/v2-60957c76fd38d48903276445b27ac714_hd.jpg", "https://github.com/yjyqq123", "吃喝玩乐", "开心每一天", "#dcdcdc"
                ),
                new User("30", "田震", "zhent1106", "Crihero_", "山西吕梁", "1998.11.06", "天蝎座", "19850099292", "1299088269", "zhent1106@163.com", "https://uploader.shimo.im/f/IZuPjlOpBRUTU7oZ.jpg!avatar", "https://github.com/zhent1106", "听歌，阅读，创新", "山川湖泊和我都在看你", "#4574C1"
                ),
                new User("31", "王欢乐", "WHL1998w", "Sunny", "甘肃平凉", "1998.08.07", "处女座", "18805162578", "1162608075", "1162608075@qq.com", "https://upload.jianshu.io/users/upload_avatars/14351850/e3e19f54-57bf-4427-b12a-d7d1d563e20c?imageMogr2/auto-orient/strip|imageView2/1/w/120/h/120", "https://github.com/WHL1998w", "阅读，听歌，追剧", "你就是你，不一样的烟火", "#dcdcdc"
                ),
                new User("32", "王登科", "wangDk199", "For", "山西吕梁", "1997.5.20", "巨蟹座", "18851998839", "1091886414", "1091886414@qq.com", "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3397085165,1835636053&fm=26&gp=0.jpg", "https://github.com/wangDk199", "打球、编程", "忠", "#AFEEEE"
                ),
                new User("33", "郑亮", "ZL521990208", "郑亮", "安徽宿州", "1999.2.8", "水瓶座", "18851697510", "1945256212", "1945256212@qq.com", "https://avatars3.githubusercontent.com/u/55389274?s=460&v=4", "https://github.com/ZL521990208", "听歌、电影", "红红火火过大年", "#87CEEB"
                ),
                new User("34", "郭瑞昌", "48038411", "郭瑞昌", "山西临汾", "1999.04.16", "双子座", "18851853897", "48038411", "48038411@qq.com", "https://avatars0.githubusercontent.com/u/44643400?s=460&v=4", "https://github.com/48038411", "打篮球，编程", "世界这么大最自己喜欢的事", "#8db6ed"
                ),
                new User("35", "杨苏祥", "suxiangyang1", "杨苏祥", "安徽阜阳", "1999.12.21", "射手座", "15178114095", "3597107837", "3597107837@qq.com", "https://avatars3.githubusercontent.com/u/45230662?s=460&v=4", "https://github.com/suxiangyang1", "听歌 看足球", "无奈无名氏", "#00B19D"
                ),
                new User("36", "王庆媛", "Wang-qing-yuan", "啦", "贵州贵阳", "2000.9.7", "处女座", "18851861839", "1950016253", " 1950016253@qq.com", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS4GOLrJQhyxNivTABKcy6JWfuOjXNFvjtj67BOaGJzPoCXaiyt", "https://github.com/Wang-qing-yuan", "电影，听歌", "事在人为", "rgb(255,174,189)"
                ),
                new User("37", "吴家浩", "Baby20000816", "Re", "江苏苏州", "2000.8.16", "狮子座", "18851697931", "1273163614", "1273163614@qq.com", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1666882005,4218080920&fm=26&gp=0.jpg", "https://github.com/Baby20000816", "音乐，游戏", "No game no life", "#e3f9fd"
                ),
                new User("38", "陈宇航", "Kchenyuhang", "Archer", "江苏常州", "1999.12.14", "射手座", "18932386185", "1797262364", "1797262364@qq.com", "https://avatar-cdn.shimo.im/TqsbEAzOKIo6ZiUd/sheshouzuo.jpg__avatar", "https://github.com/kchenyuhang", "游戏、音乐、钓鱼、阅读", "No Freedom No Life", "#dc4e41"
                ),
                new User("39", "位哲武", "weizhewu", "隨颩洏萣", "江苏徐州", "2000.06.06", "双子座", "13013947768", "2316860587", "2316860587@qq.com", "https://avatars2.githubusercontent.com/u/43782207?s=460&v=4", "https://github.com/weizhewu", "轻音乐、阅读", "永远不要跟傻瓜吵架，因为别人会分不清到底谁是傻瓜", "#67CCAA"
                ),
                new User("40", "岳凡", "YFuean", "派大星", "江苏常州", "2000.03.23", "白羊座", "16651100323", "1412666584", "1412666584@qq.com", "https://public-cdn-oss.mosoteach.cn/avatar/2018/BD/78ad5f1737d80986b420a23fb07d530c.jpg?v=1551849938&x-oss-process=style/s200x200", "https://github.com/YFuean", "电影、阅读、追剧、乒乓、手游、桌游", "别逼我打野", "#c9e7ff"
                ),
                new User("41", "丁怡凡", "dyf-yifan", "唯一", "山西运城", "2000.10.09", "天蝎座", "18851862081", "510040515", "510040515@qq.com", "http://m.imeitou.com/uploads/allimg/2020022416/xcjlklpqncw-lp.jpeg", "https://github.com/dyf-yifan", "阅读、音乐、电影", "甩掉忧伤找回快乐@", "#FFE4C4")

        };
        List<User> userList = Arrays.asList(users);
        model.addAttribute("userList", userList);
        return "home";
}
}
