package com.dandan.logAop;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @date：2020/12/4
 * @author：suchao
 */
public class AddressResolutionUtil {

    public static List<Map<String,String>> addressResolution(String address){
        String regex="(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)(?<city>[^市]+自治州|.*?地区|.*?城区|.*?行政单位|.+盟|市辖区|.*?市|.*?县)(?<county>[^县]+县|.+市|.+旗|.+海域|.+岛|.+区|)?(?<town>[^区]+区|.+镇|.+乡)?(?<village>.*)";
        Matcher m=Pattern.compile(regex).matcher(address);
        String province=null,city,county,town=null,village=null;
        List<Map<String,String>> table=new ArrayList<Map<String,String>>();
        Map<String,String> row=null;
        while(m.find()){
            row= new LinkedHashMap<>();
            province=m.group("province");
            row.put("province", province==null?"":province.trim());
            city=m.group("city");
            row.put("city", city==null?"":city.trim());
            county=m.group("county");
            row.put("county", county==null?"":county.trim());
            town=m.group("town");
            row.put("town", town==null?"":town.trim());
            village=m.group("village");
            row.put("village", village==null?"":village.trim());
            table.add(row);
        }
        return table;
    }

    public static void main(String[] args) {
        System.out.println(addressResolution("内蒙古自治区赤峰市巴林右旗大板镇德日苏牧业园区"));
    }

}