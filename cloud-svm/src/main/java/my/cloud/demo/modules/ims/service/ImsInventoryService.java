package my.cloud.demo.modules.ims.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import my.cloud.demo.modules.ims.model.ImsInventory;

/**
 * 設備管理Service
 */
public interface ImsInventoryService extends IService<ImsInventory> {

    /**
     * 根據銷售相關欄位，分頁查詢事件資訊
     */
    Page<ImsInventory> list(String keyword, String beginTime, String endTime , Integer pageSize, Integer pageNum);



}
