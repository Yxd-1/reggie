package com.yxd.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yxd.reggie.common.CustomException;
import com.yxd.reggie.entity.Category;
import com.yxd.reggie.entity.Dish;
import com.yxd.reggie.entity.Setmeal;
import com.yxd.reggie.mapper.CategoryMapper;
import com.yxd.reggie.service.CategoryService;
import com.yxd.reggie.service.DishService;
import com.yxd.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;

    /**
     * 根据id删除分类
     * @param id
     */
    @Override
    public void remove(Long id) {

        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, id);
        int count1 = dishService.count(dishLambdaQueryWrapper);
        //查询当前分类是否关联菜品
        if (count1 > 0) {
            //已关联菜品，抛出业务异常
            throw new CustomException("关联了菜品，不能删除");
        }
        //查询当前分类是否关联菜单
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, id);
        int count2 = setmealService.count(setmealLambdaQueryWrapper);
        if (count2 > 0) {
            //已关联套餐，抛出业务异常
            throw new CustomException("关联了套餐，不能删除");
        }
        //删除菜品
        super.removeById(id);
    }
}
