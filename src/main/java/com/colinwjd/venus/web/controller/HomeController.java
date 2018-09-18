package com.colinwjd.venus.web.controller;

import java.util.List;

import com.colinwjd.venus.common.GlobalProperty;
import com.colinwjd.venus.common.enums.OptionEnum;
import com.colinwjd.venus.common.enums.PostStatusEnum;
import com.colinwjd.venus.common.enums.PostTypeEnum;
import com.colinwjd.venus.model.entity.Post;
import com.colinwjd.venus.model.vo.PostVO;
import com.colinwjd.venus.service.PostService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 主页控制器
 *
 * @author Colin Wang
 * @date 2018/9/16
 */
@Controller
public class HomeController extends AbstractController {

    private final PostService postService;

    @Autowired
    public HomeController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        return this.index(model, 1);
    }

    @GetMapping("/page/{page}")
    public String index(Model model, @PathVariable Integer page) {
        Integer size = GlobalProperty.DEFAULT_INDEX_POST_NUM;
        if (StringUtils.isNotBlank(GlobalProperty.OPTIONS.get(OptionEnum.INDEX_POST_NUM.getValue()))) {
            size = Integer.parseInt(GlobalProperty.OPTIONS.get(OptionEnum.INDEX_POST_NUM.getValue()));
        }
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.DESC, "createTime"));
        Page<Post> posts = postService.findByTypeAndStatus(PostTypeEnum.POST.getValue(),
            PostStatusEnum.PUBLISHED.getValue(), pageable);
        List<PostVO> result = PostVO.buildWith(posts);
        model.addAttribute("is_index", true);
        model.addAttribute("posts", result);
        // TODO 添加分页彩虹
        return this.render("index");
    }

    @GetMapping("/search/{keyword}")
    public String search(Model model, @PathVariable String keyword) {
        List<PostVO> posts = PostVO.buildWith(postService.search(keyword));
        model.addAttribute("posts", posts);
        return this.render("index");
    }
}
