package com.Spring_Study.mybatis.mapper;

import com.Spring_Study.mybatis.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wl
 * @ClassNameStudentMapper
 * @Description TODO
 * @Date 2020/3/31
 * @Version 1.0
 */
@Transactional(rollbackFor = Exception.class)
public interface StudentMapper {
    /**
     * 新增student
     * @param student
     */
    void insert(Student student);

    /**
     * 根据id删除学生
     * @param id
     */
    void delete(Integer id);

    /**
     * 修改学生资料
     * @param student
     */
    void update(Student student);

    /**
     * 批量插入
     * @param students
     * @return int
     */
    int batchInsert(@Param("students")List<Student>students);

    /**
     * 批量删除
     * @param idList
     * @return
     */
    int batchDelete(@Param("idList")List<Integer>idList);

    /**
     * 批量改
     * @param students
     * @return
     */
    int batchUpdate(@Param("students")List<Student>students);

    /**
     * 单表带两个指定查询条件
     * @return
     */
    List<Student>selectLimit();

    /**
     * 单表指定条件查询（结合动态sql)
     * @param student
     * @return
     */
    List<Student>selectLimitByDynamicSql(Student student);

    List<Student> selectAll();
}
