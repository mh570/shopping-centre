package com.fengling.shopping.elasticsearch.controller;

import com.fengling.shopping.elasticsearch.service.MySearchService;
import com.fengling.shopping.elasticsearch.vo.SearchParam;
import com.fengling.shopping.elasticsearch.vo.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {

    @Autowired
    private MySearchService mySearchService;

    @GetMapping("/list.html")
    public String listPage(SearchParam searchParam) {
        SearchResult searchResult = mySearchService.getListHtml(searchParam);
        return "list";
    }
}
