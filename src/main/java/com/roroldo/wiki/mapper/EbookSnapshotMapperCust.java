package com.roroldo.wiki.mapper;


import com.roroldo.wiki.resp.StatisticResp;

import java.util.List;

public interface EbookSnapshotMapperCust {

    void genSnapshot();

    List<StatisticResp> getStatistic();

    List<StatisticResp> get30Statistic();
}
