package com.yxd.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yxd.reggie.dto.DishDto;
import com.yxd.reggie.entity.Dish;

public interface DishService extends IService<Dish> {

    //新增菜品，同时插入菜品对应的口味
    void saveWithFlavor(DishDto dishDto);

    //根据id查询菜品信息和对应的口味信息
    DishDto getByIdWithFlavor(Long id);

    void updateWithFlavor(DishDto dishDto);
}
