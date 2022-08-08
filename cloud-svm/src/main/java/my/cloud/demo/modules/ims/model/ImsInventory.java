package my.cloud.demo.modules.ims.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * IOT事件資訊
 * </p>
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ims_inventory")
@ApiModel(value="ImsInventory對象", description="存貨資訊")
public class ImsInventory implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "組織編號")
    private Long orgId;

    @ApiModelProperty(value = "組織代碼")
    private String orgSn;

    @ApiModelProperty(value = "組織編號")
    private String orgName;

    @ApiModelProperty(value = "設備編碼")
    private Long deviceId;

    @ApiModelProperty(value = "設備代碼")
    private String deviceSn;

    @ApiModelProperty(value = "設備名稱")
    private String deviceName;

    @ApiModelProperty(value = "產品名稱")
    private String product;

    @ApiModelProperty(value = "主櫃/副櫃")
    private String cargo;

    @ApiModelProperty(value = "層")
    private String container;

    @ApiModelProperty(value = "總量")
    private Integer full;

    @ApiModelProperty(value = "售出")
    private Integer sales;

    @ApiModelProperty(value = "存量")
    private Integer inventory;

    @ApiModelProperty(value = "過期時間")
    private Date expiryTime;

    @ApiModelProperty(value = "創建時間")
    private Date createTime;

}
