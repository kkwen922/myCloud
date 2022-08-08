package my.cloud.demo.modules.dms.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import my.cloud.demo.modules.dms.model.DmsDeviceCategory;

import java.util.List;

/**
 * 設備分類管理Service
 */
public interface DmsDeviceCategoryService extends IService<DmsDeviceCategory> {

    /**
     * 獲得所有資源分類
     */
    List<DmsDeviceCategory> listAll();

    /**
     * 創建資源分類
     */
    boolean create(DmsDeviceCategory dmsDeviceCategory);

    /**
     * 根據設備類型或備註，分頁查詢設備分類資訊
     */
    Page<DmsDeviceCategory> list(String keyword, Integer pageSize, Integer pageNum);

    DmsDeviceCategory getCateInfoById(Long deviceType);


}
