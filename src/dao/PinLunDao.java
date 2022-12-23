package dao;


import bean.PinLun;

import java.util.List;

public interface PinLunDao {
    List<PinLun> selectPinLun(String id);

    int addPinLun(PinLun pinlun);

    int delete(String id);
}

