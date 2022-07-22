package com.yxd.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yxd.reggie.dto.SetmealDto;
import com.yxd.reggie.entity.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {
    //新增套餐，同时保存套餐和菜品的关联关系
    void saveWithDish(SetmealDto setmealDto);

    //删除套餐，同时删除套餐和菜品的关联数据
    void removeWithDish(List<Long> ids);
}
