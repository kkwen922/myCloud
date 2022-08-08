package my.cloud.demo.modules.dms.model;

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
 * 設備資訊
 * </p>
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("dms_device")
@ApiModel(value="UmsDevice對象", description="設備資訊")
public class DmsDevice implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "設備編號")
    private String deviceSn;

    @ApiModelProperty(value = "設備名稱")
    private String deviceName;

    @ApiModelProperty(value = "設備類型")
    private Long deviceType;

    @ApiModelProperty(value = "行政縣市")
    private String area;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "經度")
    private Double lat;

    @ApiModelProperty(value = "緯度")
    private Double lng;

    @ApiModelProperty(value = "創建時間")
    private Date createTime;

    @ApiModelProperty(value = "設備狀態 0->停用；1->啟用")
    private Integer status;

    @ApiModelProperty(value = "設備類型名稱")
    private String name;

    @ApiModelProperty(value = "組織代碼")
    private Long orgId;

    @ApiModelProperty(value = "組織編碼")
    private Long orgSn;

    @ApiModelProperty(value = "組織名稱")
    private String orgName;
}
