package com.yxd.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yxd.reggie.entity.Category;

public interface CategoryService extends IService<Category> {
    void remove(Long id);
}
