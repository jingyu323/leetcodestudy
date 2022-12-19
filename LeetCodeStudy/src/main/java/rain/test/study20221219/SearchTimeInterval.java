package rain.test.study20221219;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchTimeInterval {

    public static void main(String[] args) throws ParseException {

        Date startTime = DateUtils.parseStrToDate(DateUtils.YYYY_MM_DD_HH_MM_SS, "2022-12-15 07:01:01");
        Date endTme = DateUtils.parseStrToDate(DateUtils.YYYY_MM_DD_HH_MM_SS, "2022-12-17 07:01:01");

        System.out.println(startTime);
        System.out.println(endTme);
        List<Records> records = new ArrayList<>();

        Records rr = new Records();
        records.add(rr);
        rr.setFileCreateTime(DateUtils.parseStrToDate(DateUtils.YYYY_MM_DD_HH_MM_SS, "2022-12-17 07:01:01"));

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
                System.out.println(nextTime);
                Records r = new Records();
                r.setEnd(nextTime);

            }
        }


    }
}
