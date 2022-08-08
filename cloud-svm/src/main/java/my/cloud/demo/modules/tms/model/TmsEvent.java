package my.cloud.demo.modules.tms.model;

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
 * 交通事件資訊
 * </p>
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tms_event")
@ApiModel(value="TmsEvent對象", description="交通事件資訊")
public class TmsEvent implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "組織編號")
    private Long orgId;

    @ApiModelProperty(value = "組織代碼")
    private String orgSn;

    @ApiModelProperty(value = "組織編號")
    private String orgName;

    @ApiModelProperty(value = "設備代碼")
    private String deviceSn;

    @ApiModelProperty(value = "設備名稱")
    private String deviceName;

    @ApiModelProperty(value = "事件編號")
    private String eventId;

    @ApiModelProperty(value = "事件類別")
    private Long eventType;

    @ApiModelProperty(value = "事件類別名稱")
    private String eventName;

    @ApiModelProperty(value = "物件編號")
    private Long ObjectId;

    @ApiModelProperty(value = "事件起始時間")
    private Date eventStartTime;

    @ApiModelProperty(value = "事件結束時間")
    private Date eventEndTime;

    @ApiModelProperty(value = "通過所花時間")
    private Long moveTime;

    @ApiModelProperty(value = "區域編碼")
    private Long regionId;

    @ApiModelProperty(value = "區域名稱")
    private String regionName;

    @ApiModelProperty(value = "車輛類型編號")
    private Integer vehicleId;

    @ApiModelProperty(value = "車輛名稱")
    private String vehicleName;

    @ApiModelProperty(value = "創建時間")
    private Date createTime;

}
