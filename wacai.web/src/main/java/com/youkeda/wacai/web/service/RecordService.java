package com.youkeda.wacai.web.service;

import com.youkeda.wacai.web.model.AccountingRecord;

import java.util.List;

public interface RecordService {
    /**
     * 记录数据
     * @param record
     */
    public void record (AccountingRecord record);

    /**
     * 查询数据
     */
    public List<AccountingRecord> query();
}
