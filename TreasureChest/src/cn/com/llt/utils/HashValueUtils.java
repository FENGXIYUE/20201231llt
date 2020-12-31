package cn.com.llt.utils;

import cn.com.llt.domain.TreasureChest;

public class HashValueUtils {
    /**
     * 计算包厢的hashValue
     * 包含时间戳
     * @param treasureChest
     * @return
     */
    public static String getHashValueHaveTimeStamp(TreasureChest treasureChest) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(treasureChest.getSeq())
                .append(treasureChest.getTimeStamp())
                .append(treasureChest.getLastHash())
                .append(treasureChest.getMysteriousNumber());
        String result = stringBuffer.toString();
        return Sha256Util.getSHA256StrJava(result);
    }
    /**
     * 计算包厢的hashValue
     * 不包含时间戳
     * @param treasureChest
     * @return
     */
    public static String getHashValueNoTimeStamp(TreasureChest treasureChest) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(treasureChest.getSeq())
                .append(treasureChest.getLastHash())
                .append(treasureChest.getMysteriousNumber());
        String result = stringBuffer.toString();
        return Sha256Util.getSHA256StrJava(result);
    }
}
