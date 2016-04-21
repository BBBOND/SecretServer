package com.geekmadmen.secret.dao.impl;

import com.geekmadmen.secret.dao.MoodDaoI;
import com.geekmadmen.secret.model.TMood;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 东 on 2016/4/6.
 */
@Repository("moodDao")
public class MoodDaoImpl extends BaseDaoImpl<TMood> implements MoodDaoI {
    @Override
    public List findInSql(String sql) {
        SQLQuery query = getCurrentSession().createSQLQuery(sql);
        List list = query.list();
       /* for (int i = 0; i < list.size(); i++) {
            Object[] o = (Object[]) list.get(i);
            for (int j = 0; j < o.length; j++) {
                System.out.print(o[j].toString() + "  ");
            }
            System.out.println("\n----");
        }*/
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }


}
