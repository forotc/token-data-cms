package com.ailu.tokenmedia.manage.obtain.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author liu zhenming
 * @version V1.0
 * @date 2018/1/17
 */
public interface WechatDao {

    void updataByWechatid(@Param("wechatid") String wechatid, @Param("bizName") String bizName,
                          @Param("head") String head,@Param("bizDes") String bizDesc
    );

}
