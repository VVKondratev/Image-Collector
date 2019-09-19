package collect.image.controller;

import collect.image.model.Images;
import collect.image.model.Tags;
import collect.image.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TagController {
    private TagService tagService ;

    @Autowired
    public void setImgService(TagService tagService) {
        this.tagService = tagService;
    }

    @RequestMapping(value = "/show_tag", method = RequestMethod.GET)
    public ModelAndView allTags() {
        List<Tags> tags = tagService.allTags();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tags");
        modelAndView.addObject("tagsList", tags);
        return modelAndView;
    }

    @RequestMapping(value = "/edit_tag", method = RequestMethod.GET)
    public ModelAndView editTag() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editTag");
        return modelAndView;
    }

    @RequestMapping(value = "/add_tag", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editTag");
        return modelAndView;
    }

    @RequestMapping(value = "/edit_tag/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        Tags tag = tagService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editTag");
        modelAndView.addObject("tag", tag);
        modelAndView.addObject("tag", tagService.getById(id));
        return modelAndView;
    }


    @RequestMapping(value = "/add_tag", method = RequestMethod.POST)
    public ModelAndView addTag(@ModelAttribute("tag") Tags tag) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        tagService.add(tag);
        return modelAndView;
    }

    @RequestMapping(value="/delete_tag/{id}", method = RequestMethod.GET)
    public ModelAndView deleteTag(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Tags tag = tagService.getById(id);
        tagService.delete(tag);
        return modelAndView;
    }

    @RequestMapping(value="/assignedImages/{id}", method = RequestMethod.GET)
    public ModelAndView assignedTags(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        List<Images> imgs = tagService.getImagesById(id);
        modelAndView.setViewName("imgs");
        modelAndView.addObject("imgsList", imgs);
        return modelAndView;
    }
}
