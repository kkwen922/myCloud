package my.cloud.backend.modules.ums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import my.cloud.backend.modules.ums.model.UmsRole;
import my.cloud.backend.modules.ums.model.UmsRoleResourceRelation;

import java.util.List;

/**
 * <p>
 * 後台角色資源關聯 Mapper 接口
 * </p>

 */
public interface UmsRoleResourceRelationMapper extends BaseMapper<UmsRoleResourceRelation> {

    List<UmsRoleResourceRelation> getRoleResourceListAll();
}
