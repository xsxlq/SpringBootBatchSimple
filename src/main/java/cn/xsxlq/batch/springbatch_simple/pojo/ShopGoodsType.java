package cn.xsxlq.batch.springbatch_simple.pojo;

import lombok.Data;

/**
 * 商品类型表
 */
@Data
public class ShopGoodsType {
    private Integer goodsTypeId;

    private String goodsTypeName;

    private Integer parentId;

    @Override
    public String toString() {
        return "ShopGoodsType{" +
                "goodsTypeId=" + goodsTypeId +
                ", goodsTypeName='" + goodsTypeName + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}