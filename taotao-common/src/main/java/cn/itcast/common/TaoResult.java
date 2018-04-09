package cn.itcast.common;

import java.io.Serializable;
import java.util.List;

public class TaoResult<T> implements Serializable {
    public Long total;
    public List<T> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
