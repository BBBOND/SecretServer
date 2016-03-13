package com.geekmadmen.secret.dao.impl;

import com.geekmadmen.secret.dao.ManagerDaoI;
import com.geekmadmen.secret.model.TManager;
import org.springframework.stereotype.Repository;

/**
 * Created by 东 on 2016/3/12.
 */
@Repository("managerDao")
public class ManagerDaoImpl extends BaseDaoImpl<TManager> implements ManagerDaoI  {
}
