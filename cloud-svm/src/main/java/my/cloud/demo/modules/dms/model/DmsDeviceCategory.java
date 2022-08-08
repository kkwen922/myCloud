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
 * 設備分類
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("dms_device_category")
@ApiModel(value="DmsDeviceCategory對象", description="設備分類")
public class DmsDeviceCategory implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "創建時間")
    private Date createTime;

    @ApiModelProperty(value = "分類名稱")
    private String name;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "備註")
    private String note;

}
