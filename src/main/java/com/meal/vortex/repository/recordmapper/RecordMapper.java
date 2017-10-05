package com.meal.vortex.repository.recordmapper;

import com.meal.vortex.repository.beans.RecordBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RecordMapper {
    public int insertRecord(RecordBean recordBean) throws Exception;

    public int updateRecord(RecordBean recordBean) throws Exception;

    public int deleteRecord(int record_id) throws Exception;

    public RecordBean selectRecordById(int record_id) throws Exception;

    public List<RecordBean> selectAllRecord() throws Exception;
}
