package cn.com.llt;

import cn.com.llt.constant.CharConstant;
import cn.com.llt.constant.IntegerConstant;
import cn.com.llt.constant.StringConstant;
import cn.com.llt.domain.TreasureChest;
import cn.com.llt.utils.HashValueUtils;


public class FindNumber {
    //利用双层for循环实现十个箱依次打开，并将打开时上一个的hash值赋值给下一个宝箱
    public static void main(String[] args) {
        String lastHash = StringConstant.ZERO_STR;
        String hash = StringConstant.BLACK_STR;
        //当前时间戳
        long current = System.currentTimeMillis();
        for (int i = IntegerConstant.ONE_INT; i <= IntegerConstant.TEN_INT; i++) {
            TreasureChest treasureChest = TreasureChest.builder()
                    .lastHash(lastHash)
                    .seq(i)
                    .timeStamp(current).build();
//            依次打开十个宝箱
            for (int j = IntegerConstant.ONE_INT; ; j++) {
                treasureChest.setMysteriousNumber(j);
//              hash = HashValueUtils.getHashValueHaveTimeStamp(treasureChest);
                hash = HashValueUtils.getHashValueNoTimeStamp(treasureChest);
                if (checkNumberIsMysteriousNumber(hash)) {
                    System.out.println("第"+i+"个宝箱的神秘数字为："+j+" hash值为："+hash);
                    lastHash = hash;
                    break;
                }
            }
        }
    }

    /**
     * 计算当前值是否为神秘值
     * 因为前五位为0，所以转为16进制后应该为07-00开头的几位数。
     *
     * @param hashValue
     * @return
     */
    private static boolean checkNumberIsMysteriousNumber(String hashValue) {
        char secChar = hashValue.charAt(IntegerConstant.ONE_INT);
        //不是0开头的不符合
        if (!hashValue.startsWith(StringConstant.ZERO_STR)) {
            return false;
        }
        //可用apache.lang3.StringUtils.isNumeric 判断  因为这里没有引入所以利用ascII码进行判断
        if(secChar< CharConstant.ZERO_CHAR ||secChar>CharConstant.NINE_CHAR){
            return false;
        }
        //第二位大于7的不符合
        String secStr = hashValue.substring(IntegerConstant.ONE_INT, IntegerConstant.TWO_INT);
        if (Integer.parseInt(secStr) > IntegerConstant.SEVEN_INT) {
            return false;
        }
        return true;
    }
}
