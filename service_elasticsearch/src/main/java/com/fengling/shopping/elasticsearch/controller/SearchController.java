package com.fengling.shopping.elasticsearch.controller;

import com.fengling.shopping.elasticsearch.service.MySearchService;
import com.fengling.shopping.elasticsearch.vo.SearchParam;
import com.fengling.shopping.elasticsearch.vo.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SearchController {

    @Autowired
    private MySearchService mySearchService;

    @GetMapping("/list.html")
    public String listPage(SearchParam searchParam, Model model, HttpServletRequest request) {

        String queryString = request.getQueryString();
        searchParam.set_queryString(queryString);

        SearchResult result = mySearchService.getListHtml(searchParam);
        model.addAttribute("result" ,result);
        return "list";
    }
}
