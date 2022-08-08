package my.cloud.demo.modules.dms.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import my.cloud.demo.common.api.CommonPage;
import my.cloud.demo.common.api.CommonResult;
import my.cloud.demo.modules.dms.dto.DmsDeviceParam;
import my.cloud.demo.modules.dms.model.DmsDevice;
import my.cloud.demo.modules.dms.model.DmsDeviceCategory;
import my.cloud.demo.modules.dms.service.DmsDeviceCategoryService;
import my.cloud.demo.modules.dms.service.DmsDeviceService;
import my.cloud.demo.modules.oms.model.OmsOrganization;
import my.cloud.demo.modules.oms.service.OmsOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 設備管理
 */
@Controller
@Api(tags = "DmsDeviceController", description = "設備管理")
@RequestMapping("/device")
@Slf4j
public class DmsDeviceController {

    @Autowired
    private DmsDeviceService deviceService;

    @Autowired
    private DmsDeviceCategoryService deviceCateService;

    @Autowired
    private OmsOrganizationService omsOrganizationService;

    @ApiOperation(value = "新增設備")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<DmsDevice> register(@Validated @RequestBody DmsDeviceParam dmsDeviceParam) {


        //取得設備類型
        log.info("dmsDeviceParam.getDeviceType():{}",dmsDeviceParam.getDeviceType());

        DmsDeviceCategory dmsDeviceCategory = new DmsDeviceCategory();
        dmsDeviceCategory = deviceCateService.getCateInfoById(dmsDeviceParam.getDeviceType());

        log.info("dmsDeviceCategory:{}",dmsDeviceCategory.getName());
        dmsDeviceParam.setName(dmsDeviceCategory.getName());

        //取得組織關聯
        log.info("device info:{}",dmsDeviceParam.getOrgId());
        OmsOrganization omsOrganization = new OmsOrganization();
        omsOrganization =omsOrganizationService.getById(dmsDeviceParam.getOrgId());

        log.info("omsOrganization info: {},{}" , omsOrganization.getNameSn(),omsOrganization.getName());
        dmsDeviceParam.setOrgSn(omsOrganization.getNameSn());
        dmsDeviceParam.setOrgName(omsOrganization.getName());

        DmsDevice dmsDevice = deviceService.create(dmsDeviceParam);

        if (dmsDevice == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(dmsDevice);
    }


    @ApiOperation("獲取設備編號或設備名稱相關資訊之分頁列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<DmsDevice>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        log.info("pageSize:{}",pageSize);

        Page<DmsDevice> deviceList = deviceService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(deviceList));
    }

    @ApiOperation("取得特定單一設備資訊")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<DmsDevice> getItem(@PathVariable Long id) {
        log.info("deviceService.getById: {}",id);
        DmsDevice device = deviceService.getById(id);
        return CommonResult.success(device);
    }

    @ApiOperation("修改指定之設備資訊")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody DmsDevice device) {

        //關聯到DeviceCate
        log.info("device info:{}",device.getDeviceType());
        DmsDeviceCategory dmsDeviceCategory = new DmsDeviceCategory();
        dmsDeviceCategory = deviceCateService.getCateInfoById(device.getDeviceType());

        log.info("dmsDeviceCategory:{}",dmsDeviceCategory.getName());
        device.setName(dmsDeviceCategory.getName());

        //關聯到Organization
        log.info("device info:{}",device.getOrgId());
        OmsOrganization omsOrganization = new OmsOrganization();
        omsOrganization =omsOrganizationService.getById(device.getOrgId());

        log.info("omsOrganization info: {},{}" , omsOrganization.getNameSn(),omsOrganization.getName());
        device.setOrgSn(omsOrganization.getNameSn());
        device.setOrgName(omsOrganization.getName());

        //更新設備資訊

        boolean success = deviceService.update(id, device);

        if (success) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }


    @ApiOperation("删除指定之設備")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        boolean success = deviceService.delete(id);
        if (success) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改設備狀態")
    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateStatus(@PathVariable Long id, @RequestParam(value = "status") Integer status) {
        DmsDevice dmsDevice = new DmsDevice();
        dmsDevice.setStatus(status);
        boolean success = deviceService.update(id, dmsDevice);
        if (success) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

}
