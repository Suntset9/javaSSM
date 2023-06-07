package com.song.mybatis.mapper;

import com.song.mybatis.pojo.Brand;
import com.song.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface BrandMapper {
        /**
         * 查询所有
         * @return
         */
        List<Brand>  selectAll();

        /**
         * 根据id查询行数据
         * @param id
         * @return
         */
        Brand selectById(int id);

       //List<Brand> selectByCondition (@Param("staus") int staus, @Param("companyName") String companyNAME,@Param("brandName") String brandName);

        //List<Brand> selectByCondition(Brand brand);

        List<Brand> selectByCondition(Map map);

        /**
         * 多条件动态查询
         * @param map
         * @return
         */
        List<Brand> selectByConditionDynamic(Map map);

        /**
         * 单条件动态查询
         * @param brand
         * @return
         */
        List<Brand> selectByConditionSingle(Brand brand);

        /**
         * 添加数据方法
         * @param brand
         */
        void add(Brand brand);

        /**
         * 主键返回
         * @param brand
         */
        void addKey(Brand brand);

        /*
         * 修改数据方法
         */
        int update(Brand brand);

        /**
         * 根据id删除数据
         * @param id
         */
        void deleteById(int id);

        /**
         * 多行删除方法
         * @param ids 数组参数，存储需要批量删除的id
         */
        void deleteByIds(int[] ids);




}
