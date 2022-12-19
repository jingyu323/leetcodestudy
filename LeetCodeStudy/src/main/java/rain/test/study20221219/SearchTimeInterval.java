package rain.test.study20221219;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 之前是挨个搜 开始时间 和结束时间  添加interval 挨个去搜索看文件落在那个时间创建区间，然后确定文件的落地时间为区间的结束时间
 * <p>
 * <p>
 * 现在改为简单计算：计算文件创建时间和开始时间中间的差值，整除interval 之后 说明经过mid个区间之后文件创建时间刚好落在这个区间因此修改，因此文件落地时间区间结束时间
 */
public class SearchTimeInterval {

    public static void main(String[] args) throws ParseException {

        Date startTime = DateUtils.parseStrToDate(DateUtils.YYYY_MM_DD_HH_MM_SS, "2022-12-15 07:01:01");
        Date endTme = DateUtils.parseStrToDate(DateUtils.YYYY_MM_DD_HH_MM_SS, "2022-12-17 07:01:01");

        System.out.println(DateUtils.compareDateIntRes(startTime, startTime));
        System.out.println(DateUtils.compareDate(startTime, startTime));

        System.out.println(startTime);
        System.out.println(endTme);
        List<Records> records = new ArrayList<>();

        Records rr = new Records();

        rr.setFileCreateTime(DateUtils.parseStrToDate(DateUtils.YYYY_MM_DD_HH_MM_SS, "2022-12-15 07:01:01"));
        records.add(rr);
        if (records != null && records.size() > 0) {

            // 计算时间差
            int fileCreateInterval = 15;
            for (Records file : records) {
                Date fileCreateTime = file.getFileCreateTime();
                System.out.println(fileCreateTime);
                int diffMin = DateUtils.calMinus(startTime, fileCreateTime);
                System.out.println(diffMin);
                int mid = diffMin / fileCreateInterval + 1;
                System.out.println(mid);
                Date nextTime = DateUtils.dateAdd(startTime, DateUtils.MIN_TYPE, fileCreateInterval * mid);
                if (!DateUtils.compareDate(nextTime, endTme)) {
                    nextTime = endTme;
                }
                if (mid == 1) {
                    nextTime = fileCreateTime;
                }
                System.out.println(nextTime);
                Records r = new Records();
                r.setEnd(nextTime);

            }
        }


    }
}
