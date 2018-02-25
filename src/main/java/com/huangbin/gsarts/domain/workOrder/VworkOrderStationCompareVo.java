package com.huangbin.gsarts.domain.workOrder;

import com.huangbin.gsarts.object.statistics.ValueObject;
import lombok.Data;

import java.util.List;

/**
 * Created by HUANGBIN on 2017/5/13.
 * 工单数量按照线统计
 */

@Data
public class VworkOrderStationCompareVo {
    private String id;
    private String name;
    private List<ValueObject> data;
}
