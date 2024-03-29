package com.speily.server.search.page;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: SPL
 * @Date: 2019-07-16 11:51
 * @Description: -分页
 */
public class Page<T> extends SimplePage implements Pagination, Serializable {

    public Page() {
    }

    public Page(int pageNo, int pageSize, int totalCount) {
        super(pageNo, pageSize, totalCount);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public Page(int pageNo, int pageSize, int totalCount, List list) {
        super(pageNo, pageSize, totalCount);
        this.list = list;
    }

    public int getFirstResult() {
        return (pageNo - 1) * pageSize;
    }

    /**
     * 当前页的数据
     */
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}
