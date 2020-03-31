package com.Spring_Study.mybatis.mapper;

import com.Spring_Study.mybatis.domain.ClazzVo;

import com.Spring_Study.mybatis.domain.MatterDto;
import com.Spring_Study.mybatis.domain.MatterVo;
import com.Spring_Study.mybatis.entity.Clazz;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author wl
 * @ClassNameClazzMapper
 * @Description TODO
 * @Date 2020/3/31
 * @Version 1.0
 */
@Transactional(rollbackFor = Exception.class)
public interface ClazzMapper {
    /**
     * 读取指定班课中所有学生信息
     * @param clazzId
     * @return
     */
    List<ClazzVo> getClazzStudent(int clazzId);

    /**
     * 获取指定班课的所有教师信息
     * @param id
     * @return
     */
    List<Map<String,Object>> getClazzStudent1(int id);

    /**一对一
     * 查询班级名称 老师姓名 学生信息
     * @param matterDto
     * @return
     */
 List<MatterVo>  selectLimitFromTeacherInClassByDynamicSql( MatterDto matterDto);

    /**
     * 根据clazid一对多关联查询本班所有学生
     * @param clazzId
     * @return
     */
 Clazz getClazzOneToMany(int clazzId);
}
