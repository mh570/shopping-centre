package com.fengling.shopping.elasticsearch.service;

import com.fengling.shopping.elasticsearch.vo.SearchParam;
import com.fengling.shopping.elasticsearch.vo.SearchResult;

public interface MySearchService {
    SearchResult getListHtml(SearchParam searchParam);
}
