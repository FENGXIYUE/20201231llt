package cn.com.llt.domain;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TreasureChest {
    /**
     * 宝箱编号
     */
    private int seq;
    /**
     * 时间戳
     */
    private long timeStamp;
    /**
     * hash值
     */
    private String hash;
    /**
     * 上一个宝箱的hash值
     */
    private String lastHash;
    /**
     * 神秘数字
     */
    private Integer mysteriousNumber;
}
