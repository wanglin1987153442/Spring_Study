package com.Spring_Study.mybatis.mapper;


import com.Spring_Study.mybatis.entity.Course;

public interface CourseMapper {
    /**
     * 根据班课id查询班课详情(班课自身信息、学生列表)
     * @param courseId
     * @return
     */
    Course getCourseById(int courseId);
}
