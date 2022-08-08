package my.cloud.demo.modules.dms.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import my.cloud.demo.common.api.CommonPage;
import my.cloud.demo.common.api.CommonResult;
import my.cloud.demo.modules.dms.model.DmsDeviceCategory;
import my.cloud.demo.modules.dms.service.DmsDeviceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 設備分類管理Controller
 */
@Controller
@Api(tags = "DmsDeviceCategoryController", description = "設備分類管理")
@RequestMapping("/deviceCategory")
public class DmsDeviceCategoryController {

    @Autowired
    private DmsDeviceCategoryService dmsDeviceCategoryService;

    @ApiOperation("查詢所有設備分類")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<DmsDeviceCategory>> listAll() {
        List<DmsDeviceCategory> deviceCategoryList = dmsDeviceCategoryService.listAll();
        return CommonResult.success(deviceCategoryList);
    }

    @ApiOperation("新增設備分類")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody DmsDeviceCategory dmsDeviceCategory) {
        boolean success = dmsDeviceCategoryService.create(dmsDeviceCategory);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改設備分類")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody DmsDeviceCategory dmsDeviceCategory) {
        dmsDeviceCategory.setId(id);
        boolean success = dmsDeviceCategoryService.updateById(dmsDeviceCategory);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根據ID删除設備分類")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        boolean success = dmsDeviceCategoryService.removeById(id);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }


    @ApiOperation("獲取設備分類或備註之相關資訊分頁列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<DmsDeviceCategory>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<DmsDeviceCategory> deviceCateList = dmsDeviceCategoryService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(deviceCateList));
    }
}
