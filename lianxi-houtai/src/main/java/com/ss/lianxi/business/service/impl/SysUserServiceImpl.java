package com.ss.lianxi.business.service.impl;

import com.ss.lianxi.business.entity.User;
import com.ss.lianxi.persistence.beans.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ss.lianxi.persistence.mapper.SysUserMapper;
import com.ss.lianxi.business.service.SysUserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService{

    @Autowired
    private SysUserMapper sysUserMapper;


    @Override
    public boolean findUser(String username, String password) {
        SysUser sysUser = sysUserMapper.findByUsernameAndPassword(username, password);
        return sysUser ==null;
    }

    /**
     * 保存一个实体类，null不会被保存，会使用数据库默认值
     * @param user
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    /*当作用于类上时，该类的所有 public 方法将都具有该类型的事务属性，同时，我们也可以在方法级别使用该标注来覆盖类级别的定义。
    在项目中，@Transactional(rollbackFor=Exception.class)，如果类加了这个注解，那么这个类里面的方法抛出异常，就会回滚，数据库里面的数据也会回滚。
    在@Transactional注解中如果不配置rollbackFor属性,那么事物只会在遇到RuntimeException的时候才会回滚,加上rollbackFor=Exception.class,
    可以让事物在遇到非运行时异常时也回滚*/
    public User insert(User user) {
        Assert.notNull(user, "user不可为空！");
        user.setCtime(LocalDateTime.now());
        user.setUtime(LocalDateTime.now());
        sysUserMapper.insert(user.getSysUser());
        return user;
    }

    /**
     * 批量插入，id必须为自增列
     * @param entities
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertList(List<User> entities) {
        Assert.notNull(entities, "entities不可为空！");
        List<SysUser> sysUsers = new ArrayList<>();
        for (User user : entities) {
            user.setCtime(LocalDateTime.now());
            user.setUtime(LocalDateTime.now());
            sysUsers.add(user.getSysUser());
        }
        sysUserMapper.insertList(sysUsers);
    }

    /**
     * 根据主键字段删除
     * @param primaryKey
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeByPrimaryKey(Integer primaryKey) {
        return sysUserMapper.deleteByPrimaryKey(primaryKey) >0;
    }

    /**
     *根据主键更新全部字段，null会被更新
     * @param entity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(User entity) {
        Assert.notNull(entity, "entity不可为空！");
        entity.setUtime(LocalDateTime.now());
        return sysUserMapper.updateByPrimaryKey(entity.getSysUser()) > 0;
    }

    /**
     *根据主键更新不为null的值
     * @param entity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateSelective(User entity) {
        Assert.notNull(entity, "entity不可为空！");
        entity.setUtime(LocalDateTime.now());
        return sysUserMapper.updateByPrimaryKeySelective(entity.getSysUser()) >0;
    }

    /**
     *根据主键进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @param primaryKey
     * @return
     */
    @Override
    public User getByPrimaryKey(Integer primaryKey) {
        Assert.notNull(primaryKey,"PrimaryKey不可为空");
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(primaryKey);
        return null == sysUser ? null : new User(sysUser);
    }

    /**
     *根据实体中的属性进行查询，只能有一个返回值，有多个结果时抛出异常，查询条件使用等号
     * @param entity
     * @return
     */
    @Override
    public User getOneByEntity(User entity) {
        Assert.notNull(entity,"entity不可为空");
        SysUser sysUser = sysUserMapper.selectOne(entity.getSysUser());
        return null == sysUser ? null : new User(sysUser);
    }

    /**
     * 查询全部结果，listByEntity(null)方法能达到同样的效果
     * @return
     */
    @Override
    public List<User> listAll() {
        List<SysUser> sysUsers = sysUserMapper.selectAll();
        return getUsers(sysUsers);
    }

    /**
     *根据实体中的属性值进行查询，查询条件使用等号
     * @param entity
     * @return
     */
    @Override
    public List<User> listByEntity(User entity) {
        Assert.notNull(entity,"entity不可为空");
        List<SysUser> sysUsers = sysUserMapper.select(entity.getSysUser());
        return getUsers(sysUsers);
    }

    private List<User> getUsers(List<SysUser> sysUsers){
        if (CollectionUtils.isEmpty(sysUsers)){
            return null;
        }
        List<User> users =new ArrayList<>();
        for (SysUser sysUser : sysUsers) {
            users.add(new User(sysUser));
        }
        return users;
    }
}
