package cn.lgw.learn.mapper;

import cn.lgw.learn.domain.condition.UserCondition;
import cn.lgw.learn.to.resp.GeneralUserTO;

import java.util.List;

public interface MUserMapper {

    List<GeneralUserTO> selectGeneralByExample(UserCondition condition);
}
