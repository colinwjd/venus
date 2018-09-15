package com.colinwjd.venus.web.controller;

import com.colinwjd.venus.model.entity.Post;
import com.colinwjd.venus.model.vo.GalleryVO;
import com.colinwjd.venus.model.vo.LinkVO;
import com.colinwjd.venus.model.vo.PostVO;
import com.colinwjd.venus.service.GalleryService;
import com.colinwjd.venus.service.LinkService;
import com.colinwjd.venus.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 页面 控制器
 *
 * @author Colin Wang
 * @date 2018/9/15
 */
@Controller
public class PageController extends AbstractController {

    private final PostService postService;
    private final GalleryService galleryService;
    private final LinkService linkService;

    @Autowired
    public PageController(PostService postService, GalleryService galleryService, LinkService linkService) {
        this.postService = postService;
        this.galleryService = galleryService;
        this.linkService = linkService;
    }

    @GetMapping("/gallery")
    public String gallery(Model model) {
        List<GalleryVO> galleries = GalleryVO.buildWith(galleryService.findAll());
        model.addAttribute("galleries", galleries);
        return this.render("gallery");
    }

    @GetMapping("/link")
    public String link(Model model) {
        List<LinkVO> links = LinkVO.buildWith(linkService.findAll());
        model.addAttribute("links", links);
        return this.render("link");
    }

    @GetMapping("/page/{url}")
    public String page(@PathVariable String url, Model model) {
        Post post = postService.findByUrl(url);
        PostVO postVO = PostVO.buildWith(post);
        model.addAttribute("is_page", true);
        model.addAttribute("post", postVO);
        postService.updateVisitCount(post);
        return this.render("page");
    }
}
