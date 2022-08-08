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
@TableName("ims_event")
@ApiModel(value="ImsEvent對象", description="智販機事件資訊")
public class ImsEvent implements Serializable {

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

    @ApiModelProperty(value = "事件編號")
    private Long eventId;

    @ApiModelProperty(value = "事件類別")
    private String eventType;

    @ApiModelProperty(value = "主櫃溫度")
    private Long mainTemp;

    @ApiModelProperty(value = "副櫃溫度")
    private String additionalTemp;

    @ApiModelProperty(value = "產品名稱")
    private String product;

    @ApiModelProperty(value = "到期時間")
    private Date expiryTime;

    @ApiModelProperty(value = "事件時間")
    private Date eventTime;

}
