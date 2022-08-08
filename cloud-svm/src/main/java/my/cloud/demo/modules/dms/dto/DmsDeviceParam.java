package my.cloud.demo.modules.dms.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * 新增設備參數
 */
@Getter
@Setter
public class DmsDeviceParam {

    @NotEmpty
    @ApiModelProperty(value = "設備編號", required = true)
    private String deviceSn;

    @NotEmpty
    @ApiModelProperty(value = "設備名稱",required = true)
    private String deviceName;

    @ApiModelProperty(value = "設備類型代碼",required = true)
    private Long deviceType;

    @ApiModelProperty(value = "設備類型",required = true)
    private String name;

    @ApiModelProperty(value = "行政縣市",required = true)
    private String area;

    @ApiModelProperty(value = "地址",required = true)
    private String address;

    @ApiModelProperty(value = "經度")
    private Double lat;

    @ApiModelProperty(value = "緯度")
    private Double lng;

    @ApiModelProperty(value = "組織代碼")
    private Long orgId;

    @ApiModelProperty(value = "組織編碼")
    private Long orgSn;

    @ApiModelProperty(value = "組織名稱")
    private String orgName;


}
