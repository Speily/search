package com.speily.server.search.page;

/**
 * @Auther: SPL
 * @Date: 2019-07-16 11:51
 * @Description: -分页 接口定义
 */
interface Pagination {
    /**
     * 总记录数
     *
     * @return
     */
    int getTotalCount();

    /**
     * 总页数
     *
     * @return
     */
    int getTotalPage();

    /**
     * 每页记录数
     *
     * @return
     */
    int getPageSize();

    /**
     * 当前页号
     *
     * @return
     */
    int getPageNo();

    /**
     * 是否第一页
     *
     * @return
     */
    boolean isFirstPage();

    /**
     * 是否最后一页
     *
     * @return
     */
    boolean isLastPage();

    /**
     * 返回下页的页号
     */
    int getNextPage();

    /**
     * 返回上页的页号
     */
    int getPrePage();
}
