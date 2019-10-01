package cn.xsxlq.batch.springbatch_simple.pojo;

import lombok.Data;

/**
 * 商品类型表
 */
@Data
public class ShopGoodsType {
    private Integer goodstypeid;

    private String goodstypename;

    private Integer parentid;
}